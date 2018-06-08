package com.khidi.manager.sys.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-13 15:21:19
 */
public class SysLayertreeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//图层名称
    @ApiModelProperty(value = "图层名称",dataType="String",required = true,hidden = false)
	private String name;
	//模块编码
    @ApiModelProperty(value = "模块编码",dataType="String",required = true,hidden = false)
	private String code;
	//图层类型
    @ApiModelProperty(value = "图层类型",dataType="String",required = true,hidden = false)
	private String type;
	//上级图层
    @ApiModelProperty(value = "上级图层",dataType="String",required = true,hidden = false)
	private String parentId;
	//图标
    @ApiModelProperty(value = "图标",dataType="String",required = true,hidden = false)
	private String icon;
	//查询面板
    @ApiModelProperty(value = "查询面板",dataType="String",required = true,hidden = false)
	private String queryplant;
	//标题
    @ApiModelProperty(value = "标题",dataType="String",required = true,hidden = false)
	private String title;
	//图层来源
    @ApiModelProperty(value = "图层来源",dataType="String",required = true,hidden = false)
	private String layersource;
	//参数
    @ApiModelProperty(value = "参数",dataType="String",required = true,hidden = false)
	private String args;
	//生成时间
    @ApiModelProperty(value = "生成时间",dataType="Date",required = true,hidden = false)
	private Date createtime;
    private Boolean open;
	private List<?> list;
	private String orderNum;

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
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
	 * 设置：图层名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：图层名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：模块编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：模块编码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：图层类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：图层类型
	 */
	public String getType() {
		return type;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * 设置：图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：图标
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：查询面板
	 */
	public void setQueryplant(String queryplant) {
		this.queryplant = queryplant;
	}
	/**
	 * 获取：查询面板
	 */
	public String getQueryplant() {
		return queryplant;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：图层来源
	 */
	public void setLayersource(String layersource) {
		this.layersource = layersource;
	}
	/**
	 * 获取：图层来源
	 */
	public String getLayersource() {
		return layersource;
	}
	/**
	 * 设置：参数
	 */
	public void setArgs(String args) {
		this.args = args;
	}
	/**
	 * 获取：参数
	 */
	public String getArgs() {
		return args;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SysLayertreeEntity sysLayertreeEntity  = (SysLayertreeEntity) o;

		if (!id.equals(sysLayertreeEntity.id)) return false;
		return id.equals(sysLayertreeEntity.id);

	}
	@Override
	public int hashCode() {
		int re = id.hashCode();
		re = 31 * re + id.hashCode();
		return re;
	}

}
