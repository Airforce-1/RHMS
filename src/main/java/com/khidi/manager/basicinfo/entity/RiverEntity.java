package com.khidi.manager.basicinfo.entity;

import io.swagger.annotations.ApiModelProperty;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ${comments}
 *
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:56:52
 * Jerry Wang 2017 12 23
 */
@ExcelTarget("RiverEntity")
public class RiverEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    // 编码
    @Excel(name = "编号", orderNum = "1", mergeVertical = true, isImportField = "id")
    @ApiModelProperty(value = "编码", dataType = "String", required = true, hidden = false)
    private String id;
    // 河流名称
    @Excel(name = "河流名称", orderNum = "2", mergeVertical = true, isImportField = "name")
    @ApiModelProperty(value = "河流名称", dataType = "String", required = true, hidden = false)
    private String name;
    // 河流编码
    @Excel(name = "河流编码", orderNum = "3", mergeVertical = true, isImportField = "code")
    @ApiModelProperty(value = "河流编码", dataType = "String", required = true, hidden = false)
    private String code;
    // 跨界类型
    @Excel(name = "跨界类型", orderNum = "4", mergeVertical = true, isImportField = "crossType")
    @ApiModelProperty(value = "跨界类型", dataType = "String", required = true, hidden = false)
    private String crossType;
    // 所属行政区划
    @Excel(name = "行政区划编码", orderNum = "5", mergeVertical = true, isImportField = "areaId")
    @ApiModelProperty(value = "所属行政区划", dataType = "String", required = true, hidden = false)
    private String areaId;
    // 所属行政区划
    @Excel(name = "行政区划名称", orderNum = "6", mergeVertical = true, isImportField = "areaName")
    @ApiModelProperty(value = "所属行政名称", dataType = "String", required = true, hidden = false)
    private String areaName;
    // 岸别
    @Excel(name = "岸别", orderNum = "6", mergeVertical = true, isImportField = "direction")
    @ApiModelProperty(value = "岸别", dataType = "String", required = true, hidden = false)
    private String direction;
    // 别名
    @Excel(name = "别名", orderNum = "6", mergeVertical = true, isImportField = "alias")
    @ApiModelProperty(value = "别名", dataType = "String", required = true, hidden = false)
    private String alias;
    // 河源所在位置
    @Excel(name = "河源所在位置", orderNum = "6", mergeVertical = true, isImportField = "riverResource")
    @ApiModelProperty(value = "河源所在位置", dataType = "String", required = true, hidden = false)
    private String riverResource;
    // 河口所在位置
    @Excel(name = "河口所在位置", orderNum = "6", mergeVertical = true, isImportField = "mouth")
    @ApiModelProperty(value = "河口所在位置", dataType = "String", required = true, hidden = false)
    private String mouth;
    // 河源经度
    @Excel(name = "河源经度", orderNum = "6", mergeVertical = true, isImportField = "resourceX")
    @ApiModelProperty(value = "河源经度", dataType = "String", required = true, hidden = false)
    private String resourceX;
    // 河源经度
    @Excel(name = "河源纬度", orderNum = "6", mergeVertical = true, isImportField = "resourceY")
    @ApiModelProperty(value = "河源纬度", dataType = "String", required = true, hidden = false)
    private String resourceY;
    // 河口经度
    @Excel(name = "河口经度", orderNum = "6", mergeVertical = true, isImportField = "mouthX")
    @ApiModelProperty(value = "河口经度", dataType = "String", required = true, hidden = false)
    private String mouthX;
    // 河口纬度
    @Excel(name = "河口纬度", orderNum = "6", mergeVertical = true, isImportField = "mouthY")
    @ApiModelProperty(value = "河口纬度", dataType = "String", required = true, hidden = false)
    private String mouthY;
    // 河流类型
    @Excel(name = "河流类型", orderNum = "6", mergeVertical = true, isImportField = "type")
    @ApiModelProperty(value = "河流类型", dataType = "String", required = true, hidden = false)
    private String type;
    // 平均比降
    @Excel(name = "平均比降", orderNum = "6", mergeVertical = true, isImportField = "gradient")
    @ApiModelProperty(value = "平均比降", dataType = "String", required = true, hidden = false)
    private String gradient;
    // 多年平均流量
    @Excel(name = "多年平均流量", orderNum = "6", mergeVertical = true, isImportField = "flow")
    @ApiModelProperty(value = "多年平均流量", dataType = "String", required = true, hidden = false)
    private String flow;
    // 河流长度
    @Excel(name = "河流长度", orderNum = "6", mergeVertical = true, isImportField = "length")
    @ApiModelProperty(value = "河流长度", dataType = "String", required = true, hidden = false)
    private String length;
    // 多年平均径流量
    @Excel(name = "多年平均径流量", orderNum = "6", mergeVertical = true, isImportField = "runoff")
    @ApiModelProperty(value = "多年平均径流量", dataType = "String", required = true, hidden = false)
    private String runoff;
    // 流域面积
    @Excel(name = "流域面积", orderNum = "6", mergeVertical = true, isImportField = "area")
    @ApiModelProperty(value = "流域面积", dataType = "String", required = true, hidden = false)
    private String area;
    // 流经地区
    @Excel(name = "流经地区", orderNum = "6", mergeVertical = true, isImportField = "regions")
    @ApiModelProperty(value = "流经地区", dataType = "String", required = true, hidden = false)
    private String regions;
    // 备注
    @Excel(name = "备注", orderNum = "6", mergeVertical = true, isImportField = "remark")
    @ApiModelProperty(value = "备注", dataType = "String", required = true, hidden = false)
    private String remark;
    // 父河流编码
    @Excel(name = "父河流编码", orderNum = "6", mergeVertical = true, isImportField = "parentId")
    @ApiModelProperty(value = "父河流编码", dataType = "String", required = true, hidden = false)
    private String parentId;
    // 岸别名称
    @ApiModelProperty(value = "岸别名称", dataType = "String", required = true, hidden = false)
    private String directionName;
    // 跨界类型名称
    @ApiModelProperty(value = "跨界类型名称", dataType = "String", required = true, hidden = false)
    private String crossTypeName;
    // 河流类型名称
    @ApiModelProperty(value = "河流类型名称", dataType = "String", required = true, hidden = false)
    private String typeName;


    //河道警长(姓名)
    @ApiModelProperty(value = "河道警长(姓名)", dataType = "String", required = true, hidden = false)
    private String policeman;
    //巡查员
    @ApiModelProperty(value = "巡查员", dataType = "String", required = true, hidden = false)
    private String checker;
    //督察长
    @ApiModelProperty(value = "督察长", dataType = "String", required = true, hidden = false)
    private String superviser;
    //河长职责
    @ApiModelProperty(value = "河长职责", dataType = "String", required = true, hidden = false)
    private String duty;
    //整治目标
    @ApiModelProperty(value = "整治目标", dataType = "String", required = true, hidden = false)
    private String aim;
    //河长备注
    @ApiModelProperty(value = "河长备注", dataType = "String", required = true, hidden = false)
    private String headerremark;
    //河段长
    @ApiModelProperty(value = "河段长", dataType = "String", required = true, hidden = false)
    private String header;
    //协调员
    @ApiModelProperty(value = "协调员", dataType = "String", required = true, hidden = false)
    private String coordinater;
    
    // 支流
    private List<RiverEntity> childrenRiver;

    @ApiModelProperty(value = "河段长职务", dataType = "String", required = true, hidden = false)
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
     * 设置：河段长职务
     */
    public void setHeaderpost(String headerpost) {
        this.headerpost = headerpost;
    }

    /**
     * 获取：河段长职务
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

    public List<RiverEntity> getChildrenRiver() {
		return childrenRiver;
	}

	public void setChildrenRiver(List<RiverEntity> childrenRiver) {
		this.childrenRiver = childrenRiver;
	}

	/**
     * 设置：河道警长(姓名)
     */
    public void setPoliceman(String policeman) {
        this.policeman = policeman;
    }

    /**
     * 获取：河道警长(姓名)
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
     * 设置：河长职责
     */
    public void setDuty(String duty) {
        this.duty = duty;
    }

    /**
     * 获取：河长职责
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
     * 设置：河长备注
     */
    public void setHeaderremark(String headerremark) {
        this.headerremark = headerremark;
    }

    /**
     * 获取：河长备注
     */
    public String getHeaderremark() {
        return headerremark;
    }

    /**
     * 设置：河段长
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * 获取：河段长
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
     * 获取：岸别名称
     */
    public String getDirectionName() {
        return directionName;
    }

    /**
     * 设置：岸别名称
     */
    public void setDirectionName(String directionName) {
        this.directionName = directionName;
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
     * 获取：河流类型名称
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置：河流类型名称
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 获取：父河流编码
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置：父河流编码
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：行政规划名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置：行政规划名称
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
     * 设置：河流名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：河流名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：河流编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取：河流编码
     */
    public String getCode() {
        return code;
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
     * 设置：岸别
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * 获取：岸别
     */
    public String getDirection() {
        return direction;
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
     * 设置：河源所在位置
     */
    public void setRiverResource(String riverResource) {
        this.riverResource = riverResource;
    }

    /**
     * 获取：河源所在位置
     */
    public String getRiverResource() {
        return riverResource;
    }

    /**
     * 设置：河口所在位置
     */
    public void setMouth(String mouth) {
        this.mouth = mouth;
    }

    /**
     * 获取：河口所在位置
     */
    public String getMouth() {
        return mouth;
    }

    /**
     * 设置：河源经度
     */
    public void setResourceX(String resourceX) {
        this.resourceX = resourceX;
    }

    /**
     * 获取：河源经度
     */
    public String getResourceX() {
        return resourceX;
    }

    /**
     * 设置：河源经度
     */
    public void setResourceY(String resourceY) {
        this.resourceY = resourceY;
    }

    /**
     * 获取：河源经度
     */
    public String getResourceY() {
        return resourceY;
    }

    /**
     * 设置：河口经度
     */
    public void setMouthX(String mouthX) {
        this.mouthX = mouthX;
    }

    /**
     * 获取：河口经度
     */
    public String getMouthX() {
        return mouthX;
    }

    /**
     * 设置：河口纬度
     */
    public void setMouthY(String mouthY) {
        this.mouthY = mouthY;
    }

    /**
     * 获取：河口纬度
     */
    public String getMouthY() {
        return mouthY;
    }

    /**
     * 设置：河流类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取：河流类型
     */
    public String getType() {
        return type;
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
     * 设置：多年平均流量
     */
    public void setFlow(String flow) {
        this.flow = flow;
    }

    /**
     * 获取：多年平均流量
     */
    public String getFlow() {
        return flow;
    }

    /**
     * 设置：河流长度
     */
    public void setLength(String length) {
        this.length = length;
    }

    /**
     * 获取：河流长度
     */
    public String getLength() {
        return length;
    }

    /**
     * 设置：多年平均径流量
     */
    public void setRunoff(String runoff) {
        this.runoff = runoff;
    }

    /**
     * 获取：多年平均径流量
     */
    public String getRunoff() {
        return runoff;
    }

    /**
     * 设置：流域面积
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取：流域面积
     */
    public String getArea() {
        return area;
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
