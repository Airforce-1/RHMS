package com.khidi.manager.officework.service.impl;

import com.khidi.common.utils.DateUtils;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.officework.entity.CheckrouteEntity;
import com.khidi.manager.officework.service.CheckrouteService;
import com.khidi.manager.officework.vo.ChecktaskEntityVo;
import com.khidi.manager.sys.service.CommonService;
import com.khidi.manager.sys.service.SysAreaService;
import com.khidi.manager.sys.service.SysDictService;
import com.khidi.manager.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.khidi.manager.officework.dao.ChecktaskDao;
import com.khidi.manager.officework.entity.ChecktaskEntity;
import com.khidi.manager.officework.service.ChecktaskService;



@Service("checktaskService")
public class ChecktaskServiceImpl implements ChecktaskService {
	@Autowired
	private ChecktaskDao checktaskDao;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private CheckrouteService checkrouteService;
	@Autowired
	private SysDictService sysDictService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private SysAreaService sysAreaService;
	@Override
	public ChecktaskEntityVo queryObject(String id){
		ChecktaskEntity entity = checktaskDao.queryObject(id);
		ChecktaskEntityVo vo = new ChecktaskEntityVo();//构造返回实体
		CheckrouteEntity route = checkrouteService.queryObject(entity.getRouteid());//获取路线实体
		vo.setId(entity.getId());
		vo.setChecker(entity.getChecker());
		vo.setRouteid(entity.getRouteid());
		vo.setRouteName(checkrouteService.queryObject(entity.getRouteid()).getName());//路线名称
		vo.setResourceTypeName(sysDictService.typevalue4name("河湖类型",route.getResourcetype()));//河湖类型
		vo.setResourceName(commonService.getResource(route.getResourcetype(),route.getResourceid()));//河湖名称
		vo.setAreaName(sysAreaService.queryObject(route.getAreaid()).getName());//行政区划名称
		vo.setStatr2End(route.getStartpoint()+"--"+route.getEndpoint());//起止位置
		vo.setTaskSender(sysUserService.queryObject(entity.getTasksender()).getName());//任务发布人
		vo.setLastbegintime(DateUtils.format(entity.getLastStartDate(),"yyyy-MM-dd HH:mm:ss"));
		vo.setStatus(entity.getStatus());//任务状态
		vo.setBegintime(entity.getStartdate());//任务开始时间
		vo.setEndtime(entity.getEnddate());//任务结束时间
		vo.setCreatetime(entity.getCreatetime());//任务发布时间
		vo.setCheckerName(findCheckerbyid(entity.getChecker()));//巡查员
		vo.setType(entity.getType());
		if(entity.getStatus().equals("已完成") || entity.getStatus().equals("缺勤")|| entity.getStatus().equals("进行中")){
			vo.setStatus(entity.getStatus());
		}else{
			if(entity.getEnddate().before(new Date())){
				vo.setStatus("缺勤");
				entity.setStatus("缺勤");
				update(entity);
			}else{
				vo.setStatus("等待");
			}
		}
		return vo;
	}
	
	@Override
	public List<ChecktaskEntityVo> queryList(Map<String, Object> map){
		List<ChecktaskEntity> checktaskList = checktaskDao.queryList(map);
		List<ChecktaskEntityVo> resultList = new ArrayList<>();
		for(ChecktaskEntity entity:checktaskList){//遍历任务实体
			ChecktaskEntityVo vo = new ChecktaskEntityVo();//构造返回实体
			CheckrouteEntity route = checkrouteService.queryObject(entity.getRouteid());//获取路线实体
			vo.setId(entity.getId());
			vo.setRouteid(entity.getRouteid());
			vo.setRouteName(checkrouteService.queryObject(entity.getRouteid()).getName());//路线名称
			vo.setResourceTypeName(sysDictService.typevalue4name("河湖类型",route.getResourcetype()));//河湖类型
			vo.setResourceName(commonService.getResource(route.getResourcetype(),route.getResourceid()));//河湖名称
			vo.setAreaName(sysAreaService.queryObject(route.getAreaid()).getName());//行政区划名称
			vo.setStatr2End(route.getStartpoint()+"--"+route.getEndpoint());//起止位置
			vo.setTaskSender(sysUserService.queryObject(entity.getTasksender()).getName());//任务发布人
			vo.setLastbegintime(DateUtils.format(entity.getLastStartDate(),"yyyy-MM-dd HH:mm:ss"));
			vo.setStatus(entity.getStatus());//任务状态
			vo.setBegintime(entity.getStartdate());//任务开始时间
			vo.setEndtime(entity.getEnddate());//任务结束时间
			vo.setCreatetime(entity.getCreatetime());//任务发布时间
			vo.setCheckerName(findCheckerbyid(entity.getChecker()));//巡查员
			vo.setType(entity.getType()); //任务类型
			vo.setFeatureId(entity.getFeatureId());
			vo.setResourceId(entity.getResourceId());
			vo.setResourceType(entity.getResourceType());
			if(entity.getStatus().equals("已完成") || entity.getStatus().equals("缺勤")|| entity.getStatus().equals("进行中")){
				vo.setStatus(entity.getStatus());
			}else{
				if(entity.getEnddate().before(new Date())){
					vo.setStatus("缺勤");
					entity.setStatus("缺勤");
					update(entity);
				}else{
					vo.setStatus("等待");
				}
			}

			vo.setStatus(entity.getStatus());
			resultList.add(vo);
		}
		return resultList;
	}


	public String findCheckerbyid(String ids){
		List<String> idList = StringUtil.arrays2List(ids);
		StringBuilder resultString = new StringBuilder();
		for(String id:idList){
			resultString = resultString.append(" "+sysUserService.queryObject(id).getName());
		}
		return resultString.toString().substring(1,resultString.length());
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return checktaskDao.queryTotal(map);
	}
	
	@Override
	public void save(ChecktaskEntity checktask){
        checktask.setId(UUID.randomUUID().toString());
		checktask.setStatus("等待");
		checktaskDao.save(checktask);
	}
	
	@Override
	public void update(ChecktaskEntity checktask){
		checktaskDao.update(checktask);
	}
	
	@Override
	public void delete(String id){
		checktaskDao.delete(id);
	}
}
