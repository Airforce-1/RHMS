package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.RiverEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
public interface RiverService {
	
	RiverEntity queryObject(String id);
	
	List<RiverEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	List<RiverEntity> queryChildrenRivers(String parentId);
	
	void save(RiverEntity river);
	
	void update(RiverEntity river);
	
	void delete(String id);
}
