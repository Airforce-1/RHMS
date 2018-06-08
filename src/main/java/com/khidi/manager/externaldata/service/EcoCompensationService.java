package com.khidi.manager.externaldata.service;

import com.khidi.manager.externaldata.entity.EcoCompensationEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-17 16:39:02
 */
public interface EcoCompensationService {
	
	EcoCompensationEntity queryObject(String id);
	
	List<EcoCompensationEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(EcoCompensationEntity ecoCompensation);
	
	void update(EcoCompensationEntity ecoCompensation);
	
	void delete(String id);
	List<EcoCompensationEntity> queryListByStationId(String stationId);
}
