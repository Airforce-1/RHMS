package com.khidi.manager.officework.service;

import com.khidi.manager.officework.entity.ChecktrailEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-10 11:56:31
 */
public interface ChecktrailService {
	
	ChecktrailEntity queryObject(String id);
	
	List<ChecktrailEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ChecktrailEntity checktrail);
	
	void update(ChecktrailEntity checktrail);
	
	void delete(String id);
}
