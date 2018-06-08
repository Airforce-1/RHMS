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
public class AppeventAttinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
    @ApiModelProperty(value = "编号",dataType="String",required = true,hidden = false)
	private String id;
	//事件编号
    @ApiModelProperty(value = "事件编号",dataType="String",required = true,hidden = false)
	private String eid;
	//附件文件名
    @ApiModelProperty(value = "附件文件名",dataType="String",required = true,hidden = false)
	private String attname;
	//附件文件扩展名
    @ApiModelProperty(value = "附件文件扩展名",dataType="String",required = true,hidden = false)
	private String attext;
	//附件文件相对路径
    @ApiModelProperty(value = "附件文件相对路径",dataType="String",required = true,hidden = false)
	private String attrelativepath;
	//附件编号(与附件表对应)
    @ApiModelProperty(value = "附件编号(与附件表对应)",dataType="String",required = true,hidden = false)
	private String attid;

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
	public void setAttext(String attext) {
		this.attext = attext;
	}
	/**
	 * 获取：附件文件扩展名
	 */
	public String getAttext() {
		return attext;
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
	 * 设置：附件编号(与附件表对应)
	 */
	public void setAttid(String attid) {
		this.attid = attid;
	}
	/**
	 * 获取：附件编号(与附件表对应)
	 */
	public String getAttid() {
		return attid;
	}
}
