package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.ResourceCompanywaterEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-22 17:36:48
 */
public interface ResourceCompanywaterService {
	
	ResourceCompanywaterEntity queryObject(String id);
	
	List<ResourceCompanywaterEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResourceCompanywaterEntity resourceCompanywater);
	
	void update(ResourceCompanywaterEntity resourceCompanywater);
	
	void delete(String id);
}
