package com.khidi.manager.basicinfo.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * ${comments}
 *
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-23 10:22:51
 */
public class ResourceBridgeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    // 系统编码
    @ApiModelProperty(value = "系统编码", dataType = "String", required = true, hidden = false)
    private String id;
    // 桥梁编码
    @ApiModelProperty(value = "桥梁编码", dataType = "String", required = true, hidden = false)
    private String code;
    // 桥梁名称
    @ApiModelProperty(value = "桥梁名称", dataType = "String", required = true, hidden = false)
    private String name;
    // 桥梁起点位置
    @ApiModelProperty(value = "桥梁起点位置", dataType = "String", required = true, hidden = false)
    private String bridgeStart;
    // 桥梁终点位置
    @ApiModelProperty(value = "桥梁终点位置", dataType = "String", required = true, hidden = false)
    private String bridgeEnd;
    // 起点经度
    @ApiModelProperty(value = "起点经度", dataType = "String", required = true, hidden = false)
    private String startX;
    // 起点纬度
    @ApiModelProperty(value = "起点纬度", dataType = "String", required = true, hidden = false)
    private String startY;
    // 终点经度
    @ApiModelProperty(value = "终点经度", dataType = "String", required = true, hidden = false)
    private String endX;
    // 终点纬度
    @ApiModelProperty(value = "终点纬度", dataType = "String", required = true, hidden = false)
    private String endY;
    // 行政区划编码
    @ApiModelProperty(value = "行政区划编码", dataType = "String", required = true, hidden = false)
    private String areaId;
    // 行政区划名称
    @ApiModelProperty(value = "所属行政区划名称", dataType = "String", required = true, hidden = false)
    private String areaName;
    // 桥梁长度（m）
    @ApiModelProperty(value = "桥梁长度（m）", dataType = "String", required = true, hidden = false)
    private String bridgeLength;
    // 跨越河流类型
    @ApiModelProperty(value = "跨越河流类型", dataType = "String", required = true, hidden = false)
    private String resourceType;
    // 跨越河流编码
    @ApiModelProperty(value = "跨越河流编码", dataType = "String", required = true, hidden = false)
    private String resourceId;
    // 工程建设情况
    @ApiModelProperty(value = "工程建设情况", dataType = "String", required = true, hidden = false)
    private String stationBuild;
    // 运行状况
    @ApiModelProperty(value = "运行状况", dataType = "String", required = true, hidden = false)
    private String stationSituation;
    // 开工时间
    @ApiModelProperty(value = "开工时间", dataType = "Date", required = true, hidden = false)
    private Date stationStarttime;
    // 建成时间
    @ApiModelProperty(value = "建成时间", dataType = "Date", required = true, hidden = false)
    private Date stationBuildtime;
    // 备注
    @ApiModelProperty(value = "备注", dataType = "String", required = true, hidden = false)
    private String remark;
    // 跨越河流名称
    @ApiModelProperty(value = "跨越河流名称", dataType = "String", required = true, hidden = false)
    private String resourceName;
    // 跨越河流类型名称
    @ApiModelProperty(value = "跨越河流类型名称", dataType = "String", required = true, hidden = false)
    private String resourceTypeName;
    //工程建设情况名称
    @ApiModelProperty(value = "工程建设情况名称", dataType = "String", required = true, hidden = false)
    private String stationBuildName;
    //运行状况名称
    @ApiModelProperty(value = "运行状况名称", dataType = "String", required = true, hidden = false)
    private String stationSituationName;

    /**
     * 获取：运行状况名称
     */
    public String getStationSituationName() {
        return stationSituationName;
    }

    /**
     * 设置：运行状况名称
     */
    public void setStationSituationName(String stationSituationName) {
        this.stationSituationName = stationSituationName;
    }

    /**
     * 获取：工程建设情况名称
     */
    public String getStationBuildName() {
        return stationBuildName;
    }

    /**
     * 设置：工程建设情况名称
     */
    public void setStationBuildName(String stationBuildName) {
        this.stationBuildName = stationBuildName;
    }

    /**
     * 获取：跨越河流名称
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * 设置：跨越河流名称
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * 获取：跨越河流类型名称
     */
    public String getResourceTypeName() {
        return resourceTypeName;
    }

    /**
     * 设置：跨越河流类型名称
     */
    public void setResourceTypeName(String resourceTypeName) {
        this.resourceTypeName = resourceTypeName;
    }

    /**
     * 获取：所属行政区划名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置：所属行政区划名称
     */
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
     * 设置：桥梁编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取：桥梁编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置：桥梁名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：桥梁名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：桥梁起点位置
     */
    public void setBridgeStart(String bridgeStart) {
        this.bridgeStart = bridgeStart;
    }

    /**
     * 获取：桥梁起点位置
     */
    public String getBridgeStart() {
        return bridgeStart;
    }

    /**
     * 设置：桥梁终点位置
     */
    public void setBridgeEnd(String bridgeEnd) {
        this.bridgeEnd = bridgeEnd;
    }

    /**
     * 获取：桥梁终点位置
     */
    public String getBridgeEnd() {
        return bridgeEnd;
    }

    /**
     * 设置：起点经度
     */
    public void setStartX(String startX) {
        this.startX = startX;
    }

    /**
     * 获取：起点经度
     */
    public String getStartX() {
        return startX;
    }

    /**
     * 设置：起点纬度
     */
    public void setStartY(String startY) {
        this.startY = startY;
    }

    /**
     * 获取：起点纬度
     */
    public String getStartY() {
        return startY;
    }

    /**
     * 设置：终点经度
     */
    public void setEndX(String endX) {
        this.endX = endX;
    }

    /**
     * 获取：终点经度
     */
    public String getEndX() {
        return endX;
    }

    /**
     * 设置：终点纬度
     */
    public void setEndY(String endY) {
        this.endY = endY;
    }

    /**
     * 获取：终点纬度
     */
    public String getEndY() {
        return endY;
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
     * 设置：桥梁长度（m）
     */
    public void setBridgeLength(String bridgeLength) {
        this.bridgeLength = bridgeLength;
    }

    /**
     * 获取：桥梁长度（m）
     */
    public String getBridgeLength() {
        return bridgeLength;
    }

    /**
     * 设置：跨越河流类型
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * 获取：跨越河流类型
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * 设置：跨越河流编码
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 获取：跨越河流编码
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * 设置：工程建设情况
     */
    public void setStationBuild(String stationBuild) {
        this.stationBuild = stationBuild;
    }

    /**
     * 获取：工程建设情况
     */
    public String getStationBuild() {
        return stationBuild;
    }

    /**
     * 设置：运行状况
     */
    public void setStationSituation(String stationSituation) {
        this.stationSituation = stationSituation;
    }

    /**
     * 获取：运行状况
     */
    public String getStationSituation() {
        return stationSituation;
    }

    /**
     * 设置：开工时间
     */
    public void setStationStarttime(Date stationStarttime) {
        this.stationStarttime = stationStarttime;
    }

    /**
     * 获取：开工时间
     */
    public Date getStationStarttime() {
        return stationStarttime;
    }

    /**
     * 设置：建成时间
     */
    public void setStationBuildtime(Date stationBuildtime) {
        this.stationBuildtime = stationBuildtime;
    }

    /**
     * 获取：建成时间
     */
    public Date getStationBuildtime() {
        return stationBuildtime;
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
