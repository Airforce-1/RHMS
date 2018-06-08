package com.khidi.manager.sys.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-17 18:00:07
 */
public class SysResourceEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
    @ApiModelProperty(value = "编号",dataType="String",required = true,hidden = false)
	private String id;
	//资源信息
    @ApiModelProperty(value = "资源信息",dataType="String",required = true,hidden = false)
	private String resourceInfo;
	//资源对应表
    @ApiModelProperty(value = "资源对应表",dataType="String",required = true,hidden = false)
	private String resourceTablename;
	//生成时间
    @ApiModelProperty(value = "生成时间",dataType="Date",required = true,hidden = true)
	private Date createTime;
	//资源类型
    @ApiModelProperty(value = "资源类型",dataType="Double",required = true,hidden = false)
	private Double resourceType;

	/**
	 * 设置：编号
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：编号
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：资源信息
	 */
	public void setResourceInfo(String resourceInfo) {
		this.resourceInfo = resourceInfo;
	}
	/**
	 * 获取：资源信息
	 */
	public String getResourceInfo() {
		return resourceInfo;
	}
	/**
	 * 设置：资源对应表
	 */
	public void setResourceTablename(String resourceTablename) {
		this.resourceTablename = resourceTablename;
	}
	/**
	 * 获取：资源对应表
	 */
	public String getResourceTablename() {
		return resourceTablename;
	}
	/**
	 * 设置：生成时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：生成时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：资源类型
	 */
	public void setResourceType(Double resourceType) {
		this.resourceType = resourceType;
	}
	/**
	 * 获取：资源类型
	 */
	public Double getResourceType() {
		return resourceType;
	}
}
