package com.khidi.manager.basicinfo.service.impl;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.basicinfo.dao.*;
import com.khidi.manager.basicinfo.entity.ResourceIrrigatedEntity;
import com.khidi.manager.sys.dao.FileuploadDao;
import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.dao.SysDictDao;
import com.khidi.manager.sys.entity.FileUploadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.khidi.manager.basicinfo.entity.ResourcePublicitycardEntity;
import com.khidi.manager.basicinfo.service.ResourcePublicitycardService;



@Service("resourcePublicitycardService")
public class ResourcePublicitycardServiceImpl implements ResourcePublicitycardService {
	@Autowired
	private ResourcePublicitycardDao resourcePublicitycardDao;
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
	private FileuploadDao fileuploadDao;

	
	@Override
	public ResourcePublicitycardEntity queryObject(String id){



		return resourcePublicitycardDao.queryObject(id);
	}
	
	@Override
	public List<ResourcePublicitycardEntity> queryList(Map<String, Object> map){
		List<ResourcePublicitycardEntity> list = resourcePublicitycardDao.queryList(map);

		for (int i = 0; i < list.size(); i++) {
			list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());

			if (StringUtil.isEmpty(list.get(i).getFileaddress())) {
				list.get(i).setFileList(null);
			} else {
				String allFlieId[] = list.get(i).getFileaddress().split(",");
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

			Map<String, Object> querymap = new HashMap();
			if (StringUtil.isEmpty(list.get(i).getResourcetype())) {
				list.get(i).setResourcetypeName(null);
			} else {
				querymap.put("dictValue", list.get(i).getResourcetype());
				querymap.put("dictType", "河湖类型");
				list.get(i).setResourcetypeName(sysDictDao.queryObject(querymap).getDictName());
			}

			if (StringUtil.isEmpty(list.get(i).getResourcetype())) {
				list.get(i).setResourceName(null);
			} else if (StringUtil.isEmpty(list.get(i).getResourceid())) {
				list.get(i).setResourceName(null);
			} else if (list.get(i).getResourcetype().equals("1")) {   //河流
				list.get(i).setResourceName(riverDao.queryObject(list.get(i).getResourceid()).getName());
			} else if (list.get(i).getResourcetype().equals("2")) {    //河段
				list.get(i).setResourceName(partRiverDao.queryObject(list.get(i).getResourceid()).getName());
			} else if (list.get(i).getResourcetype().equals("3")) {    //渠道
				list.get(i).setResourceName(canalDao.queryObject(list.get(i).getResourceid()).getName());
			} else if (list.get(i).getResourcetype().equals("4")) {    //渠段
				list.get(i).setResourceName(partCanalDao.queryObject(list.get(i).getResourceid()).getName());
			} else if (list.get(i).getResourcetype().equals("5")) {  //湖泊
				list.get(i).setResourceName(lakeDao.queryObject(list.get(i).getResourceid()).getName());
			} else if (list.get(i).getResourcetype().equals("6")) {    //湖段
				list.get(i).setResourceName(partLakeDao.queryObject(list.get(i).getResourceid()).getName());
			} else if (list.get(i).getResourcetype().equals("7")) {   //水库
				list.get(i).setResourceName(reservoirDao.queryObject(list.get(i).getResourceid()).getName());
			} else if (list.get(i).getResourcetype().equals("8")) {    //库段
				list.get(i).setResourceName(partReservoirDao.queryObject(list.get(i).getResourceid()).getName());
			}

		}
		return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resourcePublicitycardDao.queryTotal(map);
	}
	
	@Override
	public void save(ResourcePublicitycardEntity resourcePublicitycard){
        resourcePublicitycard.setId(UUID.randomUUID().toString());
		resourcePublicitycardDao.save(resourcePublicitycard);
	}
	
	@Override
	public void update(ResourcePublicitycardEntity resourcePublicitycard){
		resourcePublicitycardDao.update(resourcePublicitycard);
	}
	
	@Override
	public void delete(String id){
		resourcePublicitycardDao.delete(id);
	}
}
