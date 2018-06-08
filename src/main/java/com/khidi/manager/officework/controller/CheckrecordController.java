package com.khidi.manager.officework.controller;

import com.khidi.common.utils.DateUtils;
import com.khidi.manager.officework.vo.CheckRecordVo;
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

import com.khidi.manager.officework.entity.CheckrecordEntity;
import com.khidi.manager.officework.service.CheckrecordService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;

import static com.khidi.common.utils.ShiroUtils.getUserId;


/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-10 11:56:31
 */
@RestController
@RequestMapping("checkrecord")
@Api(value = "/Checkrecord", description = "巡查记录")
public class CheckrecordController {
	@Autowired
	private CheckrecordService checkrecordService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("巡查记录:查看")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="areaId",required=false) String areaId,
                  @RequestParam(value="resourceName",required=false) String resourceName,
				  @RequestParam(value="checker",required=false) String checker,
                  @RequestParam(value="checkstarttime",required=false) String checkstarttime,
				  @RequestParam(value="checkendtime",required=false) String checkendtime,
                  @RequestParam(value="eventids",required=false) String eventids,
                  @RequestParam(value="iswaterdirty",required=false) String iswaterdirty,
                  @RequestParam(value="isoccupyriver",required=false) String isoccupyriver,
                  @RequestParam(value="isfloater",required=false) String isfloater,
                  @RequestParam(value="isrubbish",required=false) String isrubbish,
                  @RequestParam(value="issmelly",required=false) String issmelly				  ){
        Map<String,Object> queryparams = new HashMap<String,Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
		if(areaId != null){
			queryparams.put("areaId",areaId);
		}
		if(resourceName != null){
			queryparams.put("resourceName",resourceName);
		}
		if(checker != null){
			queryparams.put("checker",checker);
		}
		if(checkstarttime != null){
			queryparams.put("checkstarttime", DateUtils.stringToDate(checkstarttime,"yyyy-MM-dd HH:mm:ss"));
		}
		if(checkendtime != null){
			queryparams.put("checkendtime", DateUtils.stringToDate(checkendtime,"yyyy-MM-dd HH:mm:ss"));
		}
		if(eventids != null){
    	queryparams.put("eventids",eventids);
		}
		if(iswaterdirty != null){
    	queryparams.put("iswaterdirty",iswaterdirty);
		}
		if(isoccupyriver != null){
    	queryparams.put("isoccupyriver",isoccupyriver);
		}
		if(isfloater != null){
    	queryparams.put("isfloater",isfloater);
		}
		if(isrubbish != null){
    	queryparams.put("isrubbish",isrubbish);
		}
		if(issmelly != null){
    	queryparams.put("issmelly",issmelly);
		}


		//查询列表数据
        Query query = new Query(queryparams);
		//加入用户id过滤出该用户的巡查任务
		query.put("userId",getUserId());

		List<CheckRecordVo> checkrecordList = checkrecordService.queryList(query);
		int total = checkrecordService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(checkrecordList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("巡查记录:查看")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		CheckrecordEntity checkrecord = checkrecordService.queryObject(id);
		
		return R.ok().put("data", checkrecord);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("巡查记录:管理")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody CheckrecordEntity checkrecord){
        verifyForm(checkrecord);
		checkrecordService.save(checkrecord);
		return R.ok();
	}



    private void verifyForm(CheckrecordEntity checkrecord){
	        if(StringUtils.isBlank(checkrecord.getCheckstarttime().toString())){
            throw new RRException(270,"巡查开始时间不能为空");
		}
	        if(StringUtils.isBlank(checkrecord.getCheckendtime().toString())){
            throw new RRException(270,"巡查结束时间不能为空");
		}
//	        if(StringUtils.isBlank(checkrecord.getSituation())){
//            throw new RRException(270,"巡查工作情况不能为空");
//		}
//	        if(StringUtils.isBlank(checkrecord.getAttachmentids())){
//            throw new RRException(270,"附件编码不能为空");
//		}
	        if(StringUtils.isBlank(checkrecord.getIswaterdirty())){
            throw new RRException(270,"生活污水的收集、处置、排放不合规不能为空");
		}
	        if(StringUtils.isBlank(checkrecord.getIsoccupyriver())){
            throw new RRException(270,"河道周边有违章搭建、占用河道情况不能为空");
		}
	        if(StringUtils.isBlank(checkrecord.getIsfloater())){
            throw new RRException(270,"河面有成片漂浮废弃物不能为空");
		}
	        if(StringUtils.isBlank(checkrecord.getIsrubbish())){
            throw new RRException(270,"河岸有垃圾堆放不能为空");
		}
	        if(StringUtils.isBlank(checkrecord.getIssmelly())){
            throw new RRException(270,"河道水体有臭味、异常颜色不能为空");
		}
	    }


}