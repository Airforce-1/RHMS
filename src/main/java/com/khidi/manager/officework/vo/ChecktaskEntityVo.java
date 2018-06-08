package com.khidi.manager.officework.vo;

import com.khidi.manager.officework.entity.ChecktaskdailyEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/22.
 */
public class ChecktaskEntityVo extends ChecktaskdailyEntity {
    private String routeName;//巡查路线名称
    private String resourceTypeName;//河渠湖库类型名称
    private String areaName;//行政区划名称
    private String resourceName;//河渠湖库名称
    private String checkerName;//巡查员姓名
    private String statr2End;//起止位置
    private String type;//任务类型
    private String featureId;//地图编码
    private String resourceId;
    private String resourceType;
    private String times;//巡查频次

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getResourceTypeName() {
        return resourceTypeName;
    }

    public void setResourceTypeName(String resourceTypeName) {
        this.resourceTypeName = resourceTypeName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getCheckerName() {
        return checkerName;
    }

    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }

    public String getStatr2End() {
        return statr2End;
    }

    public void setStatr2End(String statr2End) {
        this.statr2End = statr2End;
    }

}
