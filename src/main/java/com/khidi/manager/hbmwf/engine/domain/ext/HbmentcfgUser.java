/**   
* @Title: HbmentcfgUser.java 
* @Package com.khidi.manager.hbm.engine.domain.ext 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年12月1日 下午1:47:34 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.domain.ext;

/**
 * @author Administrator
 *
 */
public class HbmentcfgUser {
	// 用户编号
	private String userId;
	// 用户名称
	private String userName;
	// 部门编号
	private String deptId;
	
	private String deptName;
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
}
