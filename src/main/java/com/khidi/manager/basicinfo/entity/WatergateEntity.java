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
public class WatergateEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//水闸编码
    @ApiModelProperty(value = "水闸编码",dataType="String",required = true,hidden = false)
	private String code;
	//经度
    @ApiModelProperty(value = "经度",dataType="String",required = true,hidden = false)
	private String x;
	//纬度
    @ApiModelProperty(value = "纬度",dataType="String",required = true,hidden = false)
	private String y;
	//水闸类型
    @ApiModelProperty(value = "水闸类型",dataType="String",required = true,hidden = false)
	private String type;
    //水闸类型名称
    @ApiModelProperty(value = "水闸类型名称",dataType="String",required = true,hidden = false)
	private String typeName;
	//工程建设情况
    @ApiModelProperty(value = "工程建设情况",dataType="String",required = true,hidden = false)
	private String buildSituation;
    //工程建设情况名称
    @ApiModelProperty(value = "工程建设情况名称",dataType="String",required = true,hidden = false)
	private String buildSituationName;
	//建成时间
    @ApiModelProperty(value = "建成时间",dataType="Date",required = true,hidden = false)
	private Date buildTime;
	//所在灌区
    @ApiModelProperty(value = "所在灌区",dataType="String",required = true,hidden = false)
	private String irrigatedId;
	//是否闸站工程
    @ApiModelProperty(value = "是否闸站工程",dataType="String",required = true,hidden = false)
	private String islockstation;
	//是否套站工程
    @ApiModelProperty(value = "是否套站工程",dataType="String",required = true,hidden = false)
	private String iswaterlock;
	//水闸管理单位
    @ApiModelProperty(value = "水闸管理单位",dataType="String",required = true,hidden = false)
	private String managerName;
	//行政区划
    @ApiModelProperty(value = "行政区划",dataType="String",required = true,hidden = false)
	private String areaId;
    //行政区划名称
    @ApiModelProperty(value = "行政区划",dataType="String",required = true,hidden = false)
	private String areaName;
	//生成时间
    @ApiModelProperty(value = "生成时间",dataType="Date",required = true,hidden = false)
	private Date createTime;
	//管理单位编码
    @ApiModelProperty(value = "管理单位编码",dataType="String",required = true,hidden = false)
	private String managerCode;
	//水闸归口管理单位

    @ApiModelProperty(value = "水闸归口管理单位",dataType="String",required = true,hidden = false)
	private String underManager;
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//水闸名称
    @ApiModelProperty(value = "水闸名称",dataType="String",required = true,hidden = false)
	private String name;
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
    //工程等别
    @ApiModelProperty(value = "工程等别",dataType="String",required = true,hidden = false)
	private String grade;
    
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getBuildSituationName() {
		return buildSituationName;
	}
	public void setBuildSituationName(String buildSituationName) {
		this.buildSituationName = buildSituationName;
	}
	/**
	 * 设置：水闸编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：水闸编码
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
	 * 设置：水闸类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：水闸类型
	 */
	public String getType() {
		return type;
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
	 * 设置：所在灌区
	 */
	public void setIrrigatedId(String irrigatedId) {
		this.irrigatedId = irrigatedId;
	}
	/**
	 * 获取：所在灌区
	 */
	public String getIrrigatedId() {
		return irrigatedId;
	}
	/**
	 * 设置：是否闸站工程
	 */
	public void setIslockstation(String islockstation) {
		this.islockstation = islockstation;
	}
	/**
	 * 获取：是否闸站工程
	 */
	public String getIslockstation() {
		return islockstation;
	}
	/**
	 * 设置：是否套站工程
	 */
	public void setIswaterlock(String iswaterlock) {
		this.iswaterlock = iswaterlock;
	}
	/**
	 * 获取：是否套站工程
	 */
	public String getIswaterlock() {
		return iswaterlock;
	}
	/**
	 * 设置：水闸管理单位
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	/**
	 * 获取：水闸管理单位
	 */
	public String getManagerName() {
		return managerName;
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
	 * 设置：水闸归口管理单位

	 */
	public void setUnderManager(String underManager) {
		this.underManager = underManager;
	}
	/**
	 * 获取：水闸归口管理单位

	 */
	public String getUnderManager() {
		return underManager;
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
	 * 设置：水闸名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：水闸名称
	 */
	public String getName() {
		return name;
	}
	
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public String getResourceTypeName() {
		return resourceTypeName;
	}
	public void setResourceTypeName(String resourceTypeName) {
		this.resourceTypeName = resourceTypeName;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
