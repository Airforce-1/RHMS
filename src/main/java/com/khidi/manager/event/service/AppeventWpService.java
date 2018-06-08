package com.khidi.manager.event.service;

import com.khidi.manager.event.entity.AppeventWpEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-29 15:22:47
 */
public interface AppeventWpService {
	
	AppeventWpEntity queryObject(String id);
	
	List<AppeventWpEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AppeventWpEntity appeventWp);
	
	void update(AppeventWpEntity appeventWp);
	
	void delete(String id);
}
