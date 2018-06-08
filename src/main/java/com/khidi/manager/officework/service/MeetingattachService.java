package com.khidi.manager.officework.service;

import com.khidi.manager.officework.entity.MeetingattachEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-26 09:39:11
 */
public interface MeetingattachService {
	
	MeetingattachEntity queryObject(String id);
	
	List<MeetingattachEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MeetingattachEntity meetingattach);
	
	void update(MeetingattachEntity meetingattach);
	
	void delete(String id);
}
