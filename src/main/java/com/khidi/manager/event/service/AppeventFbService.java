package com.khidi.manager.event.service;

import com.khidi.manager.event.entity.AppeventFbEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-29 15:22:47
 */
public interface AppeventFbService {
	
	AppeventFbEntity queryObject(String id);
	
	List<AppeventFbEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AppeventFbEntity appeventFb);
	
	void update(AppeventFbEntity appeventFb);
	
	void delete(String id);
}
