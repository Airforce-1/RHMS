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
public class WatersourceEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//水源地名称
    @ApiModelProperty(value = "水源地名称",dataType="String",required = true,hidden = false)
	private String name;
	//水源地编码
    @ApiModelProperty(value = "水源地编码",dataType="String",required = true,hidden = false)
	private String code;
	//经度
    @ApiModelProperty(value = "经度",dataType="String",required = true,hidden = false)
	private String x;
	//纬度
    @ApiModelProperty(value = "纬度",dataType="String",required = true,hidden = false)
	private String y;
	//行政区划
    @ApiModelProperty(value = "行政区划",dataType="String",required = true,hidden = false)
	private String areaId;
    //行政区划名称
    @ApiModelProperty(value = "行政区划",dataType="String",required = true,hidden = false)
	private String areaName;
	//河湖渠库类型
    @ApiModelProperty(value = "河湖渠库类型",dataType="String",required = true,hidden = false)
	private String resourceType;
    //河湖渠库类型名称
    @ApiModelProperty(value = "河湖渠库类型名称",dataType="String",required = true,hidden = false)
	private String resourceTypeName;
	//河湖渠库名称
    @ApiModelProperty(value = "河湖渠库名称id",dataType="String",required = true,hidden = false)
	private String resourceId;
	//河湖渠库名称
    @ApiModelProperty(value = "河湖渠库名称",dataType="String",required = true,hidden = false)
	private String resourceName;
	//取水口个数
    @ApiModelProperty(value = "取水口个数",dataType="String",required = true,hidden = false)
	private String waterCount;
	//水质目标
    @ApiModelProperty(value = "水质目标",dataType="String",required = true,hidden = false)
	private String waterAim;
	//是否监测
    @ApiModelProperty(value = "是否监测",dataType="String",required = true,hidden = false)
	private String ismonitor;
	//水源地现状水质类别
    @ApiModelProperty(value = "水源地现状水质类别",dataType="String",required = true,hidden = false)
	private String waterLevel;
    //水源地现状水质类别名称
    @ApiModelProperty(value = "水源地现状水质类别名称",dataType="String",required = true,hidden = false)
	private String waterLevelName;
	//主要供水用途
    @ApiModelProperty(value = "主要供水用途",dataType="String",required = true,hidden = false)
	private String purpose;
	//供水人口（万人）
    @ApiModelProperty(value = "供水人口（万人）",dataType="String",required = true,hidden = false)
	private String peopleCount;
	//主要供水城镇名称
    @ApiModelProperty(value = "主要供水城镇名称",dataType="String",required = true,hidden = false)
	private String supplyAreaId;
	//供水规模（万立方米/日）
    @ApiModelProperty(value = "供水规模（万立方米/日）",dataType="String",required = true,hidden = false)
	private String waterSize;
	//生成时间
    @ApiModelProperty(value = "生成时间",dataType="Date",required = true,hidden = false)
	private Date createTime;
	//管理单位名称
    @ApiModelProperty(value = "管理单位名称",dataType="String",required = true,hidden = false)
	private String managerName;
	//管理单位编码
    @ApiModelProperty(value = "管理单位编码",dataType="String",required = true,hidden = false)
	private String managerCode;
	//管理部门所属行业
    @ApiModelProperty(value = "管理部门所属行业",dataType="String",required = true,hidden = false)
	private String managerTrade;

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
	 * 设置：水源地名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：水源地名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：水源地编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：水源地编码
	 */
	public String getCode() {
		return code;
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
	 * 设置：行政区划
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	/**
	 * 获取：行政区划
	 */
	public String getAreaId() {
		return areaId;
	}
	/**
	 * 设置：河湖渠库类型
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	/**
	 * 获取：河湖渠库类型
	 */
	public String getResourceType() {
		return resourceType;
	}
	/**
	 * 设置：河湖渠库名称
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	/**
	 * 获取：河湖渠库名称
	 */
	public String getResourceId() {
		return resourceId;
	}
	/**
	 * 设置：取水口个数
	 */
	public void setWaterCount(String waterCount) {
		this.waterCount = waterCount;
	}
	/**
	 * 获取：取水口个数
	 */
	public String getWaterCount() {
		return waterCount;
	}
	/**
	 * 设置：水质目标
	 */
	public void setWaterAim(String waterAim) {
		this.waterAim = waterAim;
	}
	/**
	 * 获取：水质目标
	 */
	public String getWaterAim() {
		return waterAim;
	}
	/**
	 * 设置：是否监测
	 */
	public void setIsmonitor(String ismonitor) {
		this.ismonitor = ismonitor;
	}
	/**
	 * 获取：是否监测
	 */
	public String getIsmonitor() {
		return ismonitor;
	}
	/**
	 * 设置：水源地现状水质类别

	 */
	public void setWaterLevel(String waterLevel) {
		this.waterLevel = waterLevel;
	}
	/**
	 * 获取：水源地现状水质类别

	 */
	public String getWaterLevel() {
		return waterLevel;
	}
	/**
	 * 设置：主要供水用途
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	/**
	 * 获取：主要供水用途
	 */
	public String getPurpose() {
		return purpose;
	}
	/**
	 * 设置：供水人口（万人）

	 */
	public void setPeopleCount(String peopleCount) {
		this.peopleCount = peopleCount;
	}
	/**
	 * 获取：供水人口（万人）

	 */
	public String getPeopleCount() {
		return peopleCount;
	}
	/**
	 * 设置：主要供水城镇名称

	 */
	public void setSupplyAreaId(String supplyAreaId) {
		this.supplyAreaId = supplyAreaId;
	}
	/**
	 * 获取：主要供水城镇名称

	 */
	public String getSupplyAreaId() {
		return supplyAreaId;
	}
	/**
	 * 设置：供水规模（万立方米/日）

	 */
	public void setWaterSize(String waterSize) {
		this.waterSize = waterSize;
	}
	/**
	 * 获取：供水规模（万立方米/日）

	 */
	public String getWaterSize() {
		return waterSize;
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
	/**
	 * 设置：管理单位名称
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	/**
	 * 获取：管理单位名称
	 */
	public String getManagerName() {
		return managerName;
	}
	/**
	 * 设置：管理单位编码
	 */
	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}
	/**
	 * 获取：管理单位编码
	 */
	public String getManagerCode() {
		return managerCode;
	}
	/**
	 * 设置：管理部门所属行业

	 */
	public void setManagerTrade(String managerTrade) {
		this.managerTrade = managerTrade;
	}
	/**
	 * 获取：管理部门所属行业

	 */
	public String getManagerTrade() {
		return managerTrade;
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
	public String getWaterLevelName() {
		return waterLevelName;
	}
	public void setWaterLevelName(String waterLevelName) {
		this.waterLevelName = waterLevelName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
}
