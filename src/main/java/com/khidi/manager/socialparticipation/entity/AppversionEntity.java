package com.khidi.manager.socialparticipation.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-08 15:06:21
 * Jerry Wang 2017  12  12
 */
public class AppversionEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;    
	//APP版本 类型 1(GZ XZ)
    @ApiModelProperty(value = "APP版本1",dataType="String",required = true,hidden = false)
	private String appType1;
	//APP版本 类型 2(I A)
    @ApiModelProperty(value = "APP版本2",dataType="String",required = true,hidden = false)
    private String appType2;
	//版本名称
    @ApiModelProperty(value = "版本名称",dataType="String",required = true,hidden = false)
	private String appName;
	//版本号
    @ApiModelProperty(value = "版本号",dataType="String",required = true,hidden = false)
	private String appVersion;
	//app存放路径
    @ApiModelProperty(value = "app存放路径",dataType="String",required = true,hidden = false)
	private String appPath;
	//版本说明
    @ApiModelProperty(value = "版本说明",dataType="String",required = true,hidden = false)
	private String appDesc;
 
    //发布日期
    @ApiModelProperty(value = "发布日期",dataType="Date",required = true,hidden = false)
    private Date releaseTime;
    
    //app文件附件编号
    @ApiModelProperty(value = "app文件附件编号",dataType="String",required = true,hidden = false)
    private String attachId;
    
    public String getAttachId() {
		return attachId;
	}
	public void setAttachId(String attachId) {
		this.attachId = attachId;
	}
	public String getAppType1() {
		return appType1;
	}
	public void setAppType1(String appType1) {
		this.appType1 = appType1;
	}
	public String getAppType2() {
		return appType2;
	}
	public void setAppType2(String appType2) {
		this.appType2 = appType2;
	}
    
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public String getAppPath() {
		return appPath;
	}
	public void setAppPath(String appPath) {
		this.appPath = appPath;
	}
	public String getAppDesc() {
		return appDesc;
	}
	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
