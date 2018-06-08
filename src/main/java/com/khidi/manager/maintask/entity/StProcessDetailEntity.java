package com.khidi.manager.maintask.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-10 15:36:28
 */
public class StProcessDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
    @ApiModelProperty(value = "编号",dataType="String",required = true,hidden = false)
	private String id;
	//目标编号
    @ApiModelProperty(value = "目标编号",dataType="String",required = true,hidden = false)
	private String targetid;
	//任务编号
    @ApiModelProperty(value = "任务编号",dataType="String",required = true,hidden = false)
	private String taskid;
	//目标明细编号
    @ApiModelProperty(value = "目标明细编号",dataType="String",required = true,hidden = false)
	private String targetDetailId;
	//任务明细编号
    @ApiModelProperty(value = "任务明细编号",dataType="String",required = true,hidden = false)
	private String taskDetailId;
	//子任务计划进度编号
    @ApiModelProperty(value = "子任务计划进度编号",dataType="String",required = true,hidden = false)
	private String taskdetailSubtaskId;
	//指标类型
    @ApiModelProperty(value = "指标类型",dataType="Double",required = true,hidden = false)
	private Double objtype;
	//进度数值
    @ApiModelProperty(value = "进度数值",dataType="Double",required = true,hidden = false)
	private Double progress;
	//填报人
    @ApiModelProperty(value = "填报人",dataType="String",required = true,hidden = false)
	private String createuserid;
	//填报人所在部门
    @ApiModelProperty(value = "填报人所在部门",dataType="String",required = true,hidden = false)
	private String createdeptid;
	//备注信息
    @ApiModelProperty(value = "备注信息",dataType="String",required = true,hidden = false)
	private String memo;
	//备注信息
	@ApiModelProperty(value = "备注信息",dataType="String",required = true,hidden = false)
	private String createtime;

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
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
	 * 设置：目标明细编号
	 */
	public void setTargetDetailId(String targetDetailId) {
		this.targetDetailId = targetDetailId;
	}
	/**
	 * 获取：目标明细编号
	 */
	public String getTargetDetailId() {
		return targetDetailId;
	}
	/**
	 * 设置：任务明细编号
	 */
	public void setTaskDetailId(String taskDetailId) {
		this.taskDetailId = taskDetailId;
	}
	/**
	 * 获取：任务明细编号
	 */
	public String getTaskDetailId() {
		return taskDetailId;
	}
	/**
	 * 设置：子任务计划进度编号
	 */
	public void setTaskdetailSubtaskId(String taskdetailSubtaskId) {
		this.taskdetailSubtaskId = taskdetailSubtaskId;
	}
	/**
	 * 获取：子任务计划进度编号
	 */
	public String getTaskdetailSubtaskId() {
		return taskdetailSubtaskId;
	}
	/**
	 * 设置：指标类型
	 */
	public void setObjtype(Double objtype) {
		this.objtype = objtype;
	}
	/**
	 * 获取：指标类型
	 */
	public Double getObjtype() {
		return objtype;
	}
	/**
	 * 设置：进度数值
	 */
	public void setProgress(Double progress) {
		this.progress = progress;
	}
	/**
	 * 获取：进度数值
	 */
	public Double getProgress() {
		return progress;
	}
	/**
	 * 设置：填报人
	 */
	public void setCreateuserid(String createuserid) {
		this.createuserid = createuserid;
	}
	/**
	 * 获取：填报人
	 */
	public String getCreateuserid() {
		return createuserid;
	}
	/**
	 * 设置：填报人所在部门
	 */
	public void setCreatedeptid(String createdeptid) {
		this.createdeptid = createdeptid;
	}
	/**
	 * 获取：填报人所在部门
	 */
	public String getCreatedeptid() {
		return createdeptid;
	}
	/**
	 * 设置：备注信息
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * 获取：备注信息
	 */
	public String getMemo() {
		return memo;
	}
}
