package com.khidi.manager.hbmwf.engine.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.khidi.manager.hbmwf.engine.domain.HbmentWftmpl;
import com.khidi.manager.hbmwf.engine.domain.HbmentuiWftmpl;
import com.khidi.manager.hbmwf.engine.wfobj.uiFlow.HbmwfuientWfobj;
import com.khidi.manager.hbmwf.engine.wfutil.HbmXml;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.hbmwf.enginext.cfg.WfCurrentSession;

/**
 * 工作流POJO 流程模板
 *
 * @author 王顺波
 * @email 405877884@qq.com
 * @date 2017-11-17 11:02
 */
@Component
@Qualifier("WfTmplDao")
public class WfTmplDao {

	// 新增流程模板
	public HbmentWftmpl NewWftmpl(HbmentuiWftmpl wfTmpl) throws Exception {
		String sql = "INSERT INTO HBMWFTMPL(ID,NAME,THECONTENT,PID,MEMO,LASTUPDATETIME,"
				+ "LASTUPDATEDEPT,LASTUPDATEUSER,CREATETIME,BFLD0," + "CREATEUSER,CREATEDEPT) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		int newId = HbmwfUtil.NewId("HBMWFTMPL");
		pre.setInt(1, newId);
		pre.setString(2, wfTmpl.getName());
		//
		String wftmplContent = HbmXml.GetXml(wfTmpl.getTheContent());
		System.out.println(wftmplContent);
		String wftmplContent01 = HbmwfUtil.encodeBase64(wftmplContent.getBytes());
		//
		pre.setString(3, wftmplContent01);
		pre.setInt(4, wfTmpl.getPid());
		pre.setString(5, wfTmpl.getMemo());
		pre.setDate(6, (java.sql.Date) wfTmpl.getLastUpdateTime());
		pre.setString(7, wfTmpl.getLastUpdateDept());
		pre.setString(8, wfTmpl.getLastUpdateUser());
		pre.setDate(9, wfTmpl.getCreateTime());
		pre.setString(10, wfTmpl.getBfld0());
		pre.setString(11, wfTmpl.getCreateUser());
		pre.setString(12, wfTmpl.getCreateDept());
		//
		pre.execute();
		pre.close();
		con.close();

		HbmentWftmpl rtn = new HbmentWftmpl();
		rtn.setCreateDept(wfTmpl.getCreateDept());
		rtn.setCreateTime(wfTmpl.getCreateTime());
		rtn.setCreateUser(wfTmpl.getCreateUser());
		rtn.setId(newId);
		rtn.setLastUpdateDept(wfTmpl.getLastUpdateDept());
		rtn.setLastUpdateUser(wfTmpl.getLastUpdateUser());
		rtn.setLastUpdateTime(wfTmpl.getLastUpdateTime());
		rtn.setMemo(wfTmpl.getMemo());
		rtn.setName(wfTmpl.getName());
		rtn.setPid(wfTmpl.getPid());
		rtn.setTheContent(wftmplContent);
		//
		return rtn;
	}

	// 编辑流程模板基础信息
	public HbmentWftmpl EditWftmplBase(HbmentWftmpl wfTmpl) throws SQLException {
		String sql = "UPDATE HBMWFTMPL SET NAME = ? ,BFLD0 = ?,MEMO = ? "
				+ ",LASTUPDATETIME = ? ,LASTUPDATEDEPT = ? ,LASTUPDATEUSER = ? WHERE ID = ?";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, wfTmpl.getName());
		pre.setString(2, wfTmpl.getBfld0());
		//
		pre.setString(3, wfTmpl.getMemo());
		java.sql.Date curDt = new java.sql.Date(new Date().getTime());
		pre.setDate(4, curDt);
		pre.setString(5, WfCurrentSession.GetDeptId());
		pre.setString(6, WfCurrentSession.GetUserId());
		pre.setInt(7, wfTmpl.getId());
		//
		pre.execute();
		pre.close();
		con.close();
		//
		return wfTmpl;
	}

	// 编辑流程模板
	public HbmentWftmpl EditWftmpl(HbmentuiWftmpl wfUiTmpl) throws Exception {

		String sql = "UPDATE HBMWFTMPL SET NAME = ?,BFLD0 = ? ,THECONTENT = ? ,MEMO = ? "
				+ ",LASTUPDATETIME = ? ,LASTUPDATEDEPT = ? ,LASTUPDATEUSER = ? WHERE ID = ?";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, wfUiTmpl.getName());
		pre.setString(2, wfUiTmpl.getBfld0());

		String wftmplContent = HbmXml.GetXml(wfUiTmpl.getTheContent());// HbmXml.GetXml(wfTmpl.getTheContent());
		String wftmplContent01 = HbmwfUtil.encodeBase64(wftmplContent.getBytes());
		//
		pre.setString(3, wftmplContent01);
		pre.setString(4, wfUiTmpl.getMemo());
		java.sql.Date curDt = new java.sql.Date(new Date().getTime());
		pre.setDate(5, curDt);
		pre.setString(6, WfCurrentSession.GetDeptId());
		pre.setString(7, WfCurrentSession.GetUserId());
		pre.setInt(8, wfUiTmpl.getId());
		//
		pre.execute();
		pre.close();
		con.close();
		//
		HbmentWftmpl rtn = new HbmentWftmpl();
		rtn.setCreateDept(wfUiTmpl.getCreateDept());
		rtn.setCreateTime(wfUiTmpl.getCreateTime());
		rtn.setCreateUser(wfUiTmpl.getCreateUser());
		rtn.setId(wfUiTmpl.getId());
		rtn.setLastUpdateDept(wfUiTmpl.getLastUpdateDept());
		rtn.setLastUpdateUser(wfUiTmpl.getLastUpdateUser());
		rtn.setLastUpdateTime(wfUiTmpl.getLastUpdateTime());
		rtn.setMemo(wfUiTmpl.getMemo());
		rtn.setName(wfUiTmpl.getName());
		rtn.setPid(wfUiTmpl.getPid());
		rtn.setTheContent(wftmplContent);
		//
		return rtn;
	}

	// 查询流程模板
	public List<HbmentWftmpl> QueryWftmpl(boolean includeContent,String wfType) throws Exception {
		String sql = "SELECT * FROM HBMWFTMPL";
		if(wfType != null && !wfType.equals(""))
		{
			sql = sql + " WHERE BFLD0 = ?"; 
		}
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		if(wfType != null && !wfType.equals(""))
		{
			pre.setString(1, wfType);
		}
		//
		ResultSet rs = pre.executeQuery();
		//
		List<HbmentWftmpl> rtn = OracleUtil.GetWftempInfos(rs, includeContent);
		//
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}

	// 获取流程模板
	public HbmentWftmpl GetWftmpl(int tmplId) throws SQLException {
		String sql = "SELECT * FROM HBMWFTMPL WHERE ID = ?";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		pre.setInt(1, tmplId);
		//
		ResultSet rs = pre.executeQuery();
		//
		HbmentWftmpl rtn = OracleUtil.GetWftempInfo(rs);
		//
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}

	// 删除流程模板
	public boolean DeleteWftmpl(int tmplId) throws SQLException {
		String sql = "DELETE FROM HBMWFTMPL WHERE ID = ?";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		pre.setInt(1, tmplId);
		//
		boolean rtn0 = pre.execute();
		//
		pre.close();
		con.close();
		//
		return rtn0;
	}

}
