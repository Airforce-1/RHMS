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

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.khidi.manager.basicinfo.entity.ResourceIrrigatedEntity;
import com.khidi.manager.basicinfo.service.ResourceIrrigatedService;
import com.khidi.common.exception.RRException;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;

/**
 * 灌区基础信息管理
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-24 08:27:48
 */
@RestController
@RequestMapping("resourceirrigated")
@Api(value = "/ResourceIrrigated", description = "灌区基础信息管理")
public class ResourceIrrigatedController extends AbstractController {
	@Autowired
	private ResourceIrrigatedService resourceIrrigatedService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions("灌区:查看")
	@ApiOperation(value = "列表", notes = "")
	public R list(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "limit", required = true) int limit,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "leftX", required = false) String leftX,
			@RequestParam(value = "leftY", required = false) String leftY,
			@RequestParam(value = "rightX", required = false) String rightX,
			@RequestParam(value = "rightY", required = false) String rightY,
			@RequestParam(value = "areaId", required = false) String areaId,
			@RequestParam(value = "scale", required = false) String scale,
			@RequestParam(value = "wateruserType", required = false) String wateruserType,
			@RequestParam(value = "waterType", required = false) String waterType,
			@RequestParam(value = "build", required = false) String build,
			@RequestParam(value = "work", required = false) String work,
			@RequestParam(value = "extent", required = false) String extent,
			@RequestParam(value = "designExtent", required = false) String designExtent,
			@RequestParam(value = "sumExtent", required = false) String sumExtent,
			@RequestParam(value = "validExtent", required = false) String validExtent,
			@RequestParam(value = "starttime", required = false) Date starttime,
			@RequestParam(value = "buildtime", required = false) Date buildtime,
			@RequestParam(value = "reamrk", required = false) String reamrk,
			@RequestParam(value = "createTime", required = false) Date createTime,
			@RequestParam(value = "id", required = false) String id) {
		Map<String, Object> queryparams = new HashMap<String, Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
		if (code != null) {
			queryparams.put("code", code);
		}
		if (name != null) {
			queryparams.put("name", name);
		}
		if (leftX != null) {
			queryparams.put("leftX", leftX);
		}
		if (leftY != null) {
			queryparams.put("leftY", leftY);
		}
		if (rightX != null) {
			queryparams.put("rightX", rightX);
		}
		if (rightY != null) {
			queryparams.put("rightY", rightY);
		}
		if (areaId != null) {
			queryparams.put("areaId", areaId);
		}
		if (scale != null) {
			queryparams.put("scale", scale);
		}
		if (wateruserType != null) {
			queryparams.put("wateruserType", wateruserType);
		}
		if (waterType != null) {
			queryparams.put("waterType", waterType);
		}
		if (build != null) {
			queryparams.put("build", build);
		}
		if (work != null) {
			queryparams.put("work", work);
		}
		if (extent != null) {
			queryparams.put("extent", extent);
		}
		if (designExtent != null) {
			queryparams.put("designExtent", designExtent);
		}
		if (sumExtent != null) {
			queryparams.put("sumExtent", sumExtent);
		}
		if (validExtent != null) {
			queryparams.put("validExtent", validExtent);
		}
		if (starttime != null) {
			queryparams.put("starttime", starttime);
		}
		if (buildtime != null) {
			queryparams.put("buildtime", buildtime);
		}
		if (reamrk != null) {
			queryparams.put("reamrk", reamrk);
		}
		if (createTime != null) {
			queryparams.put("createTime", createTime);
		}
		if (id != null) {
			queryparams.put("id", id);
		}
		// 查询列表数据
		Query query = new Query(queryparams);
		//加入用户角色的资源的过滤
		query.put("roleId", StringUtil.joinList4sql(getRole(), "','"));

		List<ResourceIrrigatedEntity> resourceIrrigatedList = resourceIrrigatedService.queryList(query);
		int total = resourceIrrigatedService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(resourceIrrigatedList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@RequiresPermissions("灌区:查看")
	@ApiOperation(value = "信息", notes = "")
	public R info(@PathVariable("id") String id) {
		ResourceIrrigatedEntity resourceIrrigated = resourceIrrigatedService.queryObject(id);

		return R.ok().put("resourceIrrigated", resourceIrrigated);
	}

	/**
	 * 保存
	 */
	@SysLog("保存灌区信息")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@RequiresPermissions("灌区:管理")
	@ApiOperation(value = "保存", notes = "")
	public R save(@RequestBody ResourceIrrigatedEntity resourceIrrigated) {
		verifyForm(resourceIrrigated);
		resourceIrrigatedService.save(resourceIrrigated);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改灌区信息")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("灌区:管理")
	@ApiOperation(value = "修改", notes = "")
	public R update(@RequestBody ResourceIrrigatedEntity resourceIrrigated) {
		verifyForm(resourceIrrigated);
		resourceIrrigatedService.update(resourceIrrigated);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除灌区信息")
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("灌区:管理")
	@ApiOperation(value = "删除", notes = "")
	public R delete(@PathVariable("ids") String ids) {
		String[] strings = ids.split(",");
		for (int i = 0; i < strings.length; i++) {
			resourceIrrigatedService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(ResourceIrrigatedEntity resourceIrrigated) {
		if (StringUtils.isBlank(resourceIrrigated.getCode())) {
			throw new RRException(270, "灌区编码不能为空");
		}
		if (StringUtils.isBlank(resourceIrrigated.getName())) {
			throw new RRException(270, "灌区名称不能为空");
		}
		if (StringUtils.isBlank(resourceIrrigated.getLeftX())) {
			throw new RRException(270, "左下角经度不能为空");
		}
		if (StringUtils.isBlank(resourceIrrigated.getLeftY())) {
			throw new RRException(270, "左下角纬度不能为空");
		}
		if (StringUtils.isBlank(resourceIrrigated.getRightX())) {
			throw new RRException(270, "右上角经度不能为空");
		}
		if (StringUtils.isBlank(resourceIrrigated.getRightY())) {
			throw new RRException(270, "右上角纬度不能为空");
		}
		if (StringUtils.isBlank(resourceIrrigated.getAreaId())) {
			throw new RRException(270, "行政区划不能为空");
		}
	}

}