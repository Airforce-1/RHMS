package com.khidi.manager.basicinfo.service.impl;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.basicinfo.dao.*;
import com.khidi.manager.sys.dao.FileuploadDao;
import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.dao.SysDictDao;
import com.khidi.manager.sys.entity.FileUploadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.khidi.manager.basicinfo.entity.ResourceIntakeEntity;
import com.khidi.manager.basicinfo.service.ResourceIntakeService;


@Service("resourceIntakeService")
public class ResourceIntakeServiceImpl implements ResourceIntakeService {
    @Autowired
    private ResourceIntakeDao resourceIntakeDao;
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
    public ResourceIntakeEntity queryObject(String id) {
        return resourceIntakeDao.queryObject(id);
    }

    @Override
    public List<ResourceIntakeEntity> queryList(Map<String, Object> map) {
        List<ResourceIntakeEntity> list = resourceIntakeDao.queryList(map);
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

            Map<String, Object> querymap = new HashMap();
            if (StringUtil.isEmpty(list.get(i).getStationBuild())) {
                list.get(i).setStationBuildName(null);
            } else {
                querymap.put("dictValue", list.get(i).getStationBuild());
                querymap.put("dictType", "工程建设情况");
                list.get(i).setStationBuildName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(list.get(i).getWaterTyper())) {
                list.get(i).setWaterTyperName(null);
            } else {
                querymap.put("dictValue", list.get(i).getWaterTyper());
                querymap.put("dictType", "水质类型");
                list.get(i).setWaterTyperName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(list.get(i).getResourceType())) {
                list.get(i).setResourceTypeName(null);
            } else {
                querymap.put("dictValue", list.get(i).getResourceType());
                querymap.put("dictType", "河湖类型");
                list.get(i).setResourceTypeName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(list.get(i).getGetway())) {
                list.get(i).setGetwayName(null);
            } else {
                querymap.put("dictValue", list.get(i).getGetway());
                querymap.put("dictType", "取水方式");
                list.get(i).setGetwayName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(list.get(i).getStationSituation())) {
                list.get(i).setStationSituationName(null);
            } else {
                querymap.put("dictValue", list.get(i).getStationSituation());
                querymap.put("dictType", "运行状况");
                list.get(i).setStationSituationName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(list.get(i).getResourceType())) {
                list.get(i).setResourceName(null);
            } else if (StringUtil.isEmpty(list.get(i).getResourceId())) {
                list.get(i).setResourceName(null);
            } else if (list.get(i).getResourceType().equals("1")) {   //河流
                list.get(i).setResourceName(riverDao.queryObject(list.get(i).getResourceId()).getName());
            } else if (list.get(i).getResourceType().equals("2")) {    //河段
                list.get(i).setResourceName(partRiverDao.queryObject(list.get(i).getResourceId()).getName());
            } else if (list.get(i).getResourceType().equals("3")) {    //渠道
                list.get(i).setResourceName(canalDao.queryObject(list.get(i).getResourceId()).getName());
            } else if (list.get(i).getResourceType().equals("4")) {    //渠段
                list.get(i).setResourceName(partCanalDao.queryObject(list.get(i).getResourceId()).getName());
            } else if (list.get(i).getResourceType().equals("5")) {  //湖泊
                list.get(i).setResourceName(lakeDao.queryObject(list.get(i).getResourceId()).getName());
            } else if (list.get(i).getResourceType().equals("6")) {    //湖段
                list.get(i).setResourceName(partLakeDao.queryObject(list.get(i).getResourceId()).getName());
            } else if (list.get(i).getResourceType().equals("7")) {   //水库
                list.get(i).setResourceName(reservoirDao.queryObject(list.get(i).getResourceId()).getName());
            } else if (list.get(i).getResourceType().equals("8")) {    //库段
                list.get(i).setResourceName(partReservoirDao.queryObject(list.get(i).getResourceId()).getName());
            }
        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return resourceIntakeDao.queryTotal(map);
    }

    @Override
    public void save(ResourceIntakeEntity resourceIntake) {
        resourceIntake.setId(UUID.randomUUID().toString());
        resourceIntakeDao.save(resourceIntake);
    }

    @Override
    public void update(ResourceIntakeEntity resourceIntake) {
        resourceIntakeDao.update(resourceIntake);
    }

    @Override
    public void delete(String id) {
        resourceIntakeDao.delete(id);
    }
}
