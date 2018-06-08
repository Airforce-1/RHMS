package com.khidi.manager.maintask.service;

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
public interface StTaskdetailTransmitService {
	
	StTaskdetailTransmitEntity queryObject(String id);
	
	List<StTaskdetailTransmitEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(StTaskdetailTransmitEntity stTaskdetailTransmit);
	
	void update(StTaskdetailTransmitEntity stTaskdetailTransmit);
	
	void delete(String id);
}
