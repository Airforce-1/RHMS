package com.khidi.manager.socialparticipation.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author JerryWang
 * @email 405877884@qq.com
 * @date 2017-12-25 13:40:37
 */
public class AppnewsviewimgEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//$column.comments
    @ApiModelProperty(value = "$column.comments",dataType="String",required = true,hidden = false)
	private String appNewsId;
	//$column.comments
    @ApiModelProperty(value = "$column.comments",dataType="String",required = true,hidden = false)
	private String filePath;
    @ApiModelProperty(value = "$column.comments",dataType="String",required = true,hidden = false)
    private String fileName;
	//$column.comments
    @ApiModelProperty(value = "$column.comments",dataType="String",required = true,hidden = false)
	private String id;
    
    
    
	public String getAppNewsId() {
		return appNewsId;
	}
	public void setAppNewsId(String appNewsId) {
		this.appNewsId = appNewsId;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
