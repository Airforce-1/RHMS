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

import com.khidi.manager.basicinfo.entity.WatersourceEntity;
import com.khidi.manager.basicinfo.service.WatersourceService;
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
@RequestMapping("watersource")
@Api(value = "/Watersource", description = "水源地管理")
public class WatersourceController {
	@Autowired
	private WatersourceService watersourceService;

	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("水源地:查看")
	@ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
			@RequestParam(value="limit",required=true) int limit,
			@RequestParam(value="sidx",required=false) String sidx,
			@RequestParam(value="order",required=false) String order,
			@RequestParam(value="id",required=false) String id,
			@RequestParam(value="name",required=false) String name,
			@RequestParam(value="code",required=false) String code,
			@RequestParam(value="x",required=false) String x,
			@RequestParam(value="y",required=false) String y,
			@RequestParam(value="areaId",required=false) String areaId,
			@RequestParam(value="resourceType",required=false) String resourceType,
			@RequestParam(value="resourceId",required=false) String resourceId,
			@RequestParam(value="waterCount",required=false) String waterCount,
			@RequestParam(value="waterAim",required=false) String waterAim,
			@RequestParam(value="ismonitor",required=false) String ismonitor,
			@RequestParam(value="waterLevel",required=false) String waterLevel,
			@RequestParam(value="purpose",required=false) String purpose,
			@RequestParam(value="peopleCount",required=false) String peopleCount,
			@RequestParam(value="supplyAreaId",required=false) String supplyAreaId,
			@RequestParam(value="waterSize",required=false) String waterSize,
			@RequestParam(value="createTime",required=false) Date createTime,
			@RequestParam(value="managerName",required=false) String managerName,
			@RequestParam(value="managerCode",required=false) String managerCode,
			@RequestParam(value="resourceName",required=false) String resourceName,
			@RequestParam(value="managerTrade",required=false) String managerTrade){
		Map<String,Object> queryparams = new HashMap<String,Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
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
		if(areaId != null){
			queryparams.put("areaId",areaId);
		}
		if(resourceType != null){
			queryparams.put("resourceType",resourceType);
		}
		if(resourceId != null){
			queryparams.put("resourceId",resourceId);
		}
		if(waterCount != null){
			queryparams.put("waterCount",waterCount);
		}
		if(waterAim != null){
			queryparams.put("waterAim",waterAim);
		}
		if(ismonitor != null){
			queryparams.put("ismonitor",ismonitor);
		}
		if(waterLevel != null){
			queryparams.put("waterLevel",waterLevel);
		}
		if(purpose != null){
			queryparams.put("purpose",purpose);
		}
		if(peopleCount != null){
			queryparams.put("peopleCount",peopleCount);
		}
		if(supplyAreaId != null){
			queryparams.put("supplyAreaId",supplyAreaId);
		}
		if(waterSize != null){
			queryparams.put("waterSize",waterSize);
		}
		if(createTime != null){
			queryparams.put("createTime",createTime);
		}
		if(managerName != null){
			queryparams.put("managerName",managerName);
		}
		if(managerCode != null){
			queryparams.put("managerCode",managerCode);
		}
		if(managerTrade != null){
			queryparams.put("managerTrade",managerTrade);
		}
		if(resourceName != null){
			queryparams.put("resourceName",resourceName);
		}
		//查询列表数据
		Query query = new Query(queryparams);

		List<WatersourceEntity> watersourceList = watersourceService.queryList(query);
		int total = watersourceService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(watersourceList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}


	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("水源地:查看")
	@ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		WatersourceEntity watersource = watersourceService.queryObject(id);

		return R.ok().put("data", watersource);
	}

	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("水源地:管理")
	@ApiOperation(value = "保存",notes="")
	public R save(@RequestBody WatersourceEntity watersource){
		verifyForm(watersource);
		watersourceService.save(watersource);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("水源地:管理")
	@ApiOperation(value = "修改",notes="")
	public R update(@RequestBody WatersourceEntity watersource){
		verifyForm(watersource);
		watersourceService.update(watersource);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("水源地:管理")
	@ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
		String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
			watersourceService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(WatersourceEntity watersource){
		/*if(StringUtils.isBlank(watersource.getId())){
			throw new RRException(270,"系统编码不能为空");
		}*/
		if(StringUtils.isBlank(watersource.getName())){
			throw new RRException(270,"水源地名称不能为空");
		}
		if(StringUtils.isBlank(watersource.getCode())){
			throw new RRException(270,"水源地编码不能为空");
		}
		if(StringUtils.isBlank(watersource.getX())){
			throw new RRException(270,"经度不能为空");
		}
		if(StringUtils.isBlank(watersource.getY())){
			throw new RRException(270,"纬度不能为空");
		}
		/*if(StringUtils.isBlank(watersource.getAreaId())){
			throw new RRException(270,"行政区划不能为空");
		}*/
		if(StringUtils.isBlank(watersource.getResourceType())){
			throw new RRException(270,"河湖渠库类型不能为空");
		}
		if(StringUtils.isBlank(watersource.getResourceId())){
			throw new RRException(270,"河湖渠库名称不能为空");
		}
		/*if(StringUtils.isBlank(watersource.getWaterCount())){
			throw new RRException(270,"取水口个数不能为空");
		}
		if(StringUtils.isBlank(watersource.getWaterAim())){
			throw new RRException(270,"水质目标不能为空");
		}
		if(StringUtils.isBlank(watersource.getIsmonitor())){
			throw new RRException(270,"是否监测不能为空");
		}
		if(StringUtils.isBlank(watersource.getWaterLevel())){
			throw new RRException(270,"水源地现状水质类别不能为空");
		}
		if(StringUtils.isBlank(watersource.getPurpose())){
			throw new RRException(270,"主要供水用途不能为空");
		}
		if(StringUtils.isBlank(watersource.getPeopleCount())){
			throw new RRException(270,"供水人口（万人）不能为空");
		}
		if(StringUtils.isBlank(watersource.getSupplyAreaId())){
			throw new RRException(270,"主要供水城镇名称不能为空");
		}
		if(StringUtils.isBlank(watersource.getWaterSize())){
			throw new RRException(270,"供水规模（万立方米/日）不能为空");
		}*/
		if(StringUtils.isBlank(watersource.getManagerName())){
			throw new RRException(270,"管理单位名称不能为空");
		}
		/*if(StringUtils.isBlank(watersource.getManagerCode())){
			throw new RRException(270,"管理单位编码不能为空");
		}
		if(StringUtils.isBlank(watersource.getManagerTrade())){
			throw new RRException(270,"管理部门所属行业不能为空");
		}*/
	}


}