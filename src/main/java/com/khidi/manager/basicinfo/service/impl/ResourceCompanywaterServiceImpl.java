package com.khidi.manager.basicinfo.service.impl;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.dao.SysDictDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.basicinfo.dao.ResourceCompanywaterDao;
import com.khidi.manager.basicinfo.entity.ResourceCompanywaterEntity;
import com.khidi.manager.basicinfo.service.ResourceCompanywaterService;



@Service("resourceCompanywaterService")
public class ResourceCompanywaterServiceImpl implements ResourceCompanywaterService {
	@Autowired
	private ResourceCompanywaterDao resourceCompanywaterDao;
	@Autowired
	private SysAreaDao sysAreaDao;
	@Autowired
	private SysDictDao sysDictDao;

	@Override
	public ResourceCompanywaterEntity queryObject(String id){
		return resourceCompanywaterDao.queryObject(id);
	}

	@Override
	public List<ResourceCompanywaterEntity> queryList(Map<String, Object> map){
		List<ResourceCompanywaterEntity> list = resourceCompanywaterDao.queryList(map);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());

			Map<String, Object> querymap = new HashMap();
			if (StringUtil.isEmpty(list.get(i).getOutputDirection())){
				list.get(i).setOutputDirectionName(null);
			}else{
				querymap.put("dictValue",list.get(i).getOutputDirection());
				querymap.put("dictType","排去方向");
				list.get(i).setOutputDirectionName(sysDictDao.queryObject(querymap).getDictName());
			}

			if (StringUtil.isEmpty(list.get(i).getTapwaterMode())){
				list.get(i).setTapwaterModeName(null);
			}else{
				querymap.put("dictValue",list.get(i).getTapwaterMode());
				querymap.put("dictType","自来水计量方式");
				list.get(i).setTapwaterModeName(sysDictDao.queryObject(querymap).getDictName());
			}

			if (StringUtil.isEmpty(list.get(i).getSurfacewaterMode())){
				list.get(i).setSurfacewaterModeName(null);
			}else{
				querymap.put("dictValue",list.get(i).getSurfacewaterMode());
				querymap.put("dictType","地表水计量方式");
				list.get(i).setSurfacewaterModeName(sysDictDao.queryObject(querymap).getDictName());
			}

			if (StringUtil.isEmpty(list.get(i).getGroundwaterMode())){
				list.get(i).setGroundwaterModeName(null);
			}else{
				querymap.put("dictValue",list.get(i).getGroundwaterMode());
				querymap.put("dictType","地下水计量方式");
				list.get(i).setGroundwaterModeName(sysDictDao.queryObject(querymap).getDictName());
			}

			if (StringUtil.isEmpty(list.get(i).getReclaimedwaterMode())){
				list.get(i).setReclaimedwaterModeName(null);
			}else{
				querymap.put("dictValue",list.get(i).getReclaimedwaterMode());
				querymap.put("dictType","再生水计量方式");
				list.get(i).setReclaimedwaterModeName(sysDictDao.queryObject(querymap).getDictName());
			}

			if (StringUtil.isEmpty(list.get(i).getOtherwaterMode())){
				list.get(i).setOtherwaterModeName(null);
			}else{
				querymap.put("dictValue",list.get(i).getOtherwaterMode());
				querymap.put("dictType","其他水计量方式");
				list.get(i).setOtherwaterModeName(sysDictDao.queryObject(querymap).getDictName());
			}

		}
		return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resourceCompanywaterDao.queryTotal(map);
	}
	
	@Override
	public void save(ResourceCompanywaterEntity resourceCompanywater){
        resourceCompanywater.setId(UUID.randomUUID().toString());
		resourceCompanywaterDao.save(resourceCompanywater);
	}
	
	@Override
	public void update(ResourceCompanywaterEntity resourceCompanywater){
		resourceCompanywaterDao.update(resourceCompanywater);
	}
	
	@Override
	public void delete(String id){
		resourceCompanywaterDao.delete(id);
	}
}
