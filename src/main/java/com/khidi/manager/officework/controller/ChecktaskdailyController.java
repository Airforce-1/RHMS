package com.khidi.manager.officework.controller;

import com.khidi.common.utils.*;
import com.khidi.manager.officework.service.CheckrouteService;
import com.khidi.manager.officework.vo.ChecktaskEntityVo;
import com.khidi.manager.sys.controller.AbstractController;
import com.khidi.manager.sys.service.SysUserService;
import com.khidi.common.exception.RRException;
import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.regex.Pattern;

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

import com.khidi.manager.officework.entity.ChecktaskdailyEntity;
import com.khidi.manager.officework.service.ChecktaskdailyService;


/**
 * 日常巡查任务
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-22 11:37:03
 */
@RestController
@RequestMapping("checktaskdaily")
@Api(value = "/Checktaskdaily", description = "日常巡查任务")
public class ChecktaskdailyController extends AbstractController{
	@Autowired
	private ChecktaskdailyService checktaskdailyService;
	@Autowired
	private CheckrouteService checkrouteService;
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("日常巡查任务:查看")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="code",required=false) String code,
				  @RequestParam(value="areaId",required=false) String areaId,
                  @RequestParam(value="routeid",required=false) String routeid,
                  @RequestParam(value="checker",required=false) String checker,
                  @RequestParam(value="checktimes",required=false) String checktimes,
                  @RequestParam(value="unit",required=false) String unit,
                  @RequestParam(value="status",required=false) String status,
                  @RequestParam(value="lastbegintime",required=false) String lastbegintime,
                  @RequestParam(value="lastendtime",required=false) String lastendtime,
                  @RequestParam(value="begintime4start",required=false) String begintime4start,
                  @RequestParam(value="begintime4end",required=false) String begintime4end,
                  @RequestParam(value="createtime4start",required=false) String createtime4start,
				  @RequestParam(value="createtime4end",required=false) String createtime4end,
				  @RequestParam(value="resourceName",required=false) String resourceName){
        Map<String,Object> queryparams = new HashMap<String,Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
		if(id != null){
    		queryparams.put("id",id);
		}
		if(areaId != null){
			queryparams.put("areaid",areaId);
		}
		if(checker != null){
			queryparams.put("checker",checker);
		}
		if(resourceName != null){
			queryparams.put("resourceName",resourceName);
		}
		if(code != null){
    		queryparams.put("code",code);
		}
		if(routeid != null){
    		queryparams.put("routeid",routeid);
		}
		if(checktimes != null){
    		queryparams.put("checktimes",checktimes);
		}
		if(unit != null){
    		queryparams.put("unit",unit);
		}
		if(status != null){
    		queryparams.put("status",status);
		}
		if(lastbegintime != null){
			queryparams.put("lastbegintime", DateUtils.stringToDate(lastbegintime,"yyyy-MM-dd HH:mm:ss"));
		}
		if(lastendtime != null){
			queryparams.put("lastendtime", DateUtils.stringToDate(lastendtime,"yyyy-MM-dd HH:mm:ss"));
		}
		if(begintime4start != null){
			queryparams.put("begintime4start", DateUtils.stringToDate(begintime4start,"yyyy-MM-dd HH:mm:ss"));
		}
		if(begintime4end != null){
			queryparams.put("begintime4end", DateUtils.stringToDate(begintime4end,"yyyy-MM-dd HH:mm:ss"));
		}
		if(createtime4start != null){
			queryparams.put("createtime4start", DateUtils.stringToDate(createtime4start,"yyyy-MM-dd HH:mm:ss"));
		}
		if(createtime4end != null){
			queryparams.put("createtime4end", DateUtils.stringToDate(createtime4end,"yyyy-MM-dd HH:mm:ss"));
		}
		Query query = new Query(queryparams);

		List<ChecktaskEntityVo> checktaskdailyList = checktaskdailyService.queryList(query);
		int total = checktaskdailyService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(checktaskdailyList, total, query.getLimit(), query.getPage());
		return R.ok().put("page", pageUtil);

	}
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("日常巡查任务:查看")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		ChecktaskEntityVo checktaskdailyvo = checktaskdailyService.queryObject(id);
		return R.ok().put("data", checktaskdailyvo);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("日常巡查任务:管理")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody ChecktaskdailyEntity checktaskdaily){
        verifyForm(checktaskdaily);
		checktaskdaily.setTaskSender(getUserId());
		checktaskdailyService.save(checktaskdaily);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("日常巡查任务:管理")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody ChecktaskdailyEntity checktaskdaily){
        verifyForm(checktaskdaily);
		checktaskdaily.setTaskSender(getUserId());
		checktaskdailyService.update(checktaskdaily);
		return R.ok();
	}
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("日常巡查任务:管理")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				checktaskdailyService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(ChecktaskdailyEntity checktaskdaily){
		String regEx = "^-?[0-9]+$";
		Pattern pat = Pattern.compile(regEx);
	        if(StringUtils.isBlank(checktaskdaily.getRouteid())){
            throw new RRException(270,"巡查路线编码不能为空");
		}
	        if(StringUtils.isBlank(checktaskdaily.getChecker())){
            throw new RRException(270,"巡查员不能为空");
		}
	        if(StringUtils.isBlank(checktaskdaily.getChecktimes())){
            throw new RRException(270,"巡查频次不能为空");
		}
			if(!StringUtils.isNumeric(checktaskdaily.getChecktimes())){
			throw new RRException(260,"巡查频次必须为数字");
		}
	        if(StringUtils.isBlank(checktaskdaily.getUnit())){
            throw new RRException(270,"巡查频次单位不能为空");
		}
	        if(StringUtils.isBlank(checktaskdaily.getStatus())){
            throw new RRException(270,"任务状态不能为空");
		}
	        if(checktaskdaily.getBegintime()== null){
            throw new RRException(270,"任务启用时间不能为空");
		}
	        if(checktaskdaily.getEndtime()==null){
            throw new RRException(270,"任务失效时间不能为空");
		}
	    }
}