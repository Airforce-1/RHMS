package com.khidi.manager.externaldata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.externaldata.dao.EcoCompensationDao;
import com.khidi.manager.externaldata.entity.EcoCompensationEntity;
import com.khidi.manager.externaldata.service.EcoCompensationService;



@Service("ecoCompensationService")
public class EcoCompensationServiceImpl implements EcoCompensationService {
	@Autowired
	private EcoCompensationDao ecoCompensationDao;
	
	@Override
	public EcoCompensationEntity queryObject(String id){
		return ecoCompensationDao.queryObject(id);
	}
	
	@Override
	public List<EcoCompensationEntity> queryList(Map<String, Object> map){
	    return ecoCompensationDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return ecoCompensationDao.queryTotal(map);
	}
	
	@Override
	public void save(EcoCompensationEntity ecoCompensation){
		ecoCompensationDao.save(ecoCompensation);
	}
	
	@Override
	public void update(EcoCompensationEntity ecoCompensation){
		ecoCompensationDao.update(ecoCompensation);
	}
	
	@Override
	public void delete(String id){
		ecoCompensationDao.delete(id);
	}
	@Override
	public List<EcoCompensationEntity> queryListByStationId(String stationId){
		return ecoCompensationDao.queryListByStationId(stationId);
	}
}
