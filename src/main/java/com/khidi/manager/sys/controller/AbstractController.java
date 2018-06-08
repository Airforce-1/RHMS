package com.khidi.manager.sys.controller;

import com.khidi.manager.sys.entity.SysRoleEntity;
import com.khidi.manager.sys.entity.SysUserEntity;
import com.khidi.manager.sys.service.SysRoleResourceService;
import com.khidi.manager.sys.service.SysRoleService;
import com.khidi.manager.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller公共组件
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月9日 下午9:42:26
 */
public abstract class AbstractController {
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysUserService sysUserService;
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUserEntity getUser() {
		return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
	}

	protected String getUserId() {
		return getUser().getUserId();
	}

	protected List<String> getRole(){
		return sysRoleService.queryRoleList(getUser().getUserId());
	}

	protected String getDeptId() {
		return getUser().getDeptId();
	}

	protected String getAreaId(){return getUser().getAreaId();}

	protected List<SysUserEntity> getUserListByDeptId(String deptId){
		return sysUserService.getUserListByDeptId(deptId);
	}
}
