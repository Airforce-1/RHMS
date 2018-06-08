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
public class AppeventStepsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
    @ApiModelProperty(value = "编号",dataType="String",required = true,hidden = false)
	private String id;
	//事件流转类型
    @ApiModelProperty(value = "事件流转类型",dataType="String",required = true,hidden = false)
	private String esteptype;
	//上报编号
    @ApiModelProperty(value = "上报编号",dataType="String",required = true,hidden = false)
	private String reportid;
	//委派编号
    @ApiModelProperty(value = "委派编号",dataType="String",required = true,hidden = false)
	private String wpId;
	//委派核实编号
    @ApiModelProperty(value = "委派核实编号",dataType="String",required = true,hidden = false)
	private String wpHsId;
	//处理编号
    @ApiModelProperty(value = "处理编号",dataType="String",required = true,hidden = false)
	private String clid;
	//事件记录时间
    @ApiModelProperty(value = "事件记录时间",dataType="Date",required = true,hidden = false)
	private Date createtime;
	//事件编号
    @ApiModelProperty(value = "事件编号",dataType="String",required = true,hidden = false)
	private String eid;
	//分组(yyyyMMddHHmmss)
    @ApiModelProperty(value = "分组(yyyyMMddHHmmss)",dataType="String",required = true,hidden = false)
	private String grpid;

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
	 * 设置：事件流转类型
	 */
	public void setEsteptype(String esteptype) {
		this.esteptype = esteptype;
	}
	/**
	 * 获取：事件流转类型
	 */
	public String getEsteptype() {
		return esteptype;
	}
	/**
	 * 设置：上报编号
	 */
	public void setReportid(String reportid) {
		this.reportid = reportid;
	}
	/**
	 * 获取：上报编号
	 */
	public String getReportid() {
		return reportid;
	}
	/**
	 * 设置：委派编号
	 */
	public void setWpId(String wpId) {
		this.wpId = wpId;
	}
	/**
	 * 获取：委派编号
	 */
	public String getWpId() {
		return wpId;
	}
	/**
	 * 设置：委派核实编号
	 */
	public void setWpHsId(String wpHsId) {
		this.wpHsId = wpHsId;
	}
	/**
	 * 获取：委派核实编号
	 */
	public String getWpHsId() {
		return wpHsId;
	}
	/**
	 * 设置：处理编号
	 */
	public void setClid(String clid) {
		this.clid = clid;
	}
	/**
	 * 获取：处理编号
	 */
	public String getClid() {
		return clid;
	}
	/**
	 * 设置：事件记录时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：事件记录时间
	 */
	public Date getCreatetime() {
		return createtime;
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
}
