package com.khidi.manager.officework.service.impl;

import com.khidi.common.utils.DateUtils;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.officework.dao.ChecktaskDao;
import com.khidi.manager.officework.entity.CheckrouteEntity;
import com.khidi.manager.officework.entity.ChecktaskEntity;
import com.khidi.manager.officework.service.CheckrouteService;
import com.khidi.manager.officework.service.ChecktaskService;
import com.khidi.manager.officework.vo.ChecktaskEntityVo;
import com.khidi.manager.sys.service.CommonService;
import com.khidi.manager.sys.service.SysAreaService;
import com.khidi.manager.sys.service.SysDictService;
import com.khidi.manager.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import com.khidi.manager.officework.dao.ChecktaskdailyDao;
import com.khidi.manager.officework.entity.ChecktaskdailyEntity;
import com.khidi.manager.officework.service.ChecktaskdailyService;



@Service("checktaskdailyService")
public class ChecktaskdailyServiceImpl implements ChecktaskdailyService {
	@Autowired
	private ChecktaskdailyDao checktaskdailyDao;
	@Autowired
	private ChecktaskDao checktaskDao;
	@Autowired
	private CheckrouteService checkrouteService;
	@Autowired
	private SysDictService sysDictService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private SysAreaService sysAreaService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private ChecktaskService checktaskService;

	/**
	 * 根据传回的id查询出对应视图实体，查询出路线相关信息赋值给ChecktaskEntityVo返回
	 * @param id
	 * @return
	 */
	@Override
	public ChecktaskEntityVo queryObject(String id){
		ChecktaskdailyEntity entity = checktaskdailyDao.queryObject(id);
		ChecktaskEntityVo vo = new ChecktaskEntityVo();
		vo.setId(entity.getId());
		vo.setCode(entity.getCode());
		vo.setRouteid(entity.getRouteid());
		vo.setRouteName(checkrouteService.queryObject(entity.getRouteid()).getName());
		vo.setTimes(entity.getChecktimes()+entity.getUnit()+"一次");
		vo.setLastbegintime(entity.getLastbegintime());
		vo.setLastendtime(entity.getLastendtime());
		vo.setTaskSender(sysUserService.queryObject(entity.getTaskSender()).getName());
		vo.setStatus(entity.getStatus());
		vo.setBegintime(entity.getBegintime());
		vo.setEndtime(entity.getEndtime());
		vo.setCreatetime(entity.getCreatetime());
		vo.setChecker(entity.getChecker());
		vo.setUnit(entity.getUnit());
		vo.setChecktimes(entity.getChecktimes());
		vo.setCheckerName(findCheckerbyid(entity.getChecker()));
		return vo;
	}

	/**
	 * 对查询出的List中的实体分别再附上路线信息，以List<ChecktaskEntityVo>返回
	 * @param map
	 * @return
	 */
	@Override
	public List<ChecktaskEntityVo> queryList(Map<String, Object> map){
		List<ChecktaskdailyEntity> checktaskdailyList = checktaskdailyDao.queryList(map);
		List<ChecktaskEntityVo> resultList = new ArrayList<>();
		for(ChecktaskdailyEntity entity:checktaskdailyList){//遍历任务实体
			ChecktaskEntityVo vo = new ChecktaskEntityVo();//构造返回实体
			CheckrouteEntity route = checkrouteService.queryObject(entity.getRouteid());//获取路线实体
			vo.setId(entity.getId());
			vo.setCode(entity.getCode());
			vo.setRouteName(checkrouteService.queryObject(entity.getRouteid()).getName());
			vo.setResourceTypeName(sysDictService.typevalue4name("河湖类型",route.getResourcetype()));
			vo.setResourceName(commonService.getResource(route.getResourcetype(),route.getResourceid()));
			vo.setAreaName(sysAreaService.queryObject(route.getAreaid()).getName());
			vo.setStatr2End(route.getStartpoint()+"--"+route.getEndpoint());
			vo.setTimes(entity.getChecktimes()+sysDictService.typevalue4name("巡查频次",entity.getUnit())+"1次");
			vo.setLastbegintime(entity.getLastbegintime());
			vo.setLastendtime(entity.getLastendtime());
			vo.setTaskSender(sysUserService.queryObject(entity.getTaskSender()).getName());
			vo.setStatus(entity.getStatus());
			vo.setBegintime(entity.getBegintime());
			vo.setEndtime(entity.getEndtime());
			vo.setCreatetime(entity.getCreatetime());
			vo.setCheckerName(findCheckerbyid(entity.getChecker()));
			resultList.add(vo);
		}
	    return resultList;
	}


	/**
	 * 传入多个用户id，然后返回以空格隔开的对应姓名
	 * @param ids
	 * @return
	 */
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
		return checktaskdailyDao.queryTotal(map);
	}

	/**
	 * 每当生成一个日常巡查任务的时候，就按规则生成巡查任务
	 * @param checktaskdaily
	 */
	@Override
	public void save(ChecktaskdailyEntity checktaskdaily){
        checktaskdaily.setId(UUID.randomUUID().toString());
		checktaskdailyDao.save(checktaskdaily);
		LocalDateTime beginTime = LocalDateTime.ofInstant(checktaskdaily.getBegintime().toInstant(),ZoneId.systemDefault());//生成LocalDateTime
		LocalDateTime endTime = LocalDateTime.ofInstant(checktaskdaily.getEndtime().toInstant(),ZoneId.systemDefault());//生成LocalDateTime
		if(checktaskdaily.getUnit().equals("1")){   //小时
			while(endTime.isAfter(beginTime)){
				ChecktaskEntity checktaskEntity = new ChecktaskEntity();
				checktaskEntity.setDailyTaskId(checktaskdaily.getId());//前端显示系统编码
				checktaskEntity.setType("日常任务");//前端显示任务类型
				checktaskEntity.setStatus("等待");//前端显示任务状态
				checktaskEntity.setRouteid(checktaskdaily.getRouteid());//前端显示任务路线编码
				checktaskEntity.setChecker(checktaskdaily.getChecker());//前端显示巡查员姓名
				checktaskEntity.setTasksender(checktaskdaily.getTaskSender());//前端显示任务发布人
				checktaskEntity.setStartdate(Date.from(beginTime.atZone(ZoneId.systemDefault()).toInstant()));//前端显示任务开始时间
//				checktaskEntity.setLastStartDate(Date.from(beginTime.plusHours(Integer.valueOf(checktaskdaily.getChecktimes())).atZone(ZoneId.systemDefault()).toInstant()));//前端显示最迟开始时间
				checktaskEntity.setEnddate(Date.from(beginTime.plusHours(Integer.valueOf(checktaskdaily.getChecktimes())*2).atZone(ZoneId.systemDefault()).toInstant()));//前端显示结束时间
				checktaskService.save(checktaskEntity);//
				beginTime = beginTime.plusHours(Integer.valueOf(checktaskdaily.getChecktimes()));
			}
		}else if(checktaskdaily.getUnit().equals("2")){//日
			while(endTime.isAfter(beginTime)){
				ChecktaskEntity checktaskEntity = new ChecktaskEntity();
				checktaskEntity.setDailyTaskId(checktaskdaily.getId());
				checktaskEntity.setType("日常任务");
				checktaskEntity.setStatus("等待");
				checktaskEntity.setRouteid(checktaskdaily.getRouteid());
				checktaskEntity.setChecker(checktaskdaily.getChecker());
				checktaskEntity.setTasksender(checktaskdaily.getTaskSender());
				checktaskEntity.setStartdate(Date.from(beginTime.atZone(ZoneId.systemDefault()).toInstant()));
//				checktaskEntity.setLastStartDate(Date.from(beginTime.plusHours(Integer.valueOf(checktaskdaily.getChecktimes())).atZone(ZoneId.systemDefault()).toInstant()));
				checktaskEntity.setEnddate(Date.from(beginTime.plusDays(Integer.valueOf(checktaskdaily.getChecktimes())*2).atZone(ZoneId.systemDefault()).toInstant()));
				checktaskService.save(checktaskEntity);
				beginTime = beginTime.plusDays(Integer.valueOf(checktaskdaily.getChecktimes()));
			}
		}else if(checktaskdaily.getUnit().equals("3")){//周
			while(endTime.isAfter(beginTime)){
				ChecktaskEntity checktaskEntity = new ChecktaskEntity();
				checktaskEntity.setDailyTaskId(checktaskdaily.getId());
				checktaskEntity.setType("日常任务");
				checktaskEntity.setStatus("等待");
				checktaskEntity.setRouteid(checktaskdaily.getRouteid());
				checktaskEntity.setChecker(checktaskdaily.getChecker());
				checktaskEntity.setTasksender(checktaskdaily.getTaskSender());
				checktaskEntity.setStartdate(Date.from(beginTime.atZone(ZoneId.systemDefault()).toInstant()));
//				checktaskEntity.setLastStartDate(Date.from(beginTime.plusHours(Integer.valueOf(checktaskdaily.getChecktimes())).atZone(ZoneId.systemDefault()).toInstant()));
				checktaskEntity.setEnddate(Date.from(beginTime.plusWeeks(Integer.valueOf(checktaskdaily.getChecktimes())*2).atZone(ZoneId.systemDefault()).toInstant()));
				checktaskService.save(checktaskEntity);
				beginTime =	beginTime.plusWeeks(Integer.valueOf(checktaskdaily.getChecktimes()));
			}

		}else if(checktaskdaily.getUnit().equals("4")){//月
			while(endTime.isAfter(beginTime)){
				ChecktaskEntity checktaskEntity = new ChecktaskEntity();
				checktaskEntity.setDailyTaskId(checktaskdaily.getId());
				checktaskEntity.setType("日常任务");
				checktaskEntity.setStatus("等待");
				checktaskEntity.setRouteid(checktaskdaily.getRouteid());
				checktaskEntity.setChecker(checktaskdaily.getChecker());
				checktaskEntity.setTasksender(checktaskdaily.getTaskSender());
				checktaskEntity.setStartdate(Date.from(beginTime.atZone(ZoneId.systemDefault()).toInstant()));
//				checktaskEntity.setLastStartDate(Date.from(beginTime.plusHours(Integer.valueOf(checktaskdaily.getChecktimes())).atZone(ZoneId.systemDefault()).toInstant()));
				checktaskEntity.setEnddate(Date.from(beginTime.plusMonths(Integer.valueOf(checktaskdaily.getChecktimes())*2).atZone(ZoneId.systemDefault()).toInstant()));
				checktaskService.save(checktaskEntity);
				beginTime = beginTime.plusMonths(Integer.valueOf(checktaskdaily.getChecktimes()));
			}
		}
	}
	
	@Override
	public void update(ChecktaskdailyEntity checktaskdaily){
		checktaskDao.deleteByDailyTaskId(checktaskdaily.getId());
		checktaskdailyDao.update(checktaskdaily);
		LocalDateTime beginTime = LocalDateTime.ofInstant(checktaskdaily.getBegintime().toInstant(),ZoneId.systemDefault());//生成LocalDateTime
		LocalDateTime endTime = LocalDateTime.ofInstant(checktaskdaily.getEndtime().toInstant(),ZoneId.systemDefault());//生成LocalDateTime
		if(checktaskdaily.getUnit().equals("1")){   //小时
			while(endTime.isAfter(beginTime)){
				ChecktaskEntity checktaskEntity = new ChecktaskEntity();
				checktaskEntity.setDailyTaskId(checktaskdaily.getId());
				checktaskEntity.setType("日常任务");
				checktaskEntity.setStatus("等待");
				checktaskEntity.setRouteid(checktaskdaily.getRouteid());
				checktaskEntity.setChecker(checktaskdaily.getChecker());
				checktaskEntity.setTasksender(checktaskdaily.getTaskSender());
				checktaskEntity.setStartdate(Date.from(beginTime.atZone(ZoneId.systemDefault()).toInstant()));
//				checktaskEntity.setLastStartDate(Date.from(beginTime.plusHours(Integer.valueOf(checktaskdaily.getChecktimes())).atZone(ZoneId.systemDefault()).toInstant()));
				checktaskEntity.setEnddate(Date.from(beginTime.plusHours(Integer.valueOf(checktaskdaily.getChecktimes())*2).atZone(ZoneId.systemDefault()).toInstant()));
				checktaskService.save(checktaskEntity);
				beginTime = beginTime.plusHours(Integer.valueOf(checktaskdaily.getChecktimes()));
			}
		}else if(checktaskdaily.getUnit().equals("2")){//日
			while(endTime.isAfter(beginTime)){
				ChecktaskEntity checktaskEntity = new ChecktaskEntity();
				checktaskEntity.setDailyTaskId(checktaskdaily.getId());
				checktaskEntity.setType("日常任务");
				checktaskEntity.setStatus("等待");
				checktaskEntity.setRouteid(checktaskdaily.getRouteid());
				checktaskEntity.setChecker(checktaskdaily.getChecker());
				checktaskEntity.setTasksender(checktaskdaily.getTaskSender());
				checktaskEntity.setStartdate(Date.from(beginTime.atZone(ZoneId.systemDefault()).toInstant()));
//				checktaskEntity.setLastStartDate(Date.from(beginTime.plusHours(Integer.valueOf(checktaskdaily.getChecktimes())).atZone(ZoneId.systemDefault()).toInstant()));
				checktaskEntity.setEnddate(Date.from(beginTime.plusDays(Integer.valueOf(checktaskdaily.getChecktimes())*2).atZone(ZoneId.systemDefault()).toInstant()));
				checktaskService.save(checktaskEntity);
				beginTime = beginTime.plusDays(Integer.valueOf(checktaskdaily.getChecktimes()));
			}
		}else if(checktaskdaily.getUnit().equals("3")){//周
			while(endTime.isAfter(beginTime)){
				ChecktaskEntity checktaskEntity = new ChecktaskEntity();
				checktaskEntity.setDailyTaskId(checktaskdaily.getId());
				checktaskEntity.setType("日常任务");
				checktaskEntity.setStatus("等待");
				checktaskEntity.setRouteid(checktaskdaily.getRouteid());
				checktaskEntity.setChecker(checktaskdaily.getChecker());
				checktaskEntity.setTasksender(checktaskdaily.getTaskSender());
				checktaskEntity.setStartdate(Date.from(beginTime.atZone(ZoneId.systemDefault()).toInstant()));
//				checktaskEntity.setLastStartDate(Date.from(beginTime.plusHours(Integer.valueOf(checktaskdaily.getChecktimes())).atZone(ZoneId.systemDefault()).toInstant()));
				checktaskEntity.setEnddate(Date.from(beginTime.plusWeeks(Integer.valueOf(checktaskdaily.getChecktimes())*2).atZone(ZoneId.systemDefault()).toInstant()));
				checktaskService.save(checktaskEntity);
				beginTime =	beginTime.plusWeeks(Integer.valueOf(checktaskdaily.getChecktimes()));
			}

		}else if(checktaskdaily.getUnit().equals("4")){//月
			while(endTime.isAfter(beginTime)){
				ChecktaskEntity checktaskEntity = new ChecktaskEntity();
				checktaskEntity.setDailyTaskId(checktaskdaily.getId());
				checktaskEntity.setType("日常任务");
				checktaskEntity.setStatus("等待");
				checktaskEntity.setRouteid(checktaskdaily.getRouteid());
				checktaskEntity.setChecker(checktaskdaily.getChecker());
				checktaskEntity.setTasksender(checktaskdaily.getTaskSender());
				checktaskEntity.setStartdate(Date.from(beginTime.atZone(ZoneId.systemDefault()).toInstant()));
//				checktaskEntity.setLastStartDate(Date.from(beginTime.plusHours(Integer.valueOf(checktaskdaily.getChecktimes())).atZone(ZoneId.systemDefault()).toInstant()));
				checktaskEntity.setEnddate(Date.from(beginTime.plusMonths(Integer.valueOf(checktaskdaily.getChecktimes())*2).atZone(ZoneId.systemDefault()).toInstant()));
				checktaskService.save(checktaskEntity);
				beginTime = beginTime.plusMonths(Integer.valueOf(checktaskdaily.getChecktimes()));
			}
		}

	}

	@Override
	public void delete(String id){
		checktaskDao.deleteByDailyTaskId(id);
		checktaskdailyDao.delete(id);
	}
}