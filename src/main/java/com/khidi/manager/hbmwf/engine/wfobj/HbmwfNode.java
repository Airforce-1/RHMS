package com.khidi.manager.hbmwf.engine.wfobj;

import java.util.List;

import com.khidi.manager.hbmwf.engine.wfobj.theenum.EnumHbmwfNodeLogic;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumNodeState;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumNodeType;

/**
 * 工作流数据结构 工作流结构
 *
 * @author 王顺波
 * @email 405877884@qq.com
 * @date 2017-11-17 11:02
 */
public class HbmwfNode {
	// 节点编号
	private String NodeId;
	// 节点名称
	private String NodeName;
	// 节点X坐标
	private String X;
	// 节点Y坐标
	private String Y;
	// 节点显示宽度
	private String Width;
	// 节点显示高度
	private String Height;
	// 节点类型
	private HbmwfenumNodeType EnumNodeType;
	// 节点状态
	private HbmwfenumNodeState EnumNodeState;
	// 子节点
	private List<HbmwfNode> nextNodes;
	// 退回到的节点
	private String backToNode;
	// 接收者
	private String receivers;

	// 节点逻辑
	private EnumHbmwfNodeLogic nodeLogic;

	public EnumHbmwfNodeLogic getNodeLogic() {
		return nodeLogic;
	}

	public void setNodeLogic(EnumHbmwfNodeLogic nodeLogic) {
		this.nodeLogic = nodeLogic;
	}

	public String getReceivers() {
		return receivers;
	}

	public void setReceivers(String receivers) {
		this.receivers = receivers;
	}

	public String getBackToNode() {
		return backToNode;
	}

	public void setBackToNode(String backToNode) {
		this.backToNode = backToNode;
	}

	//
	private String NodeColor;

	//
	public String getNodeId() {
		return NodeId;
	}

	public void setNodeId(String nodeId) {
		NodeId = nodeId;
	}

	public String getNodeName() {
		return NodeName;
	}

	public void setNodeName(String nodeName) {
		NodeName = nodeName;
	}

	public String getX() {
		return X;
	}

	public void setX(String x) {
		X = x;
	}

	public String getY() {
		return Y;
	}

	public void setY(String y) {
		Y = y;
	}

	public String getWidth() {
		return Width;
	}

	public void setWidth(String width) {
		Width = width;
	}

	public String getHeight() {
		return Height;
	}

	public void setHeight(String height) {
		Height = height;
	}

	public HbmwfenumNodeType getEnumNodeType() {
		return EnumNodeType;
	}

	public void setEnumNodeType(HbmwfenumNodeType enumNodeType) {
		EnumNodeType = enumNodeType;
	}

	public HbmwfenumNodeState getEnumNodeState() {
		return EnumNodeState;
	}

	public void setEnumNodeState(HbmwfenumNodeState enumNodeState) {
		EnumNodeState = enumNodeState;
	}

	public List<HbmwfNode> getNextNodes() {
		return nextNodes;
	}

	public void setNextNodes(List<HbmwfNode> nextNodes) {
		this.nextNodes = nextNodes;
	}

	public String getNodeColor() {
		return NodeColor;
	}

	public void setNodeColor(String NodeColor) {
		this.NodeColor = NodeColor;
	}
	
	public HbmwfNode DeepCopy() {
		// TODO Auto-generated method stub
		HbmwfNode rtn = new HbmwfNode();
		rtn.setBackToNode(null);
		rtn.setEnumNodeState(this.getEnumNodeState());
		rtn.setEnumNodeType(this.getEnumNodeType());
		rtn.setHeight(this.getHeight());
		rtn.setNextNodes(null);
		rtn.setNodeColor("");
		rtn.setNodeId(this.getNodeId());
		rtn.setNodeLogic(this.getNodeLogic());
		rtn.setNodeName(this.getNodeName());
		rtn.setReceivers(this.getReceivers());
		rtn.setWidth(this.getWidth());
		rtn.setX(this.getX());
		rtn.setY(this.getY());
		return rtn;
	}
}
