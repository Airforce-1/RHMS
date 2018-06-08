package com.khidi.manager.maintask.service.impl;

import com.khidi.common.utils.CurrentSession;
import com.khidi.common.utils.DateUtils;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.basicinfo.dao.*;
import com.khidi.manager.basicinfo.entity.ResourcePublicitycardEntity;
import com.khidi.manager.maintask.entity.StTaskdetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.maintask.dao.StTaskDao;
import com.khidi.manager.maintask.entity.StTaskEntity;
import com.khidi.manager.maintask.service.StTaskService;


@Service("stTaskService")
public class StTaskServiceImpl implements StTaskService {
    @Autowired
    private StTaskDao stTaskDao;
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


    @Override
    public StTaskEntity queryObject(String id) {
        return stTaskDao.queryObject(id);
    }

    @Override
    public List<StTaskEntity> queryList(Map<String, Object> map) {
        return stTaskDao.queryList(map);
    }

    @Override
    public List<StTaskdetailEntity> queryTaskDetailByTaskId(String StTaskId) {
        return stTaskDao.queryTaskDetailByTaskId(StTaskId);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return stTaskDao.queryTotal(map);
    }

    @Override
    public void save(StTaskEntity stTask) {
        stTask.setId(UUID.randomUUID().toString());
        stTask.setXddept(CurrentSession.GetDeptId());
        stTaskDao.save(stTask);
    }

    @Override
    public void update(StTaskEntity stTask) {
        stTaskDao.update(stTask);
    }

    @Override
    public void delete(String id) {
        stTaskDao.delete(id);
    }
}
