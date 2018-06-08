package com.khidi.manager.basicinfo.service.impl;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.basicinfo.dao.*;
import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.dao.SysDictDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.basicinfo.entity.ResourceVideoEntity;
import com.khidi.manager.basicinfo.service.ResourceVideoService;

import javax.annotation.Resource;

@Service("resourceVideoService")
public class ResourceVideoServiceImpl implements ResourceVideoService {
    @Autowired
    private ResourceVideoDao resourceVideoDao;
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
    private ResourceStationDao resourceStationDao;

    @Override
    public ResourceVideoEntity queryObject(String id) {
        return resourceVideoDao.queryObject(id);
    }


    @Override
    public List<ResourceVideoEntity> queryList(Map<String, Object> map) {
        List<ResourceVideoEntity> list = resourceVideoDao.queryList(map);


        for (int i = 0; i < list.size(); i++) {
            list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());

            Map<String, Object> querymap = new HashMap();

            if (StringUtil.isEmpty(list.get(i).getType())) {
                list.get(i).setStationTypeName(null);
            } else {
                querymap.put("dictValue", list.get(i).getType());
                querymap.put("dictType", "视频监测站类型");
                list.get(i).setStationTypeName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(list.get(i).getResourceType())) {
                list.get(i).setResourceTypeName(null);
            } else {
                querymap.put("dictValue", list.get(i).getResourceType());
                querymap.put("dictType", "河湖类型");
                list.get(i).setResourceTypeName(sysDictDao.queryObject(querymap).getDictName());
            }

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

            if (StringUtil.isEmpty(list.get(i).getStationId())) {
                list.get(i).setStationName(null);
            }else{
                list.get(i).setStationName(resourceStationDao.queryObject(list.get(i).getStationId()).getName());
            }
        }

        return list;
    }


    @Override
    public int queryTotal(Map<String, Object> map) {
        return resourceVideoDao.queryTotal(map);
    }

    @Override
    public void save(ResourceVideoEntity resourceVideo) {
        resourceVideo.setId(UUID.randomUUID().toString());
        resourceVideoDao.save(resourceVideo);
    }

    @Override
    public void update(ResourceVideoEntity resourceVideo) {
        resourceVideoDao.update(resourceVideo);
    }

    @Override
    public void delete(String id) {
        resourceVideoDao.delete(id);
    }
}
