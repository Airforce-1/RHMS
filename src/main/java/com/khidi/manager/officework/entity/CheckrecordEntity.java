package com.khidi.manager.officework.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-10 11:56:31
 */
public class CheckrecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//巡查状态
    @ApiModelProperty(value = "巡查状态",dataType="String",required = true,hidden = false)
	private String status;
	//巡查开始时间
    @ApiModelProperty(value = "巡查开始时间",dataType="Date",required = true,hidden = false)
	private Date checkstarttime;
	//事件编码ids
    @ApiModelProperty(value = "事件编码ids",dataType="unknowType",required = true,hidden = false)
	private String eventids;
	//巡查任务编码
    @ApiModelProperty(value = "巡查任务编码",dataType="String",required = true,hidden = false)
	private String taskid;
	//巡查结束时间
    @ApiModelProperty(value = "巡查结束时间",dataType="Date",required = true,hidden = false)
	private Date checkendtime;
	//生成时间
    @ApiModelProperty(value = "生成时间",dataType="Date",required = true,hidden = false)
	private Date createtime;
	//巡查工作情况
    @ApiModelProperty(value = "巡查工作情况",dataType="unknowType",required = true,hidden = false)
	private String situation;
	//附件编码
    @ApiModelProperty(value = "附件编码",dataType="unknowType",required = true,hidden = false)
	private String attachmentids;
	//生活污水的收集、处置、排放不合规
    @ApiModelProperty(value = "生活污水的收集、处置、排放不合规",dataType="String",required = true,hidden = false)
	private String iswaterdirty;
	//河道周边有违章搭建、占用河道情况
    @ApiModelProperty(value = "河道周边有违章搭建、占用河道情况",dataType="String",required = true,hidden = false)
	private String isoccupyriver;
	//河面有成片漂浮废弃物
    @ApiModelProperty(value = "河面有成片漂浮废弃物",dataType="String",required = true,hidden = false)
	private String isfloater;
	//河岸有垃圾堆放
    @ApiModelProperty(value = "河岸有垃圾堆放",dataType="String",required = true,hidden = false)
	private String isrubbish;
	//河道水体有臭味、异常颜色
    @ApiModelProperty(value = "河道水体有臭味、异常颜色",dataType="String",required = true,hidden = false)
	private String issmelly;
    //轨迹列表
	@ApiModelProperty(value = "轨迹列表",required = false,hidden = false)
	private List<ChecktrailEntity> list;

	public List<ChecktrailEntity> getList() {
		return list;
	}

	public void setList(List<ChecktrailEntity> list) {
		this.list = list;
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
	 * 设置：巡查状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：巡查状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：巡查开始时间
	 */
	public void setCheckstarttime(Date checkstarttime) {
		this.checkstarttime = checkstarttime;
	}
	/**
	 * 获取：巡查开始时间
	 */
	public Date getCheckstarttime() {
		return checkstarttime;
	}

	public String getEventids() {
		return eventids;
	}

	public void setEventids(String eventids) {
		this.eventids = eventids;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getAttachmentids() {
		return attachmentids;
	}

	public void setAttachmentids(String attachmentids) {
		this.attachmentids = attachmentids;
	}

	/**
	 * 设置：巡查任务编码
	 */
	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}
	/**
	 * 获取：巡查任务编码
	 */
	public String getTaskid() {
		return taskid;
	}
	/**
	 * 设置：巡查结束时间
	 */
	public void setCheckendtime(Date checkendtime) {
		this.checkendtime = checkendtime;
	}
	/**
	 * 获取：巡查结束时间
	 */
	public Date getCheckendtime() {
		return checkendtime;
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
	 * 设置：生活污水的收集、处置、排放不合规
	 */
	public void setIswaterdirty(String iswaterdirty) {
		this.iswaterdirty = iswaterdirty;
	}
	/**
	 * 获取：生活污水的收集、处置、排放不合规
	 */
	public String getIswaterdirty() {
		return iswaterdirty;
	}
	/**
	 * 设置：河道周边有违章搭建、占用河道情况
	 */
	public void setIsoccupyriver(String isoccupyriver) {
		this.isoccupyriver = isoccupyriver;
	}
	/**
	 * 获取：河道周边有违章搭建、占用河道情况
	 */
	public String getIsoccupyriver() {
		return isoccupyriver;
	}
	/**
	 * 设置：河面有成片漂浮废弃物
	 */
	public void setIsfloater(String isfloater) {
		this.isfloater = isfloater;
	}
	/**
	 * 获取：河面有成片漂浮废弃物
	 */
	public String getIsfloater() {
		return isfloater;
	}
	/**
	 * 设置：河岸有垃圾堆放
	 */
	public void setIsrubbish(String isrubbish) {
		this.isrubbish = isrubbish;
	}
	/**
	 * 获取：河岸有垃圾堆放
	 */
	public String getIsrubbish() {
		return isrubbish;
	}
	/**
	 * 设置：河道水体有臭味、异常颜色
	 */
	public void setIssmelly(String issmelly) {
		this.issmelly = issmelly;
	}
	/**
	 * 获取：河道水体有臭味、异常颜色
	 */
	public String getIssmelly() {
		return issmelly;
	}
}
