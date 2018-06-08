package com.khidi.manager.socialparticipation.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-12 15:29:14
 */
public class AppnewsMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//$column.comments
    @ApiModelProperty(value = "$column.comments",dataType="String",required = true,hidden = false)
	private String appinfoid;
	//$column.comments
    @ApiModelProperty(value = "$column.comments",dataType="String",required = true,hidden = false)
	private String appmenuid;

	/**
	 * 设置：${column.comments}
	 */
	public void setAppinfoid(String appinfoid) {
		this.appinfoid = appinfoid;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getAppinfoid() {
		return appinfoid;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setAppmenuid(String appmenuid) {
		this.appmenuid = appmenuid;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getAppmenuid() {
		return appmenuid;
	}
}
