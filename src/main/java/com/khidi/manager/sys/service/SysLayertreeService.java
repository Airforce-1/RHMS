package com.khidi.manager.sys.service;

import com.khidi.manager.sys.entity.SysLayertreeEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-13 15:21:19
 */
public interface SysLayertreeService {
	
	SysLayertreeEntity queryObject(String id);
	
	List<SysLayertreeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysLayertreeEntity sysLayertree);
	
	void update(SysLayertreeEntity sysLayertree);
	
	void delete(String id);

	int queryCountbyParentId(String parentId);

	List<SysLayertreeEntity> querySonList(String parentId);

	String queryParentIdIsCorrent(SysLayertreeEntity entity);
}
