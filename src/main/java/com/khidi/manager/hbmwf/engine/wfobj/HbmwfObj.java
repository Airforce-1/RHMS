package com.khidi.manager.hbmwf.engine.wfobj;

import java.util.ArrayList;
import java.util.List;

import com.khidi.manager.hbmwf.engine.wfobj.base.HbmNodehaveSon;
import com.khidi.manager.hbmwf.engine.wfobj.base.HbmwfObjBase1;
import com.khidi.manager.hbmwf.engine.wfobj.base.WfnodestatewrongeException;
import com.khidi.manager.hbmwf.engine.wfobj.base.WfstartException;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.EnumHbmwfNodeLogic;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmEnumwfState;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumNodeState;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumNodeType;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumeventType;

/**
 * 工作流数据结构 工作流引擎 类2
 *
 * @author 王顺波
 * @email 405877884@qq.com
 * @date 2017-11-17 11:02
 */
// 流程引擎核心2
public class HbmwfObj {
	// 流程ID
	private int _Wfid;
	public int get_Wfid() {
		return _Wfid;
	}

	public void set_Wfid(int _Wfid) {
		this._Wfid = _Wfid;
	}

	// 起始节点
	private HbmwfNode _startnode;

	public HbmwfNode get_startnode() {
		return _startnode;
	}

	public void set_startnode(HbmwfNode _startnode) {
		this._startnode = _startnode;
	}

	// 结束节点
	private HbmwfNode _endnode;

	// 流程标题
	private String _title;

	public String get_title() {
		return _title;
	}

	public void set_title(String _title) {
		this._title = _title;
	}

	// 流程节点集合
	private List<String> _nodeids = new ArrayList<String>();

	// 检查节点是否存在
	private boolean NodeIdExists(String nodeId) {
		for (String lpNode : _nodeids) {
			if (lpNode.equals(nodeId)) {
				return true;
			}
		}
		return false;
	}

	// 项数据结构中添加节点
	private void Addnodeid(String pNodeid) {
		if (!NodeIdExists(pNodeid)) {
			_nodeids.add(pNodeid);
		}
	}

	// 获取流程节点数量
	private int GetNodesCounts() {
		return _nodeids.size();
	}

	// 查找节点
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
		if (_startnode == null) {
			return null;
		}
		return _findnode(_startnode, pNodeid);
	}
	//

	/*************************************************** 备注 *******************************************************/

	/*************************************************
	 * END 备注
	 *****************************************************/

	// 获取流程状态
	public HbmEnumwfState GetWfState() {
		if (_Nstnonect > 0) {
			return HbmEnumwfState.none;
		} else {
			if (_endnode.getEnumNodeState() == HbmwfenumNodeState.PSD) {
				return HbmEnumwfState.complete;
			}
		}
		//
		if (_Nstnbct == _Nodecounts && _Nstdoct == 0 && _Nstnonect == 0 && _Nstnpdct == 0 && _Nstpsdct == 0) {
			// 未开始
			return HbmEnumwfState.nb;
		} else {
			if (_Nstdoct > 0) {
				return HbmEnumwfState.doing;
			} else {
				// ...
			}
		}
		return HbmEnumwfState.none;
	}

	// 检查流程是否可以启动
	public boolean Wfcanrestart() {
		if (GetWfState() == HbmEnumwfState.doing) {
			for (HbmgsWfent lpWfent : _Gswfents) {
				if (lpWfent.getNodeType() == HbmwfenumNodeType.common
						&& (lpWfent.getReceiver() == null || lpWfent.getReceiver().length() == 0)) {
					return false;
				}
			}
			return true;
		}

		return false;
	}

	public boolean Wfcanstart() {
		boolean rtn = false;
		HbmEnumwfState wfState = GetWfState();
		if (wfState == HbmEnumwfState.nb) {
			rtn = true;
			for (HbmgsWfent lpWfent : _Gswfents) {
				if (lpWfent.getNodeType() == HbmwfenumNodeType.common
						&& (lpWfent.getReceiver() == null || lpWfent.getReceiver().length() == 0)) {
					rtn = false;
					break;
				}
			}
		}
		return rtn;
	}

	// 根据状态获取节点数量
	private int GetNodeCountsByNodeState(HbmwfenumNodeState nodeState) {
		int rtn = 0;
		for (HbmgsWfent lpWfent : _Gswfents) {
			if (lpWfent.getNodeState() == nodeState) {
				rtn++;
			}
		}
		//
		return rtn;
	}

	// 刷新流程状态
	public void RefreshWf() {
		_Gswfents = new ArrayList<HbmgsWfent>();
		//
		MainInitialized(_startnode);
		//
		_Nstdoct = GetNodeCountsByNodeState(HbmwfenumNodeState.DO);
		_Nstnbct = GetNodeCountsByNodeState(HbmwfenumNodeState.NB);
		_Nstnonect = GetNodeCountsByNodeState(HbmwfenumNodeState.NONE);
		_Nstnpdct = GetNodeCountsByNodeState(HbmwfenumNodeState.NPD);
		_Nstpsdct = GetNodeCountsByNodeState(HbmwfenumNodeState.PSD);
		//
		_Nodecounts = _Gswfents.size();
	}

	// 流程节点对象集合
	private List<HbmgsWfent> _Gswfents = new ArrayList<HbmgsWfent>();

	public List<HbmgsWfent> GetAllNodeList() {
		return _Gswfents;
	}

	// 节点状态数量
	private int _Nstdoct = 0;
	private int _Nstnbct = 0;
	private int _Nstnonect = 0;
	private int _Nstnpdct = 0;
	private int _Nstpsdct = 0;
	// 结束节点数
	private int _Endnodect = 0;
	// 节点数
	private int _Nodecounts = 0;
	//

	// 流程初始化方法1
	public void MainInitialized() {
		MainInitialized(_startnode);
		//
		_Nstdoct = GetNodeCountsByNodeState(HbmwfenumNodeState.DO);
		_Nstnbct = GetNodeCountsByNodeState(HbmwfenumNodeState.NB);
		_Nstnonect = GetNodeCountsByNodeState(HbmwfenumNodeState.NONE);
		_Nstnpdct = GetNodeCountsByNodeState(HbmwfenumNodeState.NPD);
		_Nstpsdct = GetNodeCountsByNodeState(HbmwfenumNodeState.PSD);
		//
		_Nodecounts = _Gswfents.size();
	}

	// 检查节点是否在cache中存在
	private boolean NodeExistsInCacheNodes(String nodeId) {
		for (HbmgsWfent lpWfent : _Gswfents) {
			if (lpWfent.getNodeId().equals(nodeId)) {
				return true;
			}
		}
		//
		return false;
	}

	// 流程初始化方法2
	private void MainInitialized(HbmwfNode pNode) {
		if (pNode == null) {
			return;
		}
		if (pNode.getEnumNodeType() == HbmwfenumNodeType.end) {
			_endnode = (HbmwfNode) pNode;
			_Endnodect++;
		}

		if (!NodeExistsInCacheNodes(pNode.getNodeId())) {
			_Gswfents.add(new HbmgsWfent(pNode.getNodeId(), pNode.getEnumNodeState(), pNode.getBackToNode(),
					pNode.getReceivers(), pNode.getEnumNodeType()));
		}
		if (pNode.getNextNodes() != null) {
			for (HbmwfNode lpNode : pNode.getNextNodes()) {
				MainInitialized(lpNode);
			}
		}
	}

	// 流程事件代理
	public IhbmwfAdapter __eventAdapter;

	// 重启流程
	public void RestartWf() // internal
	{
		if (!Wfcanrestart()) {
			throw new WfstartException("流程状态不适合启动");
		}
		//
		if (_startnode.getEnumNodeState() != HbmwfenumNodeState.PSD
				&& _startnode.getEnumNodeState() == HbmwfenumNodeState.DO) {
			if (__eventAdapter != null) {
				_startnode.setEnumNodeState(HbmwfenumNodeState.PSD);
				__eventAdapter.WfNodeStateChanged(
						new HbmwfEventObj(_startnode, null, null, HbmwfenumeventType.startwf, "", "启动流程"));
				// TODO:修正所有触发参数为标准参数
			}

		} else {
			throw new WfstartException("流程状态不适合启动");
		}
		for (HbmwfNode pNode : _startnode.getNextNodes()) {
			StartWf(pNode);
		}
	}

	// 启动流程
	protected void StartWf() throws Exception // TODO:internal
	{
		if (!Wfcanstart()) {
			throw new Exception("流程状态不适合启动");
		}
		if (_startnode.getEnumNodeState() != HbmwfenumNodeState.PSD) {
			if (__eventAdapter != null) {
				_startnode.setEnumNodeState(HbmwfenumNodeState.PSD);
				__eventAdapter.WfNodeStateChanged(
						new HbmwfEventObj(_startnode, null, null, HbmwfenumeventType.startwf, "", "启动流程"));
				// TODO:修正所有触发参数为标准参数
			}
		}
		//
		for (HbmwfNode pNode : _startnode.getNextNodes()) {
			StartWf(pNode);
		}
	}

	// 启动流程
	private void StartWf(HbmwfNode pNode) {

		if (pNode.getEnumNodeState() != HbmwfenumNodeState.NB && pNode.getEnumNodeState() != HbmwfenumNodeState.NPD) {
			throw new WfnodestatewrongeException("");
		}
		pNode.setEnumNodeState(HbmwfenumNodeState.DO);
		if (__eventAdapter != null) {
			__eventAdapter.WfNodeStateChanged(new HbmwfEventObj(pNode, null, null, HbmwfenumeventType.startwf, "", "启动流程"));
		}

	}

	// 读取节点的所有父节点
	private List<HbmwfNode> GetPreviousNodes(HbmwfNode pSourceNode, HbmwfNode pTheNode) {
		List<HbmwfNode> rtn = null;
		//
		HbmwfObjBase1 hbmwfobjBase = new HbmwfObjBase1();
		hbmwfobjBase.FillPreviousNodes(pSourceNode, pTheNode);
		return hbmwfobjBase.GetResult();
	}

	// 检查两个节点是否是父子关系
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
		if (_startnode.getNextNodes() != null) {
			for (HbmwfNode lpNode : _startnode.getNextNodes()) {
				if (lpNode.getNodeId().equals(pNode.getNodeId())) {
					return true;
				}
			}
		}
		return false;
	}

	private void VeriNotPsd(HbmwfNode pVeriNode, HbmwfNode pBackNode) throws Exception {
		if (GetWfState() == HbmEnumwfState.complete) {
			throw new Exception("节点状态不允许该操作");
		}

		if (pBackNode.getEnumNodeState() == HbmwfenumNodeState.PSD) {
			pBackNode.setEnumNodeState(HbmwfenumNodeState.DO);
			//
			if (__eventAdapter != null) {
				__eventAdapter.WfNodeNotPsdBacktobacknode(new HbmwfEventObj(pBackNode, pVeriNode, pBackNode,
						HbmwfenumeventType.backtobacknode, "", "审批不通过,退回到backnode"));
			}
		}
		if (pBackNode.getNextNodes() != null) {
			for (HbmwfNode lpNode : pBackNode.getNextNodes()) {
				VeriEnforceNotPsd(pVeriNode, pBackNode, lpNode);
			}
		}
		//
	}

	private void VeriEnforceNotPsd(HbmwfNode pVeriNode, HbmwfNode pBackNode, HbmwfNode pEnforceBackNode) {
		if (pEnforceBackNode.getEnumNodeState() == HbmwfenumNodeState.PSD) {
			pEnforceBackNode.setEnumNodeState(HbmwfenumNodeState.NPD);
			if (__eventAdapter != null) {
				__eventAdapter.WfNodeEnforceNotPsd(new HbmwfEventObj(pEnforceBackNode, pVeriNode, pBackNode,
						HbmwfenumeventType.enforceverinodenpd, "", "强制审批不通过"));
			}
		} else {
			if (pEnforceBackNode.getEnumNodeState() == HbmwfenumNodeState.DO) {
				pEnforceBackNode.setEnumNodeState(HbmwfenumNodeState.NB);
				if (__eventAdapter != null) {
					__eventAdapter.WfNodeStateChanged(new HbmwfEventObj(pEnforceBackNode, pVeriNode, pBackNode,
							HbmwfenumeventType.enforceverinodenpd, "", "强制审批不通过"));
				}
			}
		}
		//
		if (pEnforceBackNode.getNextNodes() != null) {
			for (HbmwfNode lpNode : pEnforceBackNode.getNextNodes()) {
				if (lpNode.getEnumNodeState() == HbmwfenumNodeState.PSD
						|| lpNode.getEnumNodeState() == HbmwfenumNodeState.DO) {
					VeriEnforceNotPsd(pVeriNode, pBackNode, lpNode);
				}
			}
		}
	}

	private boolean CheckNodeHaveEnd(List<HbmwfNode> nodes) {
		for (HbmwfNode lpNode : nodes) {
			if (lpNode.getEnumNodeType() == HbmwfenumNodeType.end) {
				return true;
			}
		}
		return false;
	}

	private int GetNodeCountsByNodeState(List<HbmwfNode> sourceNodes,HbmwfenumNodeState nodeState)
	{
		int rtn = 0;
		for(HbmwfNode lpNode : sourceNodes)
		{
			if(lpNode.getEnumNodeState() == nodeState)
			{
				rtn ++;
			}
		}
		return rtn;
	}
	
	private int GetNodeCountsByNodeNotTheState(List<HbmwfNode> sourceNodes,HbmwfenumNodeState nodeState)
	{
		int rtn = 0;
		for(HbmwfNode lpNode : sourceNodes)
		{
			if(lpNode.getEnumNodeState() != nodeState)
			{
				rtn ++;
			}
		}
		return rtn;
	}
	// 审批通过 end节点检查
	public void VeriNodePsdCheckNextIsEndNode(HbmwfNode pVeriNode) throws InterruptedException // internal
    {
        if (pVeriNode.getNextNodes() != null)
        {
           if(CheckNodeHaveEnd(pVeriNode.getNextNodes()))
            {
                List<HbmwfNode> tmpPreNodes = new ArrayList<HbmwfNode>();
                HbmwfObjBase1 hbmwfObjBase = new HbmwfObjBase1();
                hbmwfObjBase.FillPreviousNodes(_startnode, _endnode);
                tmpPreNodes = hbmwfObjBase.GetResult();
                //
                
                int tmpPsdCount = GetNodeCountsByNodeState(tmpPreNodes,HbmwfenumNodeState.PSD);
                
                if (_endnode.getNodeLogic() == EnumHbmwfNodeLogic.and)
                {
                    if (tmpPsdCount == tmpPreNodes.size())
                    {
                        if (_endnode.getEnumNodeState() != HbmwfenumNodeState.PSD)
                        {
                            _endnode.setEnumNodeState(HbmwfenumNodeState.PSD);
                            //
                            if (__eventAdapter != null)
                            {
                            	__eventAdapter.WfNodeStateChanged(new HbmwfEventObj(_endnode, pVeriNode, null, HbmwfenumeventType.verinodepsd, "", "最终节点审批通过"));
                                //
                                Thread.sleep(1);
                                //
                                __eventAdapter.WfNodeEnforcePsd(new HbmwfEventObj(_endnode, pVeriNode, null, HbmwfenumeventType.completewf, "", "流程审批结束"));
                            }
                        }
                    }
                }
                else
                {
                    if (_endnode.getNodeLogic() == EnumHbmwfNodeLogic.or)
                    {
                        if (tmpPsdCount > 0)
                        {
                            for (HbmwfNode lpNode : tmpPreNodes)
                            {
                                if (lpNode.getEnumNodeState() != HbmwfenumNodeState.PSD)
                                {
                                    lpNode.setEnumNodeState(HbmwfenumNodeState.PSD);
                                    //
                                    if (__eventAdapter != null)
                                    {
                                    	__eventAdapter.WfNodeEnforcePsd(new HbmwfEventObj(lpNode, pVeriNode, null, HbmwfenumeventType.enforceverinodepsd, "", "强制审批通过"));
                                        // Jerry Wang 2017 02 07
                                        Thread.sleep(1);
                                        __eventAdapter.WfNodeEnforcePsd(new HbmwfEventObj(lpNode, pVeriNode, null, HbmwfenumeventType.completewf, "", "流程审批结束"));
                                    }
                                }
                            }
                            //
                            if (_endnode.getEnumNodeState() != HbmwfenumNodeState.PSD)
                            {
                                _endnode.setEnumNodeState(HbmwfenumNodeState.PSD);
                                //
                                if (__eventAdapter != null)
                                {
                                	__eventAdapter.WfNodeStateChanged(new HbmwfEventObj(_endnode, pVeriNode, null, HbmwfenumeventType.verinodepsd, "", "最终节点审批通过"));
                                    //
                                    Thread.sleep(1);
                                    __eventAdapter.WfNodeEnforcePsd(new HbmwfEventObj(_endnode, pVeriNode, null, HbmwfenumeventType.completewf, "", "流程审批结束"));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

	public void VeriNode(String pNodeId, String pVeriDesc, boolean pPsd) throws Exception //TODO:internal
    {
        if (GetWfState() == HbmEnumwfState.nb)
        {
            throw new Exception("节点状态错误异常");
        }

        HbmwfNode tmpNode = FindNode(pNodeId);
        //
        if (tmpNode.getEnumNodeState() != HbmwfenumNodeState.DO && tmpNode.getEnumNodeState() != HbmwfenumNodeState.NPD)
        {
            throw new Exception("节点状态错误异常");
        }
        //
        List<HbmwfNode> tmpPreNodes = new ArrayList<HbmwfNode>();
        HbmwfObjBase1 hbmwfObjbase = new HbmwfObjBase1();
        hbmwfObjbase.FillPreviousNodes(_startnode, tmpNode);
        tmpPreNodes = hbmwfObjbase.GetResult();
        //
        int psdNodeCounts = GetNodeCountsByNodeNotTheState(tmpPreNodes,HbmwfenumNodeState.PSD);
        if (psdNodeCounts > 0)
        {
            throw new Exception("节点状态错误异常");
        }
        //
        if (tmpNode == null)
        {
        	throw new Exception("节点为空异常");
        }
        //
        if ((tmpNode.getEnumNodeState() != HbmwfenumNodeState.PSD && pPsd) || (tmpNode.getEnumNodeState() != HbmwfenumNodeState.NPD && pPsd == false))
        {
            if (pPsd)
            {
                tmpNode.setEnumNodeState(HbmwfenumNodeState.PSD);
                if (__eventAdapter != null)
                {
                	__eventAdapter.WfNodeStateChanged(new HbmwfEventObj(tmpNode, null, null, HbmwfenumeventType.verinodepsd, pVeriDesc, "审批通过"));
                }
                VeriNodePsdCheckNextIsEndNode(tmpNode);
            }
            else
            {
                if (!pPsd)
                {
                    if (IsStartSon(tmpNode))
                    {
                        if (tmpNode.getEnumNodeState() == HbmwfenumNodeState.DO)
                        {
                            // Jerry Wang 2017 06 03 15:48
                            tmpNode.setEnumNodeState(HbmwfenumNodeState.NPD);
                            //
                            if (__eventAdapter != null)
                            {
                            	__eventAdapter.WfNodeNotPsd(new HbmwfEventObj(tmpNode, null, null, HbmwfenumeventType.verinodenpd, pVeriDesc, "审批不通过"));
                            }
                            //
                            HbmwfNode tmpBackNode = FindNode(tmpNode.getBackToNode());
                            if (tmpBackNode == null)
                            {
                                tmpBackNode = _startnode;
                            }
                            //
                            VeriNotPsd(tmpNode, tmpBackNode);
                        }
                        else
                        {
                            throw new Exception("状态不允许的异常");
                        }
                    }
                    else
                    {
                        tmpNode.setEnumNodeState(HbmwfenumNodeState.NPD);
                        //
                        if (__eventAdapter != null)
                        {
                        	__eventAdapter.WfNodeNotPsd(new HbmwfEventObj(tmpNode, null, null, HbmwfenumeventType.verinodenpd, pVeriDesc, "审批不通过"));
                        }
                        //
                        HbmwfNode tmpBackNode = FindNode(tmpNode.getBackToNode());
                        if (tmpBackNode == null)
                        {
                            tmpBackNode = _startnode;
                        }
                        //
                        VeriNotPsd(tmpNode, tmpBackNode);
                    }
                }
                else
                {
                	throw new Exception("节点状态错误异常");
                }
            }
            if (tmpNode.getNextNodes() != null && pPsd)
            {
                for (HbmwfNode lpNode : tmpNode.getNextNodes())
                {
                    DrivingWf(lpNode);
                }
            }
            RefreshWf();
        }
        else
        {
            throw new Exception("节点状态错误异常");
        }
    }

	// TODO:还有问题，需进一步修改
	private void DrivingWf(HbmwfNode pNextNode) throws InterruptedException
    {
        // PSD
        List<HbmwfNode> tmpPreviousNodes = new ArrayList<HbmwfNode>();
        HbmwfObjBase1 hbmwfObjBase = new HbmwfObjBase1();
        hbmwfObjBase.FillPreviousNodes(_startnode, pNextNode);
        tmpPreviousNodes = hbmwfObjBase.GetResult();
        //
        //节点审批通过或者不通过时，判断下级节点的状态是否启动或者...
        //
        if (pNextNode.getEnumNodeState() == HbmwfenumNodeState.NB || pNextNode.getEnumNodeState() == HbmwfenumNodeState.NPD)
        {
            //
            if (pNextNode.getNodeLogic() == EnumHbmwfNodeLogic.and)
            {
                boolean allPsd = true;
                for (HbmwfNode lpNode : tmpPreviousNodes)
                {
                    if (lpNode.getEnumNodeState() != HbmwfenumNodeState.PSD)
                    {
                        allPsd = false;
                    }
                    //if (lpNode.Nodestate == EnumGswfnodeState.Nb)
                    //{
                    //    lpNode.Nodestate = EnumGswfnodeState.Do;
                    //    if (WfNodeStateChanged != null)
                    //    {
                    //        WfNodeStateChanged(lpNode, new EventArgs());
                    //    }
                    //}
                }
                if (allPsd)
                {
                    // TODO:Enforce doing...
                    pNextNode.setEnumNodeState(HbmwfenumNodeState.DO); 
                    if (__eventAdapter != null)
                    {

                    	__eventAdapter.WfNodeStateChanged(new HbmwfEventObj(pNextNode, null, null, HbmwfenumeventType.autostartnode, "", "自动启动下一节点"));
                    }
                    //
                    // VeriNodePsdCheckNextIsEndNode(pNextNode);
                }
            }
            else
            {
                if (pNextNode.getNodeLogic() == EnumHbmwfNodeLogic.or)
                {
                    boolean havePsd = false;
                    for (HbmwfNode lpNode : tmpPreviousNodes)
                    {
                        if (lpNode.getEnumNodeState() != HbmwfenumNodeState.PSD)
                        {
                            havePsd = true;
                        }
                    }
                    if (havePsd)
                    {
                        // TODO:Enforce doing...
                        pNextNode.setEnumNodeState(HbmwfenumNodeState.DO);
                        if (__eventAdapter != null)
                        {
                        	__eventAdapter.WfNodeStateChanged(new HbmwfEventObj(pNextNode, null, null, HbmwfenumeventType.autostartnode, "", "自动启动下一节点"));
                        }
                        //

                        for (HbmwfNode lpNode : tmpPreviousNodes)
                        {
                            if (lpNode.getEnumNodeState() != HbmwfenumNodeState.PSD)
                            {
                                lpNode.setEnumNodeState(HbmwfenumNodeState.PSD); 
                                //
                                if (__eventAdapter != null)
                                {
                                	__eventAdapter.WfNodeEnforcePsd(new HbmwfEventObj(lpNode, null, null, HbmwfenumeventType.enforceverinodepsd, "", "强制审批通过"));
                                }
                                // 下级节点有结束节点的强制审批
                                VeriNodePsdCheckNextIsEndNode(pNextNode);
                            }
                        }
                    }

                }
                for (HbmwfNode lpNode : tmpPreviousNodes)
                {
                    if (lpNode.getEnumNodeState() == HbmwfenumNodeState.NB)
                    {
                        lpNode.setEnumNodeState(HbmwfenumNodeState.DO); 
                        if (__eventAdapter != null)
                        {
                        	__eventAdapter.WfNodeStateChanged(new HbmwfEventObj(lpNode, null, null, HbmwfenumeventType.autostartnode, "", "启动节点"));
                        }
                    }
                }
            }
        }
        // NOT PSD
        // 在父函数作了处理
    }
	
	public void WfStartUndo() throws Exception
    {
        if (GetWfState() == HbmEnumwfState.doing)
        {
            if (_startnode.getNextNodes() != null)
            {
                boolean tmpCanUndo = true;
                for (HbmwfNode lpNode : _startnode.getNextNodes())
                {
                    if (lpNode.getEnumNodeState() != HbmwfenumNodeState.DO)
                    {
                        tmpCanUndo = false;
                        break;
                    }
                    if (lpNode.getNextNodes() != null)
                    {
                        for (HbmwfNode lplpNode : lpNode.getNextNodes())
                        {
                            if (lplpNode.getEnumNodeState() != HbmwfenumNodeState.NB)
                            {
                                tmpCanUndo = false;
                                break;
                            }
                        }
                    }
                }
                //
                if (tmpCanUndo)
                {
                    for (HbmwfNode lpNode : _startnode.getNextNodes())
                    {
                        if (lpNode.getEnumNodeState() == HbmwfenumNodeState.DO)
                        {
                            lpNode.setEnumNodeState(HbmwfenumNodeState.NB);
                            if (__eventAdapter != null)
                            {
                            	__eventAdapter.WfStartUndoEvent(new HbmwfEventObj(lpNode, null, null, HbmwfenumeventType.undostartwf, "", "撤销流程的启动(子节点)"));
                            }
                        }
                    }
                    if (_startnode.getEnumNodeState() == HbmwfenumNodeState.PSD)
                    {
                        _startnode.setEnumNodeState(HbmwfenumNodeState.NB);
                        if (__eventAdapter != null)
                        {
                        	__eventAdapter.WfStartUndoEvent(new HbmwfEventObj(_startnode, null, null, HbmwfenumeventType.undostartwf, "", "撤销流程的启动(根节点)"));
                        }
                    }
                }
                else
                {
                    throw new Exception("状态错误异常");
                }
            }
        }
    }
	
	public void WfEnforceStartUndo() throws Exception {
		if (GetWfState() == HbmEnumwfState.complete) {
			throw new Exception("流程状态不允许异常");
		}
		WfEnforceStartUndo(_startnode);
	}

	private void WfEnforceStartUndo(HbmwfNode pNode)
    {
        if (pNode.getEnumNodeState() != HbmwfenumNodeState.NB)
        {
            pNode.setEnumNodeState(HbmwfenumNodeState.NB);
            if (__eventAdapter != null)
            {
            	__eventAdapter.WfEnforceStartUndoEvent(new HbmwfEventObj(pNode, null, null, HbmwfenumeventType.enforceundostartwf, "", "强制撤销流程的启动(节点状态改变)"));
            }
        }
        if (pNode.getNextNodes() != null)
        {
            for (HbmwfNode lpNode : pNode.getNextNodes())
            {
                WfEnforceStartUndo(lpNode);
            }
        }
    }
	
	public boolean Cancfgbackto(String pNodeId) {
		HbmEnumwfState tmpWfState = GetWfState();
		if (tmpWfState == HbmEnumwfState.complete || tmpWfState == HbmEnumwfState.none) {
			return false;
		}
		HbmwfNode tmpNode = FindNode(pNodeId);
		if (tmpNode.getEnumNodeState() == HbmwfenumNodeState.DO || tmpNode.getEnumNodeState() == HbmwfenumNodeState.NB
				|| tmpNode.getEnumNodeState() == HbmwfenumNodeState.NPD) {
			return true;
		}
		return false;
	}

	public boolean CanCfgreceiver01(String pNodeId) {
		HbmEnumwfState tmpWfState = GetWfState();
		if (tmpWfState != HbmEnumwfState.nb) {
			return false;
		}
		HbmwfNode tmpNode = FindNode(pNodeId);
		return (tmpNode.getEnumNodeState() == HbmwfenumNodeState.NB || tmpNode.getEnumNodeState() == HbmwfenumNodeState.NPD);
	}

	public boolean IsCanBebackto(String pBackFrom, String pBackTo) {
		HbmwfNode tmpBackFromNode = FindNode(pBackFrom);
		HbmwfNode tmpBackToNode = FindNode(pBackTo);
		//
		if (tmpBackFromNode.getEnumNodeType() == HbmwfenumNodeType.start || tmpBackFromNode.getEnumNodeType() == HbmwfenumNodeType.none
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
		if (tmpBackFromNode.getEnumNodeType() == HbmwfenumNodeType.start || tmpBackFromNode.getEnumNodeType() == HbmwfenumNodeType.none
				|| tmpBackFromNode.getEnumNodeType() == HbmwfenumNodeType.end || IsStartSon(tmpBackFromNode)) {
			// throw Wfexceptions.Wfnodetypenotallowexception;
			return false;
		}
		return true;
	}


	public boolean CanCfgreceiver02(String pNodeId)
    {
		HbmwfNode tmpNode = FindNode(pNodeId);
        return tmpNode.getEnumNodeType() == HbmwfenumNodeType.common;
    }

	/*************************************************** END *******************************************************/

	/*************************************************** 初始化流程 *******************************************************/

	/*************************************************
	 * END 初始化流程
	 *****************************************************/

	/*************************************************** 备注 *******************************************************/

	/*************************************************
	 * END 备注
	 *****************************************************/

	/*************************************************** 备注 *******************************************************/

	/*************************************************
	 * END 备注
	 *****************************************************/

	/*************************************************** 备注 *******************************************************/

	/*************************************************
	 * END 备注
	 *****************************************************/

	/*************************************************** 备注 *******************************************************/

	/*************************************************
	 * END 备注
	 *****************************************************/

	/*************************************************** 备注 *******************************************************/

	/*************************************************
	 * END 备注
	 *****************************************************/

	/*************************************************** 备注 *******************************************************/

	/*************************************************
	 * END 备注
	 *****************************************************/

	/*************************************************** 备注 *******************************************************/

	/*************************************************
	 * END 备注
	 *****************************************************/

	/*************************************************** 备注 *******************************************************/

	/*************************************************
	 * END 备注
	 *****************************************************/

	/*************************************************** 备注 *******************************************************/

	/*************************************************
	 * END 备注
	 *****************************************************/

	/*************************************************** 备注 *******************************************************/

	/*************************************************
	 * END 备注
	 *****************************************************/
}
