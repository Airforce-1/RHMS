package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.CanalEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
public interface CanalService {
	
	CanalEntity queryObject(String id);
	
	List<CanalEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CanalEntity canal);
	
	void update(CanalEntity canal);
	
	void delete(String id);
	
}
