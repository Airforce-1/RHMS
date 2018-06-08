package com.khidi.manager.basicinfo.service.impl;

import com.khidi.manager.basicinfo.dao.CanalDao;
import com.khidi.manager.basicinfo.entity.CanalEntity;
import com.khidi.manager.sys.dao.SysAreaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.basicinfo.dao.PartCanalDao;
import com.khidi.manager.basicinfo.entity.PartCanalEntity;
import com.khidi.manager.basicinfo.service.PartCanalService;



@Service("partCanalService")
public class PartCanalServiceImpl implements PartCanalService {
	@Autowired
	private PartCanalDao partCanalDao;
	@Autowired
	private SysAreaDao sysAreaDao;
	@Autowired
	private CanalDao canalDao;

	@Override
	public PartCanalEntity queryObject(String id){
		return partCanalDao.queryObject(id);
	}
	@Override
	public List<PartCanalEntity> queryListByCanalId(String canalId){
		return partCanalDao.queryListByCanalId(canalId);
	}

	
	@Override
	public List<PartCanalEntity> queryList(Map<String, Object> map){
		List<PartCanalEntity> list = partCanalDao.queryList(map);
		for(int i=0;i<list.size();i++){
			list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());
			list.get(i).setCanalName(canalDao.queryObject(list.get(i).getCanalId()).getName());
		}
		return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return partCanalDao.queryTotal(map);
	}
	
	@Override
	public void save(PartCanalEntity partCanal){
        partCanal.setId(UUID.randomUUID().toString());
		partCanalDao.save(partCanal);
	}
	
	@Override
	public void update(PartCanalEntity partCanal){
		partCanalDao.update(partCanal);
	}
	
	@Override
	public void delete(String id){
		partCanalDao.delete(id);
	}
	

}
