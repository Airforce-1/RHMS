package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.ResourceStationEntity;
import com.khidi.manager.monitoringnet.entity.WaterqualitydataEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-22 17:36:48 Jerry Wang 2017 12 23
 */
public interface ResourceStationService {

	ResourceStationEntity queryObject(String id);

	List<ResourceStationEntity> queryList(Map<String, Object> map);

	int queryTotal(Map<String, Object> map);

	List<ResourceStationEntity> queryByResource(String resourceId, String resourceType, String stationType);
	
	List<ResourceStationEntity> queryUpStationLinks(String resourceId, String resourceType, String stationType);
	
	List<ResourceStationEntity> allStations(String stationType);

	List<WaterqualitydataEntity> queryWaterqualitydata(String resourceId, String resourceType, String stationType);
	
	List<WaterqualitydataEntity> queryWaterqualitydata(String resourceIds,String ctDate);

	void save(ResourceStationEntity resourceStation);

	void update(ResourceStationEntity resourceStation);

	void delete(String id);

	ResourceStationEntity queryObjectByCode(String code);
}
