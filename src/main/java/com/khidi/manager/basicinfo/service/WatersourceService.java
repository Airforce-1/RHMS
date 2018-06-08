package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.WatersourceEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-15 15:37:03
 */
public interface WatersourceService {
	
	WatersourceEntity queryObject(String id);
	
	List<WatersourceEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WatersourceEntity watersource);
	
	void update(WatersourceEntity watersource);
	
	void delete(String id);
}
