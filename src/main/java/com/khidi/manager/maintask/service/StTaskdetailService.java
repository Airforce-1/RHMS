package com.khidi.manager.maintask.service;

import com.khidi.manager.maintask.entity.StSubtaskprogressEntity;
import com.khidi.manager.maintask.entity.StTaskdetailEntity;
import com.khidi.manager.maintask.entity.StTaskdetailTransmitEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-03 10:29:04
 */
public interface StTaskdetailService {
	
	StTaskdetailEntity queryObject(String id);
	
	List<StTaskdetailEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(StTaskdetailEntity stTaskdetail);
	
	void update(StTaskdetailEntity stTaskdetail);
	
	void delete(String id);

}
