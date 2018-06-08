package com.khidi.manager.officework.controller;

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

import com.khidi.manager.officework.entity.MeetingattachEntity;
import com.khidi.manager.officework.service.MeetingattachService;
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
@RequestMapping("meetingattach")
@Api(value = "/Meetingattach", description = "会议附件管理")
public class MeetingattachController {
	@Autowired
	private MeetingattachService meetingattachService;

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
			@RequestParam(value = "formid", required = false) String formid,
			@RequestParam(value = "nodeid", required = false) String nodeid,
			@RequestParam(value = "formtype", required = false) String formtype,
			@RequestParam(value = "attachid", required = false) String attachid,
			@RequestParam(value = "attachname", required = false) String attachname,
			@RequestParam(value = "attachfilepath", required = false) String attachfilepath,
			@RequestParam(value = "nodeflag", required = false) String nodeflag) {
		Map<String, Object> queryparams = new HashMap<String, Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
		if (formid != null) {
			queryparams.put("formid", formid);
		}
		if (nodeid != null) {
			queryparams.put("nodeid", nodeid);
		}
		if (formtype != null) {
			queryparams.put("formtype", formtype);
		}
		if (attachid != null) {
			queryparams.put("attachid", attachid);
		}
		if (attachname != null) {
			queryparams.put("attachname", attachname);
		}
		if (attachfilepath != null) {
			queryparams.put("attachfilepath", attachfilepath);
		}
		if (nodeflag != null) {
			queryparams.put("nodeflag", nodeflag);
		}
		// 查询列表数据
		Query query = new Query(queryparams);

		List<MeetingattachEntity> meetingattachList = meetingattachService.queryList(query);
		int total = meetingattachService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(meetingattachList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	@RequiresPermissions("meetingattach:list")
//	@ApiOperation(value = "节点ID查询附件列表", notes = "")
	public R queryList0(@RequestParam(value = "formId", required = false) String formId,
			@RequestParam(value = "formType", required = false) String formType,
			@RequestParam(value = "nodeId", required = false) String nodeId) {
		return R.ok().put("data", null);
	}
	
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	@RequiresPermissions("meetingattach:list")
//	@ApiOperation(value = "节点类型查询附件列表", notes = "")
	public R queryList1(@RequestParam(value = "formId", required = false) String formId,
			@RequestParam(value = "formType", required = false) String formType,
			@RequestParam(value = "nodeOpType", required = false) String nodeOpType) {
		return R.ok().put("data", null);
	}

	/**
	 * 信息
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@RequiresPermissions("会议管理:查看")
	@ApiOperation(value = "信息", notes = "")
	public R info(@PathVariable("id") String id) {
		MeetingattachEntity meetingattach = meetingattachService.queryObject(id);

		return R.ok().put("data", meetingattach);
	}

	/**
	 * 保存
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@RequiresPermissions("会议管理:管理")
	@ApiOperation(value = "保存", notes = "")
	public R save(@RequestBody MeetingattachEntity meetingattach) {
		verifyForm(meetingattach);
		meetingattachService.save(meetingattach);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("会议管理:管理")
	@ApiOperation(value = "修改", notes = "")
	public R update(@RequestBody MeetingattachEntity meetingattach) {
		verifyForm(meetingattach);
		meetingattachService.update(meetingattach);
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
			meetingattachService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(MeetingattachEntity meetingattach) {
		if (StringUtils.isBlank(meetingattach.getFormid())) {
			throw new RRException(270, "formId不能为空");
		}
		if (StringUtils.isBlank(meetingattach.getNodeid())) {
			throw new RRException(270, "nodeId不能为空");
		}
		if (StringUtils.isBlank(meetingattach.getFormtype())) {
			throw new RRException(270, "formType不能为空");
		}
		if (StringUtils.isBlank(meetingattach.getAttachid())) {
			throw new RRException(270, "attachId不能为空");
		}
		if (StringUtils.isBlank(meetingattach.getAttachname())) {
			throw new RRException(270, "attachName不能为空");
		}
		if (StringUtils.isBlank(meetingattach.getAttachfilepath())) {
			throw new RRException(270, "attachFilePath不能为空");
		}
//		if (StringUtils.isBlank(meetingattach.getNodeflag())) {
//			throw new RRException(270, "${column.comments}不能为空");
//		}
	}

}