package com.khidi.manager.sys.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import com.khidi.manager.sys.entity.SysLogEntity;
import com.khidi.manager.sys.service.SysLogService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 系统日志管理
 * 
 * @author shudewei
 * @email 53725025@qq.com.com
 * @date 2017-10-08 10:40:56
 */
@Controller
@RequestMapping("/sys/log")
@Api(value="/sys/log",description="系统日志")
public class SysLogController {
	@Autowired
	private SysLogService sysLogService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping(path="/list",method=RequestMethod.GET)
	@RequiresPermissions("系统日志:查看")
	@ApiOperation(value="获取日志列表", notes="获取日志列表")
	public R list(@RequestParam(value="page",required=true) int page,
				  @RequestParam(value="limit",required=true) int limit,
				  @RequestParam(value="sidx",required=false) String sidx,
				  @RequestParam(value="order",required=false) String order,
				  @RequestParam(value="id",required=false) String id,
				  @RequestParam(value="username",required=false) String username,
				  @RequestParam(value="operation",required=false) String operation,
				  @RequestParam(value="method",required=false) String method,
				  @RequestParam(value="params",required=false) String params,
				  @RequestParam(value="time",required=false) Double time,
				  @RequestParam(value="ip",required=false) String ip,
				  @RequestParam(value="createTime",required=false) Date createTime
				  ){
		Map<String,Object> queryparams = new HashMap<String,Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
		if(id != null){
			queryparams.put("id",id);
		}
		if(username != null){
			queryparams.put("username",username);
		}
		if(operation != null){
			queryparams.put("operation",operation);
		}
		if(method != null){
			queryparams.put("method",method);
		}
		if(params != null){
			queryparams.put("params",params);
		}
		if(time != null){
			queryparams.put("time",time);
		}
		if(ip != null){
			queryparams.put("ip",ip);
		}
		if(createTime != null){
			queryparams.put("createTime",createTime);
		}
		//查询列表数据
		Query query = new Query(queryparams);

		List<SysLogEntity> sysLogList = sysLogService.queryList(query);
		int total = sysLogService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(sysLogList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}
}
