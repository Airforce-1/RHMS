package com.khidi.manager.event.service;

import com.khidi.manager.event.entity.AppeventInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-29 15:22:47
 */
public interface AppeventInfoService {
	
	AppeventInfoEntity queryObject(String id);
	
	List<AppeventInfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AppeventInfoEntity appeventInfo);
	
	void update(AppeventInfoEntity appeventInfo);
	
	void delete(String id);
}
