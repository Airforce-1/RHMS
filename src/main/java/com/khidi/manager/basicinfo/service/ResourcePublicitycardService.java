package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.ResourcePublicitycardEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-04 18:19:33
 */
public interface ResourcePublicitycardService {
	
	ResourcePublicitycardEntity queryObject(String id);
	
	List<ResourcePublicitycardEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResourcePublicitycardEntity resourcePublicitycard);
	
	void update(ResourcePublicitycardEntity resourcePublicitycard);
	
	void delete(String id);
}
