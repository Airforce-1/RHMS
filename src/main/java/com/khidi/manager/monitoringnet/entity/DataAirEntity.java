package com.khidi.manager.monitoringnet.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-30 14:23:59
 */
public class DataAirEntity implements Serializable {
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
	//空气质量指数
    @ApiModelProperty(value = "空气质量指数",dataType="String",required = true,hidden = false)
	private String aqi;
	//空气质量评价
    @ApiModelProperty(value = "空气质量评价",dataType="String",required = true,hidden = false)
	private String airLevel;
	//主要污染物
    @ApiModelProperty(value = "主要污染物",dataType="String",required = true,hidden = false)
	private String primaryPollutant;
	//PM2.5(μg/m3)
    @ApiModelProperty(value = "PM2.5(μg/m3)",dataType="String",required = true,hidden = false)
	private String pm25;
	//PM10(μg/m3)
    @ApiModelProperty(value = "PM10(μg/m3)",dataType="String",required = true,hidden = false)
	private String pm10;
	//一氧化碳(μg/m3)
    @ApiModelProperty(value = "一氧化碳(μg/m3)",dataType="String",required = true,hidden = false)
	private String co;
	//二氧化氮(μg/m3)
    @ApiModelProperty(value = "二氧化氮(μg/m3)",dataType="String",required = true,hidden = false)
	private String no2;
	//臭氧1H(ppm)
    @ApiModelProperty(value = "臭氧1H(ppm)",dataType="String",required = true,hidden = false)
	private String o31h;
	//臭氧8H(ppm)
    @ApiModelProperty(value = "臭氧8H(ppm)",dataType="String",required = true,hidden = false)
	private String o38h;
	//二氧化硫(μg/m3)
    @ApiModelProperty(value = "二氧化硫(μg/m3)",dataType="String",required = true,hidden = false)
	private String so2;
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
	/**
	 * 设置：监测时间
	 */
	public void setMonitorTime(String monitorTime) {
		this.monitorTime = monitorTime;
	}
	/**
	 * 获取：监测时间
	 */
	public String getMonitorTime() {
		return monitorTime;
	}
	/**
	 * 设置：空气质量指数
	 */
	public void setAqi(String aqi) {
		this.aqi = aqi;
	}
	/**
	 * 获取：空气质量指数
	 */
	public String getAqi() {
		return aqi;
	}
	/**
	 * 设置：空气质量评价
	 */
	public void setAirLevel(String airLevel) {
		this.airLevel = airLevel;
	}
	/**
	 * 获取：空气质量评价
	 */
	public String getAirLevel() {
		return airLevel;
	}
	/**
	 * 设置：主要污染物
	 */
	public void setPrimaryPollutant(String primaryPollutant) {
		this.primaryPollutant = primaryPollutant;
	}
	/**
	 * 获取：主要污染物
	 */
	public String getPrimaryPollutant() {
		return primaryPollutant;
	}
	/**
	 * 设置：PM2.5(μg/m3)
	 */
	public void setPm25(String pm25) {
		this.pm25 = pm25;
	}
	/**
	 * 获取：PM2.5(μg/m3)
	 */
	public String getPm25() {
		return pm25;
	}
	/**
	 * 设置：PM10(μg/m3)
	 */
	public void setPm10(String pm10) {
		this.pm10 = pm10;
	}
	/**
	 * 获取：PM10(μg/m3)
	 */
	public String getPm10() {
		return pm10;
	}
	/**
	 * 设置：一氧化碳(μg/m3)
	 */
	public void setCo(String co) {
		this.co = co;
	}
	/**
	 * 获取：一氧化碳(μg/m3)
	 */
	public String getCo() {
		return co;
	}
	/**
	 * 设置：二氧化氮(μg/m3)
	 */
	public void setNo2(String no2) {
		this.no2 = no2;
	}
	/**
	 * 获取：二氧化氮(μg/m3)
	 */
	public String getNo2() {
		return no2;
	}
	/**
	 * 设置：臭氧1H(ppm)
	 */
	public void setO31h(String o31h) {
		this.o31h = o31h;
	}
	/**
	 * 获取：臭氧1H(ppm)
	 */
	public String getO31h() {
		return o31h;
	}
	/**
	 * 设置：臭氧8H(ppm)
	 */
	public void setO38h(String o38h) {
		this.o38h = o38h;
	}
	/**
	 * 获取：臭氧8H(ppm)
	 */
	public String getO38h() {
		return o38h;
	}
	/**
	 * 设置：二氧化硫(μg/m3)
	 */
	public void setSo2(String so2) {
		this.so2 = so2;
	}
	/**
	 * 获取：二氧化硫(μg/m3)
	 */
	public String getSo2() {
		return so2;
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
