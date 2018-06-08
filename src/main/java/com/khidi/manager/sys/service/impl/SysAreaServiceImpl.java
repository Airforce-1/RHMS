package com.khidi.manager.sys.service.impl;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.entity.SysAreaEntity;
import com.khidi.manager.sys.service.SysAreaService;
import com.qiniu.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("sysAreaService")
public class SysAreaServiceImpl implements SysAreaService {
	@Autowired
	private SysAreaDao sysAreaDao;
	@Override
	public SysAreaEntity queryObject(String areaId){
		return sysAreaDao.queryObject(areaId);
	}
	@Override
	public List<SysAreaEntity> queryList(Map<String, Object> map){
		List<SysAreaEntity> list= sysAreaDao.queryList(map);
		return list;
	}
	@Transactional
	@Override
	public SysAreaEntity save(SysAreaEntity sysArea){
		sysArea.setAreaId(UUID.randomUUID().toString());
		sysArea.setDelFlag(0);
		sysArea.setOpen(false);
		if(!sysAreaDao.queryObject(sysArea.getParentId()).getOpen()){
			SysAreaEntity sysAreaEntity= sysAreaDao.queryObject(sysArea.getParentId());
			sysAreaEntity.setOpen(true);
			sysAreaDao.update(sysAreaEntity);
		}
		sysAreaDao.save(sysArea);
		return sysArea;
	}
	@Override
	public List<SysAreaEntity> queryExistsByParentId(String parentId){
		return sysAreaDao.queryExistsByParentId(parentId);
	}
	@Transactional
	@Override
	public SysAreaEntity update(SysAreaEntity sysArea){
		sysAreaDao.update(sysArea);
		if(queryAreaIdList(sysArea.getParentId()).size()==0){
			SysAreaEntity sysAreaEntity= sysAreaDao.queryObject(sysArea.getParentId());
			sysAreaEntity.setOpen(false);
			sysAreaDao.update(sysAreaEntity);
		}
		return sysArea;
	}

	@Transactional
	@Override
	public void delete(String areaId){

		if(queryAreaIdList(sysAreaDao.queryObject(areaId).getParentId()).size()==1){
			SysAreaEntity sysAreaEntity= sysAreaDao.queryObject(sysAreaDao.queryObject(areaId).getParentId());
			sysAreaEntity.setOpen(false);
			sysAreaDao.update(sysAreaEntity);
		}
		sysAreaDao.delete(areaId);
	}

	@Override
	public List<String> queryAreaIdList(String parentId) {
		return sysAreaDao.queryAreaIdList(parentId);
	}



	@Override
	public List<SysAreaEntity> queryListByParentId(String parentId){
		List<SysAreaEntity> list = sysAreaDao.queryListByParentId(parentId);
		return list;
	}

	@Override
	public List<SysAreaEntity> getList4Open(){
		return sysAreaDao.getList4Open();
	}

	@Override
	public String getSubAreaIdList(String areaId){

		List<String> areaIdList = sysAreaDao.getSubAreaIdList(areaId);


//		//部门及子部门ID列表
////		List<String> areaIdList = new ArrayList<>();
//
//		//获取子部门ID
//		List<String> subIdList = queryAreaIdList(areaId);
//		getAreaTreeList(subIdList, areaIdList);
//
//		//添加本部门
//		areaIdList.add(areaId);
//
//		String areaFilter = StringUtils.join(areaIdList, ",");
		return StringUtil.joinList(areaIdList,",");
	}



	@Override
	public List<String> getSonAreaIdList(String areaId){

		List<String> areaIdList = sysAreaDao.getSubAreaIdList(areaId);


//		//部门及子部门ID列表
////		List<String> areaIdList = new ArrayList<>();
//
//		//获取子部门ID
//		List<String> subIdList = queryAreaIdList(areaId);
//		getAreaTreeList(subIdList, areaIdList);
//
//		//添加本部门
//		areaIdList.add(areaId);
//
//		String areaFilter = StringUtils.join(areaIdList, ",");
		return areaIdList;
	}

	@Override
	public String queryParentIdIsCorrent(SysAreaEntity entity){
		return sysAreaDao.queryParentIdIsCorrent(entity);
	}
}
