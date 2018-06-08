/**   
* @Title: HbmentcfgDept.java 
* @Package com.khidi.manager.hbm.engine.domain.ext 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年12月2日 上午9:27:31 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.domain.ext;

/**
 * @author Administrator
 *
 */
public class HbmentcfgDept {
// 部门编号
private String deptId;
// 部门名称
private String deptName;
// 父级部门名称
private String deptParentid;

public String getDeptId() {
	return deptId;
}
public void setDeptId(String deptId) {
	this.deptId = deptId;
}
public String getDeptName() {
	return deptName;
}
public void setDeptName(String deptName) {
	this.deptName = deptName;
}
public String getDeptParentid() {
	return deptParentid;
}
public void setDeptParentid(String deptParentid) {
	this.deptParentid = deptParentid;
}
}
