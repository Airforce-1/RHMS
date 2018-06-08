package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.PartReservoirEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
public interface PartReservoirService {
	
	PartReservoirEntity queryObject(String id);
	
	List<PartReservoirEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PartReservoirEntity partReservoir);
	
	void update(PartReservoirEntity partReservoir);
	
	void delete(String id);

	List<PartReservoirEntity> queryListByReservoirId(String reservoirId);
	
}
