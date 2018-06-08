package com.khidi.manager.officework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.officework.dao.MeetingattachDao;
import com.khidi.manager.officework.entity.MeetingattachEntity;
import com.khidi.manager.officework.service.MeetingattachService;



@Service("meetingattachService")
public class MeetingattachServiceImpl implements MeetingattachService {
	@Autowired
	private MeetingattachDao meetingattachDao;
	
	@Override
	public MeetingattachEntity queryObject(String id){
		return meetingattachDao.queryObject(id);
	}
	
	@Override
	public List<MeetingattachEntity> queryList(Map<String, Object> map){
	    return meetingattachDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return meetingattachDao.queryTotal(map);
	}
	
	@Override
	public void save(MeetingattachEntity meetingattach){
		meetingattachDao.save(meetingattach);
	}
	
	@Override
	public void update(MeetingattachEntity meetingattach){
		meetingattachDao.update(meetingattach);
	}
	
	@Override
	public void delete(String id){
		meetingattachDao.delete(id);
	}
}
