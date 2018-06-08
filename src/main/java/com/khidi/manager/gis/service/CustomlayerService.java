package com.khidi.manager.gis.service;

import com.khidi.manager.gis.entity.CustomlayerEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author fu
 * @email
 * @date 2018-01-30 17:55:17
 */
public interface CustomlayerService {
	
	CustomlayerEntity queryObject(String id);
	
	List<CustomlayerEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CustomlayerEntity customlayer);
	
	void update(CustomlayerEntity customlayer);
	
	void delete(String id);
}
