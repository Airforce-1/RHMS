package com.khidi.manager.sys.service;

import com.khidi.manager.sys.entity.SysMenuEntity;
import com.khidi.manager.sys.entity.SysRoleResourceEntity;
import com.khidi.manager.sys.vo.RoleResourceIdsVO;
import com.khidi.manager.sys.vo.Vo4River;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-14 14:31:17
 */
public interface SysRoleResourceService {
	
	SysRoleResourceEntity queryObject(String id);

	List<RoleResourceIdsVO> stations(Map<String,Object> map);
	Vo4River rivers(String roleId,String parentId);
	Vo4River canals(String roleId,String parentId);
	Vo4River lakes(String roleId,String parentId);
	Vo4River reservoirs(String roleId,String parentId);
	Vo4River areas(String roleId,String parentId);
	List<SysRoleResourceEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysRoleResourceEntity sysRoleResource);
	
	void update(SysRoleResourceEntity sysRoleResource);
	
	void delete(String id);
	SysMenuEntity menus(String roleId);
	List<RoleResourceIdsVO> permstations(String roleId);
	SysRoleResourceEntity queryObjectByRoleId(String roleId);
}
