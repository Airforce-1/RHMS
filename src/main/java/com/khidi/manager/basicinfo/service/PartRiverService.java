package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.PartRiverEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
public interface PartRiverService {
	
	PartRiverEntity queryObject(String id);
	
	List<PartRiverEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PartRiverEntity partRiver);
	
	void update(PartRiverEntity partRiver);
	
	void delete(String id);

	List<PartRiverEntity> queryListByRiverId(String riverId);
}
