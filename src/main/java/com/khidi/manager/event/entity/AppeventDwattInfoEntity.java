package com.khidi.manager.event.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-29 15:22:47
 */
public class AppeventDwattInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//附件编号
    @ApiModelProperty(value = "附件编号",dataType="String",required = true,hidden = false)
	private String attid;
	//事项编号
    @ApiModelProperty(value = "事项编号",dataType="String",required = true,hidden = false)
	private String eid;
	//事件处理编号
    @ApiModelProperty(value = "事件处理编号",dataType="String",required = true,hidden = false)
	private String eclid;
	//附件文件名
    @ApiModelProperty(value = "附件文件名",dataType="String",required = true,hidden = false)
	private String attname;
	//附件文件扩展名
    @ApiModelProperty(value = "附件文件扩展名",dataType="String",required = true,hidden = false)
	private String extname;
	//附件文件相对路径
    @ApiModelProperty(value = "附件文件相对路径",dataType="String",required = true,hidden = false)
	private String attrelativepath;
	//事件流转编号
    @ApiModelProperty(value = "事件流转编号",dataType="String",required = true,hidden = false)
	private String eflowid;

	/**
	 * 设置：附件编号
	 */
	public void setAttid(String attid) {
		this.attid = attid;
	}
	/**
	 * 获取：附件编号
	 */
	public String getAttid() {
		return attid;
	}
	/**
	 * 设置：事项编号
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}
	/**
	 * 获取：事项编号
	 */
	public String getEid() {
		return eid;
	}
	/**
	 * 设置：事件处理编号
	 */
	public void setEclid(String eclid) {
		this.eclid = eclid;
	}
	/**
	 * 获取：事件处理编号
	 */
	public String getEclid() {
		return eclid;
	}
	/**
	 * 设置：附件文件名
	 */
	public void setAttname(String attname) {
		this.attname = attname;
	}
	/**
	 * 获取：附件文件名
	 */
	public String getAttname() {
		return attname;
	}
	/**
	 * 设置：附件文件扩展名
	 */
	public void setExtname(String extname) {
		this.extname = extname;
	}
	/**
	 * 获取：附件文件扩展名
	 */
	public String getExtname() {
		return extname;
	}
	/**
	 * 设置：附件文件相对路径
	 */
	public void setAttrelativepath(String attrelativepath) {
		this.attrelativepath = attrelativepath;
	}
	/**
	 * 获取：附件文件相对路径
	 */
	public String getAttrelativepath() {
		return attrelativepath;
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
}
