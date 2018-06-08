package com.khidi.manager.externaldata.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-24 10:56:45
 */
public class ExternalWqDataEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//监测站编码
    @ApiModelProperty(value = "监测站编码",dataType="String",required = true,hidden = false)
	private String stationId;
	//监测时间
    @ApiModelProperty(value = "监测时间",dataType="String",required = true,hidden = false)
	private String monitorTime;
	//监测项目
    @ApiModelProperty(value = "监测项目",dataType="String",required = true,hidden = false)
	private String item;
	//监测值
    @ApiModelProperty(value = "监测值",dataType="String",required = true,hidden = false)
	private String value;
	//值单位
    @ApiModelProperty(value = "值单位",dataType="String",required = true,hidden = false)
	private String unit;
	//生成时间
    @ApiModelProperty(value = "生成时间",dataType="Date",required = true,hidden = false)
	private Date createTime;

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
	 * 设置：监测站编码
	 */
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	/**
	 * 获取：监测站编码
	 */
	public String getStationId() {
		return stationId;
	}

	public String getMonitorTime() {
		return monitorTime;
	}

	public void setMonitorTime(String monitorTime) {
		this.monitorTime = monitorTime;
	}

	/**
	 * 设置：监测项目
	 */
	public void setItem(String item) {
		this.item = item;
	}
	/**
	 * 获取：监测项目
	 */
	public String getItem() {
		return item;
	}
	/**
	 * 设置：监测值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取：监测值
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 设置：值单位
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取：值单位
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * 设置：生成时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：生成时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
