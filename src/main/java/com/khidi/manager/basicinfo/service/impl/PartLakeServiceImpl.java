package com.khidi.manager.basicinfo.service.impl;

import com.khidi.manager.basicinfo.dao.LakeDao;
import com.khidi.manager.basicinfo.entity.LakeEntity;
import com.khidi.manager.sys.dao.SysAreaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.basicinfo.dao.PartLakeDao;
import com.khidi.manager.basicinfo.entity.PartLakeEntity;
import com.khidi.manager.basicinfo.service.PartLakeService;



@Service("partLakeService")
public class PartLakeServiceImpl implements PartLakeService {
	@Autowired
	private PartLakeDao partLakeDao;
	@Autowired
	private LakeDao lakeDao;
	@Autowired
	private SysAreaDao sysAreaDao;
	
	@Override
	public PartLakeEntity queryObject(String id){
		return partLakeDao.queryObject(id);
	}


	@Override
	public List<PartLakeEntity> queryListByLakeId(String lakeId){
		return partLakeDao.queryListByLakeId(lakeId);
	}
	
	@Override
	public List<PartLakeEntity> queryList(Map<String, Object> map){

		List<PartLakeEntity> list = partLakeDao.queryList(map);
		for(int i=0;i<list.size();i++){
			list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());
			list.get(i).setLakeName(lakeDao.queryObject(list.get(i).getLakeId()).getName());
		}
		return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return partLakeDao.queryTotal(map);
	}
	
	@Override
	public void save(PartLakeEntity partLake){
        partLake.setId(UUID.randomUUID().toString());
		partLakeDao.save(partLake);
	}
	
	@Override
	public void update(PartLakeEntity partLake){
		partLakeDao.update(partLake);
	}
	
	@Override
	public void delete(String id){
		partLakeDao.delete(id);
	}
	

}
