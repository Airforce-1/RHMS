package com.khidi.manager.hbmwf.engine.wfobj;

import java.util.ArrayList;
import java.util.List;

import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumeventType;

// 流程事件回调信息
public class HbmwfEventObj {
	// 当前节点
	private HbmwfNode theNode;

	public HbmwfNode getTheNode() {
		return theNode;
	}

	public void setTheNode(HbmwfNode theNode) {
		this.theNode = theNode;
	}

	private List<HbmwfNode> _AttachNodes = new ArrayList<HbmwfNode>();

	// 事件类型
	private HbmwfenumeventType eventType = HbmwfenumeventType.none;

	private String lparam;
	private String rparam;

	public String getLparam() {
		return lparam;
	}

	public void setLparam(String lparam) {
		this.lparam = lparam;
	}

	public String getRparam() {
		return rparam;
	}

	public void setRparam(String rparam) {
		this.rparam = rparam;
	}

	// 流程事件对象
	public HbmwfEventObj(HbmwfNode pTheNode, HbmwfNode pBknode1, HbmwfNode pBknode2, HbmwfenumeventType pEventType,
			String pLparam, String pRparam) {
		theNode = pTheNode.DeepCopy();
		if (pBknode1 != null) {
			_AttachNodes.add(pBknode1.DeepCopy());
		}
		if (pBknode2 != null) {
			_AttachNodes.add(pBknode2.DeepCopy());
		}
		eventType = pEventType;
		lparam = pLparam;
		rparam = pRparam;
	}

	public HbmwfenumeventType getEventType() {
		return eventType;
	}

	public void setEventType(HbmwfenumeventType eventType) {
		this.eventType = eventType;
	}
}
