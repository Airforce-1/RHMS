package com.khidi.manager.officework.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-10 11:56:31
 */
public class ChecktrailEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//经度
    @ApiModelProperty(value = "经度",dataType="String",required = true,hidden = false)
	private String x;
	//巡查记录编码
    @ApiModelProperty(value = "巡查记录编码",dataType="String",required = true,hidden = false)
	private String recordid;
	//纬度
    @ApiModelProperty(value = "纬度",dataType="String",required = true,hidden = false)
	private String y;
	//生成时间
    @ApiModelProperty(value = "生成时间",dataType="Date",required = true,hidden = false)
	private Date createtime;

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
	 * 设置：经度
	 */
	public void setX(String x) {
		this.x = x;
	}
	/**
	 * 获取：经度
	 */
	public String getX() {
		return x;
	}
	/**
	 * 设置：巡查记录编码
	 */
	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}
	/**
	 * 获取：巡查记录编码
	 */
	public String getRecordid() {
		return recordid;
	}
	/**
	 * 设置：纬度
	 */
	public void setY(String y) {
		this.y = y;
	}
	/**
	 * 获取：纬度
	 */
	public String getY() {
		return y;
	}
	/**
	 * 设置：生成时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：生成时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
}
