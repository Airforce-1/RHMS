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
public class CanalEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    //编码
    @ApiModelProperty(value = "编码", dataType = "String", required = true, hidden = false)
    private String id;
    //渠道名称
    @ApiModelProperty(value = "渠道名称", dataType = "String", required = true, hidden = false)
    private String name;
    //渠道编码
    @ApiModelProperty(value = "渠道编码", dataType = "String", required = true, hidden = false)
    private String code;
    //所属行政区划
    @ApiModelProperty(value = "所属行政区划", dataType = "String", required = true, hidden = false)
    private String areaId;

    //所属行政区划名称
    @ApiModelProperty(value = "所属行政区划名称", dataType = "String", required = true, hidden = false)
    private String areaName;
    //上级河渠湖库ID
    @ApiModelProperty(value = "上级河渠湖库ID", dataType = "String", required = true, hidden = false)
    private String superName;
    //上级河渠湖库类型
    @ApiModelProperty(value = "上级河渠湖库类型", dataType = "String", required = true, hidden = false)
    private String superType;
    //排入河渠湖库ID
    @ApiModelProperty(value = "排入河渠湖库ID", dataType = "String", required = true, hidden = false)
    private String inputName;
    //排入河渠湖库类型
    @ApiModelProperty(value = "排入河渠湖库类型", dataType = "String", required = true, hidden = false)
    private String inputType;
    //别名
    @ApiModelProperty(value = "别名", dataType = "String", required = true, hidden = false)
    private String alias;
    //渠首所在位置
    @ApiModelProperty(value = "渠首所在位置", dataType = "String", required = true, hidden = false)
    private String riverstart;
    //渠尾所在位置
    @ApiModelProperty(value = "渠尾所在位置", dataType = "String", required = true, hidden = false)
    private String riverend;
    //渠首经度
    @ApiModelProperty(value = "渠首经度", dataType = "String", required = true, hidden = false)
    private String startX;
    //渠首纬度
    @ApiModelProperty(value = "渠首纬度", dataType = "String", required = true, hidden = false)
    private String startY;
    //渠尾经度
    @ApiModelProperty(value = "渠尾经度", dataType = "String", required = true, hidden = false)
    private String endX;
    //渠尾纬度
    @ApiModelProperty(value = "渠尾纬度", dataType = "String", required = true, hidden = false)
    private String endY;
    //渠道功能
    @ApiModelProperty(value = "渠道功能", dataType = "String", required = true, hidden = false)
    private String function;
    //设计流量
    @ApiModelProperty(value = "设计流量", dataType = "String", required = true, hidden = false)
    private String flow;
    //跨界类型
    @ApiModelProperty(value = "跨界类型", dataType = "String", required = true, hidden = false)
    private String crossType;
    //渠道长度
    @ApiModelProperty(value = "渠道长度", dataType = "String", required = true, hidden = false)
    private String length;
    //平均比降
    @ApiModelProperty(value = "平均比降", dataType = "String", required = true, hidden = false)
    private String gradient;
    //流经地区
    @ApiModelProperty(value = "流经地区", dataType = "String", required = true, hidden = false)
    private String regions;
    //备注
    @ApiModelProperty(value = "备注", dataType = "String", required = true, hidden = false)
    private String remark;
    //父渠道编码
    @ApiModelProperty(value = "父渠道编码", dataType = "String", required = true, hidden = false)
    private String parentId;
    //上级河渠湖库类型名称
    @ApiModelProperty(value = "上级河渠湖库类型名称", dataType = "String", required = true, hidden = false)
    private String superTypeName;
    //排入河渠湖库类型名称
    @ApiModelProperty(value = "排入河渠湖库类型名称", dataType = "String", required = true, hidden = false)
    private String inputTypeName;
    //渠道功能名称
    @ApiModelProperty(value = "渠道功能名称", dataType = "String", required = true, hidden = false)
    private String functionName;
    //跨界类型名称
    @ApiModelProperty(value = "跨界类型名称", dataType = "String", required = true, hidden = false)
    private String crossTypeName;

    //督察长
    @ApiModelProperty(value = "督察长", dataType = "String", required = true, hidden = false)
    private String superviser;
    //渠长职责
    @ApiModelProperty(value = "渠长职责", dataType = "String", required = true, hidden = false)
    private String duty;
    //渠段长
    @ApiModelProperty(value = "渠段长", dataType = "String", required = true, hidden = false)
    private String header;
    //协调员
    @ApiModelProperty(value = "协调员", dataType = "String", required = true, hidden = false)
    private String coordinater;
    //渠道警长（姓名）
    @ApiModelProperty(value = "渠道警长（姓名）", dataType = "String", required = true, hidden = false)
    private String policeman;
    //整治目标
    @ApiModelProperty(value = "整治目标", dataType = "String", required = true, hidden = false)
    private String aim;
    //渠长备注
    @ApiModelProperty(value = "渠长备注", dataType = "String", required = true, hidden = false)
    private String headerremark;
    //巡查员
    @ApiModelProperty(value = "巡查员", dataType = "String", required = true, hidden = false)
    private String checker;
    //渠段长职务
    @ApiModelProperty(value = "渠段长职务", dataType = "String", required = true, hidden = false)
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

    // 岸别名称
    @ApiModelProperty(value = "岸别名称", dataType = "String", required = true, hidden = false)
    private String direction;
    // 渠道类型名称
    @ApiModelProperty(value = "渠道类型", dataType = "String", required = true, hidden = false)
    private String canaltype;
    //上级河渠湖库名称
    @ApiModelProperty(value = "上级河渠湖库名称", dataType = "String", required = true, hidden = false)
    private String superNameName;
    //排入河渠湖库名称
    @ApiModelProperty(value = "排入河渠湖库名称", dataType = "String", required = true, hidden = false)
    private String inputNameName;
    // 渠道类型名称
    @ApiModelProperty(value = "渠道类型名称", dataType = "String", required = true, hidden = false)
    private String canalTypeName;
    // 岸别名称
    @ApiModelProperty(value = "岸别名称", dataType = "String", required = true, hidden = false)
    private String directionName;
    //地图资源编码
    @ApiModelProperty(value = "地图资源编码", dataType = "String", required = true, hidden = false)
    private String featureId;

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public String getCanalTypeName() {
        return canalTypeName;
    }

    public void setCanalTypeName(String canalTypeName) {
        this.canalTypeName = canalTypeName;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public String getSuperNameName() {
        return superNameName;
    }

    public void setSuperNameName(String superNameName) {
        this.superNameName = superNameName;
    }

    public String getInputNameName() {
        return inputNameName;
    }

    public void setInputNameName(String inputNameName) {
        this.inputNameName = inputNameName;
    }


    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCanaltype() {
        return canaltype;
    }

    public void setCanaltype(String canaltype) {
        this.canaltype = canaltype;
    }

    /**
     * 设置：渠段长职务
     */
    public void setHeaderpost(String headerpost) {
        this.headerpost = headerpost;
    }

    /**
     * 获取：渠段长职务
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
     * 设置：渠段长
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * 获取：渠段长
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
     * 设置：渠道警长（姓名）
     */
    public void setPoliceman(String policeman) {
        this.policeman = policeman;
    }

    /**
     * 获取：渠道警长（姓名）
     */
    public String getPoliceman() {
        return policeman;
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
     * 设置：渠长备注
     */
    public void setHeaderremark(String headerremark) {
        this.headerremark = headerremark;
    }

    /**
     * 获取：渠长备注
     */
    public String getHeaderremark() {
        return headerremark;
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
     * 设置：渠长职责
     */
    public void setDuty(String duty) {
        this.duty = duty;
    }

    /**
     * 获取：渠长职责
     */
    public String getDuty() {
        return duty;
    }

    /**
     * 获取：上级河渠湖库类型名称
     */
    public String getSuperTypeName() {
        return superTypeName;
    }

    /**
     * 设置：上级河渠湖库类型名称
     */
    public void setSuperTypeName(String superTypeName) {
        this.superTypeName = superTypeName;
    }

    /**
     * 获取：排入河渠湖库类型名称
     */
    public String getInputTypeName() {
        return inputTypeName;
    }

    /**
     * 设置：排入河渠湖库类型名称
     */
    public void setInputTypeName(String inputTypeName) {
        this.inputTypeName = inputTypeName;
    }

    /**
     * 获取：渠道功能名称
     */
    public String getFunctionName() {
        return functionName;
    }

    /**
     * 设置：渠道功能名称
     */
    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    /**
     * 获取：跨界类型名称
     */
    public String getCrossTypeName() {
        return crossTypeName;
    }

    /**
     * 设置：跨界类型名称
     */
    public void setCrossTypeName(String crossTypeName) {
        this.crossTypeName = crossTypeName;
    }

    /**
     * 获取：父渠道编码
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置：父渠道编码
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
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
     * 设置：渠道名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：渠道名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：渠道编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取：渠道编码
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
     * 设置：所属行政区划
     */
    public void setSuperName(String superName) {
        this.superName = superName;
    }

    /**
     * 获取：所属行政区划
     */
    public String getSuperName() {
        return superName;
    }

    /**
     * 设置：上级河渠湖库类型
     */
    public void setSuperType(String superType) {
        this.superType = superType;
    }

    /**
     * 获取：上级河渠湖库类型
     */
    public String getSuperType() {
        return superType;
    }

    /**
     * 设置：排入河渠湖库名称
     */
    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    /**
     * 获取：排入河渠湖库名称
     */
    public String getInputName() {
        return inputName;
    }

    /**
     * 设置：排入河渠湖库类型
     */
    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    /**
     * 获取：排入河渠湖库类型
     */
    public String getInputType() {
        return inputType;
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
     * 设置：渠首所在位置
     */
    public void setRiverstart(String riverstart) {
        this.riverstart = riverstart;
    }

    /**
     * 获取：渠首所在位置
     */
    public String getRiverstart() {
        return riverstart;
    }

    /**
     * 设置：渠尾所在位置
     */
    public void setRiverend(String riverend) {
        this.riverend = riverend;
    }

    /**
     * 获取：渠尾所在位置
     */
    public String getRiverend() {
        return riverend;
    }

    /**
     * 设置：渠首经度
     */
    public void setStartX(String startX) {
        this.startX = startX;
    }

    /**
     * 获取：渠首经度
     */
    public String getStartX() {
        return startX;
    }

    /**
     * 设置：渠首纬度
     */
    public void setStartY(String startY) {
        this.startY = startY;
    }

    /**
     * 获取：渠首纬度
     */
    public String getStartY() {
        return startY;
    }

    /**
     * 设置：渠尾经度
     */
    public void setEndX(String endX) {
        this.endX = endX;
    }

    /**
     * 获取：渠尾经度
     */
    public String getEndX() {
        return endX;
    }

    /**
     * 设置：渠尾纬度
     */
    public void setEndY(String endY) {
        this.endY = endY;
    }

    /**
     * 获取：渠尾纬度
     */
    public String getEndY() {
        return endY;
    }

    /**
     * 设置：渠道功能
     */
    public void setFunction(String function) {
        this.function = function;
    }

    /**
     * 获取：渠道功能
     */
    public String getFunction() {
        return function;
    }

    /**
     * 设置：设计流量
     */
    public void setFlow(String flow) {
        this.flow = flow;
    }

    /**
     * 获取：设计流量
     */
    public String getFlow() {
        return flow;
    }

    /**
     * 设置：跨界类型
     */
    public void setCrossType(String crossType) {
        this.crossType = crossType;
    }

    /**
     * 获取：跨界类型
     */
    public String getCrossType() {
        return crossType;
    }

    /**
     * 设置：渠道长度
     */
    public void setLength(String length) {
        this.length = length;
    }

    /**
     * 获取：渠道长度
     */
    public String getLength() {
        return length;
    }

    /**
     * 设置：平均比降
     */
    public void setGradient(String gradient) {
        this.gradient = gradient;
    }

    /**
     * 获取：平均比降
     */
    public String getGradient() {
        return gradient;
    }

    /**
     * 设置：流经地区
     */
    public void setRegions(String regions) {
        this.regions = regions;
    }

    /**
     * 获取：流经地区
     */
    public String getRegions() {
        return regions;
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
