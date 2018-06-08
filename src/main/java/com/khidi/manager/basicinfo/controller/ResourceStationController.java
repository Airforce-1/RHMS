package com.khidi.manager.basicinfo.controller;

import com.khidi.common.annotation.SysLog;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.sys.controller.AbstractController;
import io.swagger.annotations.ApiParam;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Date;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.khidi.manager.basicinfo.entity.ResourceStationEntity;
import com.khidi.manager.basicinfo.entity.RiverEntity;
import com.khidi.manager.basicinfo.service.ResourceStationService;
import com.khidi.manager.basicinfo.service.RiverService;
import com.khidi.manager.monitoringnet.entity.WaterqualitydataEntity;
import com.khidi.common.exception.RRException;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;

/**
 * 河流(水质、水文)监测站管理
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-22 17:36:48 Jerry Wang 2017 12 23 Jerry Wang 2017 12 25
 */
@RestController
@RequestMapping("resourcestation")
@Api(value = "/ResourceStation", description = "河流(水质、水文)监测站管理")
public class ResourceStationController extends AbstractController {
	@Autowired
	private ResourceStationService resourceStationService;

	@Autowired
	private RiverService riverService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions("河流监测站:查看")
	@ApiOperation(value = "列表", notes = "")
	public R list(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "limit", required = true) int limit,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "areaId", required = false) String areaId,
			@RequestParam(value = "stationType", required = false) String stationType,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "riverType", required = false) String riverType,
			@RequestParam(value = "riverName", required = false) String riverName,
			@RequestParam(value = "resourceName", required = false) String resourceName,
			@RequestParam(value = "stationX", required = false) String stationX,
			@RequestParam(value = "stationY", required = false) String stationY,
			@RequestParam(value = "owner", required = false) String owner,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "stationBuild", required = false) String stationBuild,
			@RequestParam(value = "stationSituation", required = false) String stationSituation,
			@RequestParam(value = "stationStarttime", required = false) Date stationStarttime,
			@RequestParam(value = "stationBuildtime", required = false) Date stationBuildtime,
			@RequestParam(value = "remark", required = false) String remark,
			@RequestParam(value = "attachment", required = false) String attachment,
			@RequestParam(value = "uprId", required = false) String uprId) {
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
		if (areaId != null) {
			queryparams.put("areaId", areaId);
		}
		if (resourceName != null) {
			queryparams.put("resourceName", resourceName);
		}
		if (stationType != null) {
			queryparams.put("stationType", stationType);
		}
		if (name != null) {
			queryparams.put("name", name);
		}
		if (address != null) {
			queryparams.put("address", address);
		}
		if (riverType != null) {
			queryparams.put("riverType", riverType);
		}
		if (riverName != null) {
			queryparams.put("riverName", riverName);
		}
		if (stationX != null) {
			queryparams.put("stationX", stationX);
		}
		if (stationY != null) {
			queryparams.put("stationY", stationY);
		}
		if (owner != null) {
			queryparams.put("owner", owner);
		}
		if (phone != null) {
			queryparams.put("phine", phone);
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
		if (attachment != null) {
			queryparams.put("attachment", attachment);
		}
		if (uprId != null) {
			queryparams.put("uprId", uprId);
		}
		// 查询列表数据
		Query query = new Query(queryparams);
		// 加入用户角色的资源的过滤
		query.put("roleId", StringUtil.joinList4sql(getRole(), "','"));

		List<ResourceStationEntity> resourceStationList = resourceStationService.queryList(query);
		int total = resourceStationService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(resourceStationList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@RequiresPermissions("河流监测站:查看")
	@ApiOperation(value = "信息", notes = "")
	public R info(@PathVariable("id") String id) {
		ResourceStationEntity resourceStation = resourceStationService.queryObject(id);

		return R.ok().put("resourceStation", resourceStation);
	}

	/**
	 * 保存
	 */
	@SysLog("保存监测站信息")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@RequiresPermissions("河流监测站:管理")
	@ApiOperation(value = "保存", notes = "")
	public R save(@RequestBody ResourceStationEntity resourceStation) {
		verifyForm(resourceStation);
		resourceStationService.save(resourceStation);

		return R.ok();
	}

	// 根据资源ID(河流... ) 资源类型 ... 查询水质测站信息
	@RequestMapping(value = "/queryByResource", method = RequestMethod.GET)
	@RequiresPermissions("河流监测站:查看")
	@ApiOperation(value = "查询 根据资源ID(河流... ) 资源类型 ... 查询水质测站信息", notes = "")
	public R queryByResource(@RequestParam(value = "resourceId", required = true) String resourceId,
			@RequestParam(value = "resourceType", required = false) String resourceType,
			@RequestParam(value = "stationType", required = false) String stationType) {
		// Map<String, Object> queryparams = new HashMap<String, Object>();
		// queryparams.put("riverId", value)
		List<ResourceStationEntity> rtn0 = resourceStationService.queryByResource(resourceId, resourceType,
				stationType);
		//
		return R.ok().put("data", rtn0);
	}

	// 查询全部的（主干和支流）的测站（id pid name） (不用排序)
	@RequestMapping(value = "/queryLevelByResource", method = RequestMethod.GET)
	@RequiresPermissions("河流监测站:查看")
	@ApiOperation(value = "查询全部的（主干和支流）的测站（id pid name）  (不用排序)", notes = "")
	// public R queryLevelByResource(@RequestParam(value = "parentId", required
	// = false) String parentId,
	// @RequestParam(value = "stationType", required = false) String
	// stationType) {
	public R queryLevelByResource(@RequestParam(value = "stationType", required = false) String stationType) {
		// List<RiverEntity> levelRivers =
		// riverService.queryChildrenRivers(parentId);
		//
//		List<ResourceStationEntity> rtn0 = new ArrayList<ResourceStationEntity>();
//		//
//		for (RiverEntity lpRiver : levelRivers) {
//			_FillStationsByRiver(rtn0, lpRiver, stationType);
//		}
		//
		List<ResourceStationEntity> rtn = resourceStationService.allStations(stationType);
		//
		return R.ok().put("levelRiver", null).put("stations", rtn);
	}

	private void _FillStationsByRiver(List<ResourceStationEntity> refRtn, RiverEntity river, String stationType) {
		//
		List<ResourceStationEntity> rtn0 = resourceStationService.queryByResource(river.getId(), river.getType(),
				stationType);
		if (rtn0 != null && rtn0.size() > 0) {
			refRtn.addAll(rtn0);
			//
			List<RiverEntity> childrenRiver = river.getChildrenRiver();
			if (childrenRiver != null && childrenRiver.size() > 0) {
				for (RiverEntity lpRiver : childrenRiver) {
					_FillStationsByRiver(refRtn, lpRiver, stationType);
				}
			}
		}
	}

	// // 根据资源ID(河流... ) 资源类型 ... 查询水质测站信息
	// @RequestMapping(value = "/queryLinkedStations0", method =
	// RequestMethod.GET)
	// @RequiresPermissions("resourcestation:info")
	// @ApiOperation(value = "根据测站查看该测站所在河流(指定id的河流)的的全部测站值（并按上游到下游排序）(要排序)",
	// notes = "")
	// public R queryLinkedStations0(@RequestParam(value = "resourceId",
	// required = false) String resourceId,
	// @RequestParam(value = "resourceType", required = false) String
	// resourceType,
	// @RequestParam(value = "stationType", required = false) String
	// stationType) {
	// List<ResourceStationEntity> rtn0 =
	// resourceStationService.queryUpStationLinks(resourceId, resourceType,
	// stationType);
	// List<WaterqualitydataEntity> rtn1 =
	// resourceStationService.queryWaterqualitydata(resourceId, resourceType,
	// stationType);
	// //
	// return R.ok().put("linkedstation", rtn0).put("waterqualitydata", rtn1);
	// }

	// 据测站ID查询该测站所在河流的全部测站值（并按上游到下游排序）(要排序)
	@RequestMapping(value = "/queryLinkedStations", method = RequestMethod.GET)
	@RequiresPermissions("河流监测站:查看")
	@ApiOperation(value = "据测站ID查询该测站所在河流的全部测站值（并按上游到下游排序）(要排序)", notes = "")
	public R queryLinkedStations(@RequestParam(value = "stationId", required = false) String stationId,
			@RequestParam(value = "stationType", required = false) String stationType) {
		ResourceStationEntity rtn00 = resourceStationService.queryObject(stationId);

		List<ResourceStationEntity> rtn0 = resourceStationService.queryUpStationLinks(rtn00.getResourceId(),
				rtn00.getResourceType(), stationType);
		List<WaterqualitydataEntity> rtn1 = resourceStationService.queryWaterqualitydata(rtn00.getResourceId(),
				rtn00.getResourceType(), stationType);
		//
		return R.ok().put("linkedstation", rtn0).put("waterqualitydata", rtn1);
	}

	/**
	 * 修改
	 */
	@SysLog("修改监测站信息")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("河流监测站:管理")
	@ApiOperation(value = "修改", notes = "")
	public R update(@RequestBody ResourceStationEntity resourceStation) {
		verifyForm(resourceStation);
		resourceStationService.update(resourceStation);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除监测站信息")
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("河流监测站:管理")
	@ApiOperation(value = "删除", notes = "")
	public R delete(@PathVariable("ids") String ids) {
		String[] strings = ids.split(",");
		for (int i = 0; i < ids.length(); i++) {
			resourceStationService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(ResourceStationEntity resourceStation) {
		if (StringUtils.isBlank(resourceStation.getCode())) {
			throw new RRException(270, "监测站编码不能为空");
		}
		if (StringUtils.isBlank(resourceStation.getAreaId())) {
			throw new RRException(270, "行政区划不能为空");
		}
		if (StringUtils.isBlank(resourceStation.getName())) {
			throw new RRException(270, "监测站名称不能为空");
		}
		if (StringUtils.isBlank(resourceStation.getStationX())) {
			throw new RRException(270, "经度不能为空");
		}
		if (StringUtils.isBlank(resourceStation.getStationY())) {
			throw new RRException(270, "纬度不能为空");
		}
	}
}