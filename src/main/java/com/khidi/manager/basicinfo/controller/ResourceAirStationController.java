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

import com.khidi.manager.basicinfo.entity.ResourceAirStationEntity;
import com.khidi.manager.basicinfo.service.ResourceAirStationService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;




/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-30 09:39:48
 */
@RestController
@RequestMapping("resourceairstation")
@Api(value = "/ResourceAirStation", description = "空气监测站管理")
public class ResourceAirStationController {
	@Autowired
	private ResourceAirStationService resourceAirStationService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("空气监测站:查看")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="name",required=false) String name,
                  @RequestParam(value="address",required=false) String address,
                  @RequestParam(value="areaId",required=false) String areaId,
                  @RequestParam(value="x",required=false) String x,
                  @RequestParam(value="y",required=false) String y,
                  @RequestParam(value="createTime",required=false) Date createTime				  ){
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
		if(address != null){
    	queryparams.put("address",address);
		}
		if(areaId != null){
    	queryparams.put("areaId",areaId);
		}
		if(x != null){
    	queryparams.put("x",x);
		}
		if(y != null){
    	queryparams.put("y",y);
		}
		if(createTime != null){
    	queryparams.put("createTime",createTime);
		}
		//查询列表数据
        Query query = new Query(queryparams);

		List<ResourceAirStationEntity> resourceAirStationList = resourceAirStationService.queryList(query);
		int total = resourceAirStationService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(resourceAirStationList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("空气监测站:查看")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		ResourceAirStationEntity resourceAirStation = resourceAirStationService.queryObject(id);
		
		return R.ok().put("data", resourceAirStation);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("空气监测站:管理")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody ResourceAirStationEntity resourceAirStation){
        verifyForm(resourceAirStation);
		resourceAirStationService.save(resourceAirStation);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("空气监测站:管理")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody ResourceAirStationEntity resourceAirStation){
        verifyForm(resourceAirStation);
		resourceAirStationService.update(resourceAirStation);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("空气监测站:管理")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				resourceAirStationService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(ResourceAirStationEntity resourceAirStation){
	        if(StringUtils.isBlank(resourceAirStation.getName())){
            throw new RRException(270,"监测站名称不能为空");
		}
	        if(StringUtils.isBlank(resourceAirStation.getAddress())){
            throw new RRException(270,"监测站地址不能为空");
		}
	        if(StringUtils.isBlank(resourceAirStation.getAreaId())){
            throw new RRException(270,"所属行政区划不能为空");
		}
	        if(StringUtils.isBlank(resourceAirStation.getX())){
            throw new RRException(270,"经度不能为空");
		}
	        if(StringUtils.isBlank(resourceAirStation.getY())){
            throw new RRException(270,"纬度不能为空");
		}
	    }
}