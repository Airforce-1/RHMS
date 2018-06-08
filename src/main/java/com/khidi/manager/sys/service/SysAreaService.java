package com.khidi.manager.sys.service;

import com.khidi.manager.sys.entity.SysAreaEntity;

import java.util.List;
import java.util.Map;

/**
 * 行政区域管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-20 15:23:47
 */
public interface SysAreaService {
	
	SysAreaEntity queryObject(String areaId);
	
	List<SysAreaEntity> queryList(Map<String, Object> map);


	SysAreaEntity save(SysAreaEntity sysArea);

	SysAreaEntity update(SysAreaEntity sysArea);
	
	void delete(String areaId);

	/**
	 * 查询子部门ID列表
	 * @param parentId  上级部门ID
	 */
	List<String> queryAreaIdList(String parentId);

	/**
	 * 获取子部门ID(包含本部门ID)，用于数据过滤
	 */
	String getSubAreaIdList(String areaId);
	List<SysAreaEntity> queryListByParentId(String parentId);
	List<SysAreaEntity> queryExistsByParentId(String parentId);
	List<SysAreaEntity> getList4Open();
	List<String> getSonAreaIdList(String areaId);
	String queryParentIdIsCorrent(SysAreaEntity entity);

}
