package com.khidi.manager.gis.controller;

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

import com.khidi.manager.gis.entity.CustomlayerEntity;
import com.khidi.manager.gis.service.CustomlayerService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;




/**
 * ${comments}
 * 
 * @author fu
 * @email
 * @date 2018-01-30 17:55:17
 */
@RestController
@RequestMapping("customlayer")
@Api(value = "/Customlayer", description = "自定义图层")
public class CustomlayerController {
	@Autowired
	private CustomlayerService customlayerService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
//	@RequiresPermissions("自定义图层:查看")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="title",required=false) String title,
                  @RequestParam(value="geoset",required=false) String geoset				  ){
        Map<String,Object> queryparams = new HashMap<String,Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
		if(id != null){
    	queryparams.put("id",id);
		}
		if(title != null){
    	queryparams.put("title",title);
		}
		if(geoset != null){
    	queryparams.put("geoset",geoset);
		}
		//查询列表数据
        Query query = new Query(queryparams);

		List<CustomlayerEntity> customlayerList = customlayerService.queryList(query);
		int total = customlayerService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(customlayerList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
//	@RequiresPermissions("自定义图层:查看")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		CustomlayerEntity customlayer = customlayerService.queryObject(id);
		
		return R.ok().put("data", customlayer);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
//	@RequiresPermissions("自定义图层:管理")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody CustomlayerEntity customlayer){
        verifyForm(customlayer);
		customlayerService.save(customlayer);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
//	@RequiresPermissions("自定义图层:管理")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody CustomlayerEntity customlayer){
        verifyForm(customlayer);
		customlayerService.update(customlayer);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
//	@RequiresPermissions("自定义图层:管理")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				customlayerService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(CustomlayerEntity customlayer){
	        if(StringUtils.isBlank(customlayer.getTitle())){
            throw new RRException(270,"图层名称不能为空");
		}
	        if(StringUtils.isBlank(customlayer.getGeoset())){
            throw new RRException(270,"点集不能为空");
		}
	    }


}