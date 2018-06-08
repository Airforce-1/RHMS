package com.khidi.manager.monitoringnet.service;

import com.khidi.manager.monitoringnet.entity.HydrologydataEntity;
import com.khidi.manager.monitoringnet.entity.WaterqualitydataEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-08 13:25:47
 */
public interface HydrologydataService {
	
	HydrologydataEntity queryObject(String id);
	
	List<HydrologydataEntity> queryList(Map<String, Object> map);
	List<HydrologydataEntity> querytopList(Map<String, Object> map);
	int queryTotal(Map<String, Object> map);
	
	void save(HydrologydataEntity hydrologydata);
	
	void update(HydrologydataEntity hydrologydata);
	
	void delete(String id);

	HydrologydataEntity queryObjectfortop(String id);
}
