package com.khidi.manager.officework.controller;

import com.khidi.common.utils.*;
import com.khidi.manager.officework.vo.ChecktaskEntityVo;
import com.khidi.common.exception.RRException;
import com.khidi.manager.sys.controller.AbstractController;
import org.apache.commons.lang.StringUtils;

import java.util.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.khidi.manager.officework.entity.ChecktaskEntity;
import com.khidi.manager.officework.service.ChecktaskService;


/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-25 15:53:29
 */
@RestController
@RequestMapping("checktask")
@Api(value = "/Checktask", description = "巡查任务管理")
public class ChecktaskController extends AbstractController{
	@Autowired
	private ChecktaskService checktaskService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("巡查任务:查看")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="routeid",required=false) String routeid,
				  @RequestParam(value="areaid",required=false) String areaid,
                  @RequestParam(value="checker",required=false) String checker,
                  @RequestParam(value="startdate",required=false) Date startdate,
                  @RequestParam(value="enddate",required=false) Date enddate,
                  @RequestParam(value="createtime",required=false) Date createtime,
                  @RequestParam(value="type",required=false) String type,
                  @RequestParam(value="tasksender",required=false) String tasksender,
				  @RequestParam(value="begintime4start",required=false) String begintime4start,
				  @RequestParam(value="begintime4end",required=false) String begintime4end,
				  @RequestParam(value="createtime4start",required=false) String createtime4start,
				  @RequestParam(value="createtime4end",required=false) String createtime4end,
				  @RequestParam(value="resourceName",required=false) String resourceName,
                  @RequestParam(value="status",required=false) String status				  ){
        Map<String,Object> queryparams = new HashMap<String,Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
		if(id != null){
    	queryparams.put("id",id);
		}
		if(routeid != null){
    	queryparams.put("routeid",routeid);
		}

		if(checker != null){
    	queryparams.put("checker",checker);
		}

		if(resourceName != null){
			queryparams.put("resourceName",resourceName);
		}
		if(startdate != null){
			queryparams.put("startdate",startdate);
		}
		if(enddate != null){
    	queryparams.put("enddate",enddate);
		}
		if(createtime != null){
    	queryparams.put("createtime",createtime);
		}
		if(type != null){
    	queryparams.put("type",type);
		}
		if(areaid != null){
			queryparams.put("areaid",areaid);
		}
		if(tasksender != null){
    	queryparams.put("tasksender",tasksender);
		}
		if(status != null){
    	queryparams.put("status",status);//状态
		}
		if(begintime4start != null){
			queryparams.put("begintime4start", DateUtils.stringToDate(begintime4start,"yyyy-MM-dd HH:mm:ss"));//开始时间4start
		}
		if(begintime4end != null){
			queryparams.put("begintime4end", DateUtils.stringToDate(begintime4end,"yyyy-MM-dd HH:mm:ss"));//开始时间4end
		}
		if(createtime4start != null){
			queryparams.put("createtime4start", DateUtils.stringToDate(createtime4start,"yyyy-MM-dd HH:mm:ss"));//任务发布时间4start
		}
		if(createtime4end != null){
			queryparams.put("createtime4end", DateUtils.stringToDate(createtime4end,"yyyy-MM-dd HH:mm:ss"));//任务发布时间4end
		}
		Query query = new Query(queryparams);
		//加入用户id过滤出该用户的巡查任务
		query.put("userId",getUserId());

		List<ChecktaskEntityVo> checktaskList = checktaskService.queryList(query);
		int total = checktaskService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(checktaskList, total, query.getLimit(), query.getPage());
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("巡查任务:查看")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		return R.ok().put("data", checktaskService.queryObject(id));
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("巡查任务:管理")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody ChecktaskEntity checktask){
        verifyForm(checktask);
		checktask.setTasksender(getUserId());
		checktask.setType("临时任务");
		checktaskService.save(checktask);

		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("巡查任务:管理")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody ChecktaskEntity checktask){
        verifyForm(checktask);
		checktaskService.update(checktask);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("巡查任务:管理")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				checktaskService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(ChecktaskEntity checktask){
	        if(StringUtils.isBlank(checktask.getRouteid())){
            throw new RRException(270,"巡查路线编码不能为空");
		}
	        if(StringUtils.isBlank(checktask.getChecker())){
            throw new RRException(270,"巡查员编码不能为空");
		}
	        if(checktask.getStartdate() == null){
            throw new RRException(270,"巡查开始时间不能为空");
		}
	        if(checktask.getEnddate() == null){
            throw new RRException(270,"巡查结束时间不能为空");
		}
	}


}