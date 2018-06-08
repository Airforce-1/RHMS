package com.khidi.manager.monitoringnet.controller;

import com.khidi.common.utils.DateUtils;
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

import com.khidi.manager.monitoringnet.entity.DataAirEntity;
import com.khidi.manager.monitoringnet.service.DataAirService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;




/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-30 14:23:59
 */
@RestController
@RequestMapping("dataair")
@Api(value = "/DataAir", description = "空气质量监测数据")
public class DataAirController {
	@Autowired
	private DataAirService dataAirService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("空气质量监测:查看")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="stationId",required=false) String stationId,
                  @RequestParam(value="monitorTime",required=false) String monitorTime,
				  @RequestParam(value="startTime",required=false) String startTime,
				  @RequestParam(value="endTime",required=false) String endTime,
                  @RequestParam(value="aqi",required=false) String aqi,
                  @RequestParam(value="airLevel",required=false) String airLevel,
                  @RequestParam(value="primaryPollutant",required=false) String primaryPollutant,
                  @RequestParam(value="pm25",required=false) String pm25,
                  @RequestParam(value="pm10",required=false) String pm10,
                  @RequestParam(value="co",required=false) String co,
                  @RequestParam(value="no2",required=false) String no2,
                  @RequestParam(value="o31h",required=false) String o31h,
                  @RequestParam(value="o38h",required=false) String o38h,
                  @RequestParam(value="so2",required=false) String so2,
                  @RequestParam(value="createTime",required=false) Date createTime				  ){
        Map<String,Object> queryparams = new HashMap<String,Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
		if(startTime != null){
			queryparams.put("startTime", startTime.replace(" ",""));
		}
		if(endTime != null){
			queryparams.put("endTime",endTime.replace(" ",""));
		}
		if(id != null){
    	queryparams.put("id",id);
		}
		if(stationId != null){
    	queryparams.put("stationId",stationId);
		}
		if(monitorTime != null){
    	queryparams.put("monitorTime",monitorTime);
		}
		if(aqi != null){
    	queryparams.put("aqi",aqi);
		}
		if(airLevel != null){
    	queryparams.put("airLevel",airLevel);
		}
		if(primaryPollutant != null){
    	queryparams.put("primaryPollutant",primaryPollutant);
		}
		if(pm25 != null){
    	queryparams.put("pm25",pm25);
		}
		if(pm10 != null){
    	queryparams.put("pm10",pm10);
		}
		if(co != null){
    	queryparams.put("co",co);
		}
		if(no2 != null){
    	queryparams.put("no2",no2);
		}
		if(o31h != null){
    	queryparams.put("o31h",o31h);
		}
		if(o38h != null){
    	queryparams.put("o38h",o38h);
		}
		if(so2 != null){
    	queryparams.put("so2",so2);
		}
		if(createTime != null){
    	queryparams.put("createTime",createTime);
		}
		//查询列表数据
        Query query = new Query(queryparams);

		List<DataAirEntity> dataAirList = dataAirService.queryList(query);
		int total = dataAirService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(dataAirList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("空气质量监测:查看")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		DataAirEntity dataAir = dataAirService.queryObject(id);
		
		return R.ok().put("data", dataAir);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("空气质量监测:管理")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody DataAirEntity dataAir){
        verifyForm(dataAir);
		dataAirService.save(dataAir);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("空气质量监测:管理")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody DataAirEntity dataAir){
        verifyForm(dataAir);
		dataAirService.update(dataAir);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("空气质量监测:管理")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				dataAirService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(DataAirEntity dataAir){
        if(StringUtils.isBlank(dataAir.getId())){
            throw new RRException(270,"系统编码不能为空");
		}
	        if(StringUtils.isBlank(dataAir.getStationId())){
            throw new RRException(270,"监测站编码不能为空");
		}
	        if(StringUtils.isBlank(dataAir.getMonitorTime())){
            throw new RRException(270,"监测时间不能为空");
		}
	        if(StringUtils.isBlank(dataAir.getAqi())){
            throw new RRException(270,"空气质量指数不能为空");
		}
	        if(StringUtils.isBlank(dataAir.getAirLevel())){
            throw new RRException(270,"空气质量评价不能为空");
		}
	        if(StringUtils.isBlank(dataAir.getPrimaryPollutant())){
            throw new RRException(270,"主要污染物不能为空");
		}
	        if(StringUtils.isBlank(dataAir.getPm25())){
            throw new RRException(270,"PM2.5(μg/m3)不能为空");
		}
	        if(StringUtils.isBlank(dataAir.getPm10())){
            throw new RRException(270,"PM10(μg/m3)不能为空");
		}
	        if(StringUtils.isBlank(dataAir.getCo())){
            throw new RRException(270,"一氧化碳(μg/m3)不能为空");
		}
	        if(StringUtils.isBlank(dataAir.getNo2())){
            throw new RRException(270,"二氧化氮(μg/m3)不能为空");
		}
	        if(StringUtils.isBlank(dataAir.getO31h())){
            throw new RRException(270,"臭氧1H(ppm)不能为空");
		}
	        if(StringUtils.isBlank(dataAir.getO38h())){
            throw new RRException(270,"臭氧8H(ppm)不能为空");
		}
	        if(StringUtils.isBlank(dataAir.getSo2())){
            throw new RRException(270,"二氧化硫(μg/m3)不能为空");
		}
	    }


}