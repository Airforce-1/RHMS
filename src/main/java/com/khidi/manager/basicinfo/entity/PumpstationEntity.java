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
public class PumpstationEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//泵站管理单位编码
    @ApiModelProperty(value = "泵站管理单位编码",dataType="String",required = true,hidden = false)
	private String managerCode;
	//泵站归口管理部门
    @ApiModelProperty(value = "泵站归口管理部门",dataType="String",required = true,hidden = false)
	private String underManager;
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//泵站名称
    @ApiModelProperty(value = "泵站名称",dataType="String",required = true,hidden = false)
	private String name;
	//泵站编码
    @ApiModelProperty(value = "泵站编码",dataType="String",required = true,hidden = false)
	private String code;
	//经度
    @ApiModelProperty(value = "经度",dataType="String",required = true,hidden = false)
	private String x;
	//纬度
    @ApiModelProperty(value = "纬度",dataType="String",required = true,hidden = false)
	private String y;
	//泵站任务
    @ApiModelProperty(value = "泵站任务",dataType="String",required = true,hidden = false)
	private String task;
	//工程建设情况
    @ApiModelProperty(value = "工程建设情况",dataType="String",required = true,hidden = false)
	private String buildSiuation;
    //工程建设情况
    @ApiModelProperty(value = "工程建设情况名称",dataType="String",required = true,hidden = false)
	private String buildSiuationName;
	//建成时间
    @ApiModelProperty(value = "建成时间",dataType="Date",required = true,hidden = false)
	private Date buildTime;
	//工程等别
    @ApiModelProperty(value = "工程等别",dataType="String",required = true,hidden = false)
	private String grade;
	//主要建筑物级别
    @ApiModelProperty(value = "主要建筑物级别",dataType="String",required = true,hidden = false)
	private String buildLevel;
	//装机流量
    @ApiModelProperty(value = "装机流量",dataType="String",required = true,hidden = false)
	private String installedFlow;
	//装机功率
    @ApiModelProperty(value = "装机功率",dataType="String",required = true,hidden = false)
	private String installedPower;
	//设计扬程
    @ApiModelProperty(value = "设计扬程",dataType="String",required = true,hidden = false)
	private String designLength;
	//水泵数量
    @ApiModelProperty(value = "水泵数量",dataType="String",required = true,hidden = false)
	private String count;
	//泵站管理单位
    @ApiModelProperty(value = "泵站管理单位",dataType="String",required = true,hidden = false)
	private String managerName;
	//行政区划编码
    @ApiModelProperty(value = "行政区划编码",dataType="String",required = true,hidden = false)
	private String areaId;
    //行政区划编码名称
    @ApiModelProperty(value = "行政区划编码",dataType="String",required = true,hidden = false)
	private String areaName;
	//河湖渠库类型
    @ApiModelProperty(value = "河湖渠库类型",dataType="String",required = true,hidden = false)
	private String resourceType;
    //河湖渠库类型
    @ApiModelProperty(value = "河湖渠库类型名称",dataType="String",required = true,hidden = false)
	private String resourceTypeName;
	//河湖渠库编码
    @ApiModelProperty(value = "河湖渠库编码",dataType="String",required = true,hidden = false)
	private String resourceId;
    //河湖渠库编码
    @ApiModelProperty(value = "河湖渠库编码",dataType="String",required = true,hidden = false)
	private String resourceName;
	//生成时间
    @ApiModelProperty(value = "生成时间",dataType="Date",required = true,hidden = false)
	private Date createTime;

    
	public String getBuildSiuationName() {
		return buildSiuationName;
	}
	public void setBuildSiuationName(String buildSiuationName) {
		this.buildSiuationName = buildSiuationName;
	}
	/**
	 * 设置：泵站管理单位编码
	 */
	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}
	/**
	 * 获取：泵站管理单位编码
	 */
	public String getManagerCode() {
		return managerCode;
	}
	/**
	 * 设置：泵站归口管理部门
	 */
	public void setUnderManager(String underManager) {
		this.underManager = underManager;
	}
	/**
	 * 获取：泵站归口管理部门
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
	 * 设置：泵站名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：泵站名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：泵站编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：泵站编码
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
	 * 设置：泵站任务
	 */
	public void setTask(String task) {
		this.task = task;
	}
	/**
	 * 获取：泵站任务
	 */
	public String getTask() {
		return task;
	}
	/**
	 * 设置：工程建设情况
	 */
	public void setBuildSiuation(String buildSiuation) {
		this.buildSiuation = buildSiuation;
	}
	/**
	 * 获取：工程建设情况
	 */
	public String getBuildSiuation() {
		return buildSiuation;
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
	 * 设置：装机流量
	 */
	public void setInstalledFlow(String installedFlow) {
		this.installedFlow = installedFlow;
	}
	/**
	 * 获取：装机流量
	 */
	public String getInstalledFlow() {
		return installedFlow;
	}
	/**
	 * 设置：装机功率
	 */
	public void setInstalledPower(String installedPower) {
		this.installedPower = installedPower;
	}
	/**
	 * 获取：装机功率
	 */
	public String getInstalledPower() {
		return installedPower;
	}
	/**
	 * 设置：设计扬程
	 */
	public void setDesignLength(String designLength) {
		this.designLength = designLength;
	}
	/**
	 * 获取：设计扬程
	 */
	public String getDesignLength() {
		return designLength;
	}
	/**
	 * 设置：水泵数量
	 */
	public void setCount(String count) {
		this.count = count;
	}
	/**
	 * 获取：水泵数量
	 */
	public String getCount() {
		return count;
	}
	/**
	 * 设置：泵站管理单位
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	/**
	 * 获取：泵站管理单位
	 */
	public String getManagerName() {
		return managerName;
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
