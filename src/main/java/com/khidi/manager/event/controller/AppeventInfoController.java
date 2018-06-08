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

import com.khidi.manager.event.entity.AppeventInfoEntity;
import com.khidi.manager.event.service.AppeventInfoService;
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
@RequestMapping("appeventinfo")
@Api(value = "/AppeventInfo", description = "事件信息管理")
public class AppeventInfoController {
	@Autowired
	private AppeventInfoService appeventInfoService;

	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("事件信息:查看")
	@ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
			@RequestParam(value="limit",required=true) int limit,
			@RequestParam(value="sidx",required=false) String sidx,
			@RequestParam(value="order",required=false) String order,
			@RequestParam(value="delind",required=false) String delind,
			@RequestParam(value="id",required=false) String id,
			@RequestParam(value="flag",required=false) String flag,
			@RequestParam(value="title",required=false) String title,
			@RequestParam(value="state",required=false) String state,
			@RequestParam(value="fqr",required=false) String fqr,
			@RequestParam(value="createtime",required=false) Date createtime,
			@RequestParam(value="etype",required=false) String etype,
			@RequestParam(value="econtent",required=false) String econtent,
			@RequestParam(value="elat",required=false) Double elat,
			@RequestParam(value="eheight",required=false) Double eheight,
			@RequestParam(value="elon",required=false) Double elon,
			@RequestParam(value="dwprocedure",required=false) String dwprocedure,
			@RequestParam(value="dwuserid",required=false) String dwuserid,
			@RequestParam(value="hd",required=false) String hd,
			@RequestParam(value="attid",required=false) String attid,
			@RequestParam(value="estepstype",required=false) String estepstype){
		Map<String,Object> queryparams = new HashMap<String,Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
		if(delind != null){
			queryparams.put("delind",delind);
		}
		if(id != null){
			queryparams.put("id",id);
		}
		if(flag != null){
			queryparams.put("flag",flag);
		}
		if(title != null){
			queryparams.put("title",title);
		}
		if(state != null){
			queryparams.put("state",state);
		}
		if(fqr != null){
			queryparams.put("fqr",fqr);
		}
		if(createtime != null){
			queryparams.put("createtime",createtime);
		}
		if(etype != null){
			queryparams.put("etype",etype);
		}
		if(econtent != null){
			queryparams.put("econtent",econtent);
		}
		if(elat != null){
			queryparams.put("elat",elat);
		}
		if(eheight != null){
			queryparams.put("eheight",eheight);
		}
		if(elon != null){
			queryparams.put("elon",elon);
		}
		if(dwprocedure != null){
			queryparams.put("dwprocedure",dwprocedure);
		}
		if(dwuserid != null){
			queryparams.put("dwuserid",dwuserid);
		}
		if(hd != null){
			queryparams.put("hd",hd);
		}
		if(attid != null){
			queryparams.put("attid",attid);
		}
		if(estepstype != null){
			queryparams.put("estepstype",estepstype);
		}
		//查询列表数据
		Query query = new Query(queryparams);

		List<AppeventInfoEntity> appeventInfoList = appeventInfoService.queryList(query);
		int total = appeventInfoService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(appeventInfoList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}


	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("事件信息:查看")
	@ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		AppeventInfoEntity appeventInfo = appeventInfoService.queryObject(id);

		return R.ok().put("data", appeventInfo);
	}

	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	//@RequiresPermissions("事件信息:管理")
	@ApiOperation(value = "保存",notes="")
	public R save(@RequestBody AppeventInfoEntity appeventInfo){
		verifyForm(appeventInfo);
		appeventInfoService.save(appeventInfo);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("事件信息:管理")
	@ApiOperation(value = "修改",notes="")
	public R update(@RequestBody AppeventInfoEntity appeventInfo){
		verifyForm(appeventInfo);
		appeventInfoService.update(appeventInfo);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("事件信息:管理")
	@ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
		String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
			appeventInfoService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(AppeventInfoEntity appeventInfo){
		/*if(StringUtils.isBlank(appeventInfo.getDelind())){
			throw new RRException(270,"删除标识不能为空");
		}
		if(StringUtils.isBlank(appeventInfo.getId())){
			throw new RRException(270,"事件编号不能为空");
		}*/
		if(StringUtils.isBlank(appeventInfo.getFlag())){
			throw new RRException(270,"事项标识(可看成事项编号)不能为空");
		}
		if(StringUtils.isBlank(appeventInfo.getTitle())){
			throw new RRException(270,"事项标题不能为空");
		}
		if(StringUtils.isBlank(appeventInfo.getState())){
			throw new RRException(270,"事项状态不能为空");
		}
		if(StringUtils.isBlank(appeventInfo.getFqr())){
			throw new RRException(270,"事项发起人不能为空");
		}
		if(StringUtils.isBlank(String.valueOf(appeventInfo.getCreatetime()))){
			throw new RRException(270,"事项创建时间不能为空");
		}
		if(StringUtils.isBlank(appeventInfo.getEtype())){
			throw new RRException(270,"事项分类不能为空");
		}
		if(StringUtils.isBlank(appeventInfo.getEcontent())){
			throw new RRException(270,"事件内容不能为空");
		}
		if(StringUtils.isBlank(String.valueOf(appeventInfo.getElat()))){
			throw new RRException(270,"事件的位置(纬度)不能为空");
		}
		if(StringUtils.isBlank(String.valueOf(appeventInfo.getEheight()))){
			throw new RRException(270,"事件的位置(高度)不能为空");
		}
		if(StringUtils.isBlank(String.valueOf(appeventInfo.getElon()))){
			throw new RRException(270,"事件的位置(经度)不能为空");
		}
		if(StringUtils.isBlank(appeventInfo.getDwprocedure())){
			throw new RRException(270,"事件的处理过程不能为空");
		}
		if(StringUtils.isBlank(appeventInfo.getDwuserid())){
			throw new RRException(270,"处理人不能为空");
		}
		if(StringUtils.isBlank(appeventInfo.getHd())){
			throw new RRException(270,"事件发生的河段不能为空");
		}
	}


}