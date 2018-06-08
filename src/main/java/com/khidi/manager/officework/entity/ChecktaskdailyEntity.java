package com.khidi.manager.officework.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-22 11:37:03
 */
public class ChecktaskdailyEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//巡查任务编码
    @ApiModelProperty(value = "巡查任务编码",dataType="String",required = true,hidden = false)
	private String code;
	//巡查路线编码
    @ApiModelProperty(value = "巡查路线编码",dataType="String",required = true,hidden = false)
	private String routeid;
	//巡查员(存userId)
    @ApiModelProperty(value = "巡查员(存userId)",dataType="String",required = true,hidden = false)
	private String checker;
	//巡查频次
    @ApiModelProperty(value = "巡查频次",dataType="String",required = true,hidden = false)
	private String checktimes;
	//巡查频次单位
    @ApiModelProperty(value = "巡查频次单位",dataType="String",required = true,hidden = false)
	private String unit;
	//任务状态
    @ApiModelProperty(value = "任务状态",dataType="String",required = true,hidden = false)
	private String status;
	//最迟开始时间
    @ApiModelProperty(value = "最迟开始时间",dataType="Date",required = true,hidden = false)
	private String lastbegintime;
	//最迟结束时长
    @ApiModelProperty(value = "最迟结束时长",dataType="Date",required = true,hidden = false)
	private String lastendtime;
	//任务启用时间
    @ApiModelProperty(value = "任务启用时间",dataType="Date",required = true,hidden = false)
	private Date begintime;
	//任务失效时间
    @ApiModelProperty(value = "任务失效时间",dataType="Date",required = true,hidden = false)
	private Date endtime;
	//生产时间
    @ApiModelProperty(value = "生产时间",dataType="Date",required = true,hidden = false)
	private Date createtime;
	//发布人
	@ApiModelProperty(value = "发布人",dataType="String",required = true,hidden = false)
	private String taskSender;

	public String getTaskSender() {
		return taskSender;
	}

	public void setTaskSender(String taskSender) {
		this.taskSender = taskSender;
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
	 * 设置：巡查任务编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：巡查任务编码
	 */
	public String getCode() {
		return code;
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
	/**
	 * 设置：巡查员(存userId)
	 */
	public void setChecker(String checker) {
		this.checker = checker;
	}
	/**
	 * 获取：巡查员(存userId)
	 */
	public String getChecker() {
		return checker;
	}
	/**
	 * 设置：巡查频次
	 */
	public void setChecktimes(String checktimes) {
		this.checktimes = checktimes;
	}
	/**
	 * 获取：巡查频次
	 */
	public String getChecktimes() {
		return checktimes;
	}
	/**
	 * 设置：巡查频次单位
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取：巡查频次单位
	 */
	public String getUnit() {
		return unit;
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

	public String getLastbegintime() {
		return lastbegintime;
	}


	public void setLastbegintime(String lastbegintime) {
		this.lastbegintime = lastbegintime;
	}

	public String getLastendtime() {
		return lastendtime;
	}

	public void setLastendtime(String lastendtime) {
		this.lastendtime = lastendtime;
	}

	/**
	 * 设置：任务启用时间
	 */
	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}
	/**
	 * 获取：任务启用时间
	 */
	public Date getBegintime() {
		return begintime;
	}
	/**
	 * 设置：任务失效时间
	 */
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	/**
	 * 获取：任务失效时间
	 */
	public Date getEndtime() {
		return endtime;
	}
	/**
	 * 设置：生产时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * 获取：生产时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
}
