package com.khidi.manager.maintask.service.impl;

import com.khidi.common.utils.CurrentSession;
import com.khidi.manager.maintask.dao.StTargetdetailDao;
import com.khidi.manager.maintask.dao.StTaskdetailDao;
import com.khidi.manager.maintask.entity.StTaskdetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.maintask.dao.StTaskdetailTransmitDao;
import com.khidi.manager.maintask.entity.StTaskdetailTransmitEntity;
import com.khidi.manager.maintask.service.StTaskdetailTransmitService;


@Service("stTaskdetailTransmitService")
public class StTaskdetailTransmitServiceImpl implements StTaskdetailTransmitService {
    @Autowired
    private StTaskdetailTransmitDao stTaskdetailTransmitDao;
    @Autowired
    private StTaskdetailDao stTaskdetailDao;

    @Override
    public StTaskdetailTransmitEntity queryObject(String id) {
        return stTaskdetailTransmitDao.queryObject(id);
    }

    @Override
    public List<StTaskdetailTransmitEntity> queryList(Map<String, Object> map) {
        return stTaskdetailTransmitDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return stTaskdetailTransmitDao.queryTotal(map);
    }

    @Override
    public void save(StTaskdetailTransmitEntity stTaskdetailTransmit) {
        stTaskdetailTransmit.setId(UUID.randomUUID().toString());
        stTaskdetailTransmit.setTransmitDeptid(CurrentSession.GetDeptId());
        stTaskdetailTransmit.setTransmitUserid(CurrentSession.GetUserId());
        stTaskdetailTransmitDao.save(stTaskdetailTransmit);

        StTaskdetailEntity entity = stTaskdetailDao.queryObject(stTaskdetailTransmit.getTaskdetailid());
        entity.setTodeptid(stTaskdetailTransmit.getTodeptid());
        entity.setTransmitDeptid(stTaskdetailTransmit.getTransmitDeptid());
        entity.setTransmituserid(stTaskdetailTransmit.getTransmitUserid());
        entity.setTransmittime(new Date());
        stTaskdetailDao.update(entity);
    }

    @Override
    public void update(StTaskdetailTransmitEntity stTaskdetailTransmit) {
        StTaskdetailEntity stTaskdetailEntity = new StTaskdetailEntity();
        stTaskdetailDao.update(stTaskdetailEntity);
        stTaskdetailTransmitDao.update(stTaskdetailTransmit);
    }

    @Override
    public void delete(String id) {
        stTaskdetailTransmitDao.delete(id);
    }
}
