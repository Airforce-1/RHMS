/**   
* @Title: HbmWfNodeFill.java 
* @Package com.khidi.manager.hbm.engine.wfobj.base 
* @Description: TODO(流程数据结构  的 数据填充) 
* @author 王顺波
* @date 2017年11月23日 上午11:11:33 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.wfobj.base;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.khidi.manager.hbmwf.engine.wfobj.HbmwfNode;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.EnumHbmwfNodeLogic;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumNodeState;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumNodeType;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;

/**
 * @author 王顺波
 *
 */
// 流程数据结构  的 数据填充
public class HbmWfNodeFill {
	// 返回值
	private HbmwfNode rtnNode;
	// node中间结果变量
	private List<HbmwfNode> nodeQueue;
	// 流程xml结构
	private Document document;
	// 根据nodeid查找node
	private HbmwfNode FindNode(String nodeId)
	{
		for(HbmwfNode lpNode : nodeQueue)
		{
			if(lpNode.getNodeId().equals(nodeId))
			{
				return lpNode;
			}
		}
		return null;
	}
	
	// 读取流程节点的属性  node:节点    attrName:节点属性名
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
	
	// 从节点集合查找流程节点  nodeList: 节点集合    nodeId:要查找的节点Id
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

	// 查找流程节点  nodeId:流程节点Id
	private Node GetXmlNode(String nodeId) {
		NodeList nodeList0 = document.getElementsByTagName(HbmwfUtil.WF_NODETAG_START);
		NodeList nodeList1 = document.getElementsByTagName(HbmwfUtil.WF_NODETAG_CMN);
		NodeList nodeList2 = document.getElementsByTagName(HbmwfUtil.WF_NODETAG_END);
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
	
	// 查找并填充流程数据结构
	private HbmwfNode ConvertFillNode(Node node) {
		HbmwfNode wfNode = new HbmwfNode();
		//
		wfNode.setBackToNode(GetNodeAttrValue(node, "backto"));
		wfNode.setEnumNodeState(HbmwfenumNodeState.valueOf(GetNodeAttrValue(node, "state")));
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
		wfNode.setNodeLogic(EnumHbmwfNodeLogic.valueOf(GetNodeAttrValue(node, "prelogic")));
		wfNode.setNodeName(node.getNodeName());
		wfNode.setReceivers(GetNodeAttrValue(node,"receiver"));
		wfNode.setWidth(GetNodeAttrValue(node, "width"));
		wfNode.setX(GetNodeAttrValue(node, "left"));
		wfNode.setY(GetNodeAttrValue(node, "top"));
		
		return wfNode;
	}
	
	// 填充节点(子方法)
	private HbmwfNode FillNode(String nodeId)
	{
		Node node = GetXmlNode(nodeId);
		//
		HbmwfNode wfNode = FindNode(nodeId);
		//
		if(wfNode == null)
		{
			wfNode = ConvertFillNode(node);
			nodeQueue.add(wfNode);
		}
		
		return wfNode;
	}
	
	// 填充节点(子方法)
	private List<HbmwfNode> GetFillNextnodes(Node node,String nxtIds)
	{
		List<HbmwfNode> rtn = new ArrayList<HbmwfNode>();
		//
		if(nxtIds == null || nxtIds.equals(""))
		{
			return null;
		}
		//
		String[] nxtIdsArr = nxtIds.split(",");
		//
		for(String nxtId : nxtIdsArr)
		{
			rtn.add(FillNode(nxtId));
		}
		//
		return rtn;
	}
	
	// 填充节点(API)
	public void FillNode(Node node)
	{
		if(node == null)
		{
			return;
		}
		if(rtnNode == null)
		{
			HbmwfNode node0 = FindNode(GetNodeAttrValue(node,"id"));
			
			if(node0 != null)
			{
				rtnNode = node0;
			}
			else
			{
				HbmwfNode wfNode = new HbmwfNode();
				//
				wfNode.setBackToNode(GetNodeAttrValue(node, "backto"));
				wfNode.setEnumNodeState(HbmwfenumNodeState.valueOf(GetNodeAttrValue(node, "state")));
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
				wfNode.setNodeLogic(EnumHbmwfNodeLogic.valueOf(GetNodeAttrValue(node, "prelogic")));
				wfNode.setNodeName(node.getNodeName());
				wfNode.setReceivers(GetNodeAttrValue(node,"receiver"));
				wfNode.setWidth(GetNodeAttrValue(node, "width"));
				wfNode.setX(GetNodeAttrValue(node, "left"));
				wfNode.setY(GetNodeAttrValue(node, "top"));
			}
		}
	}
}
