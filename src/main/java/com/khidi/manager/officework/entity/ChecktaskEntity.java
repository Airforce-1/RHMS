package com.khidi.manager.officework.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-25 15:53:29
 */
public class ChecktaskEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//巡查路线编码
    @ApiModelProperty(value = "巡查路线编码",dataType="String",required = true,hidden = false)
	private String routeid;
	//巡查员编码
    @ApiModelProperty(value = "巡查员编码",dataType="String",required = true,hidden = false)
	private String checker;
	//巡查开始时间
    @ApiModelProperty(value = "巡查开始时间",dataType="Date",required = true,hidden = false)
	private Date startdate;
	//巡查结束时间
    @ApiModelProperty(value = "巡查结束时间",dataType="Date",required = true,hidden = false)
	private Date enddate;
	//生成时间
    @ApiModelProperty(value = "生成时间",dataType="Date",required = true,hidden = false)
	private Date createtime;
	//任务类型
    @ApiModelProperty(value = "任务类型",dataType="String",required = true,hidden = false)
	private String type;
	//任务发布人
    @ApiModelProperty(value = "任务发布人",dataType="String",required = true,hidden = false)
	private String tasksender;
	//任务状态
    @ApiModelProperty(value = "任务状态",dataType="String",required = true,hidden = false)
	private String status;
    //最迟开始时间
	@ApiModelProperty(value = "最迟开始时间",dataType="Date",required = true,hidden = false)
	private Date lastStartDate;
	//最迟开始时间
	@ApiModelProperty(value = "日常任务编码",dataType="String",required = true,hidden = false)
	private String dailyTaskId;
	//资源类型名称
	@ApiModelProperty(value = "资源类型名称",dataType="String",required = true,hidden = false)
	private String resourceType;
	//资源编码
	@ApiModelProperty(value = "地图资源编码",dataType="String",required = true,hidden = false)
	private String resourceId;
	//地图资源编码
	@ApiModelProperty(value = "地图资源编码",dataType="String",required = true,hidden = false)
	private String featureId;

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getFeatureId() {
		return featureId;
	}

	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}

	public String getDailyTaskId() {
		return dailyTaskId;
	}

	public void setDailyTaskId(String dailyTaskId) {
		this.dailyTaskId = dailyTaskId;
	}

	public Date getLastStartDate(){
		return lastStartDate;
	}

	public void setLastStartDate(Date lastStartDate) {
		this.lastStartDate = lastStartDate;
	}

	/**
	 * 设置：系统编码
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：系统编码
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：巡查路线编码
	 */
	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}
	/**
	 * 获取：巡查路线编码
	 */
	public String getRouteid() {
		return routeid;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	/**
	 * 设置：巡查开始时间
	 */
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	/**
	 * 获取：巡查开始时间
	 */
	public Date getStartdate() {
		return startdate;
	}
	/**
	 * 设置：巡查结束时间
	 */
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	/**
	 * 获取：巡查结束时间
	 */
	public Date getEnddate() {
		return enddate;
	}
	/**
	 * 设置：生成时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：生成时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：任务类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：任务类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：任务发布人
	 */
	public void setTasksender(String tasksender) {
		this.tasksender = tasksender;
	}
	/**
	 * 获取：任务发布人
	 */
	public String getTasksender() {
		return tasksender;
	}
	/**
	 * 设置：任务状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：任务状态
	 */
	public String getStatus() {
		return status;
	}
}
