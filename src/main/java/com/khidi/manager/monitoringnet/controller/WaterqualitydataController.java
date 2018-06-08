package com.khidi.manager.monitoringnet.controller;

import com.khidi.common.utils.DateUtils;
import com.khidi.manager.sys.entity.SysDeptEntity;
import io.swagger.annotations.ApiParam;
import com.khidi.common.exception.RRException;
import org.apache.commons.lang.StringUtils;
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

import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.monitoringnet.entity.WaterqualitydataEntity;
import com.khidi.manager.monitoringnet.service.WaterqualitydataService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-08 13:25:47
 */
@RestController
@RequestMapping("waterqualitydata")
@Api(value = "/Waterqualitydata", description = "水质监测")
public class WaterqualitydataController {
	@Autowired
	private WaterqualitydataService waterqualitydataService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions("水质监测:查看")
	@ApiOperation(value = "列表", notes = "")
	public R list(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "limit", required = true) int limit,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "stationId", required = false) String stationId,
			@RequestParam(value = "ph", required = false) String ph,
			@RequestParam(value = "cod", required = false) String cod,
			@RequestParam(value = "bod", required = false) String bod,
			@RequestParam(value = "coliform", required = false) String coliform,
			@RequestParam(value = "phosphor", required = false) String phosphor,
			@RequestParam(value = "maxuptemp", required = false) String maxuptemp,
			@RequestParam(value = "maxfalltemp", required = false) String maxfalltemp,
			@RequestParam(value = "nh", required = false) String nh,
			@RequestParam(value = "oxygen", required = false) String oxygen,
			@RequestParam(value = "permanganate", required = false) String permanganate,
			@RequestParam(value = "totaln", required = false) String totaln,
			@RequestParam(value = "cu", required = false) String cu,
			@RequestParam(value = "zn", required = false) String zn,
			@RequestParam(value = "fluoride", required = false) String fluoride,
			@RequestParam(value = "se", required = false) String se,
			@RequestParam(value = "arsenic", required = false) String arsenic,
			@RequestParam(value = "hg", required = false) String hg,
			@RequestParam(value = "cd", required = false) String cd,
			@RequestParam(value = "chromium", required = false) String chromium,
			@RequestParam(value = "lead", required = false) String lead,
			@RequestParam(value = "cyanide", required = false) String cyanide,
			@RequestParam(value = "phenol", required = false) String phenol,
			@RequestParam(value = "petroleum", required = false) String petroleum,
			@RequestParam(value = "anionic", required = false) String anionic,
			@RequestParam(value = "sulfide", required = false) String sulfide) {
		Map<String, Object> queryparams = new HashMap<String, Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
		if (id != null) {
			queryparams.put("id", id);
		}
		if (startDate != null) {
			queryparams.put("startDate", DateUtils.stringToDate(startDate, "yyyy-MM-dd HH:mm:ss"));
		}
		if (endDate != null) {
			queryparams.put("endDate", DateUtils.stringToDate(endDate, "yyyy-MM-dd HH:mm:ss"));
		}
		if (stationId != null) {
			queryparams.put("stationId", stationId);
		}
		if (ph != null) {
			queryparams.put("ph", ph);
		}
		if (cod != null) {
			queryparams.put("cod", cod);
		}
		if (bod != null) {
			queryparams.put("bod", bod);
		}
		if (coliform != null) {
			queryparams.put("coliform", coliform);
		}
		if (phosphor != null) {
			queryparams.put("phosphor", phosphor);
		}
		if (maxuptemp != null) {
			queryparams.put("maxuptemp", maxuptemp);
		}
		if (maxfalltemp != null) {
			queryparams.put("maxfalltemp", maxfalltemp);
		}
		if (nh != null) {
			queryparams.put("nh", nh);
		}
		if (oxygen != null) {
			queryparams.put("oxygen", oxygen);
		}
		if (permanganate != null) {
			queryparams.put("permanganate", permanganate);
		}
		if (totaln != null) {
			queryparams.put("totaln", totaln);
		}
		if (cu != null) {
			queryparams.put("cu", cu);
		}
		if (zn != null) {
			queryparams.put("zn", zn);
		}
		if (fluoride != null) {
			queryparams.put("fluoride", fluoride);
		}
		if (se != null) {
			queryparams.put("se", se);
		}
		if (arsenic != null) {
			queryparams.put("arsenic", arsenic);
		}
		if (hg != null) {
			queryparams.put("hg", hg);
		}
		if (cd != null) {
			queryparams.put("cd", cd);
		}
		if (chromium != null) {
			queryparams.put("chromium", chromium);
		}
		if (lead != null) {
			queryparams.put("lead", lead);
		}
		if (cyanide != null) {
			queryparams.put("cyanide", cyanide);
		}
		if (phenol != null) {
			queryparams.put("phenol", phenol);
		}
		if (petroleum != null) {
			queryparams.put("petroleum", petroleum);
		}
		if (anionic != null) {
			queryparams.put("anionic", anionic);
		}
		if (sulfide != null) {
			queryparams.put("sulfide", sulfide);
		}
		// 查询列表数据
		Query query = new Query(queryparams);

		List<WaterqualitydataEntity> waterqualitydataList = waterqualitydataService.queryList(query);
		int total = waterqualitydataService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(waterqualitydataList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 根据测站列表返回第一条数据
	 */
	@RequestMapping(value = "/toplist", method = RequestMethod.GET)
	@RequiresPermissions("水质监测:查看")
	@ApiOperation(value = "列表", notes = "")
	public R toplist(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "limit", required = true) int limit,
			@RequestParam(value = "areaId", required = false) String areaId,
			@RequestParam(value = "stationName", required = false) String stationName,
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate) {
		Map<String, Object> queryparams = new HashMap<String, Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		if (areaId != null) {
			queryparams.put("areaId", areaId);
		}
		if (stationName != null) {
			queryparams.put("stationName", stationName);
		}
		if (startDate != null) {
			queryparams.put("startDate", DateUtils.stringToDate(startDate, "yyyy-MM-dd HH:mm:ss"));
		}
		if (endDate != null) {
			queryparams.put("endDate", DateUtils.stringToDate(endDate, "yyyy-MM-dd HH:mm:ss"));
		}
		// 查询列表数据
		Query query = new Query(queryparams);

		List<WaterqualitydataEntity> waterqualitydataList = waterqualitydataService.querytopList(query);

		if (waterqualitydataList.size() < page * limit) {
			PageUtils pageUtil = new PageUtils(
					waterqualitydataList.subList((page - 1) * limit, waterqualitydataList.size()),
					waterqualitydataList.size(), query.getLimit(), query.getPage());
			return R.ok().put("page", pageUtil);
		} else {
			PageUtils pageUtil = new PageUtils(waterqualitydataList.subList((page - 1) * limit, page * limit),
					waterqualitydataList.size(), query.getLimit(), query.getPage());
			return R.ok().put("page", pageUtil);
		}
	}

	/**
	 * 根据所选的测站ids(id1,id2,... 或者单个id)（id可能一个或者多个）和 时间(时间点)，查出所有的测站值
	 * @throws Exception 
	 */
	@RequestMapping(value = "/queryMultiWaterqualityData", method = RequestMethod.GET)
	@RequiresPermissions("水质监测:查看")
	@ApiOperation(value = "根据所选的测站ids(id1,id2,... 或者单个id)（id可能一个或者多个）和 时间(时间点)，查出所有的测站值", notes = "")
	public R queryMultiWaterqualityData(@RequestParam(value = "stationIds", required = true) String stationIds,
			@RequestParam(value = "ctDate", required = false) String ctDate) throws Exception {
		if(ctDate == null || ctDate.equals(""))
		{
			ctDate = HbmwfUtil.GetDataString0(new Date(),"yyyy-mm-dd HH:mm:ss");
		}
		List<WaterqualitydataEntity> rtn0 = waterqualitydataService.queryObjectReleatedTime(stationIds, ctDate);
		//

		return R.ok().put("data", rtn0);
	}

	/**
	 * 信息
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@RequiresPermissions("水质监测:查看")
	@ApiOperation(value = "信息", notes = "")
	public R info(@PathVariable("id") String id) {
		WaterqualitydataEntity waterqualitydata = waterqualitydataService.queryObject(id);

		return R.ok().put("data", waterqualitydata);
	}

	/**
	 * 保存
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@RequiresPermissions("水质监测:管理")
	@ApiOperation(value = "保存", notes = "")
	public R save(@RequestBody WaterqualitydataEntity waterqualitydata) {
		verifyForm(waterqualitydata);
		waterqualitydataService.save(waterqualitydata);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("水质监测:管理")
	@ApiOperation(value = "修改", notes = "")
	public R update(@RequestBody WaterqualitydataEntity waterqualitydata) {
		verifyForm(waterqualitydata);
		waterqualitydataService.update(waterqualitydata);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("水质监测:管理")
	@ApiOperation(value = "删除", notes = "")
	public R delete(@PathVariable("ids") String ids) {
		String[] strings = ids.split(",");
		for (int i = 0; i < strings.length; i++) {
			waterqualitydataService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(WaterqualitydataEntity waterqualitydata) {
		if (StringUtils.isBlank(waterqualitydata.getCreatetime().toString())) {
			throw new RRException(270, "时间不能为空");
		}
		if (StringUtils.isBlank(waterqualitydata.getStationId())) {
			throw new RRException(270, "监测站编码不能为空");
		}
	}

}