package com.khidi.manager.officework.controller;

import com.khidi.common.utils.ListUtil;
import com.khidi.common.utils.R;
import com.khidi.manager.officework.service.WorkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 渠道基础信息管理
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
@RestController
@RequestMapping("work")
@Api(value = "/Work", description = "河长办公管理")
public class WorkController {
	@Autowired
	private WorkService workService;
	/**
	 * 根据五级职务级别查询人员信息  职务体系图
	 */
	@RequestMapping(value="/role/{rolelevel}",method = RequestMethod.GET)
	@RequiresPermissions("河长体系图:查看")
    @ApiOperation(value = "根据传入的职务级别返回人员信息，作用于职务体系图模块",notes="市级：1；区县级：2；乡镇级：3；村级：4；组级：5")
	public R RoleInfo(@PathVariable("rolelevel") String rolelevel,
					  @RequestParam(value="page",required=true) int page,
					  @RequestParam(value="limit",required=true) int limit){
		return R.ok().put("data", ListUtil.ListPage(workService.UserListByRoleLevel(rolelevel),page,limit));
	}

	/**
	 * 根据三级部门级别查询人员信息  河长办体系图
	 */
	@RequestMapping(value="/dept/{deptlevel}",method = RequestMethod.GET)
	@RequiresPermissions("河长体系图:查看")
	@ApiOperation(value = "根据传入的职务级别返回人员信息，作用于职务体系图模块",notes="市级：1；区县级：2；乡镇级：3")
	public R DeptInfo(@PathVariable("deptlevel") String deptlevel,
					  @RequestParam(value="page",required=true) int page,
					  @RequestParam(value="limit",required=true) int limit){
		return R.ok().put("data", ListUtil.ListPage(workService.UserListByDeptLevel(deptlevel),page,limit));
	}
}
