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

import com.khidi.manager.event.entity.AppeventWphsEntity;
import com.khidi.manager.event.service.AppeventWphsService;
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
@RequestMapping("appeventwphs")
@Api(value = "/AppeventWphs", description = "事件委派核实信息")
public class AppeventWphsController {
	@Autowired
	private AppeventWphsService appeventWphsService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("事件委派核实信息:查看")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="wpr",required=false) String wpr,
                  @RequestParam(value="wpnr",required=false) String wpnr,
                  @RequestParam(value="szxclgc",required=false) String szxclgc,
                  @RequestParam(value="createtime",required=false) Date createtime,
                  @RequestParam(value="hstime",required=false) Date hstime,
                  @RequestParam(value="sjhsjg",required=false) String sjhsjg,
                  @RequestParam(value="sjhsclgc",required=false) String sjhsclgc,
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
		if(wpr != null){
    	queryparams.put("wpr",wpr);
		}
		if(wpnr != null){
    	queryparams.put("wpnr",wpnr);
		}
		if(szxclgc != null){
    	queryparams.put("szxclgc",szxclgc);
		}
		if(createtime != null){
    	queryparams.put("createtime",createtime);
		}
		if(hstime != null){
    	queryparams.put("hstime",hstime);
		}
		if(sjhsjg != null){
    	queryparams.put("sjhsjg",sjhsjg);
		}
		if(sjhsclgc != null){
    	queryparams.put("sjhsclgc",sjhsclgc);
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

		List<AppeventWphsEntity> appeventWphsList = appeventWphsService.queryList(query);
		int total = appeventWphsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(appeventWphsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("事件委派核实信息:查看")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		AppeventWphsEntity appeventWphs = appeventWphsService.queryObject(id);
		
		return R.ok().put("data", appeventWphs);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("事件委派核实信息:管理")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody AppeventWphsEntity appeventWphs){
        verifyForm(appeventWphs);
		appeventWphsService.save(appeventWphs);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("事件委派核实信息:管理")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody AppeventWphsEntity appeventWphs){
        verifyForm(appeventWphs);
		appeventWphsService.update(appeventWphs);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("事件委派核实信息:管理")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				appeventWphsService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(AppeventWphsEntity appeventWphs){
        if(StringUtils.isBlank(appeventWphs.getId())){
            throw new RRException(270,"编号不能为空");
		}
	        if(StringUtils.isBlank(appeventWphs.getWpr())){
            throw new RRException(270,"被委派人不能为空");
		}
	        if(StringUtils.isBlank(appeventWphs.getWpnr())){
            throw new RRException(270,"委派内容不能为空");
		}
	        if(StringUtils.isBlank(appeventWphs.getSzxclgc())){
            throw new RRException(270,"事件的最新处理过程不能为空");
		}
	        if(StringUtils.isBlank(appeventWphs.getCreatetime().toString())){
            throw new RRException(270,"创建时间不能为空");
		}
	        if(StringUtils.isBlank(appeventWphs.getHstime().toString())){
            throw new RRException(270,"事件核实时间不能为空");
		}
	        if(StringUtils.isBlank(appeventWphs.getSjhsjg())){
            throw new RRException(270,"事件核实的结果不能为空");
		}
	        if(StringUtils.isBlank(appeventWphs.getSjhsclgc())){
            throw new RRException(270,"事件的核实处理过程不能为空");
		}
	        if(StringUtils.isBlank(appeventWphs.getEid())){
            throw new RRException(270,"事件编号不能为空");
		}
	        if(StringUtils.isBlank(appeventWphs.getGrpid())){
            throw new RRException(270,"分组(yyyyMMddHHmmss)不能为空");
		}
	        if(StringUtils.isBlank(appeventWphs.getCurrentind())){
            throw new RRException(270,"当前标识不能为空");
		}
	        if(StringUtils.isBlank(appeventWphs.getEflowid())){
            throw new RRException(270,"事件流转编号不能为空");
		}
	        if(StringUtils.isBlank(appeventWphs.getDelind())){
            throw new RRException(270,"删除标识不能为空");
		}
	    }


}