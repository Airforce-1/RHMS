package com.khidi.manager.monitoringnet.service;

import com.khidi.manager.gis.vo.WaterEcoInfo4GisVo;
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
public interface WaterqualitydataService {
	
	WaterqualitydataEntity queryObject(String id);
	
	List<WaterqualitydataEntity> queryList(Map<String, Object> map);
	List<WaterqualitydataEntity> querytopList(Map<String, Object> map);
	List<WaterqualitydataEntity> queryObjectReleatedTime(String stationId,String ctDate) throws Exception;

	int queryTotal(Map<String, Object> map);
	
	void save(WaterqualitydataEntity waterqualitydata);
	
	void update(WaterqualitydataEntity waterqualitydata);
	
	void delete(String id);

	WaterEcoInfo4GisVo getWQStationInfo(String stationId);


	WaterqualitydataEntity queryObjectfortop(String id);
}
