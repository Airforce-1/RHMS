package com.khidi.manager.event.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.event.dao.AppeventAttinfoDao;
import com.khidi.manager.event.entity.AppeventAttinfoEntity;
import com.khidi.manager.event.service.AppeventAttinfoService;



@Service("appeventAttinfoService")
public class AppeventAttinfoServiceImpl implements AppeventAttinfoService {
	@Autowired
	private AppeventAttinfoDao appeventAttinfoDao;
	
	@Override
	public AppeventAttinfoEntity queryObject(String id){
		return appeventAttinfoDao.queryObject(id);
	}
	
	@Override
	public List<AppeventAttinfoEntity> queryList(Map<String, Object> map){
	    return appeventAttinfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return appeventAttinfoDao.queryTotal(map);
	}
	
	@Override
	public void save(AppeventAttinfoEntity appeventAttinfo){
        appeventAttinfo.setId(UUID.randomUUID().toString());
		appeventAttinfoDao.save(appeventAttinfo);
	}
	
	@Override
	public void update(AppeventAttinfoEntity appeventAttinfo){
		appeventAttinfoDao.update(appeventAttinfo);
	}
	
	@Override
	public void delete(String id){
		appeventAttinfoDao.delete(id);
	}
}
