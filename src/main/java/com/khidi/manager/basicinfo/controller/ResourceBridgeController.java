package com.khidi.manager.basicinfo.controller;

import java.util.List;
import java.util.Map;
import java.util.Date;

import com.khidi.common.annotation.SysLog;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.sys.controller.AbstractController;
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
import com.khidi.manager.basicinfo.entity.ResourceBridgeEntity;
import com.khidi.manager.basicinfo.service.ResourceBridgeService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;

/**
 * 桥梁信息管理
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-22 17:36:48
 */
@RestController
@RequestMapping("resourcebridge")
@Api(value = "/ResourceBridge", description = "桥梁信息管理")
public class ResourceBridgeController extends AbstractController {
	@Autowired
	private ResourceBridgeService resourceBridgeService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions("桥梁:查看")
	@ApiOperation(value = "列表", notes = "")
	public R list(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "limit", required = true) int limit,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "bridgeStart", required = false) String bridgeStart,
			@RequestParam(value = "bridgeEnd", required = false) String bridgeEnd,
			@RequestParam(value = "startX", required = false) String startX,
			@RequestParam(value = "startY", required = false) String startY,
			@RequestParam(value = "endX", required = false) String endX,
			@RequestParam(value = "endY", required = false) String endY,
			@RequestParam(value = "areaId", required = false) String areaId,
			@RequestParam(value = "bridgeLength", required = false) String bridgeLength,
			@RequestParam(value = "bridgeType", required = false) String bridgeType,
			@RequestParam(value = "bridgeName", required = false) String bridgeName,
			@RequestParam(value = "resourceName", required = false) String resourceName,
			@RequestParam(value = "stationBuild", required = false) String stationBuild,
			@RequestParam(value = "stationSituation", required = false) String stationSituation,
			@RequestParam(value = "stationStarttime", required = false) Date stationStarttime,
			@RequestParam(value = "stationBuildtime", required = false) Date stationBuildtime,
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
		if (resourceName != null) {
			queryparams.put("resourceName", resourceName);
		}
		if (bridgeStart != null) {
			queryparams.put("bridgeStart", bridgeStart);
		}
		if (bridgeEnd != null) {
			queryparams.put("bridgeEnd", bridgeEnd);
		}
		if (startX != null) {
			queryparams.put("startX", startX);
		}
		if (startY != null) {
			queryparams.put("startY", startY);
		}
		if (endX != null) {
			queryparams.put("endX", endX);
		}
		if (endY != null) {
			queryparams.put("endY", endY);
		}
		if (areaId != null) {
			queryparams.put("areaId", areaId);
		}
		if (bridgeLength != null) {
			queryparams.put("bridgeLength", bridgeLength);
		}
		if (bridgeType != null) {
			queryparams.put("bridgeType", bridgeType);
		}
		if (bridgeName != null) {
			queryparams.put("bridgeName", bridgeName);
		}
		if (stationBuild != null) {
			queryparams.put("stationBuild", stationBuild);
		}
		if (stationSituation != null) {
			queryparams.put("stationSituation", stationSituation);
		}
		if (stationStarttime != null) {
			queryparams.put("stationStarttime", stationStarttime);
		}
		if (stationBuildtime != null) {
			queryparams.put("stationBuildtime", stationBuildtime);
		}
		if (remark != null) {
			queryparams.put("remark", remark);
		}
		// 查询列表数据
		Query query = new Query(queryparams);
		//加入用户角色的资源的过滤
		query.put("roleId", StringUtil.joinList4sql(getRole(), "','"));

		List<ResourceBridgeEntity> resourceBridgeList = resourceBridgeService.queryList(query);
		int total = resourceBridgeService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(resourceBridgeList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@RequiresPermissions("桥梁:查看")
	@ApiOperation(value = "信息", notes = "")
	public R info(@PathVariable("id") String id) {
		ResourceBridgeEntity resourceBridge = resourceBridgeService.queryObject(id);

		return R.ok().put("resourceBridge", resourceBridge);
	}

	/**
	 * 保存
	 */
	@SysLog("保存桥梁信息")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@RequiresPermissions("桥梁:管理")
	@ApiOperation(value = "保存", notes = "")
	public R save(@RequestBody ResourceBridgeEntity resourceBridge) {
		verifyForm(resourceBridge);
		resourceBridgeService.save(resourceBridge);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改桥梁信息")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("桥梁:管理")
	@ApiOperation(value = "修改", notes = "")
	public R update(@RequestBody ResourceBridgeEntity resourceBridge) {
		verifyForm(resourceBridge);
		resourceBridgeService.update(resourceBridge);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除桥梁信息")
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("桥梁:管理")
	@ApiOperation(value = "删除", notes = "")
	public R delete(@PathVariable("ids") String ids) {
		String[] strings = ids.split(",");
		for (int i = 0; i < strings.length; i++) {
			resourceBridgeService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(ResourceBridgeEntity resourceBridge) {
		if (StringUtils.isBlank(resourceBridge.getCode())) {
			throw new RRException(270, "桥梁编码不能为空");
		}
		if (StringUtils.isBlank(resourceBridge.getName())) {
			throw new RRException(270, "桥梁名称不能为空");
		}
		if (StringUtils.isBlank(resourceBridge.getStartX())) {
			throw new RRException(270, "起点经度不能为空");
		}
		if (StringUtils.isBlank(resourceBridge.getStartY())) {
			throw new RRException(270, "起点纬度不能为空");
		}
		if (StringUtils.isBlank(resourceBridge.getEndX())) {
			throw new RRException(270, "终点经度不能为空");
		}
		if (StringUtils.isBlank(resourceBridge.getEndY())) {
			throw new RRException(270, "终点纬度不能为空");
		}
		if (StringUtils.isBlank(resourceBridge.getAreaId())) {
			throw new RRException(270, "行政区划编码不能为空");
		}
		if (StringUtils.isBlank(resourceBridge.getBridgeLength())) {
			throw new RRException(270, "桥梁长度（m）不能为空");
		}

	}

}