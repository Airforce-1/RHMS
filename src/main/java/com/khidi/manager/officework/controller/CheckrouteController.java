package com.khidi.manager.officework.controller;

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

import com.khidi.manager.officework.entity.CheckrouteEntity;
import com.khidi.manager.officework.service.CheckrouteService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;




/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-13 15:01:00
 */
@RestController
@RequestMapping("checkroute")
@Api(value = "/Checkroute", description = "巡查路线管理")
public class CheckrouteController {
	@Autowired
	private CheckrouteService checkrouteService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("巡查路线:查看")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="code",required=false) String code,
                  @RequestParam(value="name",required=false) String name,
                  @RequestParam(value="areaid",required=false) String areaid,
                  @RequestParam(value="resourcetype",required=false) String resourcetype,
                  @RequestParam(value="resourcename",required=false) String resourcename,
                  @RequestParam(value="startpoint",required=false) String startpoint,
                  @RequestParam(value="endpoint",required=false) String endpoint,
                  @RequestParam(value="length",required=false) String length,
                  @RequestParam(value="status",required=false) String status,
                  @RequestParam(value="createtime",required=false) Date createtime){
        Map<String,Object> queryparams = new HashMap<String,Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
		if(id != null){
    	queryparams.put("id",id);
		}
		if(code != null){
    	queryparams.put("code",code);
		}
		if(name != null){
    	queryparams.put("name",name);
		}
		if(areaid != null){
    	queryparams.put("areaId",areaid);
		}
		if(resourcetype != null){
    	queryparams.put("resourcetype",resourcetype);
		}
		if(resourcename != null){
    	queryparams.put("resourcename",resourcename);
		}
		if(startpoint != null){
    	queryparams.put("startpoint",startpoint);
		}
		if(endpoint != null){
    	queryparams.put("endpoint",endpoint);
		}
		if(length != null){
    	queryparams.put("length",length);
		}
		if(status != null){
    	queryparams.put("status",status);
		}
		if(createtime != null){
    	queryparams.put("createtime",createtime);
		}

		//查询列表数据
        Query query = new Query(queryparams);

		List<CheckrouteEntity> checkrouteList = checkrouteService.queryList(query);
		int total = checkrouteService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(checkrouteList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("巡查路线:查看")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		CheckrouteEntity checkroute = checkrouteService.queryObject(id);
		
		return R.ok().put("data", checkroute);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("巡查路线:管理")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody CheckrouteEntity checkroute){
        verifyForm(checkroute);
		checkrouteService.save(checkroute);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("巡查路线:管理")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody CheckrouteEntity checkroute){
        verifyForm(checkroute);
		checkrouteService.update(checkroute);
		return R.ok();
	}


	/**
	 * 绘制路线
	 */
	@RequestMapping(value = "/drawMap", method = RequestMethod.PUT)
	@RequiresPermissions("巡查路线:管理")
	@ApiOperation(value = "绘制路线",notes="绘制路线")
	public R drawMap(@RequestBody CheckrouteEntity checkroute){
		if(StringUtils.isBlank(checkroute.getId())){
			throw new RRException(270,"编码不能为空");
		}
		if(StringUtils.isBlank(checkroute.getRouteMap())){
			throw new RRException(270,"路线绘制不能为空");
		}
		checkrouteService.update(checkroute);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("巡查路线:管理")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				checkrouteService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(CheckrouteEntity checkroute){
	        if(StringUtils.isBlank(checkroute.getCode())){
            throw new RRException(270,"路线编码不能为空");
		}
	        if(StringUtils.isBlank(checkroute.getName())){
            throw new RRException(270,"路线名称不能为空");
		}
	        if(StringUtils.isBlank(checkroute.getAreaid())){
            throw new RRException(270,"行政区划编码不能为空");
		}
	        if(StringUtils.isBlank(checkroute.getResourcetype())){
            throw new RRException(270,"河渠湖库(段)类型不能为空");
		}
	        if(StringUtils.isBlank(checkroute.getResourceid())){
            throw new RRException(270,"河渠湖库(段)名称不能为空");
		}
	        if(StringUtils.isBlank(checkroute.getStartpoint())){
            throw new RRException(270,"起点位置不能为空");
		}
	        if(StringUtils.isBlank(checkroute.getEndpoint())){
            throw new RRException(270,"终点位置不能为空");
		}
	        if(StringUtils.isBlank(checkroute.getStatus())){
            throw new RRException(270,"状态不能为空");
		}
	    }
}