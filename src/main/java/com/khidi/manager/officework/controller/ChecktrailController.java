package com.khidi.manager.officework.controller;

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

import com.khidi.manager.officework.entity.ChecktrailEntity;
import com.khidi.manager.officework.service.ChecktrailService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;




/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-10 11:56:31
 */
@RestController
@RequestMapping("checktrail")
@Api(value = "/Checktrail", description = "巡查轨迹")
public class ChecktrailController {
	@Autowired
	private ChecktrailService checktrailService;
	
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
                  @RequestParam(value="x",required=false) String x,
                  @RequestParam(value="recordid",required=false) String recordid,
                  @RequestParam(value="y",required=false) String y,
                  @RequestParam(value="createtime",required=false) Date createtime				  ){
        Map<String,Object> queryparams = new HashMap<String,Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
		if(id != null){
    	queryparams.put("id",id);
		}
		if(x != null){
    	queryparams.put("x",x);
		}
		if(recordid != null){
    	queryparams.put("recordid",recordid);
		}
		if(y != null){
    	queryparams.put("y",y);
		}
		if(createtime != null){
    	queryparams.put("createtime",createtime);
		}
		//查询列表数据
        Query query = new Query(queryparams);

		List<ChecktrailEntity> checktrailList = checktrailService.queryList(query);
		int total = checktrailService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(checktrailList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		ChecktrailEntity checktrail = checktrailService.queryObject(id);
		
		return R.ok().put("data", checktrail);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody ChecktrailEntity checktrail){
        verifyForm(checktrail);
		checktrailService.save(checktrail);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody ChecktrailEntity checktrail){
        verifyForm(checktrail);
		checktrailService.update(checktrail);
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
				checktrailService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(ChecktrailEntity checktrail){
        if(StringUtils.isBlank(checktrail.getId())){
            throw new RRException(270,"系统编码不能为空");
		}
	        if(StringUtils.isBlank(checktrail.getX())){
            throw new RRException(270,"经度不能为空");
		}
	        if(StringUtils.isBlank(checktrail.getRecordid())){
            throw new RRException(270,"巡查记录编码不能为空");
		}
	        if(StringUtils.isBlank(checktrail.getY())){
            throw new RRException(270,"纬度不能为空");
		}
	    }
}