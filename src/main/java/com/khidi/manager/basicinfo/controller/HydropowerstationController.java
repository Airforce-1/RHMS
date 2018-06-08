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

import com.khidi.manager.basicinfo.entity.HydropowerstationEntity;
import com.khidi.manager.basicinfo.service.HydropowerstationService;
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
@RequestMapping("hydropowerstation")
@Api(value = "/Hydropowerstation", description = "水电站管理")
public class HydropowerstationController {
	@Autowired
	private HydropowerstationService hydropowerstationService;

	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("水电站:查看")
	@ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
			@RequestParam(value="limit",required=true) int limit,
			@RequestParam(value="sidx",required=false) String sidx,
			@RequestParam(value="order",required=false) String order,
			@RequestParam(value="id",required=false) String id,
			@RequestParam(value="y",required=false) String y,
			@RequestParam(value="type",required=false) String type,
			@RequestParam(value="code",required=false) String code,
			@RequestParam(value="name",required=false) String name,
			@RequestParam(value="x",required=false) String x,
			@RequestParam(value="buildSituation",required=false) String buildSituation,
			@RequestParam(value="buildTime",required=false) Date buildTime,
			@RequestParam(value="buildLevel",required=false) String buildLevel,
			@RequestParam(value="grade",required=false) String grade,
			@RequestParam(value="installedCapacity",required=false) String installedCapacity,
			@RequestParam(value="power",required=false) String power,
			@RequestParam(value="waterHead",required=false) String waterHead,
			@RequestParam(value="unitNumber",required=false) String unitNumber,
			@RequestParam(value="manager",required=false) String manager,
			@RequestParam(value="resourceType",required=false) String resourceType,
			@RequestParam(value="resourceId",required=false) String resourceId,
			@RequestParam(value="areaId",required=false) String areaId,
			@RequestParam(value="resourceName",required=false) String resourceName,
			@RequestParam(value="createTime",required=false) Date createTime				  ){
		Map<String,Object> queryparams = new HashMap<String,Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
		if(id != null){
			queryparams.put("id",id);
		}
		if(y != null){
			queryparams.put("y",y);
		}
		if(type != null){
			queryparams.put("type",type);
		}
		if(code != null){
			queryparams.put("code",code);
		}
		if(name != null){
			queryparams.put("name",name);
		}
		if(x != null){
			queryparams.put("x",x);
		}
		if(buildSituation != null){
			queryparams.put("buildSituation",buildSituation);
		}
		if(buildTime != null){
			queryparams.put("buildTime",buildTime);
		}
		if(buildLevel != null){
			queryparams.put("buildLevel",buildLevel);
		}
		if(grade != null){
			queryparams.put("grade",grade);
		}
		if(installedCapacity != null){
			queryparams.put("installedCapacity",installedCapacity);
		}
		if(power != null){
			queryparams.put("power",power);
		}
		if(waterHead != null){
			queryparams.put("waterHead",waterHead);
		}
		if(unitNumber != null){
			queryparams.put("unitNumber",unitNumber);
		}
		if(manager != null){
			queryparams.put("manager",manager);
		}
		if(resourceType != null){
			queryparams.put("resourceType",resourceType);
		}
		if(resourceId != null){
			queryparams.put("resourceId",resourceId);
		}
		if(areaId != null){
			queryparams.put("areaId",areaId);
		}
		if(createTime != null){
			queryparams.put("createTime",createTime);
		}
		if(resourceName != null){
			queryparams.put("resourceName",resourceName);
		}
		//查询列表数据
		Query query = new Query(queryparams);

		List<HydropowerstationEntity> hydropowerstationList = hydropowerstationService.queryList(query);
		int total = hydropowerstationService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(hydropowerstationList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}


	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("水电站:查看")
	@ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		HydropowerstationEntity hydropowerstation = hydropowerstationService.queryObject(id);

		return R.ok().put("data", hydropowerstation);
	}

	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("水电站:管理")
	@ApiOperation(value = "保存",notes="")
	public R save(@RequestBody HydropowerstationEntity hydropowerstation){
		verifyForm(hydropowerstation);
		hydropowerstationService.save(hydropowerstation);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("水电站:管理")
	@ApiOperation(value = "修改",notes="")
	public R update(@RequestBody HydropowerstationEntity hydropowerstation){
		verifyForm(hydropowerstation);
		hydropowerstationService.update(hydropowerstation);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("水电站:管理")
	@ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
		String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
			hydropowerstationService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(HydropowerstationEntity hydropowerstation){
		/*if(StringUtils.isBlank(hydropowerstation.getId())){
			throw new RRException(270,"系统编码不能为空");
		}*/
		if(StringUtils.isBlank(hydropowerstation.getY())){
			throw new RRException(270,"纬度不能为空");
		}
		if(StringUtils.isBlank(hydropowerstation.getType())){
			throw new RRException(270,"水电站类型不能为空");
		}
		if(StringUtils.isBlank(hydropowerstation.getCode())){
			throw new RRException(270,"水电站编码不能为空");
		}
		if(StringUtils.isBlank(hydropowerstation.getName())){
			throw new RRException(270,"水电站名称不能为空");
		}
		if(StringUtils.isBlank(hydropowerstation.getX())){
			throw new RRException(270,"经度不能为空");
		}
		if(StringUtils.isBlank(hydropowerstation.getBuildSituation())){
			throw new RRException(270,"工程建设情况不能为空");
		}
		/*if(StringUtils.isBlank(hydropowerstation.getBuildLevel())){
			throw new RRException(270,"主要建筑物级别不能为空");
		}*/
		if(StringUtils.isBlank(hydropowerstation.getGrade())){
			throw new RRException(270,"工程等别不能为空");
		}
		if(StringUtils.isBlank(hydropowerstation.getInstalledCapacity())){
			throw new RRException(270,"装机容量不能为空");
		}
		/*if(StringUtils.isBlank(hydropowerstation.getPower())){
            throw new RRException(270,"保证出力不能为空");
		}
	        if(StringUtils.isBlank(hydropowerstation.getWaterHead())){
            throw new RRException(270,"额定水头不能为空");
		}
	        if(StringUtils.isBlank(hydropowerstation.getUnitNumber())){
            throw new RRException(270,"机组台数不能为空");
		}*/
		if(StringUtils.isBlank(hydropowerstation.getManager())){
			throw new RRException(270,"管理单位不能为空");
		}
		if(StringUtils.isBlank(hydropowerstation.getResourceType())){
			throw new RRException(270,"资源类型不能为空");
		}
		if(StringUtils.isBlank(hydropowerstation.getResourceId())){
			throw new RRException(270,"资源编码不能为空");
		}
		/*if(StringUtils.isBlank(hydropowerstation.getAreaId())){
			throw new RRException(270,"行政区划编码不能为空");
		}*/
	}


}