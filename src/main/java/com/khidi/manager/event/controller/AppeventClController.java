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

import com.khidi.manager.event.entity.AppeventClEntity;
import com.khidi.manager.event.service.AppeventClService;
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
@RequestMapping("appeventcl")
@Api(value = "/AppeventCl", description = "事件处理信息")
public class AppeventClController {
	@Autowired
	private AppeventClService appeventClService;

	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("事件处理信息:查看")
	@ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
			@RequestParam(value="limit",required=true) int limit,
			@RequestParam(value="sidx",required=false) String sidx,
			@RequestParam(value="order",required=false) String order,
			@RequestParam(value="id",required=false) String id,
			@RequestParam(value="bwpr",required=false) String bwpr,
			@RequestParam(value="wpnr",required=false) String wpnr,
			@RequestParam(value="zxclgc",required=false) String zxclgc,
			@RequestParam(value="createtime",required=false) Date createtime,
			@RequestParam(value="dwtime",required=false) Date dwtime,
			@RequestParam(value="dwresultContent",required=false) String dwresultContent,
			@RequestParam(value="dwProcedure",required=false) String dwProcedure,
			@RequestParam(value="eid",required=false) String eid,
			@RequestParam(value="grpid",required=false) String grpid,
			@RequestParam(value="currentind",required=false) String currentind,
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
		if(bwpr != null){
			queryparams.put("bwpr",bwpr);
		}
		if(wpnr != null){
			queryparams.put("wpnr",wpnr);
		}
		if(zxclgc != null){
			queryparams.put("zxclgc",zxclgc);
		}
		if(createtime != null){
			queryparams.put("createtime",createtime);
		}
		if(dwtime != null){
			queryparams.put("dwtime",dwtime);
		}
		if(dwresultContent != null){
			queryparams.put("dwresultContent",dwresultContent);
		}
		if(dwProcedure != null){
			queryparams.put("dwProcedure",dwProcedure);
		}
		if(eid != null){
			queryparams.put("eid",eid);
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
		//查询列表数据
		Query query = new Query(queryparams);

		List<AppeventClEntity> appeventClList = appeventClService.queryList(query);
		int total = appeventClService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(appeventClList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}


	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("事件处理信息:查看")
	@ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		AppeventClEntity appeventCl = appeventClService.queryObject(id);

		return R.ok().put("data", appeventCl);
	}

	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("事件处理信息:管理")
	@ApiOperation(value = "保存",notes="")
	public R save(@RequestBody AppeventClEntity appeventCl){
		verifyForm(appeventCl);
		appeventClService.save(appeventCl);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("事件处理信息:管理")
	@ApiOperation(value = "修改",notes="")
	public R update(@RequestBody AppeventClEntity appeventCl){
		verifyForm(appeventCl);
		appeventClService.update(appeventCl);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("事件处理信息:管理")
	@ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
		String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
			appeventClService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(AppeventClEntity appeventCl){
		if(StringUtils.isBlank(appeventCl.getId())){
			throw new RRException(270,"编号不能为空");
		}
		if(StringUtils.isBlank(appeventCl.getBwpr())){
			throw new RRException(270,"被委派人不能为空");
		}
		if(StringUtils.isBlank(appeventCl.getWpnr())){
			throw new RRException(270,"委派内容不能为空");
		}
		if(StringUtils.isBlank(appeventCl.getZxclgc())){
			throw new RRException(270,"事件的最新处理过程不能为空");
		}
		if(StringUtils.isBlank(appeventCl.getDwresultContent())){
			throw new RRException(270,"事件处理的结果内容不能为空");
		}
		if(StringUtils.isBlank(appeventCl.getDwProcedure())){
			throw new RRException(270,"事件的处理过程不能为空");
		}
		if(StringUtils.isBlank(appeventCl.getEid())){
			throw new RRException(270,"事件编号不能为空");
		}
		if(StringUtils.isBlank(appeventCl.getGrpid())){
			throw new RRException(270,"分组(yyyyMMddHHmmss)不能为空");
		}
		if(StringUtils.isBlank(appeventCl.getCurrentind())){
			throw new RRException(270,"当前标识不能为空");
		}
		if(StringUtils.isBlank(appeventCl.getEflowid())){
			throw new RRException(270,"事件流转编号不能为空");
		}
		if(StringUtils.isBlank(appeventCl.getDelind())){
			throw new RRException(270,"删除标识不能为空");
		}
	}


}