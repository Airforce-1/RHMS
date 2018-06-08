package com.khidi.manager.basicinfo.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-15 15:37:03
 */
public class HydropowerstationEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//纬度
    @ApiModelProperty(value = "纬度",dataType="String",required = true,hidden = false)
	private String y;
	//水电站类型
    @ApiModelProperty(value = "水电站类型",dataType="String",required = true,hidden = false)
	private String type;
    //水电站类型名称
    @ApiModelProperty(value = "水电站类型名称",dataType="String",required = true,hidden = false)
	private String typeName;
	//水电站编码
    @ApiModelProperty(value = "水电站编码",dataType="String",required = true,hidden = false)
	private String code;
	//水电站名称
    @ApiModelProperty(value = "水电站名称",dataType="String",required = true,hidden = false)
	private String name;
	//经度
    @ApiModelProperty(value = "经度",dataType="String",required = true,hidden = false)
	private String x;
	//工程建设情况
    @ApiModelProperty(value = "工程建设情况",dataType="String",required = true,hidden = false)
	private String buildSituation;
    //工程建设情况
    @ApiModelProperty(value = "工程建设情况名称",dataType="String",required = true,hidden = false)
	private String buildSituationName;
	//建成时间
    @ApiModelProperty(value = "建成时间",dataType="Date",required = true,hidden = false)
	private Date buildTime;
	//主要建筑物级别
    @ApiModelProperty(value = "主要建筑物级别",dataType="String",required = true,hidden = false)
	private String buildLevel;
	//工程等别
    @ApiModelProperty(value = "工程等别",dataType="String",required = true,hidden = false)
	private String grade;
	//装机容量
    @ApiModelProperty(value = "装机容量",dataType="String",required = true,hidden = false)
	private String installedCapacity;
	//保证出力
    @ApiModelProperty(value = "保证出力",dataType="String",required = true,hidden = false)
	private String power;
	//额定水头
    @ApiModelProperty(value = "额定水头",dataType="String",required = true,hidden = false)
	private String waterHead;
	//机组台数
    @ApiModelProperty(value = "机组台数",dataType="String",required = true,hidden = false)
	private String unitNumber;
	//管理单位
    @ApiModelProperty(value = "管理单位",dataType="String",required = true,hidden = false)
	private String manager;
	//河湖渠道类型
    @ApiModelProperty(value = "河湖渠道类型",dataType="String",required = true,hidden = false)
	private String resourceType;
    //河湖渠道类型
    @ApiModelProperty(value = "河湖渠道类型名称",dataType="String",required = true,hidden = false)
	private String resourceTypeName;
	//河湖渠道编码
    @ApiModelProperty(value = "河湖渠道编码",dataType="String",required = true,hidden = false)
	private String resourceId;
    //河湖渠道编码
    @ApiModelProperty(value = "河湖渠道名称",dataType="String",required = true,hidden = false)
	private String resourceName;
	//行政区划编码
    @ApiModelProperty(value = "行政区划编码",dataType="String",required = true,hidden = false)
	private String areaId;
    //行政区划编码名称
    @ApiModelProperty(value = "行政区划编码",dataType="String",required = true,hidden = false)
	private String areaName;
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
	 * 设置：水电站类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：水电站类型
	 */
	public String getType() {
		return type;
	}
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 设置：水电站编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：水电站编码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：水电站名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：水电站名称
	 */
	public String getName() {
		return name;
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
	 * 设置：工程建设情况
	 */
	public void setBuildSituation(String buildSituation) {
		this.buildSituation = buildSituation;
	}
	/**
	 * 获取：工程建设情况
	 */
	public String getBuildSituation() {
		return buildSituation;
	}
	
	public String getBuildSituationName() {
		return buildSituationName;
	}
	public void setBuildSituationName(String buildSituationName) {
		this.buildSituationName = buildSituationName;
	}
	/**
	 * 设置：建成时间
	 */
	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	/**
	 * 获取：建成时间
	 */
	public Date getBuildTime() {
		return buildTime;
	}
	/**
	 * 设置：主要建筑物级别
	 */
	public void setBuildLevel(String buildLevel) {
		this.buildLevel = buildLevel;
	}
	/**
	 * 获取：主要建筑物级别
	 */
	public String getBuildLevel() {
		return buildLevel;
	}
	/**
	 * 设置：工程等别
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * 获取：工程等别
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * 设置：装机容量
	 */
	public void setInstalledCapacity(String installedCapacity) {
		this.installedCapacity = installedCapacity;
	}
	/**
	 * 获取：装机容量
	 */
	public String getInstalledCapacity() {
		return installedCapacity;
	}
	/**
	 * 设置：保证出力
	 */
	public void setPower(String power) {
		this.power = power;
	}
	/**
	 * 获取：保证出力
	 */
	public String getPower() {
		return power;
	}
	/**
	 * 设置：额定水头
	 */
	public void setWaterHead(String waterHead) {
		this.waterHead = waterHead;
	}
	/**
	 * 获取：额定水头
	 */
	public String getWaterHead() {
		return waterHead;
	}
	/**
	 * 设置：机组台数
	 */
	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}
	/**
	 * 获取：机组台数
	 */
	public String getUnitNumber() {
		return unitNumber;
	}
	/**
	 * 设置：管理单位
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}
	/**
	 * 获取：管理单位
	 */
	public String getManager() {
		return manager;
	}
	/**
	 * 设置：资源类型
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	/**
	 * 获取：资源类型
	 */
	public String getResourceType() {
		return resourceType;
	}
	/**
	 * 设置：资源编码
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	/**
	 * 获取：资源编码
	 */
	public String getResourceId() {
		return resourceId;
	}
	/**
	 * 设置：行政区划编码
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	/**
	 * 获取：行政区划编码
	 */
	public String getAreaId() {
		return areaId;
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
	
	public String getResourceTypeName() {
		return resourceTypeName;
	}
	public void setResourceTypeName(String resourceTypeName) {
		this.resourceTypeName = resourceTypeName;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
}
