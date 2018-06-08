package com.khidi.manager.basicinfo.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-24 08:27:48
 */
public class ResourceIrrigatedEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	// 灌区编码
	@ApiModelProperty(value = "灌区编码", dataType = "String", required = true, hidden = false)
	private String code;
	// 灌区名称
	@ApiModelProperty(value = "灌区名称", dataType = "String", required = true, hidden = false)
	private String name;
	// 左下角经度
	@ApiModelProperty(value = "左下角经度", dataType = "String", required = true, hidden = false)
	private String leftX;
	// 左下角纬度
	@ApiModelProperty(value = "左下角纬度", dataType = "String", required = true, hidden = false)
	private String leftY;
	// 右上角经度
	@ApiModelProperty(value = "右上角经度", dataType = "String", required = true, hidden = false)
	private String rightX;
	// 右上角纬度
	@ApiModelProperty(value = "右上角纬度", dataType = "String", required = true, hidden = false)
	private String rightY;
	// 行政区划
	@ApiModelProperty(value = "行政区划编码", dataType = "String", required = true, hidden = false)
	private String areaId;
	// 行政区划名称
	@ApiModelProperty(value = "行政区划名称", dataType = "String", required = true, hidden = false)
	private String areaName;
	// 工程规模
	@ApiModelProperty(value = "工程规模", dataType = "String", required = true, hidden = false)
	private String scale;
	// 工程规模名称
	@ApiModelProperty(value = "工程规模名称", dataType = "String", required = true, hidden = false)
	private String scaleName;
	// 用水类型
	@ApiModelProperty(value = "用水类型", dataType = "String", required = true, hidden = false)
	private String wateruserType;
	//用水类型名称
	@ApiModelProperty(value = "用水类型名称", dataType = "String", required = true, hidden = false)
	private String wateruserName;
	// 水源类型
	@ApiModelProperty(value = "水源类型", dataType = "String", required = true, hidden = false)
	private String waterType;
	// 水源名称
	@ApiModelProperty(value = "水源名称", dataType = "String", required = true, hidden = false)
	private String waterTypeName;
	// 工程建设情况
	@ApiModelProperty(value = "工程建设情况", dataType = "String", required = true, hidden = false)
	private String build;
	// 运行状况
	@ApiModelProperty(value = "运行状况", dataType = "String", required = true, hidden = false)
	private String work;
	// 灌区范围
	@ApiModelProperty(value = "灌区范围", dataType = "String", required = true, hidden = false)
	private String extent;
	// 设计灌溉面积(亩)
	@ApiModelProperty(value = "设计灌溉面积(亩)", dataType = "String", required = true, hidden = false)
	private String designExtent;
	// 总灌溉面积(亩)
	@ApiModelProperty(value = "总灌溉面积(亩)", dataType = "String", required = true, hidden = false)
	private String sumExtent;
	// 有效灌溉面积(亩)
	@ApiModelProperty(value = "有效灌溉面积(亩)", dataType = "String", required = true, hidden = false)
	private String validExtent;
	// 开工时间
	@ApiModelProperty(value = "开工时间", dataType = "Date", required = true, hidden = false)
	private Date starttime;
	// 建成时间
	@ApiModelProperty(value = "建成时间", dataType = "Date", required = true, hidden = false)
	private Date buildtime;
	// 备注
	@ApiModelProperty(value = "备注", dataType = "String", required = true, hidden = false)
	private String reamrk;
	// 系统编码
	@ApiModelProperty(value = "系统编码", dataType = "String", required = true, hidden = false)
	private String id;
	// 工程建设情况名称
	@ApiModelProperty(value = "工程建设情况名称", dataType = "String", required = true, hidden = false)
	private String buildName;
	// 运行状况名称
	@ApiModelProperty(value = "运行状况名称", dataType = "String", required = true, hidden = false)
	private String workName;
	//坐标点集
	@ApiModelProperty(value = "坐标点集",dataType="String",required = true,hidden = false)
	private String pointSet;

	public String getPointSet() {
		return pointSet;
	}

	public void setPointSet(String pointSet) {
		this.pointSet = pointSet;
	}

	/**
	 * 获取：工程建设情况名称
	 */
	public String getBuildName() {
		return buildName;
	}

	/**
	 * 设置：工程建设情况名称
	 */
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	/**
	 * 获取：运行状况名称
	 */
	public String getWorkName() {
		return workName;
	}

	/**
	 * 设置：运行状况名称
	 */
	public void setWorkName(String workName) {
		this.workName = workName;
	}

	/**
	 * 获取：水源名称
	 */
	public String getWaterTypeName() {
		return waterTypeName;
	}
	/**
	 * 设置：水源名称
	 */
	public void setWaterTypeName(String waterTypeName) {
		this.waterTypeName = waterTypeName;
	}
	/**
	 * 获取：行政区划名称
	 */
	public String getAreaName() {
		return areaName;
	}
	/**
	 * 设置：行政区划名称
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	/**
	 * 获取：工程规模名称
	 */
	public String getScaleName() {
		return scaleName;
	}
	/**
	 * 设置：工程规模名称
	 */
	public void setScaleName(String scaleName) {
		this.scaleName = scaleName;
	}
	/**
	 * 获取：用水名称
	 */
	public String getWateruserName() {
		return wateruserName;
	}
	/**
	 * 设置：用水名称
	 */
	public void setWateruserName(String wateruserName) {
		this.wateruserName = wateruserName;
	}

	/**
	 * 设置：灌区编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取：灌区编码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置：灌区名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：灌区名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：左下角经度
	 */
	public void setLeftX(String leftX) {
		this.leftX = leftX;
	}

	/**
	 * 获取：左下角经度
	 */
	public String getLeftX() {
		return leftX;
	}

	/**
	 * 设置：左下角纬度
	 */
	public void setLeftY(String leftY) {
		this.leftY = leftY;
	}

	/**
	 * 获取：左下角纬度
	 */
	public String getLeftY() {
		return leftY;
	}

	/**
	 * 设置：右上角经度
	 */
	public void setRightX(String rightX) {
		this.rightX = rightX;
	}

	/**
	 * 获取：右上角经度
	 */
	public String getRightX() {
		return rightX;
	}

	/**
	 * 设置：右上角纬度
	 */
	public void setRightY(String rightY) {
		this.rightY = rightY;
	}

	/**
	 * 获取：右上角纬度
	 */
	public String getRightY() {
		return rightY;
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
	 * 设置：工程规模
	 */
	public void setScale(String scale) {
		this.scale = scale;
	}

	/**
	 * 获取：工程规模
	 */
	public String getScale() {
		return scale;
	}

	/**
	 * 设置：用水类型
	 */
	public void setWateruserType(String wateruserType) {
		this.wateruserType = wateruserType;
	}

	/**
	 * 获取：用水类型
	 */
	public String getWateruserType() {
		return wateruserType;
	}

	/**
	 * 设置：水源类型
	 */
	public void setWaterType(String waterType) {
		this.waterType = waterType;
	}

	/**
	 * 获取：水源类型
	 */
	public String getWaterType() {
		return waterType;
	}

	/**
	 * 设置：工程建设情况
	 */
	public void setBuild(String build) {
		this.build = build;
	}

	/**
	 * 获取：工程建设情况
	 */
	public String getBuild() {
		return build;
	}

	/**
	 * 设置：运行状况
	 */
	public void setWork(String work) {
		this.work = work;
	}

	/**
	 * 获取：运行状况
	 */
	public String getWork() {
		return work;
	}

	/**
	 * 设置：灌区范围
	 */
	public void setExtent(String extent) {
		this.extent = extent;
	}

	/**
	 * 获取：灌区范围
	 */
	public String getExtent() {
		return extent;
	}

	/**
	 * 设置：设计灌溉面积(亩)
	 */
	public void setDesignExtent(String designExtent) {
		this.designExtent = designExtent;
	}

	/**
	 * 获取：设计灌溉面积(亩)
	 */
	public String getDesignExtent() {
		return designExtent;
	}

	/**
	 * 设置：总灌溉面积(亩)
	 */
	public void setSumExtent(String sumExtent) {
		this.sumExtent = sumExtent;
	}

	/**
	 * 获取：总灌溉面积(亩)
	 */
	public String getSumExtent() {
		return sumExtent;
	}

	/**
	 * 设置：有效灌溉面积(亩)
	 */
	public void setValidExtent(String validExtent) {
		this.validExtent = validExtent;
	}

	/**
	 * 获取：有效灌溉面积(亩)
	 */
	public String getValidExtent() {
		return validExtent;
	}

	/**
	 * 设置：开工时间
	 */
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	/**
	 * 获取：开工时间
	 */
	public Date getStarttime() {
		return starttime;
	}

	/**
	 * 设置：建成时间
	 */
	public void setBuildtime(Date buildtime) {
		this.buildtime = buildtime;
	}

	/**
	 * 获取：建成时间
	 */
	public Date getBuildtime() {
		return buildtime;
	}

	/**
	 * 设置：备注
	 */
	public void setReamrk(String reamrk) {
		this.reamrk = reamrk;
	}

	/**
	 * 获取：备注
	 */
	public String getReamrk() {
		return reamrk;
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
}
