/**   
* @Title: HbmwfDriving.java 
* @Package com.khidi.manager.hbm.engine.wfobj 
* @Description: TODO(工作流引擎代码(核心1)) 
* @author 王顺波
* @date 2017年11月23日 上午9:43:46 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.wftmplobj;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.khidi.manager.hbmwf.engine.dao.OracleUtil;
import com.khidi.manager.hbmwf.engine.dao.WfDao;
import com.khidi.manager.hbmwf.engine.dao.WfHandleDao;
import com.khidi.manager.hbmwf.engine.dao.WfTmplDao;
import com.khidi.manager.hbmwf.engine.domain.HbmentWf;
import com.khidi.manager.hbmwf.engine.domain.HbmentWfHandle;
import com.khidi.manager.hbmwf.engine.domain.HbmentWftmpl;
import com.khidi.manager.hbmwf.engine.wfobj.HbmwfNode;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.EnumHbmwfNodeLogic;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmEnumwfState;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumNodeState;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumNodeType;
import com.khidi.manager.hbmwf.engine.wfutil.HbmXml;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;

/**
 * @author Administrator
 *
 */
// 流程引擎 核心1
public class HbmwftmplMonitorDriving {
	DocumentBuilderFactory dbf;// = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder;// = dbf.newDocumentBuilder();
	private Document wfContent;
	private HbmwftmplObj wfObj;
	private WfHandleDao handleDao;
	private WfTmplDao wfTmplDao;

	private HbmwftmplObj GetWfObj() {
		return wfObj;
	}

	// 从集合(nodeList)中查找节点(nodeId)
	private Node _GetXmlNode(NodeList nodeList, String nodeId) {
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node lpNode = nodeList.item(i);
			NamedNodeMap attrs = lpNode.getAttributes();
			for (int j = 0; j < attrs.getLength(); j++) {
				String attrName = attrs.item(j).getNodeName();
				String attrValue = attrs.item(j).getNodeValue();
				//
				if (attrName.toLowerCase().equals("id")) {
					if (attrValue.equals(nodeId)) {
						return lpNode;
					}
				}
			}
		}
		//
		return null;
	}

	// 根据节点编号查找节点
	private Node GetXmlNode(String nodeId) {
		NodeList nodeList0 = wfContent.getElementsByTagName(HbmwfUtil.WF_NODETAG_START);
		NodeList nodeList1 = wfContent.getElementsByTagName(HbmwfUtil.WF_NODETAG_CMN);
		NodeList nodeList2 = wfContent.getElementsByTagName(HbmwfUtil.WF_NODETAG_END);
		//
		Node node0 = _GetXmlNode(nodeList0, nodeId);
		if (node0 != null) {
			return node0;
		}
		Node node1 = _GetXmlNode(nodeList1, nodeId);
		if (node1 != null) {
			return node1;
		}
		Node node2 = _GetXmlNode(nodeList2, nodeId);
		if (node2 != null) {
			return node2;
		}
		return null;
	}

	// 节点集合缓存
	private List<HbmwfNode> _TmpWfnodelist = new ArrayList<HbmwfNode>();

	// 获取流程开始节点
	private Node GetStartNode() {
		NodeList nodeList0 = wfContent.getElementsByTagName(HbmwfUtil.WF_NODETAG_START);
		//
		return nodeList0.item(0);
	}

	// 设置流程节点属性 node: 要设置的节点   attrName:属性名    attrValue:属性值
	private void SetNodeAttribute(Node node, String attrName, String attrValue) {
		NamedNodeMap attrs = node.getAttributes();
		for (int j = 0; j < attrs.getLength(); j++) {
			String attrName0 = attrs.item(j).getNodeName();
			String attrValue0 = attrs.item(j).getNodeValue();
			if (attrName0.equals(attrName)) {
				attrs.item(j).setNodeValue(attrValue);
			}
		}
	}

	// set wf node state  设置流程节点状态
	private void SetWfState(HbmentWf wf) throws SQLException {
		List<HbmentWfHandle> wfHandles = handleDao.GetWfCurHandles(wf.getId());
		//
		if (wfHandles == null || wfHandles.size() == 0) {
			return;
		}
		for (HbmentWfHandle lpWfHandle : wfHandles) {
			String nodeStateCode = lpWfHandle.getNodeState();
			String nodeId = lpWfHandle.getNodeId();

			Node node = GetXmlNode(nodeId);
			//
			SetNodeAttribute(node, "state", nodeStateCode);
		}
	}

	// 根据节点编号查找节点
	private HbmwfNode FindNode(String nodeId) {
		for (HbmwfNode lpNode : _TmpWfnodelist) {
			if (lpNode.getNodeId().equals(nodeId)) {
				return lpNode;
			}
		}
		return null;
	}

	// 填充流程数据结构(方法1)
	private HbmwfNode FillNode(String nodeId) {
		Node node = GetXmlNode(nodeId);
		//
		HbmwfNode wfNode = FindNode(nodeId);
		//
		if (wfNode == null) {
			wfNode = ConvertFillNode(node);
			_TmpWfnodelist.add(wfNode);
		}

		return wfNode;
	}

	// 读取流程属性
	private String GetNodeAttrValue(Node node, String attrName) {
		NamedNodeMap attrs = node.getAttributes();
		for (int j = 0; j < attrs.getLength(); j++) {
			String attrName0 = attrs.item(j).getNodeName();
			String attrValue0 = attrs.item(j).getNodeValue();
			//
			if (attrName0.toLowerCase().equals(attrName.toLowerCase())) {
				return attrValue0;
			}
		}
		return null;
	}

	// 填充流程数据结构(方法2)
	private HbmwfNode ConvertFillNode(Node node) {
		HbmwfNode wfNode = new HbmwfNode();
		//
		wfNode.setBackToNode(GetNodeAttrValue(node, "backto"));
		wfNode.setEnumNodeState(
				HbmwfenumNodeState.valueOf(HbmXml.GetNodeAttribute(wfContent, node, "state", true, "NB")));
		// if (node.getNodeName() == HbmwfUtil.WF_NODETAG_CMN) {
		// wfNode.setEnumNodeType(HbmwfenumNodeType.common);
		// }
		switch (node.getNodeName()) {
		case HbmwfUtil.WF_NODETAG_CMN:
			wfNode.setEnumNodeType(HbmwfenumNodeType.common);
			break;
		case HbmwfUtil.WF_NODETAG_END:
			wfNode.setEnumNodeType(HbmwfenumNodeType.end);
			break;
		case HbmwfUtil.WF_NODETAG_START:
			wfNode.setEnumNodeType(HbmwfenumNodeType.start);
			break;
		default:
			break;
		}
		//
		wfNode.setHeight(GetNodeAttrValue(node, "height"));
		wfNode.setNextNodes(GetFillNextnodes(node, GetNodeAttrValue(node, "nxtids")));
		//
		wfNode.setNodeId(GetNodeAttrValue(node, "id"));
		String logicValue = GetNodeAttrValue(node, "prelogic");
		if(logicValue == null || logicValue.equals(""))
		{
			logicValue = "and";
		}
		wfNode.setNodeLogic(EnumHbmwfNodeLogic.valueOf(logicValue));
		wfNode.setNodeName(node.getNodeName());
		wfNode.setReceivers(GetNodeAttrValue(node, "receiver"));
		wfNode.setWidth(GetNodeAttrValue(node, "width"));
		wfNode.setX(GetNodeAttrValue(node, "left"));
		wfNode.setY(GetNodeAttrValue(node, "top"));

		return wfNode;
	}

	// 填充流程数据结构(方法3)
	private List<HbmwfNode> GetFillNextnodes(Node node, String nxtIds) {
		List<HbmwfNode> rtn = new ArrayList<HbmwfNode>();
		//
		if (nxtIds == null || nxtIds.equals("")) {
			return null;
		}
		//
		String[] nxtIdsArr = nxtIds.split(",");
		//
		for (String nxtId : nxtIdsArr) {
			rtn.add(FillNode(nxtId));
		}
		//
		return rtn;
	}

	// 填充流程数据结构(方法4)
	private void FillNode(Node node) {
		if (node == null) {
			return;
		}
		//
		if (_startNode == null) {
			HbmwfNode node0 = FindNode(GetNodeAttrValue(node, "id"));
			if (node0 != null) {
				_startNode = node0;
			} else {
				_startNode = new HbmwfNode();
				_startNode.setBackToNode(GetNodeAttrValue(node, "backto"));
				_startNode.setEnumNodeState(
						HbmwfenumNodeState.valueOf(HbmXml.GetNodeAttribute(wfContent, node, "state", true, "NB")));
				// if (node.getNodeName() == HbmwfUtil.WF_NODETAG_CMN) {
				// wfNode.setEnumNodeType(HbmwfenumNodeType.common);
				// }
				switch (node.getNodeName()) {
				case HbmwfUtil.WF_NODETAG_CMN:
					_startNode.setEnumNodeType(HbmwfenumNodeType.common);
					break;
				case HbmwfUtil.WF_NODETAG_END:
					_startNode.setEnumNodeType(HbmwfenumNodeType.end);
					break;
				case HbmwfUtil.WF_NODETAG_START:
					_startNode.setEnumNodeType(HbmwfenumNodeType.start);
					break;
				default:
					break;
				}
				//
				_startNode.setHeight(GetNodeAttrValue(node, "height"));
				_startNode.setNextNodes(GetFillNextnodes(node, GetNodeAttrValue(node, "nxtids")));
				//
				_startNode.setNodeId(GetNodeAttrValue(node, "id"));
				String lpLogicValue = HbmXml.GetNodeAttribute(wfContent, node, "prelogic", true, "and");
				System.out.println("logic:" + lpLogicValue);
				_startNode.setNodeLogic(
						EnumHbmwfNodeLogic.valueOf(lpLogicValue));
				_startNode.setNodeName(node.getNodeName());
				_startNode.setReceivers(GetNodeAttrValue(node, "receiver"));
				_startNode.setWidth(GetNodeAttrValue(node, "width"));
				_startNode.setX(GetNodeAttrValue(node, "left"));
				_startNode.setY(GetNodeAttrValue(node, "top"));
				//
				_TmpWfnodelist.add(_startNode);
			}
		}
	}

	/*******  wf  update node state  ********/
	// 更新流程节点状态
	private void _UpdateWfNodeState(Document doc, NodeList xnl, List<HbmentWfHandle> wfHandles, int wfId) {
		for (int i = 0; i < xnl.getLength(); i++) {
			Node lpNode = xnl.item(i);
			String lpNodeId = HbmXml.GetNodeAttribute(doc, lpNode, "id", false, "");
			//
			if (lpNodeId.equals("1511316384817")) {
				String abc = "aaa";
			}
			HbmentWfHandle lpWfHandle = __GetWfHandle(wfHandles, lpNodeId);
			//
			//
			if (lpWfHandle != null) {
				HbmXml.SetNodeAttribute(doc, lpNode, "state", lpWfHandle.getNodeState(), true);
			} else {
				HbmXml.SetNodeAttribute(doc, lpNode, "state", HbmwfUtil.WF_NODESTATE_NB, true);
			}
			//
		}
	}
	
	// 更新流程节点状态
	private String UpdateWfNodeState(String wfXml, int wfId)
			throws ParserConfigurationException, SAXException, IOException, SQLException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document dom = builder.parse(new InputSource(new ByteArrayInputStream(wfXml.getBytes("utf-8"))));
		List<HbmentWfHandle> curWfHandles = handleDao.GetWfCurHandles(wfId);
		//
		NodeList xnl0 = dom.getElementsByTagName(HbmwfUtil.WF_NODETAG_START);
		NodeList xnl1 = dom.getElementsByTagName(HbmwfUtil.WF_NODETAG_CMN);
		NodeList xnl2 = dom.getElementsByTagName(HbmwfUtil.WF_NODETAG_END);
		//
		_UpdateWfNodeState(dom, xnl0, curWfHandles, wfId);
		_UpdateWfNodeState(dom, xnl1, curWfHandles, wfId);
		_UpdateWfNodeState(dom, xnl2, curWfHandles, wfId);
		//
		String rtn = HbmXml.GetXmlFromDoc(dom);
		return rtn;
	}

	private HbmentWfHandle __GetWfHandle(List<HbmentWfHandle> wfHandles, String nodeId) {
		for (HbmentWfHandle lpWfHandle : wfHandles) {
			String lpNodeId = lpWfHandle.getNodeId();
			if (nodeId.equals(lpNodeId)) {
				return lpWfHandle;
			}
		}
		return null;
	}
	/*********************************/
	 
	// API
	private HbmwfNode _startNode; // 流程开始节点
	// init wf  初始化流程信息
	public void InitWfTmpl(int wfTmplId) throws Exception {
		//
		wfTmplDao = new WfTmplDao();
		handleDao = new WfHandleDao();
		//
		wfObj = new HbmwftmplObj();
		//
		HbmentWftmpl entWfTmpl = wfTmplDao.GetWftmpl(wfTmplId);
		if (entWfTmpl == null) {
			return;
		}
		//
		String wfXmlContent = OracleUtil.GetWfXmlContent(entWfTmpl.getTheContent());
		dbf = DocumentBuilderFactory.newInstance();
		builder = dbf.newDocumentBuilder();
		
		wfContent = builder.parse(new InputSource(new ByteArrayInputStream(wfXmlContent.getBytes("utf-8"))));
		//
		Node startNode = GetStartNode();
		//
		_startNode = null;
		wfObj.setWftempid(String.valueOf(wfTmplId));
		FillNode(startNode);
		wfObj.setStartnode(_startNode);
		wfObj.MainInitialized();
		wfObj.setTitle(entWfTmpl.getName());
	}

	// wf backto check
	// API: 一个节点是否能设置退回到另一个节点
	public boolean CanBackTo(String sourceNodeId, String aimNodeId) {
		return wfObj.IsCanBebackto(sourceNodeId, aimNodeId);
	}

	// API:节点是否能设置退回(如果流程已经在处理中，根据实际情况考虑不允许设置退回)//TODO:待完善
	public boolean CanCfgBackto(String nodeId) {
		return false;
	}
	
	public List<HbmwfNode> GetPreviousNodes(String nodeId)
	{
		return wfObj.GetPreNodes(nodeId);
	}
}
