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
public class AppentReportEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
    @ApiModelProperty(value = "编号",dataType="String",required = true,hidden = false)
	private String id;
	//事件编号
    @ApiModelProperty(value = "事件编号",dataType="String",required = true,hidden = false)
	private String eid;
	//记录创建时间
    @ApiModelProperty(value = "记录创建时间",dataType="Date",required = true,hidden = false)
	private Date createtime;
	//分组(yyyyMMddHHmmss)
    @ApiModelProperty(value = "分组(yyyyMMddHHmmss)",dataType="String",required = true,hidden = false)
	private String grpid;
	//当前标识
    @ApiModelProperty(value = "当前标识",dataType="String",required = true,hidden = false)
	private String currentind;
	//事件流转编号
    @ApiModelProperty(value = "事件流转编号",dataType="String",required = true,hidden = false)
	private String eflowid;
	//删除标识
    @ApiModelProperty(value = "删除标识",dataType="String",required = true,hidden = false)
	private String delind;
    //事件接收人
    @ApiModelProperty(value = "事件接收人",dataType="String",required = true,hidden = false)
	private String dwuser;

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
	 * 设置：记录创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：记录创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：分组(yyyyMMddHHmmss)
	 */
	public void setGrpid(String grpid) {
		this.grpid = grpid;
	}
	/**
	 * 获取：分组(yyyyMMddHHmmss)
	 */
	public String getGrpid() {
		return grpid;
	}
	/**
	 * 设置：当前标识
	 */
	public void setCurrentind(String currentind) {
		this.currentind = currentind;
	}
	/**
	 * 获取：当前标识
	 */
	public String getCurrentind() {
		return currentind;
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
	/**
	 * 获取：事件接收人
	 */
	public String getDwuser() {
		return dwuser;
	}
	/**
	 * 设置：事件接收人
	 */
	public void setDwuser(String dwuser) {
		this.dwuser = dwuser;
	}
	
}
