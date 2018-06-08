package com.khidi.manager.basicinfo.service.impl;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.basicinfo.dao.*;
import com.khidi.manager.basicinfo.entity.ResourceIrrigatedEntity;
import com.khidi.manager.sys.dao.FileuploadDao;
import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.dao.SysDictDao;
import com.khidi.manager.sys.entity.FileUploadEntity;
import com.khidi.manager.sys.entity.SysDictEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.basicinfo.entity.ResourceStationEntity;
import com.khidi.manager.basicinfo.service.ResourceStationService;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.monitoringnet.dao.WaterqualitydataDao;
import com.khidi.manager.monitoringnet.entity.WaterqualitydataEntity;

// Jerry Wang 2017 12 23
// Jerry Wang 2017 12 25
@Service("resourceStationService")
public class ResourceStationServiceImpl implements ResourceStationService {
	@Autowired
	private ResourceStationDao resourceStationDao;
	@Autowired
	private SysAreaDao sysAreaDao;
	@Autowired
	private SysDictDao sysDictDao;
	@Autowired
	private RiverDao riverDao;
	@Autowired
	private PartRiverDao partRiverDao;
	@Autowired
	private LakeDao lakeDao;
	@Autowired
	private PartLakeDao partLakeDao;
	@Autowired
	private CanalDao canalDao;
	@Autowired
	private PartCanalDao partCanalDao;
	@Autowired
	private ReservoirDao reservoirDao;
	@Autowired
	private PartReservoirDao partReservoirDao;
	@Autowired
	private WaterqualitydataDao waterqualitydataDao;
	@Autowired
	private FileuploadDao fileuploadDao;

	@Override
	public ResourceStationEntity queryObject(String id) {
		ResourceStationEntity res = resourceStationDao.queryObject(id);
		if (StringUtil.isEmpty(res.getAttachment())) {
			res.setFileList(null);
		} else {
			String allFlieId[] = res.getAttachment().split(",");
			List<FileUploadEntity> fileUpload = new ArrayList<FileUploadEntity>();
			for (int j = 0; j < allFlieId.length; j++) {
				FileUploadEntity fileinfo = new FileUploadEntity();
				fileinfo.setId(fileuploadDao.queryObject(allFlieId[j]).getId());
				fileinfo.setFileName(fileuploadDao.queryObject(allFlieId[j]).getFileName());
				fileinfo.setFilePath(fileuploadDao.queryObject(allFlieId[j]).getFilePath());
				fileUpload.add(fileinfo);
			}
			res.setFileList(fileUpload);
		}

		return res ;
	}

	@Override
	public List<ResourceStationEntity> queryList(Map<String, Object> map) {
		List<ResourceStationEntity> list = resourceStationDao.queryList(map);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());

			if (StringUtil.isEmpty(list.get(i).getAttachment())) {
				list.get(i).setFileList(null);
			} else {
				String allFlieId[] = list.get(i).getAttachment().split(",");
				List<FileUploadEntity> fileUpload = new ArrayList<FileUploadEntity>();
				for (int j = 0; j < allFlieId.length; j++) {
					FileUploadEntity fileinfo = new FileUploadEntity();
					fileinfo.setId(fileuploadDao.queryObject(allFlieId[j]).getId());
					fileinfo.setFileName(fileuploadDao.queryObject(allFlieId[j]).getFileName());
					fileinfo.setFilePath(fileuploadDao.queryObject(allFlieId[j]).getFilePath());
					fileUpload.add(fileinfo);
				}
				list.get(i).setFileList(fileUpload);
			}

			if (StringUtil.isEmpty(list.get(i).getResourceType())) {
				list.get(i).setResourceName(null);
			} else if (StringUtil.isEmpty(list.get(i).getResourceId())) {
				list.get(i).setResourceName(null);
			} else if (list.get(i).getResourceType().equals("1")) { // 河流
				list.get(i).setResourceName(riverDao.queryObject(list.get(i).getResourceId()).getName());
			} else if (list.get(i).getResourceType().equals("2")) { // 河段
				list.get(i).setResourceName(partRiverDao.queryObject(list.get(i).getResourceId()).getName());
			} else if (list.get(i).getResourceType().equals("3")) { // 渠道
				list.get(i).setResourceName(canalDao.queryObject(list.get(i).getResourceId()).getName());
			} else if (list.get(i).getResourceType().equals("4")) { // 渠段
				list.get(i).setResourceName(partCanalDao.queryObject(list.get(i).getResourceId()).getName());
			} else if (list.get(i).getResourceType().equals("5")) { // 湖泊
				list.get(i).setResourceName(lakeDao.queryObject(list.get(i).getResourceId()).getName());
			} else if (list.get(i).getResourceType().equals("6")) { // 湖段
				list.get(i).setResourceName(partLakeDao.queryObject(list.get(i).getResourceId()).getName());
			} else if (list.get(i).getResourceType().equals("7")) { // 水库
				list.get(i).setResourceName(reservoirDao.queryObject(list.get(i).getResourceId()).getName());
			} else if (list.get(i).getResourceType().equals("8")) { // 库段
				list.get(i).setResourceName(partReservoirDao.queryObject(list.get(i).getResourceId()).getName());
			}

			Map<String, Object> querymap = new HashMap();
			if (StringUtil.isEmpty(list.get(i).getStationBuild())) {
				list.get(i).setStationBuildName(null);
			} else {
				querymap.put("dictValue", list.get(i).getStationBuild());
				querymap.put("dictType", "工程建设情况");
				list.get(i).setStationBuildName(sysDictDao.queryObject(querymap).getDictName());
			}

			if (StringUtil.isEmpty(list.get(i).getStationSituation())) {
				list.get(i).setStationSituationName(null);
			} else {
				querymap.put("dictValue", list.get(i).getStationSituation());
				querymap.put("dictType", "运行状况");
				list.get(i).setStationSituationName(sysDictDao.queryObject(querymap).getDictName());
			}

			if (StringUtil.isEmpty(list.get(i).getResourceType())) {
				list.get(i).setResourceTypeName(null);
			} else {
				querymap.put("dictValue", list.get(i).getResourceType());
				querymap.put("dictType", "河湖类型");
				list.get(i).setResourceTypeName(sysDictDao.queryObject(querymap).getDictName());
			}
		}
		return list;
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return resourceStationDao.queryTotal(map);
	}

	@Override
	public void save(ResourceStationEntity resourceStation) {
		resourceStation.setId(UUID.randomUUID().toString());
		resourceStationDao.save(resourceStation);
	}

	@Override
	public void update(ResourceStationEntity resourceStation) {
		resourceStationDao.update(resourceStation);
	}

	@Override
	public void delete(String id) {
		resourceStationDao.delete(id);
	}
	@Override
	public ResourceStationEntity queryObjectByCode(String code){
		return resourceStationDao.queryObjectByCode(code);
	}

	@Override
	public List<ResourceStationEntity> queryByResource(String resourceId, String resourceType, String stationType) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("resourceId", resourceId);
		param.put("resourceType", resourceType);
		param.put("stationType", stationType);
		return resourceStationDao.queryByResource(param);
	}

	@Override
	public List<ResourceStationEntity> queryUpStationLinks(String resourceId, String resourceType, String stationType) {
		// Map<String, Object> param = new HashMap<String, Object>();
		// param.put("resourceId", resourceId);
		// param.put("resourceType", resourceType);
		// param.put("stationType", stationType);
		// return resourceStationDao.queryUpStationLinks(param);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("resourceId", resourceId);
		param.put("resourceType", resourceType);
		param.put("stationType", stationType);
		List<ResourceStationEntity> resourceStations = resourceStationDao.queryByResource(param);
		//
		List<ResourceStationEntity> rtn00 = new ArrayList<ResourceStationEntity>();

		for (ResourceStationEntity lpSentity : resourceStations) {
			boolean lpHaveUpStationsInOri = _UpStationInOriStations(rtn00, lpSentity.getUprId());
			//
			if (!lpHaveUpStationsInOri) {
				rtn00.add(lpSentity);
			}
		}
		//
		_MakeLinkedStations(resourceStations, rtn00);
		//
		return rtn00;
	}

	@Override
	public List<WaterqualitydataEntity> queryWaterqualitydata(String resourceId, String resourceType,
			String stationType) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("resourceId", resourceId);
		param.put("resourceType", resourceType);
		param.put("stationType", stationType);
		List<ResourceStationEntity> resourceStations = resourceStationDao.queryByResource(param);
		//
		List<WaterqualitydataEntity> rtn = new ArrayList<WaterqualitydataEntity>();
		for (ResourceStationEntity lpStationEntity : resourceStations) {
			WaterqualitydataEntity lpRtn0 = waterqualitydataDao.queryObjectfortop(lpStationEntity.getId());
			if (lpRtn0 != null) {
				rtn.add(lpRtn0);
			}
		}
		//
		return rtn;
	}

	@Override
	public List<ResourceStationEntity> allStations(String stationType) {
		return resourceStationDao.allStations(stationType);
	}

	@Override
	public List<WaterqualitydataEntity> queryWaterqualitydata(String resourceIds, String ctDate) {
		String[] resourceIdarr = resourceIds.split(",");
		String rtn0 = "";
		//
		for (String resourceId : resourceIdarr) {
			rtn0 += "'" + resourceId + "',";
		}
		if (rtn0.endsWith(",")) {
			rtn0.substring(0, rtn0.length() - 1);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", rtn0);
		map.put("thetime", HbmwfUtil.GetDate(ctDate));
		//
		return waterqualitydataDao.queryObjectReleatedTime(map);
	}

	//
	private boolean _UpStationInOriStations(List<ResourceStationEntity> oriStations, String uprId) {
		if (oriStations == null || oriStations.size() <= 0) {
			return false;
		}
		for (ResourceStationEntity stationEntity : oriStations) {
			String lpSentity = stationEntity.getUprId();
			if (lpSentity == null || lpSentity.equals("")) {
				return false;
			} else {
				if (lpSentity.equals(uprId)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean ___HaveDownStations(List<ResourceStationEntity> oriStations, ResourceStationEntity theStation) {
		List<ResourceStationEntity> rtn = new ArrayList<ResourceStationEntity>();
		for (ResourceStationEntity lpStation : oriStations) {
			if (lpStation.getUprId().equals(theStation.getId())) {
				return true;
			}
		}
		//
		return false;
	}

	private boolean TmpStationInTmpStations(List<ResourceStationEntity> tmpStations, ResourceStationEntity tmpStation) {
		for (ResourceStationEntity lpStation : tmpStations) {
			if (lpStation.getId().equals(tmpStation.getId())) {
				return true;
			}
		}
		return false;
	}

	private void __FillDownStations(List<ResourceStationEntity> oriStations, ResourceStationEntity theStation) {
		if (TmpStationInTmpStations(oriStations, theStation)) {
			return;
		}
		//
		List<ResourceStationEntity> rtn = new ArrayList<ResourceStationEntity>();
		for (ResourceStationEntity lpStation : oriStations) {
			if (lpStation.getUprId().equals(theStation.getId())) {
				rtn.add(lpStation);
				//
				if (___HaveDownStations(oriStations, lpStation)) {
					if (!TmpStationInTmpStations(resourceStations, lpStation)) {
						resourceStations.add(lpStation);
					}
					__FillDownStations(oriStations, lpStation);
				}
			}
		}
		//
		if (rtn == null || rtn.size() <= 0) {
			theStation.setDownStation(null);
		} else {
			theStation.setDownStation(rtn);
		}
	}

	private List<ResourceStationEntity> resourceStations;

	private void _MakeLinkedStations(List<ResourceStationEntity> oriStations, List<ResourceStationEntity> rtn00) {
		if (rtn00 == null || rtn00.size() == 0) {
			return;
		}
		//
		resourceStations = new ArrayList<ResourceStationEntity>();
		//

		for (ResourceStationEntity lpEntity : rtn00) {
			__FillDownStations(oriStations, lpEntity);
		}
	}

}
