package com.khidi.manager.officework.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-13 15:01:00
 */
public class CheckrouteEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//路线编码
    @ApiModelProperty(value = "路线编码",dataType="String",required = true,hidden = false)
	private String code;
	//路线名称
    @ApiModelProperty(value = "路线名称",dataType="String",required = true,hidden = false)
	private String name;
	//行政区划编码
    @ApiModelProperty(value = "行政区划编码",dataType="String",required = true,hidden = false)
	private String areaid;
	//行政区划名称
	@ApiModelProperty(value = "行政区划编码",dataType="String",required = true,hidden = false)
	private String areaName;
	//河渠湖库(段)类型
    @ApiModelProperty(value = "河渠湖库(段)类型",dataType="String",required = true,hidden = false)
	private String resourcetype;
	//河渠湖库(段)类型
	@ApiModelProperty(value = "河渠湖库(段)类型名称",dataType="String",required = true,hidden = false)
	private String resourcetypename;
	//河渠湖库(段)名称
	@ApiModelProperty(value = "河渠湖库(段)名称",dataType="String",required = true,hidden = false)
	private String resourceid;
	//河渠湖库(段)名称
    @ApiModelProperty(value = "河渠湖库(段)名称",dataType="String",required = true,hidden = false)
	private String resourcename;
	//起点位置
    @ApiModelProperty(value = "起点位置",dataType="String",required = true,hidden = false)
	private String startpoint;
	//终点位置
    @ApiModelProperty(value = "终点位置",dataType="String",required = true,hidden = false)
	private String endpoint;
	//路线长度(KM)
    @ApiModelProperty(value = "路线长度(KM)",dataType="String",required = true,hidden = false)
	private String length;
	//状态
    @ApiModelProperty(value = "状态",dataType="String",required = true,hidden = false)
	private String status;
	//生成时间
    @ApiModelProperty(value = "生成时间",dataType="Date",required = true,hidden = false)
	private Date createtime;
	//绘制地图点
	@ApiModelProperty(value = "状态",dataType="String",required = true,hidden = false)
	private String routeMap ;

	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getResourcetypename() {
		return resourcetypename;
	}
	public void setResourcetypename(String resourcetypename) {
		this.resourcetypename = resourcetypename;
	}
	public String getResourceid() {
		return resourceid;
	}
	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}

	public String getRouteMap() {
		return routeMap;
	}

	public void setRouteMap(String routeMap) {
		this.routeMap = routeMap;
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
	 * 设置：路线编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：路线编码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：路线名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：路线名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：行政区划编码
	 */
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	/**
	 * 获取：行政区划编码
	 */
	public String getAreaid() {
		return areaid;
	}
	/**
	 * 设置：河渠湖库(段)类型
	 */
	public void setResourcetype(String resourcetype) {
		this.resourcetype = resourcetype;
	}
	/**
	 * 获取：河渠湖库(段)类型
	 */
	public String getResourcetype() {
		return resourcetype;
	}
	/**
	 * 设置：河渠湖库(段)名称
	 */
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	/**
	 * 获取：河渠湖库(段)名称
	 */
	public String getResourcename() {
		return resourcename;
	}
	/**
	 * 设置：起点位置
	 */
	public void setStartpoint(String startpoint) {
		this.startpoint = startpoint;
	}
	/**
	 * 获取：起点位置
	 */
	public String getStartpoint() {
		return startpoint;
	}
	/**
	 * 设置：终点位置
	 */
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	/**
	 * 获取：终点位置
	 */
	public String getEndpoint() {
		return endpoint;
	}
	/**
	 * 设置：路线长度(KM)
	 */
	public void setLength(String length) {
		this.length = length;
	}
	/**
	 * 获取：路线长度(KM)
	 */
	public String getLength() {
		return length;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
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
}
