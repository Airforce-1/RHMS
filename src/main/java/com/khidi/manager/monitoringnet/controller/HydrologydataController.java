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

import com.khidi.manager.monitoringnet.entity.HydrologydataEntity;
import com.khidi.manager.monitoringnet.service.HydrologydataService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;




/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-08 13:25:47
 */
@RestController
@RequestMapping("hydrologydata")
@Api(value = "/Hydrologydata", description = "水文监测")
public class HydrologydataController {
	@Autowired
	private HydrologydataService hydrologydataService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("水文监测:查看")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="stationName",required=false) String stationId,
                  @RequestParam(value="startDate",required=false) String startDate,
				  @RequestParam(value="endDate",required=false) String endDate,
                  @RequestParam(value="speed",required=false) String speed,
                  @RequestParam(value="flow",required=false) String flow,
                  @RequestParam(value="yield",required=false) String yield				  ){
        Map<String,Object> queryparams = new HashMap<String,Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
		if(id != null){
    	queryparams.put("id",id);
		}
		if(stationId != null){
    	queryparams.put("stationId",stationId);
		}
		if(startDate != null){
    	queryparams.put("startDate", DateUtils.stringToDate(startDate,"yyyy-MM-dd HH:mm:ss"));
		}
		if(endDate != null){
			queryparams.put("endDate", DateUtils.stringToDate(endDate,"yyyy-MM-dd HH:mm:ss"));
		}
		if(speed != null){
    	queryparams.put("speed",speed);
		}
		if(flow != null){
    	queryparams.put("flow",flow);
		}
		if(yield != null){
    	queryparams.put("yield",yield);
		}
		//查询列表数据
        Query query = new Query(queryparams);

		List<HydrologydataEntity> hydrologydataList = hydrologydataService.queryList(query);
		int total = hydrologydataService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(hydrologydataList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}




	/**
	 * 列表
	 */
	@RequestMapping(value="/toplist",method = RequestMethod.GET)
	@RequiresPermissions("水文监测:查看")
	@ApiOperation(value = "列表",notes="")
	public R toplist(@RequestParam(value="page",required=true) int page,
				  @RequestParam(value="limit",required=true) int limit,
				  @RequestParam(value="areaId",required=false) String areaId,
				  @RequestParam(value="stationName",required=false) String stationName,
				  @RequestParam(value="startDate",required=false) String startDate,
				  @RequestParam(value="endDate",required=false) String endDate
				  			  ){
		Map<String,Object> queryparams = new HashMap<String,Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		if (areaId != null) {
			queryparams.put("areaId", areaId);
		}if (stationName != null) {
			queryparams.put("stationName", stationName);
		}if (startDate != null) {
			queryparams.put("startDate", DateUtils.stringToDate(startDate,"yyyy-MM-dd HH:mm:ss"));
		}if (endDate != null) {
			queryparams.put("endDate", DateUtils.stringToDate(endDate,"yyyy-MM-dd HH:mm:ss"));
		}
		//查询列表数据
		Query query = new Query(queryparams);

		List<HydrologydataEntity> hydrologydataList = hydrologydataService.querytopList(query);

		if(hydrologydataList.size() < page*limit){
			PageUtils pageUtil = new PageUtils(hydrologydataList.subList((page-1)*limit,hydrologydataList.size()), hydrologydataList.size(), query.getLimit(), query.getPage());
			return R.ok().put("page", pageUtil);
		}else{
			PageUtils pageUtil = new PageUtils(hydrologydataList.subList((page-1)*limit,page*limit), hydrologydataList.size(), query.getLimit(), query.getPage());
			return R.ok().put("page", pageUtil);
		}
	}

	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("水文监测:查看")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		HydrologydataEntity hydrologydata = hydrologydataService.queryObject(id);
		
		return R.ok().put("data", hydrologydata);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("水文监测:管理")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody HydrologydataEntity hydrologydata){
        verifyForm(hydrologydata);
		hydrologydataService.save(hydrologydata);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("水文监测:管理")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody HydrologydataEntity hydrologydata){
        verifyForm(hydrologydata);
		hydrologydataService.update(hydrologydata);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("水文监测:管理")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				hydrologydataService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(HydrologydataEntity hydrologydata){
	        if(StringUtils.isBlank(hydrologydata.getStationId())){
            throw new RRException(270,"监测站编码不能为空");
		}
//	        if(StringUtils.isBlank(hydrologydata.getCreatedate())){
//            throw new RRException(270,"监测时间不能为空");
////		}
//	        if(StringUtils.isBlank(hydrologydata.getSpeed())){
//            throw new RRException(270,"流速(m/s)不能为空");
//		}
//	        if(StringUtils.isBlank(hydrologydata.getFlow())){
//            throw new RRException(270,"流量(m3/s)不能为空");
//		}
//	        if(StringUtils.isBlank(hydrologydata.getYield())){
//            throw new RRException(270,"水量(万m3)不能为空");
//		}
	    }


}