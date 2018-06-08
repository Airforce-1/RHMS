package com.khidi.manager.maintask.service;

import com.khidi.manager.maintask.entity.StTaskEntity;
import com.khidi.manager.maintask.entity.StTaskdetailEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-03 10:29:04
 */
public interface StTaskService {
	
	StTaskEntity queryObject(String id);
	
	List<StTaskEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(StTaskEntity stTask);
	
	void update(StTaskEntity stTask);
	
	void delete(String id);

	List<StTaskdetailEntity>  queryTaskDetailByTaskId (String StTaskId);
}
