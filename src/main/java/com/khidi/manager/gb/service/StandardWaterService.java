package com.khidi.manager.gb.service;

import com.khidi.manager.gb.entity.StandardWaterEntity;
import com.khidi.manager.gb.vo.DataByLevelVo;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-29 11:12:03
 */
public interface StandardWaterService {
	
	StandardWaterEntity queryObject(String id);
	
	List<StandardWaterEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(StandardWaterEntity standardWater);
	
	void update(StandardWaterEntity standardWater);
	
	void delete(String id);

	DataByLevelVo getDataByLevel(String level);

	int getCodLevelByValue(String value) ;
	int getPLevelByValue(String value) ;
	int getNHLevelByValue(String value) ;
}
