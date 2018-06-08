package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.PartCanalEntity;
import com.khidi.manager.basicinfo.entity.PartLakeEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
public interface PartLakeService {
	
	PartLakeEntity queryObject(String id);
	
	List<PartLakeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PartLakeEntity partLake);
	
	void update(PartLakeEntity partLake);
	
	void delete(String id);

	List<PartLakeEntity> queryListByLakeId(String lakeId);
	
}
