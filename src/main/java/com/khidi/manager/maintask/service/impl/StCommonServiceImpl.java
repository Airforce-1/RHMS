package com.khidi.manager.maintask.service.impl;

import com.khidi.manager.maintask.dao.StTargetDao;
import com.khidi.manager.maintask.dao.StTargetdetailDao;
import com.khidi.manager.maintask.dao.StTaskdetailDao;
import com.khidi.manager.maintask.entity.*;
import com.khidi.manager.maintask.service.StCommonService;
import com.khidi.manager.sys.dao.SysDeptDao;
import com.khidi.manager.sys.entity.SysDeptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2018/1/22.
 */
@Service("StCommonService")
public class StCommonServiceImpl implements StCommonService {
    @Autowired
    private StTaskdetailDao stTaskdetailDao;
    @Autowired
    private SysDeptDao deptDao;
    @Autowired
    private StTargetdetailDao stTargetdetailDao ;
    @Autowired
    private StTargetDao stTargetDao;

    @Override
    public List<StTaskdetailTransmitEntity> queryTaskdetailTransmitByTaskdetailId(String TaskdetailId) {
        List<StTaskdetailTransmitEntity>  list = stTaskdetailDao.queryTaskdetailTransmitByTaskdetailId(TaskdetailId);
        for(StTaskdetailTransmitEntity entity : list)
        {
            String transmitDeptId   = entity.getTransmitDeptid() ;
            SysDeptEntity deptEntity = deptDao.queryObject(transmitDeptId) ;
            entity.setTransmitDeptName(deptEntity.getName());

            entity.setTodeptName(deptDao.queryObject(entity.getTodeptid()).getName());
        }
        return list;
    }

    @Override
    public List<StSubtaskprogressEntity> querySubtaskprogressByTaskdetailId(String subtaskid) {
        return stTaskdetailDao.querySubtaskprogressByTaskdetailId(subtaskid);
    }

    @Override
    public List<StTaskdetailEntity> queryTaskdetailListByTaskId(String taskId) {
        return stTaskdetailDao.queryTaskdetailListByTaskId(taskId);
    }

    @Override
    public List<StTargetdetailTransmitEntity> queryTargetdetailTransmitByTargetedtailId(String TargetedtailId) {
    	 List<StTargetdetailTransmitEntity>  list = stTargetdetailDao.queryTargetdetailTransmitByTargetedtailId(TargetedtailId);
         for(StTargetdetailTransmitEntity entity : list)
         {
             entity.setTodeptName(deptDao.queryObject(entity.getTodeptid()).getName());
         }
        return list;
    }

    @Override
    public List<StTargetdetailEntity> queryTargetdetailByTargetId(String TargetId){
        List<StTargetdetailEntity>  list = stTargetDao.queryTargetdetailByTargetId(TargetId);
        for(StTargetdetailEntity entity : list)
        {
            entity.setRespdeptName(deptDao.queryObject(entity.getRespdept()).getName());
        }
        return list;
    }
}
