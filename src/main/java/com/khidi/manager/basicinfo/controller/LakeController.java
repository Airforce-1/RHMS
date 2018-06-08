package com.khidi.manager.basicinfo.controller;
import com.khidi.common.annotation.SysLog;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.basicinfo.service.PartLakeService;
import com.khidi.manager.sys.controller.AbstractController;

import java.util.List;
import java.util.Map;
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

import com.khidi.manager.basicinfo.entity.LakeEntity;
import com.khidi.manager.basicinfo.service.LakeService;
import com.khidi.common.exception.RRException;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;
/**
 * 湖泊基础信息管理
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
@RestController
@RequestMapping("lake")
@Api(value = "/Lake", description = "湖泊基础信息管理")
public class LakeController extends AbstractController {
	@Autowired
	private LakeService lakeService;
	@Autowired
	private PartLakeService partLakeService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions("湖泊:查看")
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
			@RequestParam(value = "deep", required = false) String deep,
			@RequestParam(value = "location", required = false) String location,
			@RequestParam(value = "leftX", required = false) String leftX,
			@RequestParam(value = "rightX", required = false) String rightX,
			@RequestParam(value = "rightY", required = false) String rightY,
			@RequestParam(value = "leftY", required = false) String leftY,
			@RequestParam(value = "yearsArea", required = false) String yearsArea,
			@RequestParam(value = "yearsCapacity", required = false) String yearsCapacity,
			@RequestParam(value = "lakeType", required = false) String lakeType,
			@RequestParam(value = "yearsDeep", required = false) String yearsDeep,
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
		if (deep != null) {
			queryparams.put("deep", deep);
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
		if (yearsArea != null) {
			queryparams.put("yearsArea", yearsArea);
		}
		if (yearsCapacity != null) {
			queryparams.put("yearsCapacity", yearsCapacity);
		}
		if (lakeType != null) {
			queryparams.put("lakeType", lakeType);
		}
		if (yearsDeep != null) {
			queryparams.put("yearsDeep", yearsDeep);
		}
		if (remark != null) {
			queryparams.put("remark", remark);
		}
		// 查询列表数据
		Query query = new Query(queryparams);
		//加入用户角色的资源的过滤
		query.put("roleId", StringUtil.joinList4sql(getRole(),"','"));
		List<LakeEntity> lakeList = lakeService.queryList(query);
		int total = lakeService.queryTotal(query);


		PageUtils pageUtil = new PageUtils(lakeList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@RequiresPermissions("湖泊:查看")
	@ApiOperation(value = "信息", notes = "")
	public R info(@PathVariable("id") String id) {
		LakeEntity lake = lakeService.queryObject(id);

		return R.ok().put("lake", lake);
	}

	/**
	 * 保存
	 */
	@SysLog("保存湖泊信息")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@RequiresPermissions("湖泊:管理")
	@ApiOperation(value = "保存", notes = "")
	public R save(@RequestBody LakeEntity lake) {
		verifyForm(lake);
		lakeService.save(lake);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改湖泊信息")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("湖泊:管理")
	@ApiOperation(value = "修改", notes = "")
	public R update(@RequestBody LakeEntity lake) {
		verifyForm(lake);
		lakeService.update(lake);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除湖泊信息")
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("湖泊:管理")
	@ApiOperation(value = "删除", notes = "")
	public R delete(@PathVariable("ids") String ids) {
		String[] strings = ids.split(",");
		for (int i = 0; i < strings.length; i++) {
			if(partLakeService.queryListByLakeId(strings[i]).size()>0){
				throw  new RRException(200,"请先删除该湖泊湖段");
			}
			lakeService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(LakeEntity lake) {
		if (StringUtils.isBlank(lake.getName())) {
			throw new RRException(270, "湖泊名称不能为空");
		}
		if (StringUtils.isBlank(lake.getCode())) {
			throw new RRException(270, "湖泊编码不能为空");
		}
		if (StringUtils.isBlank(lake.getAreaId())) {
			throw new RRException(270, "所属行政区划不能为空");
		}
	}

}
