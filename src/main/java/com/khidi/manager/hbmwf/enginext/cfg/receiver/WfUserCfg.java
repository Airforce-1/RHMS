/**   
* @Title: WfUserCfg.java 
* @Package com.khidi.manager.hbm.enginext.cfg.receiver 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月22日 上午9:07:35 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.enginext.cfg.receiver;

/**
 * @author Administrator
 *
 */
public class WfUserCfg {
	private String userTableName;
	private String userIdField;
	private String userNameField;
	private String deptIdField;
	
	
	public String getUserTableName() {
		return userTableName;
	}
	public void setUserTableName(String userTableName) {
		this.userTableName = userTableName;
	}
	public String getUserIdField() {
		return userIdField;
	}
	public void setUserIdField(String userIdField) {
		this.userIdField = userIdField;
	}
	public String getUserNameField() {
		return userNameField;
	}
	public void setUserNameField(String userNameField) {
		this.userNameField = userNameField;
	}
	public String getDeptIdField() {
		return deptIdField;
	}
	public void setDeptIdField(String deptIdField) {
		this.deptIdField = deptIdField;
	}
}
