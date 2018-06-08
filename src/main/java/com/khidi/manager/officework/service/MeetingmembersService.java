package com.khidi.manager.officework.service;

import com.khidi.manager.officework.entity.MeetingmembersEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-26 09:39:11
 */
public interface MeetingmembersService {
	
	MeetingmembersEntity queryObject(String id);
	
	List<MeetingmembersEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MeetingmembersEntity meetingmembers);
	
	void update(MeetingmembersEntity meetingmembers);
	
	void delete(String id);
}
