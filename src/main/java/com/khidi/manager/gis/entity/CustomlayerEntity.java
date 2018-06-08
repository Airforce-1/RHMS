package com.khidi.manager.gis.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author fu
 * @email
 * @date 2018-01-30 17:55:17
 */
public class CustomlayerEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//图层编号
    @ApiModelProperty(value = "图层编号",dataType="String",required = true,hidden = false)
	private String id;
	//图层名称
    @ApiModelProperty(value = "图层名称",dataType="String",required = true,hidden = false)
	private String title;
	//点集
    @ApiModelProperty(value = "点集",dataType="unknowType",required = true,hidden = false)
	private String geoset;

	/**
	 * 设置：图层编号
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：图层编号
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：图层名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：图层名称
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：点集
	 */
	public void setGeoset(String geoset) {
		this.geoset = geoset;
	}
	/**
	 * 获取：点集
	 */
	public String getGeoset() {
		return geoset;
	}
}
