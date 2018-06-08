package com.khidi.manager.sys.service;

import com.khidi.manager.sys.entity.SysRoleMenuEntity;

import java.util.List;



/**
 * 角色与菜单对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:42:30
 */
public interface SysRoleMenuService {
	
	void saveOrUpdate(SysRoleMenuEntity sysRoleMenuEntity);

	void delete(String roleId);
	
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<String> queryMenuIdList(String roleId);
	
}
