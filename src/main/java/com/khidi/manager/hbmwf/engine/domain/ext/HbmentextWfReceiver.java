/**   
* @Title: HbmentextWfReceiver.java 
* @Package com.khidi.manager.hbm.engine.domain.ext 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月22日 上午9:11:22 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.domain.ext;

/**
 * @author Administrator
 *
 */
public class HbmentextWfReceiver {
	// (抽象)接收者编号
	private int id;
	// 部门编号
	private String deptId;
	// 用户编号
	private String userId;
	// 角色编号
	private String roleId;
	// 部门角色编号
	private String deptRoleId;
	// 接收者类型
	private EnumWfReceiverType receiverType;
	//
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getDeptRoleId() {
		return deptRoleId;
	}
	public void setDeptRoleId(String deptRoleId) {
		this.deptRoleId = deptRoleId;
	}
	public EnumWfReceiverType getReceiverType() {
		return receiverType;
	}
	public void setReceiverType(EnumWfReceiverType receiverType) {
		this.receiverType = receiverType;
	}
}
