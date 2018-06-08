package com.khidi.manager.externaldata.service;

import com.khidi.manager.externaldata.entity.ExternalAttributeEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-18 15:14:19
 */
public interface ExternalAttributeService {
	
	ExternalAttributeEntity queryObject(String id);
	
	List<ExternalAttributeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ExternalAttributeEntity externalAttribute);
	
	void update(ExternalAttributeEntity externalAttribute);
	
	void delete(String id);
}
