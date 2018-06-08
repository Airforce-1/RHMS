package com.khidi.manager.sys.entity;


import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 角色
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:27:38
 */
public class SysRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 角色ID
	 */
	@ApiModelProperty(value = "角色编码", required = false)
	private String roleId;
	/**
	 * 父节点ID
	 */
	@ApiModelProperty(value = "父节点编码", required = true)
	private String parentId;

	/**
	 * 角色名称
	 */
	@ApiModelProperty(value = "角色名称", required = true)
	@NotBlank(message="角色名称不能为空")
	private String roleName;

	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注", required = false)
	private String remark;

	/**
	 * 行政区划ID
	 */
	@ApiModelProperty(value = "行政区划ID", required = false)
	@NotBlank(message="行政区划不能为空")
	private String areaId;


	/**
	 * 所属机构编码
	 */
	@ApiModelProperty(value = "所属机构ID", required = false)
	private String deptId;


	/**
	 * 所属机构名称
	 */
	@ApiModelProperty(value = "所属机构名称", required = false,hidden = true)
	private String deptName;



	/**
	 * 职责描述
	 */
	@ApiModelProperty(value = "职责描述", required = false)
	private	String roleDescribe;

	/**
	 * 职务级别
	 */
	@ApiModelProperty(value = "职务级别", required = true)
	private	int roleLevel;

	/**
	 * 职务等级
	 */
	@ApiModelProperty(value = "职务类型", required = false)
	private	int roleType;
	/**
	 * 新增职务用户编码
	 */
	@ApiModelProperty(value = "新增职务用户编码", required = false,hidden = true)
	private	String creatUserId;



	/**
	 * 行政区划名称
	 */
	@ApiModelProperty(value = "行政区划名称", required = false,hidden = true)
	private String areaName;

	@ApiModelProperty(value = "菜单编号列表", required = false,hidden = true)
	private List<String> menuIdList;



	@ApiModelProperty(value = "行政区划编号列表", required = false,hidden = true)
	private List<String> areaIdList;


	@ApiModelProperty(value = "是否可以展开", required = false,hidden = true)
	private boolean open;
	@ApiModelProperty(value = "是否为父节点", required = false,hidden = true)
	private boolean isParent;
	@ApiModelProperty(value = "子列表", required = false,hidden = true)
	private List<?> list;

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public boolean isParent() {
		return isParent;
	}

	public void setParent(boolean parent) {
		isParent = parent;
	}

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "生成时间", required = false,hidden = true)
	private Date createTime;

	public boolean isOpen() {
		return open;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	/**
	 * 设置：
	 * @param roleId 
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * 获取：
	 * @return Long
	 */
	public String getRoleId() {
		return roleId;
	}
	
	/**
	 * 设置：角色名称
	 * @param roleName 角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * 获取：角色名称
	 * @return String
	 */
	public String getRoleName() {
		return roleName;
	}

	
	/**
	 * 设置：备注
	 * @param remark 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getCreatUserId() {
		return creatUserId;
	}

	public void setCreatUserId(String creatUserId) {
		this.creatUserId = creatUserId;
	}


	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * 获取：备注
	 * @return String
	 */



	public String getRemark() {
		return remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRoleDescribe() {
		return roleDescribe;
	}

	public void setRoleDescribe(String roleDescribe) {
		this.roleDescribe = roleDescribe;
	}

	public int getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(int roleLevel) {
		this.roleLevel = roleLevel;
	}

	public int getRoleType() {
		return roleType;
	}

	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}

	public List<String> getMenuIdList() {
		return menuIdList;
	}

	public void setMenuIdList(List<String> menuIdList) {
		this.menuIdList = menuIdList;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public List<String> getAreaIdList() {
		return areaIdList;
	}

	public void setAreaIdList(List<String> areaIdList) {
		this.areaIdList = areaIdList;
	}
}
