package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.WatergateEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-15 15:37:03
 */
public interface WatergateService {
	
	WatergateEntity queryObject(String id);
	
	List<WatergateEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WatergateEntity watergate);
	
	void update(WatergateEntity watergate);
	
	void delete(String id);
}
