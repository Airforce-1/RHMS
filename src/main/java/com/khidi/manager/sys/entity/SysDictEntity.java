package com.khidi.manager.sys.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * 系统字典
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 16:49:47
 */
public class SysDictEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//生成时间
    @ApiModelProperty(value = "生成时间",dataType="Date",required = false,hidden = true)
	private Date createTime;
	//字典值
    @ApiModelProperty(value = "字典值",dataType="String",required = true,hidden = false)
	private String dictValue;
	//编码
    @ApiModelProperty(value = "编码",dataType="String",required = false,hidden = false)
	private String id;
	//字典分类
    @ApiModelProperty(value = "字典分类",dataType="String",required = true,hidden = false)
	private String dictType;
	//字典名称
    @ApiModelProperty(value = "字典名称",dataType="String",required = true,hidden = false)
	private String dictName;

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
	 * 设置：字典值
	 */
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}
	/**
	 * 获取：字典值
	 */
	public String getDictValue() {
		return dictValue;
	}
	/**
	 * 设置：编码
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：编码
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：字典分类
	 */
	public void setDictType(String dictType) {
		this.dictType = dictType;
	}
	/**
	 * 获取：字典分类
	 */
	public String getDictType() {
		return dictType;
	}
	/**
	 * 设置：字典名称
	 */
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	/**
	 * 获取：字典名称
	 */
	public String getDictName() {
		return dictName;
	}
}
