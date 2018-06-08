/**   
* @Title: WfDeptMemberCfg.java 
* @Package com.khidi.manager.hbm.enginext.cfg.receiver 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月22日 上午9:04:34 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.enginext.cfg.receiver;

/**
 * @author Administrator
 *
 */
public class WfDeptMemberCfg {
	// 部门成员表名
	private String deptMemberTable;
	// 部门成员用户编号字段
	private String deptMemberUserIdField;
	// 部门成员部门编号字段
	private String deptMemberDeptIdField;
	
	public String getDeptMemberTable() {
		return deptMemberTable;
	}
	public void setDeptMemberTable(String deptMemberTable) {
		this.deptMemberTable = deptMemberTable;
	}
	public String getDeptMemberUserIdField() {
		return deptMemberUserIdField;
	}
	public void setDeptMemberUserIdField(String deptMemberUserIdField) {
		this.deptMemberUserIdField = deptMemberUserIdField;
	}
	public String getDeptMemberDeptIdField() {
		return deptMemberDeptIdField;
	}
	public void setDeptMemberDeptIdField(String deptMemberDeptIdField) {
		this.deptMemberDeptIdField = deptMemberDeptIdField;
	}

	//
}
