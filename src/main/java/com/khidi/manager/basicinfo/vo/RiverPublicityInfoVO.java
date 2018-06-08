package com.khidi.manager.basicinfo.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/2.
 */
public class RiverPublicityInfoVO implements Serializable {
    private String id;//记录编码
    private String resourceName;//河渠湖库(段)名称
    private String resourceType;//河渠湖库(段)类型
    private String areaName;//行政区划
    private String provincialHeader;//省级河长
    private String cityHeader;//市级河长市
    private String countyHeader;//县级河长县
    private String townHeader;//乡级河长
    private String villageHeader;//村级河长
    private String checker;//巡查员
    private String policeman;//职责
    private String superviser;//督察长
    private String duty;   //职责
    private String aim;  //整治目标
    private String alias;//别名
    private String length;//长度
    private String startPoint;//河流起点
    private String endPoint;//河流终点

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getProvincialHeader() {
        return provincialHeader;
    }

    public void setProvincialHeader(String provincialHeader) {
        this.provincialHeader = provincialHeader;
    }

    public String getCityHeader() {
        return cityHeader;
    }

    public void setCityHeader(String cityHeader) {
        this.cityHeader = cityHeader;
    }

    public String getCountyHeader() {
        return countyHeader;
    }

    public void setCountyHeader(String countyHeader) {
        this.countyHeader = countyHeader;
    }

    public String getTownHeader() {
        return townHeader;
    }

    public void setTownHeader(String townHeader) {
        this.townHeader = townHeader;
    }

    public String getVillageHeader() {
        return villageHeader;
    }

    public void setVillageHeader(String villageHeader) {
        this.villageHeader = villageHeader;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getPoliceman() {
        return policeman;
    }

    public void setPoliceman(String policeman) {
        this.policeman = policeman;
    }

    public String getSuperviser() {
        return superviser;
    }

    public void setSuperviser(String superviser) {
        this.superviser = superviser;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }
}
