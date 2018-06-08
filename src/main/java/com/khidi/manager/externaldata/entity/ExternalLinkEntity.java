package com.khidi.manager.externaldata.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-18 16:16:33
 */
public class ExternalLinkEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//连接区域
    @ApiModelProperty(value = "连接区域",dataType="String",required = true,hidden = false)
	private String area;
	//连接符
    @ApiModelProperty(value = "连接符",dataType="String",required = true,hidden = false)
	private String url;
	//拉取数据频率
    @ApiModelProperty(value = "拉取数据频率",dataType="String",required = true,hidden = false)
	private String rate;
	//被关联表名
    @ApiModelProperty(value = "被关联表名",dataType="String",required = true,hidden = false)
	private String linkTable;
	//是否启用
    @ApiModelProperty(value = "是否启用",dataType="String",required = true,hidden = false)
	private String enable;
	//业务描述
    @ApiModelProperty(value = "业务描述",dataType="String",required = true,hidden = false)
	private String describe;
	//生成时间
    @ApiModelProperty(value = "生成时间",dataType="Date",required = true,hidden = false)
	private Date createTime;
	//连接支持的方法
    @ApiModelProperty(value = "连接支持的方法",dataType="String",required = true,hidden = false)
	private String method;
	//验证符
    @ApiModelProperty(value = "验证符",dataType="String",required = true,hidden = false)
	private String authorization;
	//最近一次更新时间
	@ApiModelProperty(value = "验证符",dataType="String",required = true,hidden = false)
	private String newDataTime;

	public String getNewDataTime() {
		return newDataTime;
	}

	public void setNewDataTime(String newDataTime) {
		this.newDataTime = newDataTime;
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
	 * 设置：连接区域
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：连接区域
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置：连接符
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：连接符
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：拉取数据频率
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	/**
	 * 获取：拉取数据频率
	 */
	public String getRate() {
		return rate;
	}
	/**
	 * 设置：被关联表名
	 */
	public void setLinkTable(String linkTable) {
		this.linkTable = linkTable;
	}
	/**
	 * 获取：被关联表名
	 */
	public String getLinkTable() {
		return linkTable;
	}
	/**
	 * 设置：是否启用
	 */
	public void setEnable(String enable) {
		this.enable = enable;
	}
	/**
	 * 获取：是否启用
	 */
	public String getEnable() {
		return enable;
	}
	/**
	 * 设置：业务描述
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	/**
	 * 获取：业务描述
	 */
	public String getDescribe() {
		return describe;
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
	 * 设置：连接支持的方法
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * 获取：连接支持的方法
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * 设置：验证符
	 */
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	/**
	 * 获取：验证符
	 */
	public String getAuthorization() {
		return authorization;
	}
}
