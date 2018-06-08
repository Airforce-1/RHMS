package com.khidi.manager.maintask.service.impl;

import com.khidi.common.utils.CurrentSession;
import com.khidi.manager.maintask.dao.StTargetdetailDao;
import com.khidi.manager.maintask.entity.StTargetdetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.maintask.dao.StTargetdetailTransmitDao;
import com.khidi.manager.maintask.entity.StTargetdetailTransmitEntity;
import com.khidi.manager.maintask.service.StTargetdetailTransmitService;



@Service("stTargetdetailTransmitService")
public class StTargetdetailTransmitServiceImpl implements StTargetdetailTransmitService {
	@Autowired
	private StTargetdetailTransmitDao stTargetdetailTransmitDao;
	@Autowired
	private StTargetdetailDao stTargetdetailDao;
	
	@Override
	public StTargetdetailTransmitEntity queryObject(String id){
		return stTargetdetailTransmitDao.queryObject(id);
	}
	
	@Override
	public List<StTargetdetailTransmitEntity> queryList(Map<String, Object> map){
	    return stTargetdetailTransmitDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return stTargetdetailTransmitDao.queryTotal(map);
	}
	
	@Override
	public void save(StTargetdetailTransmitEntity stTargetdetailTransmit){
        stTargetdetailTransmit.setId(UUID.randomUUID().toString());
		stTargetdetailTransmit.setTransmitDeptid(CurrentSession.GetDeptId());
		stTargetdetailTransmit.setTransmitUserid(CurrentSession.GetUserId());
		stTargetdetailTransmitDao.save(stTargetdetailTransmit);

		StTargetdetailEntity entity = stTargetdetailDao.queryObject(stTargetdetailTransmit.getTargetdetailid());
		entity.setTodeptid(stTargetdetailTransmit.getTodeptid());
		entity.setTransmitDeptid(stTargetdetailTransmit.getTransmitDeptid());
		entity.setTransmituserid(stTargetdetailTransmit.getTransmitUserid());
		entity.setTransmittime(new Date());
		stTargetdetailDao.update(entity);
	}
	
	@Override
	public void update(StTargetdetailTransmitEntity stTargetdetailTransmit){
		stTargetdetailTransmitDao.update(stTargetdetailTransmit);
	}
	
	@Override
	public void delete(String id){
		stTargetdetailTransmitDao.delete(id);
	}
}
