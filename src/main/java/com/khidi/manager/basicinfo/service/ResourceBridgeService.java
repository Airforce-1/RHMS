package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.ResourceBridgeEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-22 17:36:48
 */
public interface ResourceBridgeService {
	
	ResourceBridgeEntity queryObject(String id);
	
	List<ResourceBridgeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResourceBridgeEntity resourceBridge);
	
	void update(ResourceBridgeEntity resourceBridge);
	
	void delete(String id);
}
