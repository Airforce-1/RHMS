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
public class LakeEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    // 编码
    @ApiModelProperty(value = "编码", dataType = "String", required = true, hidden = false)
    private String id;
    // 湖泊名称
    @ApiModelProperty(value = "湖泊名称", dataType = "String", required = true, hidden = false)
    private String name;
    // 湖泊编码
    @ApiModelProperty(value = "湖泊编码", dataType = "String", required = true, hidden = false)
    private String code;
    // 所属行政区划
    @ApiModelProperty(value = "所属行政区划", dataType = "String", required = true, hidden = false)
    private String areaId;
    // 所属行政区划名称
    @ApiModelProperty(value = "所属行政区划名称", dataType = "String", required = true, hidden = false)
    private String areaName;
    // 别名
    @ApiModelProperty(value = "别名", dataType = "String", required = true, hidden = false)
    private String alias;
    // 最大水深
    @ApiModelProperty(value = "最大水深", dataType = "String", required = true, hidden = false)
    private String deep;
    // 湖泊所在位置
    @ApiModelProperty(value = "湖泊所在位置", dataType = "String", required = true, hidden = false)
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
    // 多年平均水面面积
    @ApiModelProperty(value = "多年平均水面面积", dataType = "String", required = true, hidden = false)
    private String yearsArea;
    // 多年平均湖泊容积
    @ApiModelProperty(value = "多年平均湖泊容积", dataType = "String", required = true, hidden = false)
    private String yearsCapacity;
    // 咸淡水
    @ApiModelProperty(value = "咸淡水", dataType = "String", required = true, hidden = false)
    private String lakeType;
    // 多年平均水深
    @ApiModelProperty(value = "多年平均水深", dataType = "String", required = true, hidden = false)
    private String yearsDeep;
    // 备注
    @ApiModelProperty(value = "备注", dataType = "String", required = true, hidden = false)
    private String remark;
    // 咸淡水名称
    @ApiModelProperty(value = "咸淡水名称", dataType = "String", required = true, hidden = false)
    private String lakeTypeName;
    //湖段长
    @ApiModelProperty(value = "湖段长", dataType = "String", required = true, hidden = false)
    private String header;
    //协调员
    @ApiModelProperty(value = "协调员", dataType = "String", required = true, hidden = false)
    private String coordinater;
    //湖道警长（姓名）
    @ApiModelProperty(value = "湖道警长（姓名）", dataType = "String", required = true, hidden = false)
    private String policeman;
    //巡查员
    @ApiModelProperty(value = "巡查员", dataType = "String", required = true, hidden = false)
    private String checker;
    //督察长
    @ApiModelProperty(value = "督察长", dataType = "String", required = true, hidden = false)
    private String superviser;
    //湖长职责
    @ApiModelProperty(value = "湖长职责", dataType = "String", required = true, hidden = false)
    private String duty;
    //整治目标
    @ApiModelProperty(value = "整治目标", dataType = "String", required = true, hidden = false)
    private String aim;
    //湖长备注
    @ApiModelProperty(value = "湖长备注", dataType = "String", required = true, hidden = false)
    private String headerremark;

    //湖段长职务
    @ApiModelProperty(value = "湖段长职务",dataType="String",required = true,hidden = false)
    private String headerpost;
    //协调员职务
    @ApiModelProperty(value = "协调员职务",dataType="String",required = true,hidden = false)
    private String coordinaterpost;
    //巡查员职务
    @ApiModelProperty(value = "巡查员职务",dataType="String",required = true,hidden = false)
    private String checkerpost;
    //督察长职务
    @ApiModelProperty(value = "督察长职务",dataType="String",required = true,hidden = false)
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
     * 设置：湖段长职务
     */
    public void setHeaderpost(String headerpost) {
        this.headerpost = headerpost;
    }
    /**
     * 获取：湖段长职务
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
     * 设置：湖段长
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * 获取：湖段长
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
     * 设置：湖道警长（姓名）
     */
    public void setPoliceman(String policeman) {
        this.policeman = policeman;
    }

    /**
     * 获取：湖道警长（姓名）
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
     * 设置：湖长职责
     */
    public void setDuty(String duty) {
        this.duty = duty;
    }

    /**
     * 获取：湖长职责
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
     * 设置：湖长备注
     */
    public void setHeaderremark(String headerremark) {
        this.headerremark = headerremark;
    }

    /**
     * 获取：湖长备注
     */
    public String getHeaderremark() {
        return headerremark;
    }

    /**
     * 获取：咸淡水名称
     */
    public String getLakeTypeName() {
        return lakeTypeName;
    }

    /**
     * 设置：咸淡水名称
     */
    public void setLakeTypeName(String lakeTypeName) {
        this.lakeTypeName = lakeTypeName;
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
     * 设置：湖泊名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：湖泊名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：湖泊编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取：湖泊编码
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
     * 设置：最大水深
     */
    public void setDeep(String deep) {
        this.deep = deep;
    }

    /**
     * 获取：最大水深
     */
    public String getDeep() {
        return deep;
    }

    /**
     * 设置：湖泊所在位置
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 获取：湖泊所在位置
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
     * 设置：多年平均水面面积
     */
    public void setYearsArea(String yearsArea) {
        this.yearsArea = yearsArea;
    }

    /**
     * 获取：多年平均水面面积
     */
    public String getYearsArea() {
        return yearsArea;
    }

    /**
     * 设置：多年平均湖泊容积
     */
    public void setYearsCapacity(String yearsCapacity) {
        this.yearsCapacity = yearsCapacity;
    }

    /**
     * 获取：多年平均湖泊容积
     */
    public String getYearsCapacity() {
        return yearsCapacity;
    }

    /**
     * 设置：咸淡水
     */
    public void setLakeType(String lakeType) {
        this.lakeType = lakeType;
    }

    /**
     * 获取：咸淡水
     */
    public String getLakeType() {
        return lakeType;
    }

    /**
     * 设置：多年平均水深
     */
    public void setYearsDeep(String yearsDeep) {
        this.yearsDeep = yearsDeep;
    }

    /**
     * 获取：多年平均水深
     */
    public String getYearsDeep() {
        return yearsDeep;
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
