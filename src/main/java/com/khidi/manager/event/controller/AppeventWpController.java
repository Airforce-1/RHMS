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

import com.khidi.manager.event.entity.AppeventWpEntity;
import com.khidi.manager.event.service.AppeventWpService;
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
@RequestMapping("appeventwp")
@Api(value = "/AppeventWp", description = "事件委派信息")
public class AppeventWpController {
	@Autowired
	private AppeventWpService appeventWpService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("事件委派信息:查看")
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
                  @RequestParam(value="eid",required=false) String eid,
                  @RequestParam(value="grpid",required=false) String grpid,
                  @RequestParam(value="eflowid",required=false) String eflowid,
                  @RequestParam(value="currentind",required=false) String currentind,
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
		if(eid != null){
    	queryparams.put("eid",eid);
		}
		if(grpid != null){
    	queryparams.put("grpid",grpid);
		}
		if(eflowid != null){
    	queryparams.put("eflowid",eflowid);
		}
		if(currentind != null){
    	queryparams.put("currentind",currentind);
		}
		if(delind != null){
    	queryparams.put("delind",delind);
		}
		//查询列表数据
        Query query = new Query(queryparams);

		List<AppeventWpEntity> appeventWpList = appeventWpService.queryList(query);
		int total = appeventWpService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(appeventWpList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("事件委派信息:查看")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		AppeventWpEntity appeventWp = appeventWpService.queryObject(id);
		
		return R.ok().put("data", appeventWp);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("事件委派信息:管理")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody AppeventWpEntity appeventWp){
        verifyForm(appeventWp);
		appeventWpService.save(appeventWp);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("事件委派信息:管理")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody AppeventWpEntity appeventWp){
        verifyForm(appeventWp);
		appeventWpService.update(appeventWp);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("事件委派信息:管理")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				appeventWpService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(AppeventWpEntity appeventWp){
        if(StringUtils.isBlank(appeventWp.getId())){
            throw new RRException(270,"编号不能为空");
		}
	        if(StringUtils.isBlank(appeventWp.getBwpr())){
            throw new RRException(270,"被委派人不能为空");
		}
	        if(StringUtils.isBlank(appeventWp.getWpnr())){
            throw new RRException(270,"委派内容不能为空");
		}
	        if(StringUtils.isBlank(appeventWp.getZxclgc())){
            throw new RRException(270,"事件的最新处理过程不能为空");
		}
	        if(StringUtils.isBlank(appeventWp.getCreatetime().toString())){
            throw new RRException(270,"创建时间不能为空");
		}
	        if(StringUtils.isBlank(appeventWp.getEid())){
            throw new RRException(270,"事件编号不能为空");
		}
	        if(StringUtils.isBlank(appeventWp.getGrpid())){
            throw new RRException(270,"分组(yyyyMMddHHmmss)不能为空");
		}
	        if(StringUtils.isBlank(appeventWp.getEflowid())){
            throw new RRException(270,"事件流转编号不能为空");
		}
	        if(StringUtils.isBlank(appeventWp.getCurrentind())){
            throw new RRException(270,"当前标识不能为空");
		}
	        if(StringUtils.isBlank(appeventWp.getDelind())){
            throw new RRException(270,"删除标识不能为空");
		}
	    }


}