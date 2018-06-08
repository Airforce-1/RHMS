package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.ResourceAirStationEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-30 09:39:48
 */
public interface ResourceAirStationService {
	
	ResourceAirStationEntity queryObject(String id);
	
	List<ResourceAirStationEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResourceAirStationEntity resourceAirStation);
	
	void update(ResourceAirStationEntity resourceAirStation);
	
	void delete(String id);
}
