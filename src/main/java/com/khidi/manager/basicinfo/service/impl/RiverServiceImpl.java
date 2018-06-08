package com.khidi.manager.basicinfo.service.impl;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.sys.dao.SysDictDao;
import com.khidi.manager.sys.entity.SysAreaEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.basicinfo.dao.RiverDao;
import com.khidi.manager.basicinfo.entity.RiverEntity;
import com.khidi.manager.basicinfo.service.RiverService;
import com.khidi.manager.sys.dao.SysAreaDao;



@Service("riverService")
public class RiverServiceImpl implements RiverService {
	@Autowired
	private RiverDao riverDao;
	@Autowired
	private SysAreaDao sysAreaDao;
	@Autowired
	private SysDictDao sysDictDao;
	
	@Override
	public RiverEntity queryObject(String id){
		RiverEntity rtn = riverDao.queryObject(id);
//		SysAreaEntity sae = sysAreaDao.queryObject(rtn.getAreaId());
//		rtn.setAreaId(sae.getId());
		return rtn;
	}
	
	@Override
	public List<RiverEntity> queryList(Map<String, Object> map){
		List<RiverEntity> list = riverDao.queryList(map);
		for(int i =0;i<list.size();i++){
			list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());

			Map<String,Object> querymap =  new HashMap();

			if (StringUtil.isEmpty(list.get(i).getDirection())) {
				list.get(i).setDirectionName(null);
			}else{
				querymap.put("dictValue",list.get(i).getDirection());
				querymap.put("dictType","岸别");
				list.get(i).setDirectionName(sysDictDao.queryObject(querymap).getDictName());
			}

			if (StringUtil.isEmpty(list.get(i).getCrossType())) {
				list.get(i).setCrossTypeName(null);
			}else{
				querymap.put("dictValue",list.get(i).getCrossType());
				querymap.put("dictType","跨界类型");
				list.get(i).setCrossTypeName(sysDictDao.queryObject(querymap).getDictName());
			}

			if (StringUtil.isEmpty(list.get(i).getType())) {
				list.get(i).setTypeName(null);
			}else{
				querymap.put("dictValue",list.get(i).getType());
				querymap.put("dictType","河流（渠道）类型");
				list.get(i).setTypeName(sysDictDao.queryObject(querymap).getDictName());
			}


		}
	    return list;
	}
	
	private void _fillChildrenRivers(RiverEntity item)
	{
		if(item == null)
		{
			return;
		}
		List<RiverEntity> rtn0 = riverDao.queryChildrenRivers(item.getId());
		item.setChildrenRiver(rtn0);
		if(rtn0 != null && rtn0.size() > 0)
		{
			for(RiverEntity lpRiver : rtn0)
			{
				_fillChildrenRivers(lpRiver);
			}
		}		
	}
	
	@Override
	public List<RiverEntity> queryChildrenRivers(String parentId)
	{
		List<RiverEntity> riverLists = riverDao.queryChildrenRivers(parentId);
		//
		for(RiverEntity lpRiver : riverLists)
		{
			_fillChildrenRivers(lpRiver);
		}
		//
		return riverLists;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return riverDao.queryTotal(map);
	}
	
	@Override
	public void save(RiverEntity river){
        river.setId(UUID.randomUUID().toString());
		riverDao.save(river);
	}
	
	@Override
	public void update(RiverEntity river){
		riverDao.update(river);
	}
	
	@Override
	public void delete(String id){
		riverDao.delete(id);
	}
	

}
