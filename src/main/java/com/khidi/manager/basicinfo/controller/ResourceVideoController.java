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

import com.khidi.manager.basicinfo.entity.ResourceVideoEntity;
import com.khidi.manager.basicinfo.service.ResourceVideoService;
import com.khidi.common.exception.RRException;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;

/**
 * 视频监测站管理
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-22 17:36:48
 */
@RestController
@RequestMapping("resourcevideo")
@Api(value = "/ResourceVideo", description = "视频监测站管理")
public class ResourceVideoController extends AbstractController {
	@Autowired
	private ResourceVideoService resourceVideoService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions("视频监测站:查看")
	@ApiOperation(value = "列表", notes = "")
	public R list(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "limit", required = true) int limit,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "areaId", required = false) String areaId,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "resourceType", required = false) String resourceType,
			@RequestParam(value = "stationId", required = false) String stationId,
			@RequestParam(value = "stationName", required = false) String stationName,
			@RequestParam(value = "x", required = false) String x,
			@RequestParam(value = "y", required = false) String y,
			@RequestParam(value = "owner", required = false) String owner,
			@RequestParam(value = "phone", required = false) String phone,
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
		if (areaId != null) {
			queryparams.put("areaId", areaId);
		}
		if (name != null) {
			queryparams.put("name", name);
		}
		if (address != null) {
			queryparams.put("address", address);
		}
		if (type != null) {
			queryparams.put("type", type);
		}
		if (resourceType != null) {
			queryparams.put("riverType", resourceType);
		}
		if (stationId != null) {
			queryparams.put("stationId", stationId);
		}
		if (stationName != null) {
			queryparams.put("stationName", stationName);
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
		query.put("roleId", StringUtil.joinList4sql(getRole(),"','"));

		List<ResourceVideoEntity> resourceVideoList = resourceVideoService.queryList(query);
		int total = resourceVideoService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(resourceVideoList, total, query.getLimit(), query.getPage() );

		return R.ok().put("page", pageUtil );
	}

	/**
	 * 信息
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@RequiresPermissions("视频监测站:查看")
	@ApiOperation(value = "信息", notes = "")
	public R info(@PathVariable("id") String id) {
		ResourceVideoEntity resourceVideo = resourceVideoService.queryObject(id);

		return R.ok().put("resourceVideo", resourceVideo);
	}

	/**
	 * 保存
	 */
	@SysLog("保存视频站信息")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@RequiresPermissions("视频监测站:管理")
	@ApiOperation(value = "保存", notes = "")
	public R save(@RequestBody ResourceVideoEntity resourceVideo) {
		verifyForm(resourceVideo);
		resourceVideoService.save(resourceVideo);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改视频站信息")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("视频监测站:管理")
	@ApiOperation(value = "修改", notes = "")
	public R update(@RequestBody ResourceVideoEntity resourceVideo) {
		verifyForm(resourceVideo);
		resourceVideoService.update(resourceVideo);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除视频站信息")
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("视频监测站:管理")
	@ApiOperation(value = "删除", notes = "")
	public R delete(@PathVariable("ids") String ids) {
		String[] strings = ids.split(",");
		for (int i = 0; i < strings.length; i++) {
			resourceVideoService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(ResourceVideoEntity resourceVideo) {
		if (StringUtils.isBlank(resourceVideo.getCode())) {
			throw new RRException(270, "测站编码不能为空");
		}
		if (StringUtils.isBlank(resourceVideo.getAreaId())) {
			throw new RRException(270, "行政区划不能为空");
		}
		if (StringUtils.isBlank(resourceVideo.getName())) {
			throw new RRException(270, "测站名称不能为空");
		}
		if (StringUtils.isBlank(resourceVideo.getX())) {
			throw new RRException(270, "经度不能为空");
		}
		if (StringUtils.isBlank(resourceVideo.getY())) {
			throw new RRException(270, "纬度不能为空");
		}
	}

}