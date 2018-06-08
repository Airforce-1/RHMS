package com.khidi.manager.externaldata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.externaldata.dao.ExternalWqDataDao;
import com.khidi.manager.externaldata.entity.ExternalWqDataEntity;
import com.khidi.manager.externaldata.service.ExternalWqDataService;



@Service("externalWqDataService")
public class ExternalWqDataServiceImpl implements ExternalWqDataService {
	@Autowired
	private ExternalWqDataDao externalWqDataDao;
	
	@Override
	public ExternalWqDataEntity queryObject(String id){
		return externalWqDataDao.queryObject(id);
	}
	
	@Override
	public List<ExternalWqDataEntity> queryList(Map<String, Object> map){
	    return externalWqDataDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return externalWqDataDao.queryTotal(map);
	}
	
	@Override
	public void save(ExternalWqDataEntity externalWqData){
		externalWqDataDao.save(externalWqData);
	}
	
	@Override
	public void update(ExternalWqDataEntity externalWqData){
		externalWqDataDao.update(externalWqData);
	}
	
	@Override
	public void delete(String id){
		externalWqDataDao.delete(id);
	}
}
