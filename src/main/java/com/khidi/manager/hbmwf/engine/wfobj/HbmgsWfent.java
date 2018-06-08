package com.khidi.manager.hbmwf.engine.wfobj;

import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumNodeState;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumNodeType;

// 流程使用的流程节点实体
public class HbmgsWfent {
	// 节点编号
	private String nodeId;
	// 节点状态
	private HbmwfenumNodeState nodeState;
	// 返回到的节点
	private String backTo;
	// 接收者
	private String receiver;
	// 节点类型
	private HbmwfenumNodeType nodeType;
	//
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public HbmwfenumNodeState getNodeState() {
		return nodeState;
	}
	public void setNodeState(HbmwfenumNodeState nodeState) {
		this.nodeState = nodeState;
	}
	public String getBackTo() {
		return backTo;
	}
	public void setBackTo(String backTo) {
		this.backTo = backTo;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public HbmwfenumNodeType getNodeType() {
		return nodeType;
	}
	public void setNodeType(HbmwfenumNodeType nodeType) {
		this.nodeType = nodeType;
	}
	
	public HbmgsWfent(String nodeId,HbmwfenumNodeState nodeState,String backTo,String receiver,HbmwfenumNodeType nodeType)
	{
		this.nodeId = nodeId;
		this.nodeState = nodeState;
		this.backTo = backTo;
		this.receiver = receiver;
		this.nodeType = nodeType;
	}
}
