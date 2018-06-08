package com.khidi.manager.sys.entity;


import com.khidi.common.validator.group.AddGroup;
import com.khidi.common.validator.group.UpdateGroup;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户与角色对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:28:39
 */
public class SysUserRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;

	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户编码", required = true)
	@NotNull(message="用户不能为空", groups = {AddGroup.class})
	private String userId;

	/**
	 * 角色ID
	 */
	@ApiModelProperty(value = "角色编码", required = true)
	@NotNull(message="角色不能为空", groups = {AddGroup.class})
	private String roleId;

	/**
	 * 设置：
	 * @param id 
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取：
	 * @return Long
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 设置：用户ID
	 * @param userId 用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 获取：用户ID
	 * @return Long
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置：角色ID
	 * @param roleId 角色ID
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * 获取：角色ID
	 * @return Long
	 */
	public String getRoleId() {
		return roleId;
	}
	
}
