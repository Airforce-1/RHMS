package com.khidi.manager.event.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.event.dao.AppeventClDao;
import com.khidi.manager.event.entity.AppeventClEntity;
import com.khidi.manager.event.service.AppeventClService;



@Service("appeventClService")
public class AppeventClServiceImpl implements AppeventClService {
	@Autowired
	private AppeventClDao appeventClDao;
	
	@Override
	public AppeventClEntity queryObject(String id){
		return appeventClDao.queryObject(id);
	}
	
	@Override
	public List<AppeventClEntity> queryList(Map<String, Object> map){
	    return appeventClDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return appeventClDao.queryTotal(map);
	}
	
	@Override
	public void save(AppeventClEntity appeventCl){
        appeventCl.setId(UUID.randomUUID().toString());
		appeventClDao.save(appeventCl);
	}
	
	@Override
	public void update(AppeventClEntity appeventCl){
		appeventClDao.update(appeventCl);
	}
	
	@Override
	public void delete(String id){
		appeventClDao.delete(id);
	}
}
