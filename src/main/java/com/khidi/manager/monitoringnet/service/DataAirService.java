package com.khidi.manager.monitoringnet.service;

import com.khidi.manager.monitoringnet.entity.DataAirEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-30 14:23:59
 */
public interface DataAirService {
	
	DataAirEntity queryObject(String id);
	
	List<DataAirEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DataAirEntity dataAir);
	
	void update(DataAirEntity dataAir);
	
	void delete(String id);

	DataAirEntity getAir4Gis(String stationId);
}
