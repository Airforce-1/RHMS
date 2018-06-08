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

import com.khidi.manager.event.entity.AppentReportEntity;
import com.khidi.manager.event.service.AppentReportService;
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
@RequestMapping("appentreport")
@Api(value = "/AppentReport", description = "事件上报信息")
public class AppentReportController {
	@Autowired
	private AppentReportService appentReportService;

	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("事件上报信息:查看")
	@ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
			@RequestParam(value="limit",required=true) int limit,
			@RequestParam(value="sidx",required=false) String sidx,
			@RequestParam(value="order",required=false) String order,
			@RequestParam(value="id",required=false) String id,
			@RequestParam(value="eid",required=false) String eid,
			@RequestParam(value="createtime",required=false) Date createtime,
			@RequestParam(value="grpid",required=false) String grpid,
			@RequestParam(value="currentind",required=false) String currentind,
			@RequestParam(value="eflowid",required=false) String eflowid,
			@RequestParam(value="delind",required=false) String delind,
			@RequestParam(value="dwuser",required=false) String dwuser){
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
		if(createtime != null){
			queryparams.put("createtime",createtime);
		}
		if(grpid != null){
			queryparams.put("grpid",grpid);
		}
		if(currentind != null){
			queryparams.put("currentind",currentind);
		}
		if(eflowid != null){
			queryparams.put("eflowid",eflowid);
		}
		if(delind != null){
			queryparams.put("delind",delind);
		}
		if(dwuser != null){
			queryparams.put("dwuser",dwuser);
		}
		//查询列表数据
		Query query = new Query(queryparams);

		List<AppentReportEntity> appentReportList = appentReportService.queryList(query);
		int total = appentReportService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(appentReportList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}


	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("事件上报信息:查看")
	@ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		AppentReportEntity appentReport = appentReportService.queryObject(id);

		return R.ok().put("data", appentReport);
	}

	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("事件上报信息:管理")
	@ApiOperation(value = "保存",notes="")
	public R save(@RequestBody AppentReportEntity appentReport){
		verifyForm(appentReport);
		appentReportService.save(appentReport);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("事件上报信息:管理")
	@ApiOperation(value = "修改",notes="")
	public R update(@RequestBody AppentReportEntity appentReport){
		verifyForm(appentReport);
		appentReportService.update(appentReport);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("事件上报信息:管理")
	@ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
		String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
			appentReportService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(AppentReportEntity appentReport){
		if(StringUtils.isBlank(appentReport.getId())){
			throw new RRException(270,"编号不能为空");
		}
		if(StringUtils.isBlank(appentReport.getEid())){
			throw new RRException(270,"事件编号不能为空");
		}
		if(StringUtils.isBlank(appentReport.getGrpid())){
			throw new RRException(270,"分组(yyyyMMddHHmmss)不能为空");
		}
		if(StringUtils.isBlank(appentReport.getCurrentind())){
			throw new RRException(270,"当前标识不能为空");
		}
		if(StringUtils.isBlank(appentReport.getEflowid())){
			throw new RRException(270,"事件流转编号不能为空");
		}
		if(StringUtils.isBlank(appentReport.getDelind())){
			throw new RRException(270,"删除标识不能为空");
		}
	}


}