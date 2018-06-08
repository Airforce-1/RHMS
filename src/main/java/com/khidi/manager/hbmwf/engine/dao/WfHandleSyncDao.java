/**   
* @Title: WfHandleSyncDao.java 
* @Package com.khidi.manager.hbm.engine.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月24日 上午10:40:48 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.khidi.manager.hbmwf.engine.domain.HbmentWf;
import com.khidi.manager.hbmwf.engine.domain.HbmentWfHandle;
import com.khidi.manager.hbmwf.engine.wfobj.HbmwfEventObj;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumNodeState;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumNodeType;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.hbmwf.enginext.cfg.WfCurrentSession;

// 流程业务性handle DAO
public class WfHandleSyncDao {
	// 处理流程回调事件
	public void WfHandleSync(HbmwfEventObj event, HbmentWf wf) throws SQLException {
		String eventType = String.valueOf(event.getEventType());

		switch (eventType) {
		case "startwf": // 启动流程
			StartWf(event,wf);
			break;
		case "autostartnode": // 自动启动节点
			AutoStartNode(event,wf);
			break;
		case "backtobacknode": // 审批不通过自动退回节点
			BackToForNpd(event,wf);
			break;
		case "completewf":  // 处理完成，结束流程
			// do nothing
			break;
		case "enforceundostartwf": // 强制撤销流程启动
			break;
		case "enforceverinodenpd": // 强制审批不通过
			EnforceVeriNodeNpd(event,wf);
			break;
		case "enforceverinodepsd": // 强制审批通过
			EnforceVeriNodePsd(event,wf);
			break;
		case "none":  // do nothing
			break;
		case "undostartwf":  // 撤销流程启动
			break;
		case "verinodenpd":  // 审批节点不通过
			VeriNpd(event,wf);
			break;
		case "verinodepsd":  // 审批节点通过
			VeriPsd(event,wf);
			break;
		default:
			break;
		}
	}

	// 启动流程 回调
	private void StartWf(HbmwfEventObj event, HbmentWf wf) throws SQLException {
		if (event.getTheNode().getEnumNodeType() == HbmwfenumNodeType.start) {
			HbmentWfHandle wfHandle = new HbmentWfHandle();
			wfHandle.setMemo(event.getRparam());
			//
			wfHandle.setNodeId(event.getTheNode().getNodeId());
//			wfHandle.setNodeState(String.valueOf(event.getTheNode().getEnumNodeState()));
			wfHandle.setNodeState(String.valueOf(HbmwfenumNodeState.PSD));
			wfHandle.setWfId(wf.getId());
			wfHandle.setReceivers(event.getTheNode().getReceivers());
			//
			HbmentWfHandle rtn0 = GetWfCurHandle(wf.getId(), event.getTheNode().getNodeId());
			if (rtn0 != null) {
				rtn0.setReceivers(event.getTheNode().getReceivers());
				rtn0.setNodeState(String.valueOf(HbmwfenumNodeState.PSD));
				EditWfHandle(rtn0);
			} else {
				NewWfHandle(wfHandle);
			}
		} else {
			HbmentWfHandle wfHandle = new HbmentWfHandle();
			wfHandle.setMemo(event.getRparam());
			//
			wfHandle.setNodeId(event.getTheNode().getNodeId());
			wfHandle.setNodeState(String.valueOf(event.getTheNode().getEnumNodeState()));
			wfHandle.setWfId(wf.getId());
			wfHandle.setReceivers(event.getTheNode().getReceivers());
			//
			HbmentWfHandle rtn0 = GetWfCurHandle(wf.getId(), event.getTheNode().getNodeId());
			if (rtn0 != null) {
				ChangeCurHandleToHis(rtn0);
			} 
			NewWfHandle(wfHandle);
		}
	}

	// 把当前Handle变为历史记录 回调
	public boolean ChangeCurHandleToHis(HbmentWfHandle wfHandle) throws SQLException {
		String sql = "UPDATE HBMWF_HANDLE SET CURRENTIND = 0 WHERE WFID = ? AND NODEID = ? AND CURRENTIND = 1";
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		pre.setInt(1, wfHandle.getWfId());
		pre.setString(2, wfHandle.getNodeId());
		//
		boolean rtn = pre.execute();
		pre.close();
		con.close();
		return rtn;
	}

	// 自动启动节点 回调
	private void AutoStartNode(HbmwfEventObj event, HbmentWf wf) throws SQLException {
		HbmentWfHandle wfHandle = new HbmentWfHandle();
		wfHandle.setCurrentInd(1);
		wfHandle.setDelInd(0);
		wfHandle.setMemo(event.getRparam());
		wfHandle.setNodeId(event.getTheNode().getNodeId());
		wfHandle.setNodeState(String.valueOf(event.getTheNode().getEnumNodeState()));
		wfHandle.setWfId(wf.getId());
		// wfHandle.setReceivers(event.getTheNode().getReceivers()));
		HbmentWfHandle rtn0 = GetWfCurHandle(wf.getId(), event.getTheNode().getNodeId());

		if (rtn0 != null) {
			ChangeCurHandleToHis(rtn0);
		}
		NewWfHandle(wfHandle);
	}

	// 审批不通过退回 回调
	private void BackToForNpd(HbmwfEventObj event, HbmentWf wf) throws SQLException {
		HbmentWfHandle wfHandle = new HbmentWfHandle();
		wfHandle.setCurrentInd(1);
		wfHandle.setDelInd(0);
		wfHandle.setMemo(event.getRparam());
		wfHandle.setNodeId(event.getTheNode().getNodeId());
		wfHandle.setNodeState(String.valueOf(event.getTheNode().getEnumNodeState()));
		wfHandle.setWfId(wf.getId());
		HbmentWfHandle rtn0 = GetWfCurHandle(wf.getId(), event.getTheNode().getNodeId());

		if (rtn0 != null) {
			ChangeCurHandleToHis(rtn0);
		}
		NewWfHandle(wfHandle);
	}

	// 强制审批不通过 回调
	private void EnforceVeriNodeNpd(HbmwfEventObj event, HbmentWf wf) throws SQLException
	{
		HbmentWfHandle wfHandle = GetWfCurHandle(wf.getId(),event.getTheNode().getNodeId());
		//
		if(wfHandle != null)
		{
			wfHandle.setCurrentInd(1);
			wfHandle.setMemo(event.getRparam());
			wfHandle.setNodeState(String.valueOf(event.getTheNode().getEnumNodeState()));
			//
			EditWfHandle(wfHandle);
		}
	}
	
	// 强制审批通过 回调
	private void EnforceVeriNodePsd(HbmwfEventObj event,HbmentWf wf) throws SQLException
	{
		HbmentWfHandle wfHandle = GetWfCurHandle(wf.getId(),event.getTheNode().getNodeId());
		//
		if(wfHandle != null)
		{
			wfHandle.setCurrentInd(1);
			wfHandle.setMemo(event.getRparam());
			wfHandle.setNodeState(String.valueOf(event.getTheNode().getEnumNodeState()));
			//
			EditWfHandle(wfHandle);
		}
	}
	
	// 审批通过 回调
	private void VeriPsd(HbmwfEventObj event,HbmentWf wf) throws SQLException
	{
		HbmentWfHandle wfHandle = GetWfCurHandle(wf.getId(),event.getTheNode().getNodeId());
		//
		if(wfHandle != null)
		{
			wfHandle.setCurrentInd(1);
			wfHandle.setMemo(event.getRparam());
			wfHandle.setNodeState(String.valueOf(event.getTheNode().getEnumNodeState()));
			//
			EditWfHandle(wfHandle);
		}
	}
	
	// 审批不通过 回调
	private void VeriNpd(HbmwfEventObj event,HbmentWf wf) throws SQLException
	{
		HbmentWfHandle wfHandle = GetWfCurHandle(wf.getId(),event.getTheNode().getNodeId());
		//
		if(wfHandle != null)
		{
			wfHandle.setCurrentInd(1);
			wfHandle.setMemo(event.getRparam());
			wfHandle.setNodeState(String.valueOf(event.getTheNode().getEnumNodeState()));
			//
			EditWfHandle(wfHandle);
		}
	}
	
	// base
	// 获取流程操作的当前Handles
	public List<HbmentWfHandle> GetWfCurHandles(int wfId) throws SQLException {
		String sql = "SELECT * FROM HBMWF_HANDLE WHERE WFID = ? AND CURRENTIND = 1";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		pre.setInt(1, wfId);
		//
		ResultSet rs = pre.executeQuery();
		//
		List<HbmentWfHandle> rtn = OracleUtil.GetWfHandles(rs);
		//
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}

	// 获取流程操作的当前Handles
	public HbmentWfHandle GetWfCurHandle(int wfId, String nodeId) throws SQLException {
		String sql = "SELECT * FROM HBMWF_HANDLE WHERE WFID = ? AND NODEID = ? AND CURRENTIND = '1'";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		pre.setInt(1, wfId);
		pre.setString(2, nodeId);
		//
		ResultSet rs = pre.executeQuery();
		//
		HbmentWfHandle rtn = OracleUtil.GetWfHandle(rs);
		//
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}

	// 新增流程操作Handle
	public HbmentWfHandle NewWfHandle(HbmentWfHandle wfHandle) throws SQLException {
		String sql = "INSERT INTO HBMWF_HANDLE(ID,WFID,NODEID,NODESTATE,DELIND,CREATETIME,"
				+ "LASTUPDATETIME,CREATEDEPT,CREATEUSER,LASTUPDATEDEPT,LASTUPDATEUSER,CURRENTIND,MEMO,RECEIVERS) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		int newId = HbmwfUtil.NewId("HBMWF_HANDLE");
		pre.setInt(1, newId);
		pre.setInt(2, wfHandle.getWfId());
		pre.setString(3, wfHandle.getNodeId());
		pre.setString(4, wfHandle.getNodeState());
		pre.setInt(5, wfHandle.getDelInd());
		pre.setDate(6, new java.sql.Date(new Date().getTime()));
		pre.setDate(7, new java.sql.Date(new Date().getTime()));
		pre.setString(8, WfCurrentSession.GetDeptId());
		pre.setString(9, WfCurrentSession.GetUserId());
		pre.setString(10, WfCurrentSession.GetDeptId());
		pre.setString(11, WfCurrentSession.GetUserId());
		pre.setInt(12, 1);
		pre.setString(13, wfHandle.getMemo());
		pre.setString(14, wfHandle.getReceivers());
		//
		pre.execute();
		pre.close();
		con.close();
		//
		wfHandle.setId(newId);
		//
		return wfHandle;
	}

	// 编辑流程操作Handle
	public HbmentWfHandle EditWfHandle(HbmentWfHandle wfHandle) throws SQLException {
		String sql = "UPDATE HBMWF_HANDLE SET NODESTATE = ?,CURRENTIND =?,LASTUPDATETIME = ?,LASTUPDATEDEPT = ?,LASTUPDATEUSER = ? WHERE ID = ?";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		pre.setString(1, wfHandle.getNodeState());
		pre.setInt(2, wfHandle.getCurrentInd());
		pre.setDate(3, new java.sql.Date(new Date().getTime()));
		pre.setString(4, wfHandle.getLastUpdateDept());
		pre.setString(5, wfHandle.getLastUpdateUser());
		pre.setInt(6, wfHandle.getId());
		pre.execute();
		//
		//
		return wfHandle;
	}

	// 根据流程编号获取历史操作Handles
	public List<HbmentWfHandle> GetwfHishandles(int wfId) throws SQLException {
		String sql = "SELECT * FROM HBMWF_HANDLE WHERE WFID = ?";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		pre.setInt(1, wfId);
		//
		ResultSet rs = pre.executeQuery();
		//
		List<HbmentWfHandle> rtn = OracleUtil.GetWfHandles(rs);
		//
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}
}
