package com.khidi.manager.socialparticipation.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-08 15:06:21
 */
public class AppmenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//菜单名称
    @ApiModelProperty(value = "菜单名称",dataType="String",required = true,hidden = false)
	private String name;
	//菜单编码
    @ApiModelProperty(value = "菜单编码",dataType="String",required = true,hidden = false)
	private String code;
	//父节点编码
    @ApiModelProperty(value = "父节点编码",dataType="String",required = true,hidden = false)
	private String parentId;
    
    // 子节点
    @ApiModelProperty(value = "子节点",dataType="AppmenuEntity",required = true,hidden = false)
    private List<AppmenuEntity> list;
    
    
	public List<AppmenuEntity> getList() {
		return list;
	}
	public void setList(List<AppmenuEntity> list) {
		this.list = list;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	//备注
    @ApiModelProperty(value = "备注",dataType="String",required = true,hidden = false)
	private String remark;
    
    // 是否能展开
    @ApiModelProperty(value = "是否能展开",dataType="String",required = true,hidden = false)
    private boolean open;

	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
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
	 * 设置：菜单名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：菜单名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：菜单编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：菜单编码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
}
