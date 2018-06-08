package com.khidi.manager.officework.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * ${comments}
 * 
 * @author wangshunbo
 * @email 405877884@qq.com
 * @date 2017-12-16 13:52:08
 */
public class MeetingMEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	// 编号
	@ApiModelProperty(value = "编号", dataType = "String", required = true, hidden = false)
	private String id;
	// 标题
	@ApiModelProperty(value = "标题", dataType = "String", required = true, hidden = false)
	private String title;
	// 会议主持人
	@ApiModelProperty(value = "会议主持人", dataType = "String", required = true, hidden = false)
	private String presenters;
	// 会议开始时间
	@ApiModelProperty(value = "会议开始时间", dataType = "Date", required = true, hidden = false)
	private Date stime;
	// 会议结束时间
	@ApiModelProperty(value = "会议结束时间", dataType = "Date", required = true, hidden = false)
	private Date etime;
	// 会议类型
	@ApiModelProperty(value = "会议类型", dataType = "String", required = true, hidden = false)
	private String mtype;
	// 会议类型名称
	@ApiModelProperty(value = "会议类型名称", dataType = "String", required = true, hidden = false)
	private String mtypeName;
	// 会议地点 
	@ApiModelProperty(value = "会议地点", dataType = "String", required = true, hidden = false)
	private String mposition;

	// 会议状态
	@ApiModelProperty(value = "会议地点", dataType = "String", required = true, hidden = false)
	private String state;

	public String getState() {
		return state;
	}
	public String getMtypeName() {
		return mtypeName;
	}

	public void setMtypeName(String mtypeName) {
		this.mtypeName = mtypeName;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getAttState1() {
		return attState1;
	}

	public void setAttState1(String attState1) {
		this.attState1 = attState1;
	}

	// 会议备用状态1(表单状态)
	@ApiModelProperty(value = "会议备用状态1", dataType = "String", required = true, hidden = false)
	private String attState1;

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
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置：会议主持人
	 */
	public void setPresenters(String presenters) {
		this.presenters = presenters;
	}

	/**
	 * 获取：会议主持人
	 */
	public String getPresenters() {
		return presenters;
	}

	/**
	 * 设置：会议开始时间
	 */
	public void setStime(Date stime) {
		this.stime = stime;
	}

	/**
	 * 获取：会议开始时间
	 */
	public Date getStime() {
		return stime;
	}

	/**
	 * 设置：会议结束时间
	 */
	public void setEtime(Date etime) {
		this.etime = etime;
	}

	/**
	 * 获取：会议结束时间
	 */
	public Date getEtime() {
		return etime;
	}

	/**
	 * 设置：会议类型
	 */
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	/**
	 * 获取：会议类型
	 */
	public String getMtype() {
		return mtype;
	}

	/**
	 * 设置：会议地点
	 */
	public void setMposition(String mposition) {
		this.mposition = mposition;
	}

	/**
	 * 获取：会议地点
	 */
	public String getMposition() {
		return mposition;
	}
}
