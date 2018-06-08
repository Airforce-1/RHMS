package com.khidi.manager.basicinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.basicinfo.dao.ResourceAirStationDao;
import com.khidi.manager.basicinfo.entity.ResourceAirStationEntity;
import com.khidi.manager.basicinfo.service.ResourceAirStationService;



@Service("resourceAirStationService")
public class ResourceAirStationServiceImpl implements ResourceAirStationService {
	@Autowired
	private ResourceAirStationDao resourceAirStationDao;
	
	@Override
	public ResourceAirStationEntity queryObject(String id){
		return resourceAirStationDao.queryObject(id);
	}
	
	@Override
	public List<ResourceAirStationEntity> queryList(Map<String, Object> map){
	    return resourceAirStationDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resourceAirStationDao.queryTotal(map);
	}
	
	@Override
	public void save(ResourceAirStationEntity resourceAirStation){
        resourceAirStation.setId(UUID.randomUUID().toString());
		resourceAirStationDao.save(resourceAirStation);
	}
	
	@Override
	public void update(ResourceAirStationEntity resourceAirStation){
		resourceAirStationDao.update(resourceAirStation);
	}
	
	@Override
	public void delete(String id){
		resourceAirStationDao.delete(id);
	}
}
