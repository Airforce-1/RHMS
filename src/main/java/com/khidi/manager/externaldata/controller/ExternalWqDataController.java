package com.khidi.manager.externaldata.controller;

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

import com.khidi.manager.externaldata.entity.ExternalWqDataEntity;
import com.khidi.manager.externaldata.service.ExternalWqDataService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;




/**
 * 水质接口数据管理
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-24 10:56:45
 */
@RestController
@RequestMapping("externalwqdata")
@Api(value = "/ExternalWqData", description = "水质接口数据管理")
public class ExternalWqDataController {
	@Autowired
	private ExternalWqDataService externalWqDataService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
//	@RequiresPermissions("externalwqdata:list")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="stationId",required=false) String stationId,
                  @RequestParam(value="monitorTime",required=false) Date monitorTime,
                  @RequestParam(value="item",required=false) String item,
                  @RequestParam(value="value",required=false) String value,
                  @RequestParam(value="unit",required=false) String unit,
                  @RequestParam(value="createTime",required=false) Date createTime				  ){
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
		if(monitorTime != null){
    	queryparams.put("monitorTime",monitorTime);
		}
		if(item != null){
    	queryparams.put("item",item);
		}
		if(value != null){
    	queryparams.put("value",value);
		}
		if(unit != null){
    	queryparams.put("unit",unit);
		}
		if(createTime != null){
    	queryparams.put("createTime",createTime);
		}
		//查询列表数据
        Query query = new Query(queryparams);

		List<ExternalWqDataEntity> externalWqDataList = externalWqDataService.queryList(query);
		int total = externalWqDataService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(externalWqDataList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
//	@RequiresPermissions("externalwqdata:info")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		ExternalWqDataEntity externalWqData = externalWqDataService.queryObject(id);
		
		return R.ok().put("data", externalWqData);
	}
	

	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
//	@RequiresPermissions("externalwqdata:delete")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				externalWqDataService.delete(strings[i]);
		}
		return R.ok();
	}


}