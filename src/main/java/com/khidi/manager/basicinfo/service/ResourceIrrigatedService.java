package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.ResourceIrrigatedEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-24 08:27:48
 */
public interface ResourceIrrigatedService {
	
	ResourceIrrigatedEntity queryObject(String id);
	
	List<ResourceIrrigatedEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResourceIrrigatedEntity resourceIrrigated);
	
	void update(ResourceIrrigatedEntity resourceIrrigated);
	
	void delete(String id);
}
