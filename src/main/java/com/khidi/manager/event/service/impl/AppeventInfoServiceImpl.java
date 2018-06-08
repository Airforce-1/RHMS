package com.khidi.manager.event.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.khidi.manager.event.dao.AppeventInfoDao;
import com.khidi.manager.event.entity.AppentReportEntity;
import com.khidi.manager.event.entity.AppeventAttinfoEntity;
import com.khidi.manager.event.entity.AppeventInfoEntity;
import com.khidi.manager.event.entity.AppeventStepsEntity;
import com.khidi.manager.event.service.AppentReportService;
import com.khidi.manager.event.service.AppeventAttinfoService;
import com.khidi.manager.event.service.AppeventInfoService;
import com.khidi.manager.event.service.AppeventStepsService;



@Service("appeventInfoService")
public class AppeventInfoServiceImpl implements AppeventInfoService {
	@Autowired
	private AppeventInfoDao appeventInfoDao;
	@Autowired
	private AppentReportService appentReportService;
	@Autowired
	private AppeventStepsService appeventStepsService;
	@Autowired
	private AppeventAttinfoService appeventAttinfoService;
	
	
	@Override
	public AppeventInfoEntity queryObject(String id){
		return appeventInfoDao.queryObject(id);
	}
	
	@Override
	public List<AppeventInfoEntity> queryList(Map<String, Object> map){
	    return appeventInfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return appeventInfoDao.queryTotal(map);
	}
	
	@Override
	public void save(AppeventInfoEntity appeventInfo){
        String eid = UUID.randomUUID().toString();
        String eventFlowId = UUID.randomUUID().toString();
        String eventReportId = UUID.randomUUID().toString();
        //
        appeventInfo.setId(eid);
		appeventInfoDao.save(appeventInfo);
		//存入事件上报信息表
		AppentReportEntity appentReport = new AppentReportEntity();
		appentReport.setId(eventReportId);
		appentReport.setEid(eid);
		appentReport.setCreatetime(appeventInfo.getCreatetime());
		Date date = appeventInfo.getCreatetime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		appentReport.setGrpid(sdf.format(date));
		appentReport.setEflowid(eventFlowId);
		appentReport.setDelind(appeventInfo.getDelind());
		appentReport.setDwuser(appeventInfo.getDwuserid());
		appentReportService.save(appentReport);
		//String appentReportId = appentReportServiceImpl.getId();
		//存入事件流转信息中间表
		AppeventStepsEntity appeventSteps = new AppeventStepsEntity();
		appeventSteps.setId(eventFlowId);
		appeventSteps.setEsteptype(appeventInfo.getEsteptype());
		appeventSteps.setReportid(eventReportId);
		appeventSteps.setEid(eid);
		appeventSteps.setGrpid(sdf.format(date));
		appeventStepsService.save(appeventSteps);
		//存入事件的附件信息表
//		AppeventAttinfoEntity appeventAttinfo = new AppeventAttinfoEntity();
//		appeventAttinfo.setEid(eid);
//		appeventAttinfo.setAttid(appeventInfo.getAttid());
//		appeventAttinfoService.save(appeventAttinfo);
		List<AppeventAttinfoEntity> attachments = appeventInfo.getAttachments();
		//多附件处理
		if( attachments != null && attachments.size() > 0)
		{
			for(AppeventAttinfoEntity att : attachments)
			{
				AppeventAttinfoEntity appeventAttinfo = new AppeventAttinfoEntity();
				appeventAttinfo.setId(UUID.randomUUID().toString());
				appeventAttinfo.setEid(eid);
				appeventAttinfo.setAttname(att.getAttname());
				appeventAttinfo.setAttext(att.getAttext());
				appeventAttinfo.setAttrelativepath(att.getAttrelativepath());
				appeventAttinfo.setAttid(att.getAttid());
				appeventAttinfoService.save(appeventAttinfo);
			}
		}
	}
	
	@Override
	public void update(AppeventInfoEntity appeventInfo){
		appeventInfoDao.update(appeventInfo);
	}
	
	@Override
	public void delete(String id){
		appeventInfoDao.delete(id);
	}
}
