package com.khidi.manager.maintask.service.impl;

import com.khidi.manager.maintask.dao.StTaskdetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.maintask.dao.StSubtaskprogressDao;
import com.khidi.manager.maintask.entity.StSubtaskprogressEntity;
import com.khidi.manager.maintask.service.StSubtaskprogressService;



@Service("stSubtaskprogressService")
public class StSubtaskprogressServiceImpl implements StSubtaskprogressService {
	@Autowired
	private StSubtaskprogressDao stSubtaskprogressDao;
	@Autowired
	private StTaskdetailDao stTaskdetailDao;
	
	@Override
	public StSubtaskprogressEntity queryObject(String id){
		return stSubtaskprogressDao.queryObject(id);
	}
	
	@Override
	public List<StSubtaskprogressEntity> queryList(Map<String, Object> map){
	    return stSubtaskprogressDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return stSubtaskprogressDao.queryTotal(map);
	}
	
	@Override
	public void save(StSubtaskprogressEntity stSubtaskprogress){
        stSubtaskprogress.setId(UUID.randomUUID().toString());
		stSubtaskprogressDao.save(stSubtaskprogress);
	}
	
	@Override
	public void update(StSubtaskprogressEntity stSubtaskprogress){
		stSubtaskprogressDao.update(stSubtaskprogress);
	}
	
	@Override
	public void delete(String id){
		stSubtaskprogressDao.delete(id);
	}
}
