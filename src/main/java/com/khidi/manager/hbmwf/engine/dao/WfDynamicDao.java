/**   
* @Title: WfDynamicDao.java 
* @Package com.khidi.manager.hbm.engine.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月23日 下午1:53:17 
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

import com.khidi.manager.hbmwf.engine.domain.ext.HbmentcfgDept;
import com.khidi.manager.hbmwf.engine.domain.ext.HbmentcfgRole;
import com.khidi.manager.hbmwf.engine.domain.ext.HbmentcfgUser;
import com.khidi.manager.hbmwf.engine.domain.ext.HbmentextWfReceiver;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.hbmwf.enginext.cfg.receiver.WfDeptCfg;
import com.khidi.manager.hbmwf.enginext.cfg.receiver.WfRoleCfg;
import com.khidi.manager.hbmwf.enginext.cfg.receiver.WfUserCfg;
import com.khidi.manager.hbmwf.enginext.domain.HbmentDynamicForm;

/**
 * @author 王顺波
 *
 */
@Component
@Qualifier("WfDynamicDao")
public class WfDynamicDao {
	// 编辑流程操作Handle
	public boolean UpdateDynamicFormState(HbmentDynamicForm dynamicForm, String state) throws SQLException {
		String sql = String.format("UPDATE %s SET %s = ? WHERE %s = ?", dynamicForm.getFormCfg().getFormTable(),
				dynamicForm.getFormCfg().getStateFieldName(), dynamicForm.getFormCfg().getPkFieldName());
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		pre.setString(1, state);
		pre.setString(2, dynamicForm.getFormId());
		boolean rtn = pre.execute();
		//
		pre.close();
		con.close();
		//
		return rtn;
	}

	// 获取表单状态
	public String GetDynamicFormState(HbmentDynamicForm dynamicForm) throws SQLException {
		String sql = String.format("SELECT %s FROM %s WHERE %s = ?", dynamicForm.getFormCfg().getStateFieldName(),
				dynamicForm.getFormCfg().getFormTable(), dynamicForm.getFormCfg().getPkFieldName());
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		pre.setString(1, dynamicForm.getFormId());
		ResultSet rs = pre.executeQuery();
		//
		String rtn = OracleUtil.getSingleValue(rs);
		//
		pre.close();
		con.close();
		//
		return rtn;
	}

	// 读取流程相关用户信息
	public List<HbmentcfgUser> QueryUserInfo(WfUserCfg userCfg, WfDeptCfg deptCfg) throws SQLException {
		String sql = String.format("SELECT a.*,b.%s AS DEPTNAME FROM %s a,%s b WHERE a.%s = " + "b.%s",
				deptCfg.getDeptNameField(), userCfg.getUserTableName(), deptCfg.getDeptTable(),
				userCfg.getDeptIdField(), deptCfg.getDeptIdField());
		// String sql = String.format("SELECT %s,%s,%s FROM %s",
		// userCfg.getUserIdField(), userCfg.getUserNameField(),
		// userCfg.getDeptIdField(), userCfg.getUserTableName());
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		ResultSet rs = pre.executeQuery();
		//
		System.out.println(sql);
		List<HbmentcfgUser> rtn = OracleUtil.GetCfgUserInfos(rs, userCfg, deptCfg);
		//
		pre.close();
		con.close();
		//
		return rtn;
	}

	// 读取流程相关用户信息
	public List<HbmentcfgUser> QueryUserInfo(WfUserCfg userCfg, WfDeptCfg deptCfg, String deptId) throws SQLException {
		String sql = String.format("SELECT a.*,b.%s AS DEPTNAME FROM %s a,%s b WHERE a.%s = " + "b.%s AND a.%s = ?",
				deptCfg.getDeptNameField(), userCfg.getUserTableName(), deptCfg.getDeptTable(),
				userCfg.getDeptIdField(), deptCfg.getDeptIdField(), userCfg.getDeptIdField());
		// String sql = String.format("SELECT %s,%s,%s FROM %s WHERE %s = ?",
		// userCfg.getUserIdField(),
		// userCfg.getUserNameField(), userCfg.getDeptIdField(),
		// userCfg.getUserTableName(),
		// userCfg.getDeptIdField());
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		pre.setString(1, "deptId");
		System.out.println(sql);
		ResultSet rs = pre.executeQuery();
		//
		List<HbmentcfgUser> rtn = OracleUtil.GetCfgUserInfos(rs, userCfg, deptCfg);
		//
		pre.close();
		con.close();
		//
		return rtn;
	}

	// 读取流程相关用户信息
	public List<HbmentcfgUser> QueryUserInfo(WfUserCfg userCfg, WfDeptCfg deptCfg, String deptId, String userName)
			throws SQLException {
		String sql = String.format("SELECT a.*,b.%s AS DEPTNAME FROM %s a,%s b WHERE a.%s = " + "b.%s",
				deptCfg.getDeptNameField(), userCfg.getUserTableName(), deptCfg.getDeptTable(),
				userCfg.getDeptIdField(), deptCfg.getDeptIdField());
		if (deptId != null && deptId.equals("") != true) {
			sql += String.format(" AND a.%s = '%s'", deptCfg.getDeptIdField(), deptId);
		}
		if (userName != null && userName.equals("") != true) {
			sql += String.format(" AND a.%s = '%s'", userCfg.getUserNameField(), userName);
		}
		//
		//
		// sql = String.format("SELECT %s,%s,%s FROM %s WHERE %s = ?",
		// userCfg.getUserIdField(),
		// userCfg.getUserNameField(), userCfg.getDeptIdField(),
		// userCfg.getUserTableName(),
		// userCfg.getDeptIdField());
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		ResultSet rs = pre.executeQuery();
		//
		List<HbmentcfgUser> rtn = OracleUtil.GetCfgUserInfos(rs, userCfg, deptCfg);
		//
		pre.close();
		con.close();
		//
		return rtn;
	}

	// 读取一条用户信息xxxx
	public HbmentcfgUser GetUserInfo(WfUserCfg userCfg, WfDeptCfg deptCfg, String userId) throws SQLException {
		String sql = String.format("SELECT a.*,b.%s AS DEPTNAME FROM %s a,%s b WHERE a.%s = " + "b.%s AND a.%s = ?",
				deptCfg.getDeptNameField(), userCfg.getUserTableName(), deptCfg.getDeptTable(),
				userCfg.getDeptIdField(), deptCfg.getDeptIdField(), userCfg.getUserIdField());

		// String sql = String.format("SELECT %s,%s,%s,%s FROM %s WHERE %s = ?",
		// userCfg.getUserIdField(),
		// userCfg.getUserNameField(), userCfg.getDeptIdField(),
		// userCfg.getUserTableName(),
		// userCfg.getUserIdField());
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		pre.setString(1, userId);
		ResultSet rs = pre.executeQuery();
		//
		HbmentcfgUser rtn = OracleUtil.GetCfgUserInfo(rs, userCfg, deptCfg);
		//
		pre.close();
		con.close();
		//
		return rtn;
	}

	// 查询部门信息
	public List<HbmentcfgDept> QueryDeptInfo(WfDeptCfg deptCfg) throws SQLException {
		String sql = String.format("SELECT %s,%s,%s FROM %s", deptCfg.getDeptIdField(), deptCfg.getDeptNameField(),
				deptCfg.getDeptParentIdField(), deptCfg.getDeptTable());
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		ResultSet rs = pre.executeQuery();
		//
		List<HbmentcfgDept> rtn = OracleUtil.GetCfgDeptInfos(rs, deptCfg);
		//
		pre.close();
		con.close();
		//
		return rtn;
	}

	// 读取一条部门信息
	public HbmentcfgDept GetDeptInfo(WfDeptCfg deptCfg, String deptId) throws SQLException {
		String sql = String.format("SELECT %s,%s,%s FROM %s WHERE %s = ?", deptCfg.getDeptIdField(),
				deptCfg.getDeptNameField(), deptCfg.getDeptParentIdField(), deptCfg.getDeptTable(),
				deptCfg.getDeptIdField());
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		pre.setString(1, deptId);
		ResultSet rs = pre.executeQuery();
		//
		HbmentcfgDept rtn = OracleUtil.GetCfgDeptInfo(rs, deptCfg);
		//
		pre.close();
		con.close();
		//
		return rtn;
	}

	// 查询角色信息
	public List<HbmentcfgRole> QueryRoleInfo(WfRoleCfg roleCfg) throws SQLException {
		String sql = String.format("SELECT %s,%s FROM %s", roleCfg.getRoleIdField(), roleCfg.getRoleNameField(),
				roleCfg.getRoleTable());
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		ResultSet rs = pre.executeQuery();
		//
		List<HbmentcfgRole> rtn = OracleUtil.GetCfgRoleInfos(rs, roleCfg);
		//
		pre.close();
		con.close();
		//
		return rtn;
	}

	// 读取一条角色信息
	public HbmentcfgRole GetRoleInfo(WfRoleCfg roleCfg, String roleId) throws SQLException {
		String sql = String.format("SELECT %s,%s FROM %s WHERE %s = ?", roleCfg.getRoleIdField(),
				roleCfg.getRoleNameField(), roleCfg.getRoleTable(), roleCfg.getRoleIdField());
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		pre.setString(1, roleId);
		ResultSet rs = pre.executeQuery();
		//
		HbmentcfgRole rtn = OracleUtil.GetCfgRoleInfo(rs, roleCfg);
		//
		pre.close();
		con.close();
		//
		return rtn;
	}
}
