package com.khidi.manager.basicinfo.controller;

import com.khidi.common.annotation.SysLog;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.sys.controller.AbstractController;
import com.khidi.manager.sys.service.SysRoleResourceService;
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
import com.khidi.manager.basicinfo.entity.PartReservoirEntity;
import com.khidi.manager.basicinfo.service.PartReservoirService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
@RestController
@RequestMapping("partreservoir")
@Api(value = "/PartReservoir", description = "库段基础信息管理")
public class PartReservoirController extends AbstractController {
	@Autowired
	private PartReservoirService partReservoirService;
	@Autowired
	private SysRoleResourceService sysRoleResourceService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions("水库:查看")
	@ApiOperation(value = "列表", notes = "")
	public R list(
			@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "limit", required = true) int limit,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "reservoirId", required = false) String reservoirId,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "areaId", required = false) String areaId,
			@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "alias", required = false) String alias,
			@RequestParam(value = "riverStart", required = false) String riverStart,
			@RequestParam(value = "riverEnd", required = false) String riverEnd,
			@RequestParam(value = "startX", required = false) String startX,
			@RequestParam(value = "startY", required = false) String startY,
			@RequestParam(value = "endX", required = false) String endX,
			@RequestParam(value = "endY", required = false) String endY,
			@RequestParam(value = "length", required = false) String length,
			@RequestParam(value = "remark", required = false) String remark) {
		Map<String, Object> queryparams = new HashMap<String, Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);

		if (reservoirId != null) {
			queryparams.put("reservoirId", reservoirId);
		}
		if (id != null) {
			queryparams.put("id", id);
		}
		if (name != null) {
			queryparams.put("name", name);
		}
		if (areaId != null) {
			queryparams.put("areaId", areaId);
		}
		if (code != null) {
			queryparams.put("code", code);
		}
		if (alias != null) {
			queryparams.put("alias", alias);
		}
		if (riverStart != null) {
			queryparams.put("riverStart", riverStart);
		}
		if (riverEnd != null) {
			queryparams.put("riverEnd", riverEnd);
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
		if (length != null) {
			queryparams.put("length", length);
		}
		if (remark != null) {
			queryparams.put("remark", remark);
		}
		// 查询列表数据
		Query query = new Query(queryparams);
		//加入用户角色的资源的过滤
		Boolean isfilter = true;   //是否加入渠段的过滤
		for(String roleId:getRole()){
			if(sysRoleResourceService.queryObjectByRoleId(roleId) ==null) continue;
			String reservoirIds = sysRoleResourceService.queryObjectByRoleId(roleId).getReservoirids();
			//如果没有传入水库id，则返回所有库段
			if(StringUtil.isEmpty(reservoirId)){
				isfilter = false;
				break;
			}
			//如果sys_role_resource中有该水库权限，则不介入权限控制，返回该河流所有库段
			if(StringUtil.isNotEmpty(reservoirIds) && reservoirIds.contains(reservoirId)){
				isfilter = false;
			}
		}
		if(isfilter){
			query.put("roleId", StringUtil.joinList4sql(getRole(),"','"));
		}
		List<PartReservoirEntity> partReservoirList = partReservoirService.queryList(query);
		int total = partReservoirService.queryTotal(query);


		PageUtils pageUtil = new PageUtils(partReservoirList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@RequiresPermissions("水库:查看")
	@ApiOperation(value = "信息", notes = "")
	public R info(@PathVariable("id") String id) {
		PartReservoirEntity partReservoir = partReservoirService.queryObject(id);

		return R.ok().put("partReservoir", partReservoir);
	}

	/**
	 * 保存
	 */
	@SysLog("保存库段信息")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@RequiresPermissions("水库:管理")
	@ApiOperation(value = "保存", notes = "")
	public R save(@RequestBody PartReservoirEntity partReservoir) {
		verifyForm(partReservoir);
		partReservoirService.save(partReservoir);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改库段信息")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("水库:管理")
	@ApiOperation(value = "修改", notes = "")
	public R update(@RequestBody PartReservoirEntity partReservoir) {
		verifyForm(partReservoir);
		partReservoirService.update(partReservoir);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除库段信息")
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("水库:管理")
	@ApiOperation(value = "删除", notes = "")
	public R delete(@PathVariable("ids") String ids) {
		String[] strings = ids.split(",");
		for (int i = 0; i < strings.length; i++) {
			partReservoirService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(PartReservoirEntity partReservoir) {
		if (StringUtils.isBlank(partReservoir.getName())) {
			throw new RRException(270, "库段名称不能为空");
		}
		if (StringUtils.isBlank(partReservoir.getAreaId())) {
			throw new RRException(270, "所属行政区划不能为空");
		}
		if (StringUtils.isBlank(partReservoir.getCode())) {
			throw new RRException(270, "库段编码不能为空");
		}
	}
}
