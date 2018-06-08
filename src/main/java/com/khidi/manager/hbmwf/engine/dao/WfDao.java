package com.khidi.manager.hbmwf.engine.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.khidi.manager.hbmwf.engine.domain.HbmentWf;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;

/**
 * 工作流DAO  流程
 *
 * @author 王顺波
 * @email 405877884@qq.com
 * @date 2017-11-17 11:02
 */
@Component
@Qualifier("WfDao")
public class WfDao {
	// 新增工作流
	public HbmentWf NewWf(HbmentWf wf) throws SQLException {
		String sql = "INSERT INTO HBMWF(ID,NAME,MEMO,WFCONTENT,WFTMPLID,LASTUPDATETIME,"
				+ "CREATETIME,CREATEUSER,CREATEDEPT," + "LASTUPDATEUSER,LASTUPDATEDEPT,FORMID,FORMTYPE) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		// 
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		int newId = HbmwfUtil.NewId("HBMWF");
		pre.setInt(1, newId);
		pre.setString(2, wf.getName());
		pre.setString(3, wf.getMemo());
		pre.setString(4, wf.getWfContent());
		pre.setInt(5, wf.getWfTmplId());
		pre.setDate(6, new Date(wf.getLastUpdateTime().getTime()));
		pre.setDate(7, new Date(wf.getCreateTime().getTime()));
		pre.setString(8, wf.getCreateUser());
		pre.setString(9, wf.getCreateDept());
		pre.setString(10, wf.getLastUpdateUser());
		pre.setString(11, wf.getLastUpdateDept());
		pre.setString(12, wf.getFormId());
		pre.setString(13, wf.getFormType());
		//
		pre.execute();
		pre.close();
		con.close();
		//
		wf.setId(newId);
		return wf;
	}

	// 编辑工作流
	public HbmentWf EditWf(HbmentWf wf) throws SQLException {
		String sql = "UPDATE HBMWF SET NAME = ?, MEMO = ? ,LASTUPDATETIME = ? ,LASTUPDATEDEPT = ? ,"
				+ "LASTUPDATEUSER = ? WHERE ID = ?";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql);

		pre.setString(1, wf.getName());
		pre.setString(2, wf.getMemo());
		pre.setDate(3, (java.sql.Date) wf.getLastUpdateTime());
		pre.setString(4, wf.getLastUpdateUser());
		pre.setString(5, wf.getLastUpdateDept());
		pre.setString(6, wf.getFormId());
		pre.setString(7, wf.getFormType());
		pre.setInt(8, wf.getId());
		//
		pre.execute();
		pre.close();
		con.close();
		//
		return wf;
	}
	
	// 编辑流程模板内容
	public HbmentWf EditWfContent(HbmentWf wf) throws SQLException {
		String sql = "UPDATE HBMWF SET THECONTENT = ?, WFTMPLID = ? WHERE ID = ?";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql);

		pre.setString(1, wf.getWfContent());
		pre.setInt(2, wf.getWfTmplId());
		pre.setInt(3, wf.getId());
		//
		pre.execute();
		pre.close();
		con.close();
		//
		return wf;
	}
	
	// 编辑工作流
		public boolean DropWf(int wfId) throws SQLException {
			String sql = "DELETE FROM HBMWF WHERE ID = ?";
			//
			Connection con = OracleUtil.GetWfConnection();
			PreparedStatement pre = con.prepareStatement(sql);

			pre.setInt(1, wfId);
			//
			boolean rtn = pre.execute();
			pre.close();
			con.close();
			//
			return rtn;
		}
	
	// 通过表单编号 和 表单类型获取流程信息
	public HbmentWf GetWf(String formId, String formType,boolean includeContent) throws SQLException {
		String sql = "SELECT * FROM HBMWF WHERE FORMID = ? AND FORMTYPE = ?";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, formId);
		pre.setString(2, formType);
		//
		ResultSet rs = pre.executeQuery();
		HbmentWf rtn = OracleUtil.GetWfInfo(rs,includeContent);
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}
	
	// 通过流程编号获取流程信息
	public HbmentWf GetWf(int wfId,boolean includeContent) throws SQLException
	{
		String sql = "SELECT * FROM HBMWF WHERE ID = ?";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setInt(1, wfId);
		//
		ResultSet rs = pre.executeQuery();
		HbmentWf rtn = OracleUtil.GetWfInfo(rs,includeContent);
		//
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}
}
