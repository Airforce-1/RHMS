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

import com.khidi.manager.event.entity.AppeventDwattInfoEntity;
import com.khidi.manager.event.service.AppeventDwattInfoService;
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
@RequestMapping("appeventdwattinfo")
@Api(value = "/AppeventDwattInfo", description = "事件的处理附件信息")
public class AppeventDwattInfoController {
	@Autowired
	private AppeventDwattInfoService appeventDwattInfoService;

	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("事件的处理附件信息:查看")
	@ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
			@RequestParam(value="limit",required=true) int limit,
			@RequestParam(value="sidx",required=false) String sidx,
			@RequestParam(value="order",required=false) String order,
			@RequestParam(value="attid",required=false) String attid,
			@RequestParam(value="eid",required=false) String eid,
			@RequestParam(value="eclid",required=false) String eclid,
			@RequestParam(value="attname",required=false) String attname,
			@RequestParam(value="extname",required=false) String extname,
			@RequestParam(value="attrelativepath",required=false) String attrelativepath,
			@RequestParam(value="eflowid",required=false) String eflowid				  ){
		Map<String,Object> queryparams = new HashMap<String,Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
		if(attid != null){
			queryparams.put("attid",attid);
		}
		if(eid != null){
			queryparams.put("eid",eid);
		}
		if(eclid != null){
			queryparams.put("eclid",eclid);
		}
		if(attname != null){
			queryparams.put("attname",attname);
		}
		if(extname != null){
			queryparams.put("extname",extname);
		}
		if(attrelativepath != null){
			queryparams.put("attrelativepath",attrelativepath);
		}
		if(eflowid != null){
			queryparams.put("eflowid",eflowid);
		}
		//查询列表数据
		Query query = new Query(queryparams);

		List<AppeventDwattInfoEntity> appeventDwattInfoList = appeventDwattInfoService.queryList(query);
		int total = appeventDwattInfoService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(appeventDwattInfoList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}


	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("事件的处理附件信息:查看")
	@ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		AppeventDwattInfoEntity appeventDwattInfo = appeventDwattInfoService.queryObject(id);

		return R.ok().put("data", appeventDwattInfo);
	}

	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("事件的处理附件信息:管理")
	@ApiOperation(value = "保存",notes="")
	public R save(@RequestBody AppeventDwattInfoEntity appeventDwattInfo){
		verifyForm(appeventDwattInfo);
		appeventDwattInfoService.save(appeventDwattInfo);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("事件的处理附件信息:管理")
	@ApiOperation(value = "修改",notes="")
	public R update(@RequestBody AppeventDwattInfoEntity appeventDwattInfo){
		verifyForm(appeventDwattInfo);
		appeventDwattInfoService.update(appeventDwattInfo);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("事件的处理附件信息:管理")
	@ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
		String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
			appeventDwattInfoService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(AppeventDwattInfoEntity appeventDwattInfo){
		if(StringUtils.isBlank(appeventDwattInfo.getAttid())){
			throw new RRException(270,"附件编号不能为空");
		}
		if(StringUtils.isBlank(appeventDwattInfo.getEid())){
			throw new RRException(270,"事项编号不能为空");
		}
		if(StringUtils.isBlank(appeventDwattInfo.getEclid())){
			throw new RRException(270,"事件处理编号不能为空");
		}
		if(StringUtils.isBlank(appeventDwattInfo.getAttname())){
			throw new RRException(270,"附件文件名不能为空");
		}
		if(StringUtils.isBlank(appeventDwattInfo.getExtname())){
			throw new RRException(270,"附件文件扩展名不能为空");
		}
		if(StringUtils.isBlank(appeventDwattInfo.getAttrelativepath())){
			throw new RRException(270,"附件文件相对路径不能为空");
		}
		if(StringUtils.isBlank(appeventDwattInfo.getEflowid())){
			throw new RRException(270,"事件流转编号不能为空");
		}
	}


}