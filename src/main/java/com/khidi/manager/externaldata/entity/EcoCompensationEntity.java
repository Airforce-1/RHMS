package com.khidi.manager.externaldata.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-17 16:39:02
 */
public class EcoCompensationEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//目标水质类别
    @ApiModelProperty(value = "目标水质类别",dataType="String",required = true,hidden = false)
	private String aimType;
	//当前水质类别
    @ApiModelProperty(value = "当前水质类别",dataType="String",required = true,hidden = false)
	private String currentType;
	//污染因子
    @ApiModelProperty(value = "污染因子",dataType="String",required = true,hidden = false)
	private String factor;
	//COD超标值
    @ApiModelProperty(value = "COD超标值",dataType="String",required = true,hidden = false)
	private String codOut;
	//氨氮超标值
    @ApiModelProperty(value = "氨氮超标值",dataType="String",required = true,hidden = false)
	private String nhOut;
	//总磷超标值
    @ApiModelProperty(value = "总磷超标值",dataType="String",required = true,hidden = false)
	private String pOut;
	//生态补偿金(万)
    @ApiModelProperty(value = "生态补偿金(万)",dataType="String",required = true,hidden = false)
	private String ecoCompensation;
	//COD
    @ApiModelProperty(value = "COD",dataType="String",required = true,hidden = false)
	private String cod;
	//氨氮
    @ApiModelProperty(value = "氨氮",dataType="String",required = true,hidden = false)
	private String nh;
	//总磷
    @ApiModelProperty(value = "总磷",dataType="String",required = true,hidden = false)
	private String p;
	//监测时间
    @ApiModelProperty(value = "监测时间",dataType="String",required = true,hidden = false)
	private String monitorTime;
	//所属区域
	@ApiModelProperty(value = "所属区域",dataType="String",required = true,hidden = false)
	private String areaName;
	//所属河流
	@ApiModelProperty(value = "所属河流",dataType="String",required = true,hidden = false)
	private String riverName;
	//所属测站
	@ApiModelProperty(value = "所属测站",dataType="String",required = true,hidden = false)
	private String stationName;
	//所属测站编码
	@ApiModelProperty(value = "所属测站编码",dataType="String",required = true,hidden = false)
	private String stationId;

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getpOut() {
		return pOut;
	}

	public void setpOut(String pOut) {
		this.pOut = pOut;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getRiverName() {
		return riverName;
	}

	public void setRiverName(String riverName) {
		this.riverName = riverName;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
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
	 * 设置：目标水质类别
	 */
	public void setAimType(String aimType) {
		this.aimType = aimType;
	}
	/**
	 * 获取：目标水质类别
	 */
	public String getAimType() {
		return aimType;
	}
	/**
	 * 设置：当前水质类别
	 */
	public void setCurrentType(String currentType) {
		this.currentType = currentType;
	}
	/**
	 * 获取：当前水质类别
	 */
	public String getCurrentType() {
		return currentType;
	}
	/**
	 * 设置：污染因子
	 */
	public void setFactor(String factor) {
		this.factor = factor;
	}
	/**
	 * 获取：污染因子
	 */
	public String getFactor() {
		return factor;
	}
	/**
	 * 设置：COD超标值
	 */
	public void setCodOut(String codOut) {
		this.codOut = codOut;
	}
	/**
	 * 获取：COD超标值
	 */
	public String getCodOut() {
		return codOut;
	}
	/**
	 * 设置：氨氮超标值
	 */
	public void setNhOut(String nhOut) {
		this.nhOut = nhOut;
	}
	/**
	 * 获取：氨氮超标值
	 */
	public String getNhOut() {
		return nhOut;
	}
	/**
	 * 设置：总磷超标值
	 */
	public void setPOut(String pOut) {
		this.pOut = pOut;
	}
	/**
	 * 获取：总磷超标值
	 */
	public String getPOut() {
		return pOut;
	}
	/**
	 * 设置：生态补偿金(万)
	 */
	public void setEcoCompensation(String ecoCompensation) {
		this.ecoCompensation = ecoCompensation;
	}
	/**
	 * 获取：生态补偿金(万)
	 */
	public String getEcoCompensation() {
		return ecoCompensation;
	}
	/**
	 * 设置：COD
	 */
	public void setCod(String cod) {
		this.cod = cod;
	}
	/**
	 * 获取：COD
	 */
	public String getCod() {
		return cod;
	}
	/**
	 * 设置：氨氮
	 */
	public void setNh(String nh) {
		this.nh = nh;
	}
	/**
	 * 获取：氨氮
	 */
	public String getNh() {
		return nh;
	}
	/**
	 * 设置：总磷
	 */
	public void setP(String p) {
		this.p = p;
	}
	/**
	 * 获取：总磷
	 */
	public String getP() {
		return p;
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
}
