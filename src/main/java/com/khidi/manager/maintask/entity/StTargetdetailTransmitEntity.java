package com.khidi.manager.maintask.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-03 10:29:04
 */
public class StTargetdetailTransmitEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//转发部门
	@ApiModelProperty(value = "转发部门",dataType="unknowType",required = true,hidden = false)
	private String transmitDeptid;
	//转发者
	@ApiModelProperty(value = "转发者",dataType="unknowType",required = true,hidden = false)
	private String transmitUserid;
	//撤销标识
	@ApiModelProperty(value = "撤销标识",dataType="unknowType",required = true,hidden = false)
	private String delind;
	//目标明细编号
    @ApiModelProperty(value = "目标明细编号",dataType="String",required = true,hidden = false)
	private String targetdetailid;
	//目标编号
    @ApiModelProperty(value = "目标编号",dataType="String",required = true,hidden = false)
	private String targetid;
	//目标类型
    @ApiModelProperty(value = "目标类型",dataType="String",required = true,hidden = false)
	private String targettype;
	//转发时间
    @ApiModelProperty(value = "转发时间",dataType="Date",required = true,hidden = false)
	private Date zftime;
	//转发到部门
    @ApiModelProperty(value = "转发到部门",dataType="String",required = true,hidden = false)
	private String todeptid;
	//编号
    @ApiModelProperty(value = "编号",dataType="String",required = true,hidden = false)
	private String id;

	//转发部门
	@ApiModelProperty(value = "转发部门",dataType="unknowType",required = true,hidden = false)
	private String transmitDeptName;
	//转发到部门
	@ApiModelProperty(value = "转发到部门",dataType="String",required = true,hidden = false)
	private String todeptName;

	public String getTransmitDeptName() {
		return transmitDeptName;
	}

	public void setTransmitDeptName(String transmitDeptName) {
		this.transmitDeptName = transmitDeptName;
	}

	public String getTodeptName() {
		return todeptName;
	}

	public void setTodeptName(String todeptName) {
		this.todeptName = todeptName;
	}

	/**
	 * 设置：转发部门
	 */
	public void setTransmitDeptid(String transmitDeptid) {
		this.transmitDeptid = transmitDeptid;
	}
	/**
	 * 获取：转发部门
	 */
	public String getTransmitDeptid() {
		return transmitDeptid;
	}
	/**
	 * 设置：转发者
	 */
	public void setTransmitUserid(String transmitUserid) {
		this.transmitUserid = transmitUserid;
	}
	/**
	 * 获取：转发者
	 */
	public String getTransmitUserid() {
		return transmitUserid;
	}
	/**
	 * 设置：撤销标识
	 */
	public void setDelind(String delind) {
		this.delind = delind;
	}
	/**
	 * 获取：撤销标识
	 */
	public String getDelind() {
		return delind;
	}
	/**
	 * 设置：目标明细编号
	 */
	public void setTargetdetailid(String targetdetailid) {
		this.targetdetailid = targetdetailid;
	}
	/**
	 * 获取：目标明细编号
	 */
	public String getTargetdetailid() {
		return targetdetailid;
	}
	/**
	 * 设置：目标编号
	 */
	public void setTargetid(String targetid) {
		this.targetid = targetid;
	}
	/**
	 * 获取：目标编号
	 */
	public String getTargetid() {
		return targetid;
	}
	/**
	 * 设置：目标类型
	 */
	public void setTargettype(String targettype) {
		this.targettype = targettype;
	}
	/**
	 * 获取：目标类型
	 */
	public String getTargettype() {
		return targettype;
	}
	/**
	 * 设置：转发时间
	 */
	public void setZftime(Date zftime) {
		this.zftime = zftime;
	}
	/**
	 * 获取：转发时间
	 */
	public Date getZftime() {
		return zftime;
	}
	/**
	 * 设置：转发到部门
	 */
	public void setTodeptid(String todeptid) {
		this.todeptid = todeptid;
	}
	/**
	 * 获取：转发到部门
	 */
	public String getTodeptid() {
		return todeptid;
	}
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
}
