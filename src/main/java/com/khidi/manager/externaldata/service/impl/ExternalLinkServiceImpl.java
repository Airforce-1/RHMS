package com.khidi.manager.externaldata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.externaldata.dao.ExternalLinkDao;
import com.khidi.manager.externaldata.entity.ExternalLinkEntity;
import com.khidi.manager.externaldata.service.ExternalLinkService;



@Service("externalLinkService")
public class ExternalLinkServiceImpl implements ExternalLinkService {
	@Autowired
	private ExternalLinkDao externalLinkDao;
	
	@Override
	public ExternalLinkEntity queryObject(String id){
		return externalLinkDao.queryObject(id);
	}
	
	@Override
	public List<ExternalLinkEntity> queryList(Map<String, Object> map){
	    return externalLinkDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return externalLinkDao.queryTotal(map);
	}
	
	@Override
	public void save(ExternalLinkEntity externalLink){
        externalLink.setId(UUID.randomUUID().toString());
		externalLinkDao.save(externalLink);
	}
	
	@Override
	public void update(ExternalLinkEntity externalLink){
		externalLinkDao.update(externalLink);
	}
	
	@Override
	public void delete(String id){
		externalLinkDao.delete(id);
	}
}
