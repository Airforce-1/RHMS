package com.khidi.manager.sys.service;

import com.khidi.manager.sys.entity.SysUserRoleEntity;

import java.util.List;
import java.util.Map;


/**
 * 用户与角色对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:43:24
 */
public interface SysUserRoleService {
	
	void saveOrUpdate(String userId, String roleIdList);
	
	/**
	 * 根据用户ID，获取角色ID列表
	 *
	 */
	void save(SysUserRoleEntity sysUserRoleEntity);


	void  delUserRole(SysUserRoleEntity sysUserRoleEntity);

	List<String> queryRoleIdList(String userId);
	
	void delete(String userId);

	List<SysUserRoleEntity> queryListforUser(Map<String, Object> map);
}
