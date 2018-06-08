/**   
* @Title: Form1Dao.java 
* @Package com.khidi.manager.hbm.engine.dao 
* @Description: TODO(流程测试用表单) 
* @author 王顺波
* @date 2017年11月22日 下午2:17:29 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.khidi.manager.hbmwf.engine.domain.HbmentWftmpl;
import com.khidi.manager.hbmwf.engine.domain.tst.HbmentForm1;
import com.khidi.manager.hbmwf.engine.wfutil.HbmXml;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;

/**
 * @author Administrator
 *
 */
@Component
@Qualifier("Form1Dao")
public class Form1Dao {
	// 新增测试表单1数据
	public HbmentForm1 NewForm1(HbmentForm1 form1) throws SQLException {
		String sql = "INSERT INTO HBMTESTFORM1(ID,NAME,THECONTENT,STATE,KX) " + "VALUES(?,?,?,'NB',?)";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		int newId = HbmwfUtil.NewId("HBMTESTFORM1");
		pre.setInt(1, newId);
		pre.setString(2, form1.getName());
		//
		pre.setString(3, form1.getContent());
		
		pre.setDouble(4,form1.getKx());
		//
		pre.execute();
		pre.close();
		con.close();
		form1.setId(newId);
		//
		return form1;
	}

	// 编辑测试表单1数据
	public HbmentForm1 EditForm1(HbmentForm1 form1) throws SQLException {
		String sql = "UPDATE HBMTESTFORM1 SET NAME = ?,THECONTENT = ? ,KX = ? WHERE ID = ?";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, form1.getName());
		pre.setString(2, form1.getContent());
		//
		pre.setDouble(3, form1.getKx());
		pre.setInt(4, form1.getId());
		//
		pre.execute();
		pre.close();
		con.close();
		//
		return form1;
	}

	// 读取表单数据
	public HbmentForm1 GetForm(int formId) throws SQLException {
		String sql = "SELECT * FROM HBMTESTFORM1 WHERE ID = ?";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setInt(1, formId);
		ResultSet rs = pre.executeQuery();
		//
		HbmentForm1 rtn = OracleUtil.GetForm1(rs);
		//
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}

	// 查询测试表单数据
	public List<HbmentForm1> QueryForms() throws SQLException {
		String sql = "SELECT * FROM HBMTESTFORM1";
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		ResultSet rs = pre.executeQuery();
		//
		List<HbmentForm1> rtn = OracleUtil.GetForm1s(rs);
		//
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}
}
