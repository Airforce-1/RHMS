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

import com.khidi.manager.basicinfo.dao.ResourceIrrigatedDao;
import com.khidi.manager.basicinfo.entity.ResourceIrrigatedEntity;
import com.khidi.manager.basicinfo.service.ResourceIrrigatedService;


@Service("resourceIrrigatedService")
public class ResourceIrrigatedServiceImpl implements ResourceIrrigatedService {
    @Autowired
    private ResourceIrrigatedDao resourceIrrigatedDao;
    @Autowired
    private SysAreaDao sysAreaDao;
    @Autowired
    private SysDictDao sysDictDao;

    @Override
    public ResourceIrrigatedEntity queryObject(String id) {
        return resourceIrrigatedDao.queryObject(id);
    }

    @Override
    public List<ResourceIrrigatedEntity> queryList(Map<String, Object> map) {
        List<ResourceIrrigatedEntity> list = resourceIrrigatedDao.queryList(map);

        for (int i = 0; i < list.size(); i++) {
            list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());

            Map<String, Object> querymap = new HashMap();
            if (StringUtil.isEmpty(list.get(i).getWateruserType())) {
                list.get(i).setWateruserName(null);
            } else {
                querymap.put("dictValue", list.get(i).getWateruserType());
                querymap.put("dictType", "用水类型");
                list.get(i).setWateruserName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(list.get(i).getWaterType())) {
                list.get(i).setWaterTypeName(null);
            } else {
                querymap.put("dictValue", list.get(i).getWaterType());
                querymap.put("dictType", "水源类型");
                list.get(i).setWaterTypeName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(list.get(i).getScale())) {
                list.get(i).setScaleName(null);
            } else {
                querymap.put("dictValue", list.get(i).getScale());
                querymap.put("dictType", "工程规模");
                list.get(i).setScaleName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(list.get(i).getBuild())) {
                list.get(i).setBuildName(null);
            } else {
                querymap.put("dictValue", list.get(i).getBuild());
                querymap.put("dictType", "工程建设情况");
                list.get(i).setBuildName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(list.get(i).getWork())) {
                list.get(i).setWorkName(null);
            } else {
                querymap.put("dictValue", list.get(i).getWork());
                querymap.put("dictType", "运行状况");
                list.get(i).setWorkName(sysDictDao.queryObject(querymap).getDictName());
            }
        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return resourceIrrigatedDao.queryTotal(map);
    }

    @Override
    public void save(ResourceIrrigatedEntity resourceIrrigated) {
        resourceIrrigated.setId(UUID.randomUUID().toString());
        resourceIrrigatedDao.save(resourceIrrigated);
    }

    @Override
    public void update(ResourceIrrigatedEntity resourceIrrigated) {
        resourceIrrigatedDao.update(resourceIrrigated);
    }

    @Override
    public void delete(String id) {
        resourceIrrigatedDao.delete(id);
    }
}
