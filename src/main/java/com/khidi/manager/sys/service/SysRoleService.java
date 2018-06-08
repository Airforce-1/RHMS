package com.khidi.manager.sys.service;

import com.khidi.manager.sys.entity.SysMenuEntity;
import com.khidi.manager.sys.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;


/**
 * 角色
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:42:52
 */
public interface SysRoleService {
	
	SysRoleEntity queryObject(String roleId);
	
	List<SysRoleEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysRoleEntity role);
	
	void update(SysRoleEntity role);

	void delete(String roleId);

	List<String> queryRoleIdList(String parentId);

	List<String> queryRoleList(String user_id);

	String queryParentIdIsCorrent(SysRoleEntity entity);

	List<SysRoleEntity> querySonList(String parentId);
}
