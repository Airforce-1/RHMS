package com.khidi.manager.event.service;

import com.khidi.manager.event.entity.AppeventWphsEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-29 15:22:47
 */
public interface AppeventWphsService {
	
	AppeventWphsEntity queryObject(String id);
	
	List<AppeventWphsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AppeventWphsEntity appeventWphs);
	
	void update(AppeventWphsEntity appeventWphs);
	
	void delete(String id);
}
