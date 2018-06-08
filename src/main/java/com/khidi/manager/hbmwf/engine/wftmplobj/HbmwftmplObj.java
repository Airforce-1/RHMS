/**   
* @Title: HbmwftmplObj.java 
* @Package com.khidi.manager.hbm.engine.wftmplobj 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月20日 下午1:35:54 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.wftmplobj;

import java.util.ArrayList;
import java.util.List;

import com.khidi.manager.hbmwf.engine.wfobj.HbmgsWfent;
import com.khidi.manager.hbmwf.engine.wfobj.HbmwfNode;
import com.khidi.manager.hbmwf.engine.wfobj.base.HbmNodehaveSon;
import com.khidi.manager.hbmwf.engine.wfobj.base.HbmwfObjBase1;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmEnumwfState;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumNodeState;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumNodeType;

/**
 * @author Administrator
 *
 */
// 流程模板核心类
public class HbmwftmplObj {
	private String wftempid;

	private HbmwfNode startnode;

	private HbmwfNode endnode;

	private String title;

	private List<String> _nodeids = new ArrayList<String>();

	private boolean NodeIdExists(String nodeId) {
		for (String lpNode : _nodeids) {
			if (lpNode.equals(nodeId)) {
				return true;
			}
		}
		return false;
	}

	private void Addnodeid(String pNodeid) {
		if (!NodeIdExists(pNodeid)) {
			_nodeids.add(pNodeid);
		}
	}

	private int GetNodesCounts() {
		return _nodeids.size();
	}

	private HbmwfNode _findnode(HbmwfNode pNode, String pNodeid) {
		if (pNode.getNodeId().equals(pNodeid)) {
			return pNode;
		} else {
			if (pNode.getNextNodes() != null) {
				for (HbmwfNode lpNode : pNode.getNextNodes()) {
					HbmwfNode lpRtnNode = _findnode(lpNode, pNodeid);
					if (lpRtnNode != null) {
						return lpRtnNode;
					}
				}
			}
		}
		return null;
	}

	// 根据id查找node
	public HbmwfNode FindNode(String pNodeid) {
		if (startnode == null) {
			return null;
		}
		return _findnode(startnode, pNodeid);
	}

	//
	public HbmEnumwfState GetWfState() {
		return HbmEnumwfState.none;
	}

	List<HbmgsWfent> _Gswfents = new ArrayList<HbmgsWfent>();
	// 结束节点数
	private int _Endnodect = 0;
	// 节点数
	private int _Nodecounts = 0;

	//
	public void MainInitialized() // TOOD: internal
	{
		MainInitialized(startnode);
		//
		_Nodecounts = _Gswfents.size();
	}

	private boolean NodeExistsInCacheNodes(String nodeId) {
		for (HbmgsWfent lpWfent : _Gswfents) {
			if (lpWfent.getNodeId().equals(nodeId)) {
				return true;
			}
		}
		//
		return false;
	}

	// // 流程模板初始化方法1
	// public void MainInitialized() {
	// MainInitialized(_startnode);
	// //
	// _Nstdoct = GetNodeCountsByNodeState(HbmwfenumNodeState.DO);
	// _Nstnbct = GetNodeCountsByNodeState(HbmwfenumNodeState.NB);
	// _Nstnonect = GetNodeCountsByNodeState(HbmwfenumNodeState.NONE);
	// _Nstnpdct = GetNodeCountsByNodeState(HbmwfenumNodeState.NPD);
	// _Nstpsdct = GetNodeCountsByNodeState(HbmwfenumNodeState.PSD);
	// //
	// _Nodecounts = _Gswfents.size();
	// }

	private void MainInitialized(HbmwfNode pNode) {
		if (pNode == null) {
			return;
		}
		if (pNode.getEnumNodeType() == HbmwfenumNodeType.end) {
			endnode = (HbmwfNode) pNode;
			_Endnodect++;
		}

		if (NodeExistsInCacheNodes(pNode.getNodeId())) {
			_Gswfents.add(new HbmgsWfent(pNode.getNodeId(), pNode.getEnumNodeState(), pNode.getBackToNode(),
					pNode.getReceivers(), pNode.getEnumNodeType()));
		}
		if (pNode.getNextNodes() != null) {
			for (HbmwfNode lpNode : pNode.getNextNodes()) {
				MainInitialized(lpNode);
			}
		}
	}

	public List<HbmwfNode> GetPreNodes(String nodeId) {
		HbmwfNode theNode = FindNode(nodeId);
		if (theNode == null) {
			return null;
		}
		//
		return GetPreviousNodes(startnode, theNode);
	}

	private List<HbmwfNode> GetPreviousNodes(HbmwfNode pSourceNode, HbmwfNode pTheNode) {
		List<HbmwfNode> rtn = null;
		//
		HbmwfObjBase1 hbmwfobjBase = new HbmwfObjBase1();
		hbmwfobjBase.FillPreviousNodes(pSourceNode, pTheNode);
		return hbmwfobjBase.GetResult();
	}

	private boolean NodesParentAndSon(HbmwfNode pParentNode, HbmwfNode pSonNode) {
		boolean rtn = false;
		if (pParentNode.getNodeId().equals(pSonNode.getNodeId())) {
			return false;
		} else {
			HbmNodehaveSon hbmnodeHaveSon = new HbmNodehaveSon();
			hbmnodeHaveSon.NodeHaveSonCheck(pParentNode, pSonNode);
			//
			rtn = hbmnodeHaveSon.GetResult();
		}
		//
		return rtn;
	}

	private boolean IsStartSon(HbmwfNode pNode) {
		if (startnode.getNextNodes() != null) {
			for (HbmwfNode lpNode : startnode.getNextNodes()) {
				if (lpNode.getNodeId().equals(pNode.getNodeId())) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean CanCfgreceiver(String pNodeId) {
		HbmwfNode tmpNode = FindNode(pNodeId);
		return tmpNode.getEnumNodeType() == HbmwfenumNodeType.common;
	}

	public boolean IsCanBebackto(String pBackFrom, String pBackTo) {
		HbmwfNode tmpBackFromNode = FindNode(pBackFrom);
		HbmwfNode tmpBackToNode = FindNode(pBackTo);
		//
		if (tmpBackFromNode.getEnumNodeType() == HbmwfenumNodeType.start
				|| tmpBackFromNode.getEnumNodeType() == HbmwfenumNodeType.none
				|| tmpBackFromNode.getEnumNodeType() == HbmwfenumNodeType.end || IsStartSon(tmpBackFromNode)) {
			// throw Wfexceptions.Wfnodetypenotallowexception;
			return false;
		}
		if (tmpBackToNode.getEnumNodeType() != HbmwfenumNodeType.common) {
			return false;
		}
		return NodesParentAndSon(tmpBackToNode, tmpBackFromNode);
	}

	public boolean IsCanBack(String pNodeId) {
		HbmwfNode tmpBackFromNode = FindNode(pNodeId);
		//
		if (tmpBackFromNode.getEnumNodeType() == HbmwfenumNodeType.start
				|| tmpBackFromNode.getEnumNodeType() == HbmwfenumNodeType.none
				|| tmpBackFromNode.getEnumNodeType() == HbmwfenumNodeType.end || IsStartSon(tmpBackFromNode)) {
			// throw Wfexceptions.Wfnodetypenotallowexception;
			return false;
		}
		return true;
	}

	public String getWftempid() {
		return wftempid;
	}

	public void setWftempid(String wftempid) {
		this.wftempid = wftempid;
	}

	public HbmwfNode getStartnode() {
		return startnode;
	}

	public void setStartnode(HbmwfNode startnode) {
		this.startnode = startnode;
	}

	public HbmwfNode getEndnode() {
		return endnode;
	}

	public void setEndnode(HbmwfNode endnode) {
		this.endnode = endnode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
