package com.khidi.manager.event.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-29 15:22:47
 */
public class AppeventFbEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
    @ApiModelProperty(value = "编号",dataType="String",required = true,hidden = false)
	private String id;
	//事件编号
    @ApiModelProperty(value = "事件编号",dataType="String",required = true,hidden = false)
	private String eid;
	//反馈人
    @ApiModelProperty(value = "反馈人",dataType="String",required = true,hidden = false)
	private String fbuserid;
	//反馈部门
    @ApiModelProperty(value = "反馈部门",dataType="String",required = true,hidden = false)
	private String fbdeptid;
	//反馈时间
    @ApiModelProperty(value = "反馈时间",dataType="Date",required = true,hidden = false)
	private Date fbtime;
	//反馈内容
    @ApiModelProperty(value = "反馈内容",dataType="String",required = true,hidden = false)
	private String fbcontent;
	//事件流转编号
    @ApiModelProperty(value = "事件流转编号",dataType="String",required = true,hidden = false)
	private String eflowid;
	//删除标识
    @ApiModelProperty(value = "删除标识",dataType="String",required = true,hidden = false)
	private String delind;

	/**
	 * 设置：编号
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：编号
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：事件编号
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}
	/**
	 * 获取：事件编号
	 */
	public String getEid() {
		return eid;
	}
	/**
	 * 设置：反馈人
	 */
	public void setFbuserid(String fbuserid) {
		this.fbuserid = fbuserid;
	}
	/**
	 * 获取：反馈人
	 */
	public String getFbuserid() {
		return fbuserid;
	}
	/**
	 * 设置：反馈部门
	 */
	public void setFbdeptid(String fbdeptid) {
		this.fbdeptid = fbdeptid;
	}
	/**
	 * 获取：反馈部门
	 */
	public String getFbdeptid() {
		return fbdeptid;
	}
	/**
	 * 设置：反馈时间
	 */
	public void setFbtime(Date fbtime) {
		this.fbtime = fbtime;
	}
	/**
	 * 获取：反馈时间
	 */
	public Date getFbtime() {
		return fbtime;
	}
	/**
	 * 设置：反馈内容
	 */
	public void setFbcontent(String fbcontent) {
		this.fbcontent = fbcontent;
	}
	/**
	 * 获取：反馈内容
	 */
	public String getFbcontent() {
		return fbcontent;
	}
	/**
	 * 设置：事件流转编号
	 */
	public void setEflowid(String eflowid) {
		this.eflowid = eflowid;
	}
	/**
	 * 获取：事件流转编号
	 */
	public String getEflowid() {
		return eflowid;
	}
	/**
	 * 设置：删除标识
	 */
	public void setDelind(String delind) {
		this.delind = delind;
	}
	/**
	 * 获取：删除标识
	 */
	public String getDelind() {
		return delind;
	}
}
