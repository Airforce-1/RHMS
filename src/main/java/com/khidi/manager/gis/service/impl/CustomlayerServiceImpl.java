package com.khidi.manager.gis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.gis.dao.CustomlayerDao;
import com.khidi.manager.gis.entity.CustomlayerEntity;
import com.khidi.manager.gis.service.CustomlayerService;



@Service("customlayerService")
public class CustomlayerServiceImpl implements CustomlayerService {
	@Autowired
	private CustomlayerDao customlayerDao;
	
	@Override
	public CustomlayerEntity queryObject(String id){
		return customlayerDao.queryObject(id);
	}
	
	@Override
	public List<CustomlayerEntity> queryList(Map<String, Object> map){
	    return customlayerDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return customlayerDao.queryTotal(map);
	}
	
	@Override
	public void save(CustomlayerEntity customlayer){
        customlayer.setId(UUID.randomUUID().toString());
		customlayerDao.save(customlayer);
	}
	
	@Override
	public void update(CustomlayerEntity customlayer){
		customlayerDao.update(customlayer);
	}
	
	@Override
	public void delete(String id){
		customlayerDao.delete(id);
	}
}
