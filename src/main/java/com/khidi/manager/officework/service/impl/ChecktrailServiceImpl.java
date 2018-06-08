package com.khidi.manager.officework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.officework.dao.ChecktrailDao;
import com.khidi.manager.officework.entity.ChecktrailEntity;
import com.khidi.manager.officework.service.ChecktrailService;



@Service("checktrailService")
public class ChecktrailServiceImpl implements ChecktrailService {
	@Autowired
	private ChecktrailDao checktrailDao;
	
	@Override
	public ChecktrailEntity queryObject(String id){
		return checktrailDao.queryObject(id);
	}
	
	@Override
	public List<ChecktrailEntity> queryList(Map<String, Object> map){
	    return checktrailDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return checktrailDao.queryTotal(map);
	}
	
	@Override
	public void save(ChecktrailEntity checktrail){
        checktrail.setId(UUID.randomUUID().toString());
		checktrailDao.save(checktrail);
	}
	
	@Override
	public void update(ChecktrailEntity checktrail){
		checktrailDao.update(checktrail);
	}
	
	@Override
	public void delete(String id){
		checktrailDao.delete(id);
	}
}
