package com.khidi.manager.basicinfo.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * ${comments}
 *
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-22 17:36:48
 */
public class ResourceCompanywaterEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    // 行政区划名称
    @ApiModelProperty(value = "所属行政区划名称", dataType = "String", required = true, hidden = false)
    private String areaName;
    // 系统编码
    @ApiModelProperty(value = "系统编码", dataType = "String", required = true, hidden = false)
    private String id;
    // 工业企业用水户编码
    @ApiModelProperty(value = "工业企业用水户编码", dataType = "String", required = true, hidden = false)
    private String code;
    // 工业企业用水户名称
    @ApiModelProperty(value = "工业企业用水户名称", dataType = "String", required = true, hidden = false)
    private String name;
    // 经度
    @ApiModelProperty(value = "经度", dataType = "String", required = true, hidden = false)
    private String x;
    // 纬度
    @ApiModelProperty(value = "纬度", dataType = "String", required = true, hidden = false)
    private String y;
    // 负责人
    @ApiModelProperty(value = "负责人", dataType = "String", required = true, hidden = false)
    private String owner;
    // 联系电话
    @ApiModelProperty(value = "联系电话", dataType = "String", required = true, hidden = false)
    private String phone;
    // 年用水量(万m3)
    @ApiModelProperty(value = "年用水量(万m3)", dataType = "String", required = true, hidden = false)
    private String yearUse;
    // 工业总产值(亿元)
    @ApiModelProperty(value = "工业总产值(亿元)", dataType = "String", required = true, hidden = false)
    private String industrialValue;
    // 是否办理取水许可
    @ApiModelProperty(value = "是否办理取水许可", dataType = "String", required = true, hidden = false)
    private String waterPermission;
    // 取水许可证编号
    @ApiModelProperty(value = "取水许可证编号", dataType = "String", required = true, hidden = false)
    private String permissionNumber;
    // 取水许可水量(万m3)
    @ApiModelProperty(value = "取水许可水量(万m3)", dataType = "String", required = true, hidden = false)
    private String permissionSum;
    // 排水量(万m3)
    @ApiModelProperty(value = "排水量(万m3)", dataType = "String", required = true, hidden = false)
    private String displacement;
    // 排去方向
    @ApiModelProperty(value = "排去方向", dataType = "String", required = true, hidden = false)
    private String outputDirection;
    // 自来水计量方式
    @ApiModelProperty(value = "自来水计量方式", dataType = "String", required = true, hidden = false)
    private String tapwaterMode;
    // 地表水计量方式
    @ApiModelProperty(value = "地表水计量方式", dataType = "String", required = true, hidden = false)
    private String surfacewaterMode;
    // 地下水计量方式
    @ApiModelProperty(value = "地下水计量方式", dataType = "String", required = true, hidden = false)
    private String groundwaterMode;
    // 再生水计量方式
    @ApiModelProperty(value = "再生水计量方式", dataType = "String", required = true, hidden = false)
    private String reclaimedwaterMode;
    // 其他水计量方式
    @ApiModelProperty(value = "其他水计量方式", dataType = "String", required = true, hidden = false)
    private String otherwaterMode;
    // 行政区划
    @ApiModelProperty(value = "行政区划", dataType = "String", required = true, hidden = false)
    private String areaId;
    // 地址
    @ApiModelProperty(value = "地址", dataType = "String", required = true, hidden = false)
    private String address;
    // 备注
    @ApiModelProperty(value = "备注", dataType = "String", required = true, hidden = false)
    private String remark;
    // 排去方向名称
    @ApiModelProperty(value = "排去方向名称", dataType = "String", required = true, hidden = false)
    private String outputDirectionName;
    // 自来水计量方式名称
    @ApiModelProperty(value = "自来水计量方式名称", dataType = "String", required = true, hidden = false)
    private String tapwaterModeName;
    // 地表水计量方式名称
    @ApiModelProperty(value = "地表水计量方式名称", dataType = "String", required = true, hidden = false)
    private String surfacewaterModeName;
    // 地下水计量方式名称
    @ApiModelProperty(value = "地下水计量方式名称", dataType = "String", required = true, hidden = false)
    private String groundwaterModeName;
    // 再生水计量方式名称
    @ApiModelProperty(value = "再生水计量方式名称", dataType = "String", required = true, hidden = false)
    private String reclaimedwaterModeName;
    // 其他水计量方式名称
    @ApiModelProperty(value = "其他水计量方式名称", dataType = "String", required = true, hidden = false)
    private String otherwaterModeName;

    /**
     * 获取：排去方向名称
     */
    public String getOutputDirectionName() {
        return outputDirectionName;
    }

    /**
     * 设置：排去方向名称
     */
    public void setOutputDirectionName(String outputDirectionName) {
        this.outputDirectionName = outputDirectionName;
    }

    /**
     * 获取：自来水计量方式名称
     */
    public String getTapwaterModeName() {
        return tapwaterModeName;
    }

    /**
     * 设置：自来水计量方式名称
     */
    public void setTapwaterModeName(String tapwaterModeName) {
        this.tapwaterModeName = tapwaterModeName;
    }

    /**
     * 获取：地表水计量方式名称
     */
    public String getSurfacewaterModeName() {
        return surfacewaterModeName;
    }

    /**
     * 设置：地表水计量方式名称
     */
    public void setSurfacewaterModeName(String surfacewaterModeName) {
        this.surfacewaterModeName = surfacewaterModeName;
    }

    /**
     * 获取：地下水计量方式名称
     */
    public String getGroundwaterModeName() {
        return groundwaterModeName;
    }

    /**
     * 设置：地下水计量方式名称
     */
    public void setGroundwaterModeName(String groundwaterModeName) {
        this.groundwaterModeName = groundwaterModeName;
    }

    /**
     * 获取：再生水计量方式名称
     */
    public String getReclaimedwaterModeName() {
        return reclaimedwaterModeName;
    }

    /**
     * 设置：再生水计量方式名称
     */
    public void setReclaimedwaterModeName(String reclaimedwaterModeName) {
        this.reclaimedwaterModeName = reclaimedwaterModeName;
    }

    /**
     * 获取：其他水计量方式名称
     */
    public String getOtherwaterModeName() {
        return otherwaterModeName;
    }

    /**
     * 设置：其他水计量方式名称
     */
    public void setOtherwaterModeName(String otherwaterModeName) {
        this.otherwaterModeName = otherwaterModeName;
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
     * 设置：工业企业用水户编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取：工业企业用水户编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置：工业企业用水户名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：工业企业用水户名称
     */
    public String getName() {
        return name;
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
     * 设置：负责人
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * 获取：负责人
     */
    public String getOwner() {
        return owner;
    }

    /**
     * 设置：联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取：联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置：年用水量(万m3)
     */
    public void setYearUse(String yearUse) {
        this.yearUse = yearUse;
    }

    /**
     * 获取：年用水量(万m3)
     */
    public String getYearUse() {
        return yearUse;
    }

    /**
     * 设置：工业总产值(亿元)
     */
    public void setIndustrialValue(String industrialValue) {
        this.industrialValue = industrialValue;
    }

    /**
     * 获取：工业总产值(亿元)
     */
    public String getIndustrialValue() {
        return industrialValue;
    }

    /**
     * 设置：是否办理取水许可
     */
    public void setWaterPermission(String waterPermission) {
        this.waterPermission = waterPermission;
    }

    /**
     * 获取：是否办理取水许可
     */
    public String getWaterPermission() {
        return waterPermission;
    }

    /**
     * 设置：取水许可证编号
     */
    public void setPermissionNumber(String permissionNumber) {
        this.permissionNumber = permissionNumber;
    }

    /**
     * 获取：取水许可证编号
     */
    public String getPermissionNumber() {
        return permissionNumber;
    }

    /**
     * 设置：取水许可水量(万m3)
     */
    public void setPermissionSum(String permissionSum) {
        this.permissionSum = permissionSum;
    }

    /**
     * 获取：取水许可水量(万m3)
     */
    public String getPermissionSum() {
        return permissionSum;
    }

    /**
     * 设置：排水量(万m3)
     */
    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    /**
     * 获取：排水量(万m3)
     */
    public String getDisplacement() {
        return displacement;
    }

    /**
     * 设置：排去方向
     */
    public void setOutputDirection(String outputDirection) {
        this.outputDirection = outputDirection;
    }

    /**
     * 获取：排去方向
     */
    public String getOutputDirection() {
        return outputDirection;
    }

    /**
     * 设置：自来水计量方式
     */
    public void setTapwaterMode(String tapwaterMode) {
        this.tapwaterMode = tapwaterMode;
    }

    /**
     * 获取：自来水计量方式
     */
    public String getTapwaterMode() {
        return tapwaterMode;
    }

    /**
     * 设置：地表水计量方式
     */
    public void setSurfacewaterMode(String surfacewaterMode) {
        this.surfacewaterMode = surfacewaterMode;
    }

    /**
     * 获取：地表水计量方式
     */
    public String getSurfacewaterMode() {
        return surfacewaterMode;
    }

    /**
     * 设置：地下水计量方式
     */
    public void setGroundwaterMode(String groundwaterMode) {
        this.groundwaterMode = groundwaterMode;
    }

    /**
     * 获取：地下水计量方式
     */
    public String getGroundwaterMode() {
        return groundwaterMode;
    }

    /**
     * 设置：再生水计量方式
     */
    public void setReclaimedwaterMode(String reclaimedwaterMode) {
        this.reclaimedwaterMode = reclaimedwaterMode;
    }

    /**
     * 获取：再生水计量方式
     */
    public String getReclaimedwaterMode() {
        return reclaimedwaterMode;
    }

    /**
     * 设置：其他水计量方式
     */
    public void setOtherwaterMode(String otherwaterMode) {
        this.otherwaterMode = otherwaterMode;
    }

    /**
     * 获取：其他水计量方式
     */
    public String getOtherwaterMode() {
        return otherwaterMode;
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
     * 设置：地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取：地址
     */
    public String getAddress() {
        return address;
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
