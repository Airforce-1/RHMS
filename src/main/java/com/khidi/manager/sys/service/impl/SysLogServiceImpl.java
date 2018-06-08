package com.khidi.manager.sys.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khidi.manager.sys.dao.SysLogDao;
import com.khidi.manager.sys.entity.SysLogEntity;
import com.khidi.manager.sys.service.SysLogService;


@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
	@Autowired
	private SysLogDao sysLogDao;
	
	@Override
	public SysLogEntity queryObject(String id){
		return sysLogDao.queryObject(id);
	}
	
	@Override
	public List<SysLogEntity> queryList(Map<String, Object> map){
		return sysLogDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysLogDao.queryTotal(map);
	}
	
	@Override
	public void save(SysLogEntity sysLog){
		sysLog.setId(UUID.randomUUID().toString());
		sysLogDao.save(sysLog);
	}
	
	@Override
	public void delete(String id){
		sysLogDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		sysLogDao.deleteBatch(ids);
	}
	
}
