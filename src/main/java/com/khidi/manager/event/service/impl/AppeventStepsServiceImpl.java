package com.khidi.manager.event.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.event.dao.AppeventStepsDao;
import com.khidi.manager.event.entity.AppeventStepsEntity;
import com.khidi.manager.event.service.AppeventStepsService;



@Service("appeventStepsService")
public class AppeventStepsServiceImpl implements AppeventStepsService {
	@Autowired
	private AppeventStepsDao appeventStepsDao;
	
	@Override
	public AppeventStepsEntity queryObject(String id){
		return appeventStepsDao.queryObject(id);
	}
	
	@Override
	public List<AppeventStepsEntity> queryList(Map<String, Object> map){
	    return appeventStepsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return appeventStepsDao.queryTotal(map);
	}
	
	@Override
	public void save(AppeventStepsEntity appeventSteps){
        appeventSteps.setId(UUID.randomUUID().toString());
		appeventStepsDao.save(appeventSteps);
	}
	
	@Override
	public void update(AppeventStepsEntity appeventSteps){
		appeventStepsDao.update(appeventSteps);
	}
	
	@Override
	public void delete(String id){
		appeventStepsDao.delete(id);
	}
}
