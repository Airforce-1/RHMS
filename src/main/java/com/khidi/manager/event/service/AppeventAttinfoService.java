package com.khidi.manager.event.service;

import com.khidi.manager.event.entity.AppeventAttinfoEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-29 15:22:47
 */
public interface AppeventAttinfoService {
	
	AppeventAttinfoEntity queryObject(String id);
	
	List<AppeventAttinfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AppeventAttinfoEntity appeventAttinfo);
	
	void update(AppeventAttinfoEntity appeventAttinfo);
	
	void delete(String id);
}
