package com.khidi.manager.gb.controller;

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

import com.khidi.manager.gb.entity.StandardWaterEntity;
import com.khidi.manager.gb.service.StandardWaterService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;




/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-29 11:12:03
 */
@RestController
@RequestMapping("standardwater")
@Api(value = "/StandardWater", description = "地表水环境质量标准GB3838")
public class StandardWaterController {
	@Autowired
	private StandardWaterService standardWaterService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="item",required=false) String item,
                  @RequestParam(value="riverOne",required=false) String riverOne,
                  @RequestParam(value="riverTwo",required=false) String riverTwo,
                  @RequestParam(value="riverThree",required=false) String riverThree,
                  @RequestParam(value="riverFour",required=false) String riverFour,
                  @RequestParam(value="riverFive",required=false) String riverFive,
                  @RequestParam(value="lakeOne",required=false) String lakeOne,
                  @RequestParam(value="lakeTwo",required=false) String lakeTwo,
                  @RequestParam(value="lakeThree",required=false) String lakeThree,
                  @RequestParam(value="lakeFour",required=false) String lakeFour,
                  @RequestParam(value="lakeFive",required=false) String lakeFive				  ){
        Map<String,Object> queryparams = new HashMap<String,Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
		if(id != null){
    	queryparams.put("id",id);
		}
		if(item != null){
    	queryparams.put("item",item);
		}
		if(riverOne != null){
    	queryparams.put("riverOne",riverOne);
		}
		if(riverTwo != null){
    	queryparams.put("riverTwo",riverTwo);
		}
		if(riverThree != null){
    	queryparams.put("riverThree",riverThree);
		}
		if(riverFour != null){
    	queryparams.put("riverFour",riverFour);
		}
		if(riverFive != null){
    	queryparams.put("riverFive",riverFive);
		}
		if(lakeOne != null){
    	queryparams.put("lakeOne",lakeOne);
		}
		if(lakeTwo != null){
    	queryparams.put("lakeTwo",lakeTwo);
		}
		if(lakeThree != null){
    	queryparams.put("lakeThree",lakeThree);
		}
		if(lakeFour != null){
    	queryparams.put("lakeFour",lakeFour);
		}
		if(lakeFive != null){
    	queryparams.put("lakeFive",lakeFive);
		}
		//查询列表数据
        Query query = new Query(queryparams);

		List<StandardWaterEntity> standardWaterList = standardWaterService.queryList(query);
		int total = standardWaterService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(standardWaterList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		StandardWaterEntity standardWater = standardWaterService.queryObject(id);
		
		return R.ok().put("data", standardWater);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody StandardWaterEntity standardWater){
        verifyForm(standardWater);
		standardWaterService.save(standardWater);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody StandardWaterEntity standardWater){
        verifyForm(standardWater);
		standardWaterService.update(standardWater);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				standardWaterService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(StandardWaterEntity standardWater){
        if(StringUtils.isBlank(standardWater.getId())){
            throw new RRException(270,"系统编码不能为空");
		}
	        if(StringUtils.isBlank(standardWater.getItem())){
            throw new RRException(270,"参考项目不能为空");
		}
	        if(StringUtils.isBlank(standardWater.getRiverOne())){
            throw new RRException(270,"河流一类水标准不能为空");
		}
	        if(StringUtils.isBlank(standardWater.getRiverTwo())){
            throw new RRException(270,"河流二类水标准不能为空");
		}
	        if(StringUtils.isBlank(standardWater.getRiverThree())){
            throw new RRException(270,"河流三类水标准不能为空");
		}
	        if(StringUtils.isBlank(standardWater.getRiverFour())){
            throw new RRException(270,"河流四类水标准不能为空");
		}
	        if(StringUtils.isBlank(standardWater.getRiverFive())){
            throw new RRException(270,"河流五类水标准不能为空");
		}
	        if(StringUtils.isBlank(standardWater.getLakeOne())){
            throw new RRException(270,"湖泊一类水标准不能为空");
		}
	        if(StringUtils.isBlank(standardWater.getLakeTwo())){
            throw new RRException(270,"湖泊二类水标准不能为空");
		}
	        if(StringUtils.isBlank(standardWater.getLakeThree())){
            throw new RRException(270,"湖泊三类水标准不能为空");
		}
	        if(StringUtils.isBlank(standardWater.getLakeFour())){
            throw new RRException(270,"湖泊四类水标准不能为空");
		}
	        if(StringUtils.isBlank(standardWater.getLakeFive())){
            throw new RRException(270,"湖泊五类水标准不能为空");
		}
	    }


}