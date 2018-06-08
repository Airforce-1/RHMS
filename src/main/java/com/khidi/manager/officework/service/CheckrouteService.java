package com.khidi.manager.officework.service;

import com.khidi.manager.officework.entity.CheckrouteEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-13 15:01:00
 */
public interface CheckrouteService {
	
	CheckrouteEntity queryObject(String id);
	
	List<CheckrouteEntity> queryList(Map<String, Object> map);

	
	int queryTotal(Map<String, Object> map);
	
	void save(CheckrouteEntity checkroute);
	
	void update(CheckrouteEntity checkroute);
	
	void delete(String id);
}
