package com.khidi.manager.officework.vo;

import com.khidi.common.utils.ExcelUtils;
import com.khidi.manager.officework.entity.CheckrecordEntity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/10.
 */
public class CheckRecordVo extends CheckrecordEntity {
    private String routeName;  //路线名称
    private String resourceTypeName;//河渠湖库类型名称
    private String areaName;//行政区划名称
    private String resourceName;//河渠湖库名称
    private String checkerName;//巡查员姓名
    private Date taskStartDate;//任务开始时间
    private Date taskEndDate;//任务结束时间

    //将父类的属性赋给子类
    public void SetCheckrecordEntity(CheckrecordEntity val){
        Class<?> type = CheckrecordEntity.class;
        Field[] fields = type.getDeclaredFields();
        try{
        for(Field field : fields){
            String fieldName = field.getName();
            if(fieldName.equals("serialVersionUID")) continue;
            String getMethodName="get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            Method getMethod = type.getDeclaredMethod(getMethodName);
            Object o = getMethod.invoke(val);
            String setMethodName="set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            Method setMethod = this.getClass().getMethod(setMethodName,field.getType());
            setMethod.invoke(this,o);
        }
        }catch (Exception e){
            e.printStackTrace();
        }
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

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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

    public Date getTaskStartDate() {
        return taskStartDate;
    }

    public void setTaskStartDate(Date taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public Date getTaskEndDate() {
        return taskEndDate;
    }

    public void setTaskEndDate(Date taskEndDate) {
        this.taskEndDate = taskEndDate;
    }
}
