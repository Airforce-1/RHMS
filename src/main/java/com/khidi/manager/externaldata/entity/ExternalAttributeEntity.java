package com.khidi.manager.externaldata.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-18 15:14:19
 */
public class ExternalAttributeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//连接区域编码
    @ApiModelProperty(value = "连接区域编码",dataType="String",required = true,hidden = false)
	private String linkId;
	//连接区域名称
	@ApiModelProperty(value = "连接区域编码",dataType="String",required = true,hidden = false)
	private String linkName;
	//目标属性
    @ApiModelProperty(value = "目标属性",dataType="String",required = true,hidden = false)
	private String destAttr;
	//目标属性类型
    @ApiModelProperty(value = "目标属性类型",dataType="String",required = true,hidden = false)
	private String destType;
	//源数据属性
    @ApiModelProperty(value = "源数据属性",dataType="String",required = true,hidden = false)
	private String originAttr;
	//源数据属性类型
    @ApiModelProperty(value = "源数据属性类型",dataType="String",required = true,hidden = false)
	private String originType;
	//源数据属性类型
	@ApiModelProperty(value = "属性描述",dataType="String",required = true,hidden = false)
	private String attrDesc;

	public String getAttrDesc() {
		return attrDesc;
	}

	public void setAttrDesc(String attrDesc) {
		this.attrDesc = attrDesc;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
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
	 * 设置：连接区域编码
	 */
	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}
	/**
	 * 获取：连接区域编码
	 */
	public String getLinkId() {
		return linkId;
	}
	/**
	 * 设置：目标属性
	 */
	public void setDestAttr(String destAttr) {
		this.destAttr = destAttr;
	}
	/**
	 * 获取：目标属性
	 */
	public String getDestAttr() {
		return destAttr;
	}
	/**
	 * 设置：目标属性类型
	 */
	public void setDestType(String destType) {
		this.destType = destType;
	}
	/**
	 * 获取：目标属性类型
	 */
	public String getDestType() {
		return destType;
	}
	/**
	 * 设置：源数据属性
	 */
	public void setOriginAttr(String originAttr) {
		this.originAttr = originAttr;
	}
	/**
	 * 获取：源数据属性
	 */
	public String getOriginAttr() {
		return originAttr;
	}
	/**
	 * 设置：源数据属性类型
	 */
	public void setOriginType(String originType) {
		this.originType = originType;
	}
	/**
	 * 获取：源数据属性类型
	 */
	public String getOriginType() {
		return originType;
	}
}
