package com.khidi.manager.basicinfo.controller;

import com.khidi.common.annotation.SysLog;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.sys.controller.AbstractController;
import io.swagger.annotations.ApiParam;

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
import org.apache.commons.lang.StringUtils;

import com.khidi.common.exception.RRException;
import com.khidi.manager.basicinfo.entity.ResourceCompanywaterEntity;
import com.khidi.manager.basicinfo.service.ResourceCompanywaterService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;

/**
 * 工业企业用水户管理
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-22 17:36:48
 */
@RestController
@RequestMapping("resourcecompanywater")
@Api(value = "/ResourceCompanywater", description = "工业企业用水户管理")
public class ResourceCompanywaterController extends AbstractController {
	@Autowired
	private ResourceCompanywaterService resourceCompanywaterService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions("工业企业用水户:查看")
	@ApiOperation(value = "列表", notes = "")
	public R list(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "limit", required = true) int limit,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "x", required = false) String x,
			@RequestParam(value = "y", required = false) String y,
			@RequestParam(value = "owner", required = false) String owner,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "yearUse", required = false) String yearUse,
			@RequestParam(value = "industrialValue", required = false) String industrialValue,
			@RequestParam(value = "waterPermission", required = false) String waterPermission,
			@RequestParam(value = "permissionNumber", required = false) String permissionNumber,
			@RequestParam(value = "permissionSum", required = false) String permissionSum,
			@RequestParam(value = "displacement", required = false) String displacement,
			@RequestParam(value = "outputDirection", required = false) String outputDirection,
			@RequestParam(value = "tapwaterMode", required = false) String tapwaterMode,
			@RequestParam(value = "surfacewaterMode", required = false) String surfacewaterMode,
			@RequestParam(value = "groundwaterMode", required = false) String groundwaterMode,
			@RequestParam(value = "reclaimedwaterMode", required = false) String reclaimedwaterMode,
			@RequestParam(value = "otherwaterMode", required = false) String otherwaterMode,
			@RequestParam(value = "areaId", required = false) String areaId,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "remark", required = false) String remark) {
		Map<String, Object> queryparams = new HashMap<String, Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
		if (id != null) {
			queryparams.put("id", id);
		}
		if (code != null) {
			queryparams.put("code", code);
		}
		if (name != null) {
			queryparams.put("name", name);
		}
		if (x != null) {
			queryparams.put("x", x);
		}
		if (y != null) {
			queryparams.put("y", y);
		}
		if (owner != null) {
			queryparams.put("owner", owner);
		}
		if (phone != null) {
			queryparams.put("phone", phone);
		}
		if (yearUse != null) {
			queryparams.put("yearUse", yearUse);
		}
		if (industrialValue != null) {
			queryparams.put("industrialValue", industrialValue);
		}
		if (waterPermission != null) {
			queryparams.put("waterPermission", waterPermission);
		}
		if (permissionNumber != null) {
			queryparams.put("permissionNumber", permissionNumber);
		}
		if (permissionSum != null) {
			queryparams.put("permissionSum", permissionSum);
		}
		if (displacement != null) {
			queryparams.put("displacement", displacement);
		}
		if (outputDirection != null) {
			queryparams.put("outputDirection", outputDirection);
		}
		if (tapwaterMode != null) {
			queryparams.put("tapwaterMode", tapwaterMode);
		}
		if (surfacewaterMode != null) {
			queryparams.put("surfacewaterMode", surfacewaterMode);
		}
		if (groundwaterMode != null) {
			queryparams.put("groundwaterMode", groundwaterMode);
		}
		if (reclaimedwaterMode != null) {
			queryparams.put("reclaimedwaterMode", reclaimedwaterMode);
		}
		if (otherwaterMode != null) {
			queryparams.put("otherwaterMode", otherwaterMode);
		}
		if (areaId != null) {
			queryparams.put("areaId", areaId);
		}
		if (address != null) {
			queryparams.put("address", address);
		}
		if (remark != null) {
			queryparams.put("remark", remark);
		}
		// 查询列表数据
		Query query = new Query(queryparams);
		//加入用户角色的资源的过滤
		query.put("roleId", StringUtil.joinList4sql(getRole(), "','"));

		List<ResourceCompanywaterEntity> resourceCompanywaterList = resourceCompanywaterService.queryList(query);
		int total = resourceCompanywaterService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(resourceCompanywaterList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@RequiresPermissions("工业企业用水户:查看")
	@ApiOperation(value = "信息", notes = "")
	public R info(@PathVariable("id") String id) {
		ResourceCompanywaterEntity resourceCompanywater = resourceCompanywaterService.queryObject(id);

		return R.ok().put("resourceCompanywater", resourceCompanywater);
	}

	/**
	 * 保存
	 */
	@SysLog("保存取水口信息")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@RequiresPermissions("工业企业用水户:管理")
	@ApiOperation(value = "保存", notes = "")
	public R save(@RequestBody ResourceCompanywaterEntity resourceCompanywater) {
		verifyForm(resourceCompanywater);
		resourceCompanywaterService.save(resourceCompanywater);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改取水口信息")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("工业企业用水户:管理")
	@ApiOperation(value = "修改", notes = "")
	public R update(@RequestBody ResourceCompanywaterEntity resourceCompanywater) {
		verifyForm(resourceCompanywater);
		resourceCompanywaterService.update(resourceCompanywater);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除取水口信息")
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("工业企业用水户:管理")
	@ApiOperation(value = "删除", notes = "")
	public R delete(@PathVariable("ids") String ids) {
		String[] strings = ids.split(",");
		for (int i = 0; i < strings.length; i++) {
			resourceCompanywaterService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(ResourceCompanywaterEntity resourceCompanywater) {
		if (StringUtils.isBlank(resourceCompanywater.getCode())) {
			throw new RRException(270, "工业企业用水户编码不能为空");
		}
		if (StringUtils.isBlank(resourceCompanywater.getName())) {
			throw new RRException(270, "工业企业用水户名称不能为空");
		}
		if (StringUtils.isBlank(resourceCompanywater.getX())) {
			throw new RRException(270, "经度不能为空");
		}
		if (StringUtils.isBlank(resourceCompanywater.getY())) {
			throw new RRException(270, "纬度不能为空");
		}
		if (StringUtils.isBlank(resourceCompanywater.getAreaId())) {
			throw new RRException(270, "行政区划不能为空");
		}
	}

}