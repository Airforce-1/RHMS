package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.ReservoirEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
public interface ReservoirService {
	
	ReservoirEntity queryObject(String id);
	
	List<ReservoirEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ReservoirEntity reservoir);
	
	void update(ReservoirEntity reservoir);
	
	void delete(String id);

	
}
