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
public class StTaskdetailTransmitEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//任务明细编号
    @ApiModelProperty(value = "任务明细编号",dataType="String",required = true,hidden = false)
	private String taskdetailid;
	//任务编号
    @ApiModelProperty(value = "任务编号",dataType="String",required = true,hidden = false)
	private String taskid;
	//任务类型
    @ApiModelProperty(value = "任务类型",dataType="String",required = true,hidden = false)
	private String tasktype;
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
	@ApiModelProperty(value = "转发部门",dataType="String",required = true,hidden = false)
	private String transmitDeptid;
	//转发者
	@ApiModelProperty(value = "转发者",dataType="String",required = true,hidden = false)
	private String transmitUserid;
	//撤销标识
	@ApiModelProperty(value = "撤销标识",dataType="String",required = true,hidden = false)
	private String delind;
	//转发部门名称
	@ApiModelProperty(value = "转发部门名称",dataType="unknowType",required = true,hidden = false)
	private String transmitDeptName;
	//转发到部门名称
	@ApiModelProperty(value = "转发到部门名称",dataType="String",required = true,hidden = false)
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
	 * 设置：任务明细编号
	 */
	public void setTaskdetailid(String taskdetailid) {
		this.taskdetailid = taskdetailid;
	}
	/**
	 * 获取：任务明细编号
	 */
	public String getTaskdetailid() {
		return taskdetailid;
	}
	/**
	 * 设置：任务编号
	 */
	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}
	/**
	 * 获取：任务编号
	 */
	public String getTaskid() {
		return taskid;
	}
	/**
	 * 设置：任务类型
	 */
	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}
	/**
	 * 获取：任务类型
	 */
	public String getTasktype() {
		return tasktype;
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
}
