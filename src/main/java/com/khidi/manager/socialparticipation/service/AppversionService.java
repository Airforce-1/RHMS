package com.khidi.manager.socialparticipation.service;

import com.khidi.manager.socialparticipation.entity.AppversionEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-08 15:06:21
 */
public interface AppversionService {
	
	AppversionEntity queryObject(String id);
	
	List<AppversionEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AppversionEntity appversion);
	
	void update(AppversionEntity appversion);
	
	void delete(String id);
}
