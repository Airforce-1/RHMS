package com.khidi.manager.monitoringnet.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-08 13:25:47
 */
public class HydrologydataEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//监测站系统编码
    @ApiModelProperty(value = "监测站编码",dataType="String",required = true,hidden = false)
	private String stationId;
	//监测站编码
	@ApiModelProperty(value = "监测站编码",dataType="String",required = true,hidden = false)
	private String code;
	//监测站编码
	@ApiModelProperty(value = "监测站名称",dataType="String",required = true,hidden = false)
	private String stationName;
	//监测时间
	@ApiModelProperty(value = "监测时间",dataType="DATE",required = true,hidden = false)
	private Date createtime;
	//流速(m/s)
    @ApiModelProperty(value = "流速(m/s)",dataType="String",required = true,hidden = false)
	private String speed;
	//流量(m3/s)
    @ApiModelProperty(value = "流量(m3/s)",dataType="String",required = true,hidden = false)
	private String flow;
	//水量(万m3)
    @ApiModelProperty(value = "水量(万m3)",dataType="String",required = true,hidden = false)
	private String yield;
	@ApiModelProperty(value = "区划名称",dataType="String",required = true,hidden = false)
	private String areaName;

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * 设置：流速(m/s)
	 */
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	/**
	 * 获取：流速(m/s)
	 */
	public String getSpeed() {
		return speed;
	}
	/**
	 * 设置：流量(m3/s)
	 */
	public void setFlow(String flow) {
		this.flow = flow;
	}
	/**
	 * 获取：流量(m3/s)
	 */
	public String getFlow() {
		return flow;
	}
	/**
	 * 设置：水量(万m3)
	 */
	public void setYield(String yield) {
		this.yield = yield;
	}
	/**
	 * 获取：水量(万m3)
	 */
	public String getYield() {
		return yield;
	}
}
