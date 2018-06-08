package com.khidi.manager.event.service;

import com.khidi.manager.event.entity.AppeventStepsEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-29 15:22:47
 */
public interface AppeventStepsService {
	
	AppeventStepsEntity queryObject(String id);
	
	List<AppeventStepsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AppeventStepsEntity appeventSteps);
	
	void update(AppeventStepsEntity appeventSteps);
	
	void delete(String id);
}
