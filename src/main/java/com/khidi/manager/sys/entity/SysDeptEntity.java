package com.khidi.manager.sys.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;


/**
 * 部门管理
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-06-20 15:23:47
 */
public class SysDeptEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "部门ID", required = false)
	private String deptId;
	@ApiModelProperty(value = "父部门ID", required = false)
	private String parentId;
	@ApiModelProperty(value = "部门名称", required = false)
	private String name;
	@ApiModelProperty(value = "上级部门名称", required = false,hidden = true)
	private String parentName;
	@ApiModelProperty(value = "排序字段", required = false)
	private Integer orderNum;



	//机构级别
	@ApiModelProperty(value = "机构级别",dataType="Double",required = true,hidden = false)
	private Double deptLevel;
	//行政区域编码
	@ApiModelProperty(value = "行政区域编码",dataType="String",required = true,hidden = false)
	private String areaId;
	//行政区域名称
	@ApiModelProperty(value = "行政区域编码",dataType="String",required = true,hidden = false)
	private String areaName;
	//机构类型
	@ApiModelProperty(value = "机构类型",dataType="Double",required = true,hidden = false)
	private Double deptType;
	//机构职责描述
	@ApiModelProperty(value = "机构职责描述",dataType="String",required = true,hidden = false)
	private String deptDesc;
	//备注
	@ApiModelProperty(value = "备注",dataType="String",required = true,hidden = false)
	private String remark;
	/**
	 * ztree属性
	 */
	@ApiModelProperty(value = "是否可以展开", required = false,hidden = true)
	private Boolean open;
	@ApiModelProperty(value = "子节点list", required = false,hidden = true)
	private List<?> list;
	@ApiModelProperty(value = "是否删除", required = false,hidden=true)
	private int delFlag;


	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * 设置：部门名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：部门名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrderNum() {
		return orderNum;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	/**
	 * 设置：机构级别
	 */
	public void setDeptLevel(Double deptLevel) {
		this.deptLevel = deptLevel;
	}
	/**
	 * 获取：机构级别
	 */
	public Double getDeptLevel() {
		return deptLevel;
	}
	/**
	 * 设置：行政区域编码
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	/**
	 * 获取：行政区域编码
	 */
	public String getAreaId() {
		return areaId;
	}
	/**
	 * 设置：机构类型
	 */
	public void setDeptType(Double deptType) {
		this.deptType = deptType;
	}
	/**
	 * 获取：机构类型
	 */
	public Double getDeptType() {
		return deptType;
	}
	/**
	 * 设置：机构职责描述
	 */
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}
	/**
	 * 获取：机构职责描述
	 */
	public String getDeptDesc() {
		return deptDesc;
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
