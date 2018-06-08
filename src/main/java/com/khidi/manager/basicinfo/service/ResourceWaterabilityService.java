package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.ResourceWaterabilityEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-24 08:27:48
 */
public interface ResourceWaterabilityService {
	
	ResourceWaterabilityEntity queryObject(String id);
	
	List<ResourceWaterabilityEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResourceWaterabilityEntity resourceWaterability);
	
	void update(ResourceWaterabilityEntity resourceWaterability);
	
	void delete(String id);
}
