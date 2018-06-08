package com.khidi.manager.basicinfo.service.impl;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.sys.dao.SysDictDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.khidi.manager.basicinfo.dao.ReservoirDao;
import com.khidi.manager.basicinfo.entity.ReservoirEntity;
import com.khidi.manager.basicinfo.service.ReservoirService;
import com.khidi.manager.sys.dao.SysAreaDao;

@Service("reservoirService")
public class ReservoirServiceImpl implements ReservoirService {
    @Autowired
    private ReservoirDao reservoirDao;
    @Autowired
    private SysAreaDao sysAreaDao;
    @Autowired
    private SysDictDao sysDictDao;

    @Override
    public List<ReservoirEntity> queryList(Map<String, Object> map) {
        List<ReservoirEntity> list = reservoirDao.queryList(map);

        for (ReservoirEntity entity : list) {
            entity.setAreaName(sysAreaDao.queryObject(entity.getAreaId()).getName());

            Map<String, Object> querymap = new HashMap();
            if (StringUtil.isEmpty(entity.getBuild())) {
                entity.setBuildName(null);
            } else {
                querymap.put("dictValue", entity.getBuild());
                querymap.put("dictType", "工程建设情况");
                entity.setBuildName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(entity.getReservoirLevel())) {
                entity.setReservoirLevelName(null);
            } else {
                querymap.put("dictValue", entity.getReservoirLevel());
                querymap.put("dictType", "工程等级");
                entity.setReservoirLevelName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(entity.getReservoirWork())) {
                entity.setReservoirWorkName(null);
            } else {
                querymap.put("dictValue", entity.getReservoirWork());
                querymap.put("dictType", "运行状况");
                entity.setReservoirWorkName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(entity.getReservoirType())) {
                entity.setReservoirTypeName(null);
            } else {
                querymap.put("dictValue", entity.getReservoirType());
                querymap.put("dictType", "水库类型");
                entity.setReservoirTypeName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(entity.getWaterLevel())) {
                entity.setWaterLevelName(null);
            } else {
                querymap.put("dictValue", entity.getWaterLevel());
                querymap.put("dictType", "水源地级别");
                entity.setWaterLevelName(sysDictDao.queryObject(querymap).getDictName());
            }
            if (StringUtil.isEmpty(entity.getScale())) {
                entity.setScaleName(null);
            } else {
                querymap.put("dictValue", entity.getScale());
                querymap.put("dictType", "工程规模");
                entity.setScaleName(sysDictDao.queryObject(querymap).getDictName());
            }

        }

        return list;
    }

    @Override
    public ReservoirEntity queryObject(String id) {
        return reservoirDao.queryObject(id);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return reservoirDao.queryTotal(map);
    }

    @Override
    public void save(ReservoirEntity reservoir) {
        reservoir.setId(UUID.randomUUID().toString());
        reservoirDao.save(reservoir);
    }

    @Override
    public void update(ReservoirEntity reservoir) {
        reservoirDao.update(reservoir);
    }

    @Override
    public void delete(String id) {
        reservoirDao.delete(id);
    }
}
