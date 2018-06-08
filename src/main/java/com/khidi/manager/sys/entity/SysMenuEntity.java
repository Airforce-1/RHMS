package com.khidi.manager.sys.entity;


import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.dao.SysMenuDao;
import com.khidi.manager.sys.entity.base.TreeTableEntityBase;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 菜单管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:26:39
 */
public class SysMenuEntity implements TreeTableEntityBase {
	@Autowired
	private SysMenuDao sysMenuDao;
	private static final long serialVersionUID = 1L;
	
	/**
	 * 菜单ID
	 */
	@ApiModelProperty(value = "菜单ID", required = false)
	private String menuId;

	/**
	 * 父菜单ID，一级菜单为0
	 */
	@ApiModelProperty(value = "父菜单ID", required = true)
	private String parentId;

	/**
	 * 父菜单名称
	 */
	@ApiModelProperty(value = "父菜单名称", required = false)
	private String parentName;

	/**
	 * 菜单名称
	 */
	@ApiModelProperty(value = "菜单名称", required = true)
	private String name;
	/**
	 * 菜单名称
	 */
	@ApiModelProperty(value = "页面路径", required = false)
	private String url;




	/**
	 * 授权(多个用逗号分隔，如：user:list,user:create)
	 */
	@ApiModelProperty(value = "授权标识", required = false)
	private String perms;

	/**
	 * 类型     0：目录   1：菜单   2：按钮
	 */
	@ApiModelProperty(value = "类型", required = true)
	private BigDecimal type;

	/**
	 * 菜单图标
	 */
	@ApiModelProperty(value = "菜单图标", required = true)
	private String icon;

	/**
	 * 排序
	 */
	@ApiModelProperty(value = "排序", required = true)
	private BigDecimal orderNum;
	
	/**
	 * ztree属性
	 */

	@ApiModelProperty(value = "是否可以展开", required = false)
	private Boolean status;


	@ApiModelProperty(value = "是否可以展开", required = false)
	private Boolean open;
	@ApiModelProperty(value = "是否是父节点", required = false)
	private Boolean isParent;


	public Boolean getParent() {
		return isParent;
	}

	public void setParent(Boolean parent) {
		isParent = parent;
	}

	@ApiModelProperty(value = "子列表", required = false,hidden = true)
	private List<?> list;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * 设置：菜单名称
	 * @param name 菜单名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获取：菜单名称
	 * @return String
	 */



	public String getName() {
		return name;
	}

	
	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}

	public BigDecimal getType() {
		return type;
	}

	public void setType(BigDecimal type) {
		this.type = type;
	}




	/**
	 * 设置：菜单图标
	 * @param icon 菜单图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * 获取：菜单图标
	 * @return String
	 */
	public String getIcon() {
		return icon;
	}
	
	/**
	 * 设置：排序
	 * @param orderNum 排序
	 */
	public void setOrderNum(BigDecimal orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * 获取：排序
	 * @return Integer
	 */
	public BigDecimal getOrderNum() {
		return orderNum;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SysMenuEntity sysMenuEntity = (SysMenuEntity) o;

		if (!menuId.equals(sysMenuEntity.menuId)) return false;
		return menuId.equals(sysMenuEntity.menuId);

	}
	@Override
	public int hashCode() {
		int re = menuId.hashCode();
		re = 31 * re + menuId.hashCode();
		return re;
	}
}
