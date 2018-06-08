/**   
* @Title: HbmentextWfHandle.java 
* @Package com.khidi.manager.hbm.engine.domain.ext 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月22日 上午9:10:25 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.domain.ext;

import java.sql.Date;

/**
 * @author Administrator
 *
 */
// 流程Handle
public class HbmentextWfHandle {
	// 表单编号
	private String formId;
	// handle编号
	private int handleId;
	// 读取标识
	private String readInd;
	// 完成标识
	private String completedInd;
	// 读取时间
	private Date readTime;
	// 完成时间
	private Date completedTime;
	// 读取者
	private String readEmpId;
	// 完成者
	private String completedEmpId;
	// 是否当前标识
	private String currentInd;
	// 处理状态
	private String dwState;
	// 读取部门
	private String readDeptId;
	// 完成部门
	private String completedDeptId;
	// 流程节点编号
	private String wfNodeId;
	// (抽象)接收者
	private int receiverId;
	// 审批（处理)批示语
	private String veriDesc;
	// 记录创建者
	private String createUserId;
	// 记录创建部门
	private String createDeptId;
	// 创建时间
	private String createTm;
	// 表单类型
	private String formType;
	
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public int getHandleId() {
		return handleId;
	}
	public void setHandleId(int handleId) {
		this.handleId = handleId;
	}
	public String getReadInd() {
		return readInd;
	}
	public void setReadInd(String readInd) {
		this.readInd = readInd;
	}
	public String getCompletedInd() {
		return completedInd;
	}
	public void setCompletedInd(String completedInd) {
		this.completedInd = completedInd;
	}
	public Date getReadTime() {
		return readTime;
	}
	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}
	public Date getCompletedTime() {
		return completedTime;
	}
	public void setCompletedTime(Date completedTime) {
		this.completedTime = completedTime;
	}
	public String getReadEmpId() {
		return readEmpId;
	}
	public void setReadEmpId(String readEmpId) {
		this.readEmpId = readEmpId;
	}
	public String getCompletedEmpId() {
		return completedEmpId;
	}
	public void setCompletedEmpId(String completedEmpId) {
		this.completedEmpId = completedEmpId;
	}
	public String getCurrentInd() {
		return currentInd;
	}
	public void setCurrentInd(String currentInd) {
		this.currentInd = currentInd;
	}
	public String getDwState() {
		return dwState;
	}
	public void setDwState(String dwState) {
		this.dwState = dwState;
	}
	public String getReadDeptId() {
		return readDeptId;
	}
	public void setReadDeptId(String readDeptId) {
		this.readDeptId = readDeptId;
	}
	public String getCompletedDeptId() {
		return completedDeptId;
	}
	public void setCompletedDeptId(String completedDeptId) {
		this.completedDeptId = completedDeptId;
	}
	public String getWfNodeId() {
		return wfNodeId;
	}
	public void setWfNodeId(String wfNodeId) {
		this.wfNodeId = wfNodeId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public String getVeriDesc() {
		return veriDesc;
	}
	public void setVeriDesc(String veriDesc) {
		this.veriDesc = veriDesc;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public String getCreateDeptId() {
		return createDeptId;
	}
	public void setCreateDeptId(String createDeptId) {
		this.createDeptId = createDeptId;
	}
	public String getCreateTm() {
		return createTm;
	}
	public void setCreateTm(String createTm) {
		this.createTm = createTm;
	}
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}
}
