package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.PumpstationEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-15 15:37:03
 */
public interface PumpstationService {
	
	PumpstationEntity queryObject(String id);
	
	List<PumpstationEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PumpstationEntity pumpstation);
	
	void update(PumpstationEntity pumpstation);
	
	void delete(String id);
}
