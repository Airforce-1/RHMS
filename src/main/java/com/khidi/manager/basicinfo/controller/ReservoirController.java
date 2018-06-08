package com.khidi.manager.basicinfo.controller;

import com.khidi.common.annotation.SysLog;
import com.khidi.common.utils.*;
import com.khidi.manager.basicinfo.entity.PartReservoirEntity;
import com.khidi.manager.basicinfo.service.PartReservoirService;
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
import com.khidi.manager.basicinfo.entity.ReservoirEntity;
import com.khidi.manager.basicinfo.service.ReservoirService;

import java.util.HashMap;

/**
 * 水库信息管理
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
@RestController
@RequestMapping("reservoir")
@Api(value = "/Reservoir", description = "水库信息管理")
public class ReservoirController extends AbstractController {
	@Autowired
	private ReservoirService reservoirService;
	@Autowired
	private PartReservoirService partReservoirService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions("水库:查看")
	@ApiOperation(value = "列表", notes = "")
	public R list(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "limit", required = true) int limit,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "areaId", required = false) String areaId,
			@RequestParam(value = "alias", required = false) String alias,
			@RequestParam(value = "location", required = false) String location,
			@RequestParam(value = "leftX", required = false) String leftX,
			@RequestParam(value = "rightX", required = false) String rightX,
			@RequestParam(value = "rightY", required = false) String rightY,
			@RequestParam(value = "leftY", required = false) String leftY,
			@RequestParam(value = "reservoirType", required = false) String reservoirType,
			@RequestParam(value = "reservoirWork", required = false) String reservoirWork,
			@RequestParam(value = "build", required = false) String build,
			@RequestParam(value = "reservoirLevel", required = false) String reservoirLevel,
			@RequestParam(value = "scale", required = false) String scale,
			@RequestParam(value = "waterLevel", required = false) String waterLevel,
			@RequestParam(value = "highLevel", required = false) String highLevel,
			@RequestParam(value = "normalLevel", required = false) String normalLevel,
			@RequestParam(value = "area", required = false) String area,
			@RequestParam(value = "normalCapacity", required = false) String normalCapacity,
			@RequestParam(value = "sumCapacity", required = false) String sumCapacity,
			@RequestParam(value = "floodCapacity", required = false) String floodCapacity,
			@RequestParam(value = "deadCapacity", required = false) String deadCapacity,
			@RequestParam(value = "floodLimitCapacity", required = false) String floodLimitCapacity,
			@RequestParam(value = "normalArea", required = false) String normalArea,
			@RequestParam(value = "floodLimitLevel", required = false) String floodLimitLevel,
			@RequestParam(value = "deadLevel", required = false) String deadLevel,
			@RequestParam(value = "yearsFlow", required = false) String yearsFlow,
			@RequestParam(value = "starttime", required = false) String starttime,
			@RequestParam(value = "endtime", required = false) String endtime,
			@RequestParam(value = "reservoirManager", required = false) String reservoirManager,
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
		if (areaId != null) {
			queryparams.put("areaId", areaId);
		}
		if (alias != null) {
			queryparams.put("alias", alias);
		}
		if (location != null) {
			queryparams.put("location", location);
		}
		if (leftX != null) {
			queryparams.put("leftX", leftX);
		}
		if (rightX != null) {
			queryparams.put("rightX", rightX);
		}
		if (rightY != null) {
			queryparams.put("rightY", rightY);
		}
		if (leftY != null) {
			queryparams.put("leftY", leftY);
		}
		if (reservoirType != null) {
			queryparams.put("reservoirType", reservoirType);
		}
		if (reservoirWork != null) {
			queryparams.put("reservoirWork", reservoirWork);
		}
		if (build != null) {
			queryparams.put("build", build);
		}
		if (reservoirLevel != null) {
			queryparams.put("reservoirLevel", reservoirLevel);
		}
		if (scale != null) {
			queryparams.put("scale", scale);
		}
		if (waterLevel != null) {
			queryparams.put("waterLevel", waterLevel);
		}
		if (highLevel != null) {
			queryparams.put("highLevel", highLevel);
		}
		if (normalLevel != null) {
			queryparams.put("normalLevel", normalLevel);
		}
		if (area != null) {
			queryparams.put("area", area);
		}
		if (normalCapacity != null) {
			queryparams.put("normalCapacity", normalCapacity);
		}
		if (sumCapacity != null) {
			queryparams.put("sumCapacity", sumCapacity);
		}
		if (floodCapacity != null) {
			queryparams.put("floodCapacity", floodCapacity);
		}
		if (deadCapacity != null) {
			queryparams.put("deadCapacity", deadCapacity);
		}
		if (floodLimitCapacity != null) {
			queryparams.put("floodLimitCapacity", floodLimitCapacity);
		}
		if (normalArea != null) {
			queryparams.put("normalArea", normalArea);
		}
		if (floodLimitLevel != null) {
			queryparams.put("floodLimitLevel", floodLimitLevel);
		}
		if (deadLevel != null) {
			queryparams.put("deadLevel", deadLevel);
		}
		if (yearsFlow != null) {
			queryparams.put("yearsFlow", yearsFlow);
		}
		if (starttime != null) {
			queryparams.put("starttime",  DateUtils.stringToDate(starttime,"yyyy-MM-dd"));
		}
		if (endtime != null) {
			queryparams.put("endtime", DateUtils.stringToDate(endtime,"yyyy-MM-dd"));
		}
		if (reservoirManager != null) {
			queryparams.put("reservoirManager", reservoirManager);
		}
		if (remark != null) {
			queryparams.put("remark", remark);
		}
		// 查询列表数据
		Query query = new Query(queryparams);
		//加入用户角色的资源的过滤
		query.put("roleId", StringUtil.joinList4sql(getRole(),"','"));

		List<ReservoirEntity> reservoirList = reservoirService.queryList(query);
		int total = reservoirService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(reservoirList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@RequiresPermissions("水库:查看")
	@ApiOperation(value = "信息", notes = "")
	public R info(@PathVariable("id") String id) {
		ReservoirEntity reservoir = reservoirService.queryObject(id);

		return R.ok().put("reservoir", reservoir);
	}

	/**
	 * 保存
	 */
	@SysLog("保存水库信息")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@RequiresPermissions("水库:管理")
	@ApiOperation(value = "保存", notes = "")
	public R save(@RequestBody ReservoirEntity reservoir) {
		verifyForm(reservoir);
	//	reservoir.setStarttime(DateUtils.stringToDate(reservoir.getStarttime().toString(),"yyyy MM dd"));
		reservoirService.save(reservoir);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改水库信息")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("水库:管理")
	@ApiOperation(value = "修改", notes = "")
	public R update(@RequestBody ReservoirEntity reservoir) {
		verifyForm(reservoir);
		reservoirService.update(reservoir);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除水库信息")
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("水库:管理")
	@ApiOperation(value = "删除", notes = "")
	public R delete(@PathVariable("ids") String ids) {
		String[] strings = ids.split(",");
		for (int i = 0; i < strings.length; i++) {
			if(partReservoirService.queryListByReservoirId(strings[i]).size()>0){
				throw  new RRException(200,"请先删除该水库库段");
			}
			reservoirService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(ReservoirEntity reservoir) {
		if (StringUtils.isBlank(reservoir.getName())) {
			throw new RRException(270, "水库名称不能为空");
		}
		if (StringUtils.isBlank(reservoir.getCode())) {
			throw new RRException(270, "水库编码不能为空");
		}
		if (StringUtils.isBlank(reservoir.getAreaId())) {
			throw new RRException(270, "所属行政区划不能为空");
		}
	}
}
