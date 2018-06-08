package com.khidi.manager.socialparticipation.service;

import com.khidi.manager.socialparticipation.entity.AppnewsviewimgEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-25 13:40:37
 */
public interface AppnewsviewimgService {
	
	AppnewsviewimgEntity queryObject(String id);
	
	List<AppnewsviewimgEntity> queryList(Map<String, Object> map);
	
	List<AppnewsviewimgEntity> getAttachByNewsId(String newsId);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AppnewsviewimgEntity appnewsviewimg);
	
	void update(AppnewsviewimgEntity appnewsviewimg);
	
	void delete(String id);
}
