/**   
* @Title: HbmWfEditor.java 
* @Package com.khidi.manager.hbm.engine.wfobj 
* @Description: TODO(流程引擎核心   ： 流程编辑器) 
* @author 王顺波
* @date 2017年11月23日 下午3:14:24 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.wfobj;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.khidi.manager.hbmwf.engine.dao.OracleUtil;
import com.khidi.manager.hbmwf.engine.dao.WfDao;
import com.khidi.manager.hbmwf.engine.domain.HbmentWf;
import com.khidi.manager.hbmwf.engine.wfutil.HbmXml;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;

/**
 * @author Administrator
 *
 */
// 流程编辑器
public class HbmWfEditor {
	private HbmentWf wf;  // 流程实体
	private Document xd;  // 流程xml文档
	private boolean updateImmediately; // 是否立即更新流程配置
	private WfDao wfDao;  // 流程DAO

	// 构造器 1
	public HbmWfEditor(int wfId, boolean updateImmediately) throws Exception {
		this.updateImmediately = updateImmediately;
		wf = wfDao.GetWf(wfId,true);
		//

		//
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		String wfXml = OracleUtil.GetWfXmlContent(wf.getWfContent());
		xd = builder.parse(wfXml);

	}

	// 根据nodeid获取子节点Node
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

	// 根据nodeid获取对应的xml node
	private Node GetXmlNode(String nodeId) {
		NodeList nodeList0 = xd.getElementsByTagName(HbmwfUtil.WF_NODETAG_START);
		NodeList nodeList1 = xd.getElementsByTagName(HbmwfUtil.WF_NODETAG_CMN);
		NodeList nodeList2 = xd.getElementsByTagName(HbmwfUtil.WF_NODETAG_END);
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

	// 根据属性名获取node的属性值
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

	// API
	// 获取节点设置的接收者信息
	public String GetAbs(String nodeId) {
		Node node = GetXmlNode(nodeId);
		//
		String rtn = GetNodeAttrValue(node, "receiver");

		return rtn;
	}

	// 根据节点ID获取节点名称
	public String GetNodeName(String nodeId) {
		Node node = GetXmlNode(nodeId);
		//
		String rtn = GetNodeAttrValue(node, "name");
		//
		return rtn;
	}

	// 获取起始节点状态
	public String GetStartNodeState() {
		NodeList nodeList0 = xd.getElementsByTagName(HbmwfUtil.WF_NODETAG_START);
		Node startNode = nodeList0.item(0);
		String rtn = GetNodeAttrValue(startNode, "state");
		//
		return rtn;
	}

	// 获取 节点设置的backto 节点
	public String GetBackNode(String nodeId) {
		Node node = GetXmlNode(nodeId);
		String rtn = GetNodeAttrValue(node, "backto");
		//
		return rtn;
	}

	// 给节点创建属性
	private Attr CreateAttribute(Node node, String attributeName, String value) {
		Attr attr = xd.createAttribute(attributeName);
		attr.setValue(value);

		node.getAttributes().setNamedItem(attr);
		//
		return attr;
	}

	// 给节点设置属性
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

	
	// 检查节点是否包含某个属性
	private boolean HaveNodeAttribute(Node node, String attrName) {
		NamedNodeMap attrs = node.getAttributes();
		boolean exists = false;
		for (int j = 0; j < attrs.getLength(); j++) {
			String attrName0 = attrs.item(j).getNodeName();
			if (attrName0.equals(attrName)) {
				return true;
			}
		}
		return false;
	}

	// 设置节点的接收者信息
	public void SetAbs(String nodeId, String absIds, Date dtFlag, String curDeptId, String curUsrId) throws Exception {
		String absIds0 = absIds;
		if (updateImmediately) {
			if (wf.getLastUpdateTime() != dtFlag) {
				throw new Exception("信息已被更改,操作失败,请重新加载数据");
			}
		}

		if (absIds0.endsWith(",")) {
			absIds0 = absIds0.substring(0, absIds0.length() - 1);
		}

		Node node0 = GetXmlNode(nodeId);
		//
		boolean haveAttr = HaveNodeAttribute(node0, "receiver");
		if (haveAttr) {
			SetNodeAttribute(node0, "receiver", absIds);
		} else {
			CreateAttribute(node0, "receiver", absIds);
		}
		//

	}

	// 设置节点的回退节点信息(back to)
	public void SetBackTo(String nodeId, String backNodeId, Date dtFlag, String curDeptId, String curUserId) throws Exception {
		HbmwfDriving wfDriving = new HbmwfDriving();
		wfDriving.InitWf(wf.getId(),null);
		//
		boolean canBack = wfDriving.CanBackTo(nodeId, backNodeId);
		if(!canBack)
		{
			 throw new Exception("非法的操作.");
		}
		//
		if(updateImmediately)
		{
			if(wf.getLastUpdateTime() != dtFlag)
			{
				throw new Exception("信息已被更改,操作失败,请重新加载数据");
			}
		}
		//
		Node node = GetXmlNode(nodeId);
		SetNodeAttribute(node,"backto",backNodeId);
		
		if(updateImmediately)
		{
			String wfContent0 = OracleUtil.Getbase64codeFromDocument(xd);
			wf.setWfContent(wfContent0);
			wf.setLastUpdateDept(curDeptId);
			wf.setLastUpdateTime(new Date());
			wf.setLastUpdateUser(curUserId);
			//
			wfDao.EditWfContent(wf);
		}
	}
	
	
	// 保存流程内容
	public void SaveWfChanges(Date dtFlag, String curDeptId, String curUserId) throws Exception
	{
		if(wf.getLastUpdateTime() != dtFlag)
		{
			throw new Exception("信息已被更改,操作失败,请重新加载数据");
		}
		//
		String wfContent0 = OracleUtil.Getbase64codeFromDocument(xd);
		wf.setWfContent(wfContent0);
		wf.setLastUpdateDept(curDeptId);
		wf.setLastUpdateTime(new Date());
		wf.setLastUpdateUser(curUserId);
		//
		wfDao.EditWfContent(wf);
	}
}
