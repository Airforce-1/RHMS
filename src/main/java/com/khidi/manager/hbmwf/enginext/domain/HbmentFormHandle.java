/**   
* @Title: HbmentFormHandle.java 
* @Package com.khidi.manager.hbm.enginext.domain 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月23日 下午4:24:22 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.enginext.domain;

import java.util.Date;

/**
 * @author Administrator
 *
 */
public class HbmentFormHandle {
	private String formId;
	private int handleId;
	private String readInd;
	private String completedInd;
	private Date readTime;
	private Date completedTime;
	private String readEmpId;
	private String completedEmpId;
	private String currentInd;
	private String dwState;
	private String readDeptId;
	private String completedDeptId;
	private String wfNodeId;
	private String receiverId;
	private String veriDesc;
	private int wfHid;
	private String createUserId;
	private String createDeptId;
	private String createTm;
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
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public String getVeriDesc() {
		return veriDesc;
	}
	public void setVeriDesc(String veriDesc) {
		this.veriDesc = veriDesc;
	}
	public int getWfHid() {
		return wfHid;
	}
	public void setWfHid(int wfHid) {
		this.wfHid = wfHid;
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
