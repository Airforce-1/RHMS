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
public class MeetingattachEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//$column.comments
    @ApiModelProperty(value = "$column.comments",dataType="String",required = true,hidden = false)
	private String formid;
	//$column.comments
    @ApiModelProperty(value = "$column.comments",dataType="String",required = true,hidden = false)
	private String nodeid;
	//$column.comments
    @ApiModelProperty(value = "$column.comments",dataType="String",required = true,hidden = false)
	private String formtype;
	//$column.comments
    @ApiModelProperty(value = "$column.comments",dataType="String",required = true,hidden = false)
	private String attachid;
	//$column.comments
    @ApiModelProperty(value = "$column.comments",dataType="String",required = true,hidden = false)
	private String attachname;
	//$column.comments
    @ApiModelProperty(value = "$column.comments",dataType="String",required = true,hidden = false)
	private String attachfilepath;
	//$column.comments
    @ApiModelProperty(value = "$column.comments",dataType="String",required = true,hidden = false)
	private String nodeflag;

	/**
	 * 设置：${column.comments}
	 */
	public void setFormid(String formid) {
		this.formid = formid;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getFormid() {
		return formid;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getNodeid() {
		return nodeid;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setFormtype(String formtype) {
		this.formtype = formtype;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getFormtype() {
		return formtype;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setAttachid(String attachid) {
		this.attachid = attachid;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getAttachid() {
		return attachid;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setAttachname(String attachname) {
		this.attachname = attachname;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getAttachname() {
		return attachname;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setAttachfilepath(String attachfilepath) {
		this.attachfilepath = attachfilepath;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getAttachfilepath() {
		return attachfilepath;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setNodeflag(String nodeflag) {
		this.nodeflag = nodeflag;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getNodeflag() {
		return nodeflag;
	}
}
