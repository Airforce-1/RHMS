package com.khidi.manager.monitoringnet.service.impl;

import com.khidi.manager.basicinfo.dao.ResourceStationDao;
import com.khidi.manager.basicinfo.entity.ResourceStationEntity;
import com.khidi.manager.sys.dao.SysAreaDao;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.khidi.manager.monitoringnet.dao.HydrologydataDao;
import com.khidi.manager.monitoringnet.entity.HydrologydataEntity;
import com.khidi.manager.monitoringnet.service.HydrologydataService;



@Service("hydrologydataService")
public class HydrologydataServiceImpl implements HydrologydataService {
	@Autowired
	private HydrologydataDao hydrologydataDao;
	@Autowired
	private ResourceStationDao resourceStationDao;
	@Autowired
	private SysAreaDao sysAreaDao;

	@Override
	public List<HydrologydataEntity> querytopList(Map<String, Object> map){
		Map<String,Object> stationMap = new HashedMap();
		if (map.get("areaId") != null) {
			stationMap.put("areaId", map.get("areaId"));
		}if (map.get("stationName")  != null) {
			stationMap.put("stationName", map.get("stationName"));
		}

		stationMap.put("stationType","2");//2为水文监测站
		List<ResourceStationEntity> stationList = resourceStationDao.queryList(stationMap);
		List<HydrologydataEntity> resultList =  new ArrayList<>();
		if(map.get("startDate")==null&&map.get("endDate")==null){
			for(int i=0;i<stationList.size();i++){
				if(hydrologydataDao.queryObjectfortop(stationList.get(i).getId()) != null){
					HydrologydataEntity entity = hydrologydataDao.queryObjectfortop(stationList.get(i).getId());
					entity.setAreaName(sysAreaDao.queryObject(stationList.get(i).getAreaId()).getName());
					entity.setStationName(stationList.get(i).getName());
					entity.setCode(stationList.get(i).getCode());
					resultList.add(entity);
				}

			}
		}else if(map.get("startDate")!=null&&map.get("endDate")==null){
			System.out.println(map.get("startDate"));
			for(int i=0;i<stationList.size();i++){
				if(hydrologydataDao.queryObjectfortop(stationList.get(i).getId()) != null){
					HydrologydataEntity entity = hydrologydataDao.queryObjectfortop(stationList.get(i).getId());
					entity.setAreaName(sysAreaDao.queryObject(stationList.get(i).getAreaId()).getName());
					entity.setStationName(stationList.get(i).getName());
					entity.setCode(stationList.get(i).getCode());
					if(entity.getCreatetime().after((Date)map.get("startDate"))){
						resultList.add(entity);
					}
				}

			}
		}else if(map.get("startDate")==null&&map.get("endDate")!=null){
			for(int i=0;i<stationList.size();i++){
				if(hydrologydataDao.queryObjectfortop(stationList.get(i).getId()) != null){
					HydrologydataEntity entity = hydrologydataDao.queryObjectfortop(stationList.get(i).getId());
					entity.setAreaName(sysAreaDao.queryObject(stationList.get(i).getAreaId()).getName());
					entity.setStationName(stationList.get(i).getName());
					entity.setCode(stationList.get(i).getCode());
					if(entity.getCreatetime().before((Date)map.get("endDate"))){
						resultList.add(entity);
					}
				}

			}
		}else{
			for(int i=0;i<stationList.size();i++){
				if(hydrologydataDao.queryObjectfortop(stationList.get(i).getId()) != null){
					HydrologydataEntity entity = hydrologydataDao.queryObjectfortop(stationList.get(i).getId());
					entity.setAreaName(sysAreaDao.queryObject(stationList.get(i).getAreaId()).getName());
					entity.setStationName(stationList.get(i).getName());
					entity.setCode(stationList.get(i).getCode());
					if(entity.getCreatetime().after((Date)map.get("startDate"))&&entity.getCreatetime().before((Date)map.get("endDate"))){
						resultList.add(entity);
					}
				}

			}
		}

	return resultList;
	}
	
	@Override
	public HydrologydataEntity queryObject(String id){
		HydrologydataEntity hydrologydataEntity= hydrologydataDao.queryObject(id);
		ResourceStationEntity entity = resourceStationDao.queryObject(hydrologydataEntity.getStationId());
		hydrologydataEntity.setCode(entity.getCode());
		hydrologydataEntity.setStationName(entity.getName());
		return hydrologydataEntity;
	}
	
	@Override
	public List<HydrologydataEntity> queryList(Map<String, Object> map){
	    return hydrologydataDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return hydrologydataDao.queryTotal(map);
	}
	
	@Override
	public void save(HydrologydataEntity hydrologydata){
        hydrologydata.setId(UUID.randomUUID().toString());
		hydrologydataDao.save(hydrologydata);
	}
	
	@Override
	public void update(HydrologydataEntity hydrologydata){
		hydrologydataDao.update(hydrologydata);
	}
	
	@Override
	public void delete(String id){
		hydrologydataDao.delete(id);
	}

	@Override
	public HydrologydataEntity queryObjectfortop(String id){
		return hydrologydataDao.queryObjectfortop(id);
	}
}
