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

import com.khidi.manager.event.entity.AppeventAttinfoEntity;
import com.khidi.manager.event.service.AppeventAttinfoService;
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
@RequestMapping("appeventattinfo")
@Api(value = "/AppeventAttinfo", description = "事件的附件信息")
public class AppeventAttinfoController {
	@Autowired
	private AppeventAttinfoService appeventAttinfoService;

	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("事件的附件信息:查看")
	@ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
			@RequestParam(value="limit",required=true) int limit,
			@RequestParam(value="sidx",required=false) String sidx,
			@RequestParam(value="order",required=false) String order,
			@RequestParam(value="id",required=false) String id,
			@RequestParam(value="eid",required=false) String eid,
			@RequestParam(value="attname",required=false) String attname,
			@RequestParam(value="attext",required=false) String attext,
			@RequestParam(value="attrelativepath",required=false) String attrelativepath,
			@RequestParam(value="attid",required=false) String attid				  ){
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
		if(attname != null){
			queryparams.put("attname",attname);
		}
		if(attext != null){
			queryparams.put("attext",attext);
		}
		if(attrelativepath != null){
			queryparams.put("attrelativepath",attrelativepath);
		}
		if(attid != null){
			queryparams.put("attid",attid);
		}
		//查询列表数据
		Query query = new Query(queryparams);

		List<AppeventAttinfoEntity> appeventAttinfoList = appeventAttinfoService.queryList(query);
		int total = appeventAttinfoService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(appeventAttinfoList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}


	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("事件的附件信息:查看")
	@ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		AppeventAttinfoEntity appeventAttinfo = appeventAttinfoService.queryObject(id);

		return R.ok().put("data", appeventAttinfo);
	}

	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("事件的附件信息:管理")
	@ApiOperation(value = "保存",notes="")
	public R save(@RequestBody AppeventAttinfoEntity appeventAttinfo){
		verifyForm(appeventAttinfo);
		appeventAttinfoService.save(appeventAttinfo);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("事件的附件信息:管理")
	@ApiOperation(value = "修改",notes="")
	public R update(@RequestBody AppeventAttinfoEntity appeventAttinfo){
		verifyForm(appeventAttinfo);
		appeventAttinfoService.update(appeventAttinfo);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("事件的附件信息:管理")
	@ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
		String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
			appeventAttinfoService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(AppeventAttinfoEntity appeventAttinfo){
		if(StringUtils.isBlank(appeventAttinfo.getId())){
			throw new RRException(270,"编号不能为空");
		}
		if(StringUtils.isBlank(appeventAttinfo.getEid())){
			throw new RRException(270,"事件编号不能为空");
		}
		if(StringUtils.isBlank(appeventAttinfo.getAttname())){
			throw new RRException(270,"附件文件名不能为空");
		}
		if(StringUtils.isBlank(appeventAttinfo.getAttext())){
			throw new RRException(270,"附件文件扩展名不能为空");
		}
		if(StringUtils.isBlank(appeventAttinfo.getAttrelativepath())){
			throw new RRException(270,"附件文件相对路径不能为空");
		}
		if(StringUtils.isBlank(appeventAttinfo.getAttid())){
			throw new RRException(270,"附件编号(与附件表对应)不能为空");
		}
	}


}