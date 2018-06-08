package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.PartCanalEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
public interface PartCanalService {
	
	PartCanalEntity queryObject(String id);
	
	List<PartCanalEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PartCanalEntity partCanal);
	
	void update(PartCanalEntity partCanal);
	
	void delete(String id);

	List<PartCanalEntity> queryListByCanalId(String canalId);
	
}
