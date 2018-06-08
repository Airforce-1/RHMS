package com.khidi.manager.sys.service;

import com.khidi.manager.sys.entity.SysDeptEntity;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-20 15:23:47
 */
public interface SysDeptService {
	
	SysDeptEntity queryObject(String deptId);
	
	List<SysDeptEntity> queryList(Map<String, Object> map);

	void save(SysDeptEntity sysDept);
	
	void update(SysDeptEntity sysDept);
	
	void delete(String deptId);

	/**
	 * 查询子部门ID列表
	 * @param parentId  上级部门ID
	 */
	List<String> queryDetpIdList(String parentId);

	/**
	 * 获取子部门ID(包含本部门ID)，用于数据过滤
	 */
	String getSubDeptIdList(String deptId);

	String queryParentIdIsCorrent(SysDeptEntity entity);

}
