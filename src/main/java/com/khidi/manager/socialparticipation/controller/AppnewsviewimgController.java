package com.khidi.manager.socialparticipation.controller;

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

import com.khidi.manager.socialparticipation.entity.AppnewsviewimgEntity;
import com.khidi.manager.socialparticipation.service.AppnewsviewimgService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;

/**
 * ${comments}
 * 
 * @author JerryWang
 * @email 405877884@qq.com
 * @date 2017-12-25 13:40:37
 */
// @RestController
// @RequestMapping("appnewsviewimg")
// @Api(value = "/Appnewsviewimg", description = "新闻附件读取")
public class AppnewsviewimgController {
	@Autowired
	private AppnewsviewimgService appnewsviewimgService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions("appnewsviewimg:list")
	@ApiOperation(value = "列表", notes = "")
	public R list(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "limit", required = true) int limit,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "appnewsid", required = false) String appnewsid,
			@RequestParam(value = "filepath", required = false) String filepath,
			@RequestParam(value = "attachid", required = false) String attachid) {
		Map<String, Object> queryparams = new HashMap<String, Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
		if (appnewsid != null) {
			queryparams.put("appnewsid", appnewsid);
		}
		if (filepath != null) {
			queryparams.put("filepath", filepath);
		}
		if (attachid != null) {
			queryparams.put("attachid", attachid);
		}
		// 查询列表数据
		Query query = new Query(queryparams);

		List<AppnewsviewimgEntity> appnewsviewimgList = appnewsviewimgService.queryList(query);
		int total = appnewsviewimgService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(appnewsviewimgList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@RequiresPermissions("appnewsviewimg:info")
	@ApiOperation(value = "信息", notes = "")
	public R info(@PathVariable("id") String id) {
		AppnewsviewimgEntity appnewsviewimg = appnewsviewimgService.queryObject(id);

		return R.ok().put("data", appnewsviewimg);
	}

	/**
	 * 保存
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@RequiresPermissions("appnewsviewimg:save")
	@ApiOperation(value = "保存", notes = "")
	public R save(@RequestBody AppnewsviewimgEntity appnewsviewimg) {
		verifyForm(appnewsviewimg);
		appnewsviewimgService.save(appnewsviewimg);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("appnewsviewimg:update")
	@ApiOperation(value = "修改", notes = "")
	public R update(@RequestBody AppnewsviewimgEntity appnewsviewimg) {
		verifyForm(appnewsviewimg);
		appnewsviewimgService.update(appnewsviewimg);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("appnewsviewimg:delete")
	@ApiOperation(value = "删除", notes = "")
	public R delete(@PathVariable("ids") String ids) {
		String[] strings = ids.split(",");
		for (int i = 0; i < strings.length; i++) {
			appnewsviewimgService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(AppnewsviewimgEntity appnewsviewimg) {
		if (StringUtils.isBlank(appnewsviewimg.getAppNewsId())) {
			throw new RRException(270, "${column.comments}不能为空");
		}
		if (StringUtils.isBlank(appnewsviewimg.getFilePath())) {
			throw new RRException(270, "${column.comments}不能为空");
		}
		if (StringUtils.isBlank(appnewsviewimg.getId())) {
			throw new RRException(270, "${column.comments}不能为空");
		}
	}
}