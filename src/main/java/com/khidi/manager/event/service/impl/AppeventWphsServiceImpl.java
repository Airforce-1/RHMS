package com.khidi.manager.event.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.event.dao.AppeventWphsDao;
import com.khidi.manager.event.entity.AppeventWphsEntity;
import com.khidi.manager.event.service.AppeventWphsService;



@Service("appeventWphsService")
public class AppeventWphsServiceImpl implements AppeventWphsService {
	@Autowired
	private AppeventWphsDao appeventWphsDao;
	
	@Override
	public AppeventWphsEntity queryObject(String id){
		return appeventWphsDao.queryObject(id);
	}
	
	@Override
	public List<AppeventWphsEntity> queryList(Map<String, Object> map){
	    return appeventWphsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return appeventWphsDao.queryTotal(map);
	}
	
	@Override
	public void save(AppeventWphsEntity appeventWphs){
        appeventWphs.setId(UUID.randomUUID().toString());
		appeventWphsDao.save(appeventWphs);
	}
	
	@Override
	public void update(AppeventWphsEntity appeventWphs){
		appeventWphsDao.update(appeventWphs);
	}
	
	@Override
	public void delete(String id){
		appeventWphsDao.delete(id);
	}
}
