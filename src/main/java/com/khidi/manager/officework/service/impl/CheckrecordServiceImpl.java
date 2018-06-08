package com.khidi.manager.officework.service.impl;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.officework.dao.CheckrouteDao;
import com.khidi.manager.officework.dao.ChecktaskDao;
import com.khidi.manager.officework.entity.CheckrouteEntity;
import com.khidi.manager.officework.entity.ChecktaskEntity;
import com.khidi.manager.officework.vo.CheckRecordVo;
import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.dao.SysDictDao;
import com.khidi.manager.sys.service.CommonService;
import com.khidi.manager.sys.service.SysDictService;
import com.khidi.manager.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.officework.dao.CheckrecordDao;
import com.khidi.manager.officework.entity.CheckrecordEntity;
import com.khidi.manager.officework.service.CheckrecordService;



@Service("checkrecordService")
public class CheckrecordServiceImpl implements CheckrecordService {
	@Autowired
	private CheckrecordDao checkrecordDao;
	@Autowired
	private CheckrouteDao checkrouteDao;
	@Autowired
	private ChecktaskDao checktaskDao;
	@Autowired
	private SysDictService sysDictService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysAreaDao sysAreaDao;
	
	@Override
	public CheckrecordEntity queryObject(String id){
		return checkrecordDao.queryObject(id);
	}
	
	@Override
	public List<CheckRecordVo> queryList(Map<String, Object> map){
		List<CheckrecordEntity> tempList = checkrecordDao.queryList(map);
		List<CheckRecordVo> resultList =new ArrayList<>();
		for(CheckrecordEntity entity:tempList){
			CheckRecordVo vo = new CheckRecordVo();
			ChecktaskEntity task = checktaskDao.queryObject(entity.getTaskid());
			CheckrouteEntity route = checkrouteDao.queryObject(task.getRouteid());
			entity.setEventids(String.valueOf(StringUtil.getCount(entity.getEventids())));
			vo.SetCheckrecordEntity(entity);
			vo.setRouteName(route.getName());//根据任务id查找路线id查找路线名称
			vo.setResourceTypeName(sysDictService.typevalue4name("河湖类型",route.getResourcetype()));//河湖类型
			vo.setResourceName(commonService.getResource(route.getResourcetype(),route.getResourceid()));//河湖名称
			vo.setCheckerName(findCheckerbyid(task.getChecker()));//生成巡查员
			vo.setTaskStartDate(task.getStartdate());    //任务开始时间
			vo.setTaskEndDate(task.getEnddate());         //任务结束时间
			vo.setAreaName(sysAreaDao.queryObject(route.getAreaid()).getName());
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
		return checkrecordDao.queryTotal(map);
	}
	
	@Override
	public void save(CheckrecordEntity checkrecord){
        checkrecord.setId(UUID.randomUUID().toString());
		checkrecordDao.save(checkrecord);
	}
	
	@Override
	public void update(CheckrecordEntity checkrecord){
		checkrecordDao.update(checkrecord);
	}
	
	@Override
	public void delete(String id){
		checkrecordDao.delete(id);
	}
}
