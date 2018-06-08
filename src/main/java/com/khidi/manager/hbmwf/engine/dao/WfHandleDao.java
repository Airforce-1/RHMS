/**   
* @Title: WfHandleDao.java 
* @Package com.khidi.manager.hbm.engine.dao 
* @Description: TODO(工作流的扩展开发部分:  工作流内容Handle) 
* @author 王顺波
* @date 2017年11月23日 下午4:23:10 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.khidi.manager.hbmwf.engine.domain.HbmentWfHandle;
import com.khidi.manager.hbmwf.engine.domain.HbmentWftmpl;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;

@Component
@Qualifier("WfHandleDao")
public class WfHandleDao {
	// 根据handleid获取流程当前handle
	public HbmentWfHandle GetWfHandle(int hdlId) throws SQLException
	{
		String sql = "SELECT * FROM HBMWF_HANDLE WHERE ID = ? AND CURRENTIND = 1";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		pre.setInt(1, hdlId);
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
	public List<HbmentWfHandle> GetWfCurHandles(int wfId, String nodeId) throws SQLException {
		String sql = "SELECT * FROM HBMWF_HANDLE WHERE WFID = ? AND NODEID = ? AND CURRENTIND = 1";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		pre.setInt(1, wfId);
		pre.setString(2, nodeId);
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
		pre.setInt(2, wfHandle.getId());
		pre.setString(3, wfHandle.getNodeId());
		pre.setString(4, wfHandle.getNodeState());
		pre.setInt(5,wfHandle.getDelInd());
		pre.setDate(6, new java.sql.Date(wfHandle.getCreateTime().getTime()));
		pre.setDate(7, new java.sql.Date(wfHandle.getLastUpdateTime().getTime()));
		pre.setString(8, wfHandle.getCreateDept());
		pre.setString(9, wfHandle.getCreateUser());
		pre.setString(10, wfHandle.getLastUpdateDept());
		pre.setString(11, wfHandle.getLastUpdateUser());
		pre.setInt(12, wfHandle.getCurrentInd());
		pre.setString(13,wfHandle.getMemo());
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
		String sql = "UPDATE HBMWF_HANDLE SET NodeState = ?,CurrentInd =?,LastUpdatedTime = ?,LastUpdatedDeptId = ?,LastUpdatedEmpId = ? WHERE WfHid = ?";
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
	public List<HbmentWfHandle> GetwfHishandles(int wfId) throws SQLException
	{		
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
