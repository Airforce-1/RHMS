package com.khidi.manager.maintask.service.impl;

import com.khidi.common.utils.CurrentSession;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.basicinfo.dao.*;
import com.khidi.manager.maintask.entity.StTargetdetailEntity;
import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.dao.SysDeptDao;
import com.khidi.manager.sys.dao.SysDictDao;
import com.khidi.manager.sys.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.maintask.dao.StTargetDao;
import com.khidi.manager.maintask.entity.StTargetEntity;
import com.khidi.manager.maintask.service.StTargetService;


@Service("stTargetService")
public class StTargetServiceImpl implements StTargetService {
    @Autowired
    private StTargetDao stTargetDao;
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
    public StTargetEntity queryObject(String id) {
        return stTargetDao.queryObject(id);
    }

    @Override
    public List<StTargetEntity> queryList(Map<String, Object> map) {
        List<StTargetEntity> list = stTargetDao.queryList(map);
        for (int i = 0; i < list.size(); i++) {
            if (StringUtil.isEmpty(list.get(i).getLaketype())) {
                list.get(i).setLakeName(null);
            } else if (StringUtil.isEmpty(list.get(i).getLakeid())) {
                list.get(i).setLakeName(null);
            } else if (list.get(i).getLaketype().equals("1")) {   //河流
                list.get(i).setLakeName(riverDao.queryObject(list.get(i).getLakeid()).getName());
            } else if (list.get(i).getLaketype().equals("2")) {    //河段
                list.get(i).setLakeName(partRiverDao.queryObject(list.get(i).getLakeid()).getName());
            } else if (list.get(i).getLaketype().equals("3")) {    //渠道
                list.get(i).setLakeName(canalDao.queryObject(list.get(i).getLakeid()).getName());
            } else if (list.get(i).getLaketype().equals("4")) {    //渠段
                list.get(i).setLakeName(partCanalDao.queryObject(list.get(i).getLakeid()).getName());
            } else if (list.get(i).getLaketype().equals("5")) {  //湖泊
                list.get(i).setLakeName(lakeDao.queryObject(list.get(i).getLakeid()).getName());
            } else if (list.get(i).getLaketype().equals("6")) {    //湖段
                list.get(i).setLakeName(partLakeDao.queryObject(list.get(i).getLakeid()).getName());
            } else if (list.get(i).getLaketype().equals("7")) {   //水库
                list.get(i).setLakeName(reservoirDao.queryObject(list.get(i).getLakeid()).getName());
            } else if (list.get(i).getLaketype().equals("8")) {    //库段
                list.get(i).setLakeName(partReservoirDao.queryObject(list.get(i).getLakeid()).getName());
            }
        }
//        return list;
        return stTargetDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return stTargetDao.queryTotal(map);
    }

    @Override
    public void save(StTargetEntity stTarget) {
        stTarget.setId(UUID.randomUUID().toString());
        stTarget.setXddept( CurrentSession.GetDeptId());
        stTargetDao.save(stTarget);
    }

    @Override
    public void update(StTargetEntity stTarget) {
        stTargetDao.update(stTarget);
    }

    @Override
    public void delete(String id) {
        stTargetDao.delete(id);
    }


}
