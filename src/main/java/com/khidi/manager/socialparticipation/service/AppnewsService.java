package com.khidi.manager.socialparticipation.service;

import com.khidi.manager.socialparticipation.entity.AppnewsEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-08 15:16:20
 */
public interface AppnewsService {
	
	AppnewsEntity queryObject(String id);
	
	List<AppnewsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AppnewsEntity appnews);
	
	void update(AppnewsEntity appnews);
	
	void updateState(AppnewsEntity appnews);
	
	void delete(String id);
}
