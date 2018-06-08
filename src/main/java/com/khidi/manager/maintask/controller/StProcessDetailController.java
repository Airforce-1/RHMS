package com.khidi.manager.maintask.controller;

import io.swagger.annotations.ApiParam;
import com.khidi.common.exception.RRException;
import org.apache.commons.lang.StringUtils;
import java.util.List;
import java.util.Map;
import java.util.Date;
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

import com.khidi.manager.maintask.entity.StProcessDetailEntity;
import com.khidi.manager.maintask.service.StProcessDetailService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;




/**
 * 六大任务进度管理
 * 
 * @author fdz
 * @email 592926573@qq.com
 * @date 2018-01-10 15:36:28
 */
@RestController
@RequestMapping("stprocessdetail")
@Api(value = "/StProcessDetail", description = "六大任务进度管理")
public class StProcessDetailController {
	@Autowired
	private StProcessDetailService stProcessDetailService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
//	@RequiresPermissions("六大任务:查看")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="targetid",required=false) String targetid,
                  @RequestParam(value="taskid",required=false) String taskid,
                  @RequestParam(value="targetDetailId",required=false) String targetDetailId,
                  @RequestParam(value="taskDetailId",required=false) String taskDetailId,
                  @RequestParam(value="taskdetailSubtaskId",required=false) Double taskdetailSubtaskId,
                  @RequestParam(value="objtype",required=false) Double objtype,
                  @RequestParam(value="progress",required=false) Double progress,
                  @RequestParam(value="createuserid",required=false) String createuserid,
                  @RequestParam(value="createdeptid",required=false) String createdeptid,
                  @RequestParam(value="memo",required=false) String memo				  ){
        Map<String,Object> queryparams = new HashMap<String,Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
		if(id != null){
    	queryparams.put("id",id);
		}
		if(targetid != null){
    	queryparams.put("targetid",targetid);
		}
		if(taskid != null){
    	queryparams.put("taskid",taskid);
		}
		if(targetDetailId != null){
    	queryparams.put("targetDetailId",targetDetailId);
		}
		if(taskDetailId != null){
    	queryparams.put("taskDetailId",taskDetailId);
		}
		if(taskdetailSubtaskId != null){
    	queryparams.put("taskdetailSubtaskId",taskdetailSubtaskId);
		}
		if(objtype != null){
    	queryparams.put("objtype",objtype);
		}
		if(progress != null){
    	queryparams.put("progress",progress);
		}
		if(createuserid != null){
    	queryparams.put("createuserid",createuserid);
		}
		if(createdeptid != null){
    	queryparams.put("createdeptid",createdeptid);
		}
		if(memo != null){
    	queryparams.put("memo",memo);
		}
		//查询列表数据
        Query query = new Query(queryparams);

		List<StProcessDetailEntity> stProcessDetailList = stProcessDetailService.queryList(query);
		int total = stProcessDetailService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(stProcessDetailList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
//	@RequiresPermissions("六大任务:查看")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		StProcessDetailEntity stProcessDetail = stProcessDetailService.queryObject(id);
		
		return R.ok().put("data", stProcessDetail);
	}


	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
//	@RequiresPermissions("六大任务:管理")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody StProcessDetailEntity stProcessDetail){
        verifyForm(stProcessDetail);
		stProcessDetailService.save(stProcessDetail);
		return R.ok();
	}
	

	

    private void verifyForm(StProcessDetailEntity stProcessDetail){

//	        if(StringUtils.isBlank(stProcessDetail.getTargetid())){
//            throw new RRException(270,"目标编号不能为空");
//		}
//	        if(StringUtils.isBlank(stProcessDetail.getTaskid())){
//            throw new RRException(270,"任务编号不能为空");
//		}
//	        if(StringUtils.isBlank(stProcessDetail.getTargetDetailId())){
//            throw new RRException(270,"目标明细编号不能为空");
//		}
//	        if(StringUtils.isBlank(stProcessDetail.getTaskDetailId())){
//            throw new RRException(270,"任务明细编号不能为空");
//		}
//	        if(StringUtils.isBlank(stProcessDetail.getTaskdetailSubtaskId())){
//            throw new RRException(270,"子任务计划进度编号不能为空");
//		}
//	        if(StringUtils.isBlank(stProcessDetail.getObjtype())){
//            throw new RRException(270,"指标类型不能为空");
//		}
//	        if(StringUtils.isBlank(stProcessDetail.getProgress())){
//            throw new RRException(270,"进度数值不能为空");
//		}
//	        if(StringUtils.isBlank(stProcessDetail.getCreateuserid())){
//            throw new RRException(270,"填报人不能为空");
//		}
//	        if(StringUtils.isBlank(stProcessDetail.getCreatedeptid())){
//            throw new RRException(270,"填报人所在部门不能为空");
//		}
//	        if(StringUtils.isBlank(stProcessDetail.getCreatetime())){
//            throw new RRException(270,"填报时间不能为空");
//		}
	    }


}