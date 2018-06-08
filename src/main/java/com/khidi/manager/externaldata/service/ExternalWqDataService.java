package com.khidi.manager.externaldata.service;

import com.khidi.manager.externaldata.entity.ExternalWqDataEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-24 10:56:45
 */
public interface ExternalWqDataService {
	
	ExternalWqDataEntity queryObject(String id);
	
	List<ExternalWqDataEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ExternalWqDataEntity externalWqData);
	
	void update(ExternalWqDataEntity externalWqData);
	
	void delete(String id);
}
