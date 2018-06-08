package com.khidi.manager.officework.service.impl;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.sys.dao.SysDictDao;
import com.khidi.manager.sys.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.khidi.manager.sys.dao.SysAreaDao;
import java.util.HashMap;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.officework.dao.CheckrouteDao;
import com.khidi.manager.officework.entity.CheckrouteEntity;
import com.khidi.manager.officework.service.CheckrouteService;



@Service("checkrouteService")
public class CheckrouteServiceImpl implements CheckrouteService {
	@Autowired
	private CheckrouteDao checkrouteDao;
	@Autowired
	private SysAreaDao sysAreaDao;
	@Autowired
	private SysDictDao sysDictDao;
	@Autowired
	private CommonService commonService;
	@Override
	public CheckrouteEntity queryObject(String id){
		return checkrouteDao.queryObject(id);
	}
	
	@Override
	public List<CheckrouteEntity> queryList(Map<String, Object> map){
		List<CheckrouteEntity> list = checkrouteDao.queryList(map);



		for (int i = 0; i < list.size(); i++) {
			list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaid()).getName());

			Map<String, Object> querymap = new HashMap();
			if (StringUtil.isEmpty(list.get(i).getResourcetype())) {
				list.get(i).setResourcetypename(null);
			} else {
				querymap.put("dictValue", list.get(i).getResourcetype());
				querymap.put("dictType", "河湖类型");
				list.get(i).setResourcetypename(sysDictDao.queryObject(querymap).getDictName());
			}

			if (StringUtil.isEmpty(list.get(i).getResourceid())) {
				list.get(i).setResourcename(null);
			} else {
				list.get(i).setResourcename(commonService.getResource(list.get(i).getResourcetype(),list.get(i).getResourceid()));
			}
		}
		return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return checkrouteDao.queryTotal(map);
	}
	
	@Override
	public void save(CheckrouteEntity checkroute){
        checkroute.setId(UUID.randomUUID().toString());
		checkrouteDao.save(checkroute);
	}
	
	@Override
	public void update(CheckrouteEntity checkroute){
		checkrouteDao.update(checkroute);
	}
	
	@Override
	public void delete(String id){
		checkrouteDao.delete(id);
	}
}
