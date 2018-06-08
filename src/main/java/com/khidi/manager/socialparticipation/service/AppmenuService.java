package com.khidi.manager.socialparticipation.service;

import com.khidi.manager.socialparticipation.entity.AppmenuEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-08 15:06:21
 */
public interface AppmenuService {
	
	AppmenuEntity queryObject(String id);
	
	List<AppmenuEntity> queryList(Map<String, Object> map);
	
	List<AppmenuEntity> queryList0(Map<String, Object> map);
	
	List<AppmenuEntity> queryAll();
	
	List<AppmenuEntity> queryChildren(String id);
	
	int queryTotal(Map<String, Object> map);
	
	int querySonMenusCounts(String parentid);
	
	void save(AppmenuEntity appmenu);
	
	void update(AppmenuEntity appmenu);
	
	void delete(String id);
}
