package com.khidi.manager.basicinfo.controller;

import com.khidi.common.annotation.SysLog;
import com.khidi.common.utils.*;
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
import com.khidi.manager.basicinfo.entity.ResourceIntakeEntity;
import com.khidi.manager.basicinfo.service.ResourceIntakeService;

import java.util.HashMap;

/**
 * 河口（取水口、排污口）管理
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-22 17:36:48
 */
@RestController
@RequestMapping("resourceintake")
@Api(value = "/ResourceIntake", description = "河口（取水口、排污口）管理")
public class ResourceIntakeController extends AbstractController {
	@Autowired
	private ResourceIntakeService resourceIntakeService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions("河口管理:查看")
	@ApiOperation(value = "列表", notes = "")
	public R list(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "limit", required = true) int limit,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "waterTyper", required = false) String waterTyper,
			@RequestParam(value = "waterStarttime", required = false) String waterStarttime,
			@RequestParam(value = "designFlow", required = false) String designFlow,
			@RequestParam(value = "allowFlow", required = false) String allowFlow,
			@RequestParam(value = "allowSum", required = false) String allowSum,
			@RequestParam(value = "sum", required = false) String sum,
			@RequestParam(value = "remark", required = false) String remark,
			@RequestParam(value = "attachment", required = false) String attachment,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "areaId", required = false) String areaId,
			@RequestParam(value = "resourceName", required = false) String resourceName,
			@RequestParam(value = "x", required = false) String x,
			@RequestParam(value = "y", required = false) String y,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "riverType", required = false) String riverType,
			@RequestParam(value = "riverName", required = false) String riverName,
			@RequestParam(value = "owner", required = false) String owner,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "stationBuild", required = false) String stationBuild,
			@RequestParam(value = "stationSituation", required = false) String stationSituation,
			@RequestParam(value = "getway", required = false) String getway,
			@RequestParam(value = "stationStarttime", required = false) String stationStarttime,
			@RequestParam(value = "stationBuildttime", required = false) String stationBuildttime,
			@RequestParam(value = "manager", required = false) String manager) {
		Map<String, Object> queryparams = new HashMap<String, Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
		if (waterTyper != null) {
			queryparams.put("waterTyper", waterTyper);
		}
		if (waterStarttime != null) {
			queryparams.put("waterStarttime", DateUtils.stringToDate(waterStarttime,"yyyy-MM-dd HH:mm:ss"));
		}
		if (designFlow != null) {
			queryparams.put("designFlow", designFlow);
		}
		if (resourceName != null) {
			queryparams.put("resourceName", resourceName);
		}
		if (allowFlow != null) {
			queryparams.put("allowFlow", allowFlow);
		}
		if (allowSum != null) {
			queryparams.put("allowSum", allowSum);
		}
		if (sum != null) {
			queryparams.put("sum", sum);
		}
		if (remark != null) {
			queryparams.put("remark", remark);
		}
		if (attachment != null) {
			queryparams.put("attachment", attachment);
		}
		if (id != null) {
			queryparams.put("id", id);
		}
		if (code != null) {
			queryparams.put("code", code);
		}
		if (name != null) {
			queryparams.put("name", name);
		}
		if (type != null) {
			queryparams.put("type", type);
		}
		if (areaId != null) {
			queryparams.put("areaId", areaId);
		}
		if (x != null) {
			queryparams.put("x", x);
		}
		if (y != null) {
			queryparams.put("y", y);
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
		if (owner != null) {
			queryparams.put("owner", owner);
		}
		if (phone != null) {
			queryparams.put("phone", phone);
		}
		if (stationBuild != null) {
			queryparams.put("stationBuild", stationBuild);
		}
		if (stationSituation != null) {
			queryparams.put("stationSituation", stationSituation);
		}
		if (getway != null) {
			queryparams.put("getway", getway);
		}
		if (stationStarttime != null) {
			queryparams.put("stationStarttime", DateUtils.stringToDate(stationStarttime,"yyyy-MM-dd HH:mm:ss"));
		}
		if (stationBuildttime != null) {
			queryparams.put("stationBuildttime", DateUtils.stringToDate(stationBuildttime,"yyyy-MM-dd HH:mm:ss"));
		}
		if (manager != null) {
			queryparams.put("manager", manager);
		}
		// 查询列表数据
		Query query = new Query(queryparams);
//加入用户角色的资源的过滤
		query.put("roleId", StringUtil.joinList4sql(getRole(), "','"));
		List<ResourceIntakeEntity> resourceIntakeList = resourceIntakeService.queryList(query);
		int total = resourceIntakeService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(resourceIntakeList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@RequiresPermissions("河口管理:查看")
	@ApiOperation(value = "信息", notes = "")
	public R info(@PathVariable("id") String id) {
		ResourceIntakeEntity resourceIntake = resourceIntakeService.queryObject(id);

		return R.ok().put("resourceIntake", resourceIntake);
	}

	/**
	 * 保存
	 */
	@SysLog("保存取水口信息")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@RequiresPermissions("河口管理:管理")
	@ApiOperation(value = "保存", notes = "")
	public R save(@RequestBody ResourceIntakeEntity resourceIntake) {
		verifyForm(resourceIntake);
		resourceIntakeService.save(resourceIntake);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改取水口信息")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("河口管理:管理")
	@ApiOperation(value = "修改", notes = "")
	public R update(@RequestBody ResourceIntakeEntity resourceIntake) {
		verifyForm(resourceIntake);
		resourceIntakeService.update(resourceIntake);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除取水口信息")
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("河口管理:管理")
	@ApiOperation(value = "删除", notes = "")
	public R delete(@PathVariable("ids") String ids) {
		String[] strings = ids.split(",");
		for (int i = 0; i < strings.length; i++) {
			resourceIntakeService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(ResourceIntakeEntity resourceIntake) {
		if (StringUtils.isBlank(resourceIntake.getCode())) {
			throw new RRException(270, "河口编码不能为空");
		}
		if (StringUtils.isBlank(resourceIntake.getName())) {
			throw new RRException(270, "河口名称不能为空");
		}
		if (StringUtils.isBlank(resourceIntake.getAreaId())) {
			throw new RRException(270, "行政区划不能为空");
		}
		if (StringUtils.isBlank(resourceIntake.getX())) {
			throw new RRException(270, "经度不能为空");
		}
		if (StringUtils.isBlank(resourceIntake.getY())) {
			throw new RRException(270, "纬度不能为空");
		}
	}
}