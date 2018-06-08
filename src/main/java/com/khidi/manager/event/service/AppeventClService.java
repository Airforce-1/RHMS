package com.khidi.manager.event.service;

import com.khidi.manager.event.entity.AppeventClEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-29 15:22:47
 */
public interface AppeventClService {
	
	AppeventClEntity queryObject(String id);
	
	List<AppeventClEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AppeventClEntity appeventCl);
	
	void update(AppeventClEntity appeventCl);
	
	void delete(String id);
}
