package com.khidi.manager.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.sys.dao.SysLayertreeDao;
import com.khidi.manager.sys.entity.SysLayertreeEntity;
import com.khidi.manager.sys.service.SysLayertreeService;



@Service("sysLayertreeService")
public class SysLayertreeServiceImpl implements SysLayertreeService {
	@Autowired
	private SysLayertreeDao sysLayertreeDao;
	
	@Override
	public SysLayertreeEntity queryObject(String id){
		return sysLayertreeDao.queryObject(id);
	}

	@Override
	public String queryParentIdIsCorrent(SysLayertreeEntity entity){
		return sysLayertreeDao.queryParentIdIsCorrent(entity);
	}
	
	@Override
	public List<SysLayertreeEntity> queryList(Map<String, Object> map){
	    return sysLayertreeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysLayertreeDao.queryTotal(map);
	}
	
	@Override
	public void save(SysLayertreeEntity sysLayertree){
        sysLayertree.setId(UUID.randomUUID().toString());
		sysLayertreeDao.save(sysLayertree);
	}
	
	@Override
	public void update(SysLayertreeEntity sysLayertree){
		sysLayertreeDao.update(sysLayertree);
	}
	
	@Override
	public void delete(String id){
		sysLayertreeDao.delete(id);
	}


	@Override
	public int queryCountbyParentId(String parentId){
		return sysLayertreeDao.queryCountbyParentId(parentId);
	}
	@Override
	public List<SysLayertreeEntity> querySonList(String parentId){
		return sysLayertreeDao.querySonList(parentId);
	}
}
