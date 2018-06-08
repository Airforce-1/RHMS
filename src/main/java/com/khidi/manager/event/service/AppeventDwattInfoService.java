package com.khidi.manager.event.service;

import com.khidi.manager.event.entity.AppeventDwattInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-29 15:22:47
 */
public interface AppeventDwattInfoService {
	
	AppeventDwattInfoEntity queryObject(String id);
	
	List<AppeventDwattInfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AppeventDwattInfoEntity appeventDwattInfo);
	
	void update(AppeventDwattInfoEntity appeventDwattInfo);
	
	void delete(String id);
}
