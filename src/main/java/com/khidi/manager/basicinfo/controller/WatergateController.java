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

import com.khidi.manager.basicinfo.entity.WatergateEntity;
import com.khidi.manager.basicinfo.service.WatergateService;
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
@RequestMapping("watergate")
@Api(value = "/Watergate", description = "水闸管理")
public class WatergateController {
	@Autowired
	private WatergateService watergateService;

	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("水闸:查看")
	@ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
			@RequestParam(value="limit",required=true) int limit,
			@RequestParam(value="sidx",required=false) String sidx,
			@RequestParam(value="order",required=false) String order,
			@RequestParam(value="code",required=false) String code,
			@RequestParam(value="x",required=false) String x,
			@RequestParam(value="y",required=false) String y,
			@RequestParam(value="type",required=false) String type,
			@RequestParam(value="buildSituation",required=false) String buildSituation,
			@RequestParam(value="buildTime",required=false) Date buildTime,
			@RequestParam(value="irrigatedId",required=false) String irrigatedId,
			@RequestParam(value="islockstation",required=false) String islockstation,
			@RequestParam(value="iswaterlock",required=false) String iswaterlock,
			@RequestParam(value="managerName",required=false) String managerName,
			@RequestParam(value="areaId",required=false) String areaId,
			@RequestParam(value="createTime",required=false) Date createTime,
			@RequestParam(value="managerCode",required=false) String managerCode,
			@RequestParam(value="underManager",required=false) String underManager,
			@RequestParam(value="id",required=false) String id,
			@RequestParam(value="name",required=false) String name,
			@RequestParam(value="resourceId",required=false) String resourceId,
			@RequestParam(value="resourceName",required=false) String resourceName,
			@RequestParam(value="grade",required=false) String grade,
			@RequestParam(value="resourceType",required=false) String resourceType){
		Map<String,Object> queryparams = new HashMap<String,Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
		if(code != null){
			queryparams.put("code",code);
		}
		if(x != null){
			queryparams.put("x",x);
		}
		if(y != null){
			queryparams.put("y",y);
		}
		if(type != null){
			queryparams.put("type",type);
		}
		if(buildSituation != null){
			queryparams.put("buildSituation",buildSituation);
		}
		if(buildTime != null){
			queryparams.put("buildTime",buildTime);
		}
		if(irrigatedId != null){
			queryparams.put("irrigatedId",irrigatedId);
		}
		if(islockstation != null){
			queryparams.put("islockstation",islockstation);
		}
		if(iswaterlock != null){
			queryparams.put("iswaterlock",iswaterlock);
		}
		if(managerName != null){
			queryparams.put("managerName",managerName);
		}
		if(areaId != null){
			queryparams.put("areaId",areaId);
		}
		if(createTime != null){
			queryparams.put("createTime",createTime);
		}
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
		if(resourceId != null){
			queryparams.put("resourceId",resourceId);
		}
		if(resourceType != null){
			queryparams.put("resourceType",resourceType);
		}
		if(resourceName != null){
			queryparams.put("resourceName",resourceName);
		}
		if(grade != null){
			queryparams.put("grade",grade);
		}
		//查询列表数据
		Query query = new Query(queryparams);

		List<WatergateEntity> watergateList = watergateService.queryList(query);
		int total = watergateService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(watergateList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}


	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("水闸:查看")
	@ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		WatergateEntity watergate = watergateService.queryObject(id);
		//System.out.println("查找："+id);
		//System.out.println(watergate);
		return R.ok().put("data", watergate);
	}

	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("水闸:管理")
	@ApiOperation(value = "保存",notes="")
	public R save(@RequestBody WatergateEntity watergate){
		System.out.println(watergate.toString());
		verifyForm(watergate);
		watergateService.save(watergate);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("水闸:管理")
	@ApiOperation(value = "修改",notes="")
	public R update(@RequestBody WatergateEntity watergate){
		verifyForm(watergate);
		watergateService.update(watergate);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("水闸:管理")
	@ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
		String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
			watergateService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(WatergateEntity watergate){
		if(StringUtils.isBlank(watergate.getCode())){
			throw new RRException(270,"水闸编码不能为空");
		}
		if(StringUtils.isBlank(watergate.getX())){
			throw new RRException(270,"经度不能为空");
		}
		if(StringUtils.isBlank(watergate.getY())){
			throw new RRException(270,"纬度不能为空");
		}
		if(StringUtils.isBlank(watergate.getType())){
			throw new RRException(270,"水闸类型不能为空");
		}
		if(StringUtils.isBlank(watergate.getBuildSituation())){
			throw new RRException(270,"工程建设情况不能为空");
		}
		/*if(StringUtils.isBlank(watergate.getIrrigatedId())){
			throw new RRException(270,"所在灌区不能为空");
		}
		if(StringUtils.isBlank(watergate.getIslockstation())){
			throw new RRException(270,"是否闸站工程不能为空");
		}
		if(StringUtils.isBlank(watergate.getIswaterlock())){
			throw new RRException(270,"是否套站工程不能为空");
		}*/
		if(StringUtils.isBlank(watergate.getManagerName())){
			throw new RRException(270,"水闸管理单位不能为空");
		}
		/*if(StringUtils.isBlank(watergate.getAreaId())){
			throw new RRException(270,"行政区划不能为空");
		}
		if(StringUtils.isBlank(watergate.getManagerCode())){
			throw new RRException(270,"管理单位编码不能为空");
		}
		if(StringUtils.isBlank(watergate.getId())){
            throw new RRException(270,"系统编码不能为空");
		}*/
		if(StringUtils.isBlank(watergate.getName())){
			throw new RRException(270,"水闸名称不能为空");
		}
		if(StringUtils.isBlank(watergate.getGrade())){
			throw new RRException(270,"工程等别不能为空");
		}
	}


}