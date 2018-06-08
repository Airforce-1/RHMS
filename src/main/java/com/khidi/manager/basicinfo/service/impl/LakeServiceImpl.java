package com.khidi.manager.basicinfo.service.impl;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.basicinfo.entity.CanalEntity;
import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.dao.SysDictDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.basicinfo.dao.LakeDao;
import com.khidi.manager.basicinfo.entity.LakeEntity;
import com.khidi.manager.basicinfo.service.LakeService;



@Service("lakeService")
public class LakeServiceImpl implements LakeService {
	@Autowired
	private LakeDao lakeDao;
	@Autowired
	private SysAreaDao sysAreaDao;
	@Autowired
	private SysDictDao sysDictDao;
	
	@Override
	public LakeEntity queryObject(String id){
		return lakeDao.queryObject(id);
	}
	
	@Override
	public List<LakeEntity> queryList(Map<String, Object> map){
		List<LakeEntity> list = lakeDao.queryList(map);
		for(int i=0;i<list.size();i++){
			list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());

			Map<String, Object> querymap = new HashMap();
			if (StringUtil.isEmpty(list.get(i).getLakeType())){
				list.get(i).setLakeTypeName(null);
			}else{
				querymap.put("dictValue",list.get(i).getLakeType());
				querymap.put("dictType","咸淡水");
				list.get(i).setLakeTypeName(sysDictDao.queryObject(querymap).getDictName());
			}
		}
	    return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return lakeDao.queryTotal(map);
	}
	
	@Override
	public void save(LakeEntity lake){
        lake.setId(UUID.randomUUID().toString());
		lakeDao.save(lake);
	}
	
	@Override
	public void update(LakeEntity lake){
		lakeDao.update(lake);
	}
	
	@Override
	public void delete(String id){
		lakeDao.delete(id);
	}
	

}
