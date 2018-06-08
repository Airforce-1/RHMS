package com.khidi.manager.event.service;

import com.khidi.manager.event.entity.AppentReportEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-29 15:22:47
 */
public interface AppentReportService {
	
	AppentReportEntity queryObject(String id);
	
	List<AppentReportEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AppentReportEntity appentReport);
	
	void update(AppentReportEntity appentReport);
	
	void delete(String id);
}
