package com.khidi.manager.monitoringnet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.monitoringnet.dao.DataAirDao;
import com.khidi.manager.monitoringnet.entity.DataAirEntity;
import com.khidi.manager.monitoringnet.service.DataAirService;



@Service("dataAirService")
public class DataAirServiceImpl implements DataAirService {
	@Autowired
	private DataAirDao dataAirDao;



	public DataAirEntity getAir4Gis(String stationId){
		return dataAirDao.getAir4Gis(stationId);
	}
	
	@Override
	public DataAirEntity queryObject(String id){
		return dataAirDao.queryObject(id);
	}
	
	@Override
	public List<DataAirEntity> queryList(Map<String, Object> map){
	    return dataAirDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return dataAirDao.queryTotal(map);
	}
	
	@Override
	public void save(DataAirEntity dataAir){
        dataAir.setId(UUID.randomUUID().toString());
		dataAirDao.save(dataAir);
	}
	
	@Override
	public void update(DataAirEntity dataAir){
		dataAirDao.update(dataAir);
	}
	
	@Override
	public void delete(String id){
		dataAirDao.delete(id);
	}
}
