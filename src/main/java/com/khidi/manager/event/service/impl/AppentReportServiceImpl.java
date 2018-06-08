package com.khidi.manager.event.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.event.dao.AppentReportDao;
import com.khidi.manager.event.entity.AppentReportEntity;
import com.khidi.manager.event.service.AppentReportService;



@Service("appentReportService")
public class AppentReportServiceImpl implements AppentReportService {
	@Autowired
	private AppentReportDao appentReportDao;
	
	private String id;
	
	@Override
	public AppentReportEntity queryObject(String id){
		return appentReportDao.queryObject(id);
	}
	
	@Override
	public List<AppentReportEntity> queryList(Map<String, Object> map){
	    return appentReportDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return appentReportDao.queryTotal(map);
	}
	
	@Override
	public void save(AppentReportEntity appentReport){
		id=getAppentReportId();
		if(StringUtils.isBlank(appentReport.getId())){
			appentReport.setId(id);			
		}
		appentReportDao.save(appentReport);
	}
	
	//获取id
	public String getAppentReportId(){
		return UUID.randomUUID().toString();
	}
	
	@Override
	public void update(AppentReportEntity appentReport){
		appentReportDao.update(appentReport);
	}
	
	@Override
	public void delete(String id){
		appentReportDao.delete(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
