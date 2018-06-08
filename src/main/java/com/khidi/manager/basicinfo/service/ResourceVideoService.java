package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.ResourceVideoEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-22 17:36:48
 */
public interface ResourceVideoService {
	
	ResourceVideoEntity queryObject(String id);
	
	List<ResourceVideoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResourceVideoEntity resourceVideo);
	
	void update(ResourceVideoEntity resourceVideo);
	
	void delete(String id);


}
