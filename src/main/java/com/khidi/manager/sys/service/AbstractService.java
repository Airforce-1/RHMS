package com.khidi.manager.sys.service;

import com.khidi.manager.sys.dao.SysRoleDao;
import com.khidi.manager.sys.entity.SysUserEntity;
import com.khidi.manager.sys.service.SysRoleService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Service层获取角色用户权限公共组件
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月9日 下午9:42:26
 */
public abstract class AbstractService {
	@Autowired
	private SysRoleDao sysRoleDao;
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUserEntity getUser() {
		return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
	}

	protected String getUserId() {
		return getUser().getUserId();
	}

	protected List<String> getRole(){
		return sysRoleDao.queryRoleList(getUser().getUserId());
	}

	protected String getDeptId() {
		return getUser().getDeptId();
	}

	protected String getAreaId(){return getUser().getAreaId();}
}
