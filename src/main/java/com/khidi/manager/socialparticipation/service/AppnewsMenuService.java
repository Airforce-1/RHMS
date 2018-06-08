package com.khidi.manager.socialparticipation.service;

import com.khidi.manager.socialparticipation.entity.AppnewsMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-12 15:29:14
 */
public interface AppnewsMenuService {
	
	AppnewsMenuEntity queryObject(String id);
	
	List<AppnewsMenuEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AppnewsMenuEntity appnewsMenu);
	
	void update(AppnewsMenuEntity appnewsMenu);
	
	void delete(String id);
}
