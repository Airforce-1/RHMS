package com.khidi.manager.event.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.event.dao.AppeventWpDao;
import com.khidi.manager.event.entity.AppeventWpEntity;
import com.khidi.manager.event.service.AppeventWpService;



@Service("appeventWpService")
public class AppeventWpServiceImpl implements AppeventWpService {
	@Autowired
	private AppeventWpDao appeventWpDao;
	
	@Override
	public AppeventWpEntity queryObject(String id){
		return appeventWpDao.queryObject(id);
	}
	
	@Override
	public List<AppeventWpEntity> queryList(Map<String, Object> map){
	    return appeventWpDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return appeventWpDao.queryTotal(map);
	}
	
	@Override
	public void save(AppeventWpEntity appeventWp){
        appeventWp.setId(UUID.randomUUID().toString());
		appeventWpDao.save(appeventWp);
	}
	
	@Override
	public void update(AppeventWpEntity appeventWp){
		appeventWpDao.update(appeventWp);
	}
	
	@Override
	public void delete(String id){
		appeventWpDao.delete(id);
	}
}
