package com.khidi.manager.officework.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-26 09:39:11
 */
public class MeetingmembersEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//$column.comments
    @ApiModelProperty(value = "编号",dataType="String",required = true,hidden = false)
	private String id;
	//$column.comments
    @ApiModelProperty(value = "所在部门",dataType="String",required = true,hidden = false)
	private String memberOrg;
	//$column.comments
    @ApiModelProperty(value = "姓名",dataType="String",required = true,hidden = false)
	private String memberName;
	//$column.comments
    @ApiModelProperty(value = "表单类型",dataType="String",required = true,hidden = false)
	private String formType;
	//$column.comments
    @ApiModelProperty(value = "表单编号",dataType="String",required = true,hidden = false)
	private String formId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMemberOrg() {
		return memberOrg;
	}
	public void setMemberOrg(String memberOrg) {
		this.memberOrg = memberOrg;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
