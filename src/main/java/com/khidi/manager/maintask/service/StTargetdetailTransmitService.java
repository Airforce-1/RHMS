package com.khidi.manager.maintask.service;

import com.khidi.manager.maintask.entity.StTargetdetailTransmitEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-03 10:29:04
 */
public interface StTargetdetailTransmitService {
	
	StTargetdetailTransmitEntity queryObject(String id);
	
	List<StTargetdetailTransmitEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(StTargetdetailTransmitEntity stTargetdetailTransmit);
	
	void update(StTargetdetailTransmitEntity stTargetdetailTransmit);
	
	void delete(String id);
}
