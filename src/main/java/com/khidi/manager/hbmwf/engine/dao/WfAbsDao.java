/**   
* @Title: WfAbsDao.java 
* @Package com.khidi.manager.hbm.engine.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年12月4日 下午4:51:05 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.khidi.manager.hbmwf.engine.domain.ext.EnumWfReceiverType;
import com.khidi.manager.hbmwf.engine.domain.ext.HbmentextWfReceiver;
import com.khidi.manager.hbmwf.engine.wfobj.uiFlow.HbmentAbsForui;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;

/**
 * @author Administrator
 *
 */
@Component
@Qualifier("WfAbsDao")
public class WfAbsDao {
	
	// 把角色列表转换为","分割的字符串
	public String GetRoleStrByList(List<Integer> roleIds) {
		//
		String rtn = HbmwfUtil.GetStrByIntlist(roleIds);
		return rtn;
	}

	// 查询接收者
	public List<HbmentextWfReceiver> QueryReceivers(int[] receiverIds) throws SQLException {
		if (receiverIds == null || receiverIds.length == 0) {
			return null;
		}
		String partSql = HbmwfUtil.GetStrByIntarray(receiverIds);
		//
		String sql = String.format("SELECT * FROM HBMWFABS WHERE ABSRECEIVERID IN(%s)", partSql);
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		//
		ResultSet rs = pre.executeQuery();
		//
		List<HbmentextWfReceiver> rtn = OracleUtil.GetWfAbsInfos(rs);
		//
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}

	// 查询接收者
	public List<HbmentextWfReceiver> GetAbsReceivers(String receiverIds) throws SQLException {
		//
		String sql = String.format("SELECT * FROM HBMWFABS WHERE ABSRECEIVERID IN(%s)", receiverIds);
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		//
		ResultSet rs = pre.executeQuery();
		//
		List<HbmentextWfReceiver> rtn = OracleUtil.GetWfAbsInfos(rs);
		//
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}

	// 根据id获取 接收者
	public HbmentextWfReceiver GetAbsReceiver(int id) throws SQLException {
		String sql = "SELECT * FROM HBMWFABS WHERE ABSRECEIVERID = ?";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		pre.setInt(1, id);
		//
		ResultSet rs = pre.executeQuery();
		//
		HbmentextWfReceiver rtn = OracleUtil.GetWfAbsInfo(rs);
		//
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}

	// 根据接收者信息查询接收者
	public HbmentextWfReceiver GetAbsReceiver(HbmentextWfReceiver unknownReceiver) throws SQLException {
		// EM, DE, RO, DER
		String theReceiverType = unknownReceiver.getReceiverType().toString();
		switch (theReceiverType) {
		case "EM":
			return _GetEmReceiver(unknownReceiver);
		case "DE":
			return _GetDeReceiver(unknownReceiver);
		case "RO":
			return _GetRoReceiver(unknownReceiver);
		case "DER":
			return _GetDerReceiver(unknownReceiver);
		default:
			break;
		}
		return null;
	}
	
	// 获取部门接收者
	private HbmentextWfReceiver _GetDeReceiver(HbmentextWfReceiver unknownReceiver) throws SQLException
	{
		String sql0 = "SELECT * FROM HBMWFABS WHERE DEPTID = ? AND RECEIVERTYPECODE = ?";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql0); //
		pre.setString(1, unknownReceiver.getDeptId());
		pre.setString(2, EnumWfReceiverType.RO.toString());
		
		ResultSet rs = pre.executeQuery();
		HbmentextWfReceiver rtn0 = OracleUtil.GetWfAbsInfo(rs);
		rs.close();
		pre.close();
		con.close();
		
		if(rtn0 == null)
		{
			//
			return __NewDeReceiver(unknownReceiver);
		}
		else
		{
			return rtn0;
		}
	}
	
	// 获取部门角色接收者
	private HbmentextWfReceiver _GetDerReceiver(HbmentextWfReceiver unknownReceiver) throws SQLException
	{
		String sql0 = "SELECT * FROM HBMWFABS WHERE DEPTID = ? AND DEPTROLEID = ? AND RECEIVERTYPECODE = ?";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql0); //
		pre.setString(1, unknownReceiver.getDeptId());
		pre.setString(2, unknownReceiver.getDeptRoleId());
		pre.setString(3, EnumWfReceiverType.RO.toString());
		
		ResultSet rs = pre.executeQuery();
		HbmentextWfReceiver rtn0 = OracleUtil.GetWfAbsInfo(rs);
		rs.close();
		pre.close();
		con.close();
		
		if(rtn0 == null)
		{
			//
			return __NewDerReceiver(unknownReceiver);
		}
		else
		{
			return rtn0;
		}
	}
	
	// 获取角色接收者
	private HbmentextWfReceiver _GetRoReceiver(HbmentextWfReceiver unknownReceiver) throws SQLException
	{
		String sql0 = "SELECT * FROM HBMWFABS WHERE ROLEID = ? AND RECEIVERTYPECODE = ?";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql0); //
		pre.setString(1, unknownReceiver.getRoleId());
		pre.setString(2, EnumWfReceiverType.RO.toString());
		
		ResultSet rs = pre.executeQuery();
		HbmentextWfReceiver rtn0 = OracleUtil.GetWfAbsInfo(rs);
		rs.close();
		pre.close();
		con.close();
		
		if(rtn0 == null)
		{
			//
			return __NewRoReceiver(unknownReceiver);
		}
		else
		{
			return rtn0;
		}
	}
	
	// 获取人员接收者
	private HbmentextWfReceiver _GetEmReceiver(HbmentextWfReceiver unknownReceiver) throws SQLException
	{
		String sql0 = "SELECT * FROM HBMWFABS WHERE DEPTID = ? AND EMPID = ? AND RECEIVERTYPECODE = ?";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql0); //
		pre.setString(1, unknownReceiver.getDeptId());
		pre.setString(2, unknownReceiver.getUserId());
		pre.setString(3, EnumWfReceiverType.EM.toString());
		
		ResultSet rs = pre.executeQuery();
		HbmentextWfReceiver rtn0 = OracleUtil.GetWfAbsInfo(rs);
		rs.close();
		pre.close();
		con.close();
		
		if(rtn0 == null)
		{
			//
			return __NewEmReceiver(unknownReceiver);
		}
		else
		{
			return rtn0;
		}
	}
	
	// 新建部门接收者
	private HbmentextWfReceiver __NewDeReceiver(HbmentextWfReceiver unknownReceiver) throws SQLException
	{
		String sql = "INSERT INTO HBMWFABS(ABSRECEIVERID,DEPTID,RECEIVERTYPECODE) VALUES(?,?,?)";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		int newId = HbmwfUtil.NewId("HBMWFABS");
		pre.setInt(1, newId);
		pre.setString(2, unknownReceiver.getDeptId());
		pre.setString(3, unknownReceiver.getReceiverType().toString());
		//
		boolean rtn = pre.execute();
		//
		//
		pre.close();
		con.close();
		//
		unknownReceiver.setId(newId);
		unknownReceiver.setReceiverType(EnumWfReceiverType.DE);
		return unknownReceiver;
	}
	
	// 新建人员接收者
	private HbmentextWfReceiver __NewEmReceiver(HbmentextWfReceiver unknownReceiver) throws SQLException
	{
		String sql = "INSERT INTO HBMWFABS(ABSRECEIVERID,DEPTID,EMPID,RECEIVERTYPECODE) VALUES(?,?,?,?)";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		int newId = HbmwfUtil.NewId("HBMWFABS");
		pre.setInt(1, newId);
		pre.setString(2, unknownReceiver.getDeptId());
		pre.setString(3, unknownReceiver.getUserId());
		pre.setString(4, unknownReceiver.getReceiverType().toString());
		//
		boolean rtn = pre.execute();
		//
		//
		pre.close();
		con.close();
		//
		unknownReceiver.setId(newId);
		unknownReceiver.setReceiverType(EnumWfReceiverType.EM);
		return unknownReceiver;
	}
	
	// 新建角色接收者
	private HbmentextWfReceiver __NewRoReceiver(HbmentextWfReceiver unknownReceiver) throws SQLException
	{
		String sql = "INSERT INTO HBMWFABS(ABSRECEIVERID,ROLEID,RECEIVERTYPECODE) VALUES(?,?,?)";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		int newId = HbmwfUtil.NewId("HBMWFABS");
		pre.setInt(1, newId);
		pre.setString(2, unknownReceiver.getRoleId());
		pre.setString(3, unknownReceiver.getReceiverType().toString());
		//
		boolean rtn = pre.execute();
		//
		//
		pre.close();
		con.close();
		//
		unknownReceiver.setId(newId);
		unknownReceiver.setReceiverType(EnumWfReceiverType.RO);
		return unknownReceiver;
	}
	
	// 新建部门角色接收者
	private HbmentextWfReceiver __NewDerReceiver(HbmentextWfReceiver unknownReceiver) throws SQLException
	{
		String sql = "INSERT INTO HBMWFABS(ABSRECEIVERID,DEPTID,DEPTROLEID,RECEIVERTYPECODE) VALUES(?,?,?,?)";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		int newId = HbmwfUtil.NewId("HBMWFABS");
		pre.setInt(1, newId);
		pre.setString(2, unknownReceiver.getDeptId());
		pre.setString(3, unknownReceiver.getDeptRoleId());
		pre.setString(4, unknownReceiver.getReceiverType().toString());
		//
		boolean rtn = pre.execute();
		//
		//
		pre.close();
		con.close();
		//
		unknownReceiver.setId(newId);
		unknownReceiver.setReceiverType(EnumWfReceiverType.DER);
		return unknownReceiver;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
