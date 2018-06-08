package com.khidi.manager.event.controller;

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

import com.khidi.manager.event.entity.AppeventFbEntity;
import com.khidi.manager.event.service.AppeventFbService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;




/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-29 15:22:47
 */
@RestController
@RequestMapping("appeventfb")
@Api(value = "/AppeventFb", description = "事件反馈信息")
public class AppeventFbController {
	@Autowired
	private AppeventFbService appeventFbService;

	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("事件反馈信息:查看")
	@ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
			@RequestParam(value="limit",required=true) int limit,
			@RequestParam(value="sidx",required=false) String sidx,
			@RequestParam(value="order",required=false) String order,
			@RequestParam(value="id",required=false) String id,
			@RequestParam(value="eid",required=false) String eid,
			@RequestParam(value="fbuserid",required=false) String fbuserid,
			@RequestParam(value="fbdeptid",required=false) String fbdeptid,
			@RequestParam(value="fbtime",required=false) Date fbtime,
			@RequestParam(value="fbcontent",required=false) String fbcontent,
			@RequestParam(value="eflowid",required=false) String eflowid,
			@RequestParam(value="delind",required=false) String delind				  ){
		Map<String,Object> queryparams = new HashMap<String,Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
		if(id != null){
			queryparams.put("id",id);
		}
		if(eid != null){
			queryparams.put("eid",eid);
		}
		if(fbuserid != null){
			queryparams.put("fbuserid",fbuserid);
		}
		if(fbdeptid != null){
			queryparams.put("fbdeptid",fbdeptid);
		}
		if(fbtime != null){
			queryparams.put("fbtime",fbtime);
		}
		if(fbcontent != null){
			queryparams.put("fbcontent",fbcontent);
		}
		if(eflowid != null){
			queryparams.put("eflowid",eflowid);
		}
		if(delind != null){
			queryparams.put("delind",delind);
		}
		//查询列表数据
		Query query = new Query(queryparams);

		List<AppeventFbEntity> appeventFbList = appeventFbService.queryList(query);
		int total = appeventFbService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(appeventFbList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}


	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("事件反馈信息:查看")
	@ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		AppeventFbEntity appeventFb = appeventFbService.queryObject(id);

		return R.ok().put("data", appeventFb);
	}

	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("事件反馈信息:管理")
	@ApiOperation(value = "保存",notes="")
	public R save(@RequestBody AppeventFbEntity appeventFb){
		verifyForm(appeventFb);
		appeventFbService.save(appeventFb);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("事件反馈信息:管理")
	@ApiOperation(value = "修改",notes="")
	public R update(@RequestBody AppeventFbEntity appeventFb){
		verifyForm(appeventFb);
		appeventFbService.update(appeventFb);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("事件反馈信息:管理")
	@ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
		String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
			appeventFbService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(AppeventFbEntity appeventFb){
		if(StringUtils.isBlank(appeventFb.getId())){
			throw new RRException(270,"编号不能为空");
		}
		if(StringUtils.isBlank(appeventFb.getEid())){
			throw new RRException(270,"事件编号不能为空");
		}
		if(StringUtils.isBlank(appeventFb.getFbuserid())){
			throw new RRException(270,"反馈人不能为空");
		}
		if(StringUtils.isBlank(appeventFb.getFbdeptid())){
			throw new RRException(270,"反馈部门不能为空");
		}
		if(StringUtils.isBlank(appeventFb.getFbcontent())){
			throw new RRException(270,"反馈内容不能为空");
		}
		if(StringUtils.isBlank(appeventFb.getEflowid())){
			throw new RRException(270,"事件流转编号不能为空");
		}
		if(StringUtils.isBlank(appeventFb.getDelind())){
			throw new RRException(270,"删除标识不能为空");
		}
	}


}