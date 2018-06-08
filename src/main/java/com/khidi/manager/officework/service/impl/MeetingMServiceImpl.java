package com.khidi.manager.officework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khidi.manager.officework.dao.MeetingMDao;
import com.khidi.manager.officework.entity.MeetingMEntity;
import com.khidi.manager.officework.service.MeetingMService;

import java.util.UUID;
import java.util.List;
import java.util.Map;




@Service("meetingMService")
public class MeetingMServiceImpl implements MeetingMService {
	@Autowired
	private MeetingMDao meetingMDao;
	
	@Override
	public MeetingMEntity queryObject(String id){
		return meetingMDao.queryObject(id);
	}
	
	@Override
	public List<MeetingMEntity> queryList(Map<String, Object> map){
	    return meetingMDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return meetingMDao.queryTotal(map);
	}
	
	@Override
	public void save(MeetingMEntity meetingM){
		meetingMDao.save(meetingM);
	}
	
	@Override
	public void update(MeetingMEntity meetingM){
		meetingMDao.update(meetingM);
	}
	
	@Override
	public void delete(String id){
		meetingMDao.delete(id);
	}
}
