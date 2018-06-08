package com.khidi.manager.monitoringnet.service.impl;

import com.khidi.common.utils.DateUtils;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.basicinfo.dao.ResourceStationDao;
import com.khidi.manager.basicinfo.entity.ResourceStationEntity;
import com.khidi.manager.externaldata.entity.EcoCompensationEntity;
import com.khidi.manager.externaldata.service.EcoCompensationService;
import com.khidi.manager.gb.service.StandardWaterService;
import com.khidi.manager.gb.vo.DataByLevelVo;
import com.khidi.manager.gis.vo.WaterEcoInfo4GisVo;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.monitoringnet.entity.HydrologydataEntity;
import com.khidi.manager.sys.dao.SysAreaDao;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.khidi.manager.monitoringnet.dao.WaterqualitydataDao;
import com.khidi.manager.monitoringnet.entity.WaterqualitydataEntity;
import com.khidi.manager.monitoringnet.service.WaterqualitydataService;

// Jerry Wang 2017 12 25
@Service("waterqualitydataService")
public class WaterqualitydataServiceImpl implements WaterqualitydataService {
	@Autowired
	private WaterqualitydataDao waterqualitydataDao;
	@Autowired
	private ResourceStationDao resourceStationDao;
	@Autowired
	private SysAreaDao sysAreaDao;
	@Autowired
	private EcoCompensationService ecoCompensationService;
	@Autowired
	private StandardWaterService standardWaterService;
	@Override
	public WaterqualitydataEntity queryObject(String id) {
		WaterqualitydataEntity waterqualitydataEntity = waterqualitydataDao.queryObject(id);
		ResourceStationEntity entity = resourceStationDao.queryObject(waterqualitydataEntity.getStationId());
		waterqualitydataEntity.setCode(entity.getCode());
		waterqualitydataEntity.setStationName(entity.getName());
		return waterqualitydataEntity;
	}

	@Override
	public List<WaterqualitydataEntity> queryList(Map<String, Object> map) {
		return waterqualitydataDao.queryList(map);
	}

	public List<WaterqualitydataEntity> querytopList(Map<String, Object> map) {

		Map<String, Object> stationMap = new HashedMap();
		if (map.get("areaId") != null) {
			stationMap.put("areaId", map.get("areaId"));
		}
		if (map.get("stationName") != null) {
			stationMap.put("stationName", map.get("stationName"));
		}

		stationMap.put("stationType", "1");// 1为水质监测站
		List<ResourceStationEntity> stationList = resourceStationDao.queryList(stationMap);
		List<WaterqualitydataEntity> resultList = new ArrayList<>();
		if (map.get("startDate") == null && map.get("endDate") == null) {
			for (int i = 0; i < stationList.size(); i++) {
				if (waterqualitydataDao.queryObjectfortop(stationList.get(i).getId()) != null) {
					WaterqualitydataEntity entity = waterqualitydataDao.queryObjectfortop(stationList.get(i).getId());
					entity.setAreaName(sysAreaDao.queryObject(stationList.get(i).getAreaId()).getName());
					entity.setStationName(stationList.get(i).getName());
					entity.setCode(stationList.get(i).getCode());
					resultList.add(entity);
				}

			}
		} else if (map.get("startDate") != null && map.get("endDate") == null) {
			System.out.println(map.get("startDate"));
			for (int i = 0; i < stationList.size(); i++) {
				if (waterqualitydataDao.queryObjectfortop(stationList.get(i).getId()) != null) {
					WaterqualitydataEntity entity = waterqualitydataDao.queryObjectfortop(stationList.get(i).getId());
					entity.setAreaName(sysAreaDao.queryObject(stationList.get(i).getAreaId()).getName());
					entity.setStationName(stationList.get(i).getName());
					entity.setCode(stationList.get(i).getCode());
					if(entity.getCreatetime().after((Date)map.get("startDate"))){
						resultList.add(entity);
					}
				}

			}
		} else if (map.get("startDate") == null && map.get("endDate") != null) {
			for (int i = 0; i < stationList.size(); i++) {
				if (waterqualitydataDao.queryObjectfortop(stationList.get(i).getId()) != null) {
					WaterqualitydataEntity entity = waterqualitydataDao.queryObjectfortop(stationList.get(i).getId());
					entity.setAreaName(sysAreaDao.queryObject(stationList.get(i).getAreaId()).getName());
					entity.setStationName(stationList.get(i).getName());
					entity.setCode(stationList.get(i).getCode());
					if (entity.getCreatetime().before((Date)(map.get("endDate")))){
						resultList.add(entity);
					}
				}

			}
		} else {
			for (int i = 0; i < stationList.size(); i++) {
				if (waterqualitydataDao.queryObjectfortop(stationList.get(i).getId()) != null) {
					WaterqualitydataEntity entity = waterqualitydataDao.queryObjectfortop(stationList.get(i).getId());
					entity.setAreaName(sysAreaDao.queryObject(stationList.get(i).getAreaId()).getName());
					entity.setStationName(stationList.get(i).getName());
					entity.setCode(stationList.get(i).getCode());
					if (entity.getCreatetime().after((Date)(map.get("startDate")))
							&& entity.getCreatetime().before((Date)(map.get("endDate")))){
						resultList.add(entity);
					}
				}

			}
		}

		return resultList;
	}

	private String GetStationIdsSql(String stationId) {
		String rtn = "";
		String[] stationIdarr = stationId.split(",");
		for (String st : stationIdarr) {
			rtn += String.format("'%s',", st);
		}
		if (rtn.endsWith(",")) {
			rtn = rtn.substring(0, rtn.length() - 1);
		}
		//
		return rtn;
	}

	@Override
	public List<WaterqualitydataEntity> queryObjectReleatedTime(String stationId, String ctDate) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//String stationIdSql = GetStationIdsSql(stationId);
		String[] stationIdarr = stationId.split(",");
//		List<Map<String, Object>> stationIdObj = parseToParam(stationIdarr);
//		map.put("ids", stationIdarr);
//		map.put("thedate", DateUtils.stringToDate(ctDate, "yyyy-MM-dd HH:mm:ss"));
//		return waterqualitydataDao.queryObjectReleatedTime(map);
		List<WaterqualitydataEntity> rtn = new ArrayList<WaterqualitydataEntity>();
		for(String lpStationId : stationIdarr)
		{
			map.put("id", lpStationId);
			map.put("thedate", DateUtils.stringToDate(ctDate, "yyyy-MM-dd HH:mm:ss"));
			WaterqualitydataEntity lpEntity = waterqualitydataDao.queryObjectReleatedTimeSingle(map);
			//
			rtn.add(lpEntity);
		}
		return rtn;
	}
	@Override
	public int queryTotal(Map<String, Object> map) {
		return waterqualitydataDao.queryTotal(map);
	}

	@Override
	public void save(WaterqualitydataEntity waterqualitydata) {
		waterqualitydata.setId(UUID.randomUUID().toString());
		waterqualitydataDao.save(waterqualitydata);
	}

	@Override
	public void update(WaterqualitydataEntity waterqualitydata) {
		waterqualitydataDao.update(waterqualitydata);
	}

	@Override
	public void delete(String id) {
		waterqualitydataDao.delete(id);
	}

	@Override
	public WaterqualitydataEntity queryObjectfortop(String id){
		return waterqualitydataDao.queryObjectfortop(id);
	}




	public WaterEcoInfo4GisVo getWQStationInfo(String stationId){
		//获取到该监测站的详情
		ResourceStationEntity resourceStationEntity =resourceStationDao.queryObject(stationId);
		//获取到该站点最新的一条水质监测记录
		WaterqualitydataEntity waterqualitydataEntity =  this.queryObjectfortop(stationId);
		//获取该站点最新的一条生态补偿金记录
		List<EcoCompensationEntity> ecoList = ecoCompensationService.queryListByStationId(stationId);
		//构造一个返回类型
		WaterEcoInfo4GisVo resultVo = new WaterEcoInfo4GisVo();
		if(ecoList.size()>0){
			resultVo.setEcoCompensationEntity(ecoList.get(0));
		}
		//取出几类水的标准
		DataByLevelVo vo = standardWaterService.getDataByLevel(resourceStationEntity.getAimLevel());
		resultVo.setAim4Cod(vo.getCodLimit());
		resultVo.setAim4nh(vo.getNhLimit());
		resultVo.setAim4P(vo.getpLimit());
		resultVo.setAimLevel(resourceStationEntity.getAimLevel());
		if(waterqualitydataEntity != null){
			resultVo.setMonTime(DateUtils.format(waterqualitydataEntity.getCreatetime(),"yyyy-MM-dd HH:mm:ss"));
			resultVo.setCod4Now(waterqualitydataEntity.getCod());
			resultVo.setP4Now(waterqualitydataEntity.getPhosphor());
			resultVo.setNh4Now(waterqualitydataEntity.getNh());
			resultVo.setCurrentLevel(StringUtil.getMax(standardWaterService.getCodLevelByValue(waterqualitydataEntity.getCod()),standardWaterService.getNHLevelByValue(waterqualitydataEntity.getNh()),standardWaterService.getPLevelByValue(waterqualitydataEntity.getPhosphor())));
		}
		return resultVo;
	}
}
