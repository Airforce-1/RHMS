package com.khidi.manager.sys.service;

import java.util.List;


/**
 * 角色与部门对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017年6月21日 23:42:30
 */
public interface SysRoleDeptService {
	
	void saveOrUpdate(String roleId, List<String> deptIdList);
	
	/**
	 * 根据角色ID，获取部门ID列表
	 */
	List<String> queryDeptIdList(String roleId);
	
}
