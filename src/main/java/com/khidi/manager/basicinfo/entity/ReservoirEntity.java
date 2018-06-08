package com.khidi.manager.basicinfo.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * ${comments}
 *
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
public class ReservoirEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    // 编码
    @ApiModelProperty(value = "编码", dataType = "String", required = true, hidden = false)
    private String id;
    // 水库名称
    @ApiModelProperty(value = "水库名称", dataType = "String", required = true, hidden = false)
    private String name;
    // 水库编码
    @ApiModelProperty(value = "水库编码", dataType = "String", required = true, hidden = false)
    private String code;
    // 水库编码
    @ApiModelProperty(value = "所属行政区划名称", dataType = "String", required = false, hidden = false)
    private String areaName;
    // 所属行政区划
    @ApiModelProperty(value = "所属行政区划", dataType = "String", required = true, hidden = false)
    private String areaId;
    // 别名
    @ApiModelProperty(value = "别名", dataType = "String", required = true, hidden = false)
    private String alias;
    // 水库所在位置
    @ApiModelProperty(value = "水库所在位置", dataType = "String", required = true, hidden = false)
    private String location;
    // 左下角经度
    @ApiModelProperty(value = "左下角经度", dataType = "String", required = true, hidden = false)
    private String leftX;
    // 右上角经度
    @ApiModelProperty(value = "右上角经度", dataType = "String", required = true, hidden = false)
    private String rightX;
    // 右上角纬度
    @ApiModelProperty(value = "右上角纬度", dataType = "String", required = true, hidden = false)
    private String rightY;
    // 左下角纬度
    @ApiModelProperty(value = "左下角纬度", dataType = "String", required = true, hidden = false)
    private String leftY;
    // 水库类型
    @ApiModelProperty(value = "水库类型", dataType = "String", required = true, hidden = false)
    private String reservoirType;
    // 运行状况
    @ApiModelProperty(value = "运行状况", dataType = "String", required = true, hidden = false)
    private String reservoirWork;
    // 工程建设情况
    @ApiModelProperty(value = "工程建设情况", dataType = "String", required = true, hidden = false)
    private String build;
    // 工程等级
    @ApiModelProperty(value = "工程等级", dataType = "String", required = true, hidden = false)
    private String reservoirLevel;
    // 工程规模
    @ApiModelProperty(value = "工程规模", dataType = "String", required = true, hidden = false)
    private String scale;
    // 水源地级别
    @ApiModelProperty(value = "水源地级别", dataType = "String", required = true, hidden = false)
    private String waterLevel;
    // 防洪高水位
    @ApiModelProperty(value = "防洪高水位", dataType = "String", required = true, hidden = false)
    private String highLevel;
    // 正常蓄水位
    @ApiModelProperty(value = "正常蓄水位", dataType = "String", required = true, hidden = false)
    private String normalLevel;
    // 集雨面积
    @ApiModelProperty(value = "集雨面积", dataType = "String", required = true, hidden = false)
    private String area;
    // 正常蓄水位对应库容
    @ApiModelProperty(value = "正常蓄水位对应库容", dataType = "String", required = true, hidden = false)
    private String normalCapacity;
    // 总库容
    @ApiModelProperty(value = "总库容", dataType = "String", required = true, hidden = false)
    private String sumCapacity;
    // 调洪库容
    @ApiModelProperty(value = "调洪库容", dataType = "String", required = true, hidden = false)
    private String floodCapacity;
    // 死库容
    @ApiModelProperty(value = "死库容", dataType = "String", required = true, hidden = false)
    private String deadCapacity;
    // 防汛限制水位库容
    @ApiModelProperty(value = "防汛限制水位库容", dataType = "String", required = true, hidden = false)
    private String floodLimitCapacity;
    // 正常蓄水位对应水面面积
    @ApiModelProperty(value = "正常蓄水位对应水面面积", dataType = "String", required = true, hidden = false)
    private String normalArea;
    // 防洪限制水位
    @ApiModelProperty(value = "防洪限制水位", dataType = "String", required = true, hidden = false)
    private String floodLimitLevel;
    // 死水位
    @ApiModelProperty(value = "死水位", dataType = "String", required = true, hidden = false)
    private String deadLevel;
    // 坝址多年平均径流量
    @ApiModelProperty(value = "坝址多年平均径流量", dataType = "String", required = true, hidden = false)
    private String yearsFlow;
    // 开工时间
    @ApiModelProperty(value = "开工时间", dataType = "Date", required = true, hidden = false)
    private String starttime;
    // 建成时间
    @ApiModelProperty(value = "建成时间", dataType = "Date", required = true, hidden = false)
    private String endtime;
    // 归口管理单位
    @ApiModelProperty(value = "归口管理单位", dataType = "String", required = true, hidden = false)
    private String reservoirManager;
    // 备注
    @ApiModelProperty(value = "备注", dataType = "String", required = true, hidden = false)
    private String remark;

    // 水库类型名称
    @ApiModelProperty(value = "水库类型名称", dataType = "String", required = true, hidden = false)
    private String reservoirTypeName;
    // 运行状况名称
    @ApiModelProperty(value = "运行状况名称", dataType = "String", required = true, hidden = false)
    private String reservoirWorkName;
    // 工程建设情况名称
    @ApiModelProperty(value = "工程建设情况名称", dataType = "String", required = true, hidden = false)
    private String buildName;
    // 工程等级名称
    @ApiModelProperty(value = "工程等级名称", dataType = "String", required = true, hidden = false)
    private String reservoirLevelName;
    // 水源地级别名称
    @ApiModelProperty(value = "水源地级别名称", dataType = "String", required = true, hidden = false)
    private String waterLevelName;
    // 工程规模名称
    @ApiModelProperty(value = "工程规模名称", dataType = "String", required = true, hidden = false)
    private String scaleName;


    //库段长
    @ApiModelProperty(value = "库段长", dataType = "String", required = true, hidden = false)
    private String header;
    //协调员
    @ApiModelProperty(value = "协调员", dataType = "String", required = true, hidden = false)
    private String coordinater;
    //库道警长（姓名）
    @ApiModelProperty(value = "库道警长（姓名）", dataType = "String", required = true, hidden = false)
    private String policeman;
    //巡查员
    @ApiModelProperty(value = "巡查员", dataType = "String", required = true, hidden = false)
    private String checker;
    //督察长
    @ApiModelProperty(value = "督察长", dataType = "String", required = true, hidden = false)
    private String superviser;
    //水库长职责
    @ApiModelProperty(value = "水库长职责", dataType = "String", required = true, hidden = false)
    private String duty;
    //整治目标
    @ApiModelProperty(value = "整治目标", dataType = "String", required = true, hidden = false)
    private String aim;
    //库长备注
    @ApiModelProperty(value = "库长备注", dataType = "String", required = true, hidden = false)
    private String headerremark;
    //协调员职务
    @ApiModelProperty(value = "协调员职务", dataType = "String", required = true, hidden = false)
    private String coordinaterpost;
    //巡查员职务
    @ApiModelProperty(value = "巡查员职务", dataType = "String", required = true, hidden = false)
    private String checkerpost;
    //督察长职务
    @ApiModelProperty(value = "督察长职务", dataType = "String", required = true, hidden = false)
    private String superviserpost;
    //库段长职务
    @ApiModelProperty(value = "库段长职务", dataType = "String", required = true, hidden = false)
    private String headerpost;
    //地图资源编码
    @ApiModelProperty(value = "地图资源编码", dataType = "String", required = true, hidden = false)
    private String featureId;

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public String getScaleName() {
        return scaleName;
    }

    public void setScaleName(String scaleName) {
        this.scaleName = scaleName;
    }

    /**
     * 设置：协调员职务
     */
    public void setCoordinaterpost(String coordinaterpost) {
        this.coordinaterpost = coordinaterpost;
    }

    /**
     * 获取：协调员职务
     */
    public String getCoordinaterpost() {
        return coordinaterpost;
    }

    /**
     * 设置：巡查员职务
     */
    public void setCheckerpost(String checkerpost) {
        this.checkerpost = checkerpost;
    }

    /**
     * 获取：巡查员职务
     */
    public String getCheckerpost() {
        return checkerpost;
    }

    /**
     * 设置：督察长职务
     */
    public void setSuperviserpost(String superviserpost) {
        this.superviserpost = superviserpost;
    }

    /**
     * 获取：督察长职务
     */
    public String getSuperviserpost() {
        return superviserpost;
    }

    /**
     * 设置：库段长职务
     */
    public void setHeaderpost(String headerpost) {
        this.headerpost = headerpost;
    }

    /**
     * 获取：库段长职务
     */
    public String getHeaderpost() {
        return headerpost;
    }

    /**
     * 设置：库段长
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * 获取：库段长
     */
    public String getHeader() {
        return header;
    }

    /**
     * 设置：协调员
     */
    public void setCoordinater(String coordinater) {
        this.coordinater = coordinater;
    }

    /**
     * 获取：协调员
     */
    public String getCoordinater() {
        return coordinater;
    }

    /**
     * 设置：库道警长（姓名）
     */
    public void setPoliceman(String policeman) {
        this.policeman = policeman;
    }

    /**
     * 获取：库道警长（姓名）
     */
    public String getPoliceman() {
        return policeman;
    }

    /**
     * 设置：巡查员
     */
    public void setChecker(String checker) {
        this.checker = checker;
    }

    /**
     * 获取：巡查员
     */
    public String getChecker() {
        return checker;
    }

    /**
     * 设置：督察长
     */
    public void setSuperviser(String superviser) {
        this.superviser = superviser;
    }

    /**
     * 获取：督察长
     */
    public String getSuperviser() {
        return superviser;
    }

    /**
     * 设置：水库长职责
     */
    public void setDuty(String duty) {
        this.duty = duty;
    }

    /**
     * 获取：水库长职责
     */
    public String getDuty() {
        return duty;
    }

    /**
     * 设置：整治目标
     */
    public void setAim(String aim) {
        this.aim = aim;
    }

    /**
     * 获取：整治目标
     */
    public String getAim() {
        return aim;
    }

    /**
     * 设置：库长备注
     */
    public void setHeaderremark(String headerremark) {
        this.headerremark = headerremark;
    }

    /**
     * 获取：库长备注
     */
    public String getHeaderremark() {
        return headerremark;
    }

    /**
     * 获取：水源地级别名称
     */
    public String getWaterLevelName() {
        return waterLevelName;
    }

    /**
     * 设置：水源地级别名称
     */
    public void setWaterLevelName(String waterLevelName) {
        this.waterLevelName = waterLevelName;
    }

    /**
     * 获取：水库类型名称
     */
    public String getReservoirTypeName() {
        return reservoirTypeName;
    }

    /**
     * 设置：水库类型名称
     */
    public void setReservoirTypeName(String reservoirTypeName) {
        this.reservoirTypeName = reservoirTypeName;
    }

    /**
     * 获取：运行状况名称
     */
    public String getReservoirWorkName() {
        return reservoirWorkName;
    }

    /**
     * 设置：运行状况名称
     */
    public void setReservoirWorkName(String reservoirWorkName) {
        this.reservoirWorkName = reservoirWorkName;
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
     * 获取：工程等级名称
     */
    public String getReservoirLevelName() {
        return reservoirLevelName;
    }

    /**
     * 设置：工程等级名称
     */
    public void setReservoirLevelName(String reservoirLevelName) {
        this.reservoirLevelName = reservoirLevelName;
    }

    /**
     * 获取：所属行政编码
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置：所属行政编码
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 设置：编码
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取：编码
     */
    public String getId() {
        return id;
    }

    /**
     * 设置：水库名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：水库名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：水库编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取：水库编码
     */
    public String getCode() {
        return code;
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
     * 设置：别名
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * 获取：别名
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 设置：水库所在位置
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 获取：水库所在位置
     */
    public String getLocation() {
        return location;
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
     * 设置：水库类型
     */
    public void setReservoirType(String reservoirType) {
        this.reservoirType = reservoirType;
    }

    /**
     * 获取：水库类型
     */
    public String getReservoirType() {
        return reservoirType;
    }

    /**
     * 设置：运行状况
     */
    public void setReservoirWork(String reservoirWork) {
        this.reservoirWork = reservoirWork;
    }

    /**
     * 获取：运行状况
     */
    public String getReservoirWork() {
        return reservoirWork;
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
     * 设置：工程等级
     */
    public void setReservoirLevel(String reservoirLevel) {
        this.reservoirLevel = reservoirLevel;
    }

    /**
     * 获取：工程等级
     */
    public String getReservoirLevel() {
        return reservoirLevel;
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
     * 设置：水源地级别
     */
    public void setWaterLevel(String waterLevel) {
        this.waterLevel = waterLevel;
    }

    /**
     * 获取：水源地级别
     */
    public String getWaterLevel() {
        return waterLevel;
    }

    /**
     * 设置：防洪高水位
     */
    public void setHighLevel(String highLevel) {
        this.highLevel = highLevel;
    }

    /**
     * 获取：防洪高水位
     */
    public String getHighLevel() {
        return highLevel;
    }

    /**
     * 设置：正常蓄水位
     */
    public void setNormalLevel(String normalLevel) {
        this.normalLevel = normalLevel;
    }

    /**
     * 获取：正常蓄水位
     */
    public String getNormalLevel() {
        return normalLevel;
    }

    /**
     * 设置：集雨面积
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取：集雨面积
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置：正常蓄水位对应库容
     */
    public void setNormalCapacity(String normalCapacity) {
        this.normalCapacity = normalCapacity;
    }

    /**
     * 获取：正常蓄水位对应库容
     */
    public String getNormalCapacity() {
        return normalCapacity;
    }

    /**
     * 设置：总库容
     */
    public void setSumCapacity(String sumCapacity) {
        this.sumCapacity = sumCapacity;
    }

    /**
     * 获取：总库容
     */
    public String getSumCapacity() {
        return sumCapacity;
    }

    /**
     * 设置：调洪库容
     */
    public void setFloodCapacity(String floodCapacity) {
        this.floodCapacity = floodCapacity;
    }

    /**
     * 获取：调洪库容
     */
    public String getFloodCapacity() {
        return floodCapacity;
    }

    /**
     * 设置：死库容
     */
    public void setDeadCapacity(String deadCapacity) {
        this.deadCapacity = deadCapacity;
    }

    /**
     * 获取：死库容
     */
    public String getDeadCapacity() {
        return deadCapacity;
    }

    /**
     * 设置：防汛限制水位库容
     */
    public void setFloodLimitCapacity(String floodLimitCapacity) {
        this.floodLimitCapacity = floodLimitCapacity;
    }

    /**
     * 获取：防汛限制水位库容
     */
    public String getFloodLimitCapacity() {
        return floodLimitCapacity;
    }

    /**
     * 设置：正常蓄水位对应水面面积
     */
    public void setNormalArea(String normalArea) {
        this.normalArea = normalArea;
    }

    /**
     * 获取：正常蓄水位对应水面面积
     */
    public String getNormalArea() {
        return normalArea;
    }

    /**
     * 设置：防洪限制水位
     */
    public void setFloodLimitLevel(String floodLimitLevel) {
        this.floodLimitLevel = floodLimitLevel;
    }

    /**
     * 获取：防洪限制水位
     */
    public String getFloodLimitLevel() {
        return floodLimitLevel;
    }

    /**
     * 设置：死水位
     */
    public void setDeadLevel(String deadLevel) {
        this.deadLevel = deadLevel;
    }

    /**
     * 获取：死水位
     */
    public String getDeadLevel() {
        return deadLevel;
    }

    /**
     * 设置：坝址多年平均径流量
     */
    public void setYearsFlow(String yearsFlow) {
        this.yearsFlow = yearsFlow;
    }

    /**
     * 获取：坝址多年平均径流量
     */
    public String getYearsFlow() {
        return yearsFlow;
    }

    /**
     * 设置：开工时间
     */
    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    /**
     * 获取：开工时间
     */
    public String getStarttime() {
        return starttime;
    }

    /**
     * 设置：建成时间
     */
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }


    /**
     * 获取：建成时间
     */
    public String getEndtime() {
        return endtime;
    }


    /**
     * 设置：归口管理单位
     */
    public void setReservoirManager(String reservoirManager) {
        this.reservoirManager = reservoirManager;
    }

    /**
     * 获取：归口管理单位
     */
    public String getReservoirManager() {
        return reservoirManager;
    }

    /**
     * 设置：备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
    }
}
