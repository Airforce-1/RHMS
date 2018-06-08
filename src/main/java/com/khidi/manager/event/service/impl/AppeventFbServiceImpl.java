package com.khidi.manager.event.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.event.dao.AppeventFbDao;
import com.khidi.manager.event.entity.AppeventFbEntity;
import com.khidi.manager.event.service.AppeventFbService;



@Service("appeventFbService")
public class AppeventFbServiceImpl implements AppeventFbService {
	@Autowired
	private AppeventFbDao appeventFbDao;
	
	@Override
	public AppeventFbEntity queryObject(String id){
		return appeventFbDao.queryObject(id);
	}
	
	@Override
	public List<AppeventFbEntity> queryList(Map<String, Object> map){
	    return appeventFbDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return appeventFbDao.queryTotal(map);
	}
	
	@Override
	public void save(AppeventFbEntity appeventFb){
        appeventFb.setId(UUID.randomUUID().toString());
		appeventFbDao.save(appeventFb);
	}
	
	@Override
	public void update(AppeventFbEntity appeventFb){
		appeventFbDao.update(appeventFb);
	}
	
	@Override
	public void delete(String id){
		appeventFbDao.delete(id);
	}
}
