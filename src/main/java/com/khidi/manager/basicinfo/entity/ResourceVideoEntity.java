package com.khidi.manager.basicinfo.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * ${comments}
 *
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-23 10:22:50
 */
public class ResourceVideoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    // 行政区划名称
    @ApiModelProperty(value = "所属行政区划名称", dataType = "String", required = true, hidden = false)
    private String areaName;
    //系统编码
    @ApiModelProperty(value = "系统编码", dataType = "String", required = true, hidden = false)
    private String id;
    //测站编码
    @ApiModelProperty(value = "测站编码", dataType = "String", required = true, hidden = false)
    private String code;
    //行政区划
    @ApiModelProperty(value = "行政区划", dataType = "String", required = true, hidden = false)
    private String areaId;
    //测站名称
    @ApiModelProperty(value = "测站名称", dataType = "String", required = true, hidden = false)
    private String name;
    //地址
    @ApiModelProperty(value = "地址", dataType = "String", required = true, hidden = false)
    private String address;
    //视频监测站类型
    @ApiModelProperty(value = "视频监测站类型", dataType = "String", required = true, hidden = false)
    private String type;
    //河湖渠库(段)类型
    @ApiModelProperty(value = "河湖渠库(段)类型", dataType = "String", required = true, hidden = false)
    private String resourceType;
    //所属测站
    @ApiModelProperty(value = "所属测站", dataType = "String", required = true, hidden = false)
    private String stationId;
    //河湖渠库(段)编码
    @ApiModelProperty(value = "河湖渠库(段)编码", dataType = "String", required = true, hidden = false)
    private String resourceId;
    //经度
    @ApiModelProperty(value = "经度", dataType = "String", required = true, hidden = false)
    private String x;
    //纬度
    @ApiModelProperty(value = "纬度", dataType = "String", required = true, hidden = false)
    private String y;
    //负责人
    @ApiModelProperty(value = "负责人", dataType = "String", required = true, hidden = false)
    private String owner;
    //负责人电话
    @ApiModelProperty(value = "负责人电话", dataType = "String", required = true, hidden = false)
    private String phone;
    //工程建设情况
    @ApiModelProperty(value = "工程建设情况", dataType = "String", required = true, hidden = false)
    private String stationBuild;
    //运行情况
    @ApiModelProperty(value = "运行情况", dataType = "String", required = true, hidden = false)
    private String stationSituation;
    //开工时间
    @ApiModelProperty(value = "开工时间", dataType = "Date", required = true, hidden = false)
    private Date stationStarttime;
    //建成时间
    @ApiModelProperty(value = "建成时间", dataType = "Date", required = true, hidden = false)
    private Date stationBuildtime;
    //备注
    @ApiModelProperty(value = "备注", dataType = "String", required = true, hidden = false)
    private String remark;
    //河湖渠库(段)名称
    @ApiModelProperty(value = "河湖渠库(段)名称", dataType = "String", required = true, hidden = false)
    private String resourceName;
    //河湖渠库(段)类型名称
    @ApiModelProperty(value = "河湖渠库(段)值类型名称", dataType = "String", required = true, hidden = false)
    private String resourceTypeName;
    //测站类型名称
    @ApiModelProperty(value = "测站类型名称", dataType = "String", required = true, hidden = false)
    private String stationTypeName;
    //工程建设情况名称
    @ApiModelProperty(value = "工程建设情况名称", dataType = "String", required = true, hidden = false)
    private String stationBuildName;
    //运行情况名称
    @ApiModelProperty(value = "运行情况名称", dataType = "String", required = true, hidden = false)
    private String stationSituationName;
    //所属测站名称
    @ApiModelProperty(value = "所属测站名称", dataType = "String", required = true, hidden = false)
    private String stationName;

    /**
     * 获取：工程建设情况名称
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * 设置：工程建设情况名称
     */
    public void setStationName(String stationName) {
        this.stationName = stationName;
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
     * 获取：运行情况名称
     */
    public String getStationSituationName() {
        return stationSituationName;
    }

    /**
     * 设置：运行情况名称
     */
    public void setStationSituationName(String stationSituationName) {
        this.stationSituationName = stationSituationName;
    }

    /**
     * 获取：河湖渠库(段)名称
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * 设置：河湖渠库(段)名称
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * 获取：河湖渠库(段)类型名称
     */
    public String getResourceTypeName() {
        return resourceTypeName;
    }

    /**
     * 设置：河湖渠库(段)类型名称
     */
    public void setResourceTypeName(String resourceTypeName) {
        this.resourceTypeName = resourceTypeName;
    }

    /**
     * 获取：测站类型名称
     */
    public String getStationTypeName() {
        return stationTypeName;
    }

    /**
     * 设置：测站类型名称
     */
    public void setStationTypeName(String stationTypeName) {
        this.stationTypeName = stationTypeName;
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
     * 设置：测站编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取：测站编码
     */
    public String getCode() {
        return code;
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
     * 设置：测站名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：测站名称
     */
    public String getName() {
        return name;
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
     * 设置：视频监测站类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取：视频监测站类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置：河湖渠库(段)类型
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * 获取：河湖渠库(段)类型
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * 设置：所属测站
     */
    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    /**
     * 获取：所属测站
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * 设置：河湖渠库(段)编码
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 获取：河湖渠库(段)编码
     */
    public String getResourceId() {
        return resourceId;
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
     * 设置：负责人电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取：负责人电话
     */
    public String getPhone() {
        return phone;
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
     * 设置：运行情况
     */
    public void setStationSituation(String stationSituation) {
        this.stationSituation = stationSituation;
    }

    /**
     * 获取：运行情况
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
