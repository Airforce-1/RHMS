package com.khidi.manager.maintask.service;

import com.khidi.manager.maintask.entity.StSubtaskprogressEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-03 10:29:04
 */
public interface StSubtaskprogressService {
	
	StSubtaskprogressEntity queryObject(String id);
	
	List<StSubtaskprogressEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(StSubtaskprogressEntity stSubtaskprogress);
	
	void update(StSubtaskprogressEntity stSubtaskprogress);
	
	void delete(String id);
}
