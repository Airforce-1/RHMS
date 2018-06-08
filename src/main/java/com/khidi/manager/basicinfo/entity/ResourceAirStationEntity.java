package com.khidi.manager.basicinfo.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-30 09:39:48
 */
public class ResourceAirStationEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//监测站名称
    @ApiModelProperty(value = "监测站名称",dataType="String",required = true,hidden = false)
	private String name;
	//监测站地址
    @ApiModelProperty(value = "监测站地址",dataType="String",required = true,hidden = false)
	private String address;
	//所属行政区划
    @ApiModelProperty(value = "所属行政区划",dataType="String",required = true,hidden = false)
	private String areaId;
	//经度
    @ApiModelProperty(value = "经度",dataType="String",required = true,hidden = false)
	private String x;
	//纬度
    @ApiModelProperty(value = "纬度",dataType="String",required = true,hidden = false)
	private String y;
	//生成时间
    @ApiModelProperty(value = "生成时间",dataType="Date",required = true,hidden = false)
	private Date createTime;
	//所属行政区划名称
	@ApiModelProperty(value = "所属行政区划",dataType="String",required = true,hidden = false)
	private String areaName;
	//监测站编码
	@ApiModelProperty(value = "所属行政区划",dataType="String",required = true,hidden = false)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
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
	 * 设置：监测站名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：监测站名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：监测站地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：监测站地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：所属行政区划
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	/**
	 * 获取：所属行政区划
	 */
	public String getAreaId() {
		return areaId;
	}
	/**
	 * 设置：经度
	 */
	public void setX(String x) {
		this.x = x;
	}
	/**
	 * 获取：经度
	 */
	public String getX() {
		return x;
	}
	/**
	 * 设置：纬度
	 */
	public void setY(String y) {
		this.y = y;
	}
	/**
	 * 获取：纬度
	 */
	public String getY() {
		return y;
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
