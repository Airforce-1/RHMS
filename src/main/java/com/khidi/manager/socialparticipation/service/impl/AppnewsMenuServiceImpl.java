package com.khidi.manager.socialparticipation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.socialparticipation.dao.AppnewsMenuDao;
import com.khidi.manager.socialparticipation.entity.AppnewsMenuEntity;
import com.khidi.manager.socialparticipation.service.AppnewsMenuService;



@Service("appnewsMenuService")
public class AppnewsMenuServiceImpl implements AppnewsMenuService {
	@Autowired
	private AppnewsMenuDao appnewsMenuDao;
	
	@Override
	public AppnewsMenuEntity queryObject(String id){
		return appnewsMenuDao.queryObject(id);
	}
	
	@Override
	public List<AppnewsMenuEntity> queryList(Map<String, Object> map){
	    return appnewsMenuDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return appnewsMenuDao.queryTotal(map);
	}
	
	@Override
	public void save(AppnewsMenuEntity appnewsMenu){
		appnewsMenuDao.save(appnewsMenu);
	}
	
	@Override
	public void update(AppnewsMenuEntity appnewsMenu){
		appnewsMenuDao.update(appnewsMenu);
	}
	
	@Override
	public void delete(String id){
		appnewsMenuDao.delete(id);
	}
}
