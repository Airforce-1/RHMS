package com.khidi.manager.sys.entity;

import com.khidi.common.validator.group.AddGroup;
import com.khidi.common.validator.group.UpdateGroup;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:28:55
 */
public class SysUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;



	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户ID", required = true)
	private String userId;

	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名", required = true)
	private String username;

	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码", required = true)
	private String password;

	/**
	 * 盐
	 */
	private String salt;

	/**
	 * 邮箱
	 */
	@ApiModelProperty(value = "邮箱", required = true)
	private String email;

	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "手机号码", required = false)
	private String mobile;

	/**
	 * 状态  0：禁用   1：正常
	 */
	@ApiModelProperty(value = "用户状态", required = true)
	private Integer status;

	/**
	 * 角色ID列表
	 */
	@ApiModelProperty(value = "角色列表", required = true)
	private String roleIdList;

	/**
	 * 创建者ID
	 */
	@ApiModelProperty(value = "创建者ID", required = true,hidden = true)
	private String createUserId;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间", required = true,hidden = true)
	private Date createTime;

	/**
	 * 部门ID
	 */
	@ApiModelProperty(value = "部门ID", required = true)
	private String deptId;

	/**
	 * 部门名称
	 */
	@ApiModelProperty(value = "部门名称", required = true,hidden = true)
	private String deptName;

	/**
	 * 行政区划ID
	 */
	@ApiModelProperty(value = "行政区划ID", required = true)
	@NotNull(message="行政区划不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String areaId;

	/**
	 * 部门名称
	 */
	@ApiModelProperty(value = "行政区划名称", required = true,hidden = true)
	private String areaName;
	/**
	 * APP用户类型
	 */
	@ApiModelProperty(value = "APP用户类型", required = false ,hidden = false)
	private String appType;





	//姓名
	@ApiModelProperty(value = "姓名",dataType="String",required = true,hidden = false)
	@NotNull(message="姓名不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	//性别
	@ApiModelProperty(value = "性别",dataType="String",required = true,hidden = false)
	private String sex;
	//办公电话
	@ApiModelProperty(value = "办公电话",dataType="String",required = true,hidden = false)
	private String officephone;
	//管辖范围
	@ApiModelProperty(value = "管辖范围",dataType="String",required = true,hidden = false)
	private String jurisdiction;
	//行政职务
	@ApiModelProperty(value = "行政职务",dataType="String",required = true,hidden = false)
	private String administrativeposts;
	//排序号
	@ApiModelProperty(value = "排序号",dataType="String",required = true,hidden = false)
	@NotNull(message="行政区划不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String ordernum;
	//职务编码
	@ApiModelProperty(value = "职务编码",dataType="String",required = true,hidden = false)
	private String roleId;
	//说明
	@ApiModelProperty(value = "说明",dataType="String",required = true,hidden = false)
	private String remark;

	//所属单位
	@ApiModelProperty(value = "所属单位",dataType="String",required = true,hidden = false)
	private String institute;

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：办公电话
	 */
	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}
	/**
	 * 获取：办公电话
	 */
	public String getOfficephone() {
		return officephone;
	}
	/**
	 * 设置：管辖范围
	 */
	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	/**
	 * 获取：管辖范围
	 */
	public String getJurisdiction() {
		return jurisdiction;
	}
	/**
	 * 设置：行政职务
	 */
	public void setAdministrativeposts(String administrativeposts) {
		this.administrativeposts = administrativeposts;
	}
	/**
	 * 获取：行政职务
	 */
	public String getAdministrativeposts() {
		return administrativeposts;
	}
	/**
	 * 设置：排序号
	 */
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	/**
	 * 获取：排序号
	 */
	public String getOrdernum() {
		return ordernum;
	}
	/**
	 * 设置：职务编码
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：职务编码
	 */
	public String getRoleId() {
		return roleId;
	}
	/**
	 * 设置：说明
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：说明
	 */
	public String getRemark() {
		return remark;
	}



	
	/**
	 * 设置：用户名
	 * @param username 用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取：用户名
	 * @return String
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * 设置：密码
	 * @param password 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取：密码
	 * @return String
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 设置：邮箱
	 * @param email 邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取：邮箱
	 * @return String
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 设置：手机号
	 * @param mobile 手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取：手机号
	 * @return String
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * 设置：状态  0：禁用   1：正常
	 * @param status 状态  0：禁用   1：正常
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取：状态  0：禁用   1：正常
	 * @return Integer
	 */
	public Integer getStatus() {
		return status;
	}
	
	/**
	 * 设置：创建时间
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：创建时间
	 * @return Date
	 */
	public Date getCreateTime() {
		return createTime;
	}

	public String getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(String roleIdList) {
		this.roleIdList = roleIdList;
	}



	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SysUserEntity sysUserEntity = (SysUserEntity) o;

		if (!userId.equals(sysUserEntity.userId)) return false;
		return username.equals(sysUserEntity.username);

	}
	@Override
	public int hashCode() {
		int re = userId.hashCode();
		re = 31 * re + username.hashCode();
		return re;
	}
}
