package com.khidi.manager.externaldata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.externaldata.dao.ExternalAttributeDao;
import com.khidi.manager.externaldata.entity.ExternalAttributeEntity;
import com.khidi.manager.externaldata.service.ExternalAttributeService;



@Service("externalAttributeService")
public class ExternalAttributeServiceImpl implements ExternalAttributeService {
	@Autowired
	private ExternalAttributeDao externalAttributeDao;
	
	@Override
	public ExternalAttributeEntity queryObject(String id){
		return externalAttributeDao.queryObject(id);
	}
	
	@Override
	public List<ExternalAttributeEntity> queryList(Map<String, Object> map){
	    return externalAttributeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return externalAttributeDao.queryTotal(map);
	}
	
	@Override
	public void save(ExternalAttributeEntity externalAttribute){
        externalAttribute.setId(UUID.randomUUID().toString());
		externalAttributeDao.save(externalAttribute);
	}
	
	@Override
	public void update(ExternalAttributeEntity externalAttribute){
		externalAttributeDao.update(externalAttribute);
	}
	
	@Override
	public void delete(String id){
		externalAttributeDao.delete(id);
	}
}
