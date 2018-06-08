package com.khidi.manager.maintask.service.impl;


import com.khidi.common.utils.CurrentSession;
import com.khidi.manager.maintask.dao.*;
import com.khidi.manager.maintask.entity.*;
import com.khidi.manager.maintask.service.StTargetdetailTransmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.maintask.service.StProcessDetailService;



@Service("stProcessDetailService")
public class StProcessDetailServiceImpl implements StProcessDetailService {
	@Autowired
	private StProcessDetailDao stProcessDetailDao;
	@Autowired
	private StTargetDao stTargetDao;
	@Autowired
	private StTargetdetailDao stTargetdetailDao;
	@Autowired
	private StTaskDao stTaskDao;
	@Autowired
	private StTaskdetailDao stTaskdetailDao;
	@Autowired
	private StSubtaskprogressDao stSubtaskprogressDao;

	@Override
	public StProcessDetailEntity queryObject(String id){
		return stProcessDetailDao.queryObject(id);
	}
	
	@Override
	public List<StProcessDetailEntity> queryList(Map<String, Object> map){
	    return stProcessDetailDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return stProcessDetailDao.queryTotal(map);
	}
	
	@Override
	public void save(StProcessDetailEntity stProcessDetail){
        stProcessDetail.setId(UUID.randomUUID().toString());
        stProcessDetail.setCreateuserid(CurrentSession.GetUserId());
		stProcessDetail.setCreatedeptid(CurrentSession.GetDeptId());
		stProcessDetailDao.save(stProcessDetail);

		if (stProcessDetail.getObjtype() == 1) {   //目标进度
			StTargetEntity entity = stTargetDao.queryObject(stProcessDetail.getTargetid());
			entity.setProgress(stProcessDetail.getProgress());
			stTargetDao.update(entity);
		}else	if (stProcessDetail.getObjtype() == 2) {   //任务进度
			StTaskEntity entity = stTaskDao.queryObject(stProcessDetail.getTaskid());
			entity.setProgress(stProcessDetail.getProgress());
			stTaskDao.update(entity);
		}else	if (stProcessDetail.getObjtype()==3) {   //目标明细进度
			StTargetdetailEntity entity = stTargetdetailDao.queryObject(stProcessDetail.getTargetDetailId());
			entity.setProgress(stProcessDetail.getProgress());
			stTargetdetailDao.update(entity);
		}else	if (stProcessDetail.getObjtype()==4) {   //任务明细进度
			StTaskdetailEntity entity = stTaskdetailDao.queryObject(stProcessDetail.getTaskDetailId());
			entity.setProgress(stProcessDetail.getProgress());
			stTaskdetailDao.update(entity);
		}else	if (stProcessDetail.getObjtype()==5) {   //计划任务进度
			StSubtaskprogressEntity entity = stSubtaskprogressDao.queryObject(stProcessDetail.getTaskdetailSubtaskId());
			entity.setProgress(stProcessDetail.getProgress());
			stSubtaskprogressDao.update(entity);
		}
	}
	
	@Override
	public void update(StProcessDetailEntity stProcessDetail){
		stProcessDetailDao.update(stProcessDetail);
	}
	
	@Override
	public void delete(String id){
		stProcessDetailDao.delete(id);
	}
}
