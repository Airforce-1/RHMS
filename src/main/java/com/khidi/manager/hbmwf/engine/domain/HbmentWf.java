package com.khidi.manager.hbmwf.engine.domain;



import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
/**
 * 工作流POJO  流程
 *
 * @author 王顺波
 * @email 405877884@qq.com
 * @date 2017-11-17 11:02
 */
public class HbmentWf {
	@ApiModelProperty(value = "流程编号", required = true,hidden = false)
	private int id;
	@ApiModelProperty(value = "名称", required = true,hidden = false)
	private String name;
	@ApiModelProperty(value = "描述", required = true,hidden = false)
	private String memo;
	@ApiModelProperty(value = "工作流内容", required = true,hidden = false)
	private String wfContent;
	@ApiModelProperty(value = "模版编号", required = true,hidden = false)
	private int wfTmplId;
	@ApiModelProperty(value = "最后更新时间", required = true,hidden = false)
	private Date lastUpdateTime;
	@ApiModelProperty(value = "创建时间", required = true,hidden = false)
	private Date createTime;
	@ApiModelProperty(value = "创建者", required = true,hidden = false)
	private String createUser;
	@ApiModelProperty(value = "创建部门", required = true,hidden = false)
	private String createDept;
	@ApiModelProperty(value = "最后更新者", required = true,hidden = false)
	private String lastUpdateUser;
	@ApiModelProperty(value = "最后更新部门", required = true,hidden = false)
	private String lastUpdateDept;
	@ApiModelProperty(value = "表单编号", required = true,hidden = false)
	private String formId;
	@ApiModelProperty(value = "表单类型", required = true,hidden = false)
	private String formType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getWfContent() {
		return wfContent;
	}
	public void setWfContent(String wfContent) {
		this.wfContent = wfContent;
	}
	public int getWfTmplId() {
		return wfTmplId;
	}
	public void setWfTmplId(int wfTmplId) {
		this.wfTmplId = wfTmplId;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date date) {
		this.createTime = date;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getCreateDept() {
		return createDept;
	}
	public void setCreateDept(String createDept) {
		this.createDept = createDept;
	}
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}
	public String getLastUpdateDept() {
		return lastUpdateDept;
	}
	public void setLastUpdateDept(String lastUpdateDept) {
		this.lastUpdateDept = lastUpdateDept;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}
}
