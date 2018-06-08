package com.khidi.manager.officework.controller;

import io.swagger.annotations.ApiParam;
import com.khidi.common.exception.RRException;
import org.apache.commons.lang.StringUtils;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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

import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import com.khidi.manager.hbmwf.engine.hbmwfservice.internalapi.WfInternalApi;
import com.khidi.manager.officework.entity.MeetingMEntity;
import com.khidi.manager.officework.service.MeetingMService;

import java.util.HashMap;




/**
 * ${comments}
 * 
 * @author wangshunbo
 * @email 405877884@qq.com
 * @date 2017-12-16 13:52:08
 */
@RestController
@RequestMapping("meetingm")
@Api(value = "/MeetingM", description = "会议管理(流程)")
public class MeetingMController {
	@Autowired
	private MeetingMService meetingMService;
	
	@Autowired
	private WfInternalApi wfInternalApi;
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
//	@RequiresPermissions("会议管理:查看")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="title",required=false) String title,
                  @RequestParam(value="presenters",required=false) String presenters,
                  @RequestParam(value="stime",required=false) Date stime,
                  @RequestParam(value="etime",required=false) Date etime,
                  @RequestParam(value="mtype",required=false) String mtype,
                  @RequestParam(value="mtypename",required=false) String mtypename,
                  @RequestParam(value="mposition",required=false) String mposition				  ){
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
		if(presenters != null){
    	queryparams.put("presenters",presenters);
		}
		if(stime != null){
    	queryparams.put("stime",stime);
		}
		if(etime != null){
    	queryparams.put("etime",etime);
		}
		if(mtype != null){
    	queryparams.put("mtype",mtype);
		}
		if(mtypename != null){
    	queryparams.put("mtypename",mtypename);
		}
		if(mposition != null){
    	queryparams.put("mposition",mposition);
		}
		//查询列表数据
        Query query = new Query(queryparams);

		List<MeetingMEntity> meetingMList = meetingMService.queryList(query);
		int total = meetingMService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(meetingMList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
//	@RequiresPermissions("会议管理:查看")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		MeetingMEntity meetingM = meetingMService.queryObject(id);
		
		return R.ok().put("data", meetingM);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
//	@RequiresPermissions("会议管理:管理")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody MeetingMEntity meetingM){
		meetingM.setId(String.valueOf(UUID.randomUUID()));
        verifyForm(meetingM);
		meetingMService.save(meetingM);
		return R.ok().put("data", meetingM);
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
//	@RequiresPermissions("会议管理:管理")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody MeetingMEntity meetingM){
        verifyForm(meetingM);
		meetingMService.update(meetingM);
		return R.ok().put("data", meetingM);
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
//	@RequiresPermissions("会议管理:管理")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				meetingMService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(MeetingMEntity meetingM){
        if(StringUtils.isBlank(meetingM.getId())){
            throw new RRException(270,"编号不能为空");
		}
	        if(StringUtils.isBlank(meetingM.getTitle())){
            throw new RRException(270,"标题不能为空");
		}
//	        if(StringUtils.isBlank(meetingM.getPresenters())){
//            throw new RRException(270,"会议主持人不能为空");
//		}
//	        if(StringUtils.isBlank(meetingM.getStime())){
//            throw new RRException(270,"会议开始时间不能为空");
//		}
//	        if(StringUtils.isBlank(meetingM.getEtime())){
//            throw new RRException(270,"会议结束时间不能为空");
//		}
	        if(StringUtils.isBlank(meetingM.getMtype())){
            throw new RRException(270,"会议类型不能为空");
		}
//	        if(StringUtils.isBlank(meetingM.getMtypeName())){
//            throw new RRException(270,"会议类型名称不能为空");
//		}
//	        if(StringUtils.isBlank(meetingM.getMposition())){
//            throw new RRException(270,"会议地点不能为空");
//		}
	    }


}