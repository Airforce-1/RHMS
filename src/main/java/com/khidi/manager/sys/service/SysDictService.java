package com.khidi.manager.sys.service;

import com.khidi.manager.sys.entity.SysDictEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-17 09:48:30
 */
public interface SysDictService {
	
	SysDictEntity queryObject(String id);
	
	List<SysDictEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysDictEntity sysDict);
	
	void update(SysDictEntity sysDict);
	
	void delete(String id);

	SysDictEntity queryObject(Map<String, Object> map);
	 String typevalue4name(String type,String value);
	
}
