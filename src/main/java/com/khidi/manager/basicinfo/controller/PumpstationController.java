package com.khidi.manager.basicinfo.controller;

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

import com.khidi.manager.basicinfo.entity.PumpstationEntity;
import com.khidi.manager.basicinfo.service.PumpstationService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;




/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-15 15:37:03
 */
@RestController
@RequestMapping("pumpstation")
@Api(value = "/Pumpstation", description = "泵站管理")
public class PumpstationController {
	@Autowired
	private PumpstationService pumpstationService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("泵站:查看")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="managerCode",required=false) String managerCode,
                  @RequestParam(value="underManager",required=false) String underManager,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="name",required=false) String name,
                  @RequestParam(value="code",required=false) String code,
                  @RequestParam(value="x",required=false) String x,
                  @RequestParam(value="y",required=false) String y,
                  @RequestParam(value="task",required=false) String task,
                  @RequestParam(value="buildSiuation",required=false) String buildSiuation,
                  @RequestParam(value="buildTime",required=false) Date buildTime,
                  @RequestParam(value="grade",required=false) String grade,
                  @RequestParam(value="buildLevel",required=false) String buildLevel,
                  @RequestParam(value="installedFlow",required=false) String installedFlow,
                  @RequestParam(value="installedPower",required=false) String installedPower,
                  @RequestParam(value="designLength",required=false) String designLength,
                  @RequestParam(value="count",required=false) String count,
                  @RequestParam(value="managerName",required=false) String managerName,
                  @RequestParam(value="areaId",required=false) String areaId,
                  @RequestParam(value="resourceType",required=false) String resourceType,
                  @RequestParam(value="resourceId",required=false) String resourceId,
                  @RequestParam(value="resourceName",required=false) String resourceName,
                  @RequestParam(value="createTime",required=false) Date createTime				  ){
        Map<String,Object> queryparams = new HashMap<String,Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
		if(managerCode != null){
    	queryparams.put("managerCode",managerCode);
		}
		if(underManager != null){
    	queryparams.put("underManager",underManager);
		}
		if(id != null){
    	queryparams.put("id",id);
		}
		if(name != null){
    	queryparams.put("name",name);
		}
		if(code != null){
    	queryparams.put("code",code);
		}
		if(x != null){
    	queryparams.put("x",x);
		}
		if(y != null){
    	queryparams.put("y",y);
		}
		if(task != null){
    	queryparams.put("task",task);
		}
		if(buildSiuation != null){
    	queryparams.put("buildSiuation",buildSiuation);
		}
		if(buildTime != null){
    	queryparams.put("buildTime",buildTime);
		}
		if(grade != null){
    	queryparams.put("grade",grade);
		}
		if(buildLevel != null){
    	queryparams.put("buildLevel",buildLevel);
		}
		if(installedFlow != null){
    	queryparams.put("installedFlow",installedFlow);
		}
		if(installedPower != null){
    	queryparams.put("installedPower",installedPower);
		}
		if(designLength != null){
    	queryparams.put("designLength",designLength);
		}
		if(count != null){
    	queryparams.put("count",count);
		}
		if(managerName != null){
    	queryparams.put("managerName",managerName);
		}
		if(areaId != null){
    	queryparams.put("areaId",areaId);
		}
		if(resourceType != null){
    	queryparams.put("resourceType",resourceType);
		}
		if(resourceId != null){
    	queryparams.put("resourceId",resourceId);
		}
		if(createTime != null){
    	queryparams.put("createTime",createTime);
		}
		if(resourceName != null){
			queryparams.put("resourceName",resourceName);
		}
		//查询列表数据
        Query query = new Query(queryparams);

		List<PumpstationEntity> pumpstationList = pumpstationService.queryList(query);
		int total = pumpstationService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(pumpstationList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("泵站:查看")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		PumpstationEntity pumpstation = pumpstationService.queryObject(id);
		
		return R.ok().put("data", pumpstation);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("泵站:管理")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody PumpstationEntity pumpstation){
        verifyForm(pumpstation);
		pumpstationService.save(pumpstation);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("泵站:管理")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody PumpstationEntity pumpstation){
        verifyForm(pumpstation);
		pumpstationService.update(pumpstation);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("泵站:管理")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				pumpstationService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(PumpstationEntity pumpstation) {
		/*if (StringUtils.isBlank(pumpstation.getManagerCode())) {
			throw new RRException(270, "泵站管理单位编码不能为空");
		}
		if (StringUtils.isBlank(pumpstation.getUnderManager())) {
			throw new RRException(270, "泵站归口管理部门不能为空");
		}
		if (StringUtils.isBlank(pumpstation.getId())) {
			throw new RRException(270, "系统编码不能为空");
		}*/
		if (StringUtils.isBlank(pumpstation.getName())) {
			throw new RRException(270, "泵站名称不能为空");
		}
		if (StringUtils.isBlank(pumpstation.getCode())) {
			throw new RRException(270, "泵站编码不能为空");
		}
		if (StringUtils.isBlank(pumpstation.getX())) {
			throw new RRException(270, "经度不能为空");
		}
		if (StringUtils.isBlank(pumpstation.getY())) {
			throw new RRException(270, "纬度不能为空");
		}
		if (StringUtils.isBlank(pumpstation.getTask())) {
			throw new RRException(270, "泵站任务不能为空");
		}
		if (StringUtils.isBlank(pumpstation.getBuildSiuation())) {
			throw new RRException(270, "工程建设情况不能为空");
		}
		if (StringUtils.isBlank(pumpstation.getGrade())) {
			throw new RRException(270, "工程等别不能为空");
		}
		/*if (StringUtils.isBlank(pumpstation.getBuildLevel())) {
			throw new RRException(270, "主要建筑物级别不能为空");
		}
		if (StringUtils.isBlank(pumpstation.getInstalledFlow())) {
			throw new RRException(270, "装机流量不能为空");
		}*/
		if (StringUtils.isBlank(pumpstation.getInstalledPower())) {
			throw new RRException(270, "装机功率不能为空");
		}
		if (StringUtils.isBlank(pumpstation.getDesignLength())) {
			throw new RRException(270, "设计扬程不能为空");
		}
		/*if (StringUtils.isBlank(pumpstation.getCount())) {
			throw new RRException(270, "水泵数量不能为空");
		}*/
		if (StringUtils.isBlank(pumpstation.getManagerName())) {
			throw new RRException(270, "泵站管理单位不能为空");
		}
		/*if (StringUtils.isBlank(pumpstation.getAreaId())) {
			throw new RRException(270, "行政区划编码不能为空");
		}*/
		if (StringUtils.isBlank(pumpstation.getResourceType())) {
			throw new RRException(270, "河湖渠库类型不能为空");
		}
		if (StringUtils.isBlank(pumpstation.getResourceId())) {
			throw new RRException(270, "河湖渠库类型不能为空");
		}
	}


}