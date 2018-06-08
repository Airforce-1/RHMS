package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.LakeEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
public interface LakeService {
	
	LakeEntity queryObject(String id);
	
	List<LakeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(LakeEntity lake);
	
	void update(LakeEntity lake);
	
	void delete(String id);
	
}
