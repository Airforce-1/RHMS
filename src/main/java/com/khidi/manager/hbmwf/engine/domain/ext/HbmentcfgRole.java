/**   
* @Title: HbmentcfgRole.java 
* @Package com.khidi.manager.hbm.engine.domain.ext 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年12月2日 上午9:31:29 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.domain.ext;

/**
 * @author Administrator
 *
 */
public class HbmentcfgRole {
	// 角色编号
	private String roleId;
	// 角色名称
	private String roleName;
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
