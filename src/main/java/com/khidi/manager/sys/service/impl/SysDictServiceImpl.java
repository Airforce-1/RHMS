package com.khidi.manager.sys.service.impl;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.sys.dao.SysDictDao;
import com.khidi.manager.sys.entity.SysDictEntity;
import com.khidi.manager.sys.service.SysDictService;



@Service("sysDictService")
public class SysDictServiceImpl implements SysDictService {
	@Autowired
	private SysDictDao sysDictDao;

	@Override
	public String typevalue4name(String type,String value){
		Map<String,Object> map = new HashedMap();
		map.put("dictValue",value);
		map.put("dictType",type);
		return this.queryObject(map).getDictName();
	}


	@Override
	public SysDictEntity queryObject(String id){
		return sysDictDao.queryObjectbyId(id);
	}
	@Override
	public List<SysDictEntity> queryList(Map<String, Object> map){
	    return sysDictDao.queryList(map);
	}
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysDictDao.queryTotal(map);
	}
	@Override
	public void save(SysDictEntity sysDict){
        sysDict.setId(UUID.randomUUID().toString());
		sysDictDao.save(sysDict);
	}
	@Override
	public void update(SysDictEntity sysDict){
		sysDictDao.update(sysDict);
	}
	@Override
	public void delete(String id){
		sysDictDao.delete(id);
	}
	@Override
	public SysDictEntity queryObject(Map<String, Object> map){
		return sysDictDao.queryObject(map);
	}
}
