/**   
* @Title: WfdrivingService.java 
* @Package com.khidi.manager.hbm.engine.hbmwfservice 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月23日 下午1:21:24 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.enginext.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
import com.khidi.manager.hbmwf.engine.dao.WfFormHandleDao;
import com.khidi.manager.hbmwf.engine.dao.WfHandleDao;
import com.khidi.manager.hbmwf.engine.domain.HbmentWf;
import com.khidi.manager.hbmwf.engine.domain.HbmentWfHandle;
import com.khidi.manager.hbmwf.engine.wfobj.HbmWfEditor;
import com.khidi.manager.hbmwf.engine.wfobj.HbmwfDriving;
import com.khidi.manager.hbmwf.engine.wfobj.HbmwfEventObj;
import com.khidi.manager.hbmwf.engine.wfobj.IhbmwfAdapter;
import com.khidi.manager.hbmwf.engine.wfobj.uiFlow.HbmwfuientWfNode;
import com.khidi.manager.hbmwf.engine.wfutil.HbmXml;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.hbmwf.enginext.cfg.WfCurrentSession;
import com.khidi.manager.hbmwf.enginext.cfg.form.BzDynamicForm;
import com.khidi.manager.hbmwf.enginext.domain.HbmentDynamicForm;
import com.khidi.manager.hbmwf.enginext.domain.HbmentFormHandle;

/**
 * @author Administrator
 *
 */
public class WfdrivingService {

	private String formId;
	private String formType;
	private HbmentDynamicForm curForm;// TODO:
	private int _VeriHandleId;
	private HbmentFormHandle theFormHandle;
	private Document theWf;
	private NodeList xnl0;
	private NodeList xnl1;
	private NodeList xnl2;
	private Node startNode;
	private Node endNode;

	private HbmentWf theWfObj;

	private WfDao wfDao;
	private WfHandleDao wfHandleDao;
	private WfFormHandleDao wfFormHandleDao;

	private Node curNode;
	private HbmentDynamicForm theDynamicForm;// TODO:

	private String curHandleMsg;

	public void InitByWfHandle(int handleId) throws Exception {
		//
		wfDao = new WfDao();
		wfHandleDao = new WfHandleDao();
		wfFormHandleDao = new WfFormHandleDao();
		//
		_VeriHandleId = handleId;
		theFormHandle = wfFormHandleDao.GetFormHandle(handleId);
		this.formId = theFormHandle.getFormId();
		this.formType = theFormHandle.getFormType();
		//
		curForm = BzDynamicForm.GetDynamicForm(formId, formType);
		//
		LoadWf();
	}

	public void InitByFormInfo(String formId, String formType) throws Exception {
		//
		wfDao = new WfDao();
		wfHandleDao = new WfHandleDao();
		wfFormHandleDao = new WfFormHandleDao();
		//
		this.formId = formId;
		this.formType = formType;
		//
		curForm = BzDynamicForm.GetDynamicForm(this.formId, this.formType);
		//
		LoadWf();
		//
	}
	
	public List<HbmwfuientWfNode> GetPreviousNodes(String nodeId)
	{
		List<Node> nodes = GetPreNodes(nodeId);
		//
		List<HbmwfuientWfNode> rtn = new ArrayList<HbmwfuientWfNode>();
		//
		for(Node lpNode : nodes)
		{
			HbmwfuientWfNode lpEntNode = new HbmwfuientWfNode();
			lpEntNode.setId(GetNodeAttrValue(lpNode,"id"));
			lpEntNode.setName(GetNodeAttrValue(lpNode,"name"));
			//
			rtn.add(lpEntNode);
		}
		return rtn;
	}

	private Node GetStartNode() {
		return xnl0.item(0);
	}

	private Node GetEndNode() {
		return xnl2.item(0);
	}

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

	private Node GetXmlNode(NodeList nodeList, String nodeId) {
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node lpNode = nodeList.item(i);
			String lpNodeId = GetNodeAttrValue(lpNode, "id");
			if (lpNodeId.equals(nodeId)) {
				return lpNode;
			}
		}
		return null;
	}

	//
	private Node GetXmlNode(String nodeId) {
		Node node0 = GetXmlNode(xnl0, nodeId);
		if (node0 != null) {
			return node0;
		}
		Node node1 = GetXmlNode(xnl1, nodeId);
		if (node1 != null) {
			return node1;
		}
		Node node2 = GetXmlNode(xnl2, nodeId);
		if (node2 != null) {
			return node2;
		}
		return null;
	}

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

	// set wf node state
	private void SetWfState(Node node, String stateValue) {
		SetNodeAttribute(node, "state", stateValue);
	}

	// set wf all node state
	private void SetWfState() throws SQLException {
		//
		List<HbmentWfHandle> curHandles = wfHandleDao.GetWfCurHandles(theWfObj.getId());
		//
		if (curHandles == null) {
			return;
		}
		//
		for (HbmentWfHandle wfHandle : curHandles) {
			String nodeStateCode = wfHandle.getNodeState();
			String nodeId = wfHandle.getNodeId();
			String nodeStateStr = "";
			//
			// switch (nodeStateCode) {
			// case "DO":
			// break;
			// case "NB":
			// break;
			// case "NPD":
			// break;
			// case "PSD":
			// break;
			// }
			nodeStateStr = nodeStateCode.toLowerCase();
			//
			Node node0 = GetXmlNode(nodeId);
			//
			SetNodeAttribute(node0, "state", nodeStateStr);
		}
	}
	
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
	
	private String UpdateWfNodeState(String wfXml, int wfId)
			throws ParserConfigurationException, SAXException, IOException, SQLException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document dom = builder.parse(new InputSource(new ByteArrayInputStream(wfXml.getBytes("utf-8"))));
		List<HbmentWfHandle> curWfHandles = wfHandleDao.GetWfCurHandles(wfId);
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
	public String GetFormId() {
		return formId;
	}

	private void LoadWf() throws Exception {
		theWfObj = wfDao.GetWf(formId, formType,true);
		//
		if (theWf == null) {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			String wfXml = OracleUtil.GetWfXmlContent(theWfObj.getWfContent());
			//
			wfXml = UpdateWfNodeState(wfXml,theWfObj.getId());
			//
			theWf = db.parse(new InputSource(new ByteArrayInputStream(wfXml.getBytes("utf-8"))));
			xnl0 = theWf.getElementsByTagName(HbmwfUtil.WF_NODETAG_START);
			xnl1 = theWf.getElementsByTagName(HbmwfUtil.WF_NODETAG_CMN);
			xnl2 = theWf.getElementsByTagName(HbmwfUtil.WF_NODETAG_END);
			//
			startNode = GetStartNode();
			endNode = GetEndNode();
			//
			if (theFormHandle != null) {
				curNode = GetXmlNode(theFormHandle.getWfNodeId());
			}
			//
			// _UpdateNodeStateCol(); 略，由前端处理
		}
	}

	private List<Node> GetNxtNodes(String nodeId) {
		List<Node> rtn = new ArrayList<Node>();
		Node theNode = GetXmlNode(nodeId);
		//
		String nxtIds = GetNodeAttrValue(theNode, "nxtids");
		if (nxtIds == null || nxtIds.equals("")) {
			return null;
		}
		String[] nxtIdsArr = nxtIds.split(",");
		//
		for (String nxtId : nxtIdsArr) {
			rtn.add(GetXmlNode(nxtId));
		}
		//
		return rtn;
	}

	private List<Node> __getprenodes(NodeList nodeList, String nodeId) {
		List<Node> rtn = new ArrayList<Node>();
		//
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node lpNode = nodeList.item(i);
			String lpNtxIds = GetNodeAttrValue(lpNode, "nxtids");
			if (lpNtxIds == null && lpNtxIds.equals("")) {
				continue;
			}
			String[] lpNtxIdsArr = lpNtxIds.split(",");
			for (String lpNtxId : lpNtxIdsArr) {
				if (lpNtxId.equals(nodeId)) {
					rtn.add(lpNode);
					break;
				}
			}
		}
		return rtn;
	}

	private List<Node> GetPreNodes(String nodeId) {
		List<Node> rtn = new ArrayList<Node>();
		//
		List<Node> nodes0 = __getprenodes(xnl0, nodeId);
		List<Node> nodes1 = __getprenodes(xnl0, nodeId);
		List<Node> nodes2 = __getprenodes(xnl0, nodeId);
		if (nodes0 != null) {
			rtn.addAll(nodes0);
		}
		if (nodes1 != null) {
			rtn.addAll(nodes1);
		}
		if (nodes2 != null) {
			rtn.addAll(nodes2);
		}
		//
		return rtn;
	}

	private List<Node> GetTheLevelNodes(String nodeId) {
		List<Node> preNodes = GetPreNodes(nodeId);
		List<Node> nxtNodes = GetNxtNodes(nodeId);
		List<Node> rtn = new ArrayList<Node>();
		//
		for (Node lpNode : preNodes) {
			List<Node> lpNxtNodes = GetNxtNodes(GetNodeAttrValue(lpNode, "id"));
			//
			rtn.addAll(lpNxtNodes);
		}
		//
		return rtn;
	}

	// 未使用
	// private void SetWfBindInfo(int wfId,String nodeId,String nodeStateCode)
	// throws SQLException
	// {
	// List<HbmentWfHandle> wfCurHandles = wfHandleDao.GetWfCurHandles(wfId,
	// nodeId);
	// //
	// if(wfCurHandles == null)
	// {
	//
	// }
	// else
	// {
	//
	// }
	// }
	// ...........
	private List<String> GetAbsRecIds(String nodeId) throws Exception {
		HbmWfEditor wfEditor = new HbmWfEditor(theWfObj.getId(), false);
		//
		String absIds = wfEditor.GetAbs(nodeId);
		//
		if (absIds == null || absIds.equals("")) {
			return null;
		}
		String[] absIdsArr = absIds.split(",");
		//
		List<String> rtn = new ArrayList<String>();
		//
		for (String absId : absIdsArr) {
			rtn.add(absId);
		}
		return rtn;
	}

	private String GetAbsRecIdStr(String nodeId) throws Exception {
		HbmWfEditor wfEditor = new HbmWfEditor(theWfObj.getId(), false);
		//
		String absIds = wfEditor.GetAbs(nodeId);
		//
		return absIds;
	}

	private void UpdateWfHandle(String nodeId, String nodeState) throws Exception {
		// HbmentWfHandle
		List<HbmentWfHandle> rtn0 = wfHandleDao.GetWfCurHandles(theWfObj.getId(), nodeId);
		//
		if (rtn0 == null || rtn0.size() == 0) {
			// new handle
			HbmentWfHandle newWfHdl = new HbmentWfHandle();
			newWfHdl.setCreateDept(WfCurrentSession.GetDeptId());
			newWfHdl.setCreateTime(new Date());
			newWfHdl.setCreateUser(WfCurrentSession.GetUserId());
			newWfHdl.setCurrentInd(1);
			newWfHdl.setDelInd(0);
			int newId = HbmwfUtil.NewId("HBMWF_HANDLE");
			newWfHdl.setId(newId);
			newWfHdl.setLastUpdateDept(WfCurrentSession.GetDeptId());
			newWfHdl.setLastUpdateTime(new Date());
			newWfHdl.setLastUpdateUser(WfCurrentSession.GetUserId());
			// newWfHdl.setMemo(memo);
			newWfHdl.setNodeId(nodeId);
			newWfHdl.setNodeState(nodeState);
			newWfHdl.setReceivers(GetAbsRecIdStr(nodeId));
			newWfHdl.setWfId(theWfObj.getId());
			//
			wfHandleDao.NewWfHandle(newWfHdl);
		} else {
			// update state
			HbmentWfHandle wfHandle0 = rtn0.get(0);
			wfHandle0.setNodeState(nodeState);
			wfHandle0.setLastUpdateDept(WfCurrentSession.GetDeptId());
			wfHandle0.setLastUpdateTime(new Date());
			wfHandle0.setLastUpdateUser(WfCurrentSession.GetUserId());
			wfHandleDao.EditWfHandle(wfHandle0);
		}
	}

	private void __Back(String nodeId, int absId) throws Exception {
		Node node = GetXmlNode(nodeId);
		SetNodeAttribute(node, "state", HbmwfUtil.WF_NODESTATE_NPD);
		//
		HbmentFormHandle formHandle0 = wfFormHandleDao.GetFormHandle(formId, formType, nodeId, absId);
		if (formHandle0 == null) {
			throw new Exception("没有可操作的数据");
		} else {
			formHandle0.setCompletedDeptId(WfCurrentSession.GetDeptId());
			formHandle0.setCompletedEmpId(WfCurrentSession.GetUserId());
			formHandle0.setCompletedInd("1");
			formHandle0.setCompletedTime(new Date());
			formHandle0.setCurrentInd("1");
			formHandle0.setDwState(HbmwfUtil.WF_NODESTATE_NPD);
			formHandle0.setVeriDesc(curHandleMsg);
			formHandle0.setWfNodeId(GetNodeAttrValue(curNode, "id"));
			wfFormHandleDao.EditFormHandle02(formHandle0);
		}
	}

	private void _Back(String nodeId) throws Exception {
		List<Node> xnl0 = GetTheLevelNodes(nodeId);
		List<Node> xnl1 = GetPreNodes(nodeId);
		//
		Node node0 = GetXmlNode(nodeId);
		//
		String nodeState0 = GetNodeAttrValue(node0, "state");
		if (nodeState0.toLowerCase().equals(HbmwfUtil.WF_NODESTATE_NPD.toLowerCase())) {
			// do nothing
		} else {
			for (Node lpNode : xnl0) {
				String lpNodeState = GetNodeAttrValue(lpNode, "state");
				if (lpNodeState.toLowerCase().equals(HbmwfUtil.WF_NODESTATE_NPD.toLowerCase())) {
					continue;
				}
				SetNodeAttribute(lpNode, "state", HbmwfUtil.WF_NODESTATE_NPD.toLowerCase());
				String nodeId0 = GetNodeAttrValue(lpNode, "id");
				List<String> absRecIds = GetAbsRecIds(nodeId0);
				//
				for (String lpAbsId : absRecIds) {
					__Back(nodeId0, Integer.valueOf(lpAbsId));
				}
				//
			}

			for (Node lpNode1 : xnl1) {
				String nodeId1 = GetNodeAttrValue(lpNode1, "id");
				List<String> absRecIds1 = GetAbsRecIds(nodeId1);
				//
				for (String lpAbsId : absRecIds1) {
					__Back(nodeId1, Integer.valueOf(lpAbsId));
					//
					_Back(nodeId1);
				}
			}

			HbmentDynamicForm dynamciForm = BzDynamicForm.GetDynamicForm(formId, formType);
			dynamciForm.setFormState(HbmwfUtil.FORM_STATE_VERINPD);
			BzDynamicForm.UpdateFormState(dynamciForm, dynamciForm.getFormState());

		}
	}

	private void _ResetNodeState() {
		for (int i = 0; i < xnl0.getLength(); i++) {
			SetNodeAttribute(xnl0.item(i), "state", HbmwfUtil.WF_NODESTATE_NB.toLowerCase());
		}
		for (int i = 0; i < xnl1.getLength(); i++) {
			SetNodeAttribute(xnl1.item(i), "state", HbmwfUtil.WF_NODESTATE_NB.toLowerCase());
		}
		for (int i = 0; i < xnl2.getLength(); i++) {
			SetNodeAttribute(xnl2.item(i), "state", HbmwfUtil.WF_NODESTATE_NB.toLowerCase());
		}
	}

	private void _UpdateWfHandleInfo() throws Exception {
		for (int i = 0; i < xnl0.getLength(); i++) {
			//
			Node node0 = xnl0.item(i);
			String node0id = GetNodeAttrValue(node0, "id");
			String node0state = GetNodeAttrValue(node0, "state");
			UpdateWfHandle(node0id, node0state);

		}
		for (int i = 0; i < xnl1.getLength(); i++) {
			//
			Node node1 = xnl1.item(i);
			String node1id = GetNodeAttrValue(node1, "id");
			String node1state = GetNodeAttrValue(node1, "state");
			UpdateWfHandle(node1id, node1state);
		}
		for (int i = 0; i < xnl2.getLength(); i++) {
			//
			Node node2 = xnl2.item(i);
			String node2id = GetNodeAttrValue(node2, "id");
			String node2state = GetNodeAttrValue(node2, "state");
			UpdateWfHandle(node2id, node2state);
		}
	}

	private void _SaveWf() throws Exception {
		_UpdateWfHandleInfo();
		//
		_ResetNodeState();
		//
		HbmentWf wf = wfDao.GetWf(formId, formType,true);
		wf.setWfContent(OracleUtil.Getbase64codeFromDocument(theWf));
		wf.setLastUpdateDept(WfCurrentSession.GetDeptId());
		wf.setLastUpdateTime(new Date());
		wf.setLastUpdateUser(WfCurrentSession.GetUserId());
		wfDao.EditWfContent(wf);
	}

	// 重新实现部分API
	// HbmentWf curWf = null; 统一成theWfObj
	HbmwfDriving curDrivering = null;

	public void StartVeriWf() throws Exception {
		theWfObj = wfDao.GetWf(formId, formType,true);
		curDrivering = new HbmwfDriving();
		HbmentWfDrivingImpl drivingEvent = new HbmentWfDrivingImpl(curDrivering, formId, formType, "启动流程");
		curDrivering.InitWf(theWfObj.getId(), drivingEvent);
		//
		if(curForm.getFormState().toLowerCase().equals(HbmwfUtil.FORM_STATE_VERINPD.toLowerCase()))
		{
			curHandleMsg = "从新发送审批";
			//
			curDrivering.RestartWf(curHandleMsg);
		}
		else
		{
			curHandleMsg = "发送审批";
			curDrivering.StartWf(curHandleMsg);
		}
	}

	// 审批功能
	public void Verification(boolean veriResult, String veriDsce) throws Exception {
		HbmentWf wf = wfDao.GetWf(formId, formType,true);
		//
		HbmwfDriving wfDriving = new HbmwfDriving();
		HbmentWfDrivingImpl drivingEvent = new HbmentWfDrivingImpl(curDrivering, formId, formType, veriDsce);
		wfDriving.InitWf(wf.getId(), drivingEvent);
		//
		wfDriving.VeriNode(theFormHandle.getWfNodeId(), veriDsce, veriResult);
	}
}