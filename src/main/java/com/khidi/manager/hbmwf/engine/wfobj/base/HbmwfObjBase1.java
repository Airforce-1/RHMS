/**   
* @Title: HbmwfObjBase1.java 
* @Package com.khidi.manager.hbm.engine.wfobj.base 
* @Description: TODO(流程数据结构  的 数据填充   工具类) 
* @author 王顺波
* @date 2017年11月23日 上午11:11:33 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.wfobj.base;

import java.util.ArrayList;
import java.util.List;

import com.khidi.manager.hbmwf.engine.wfobj.HbmwfNode;

// 读取指定节点的所有父节点
public class HbmwfObjBase1 {
	public HbmwfObjBase1() {
		previousNodes = new ArrayList<HbmwfNode>();
	}

	private List<HbmwfNode> previousNodes;

	// 检查一个节点是否在指定集合中已经存在
	private boolean NodeExists(HbmwfNode node) {
		for (HbmwfNode lpNode : previousNodes) {
			if (lpNode.getNodeId().equals(node.getNodeId())) {
			}
		}
		return false;
	}

	// 检查一个节点是否是另一个节点的子节点
	private boolean NodeExistsInSourceSons(HbmwfNode pSourceNode, HbmwfNode pTheNode) {
		if(pSourceNode.getNextNodes() == null)
		{
			return false;
		}
		for (HbmwfNode lpNode : pSourceNode.getNextNodes()) {
			if (lpNode.getNodeId().equals(pTheNode.getNodeId())) {
				return true;
			}
		}
		return false;
	}

	// 返回结果值
	public List<HbmwfNode> GetResult()
	{
		return previousNodes;
	}
	
	// 查询一个节点的父节点
	public void FillPreviousNodes(HbmwfNode pSourceNode, HbmwfNode pTheNode) {
		if(pSourceNode.getNodeId().equals(pTheNode.getNodeId()))
		{
			return;
		}
		boolean exists1 = NodeExistsInSourceSons(pSourceNode, pTheNode);
		boolean exists2 = NodeExists(pSourceNode);
		//
		if (pSourceNode.getNextNodes() != null) {
			if (exists1) {
				if (!exists2) {
					previousNodes.add(pSourceNode);
				}
			} else {
				for (HbmwfNode lpNode : pSourceNode.getNextNodes()) {
					FillPreviousNodes(lpNode, pTheNode);
				}
			}
		}
	}
}
