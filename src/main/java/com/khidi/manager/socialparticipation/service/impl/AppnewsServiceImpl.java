package com.khidi.manager.socialparticipation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.socialparticipation.dao.AppnewsDao;
import com.khidi.manager.socialparticipation.entity.AppnewsEntity;
import com.khidi.manager.socialparticipation.service.AppnewsService;



@Service("appnewsService")
public class AppnewsServiceImpl implements AppnewsService {
	@Autowired
	private AppnewsDao appnewsDao;
	
	@Override
	public AppnewsEntity queryObject(String id){
		return appnewsDao.queryObject(id);
	}
	
	@Override
	public List<AppnewsEntity> queryList(Map<String, Object> map){
	    return appnewsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return appnewsDao.queryTotal(map);
	}
	
	@Override
	public void save(AppnewsEntity appnews){
		appnewsDao.save(appnews);
	}
	
	@Override
	public void update(AppnewsEntity appnews){
		appnewsDao.update(appnews);
	}
	
	@Override
	public void updateState(AppnewsEntity appnews){
		appnewsDao.updateState(appnews);
	}
	
	@Override
	public void delete(String id){
		appnewsDao.delete(id);
	}
}
