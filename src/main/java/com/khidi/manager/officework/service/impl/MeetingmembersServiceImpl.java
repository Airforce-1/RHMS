package com.khidi.manager.officework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.officework.dao.MeetingmembersDao;
import com.khidi.manager.officework.entity.MeetingmembersEntity;
import com.khidi.manager.officework.service.MeetingmembersService;



@Service("meetingmembersService")
public class MeetingmembersServiceImpl implements MeetingmembersService {
	@Autowired
	private MeetingmembersDao meetingmembersDao;
	
	@Override
	public MeetingmembersEntity queryObject(String id){
		return meetingmembersDao.queryObject(id);
	}
	
	@Override
	public List<MeetingmembersEntity> queryList(Map<String, Object> map){
	    return meetingmembersDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return meetingmembersDao.queryTotal(map);
	}
	
	@Override
	public void save(MeetingmembersEntity meetingmembers){
//        meetingmembers.setId(UUID.randomUUID().toString());
		meetingmembersDao.save(meetingmembers);
	}
	
	@Override
	public void update(MeetingmembersEntity meetingmembers){
		meetingmembersDao.update(meetingmembers);
	}
	
	@Override
	public void delete(String id){
		meetingmembersDao.delete(id);
	}
}
