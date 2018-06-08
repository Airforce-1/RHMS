/**   
* @Title: WfRoleCfg.java 
* @Package com.khidi.manager.hbm.enginext.cfg.receiver 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月22日 上午9:05:42 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.enginext.cfg.receiver;

/**
 * @author Administrator
 *
 */
public class WfRoleCfg {
	private String roleTable;
	private String roleIdField;
	private String roleNameField;
	//
	public String getRoleTable() {
		return roleTable;
	}
	public void setRoleTable(String roleTable) {
		this.roleTable = roleTable;
	}
	public String getRoleIdField() {
		return roleIdField;
	}
	public void setRoleIdField(String roleIdField) {
		this.roleIdField = roleIdField;
	}
	public String getRoleNameField() {
		return roleNameField;
	}
	public void setRoleNameField(String roleNameField) {
		this.roleNameField = roleNameField;
	}

}
