package com.khidi.manager.officework.controller;

import io.swagger.annotations.ApiParam;
import com.khidi.common.exception.RRException;
import org.apache.commons.lang.StringUtils;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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

import com.khidi.manager.officework.entity.MeetingmembersEntity;
import com.khidi.manager.officework.service.MeetingmembersService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;

/**
 * ${comments}
 * 
 * @author Jerry Wang
 * @email 405877884@qq.com
 * @date 2017-12-26 09:39:11
 */
@RestController
@RequestMapping("meetingmembers")
@Api(value = "/Meetingmembers", description = "会议成员管理")
public class MeetingmembersController {
	@Autowired
	private MeetingmembersService meetingmembersService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions("会议管理:查看")
	@ApiOperation(value = "列表", notes = "")
	public R list(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "limit", required = true) int limit,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "memberOrg", required = false) String memberOrg,
			@RequestParam(value = "memberName", required = false) String memberName,
			@RequestParam(value = "formType", required = false) String formType,
			@RequestParam(value = "formId", required = false) String formId) {
		Map<String, Object> queryparams = new HashMap<String, Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
		if (id != null) {
			queryparams.put("id", id);
		}
		if (memberOrg != null) {
			queryparams.put("memberOrg", memberOrg);
		}
		if (memberName != null) {
			queryparams.put("memberName", memberName);
		}
		if (formType != null) {
			queryparams.put("formType", formType);
		}
		if (formId != null) {
			queryparams.put("formId", formId);
		}
		// 查询列表数据
		Query query = new Query(queryparams);

		List<MeetingmembersEntity> meetingmembersList = meetingmembersService.queryList(query);
		int total = meetingmembersService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(meetingmembersList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@RequiresPermissions("会议管理:查看")
	@ApiOperation(value = "信息", notes = "")
	public R info(@PathVariable("id") String id) {
		MeetingmembersEntity meetingmembers = meetingmembersService.queryObject(id);

		return R.ok().put("data", meetingmembers);
	}

	/**
	 * 保存
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@RequiresPermissions("会议管理:管理")
	@ApiOperation(value = "保存", notes = "")
	public R save(@RequestBody MeetingmembersEntity meetingmembers) {
		meetingmembers.setId(String.valueOf(UUID.randomUUID()));
		verifyForm(meetingmembers);
		meetingmembersService.save(meetingmembers);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("会议管理:管理")
	@ApiOperation(value = "修改", notes = "")
	public R update(@RequestBody MeetingmembersEntity meetingmembers) {
		verifyForm(meetingmembers);
		meetingmembersService.update(meetingmembers);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("会议管理:管理")
	@ApiOperation(value = "删除", notes = "")
	public R delete(@PathVariable("ids") String ids) {
		String[] strings = ids.split(",");
		for (int i = 0; i < strings.length; i++) {
			meetingmembersService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(MeetingmembersEntity meetingmembers) {
		if (StringUtils.isBlank(meetingmembers.getId())) {
			throw new RRException(270, "Id不能为空");
		}
		// if(StringUtils.isBlank(meetingmembers.getMemberorg())){
		// throw new RRException(270,"部门不能为空");
		// }
		if (StringUtils.isBlank(meetingmembers.getMemberName())) {
			throw new RRException(270, "姓名不能为空");
		}
		if (StringUtils.isBlank(meetingmembers.getFormType())) {
			throw new RRException(270, "表单类型不能为空");
		}
		if (StringUtils.isBlank(meetingmembers.getFormId())) {
			throw new RRException(270, "表单编号不能为空");
		}
	}

}