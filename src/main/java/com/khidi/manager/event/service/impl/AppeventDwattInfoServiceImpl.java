package com.khidi.manager.event.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

import com.khidi.manager.event.dao.AppeventDwattInfoDao;
import com.khidi.manager.event.entity.AppeventDwattInfoEntity;
import com.khidi.manager.event.service.AppeventDwattInfoService;



@Service("appeventDwattInfoService")
public class AppeventDwattInfoServiceImpl implements AppeventDwattInfoService {
	@Autowired
	private AppeventDwattInfoDao appeventDwattInfoDao;
	
	@Override
	public AppeventDwattInfoEntity queryObject(String id){
		return appeventDwattInfoDao.queryObject(id);
	}
	
	@Override
	public List<AppeventDwattInfoEntity> queryList(Map<String, Object> map){
	    return appeventDwattInfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return appeventDwattInfoDao.queryTotal(map);
	}
	
	@Override
	public void save(AppeventDwattInfoEntity appeventDwattInfo){
		appeventDwattInfoDao.save(appeventDwattInfo);
	}
	
	@Override
	public void update(AppeventDwattInfoEntity appeventDwattInfo){
		appeventDwattInfoDao.update(appeventDwattInfo);
	}
	
	@Override
	public void delete(String id){
		appeventDwattInfoDao.delete(id);
	}
}
