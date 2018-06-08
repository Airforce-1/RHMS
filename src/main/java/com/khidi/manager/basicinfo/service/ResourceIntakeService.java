package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.ResourceIntakeEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-22 17:36:48
 */
public interface ResourceIntakeService {
	
	ResourceIntakeEntity queryObject(String id);
	
	List<ResourceIntakeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResourceIntakeEntity resourceIntake);
	
	void update(ResourceIntakeEntity resourceIntake);
	
	void delete(String id);
}
