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
public class PartReservoirEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //编码
    @ApiModelProperty(value = "编码", dataType = "String", required = true, hidden = false)
    private String id;
    //所属水库编码
    @ApiModelProperty(value = "所属水库编码", dataType = "String", required = true, hidden = false)
    private String reservoirId;
    //所属水库名称
    @ApiModelProperty(value = "所属水库名称", dataType = "String", required = true, hidden = false)
    private String reservoirName;
    //库段名称
    @ApiModelProperty(value = "库段名称", dataType = "String", required = true, hidden = false)
    private String name;
    //所属行政区划
    @ApiModelProperty(value = "所属行政区划", dataType = "String", required = true, hidden = false)
    private String areaId;
    //所属行政区划名称
    @ApiModelProperty(value = "所属行政区划名称", dataType = "String", required = true, hidden = false)
    private String areaName;
    //库段编码
    @ApiModelProperty(value = "库段编码", dataType = "String", required = true, hidden = false)
    private String code;
    //别名
    @ApiModelProperty(value = "别名", dataType = "String", required = true, hidden = false)
    private String alias;
    //库段起点位置
    @ApiModelProperty(value = "库段起点位置", dataType = "String", required = true, hidden = false)
    private String riverStart;
    //库段终点位置
    @ApiModelProperty(value = "库段终点位置", dataType = "String", required = true, hidden = false)
    private String riverEnd;
    //起点经度
    @ApiModelProperty(value = "起点经度", dataType = "String", required = true, hidden = false)
    private String startX;
    //起点纬度
    @ApiModelProperty(value = "起点纬度", dataType = "String", required = true, hidden = false)
    private String startY;
    //终点经度
    @ApiModelProperty(value = "终点经度", dataType = "String", required = true, hidden = false)
    private String endX;
    //终点纬度
    @ApiModelProperty(value = "终点纬度", dataType = "String", required = true, hidden = false)
    private String endY;
    //库段长度
    @ApiModelProperty(value = "库段长度", dataType = "String", required = true, hidden = false)
    private String length;
    //备注
    @ApiModelProperty(value = "备注", dataType = "String", required = true, hidden = false)
    private String remark;
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
    //库段长职务
    @ApiModelProperty(value = "库段长职务", dataType = "String", required = true, hidden = false)
    private String headerpost;
    //协调员职务
    @ApiModelProperty(value = "协调员职务", dataType = "String", required = true, hidden = false)
    private String coordinaterpost;
    //巡查员职务
    @ApiModelProperty(value = "巡查员职务", dataType = "String", required = true, hidden = false)
    private String checkerpost;
    //督察长职务
    @ApiModelProperty(value = "督察长职务", dataType = "String", required = true, hidden = false)
    private String superviserpost;
    //地图资源编码
    @ApiModelProperty(value = "地图资源编码", dataType = "String", required = true, hidden = false)
    private String featureId;

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
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

    public String getReservoirName() {
        return reservoirName;
    }

    public void setReservoirName(String reservoirName) {
        this.reservoirName = reservoirName;
    }

    public String getAreaName() {
        return areaName;
    }

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

    public String getReservoirId() {
        return reservoirId;
    }

    public void setReservoirId(String reservoirId) {
        this.reservoirId = reservoirId;
    }

    /**
     * 设置：库段名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：库段名称
     */
    public String getName() {
        return name;
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
     * 设置：库段编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取：库段编码
     */
    public String getCode() {
        return code;
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
     * 设置：库段起点位置
     */
    public void setRiverStart(String riverStart) {
        this.riverStart = riverStart;
    }

    /**
     * 获取：库段起点位置
     */
    public String getRiverStart() {
        return riverStart;
    }

    /**
     * 设置：库段终点位置
     */
    public void setRiverEnd(String riverEnd) {
        this.riverEnd = riverEnd;
    }

    /**
     * 获取：库段终点位置
     */
    public String getRiverEnd() {
        return riverEnd;
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
     * 设置：库段长度
     */
    public void setLength(String length) {
        this.length = length;
    }

    /**
     * 获取：库段长度
     */
    public String getLength() {
        return length;
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
