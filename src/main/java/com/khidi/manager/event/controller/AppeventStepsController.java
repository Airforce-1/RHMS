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

import com.khidi.manager.event.entity.AppeventStepsEntity;
import com.khidi.manager.event.service.AppeventStepsService;
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
@RequestMapping("appeventsteps")
@Api(value = "/AppeventSteps", description = "事件流转信息")
public class AppeventStepsController {
	@Autowired
	private AppeventStepsService appeventStepsService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("事件流转信息:查看")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="esteptype",required=false) String esteptype,
                  @RequestParam(value="reportid",required=false) String reportid,
                  @RequestParam(value="wpId",required=false) String wpId,
                  @RequestParam(value="wpHsId",required=false) String wpHsId,
                  @RequestParam(value="clid",required=false) String clid,
                  @RequestParam(value="createtime",required=false) Date createtime,
                  @RequestParam(value="eid",required=false) String eid,
                  @RequestParam(value="grpid",required=false) String grpid				  ){
        Map<String,Object> queryparams = new HashMap<String,Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
		if(id != null){
    	queryparams.put("id",id);
		}
		if(esteptype != null){
    	queryparams.put("esteptype",esteptype);
		}
		if(reportid != null){
    	queryparams.put("reportid",reportid);
		}
		if(wpId != null){
    	queryparams.put("wpId",wpId);
		}
		if(wpHsId != null){
    	queryparams.put("wpHsId",wpHsId);
		}
		if(clid != null){
    	queryparams.put("clid",clid);
		}
		if(createtime != null){
    	queryparams.put("createtime",createtime);
		}
		if(eid != null){
    	queryparams.put("eid",eid);
		}
		if(grpid != null){
    	queryparams.put("grpid",grpid);
		}
		//查询列表数据
        Query query = new Query(queryparams);

		List<AppeventStepsEntity> appeventStepsList = appeventStepsService.queryList(query);
		int total = appeventStepsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(appeventStepsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("事件流转信息:查看")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		AppeventStepsEntity appeventSteps = appeventStepsService.queryObject(id);
		
		return R.ok().put("data", appeventSteps);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("事件流转信息:管理")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody AppeventStepsEntity appeventSteps){
        verifyForm(appeventSteps);
		appeventStepsService.save(appeventSteps);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("事件流转信息:管理")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody AppeventStepsEntity appeventSteps){
        verifyForm(appeventSteps);
		appeventStepsService.update(appeventSteps);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("事件流转信息:管理")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				appeventStepsService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(AppeventStepsEntity appeventSteps){
        if(StringUtils.isBlank(appeventSteps.getId())){
            throw new RRException(270,"编号不能为空");
		}
	        if(StringUtils.isBlank(appeventSteps.getEsteptype())){
            throw new RRException(270,"事件流转类型不能为空");
		}
	        if(StringUtils.isBlank(appeventSteps.getReportid())){
            throw new RRException(270,"上报编号不能为空");
		}
	        if(StringUtils.isBlank(appeventSteps.getWpId())){
            throw new RRException(270,"委派编号不能为空");
		}
	        if(StringUtils.isBlank(appeventSteps.getWpHsId())){
            throw new RRException(270,"委派核实编号不能为空");
		}
	        if(StringUtils.isBlank(appeventSteps.getClid())){
            throw new RRException(270,"处理编号不能为空");
		}
	        if(StringUtils.isBlank(appeventSteps.getCreatetime().toString())){
            throw new RRException(270,"事件记录时间不能为空");
		}
	        if(StringUtils.isBlank(appeventSteps.getEid())){
            throw new RRException(270,"事件编号不能为空");
		}
	        if(StringUtils.isBlank(appeventSteps.getGrpid())){
            throw new RRException(270,"分组(yyyyMMddHHmmss)不能为空");
		}
	    }


}