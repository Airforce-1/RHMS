/**   
* @Title: WfDeptCfg.java 
* @Package com.khidi.manager.hbm.enginext.cfg.receiver 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月22日 上午9:02:28 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.enginext.cfg.receiver;

/**
 * @author Administrator
 *
 */
public class WfDeptCfg {
	// 部门编号字段 
	private String deptIdField;
	// 部门名称字段
	private String deptNameField;
	// 上级部门字段
	private String deptParentIdField;
	// 部门表名
	private String deptTable;
	//
	public String getDeptIdField() {
		return deptIdField;
	}
	public void setDeptIdField(String deptIdField) {
		this.deptIdField = deptIdField;
	}
	public String getDeptNameField() {
		return deptNameField;
	}
	public void setDeptNameField(String deptNameField) {
		this.deptNameField = deptNameField;
	}
	public String getDeptParentIdField() {
		return deptParentIdField;
	}
	public void setDeptParentIdField(String deptParentIdField) {
		this.deptParentIdField = deptParentIdField;
	}
	public String getDeptTable() {
		return deptTable;
	}
	public void setDeptTable(String deptTable) {
		this.deptTable = deptTable;
	}
}
