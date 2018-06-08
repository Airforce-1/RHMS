package com.khidi.manager.officework.service;

import java.util.List;
import java.util.Map;

import com.khidi.manager.officework.entity.MeetingMEntity;

/**
 * ${comments}
 * 
 * @author wangshunbo
 * @email 405877884@qq.com
 * @date 2017-12-16 13:52:08
 */
public interface MeetingMService {
	
	MeetingMEntity queryObject(String id);
	
	List<MeetingMEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MeetingMEntity meetingM);
	
	void update(MeetingMEntity meetingM);
	
	void delete(String id);
}
