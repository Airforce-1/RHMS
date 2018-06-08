package com.khidi.manager.basicinfo.service.impl;

import com.khidi.manager.basicinfo.dao.RiverDao;
import com.khidi.manager.sys.dao.SysAreaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.basicinfo.dao.PartRiverDao;
import com.khidi.manager.basicinfo.entity.PartRiverEntity;
import com.khidi.manager.basicinfo.service.PartRiverService;



@Service("partRiverService")
public class PartRiverServiceImpl implements PartRiverService {
	@Autowired
	private PartRiverDao partRiverDao;
	@Autowired
	private RiverDao riverDao;
	@Autowired
	private SysAreaDao sysAreaDao;
	
	@Override
	public PartRiverEntity queryObject(String id){
		return partRiverDao.queryObject(id);
	}

	@Override
	public List<PartRiverEntity> queryListByRiverId(String riverId){
		return partRiverDao.queryListByRiverId(riverId);
	}
	
	@Override
	public List<PartRiverEntity> queryList(Map<String, Object> map){
		List<PartRiverEntity> list = partRiverDao.queryList(map);
		for(int i=0;i<list.size();i++){
			list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());
			list.get(i).setRiverName(riverDao.queryObject(list.get(i).getRiverId()).getName());
		}
		return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return partRiverDao.queryTotal(map);
	}
	
	@Override
	public void save(PartRiverEntity partRiver){
        partRiver.setId(UUID.randomUUID().toString());
		partRiverDao.save(partRiver);
	}
	
	@Override
	public void update(PartRiverEntity partRiver){
		partRiverDao.update(partRiver);
	}
	
	@Override
	public void delete(String id){
		partRiverDao.delete(id);
	}
	

}
