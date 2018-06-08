package com.khidi.manager.socialparticipation.controller;

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

import com.khidi.manager.socialparticipation.entity.AppmenuEntity;
import com.khidi.manager.socialparticipation.service.AppmenuService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-08 15:06:21 Jerry Wang 2017 12 09
 */
@RestController
@RequestMapping("appmenu")
@Api(value = "/Appmenu", description = "APP菜单管理")
public class AppmenuController {
	@Autowired
	private AppmenuService appmenuService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions("APP菜单管理:查看")
	@ApiOperation(value = "列表", notes = "")
	public R list(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "limit", required = true) int limit,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "parentid", required = false) String parentid,
			@RequestParam(value = "remark", required = false) String remark) {
		Map<String, Object> queryparams = new HashMap<String, Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
		if (id != null) {
			queryparams.put("id", id);
		}
		if (name != null) {
			queryparams.put("name", name);
		}
		if (code != null) {
			queryparams.put("code", code);
		}
		if (parentid != null) {
			queryparams.put("parentid", parentid);
		}
		if (remark != null) {
			queryparams.put("remark", remark);
		}
		// 查询列表数据
		Query query = new Query(queryparams);

		List<AppmenuEntity> appmenuList = appmenuService.queryList(query);
		for (AppmenuEntity lpAe : appmenuList) {
			int lpCounts = appmenuService.querySonMenusCounts(lpAe.getId());
			lpAe.setOpen(lpCounts > 0);
		}
		int total = appmenuService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(appmenuList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 列表
	 */
	@RequestMapping(value = "/queryList", method=RequestMethod.GET)
	@RequiresPermissions("APP菜单管理:查看")
	@ApiOperation(value = "列表", notes = "")
	public R list(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "parentid", required = false) String parentid,
			@RequestParam(value = "remark", required = false) String remark) {
		Map<String, Object> queryparams = new HashMap<String, Object>();
		if (id != null) {
			queryparams.put("id", id);
		}
		if (name != null) {
			queryparams.put("name", name);
		}
		if (code != null) {
			queryparams.put("code", code);
		}
		if (parentid != null) {
			queryparams.put("parentid", parentid);
		}
		if (remark != null) {
			queryparams.put("remark", remark);
		}
		// 查询列表数据

		List<AppmenuEntity> appmenuList = appmenuService.queryList0(queryparams);
		for (AppmenuEntity lpAe : appmenuList) {
			int lpCounts = appmenuService.querySonMenusCounts(lpAe.getId());
			lpAe.setOpen(lpCounts > 0);
		}

		return R.ok().put("data", appmenuList);
	}

	/**
	 * 列表
	 */
	public R listAll() {
		List<AppmenuEntity> appmenuList = appmenuService.queryAll();
		//
		for (AppmenuEntity lpAe : appmenuList) {
			int lpCounts = appmenuService.querySonMenusCounts(lpAe.getId());
			lpAe.setOpen(lpCounts > 0);
		}
		//
		return R.ok().put("data", appmenuList);
	}

	@RequestMapping(value = "/levelList", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("APP菜单管理:查看")
	@ApiOperation(value = "列表", notes = "")
	public R levelList(@RequestParam String id) {
		List<AppmenuEntity> appmenuList = appmenuService.queryChildren(id);
		//
		for (AppmenuEntity lpAe : appmenuList) {
			int lpCounts = appmenuService.querySonMenusCounts(lpAe.getId());
			lpAe.setOpen(lpCounts > 0);
		}
		AppmenuEntity theMenu = appmenuService.queryObject(id);
		if (theMenu == null) {
			theMenu = new AppmenuEntity();
			theMenu.setCode(null);
			theMenu.setId(id);
			theMenu.setName(null);
			theMenu.setParentId(null);
			theMenu.setRemark(null);
		}
		if (appmenuList != null || appmenuList.size() > 0) {
			theMenu.setOpen(true);
		} else {
			theMenu.setOpen(false);
		}
		theMenu.setList(appmenuList);
		//
		return R.ok().put("data", theMenu);
	}

	/**
	 * 信息
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@RequiresPermissions("APP菜单管理:查看")
	@ApiOperation(value = "信息", notes = "")
	public R info(@PathVariable("id") String id) {
		AppmenuEntity appmenu = appmenuService.queryObject(id);

		return R.ok().put("data", appmenu);
	}

	/**
	 * 保存
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@RequiresPermissions("APP菜单管理:管理")
	@ApiOperation(value = "保存", notes = "")
	public R save(@RequestBody AppmenuEntity appmenu) {
		appmenu.setId(String.valueOf(UUID.randomUUID()));
		// if(appmenu.getParentid().equals("0"))
		// {
		// appmenu.setParentid(null);
		// }
		verifyForm(appmenu);
		appmenuService.save(appmenu);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("APP菜单管理:管理")
	@ApiOperation(value = "修改", notes = "")
	public R update(@RequestBody AppmenuEntity appmenu) {
		verifyForm(appmenu);
		appmenuService.update(appmenu);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("APP菜单管理:管理")
	@ApiOperation(value = "删除", notes = "")
	public R delete(@PathVariable("ids") String ids) {
		String[] strings = ids.split(",");
		for (int i = 0; i < strings.length; i++) {
			appmenuService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(AppmenuEntity appmenu) {
		if (StringUtils.isBlank(appmenu.getId())) {
			throw new RRException(270, "系统编码不能为空");
		}
		if (StringUtils.isBlank(appmenu.getName())) {
			throw new RRException(270, "菜单名称不能为空");
		}
		if (StringUtils.isBlank(appmenu.getCode())) {
			throw new RRException(270, "菜单编码不能为空");
		}
		if (StringUtils.isBlank(appmenu.getParentId())) {
			throw new RRException(270, "父节点编码不能为空");
		}
	}
}