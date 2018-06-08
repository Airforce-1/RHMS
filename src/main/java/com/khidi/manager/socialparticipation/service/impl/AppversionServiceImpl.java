package com.khidi.manager.socialparticipation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.socialparticipation.dao.AppversionDao;
import com.khidi.manager.socialparticipation.entity.AppversionEntity;
import com.khidi.manager.socialparticipation.service.AppversionService;



@Service("appversionService")
public class AppversionServiceImpl implements AppversionService {
	@Autowired
	private AppversionDao appversionDao;
	
	@Override
	public AppversionEntity queryObject(String id){
		return appversionDao.queryObject(id);
	}
	
	@Override
	public List<AppversionEntity> queryList(Map<String, Object> map){
	    return appversionDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return appversionDao.queryTotal(map);
	}
	
	@Override
	public void save(AppversionEntity appversion){
		appversionDao.save(appversion);
	}
	
	@Override
	public void update(AppversionEntity appversion){
		appversionDao.update(appversion);
	}
	
	@Override
	public void delete(String id){
		appversionDao.delete(id);
	}
}
