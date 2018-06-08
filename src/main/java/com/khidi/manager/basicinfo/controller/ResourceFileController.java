package com.khidi.manager.basicinfo.controller;

import com.khidi.common.annotation.SysLog;
import com.khidi.common.exception.RRException;
import com.khidi.common.utils.Constant;
import com.khidi.common.validator.ValidatorUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.khidi.manager.sys.controller.AbstractController;
import com.khidi.manager.sys.entity.SysMenuEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.khidi.manager.basicinfo.entity.ResourceFileEntity;
import com.khidi.manager.basicinfo.service.ResourceFileService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashMap;

/**
 * 制度管理
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-24 15:59:55
 */
@RestController
@RequestMapping("resourcefile")
@Api(value = "/ResourceFile", description = "制度管理")
public class ResourceFileController extends AbstractController {
	@Autowired
	private ResourceFileService resourceFileService;
	@Value("${file.location}")
	private String filePath;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions("制度管理:查看")
	@ApiOperation(value = "列表", notes = "")
	public R list(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "limit", required = true) int limit,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "areaId", required = false) String areaId,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "filePath", required = false) String filePath,
			@RequestParam(value = "riverType", required = false) String riverType,
			@RequestParam(value = "riverName", required = false) String riverName,
			@RequestParam(value = "fileSize", required = false) String fileSize,
			@RequestParam(value = "orderNum", required = false) Double orderNum,
			@RequestParam(value = "remark", required = false) String remark,
			@RequestParam(value = "filetype", required = false) String filetype) {
		Map<String, Object> queryparams = new HashMap<String, Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
		if (id != null) {
			queryparams.put("id", id);
		}
		if (areaId != null) {
			queryparams.put("areaId", areaId);
		}
		if (name != null) {
			queryparams.put("name", name);
		}
		if (filePath != null) {
			queryparams.put("filePath", filePath);
		}
		if (riverType != null) {
			queryparams.put("riverType", riverType);
		}
		if (title != null) {
			queryparams.put("title", title);
		}
		if (riverName != null) {
			queryparams.put("riverName", riverName);
		}
		if (fileSize != null) {
			queryparams.put("fileSize", fileSize);
		}
		if (orderNum != null) {
			queryparams.put("orderNum", orderNum);
		}
		if (remark != null) {
			queryparams.put("remark", remark);
		}
		if (filetype != null) {
			queryparams.put("filetype", filetype);
		}
		// 查询列表数据
		Query query = new Query(queryparams);

		List<ResourceFileEntity> resourceFileList = resourceFileService.queryList(query);
		int total = resourceFileService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(resourceFileList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@RequiresPermissions("制度管理:查看")
	@ApiOperation(value = "信息", notes = "")
	public R info(@PathVariable("id") String id) {
		ResourceFileEntity resourceFile = resourceFileService.queryObject(id);

		return R.ok().put("resourceFile", resourceFile);
	}

	@RequestMapping(value = "/viewpdf/{id}", method = RequestMethod.GET)
	@RequiresPermissions("制度管理:查看")
	@ApiOperation(value = "信息", notes = "")
	public R viewpdf(@PathVariable("id") String id) {
		ResourceFileEntity resourceFile = resourceFileService.queryObject(id);

		return R.ok().put("resourceFile", resourceFile);
	}

	/**
	 * 上传文件
	 */
	@SysLog("上传制度文件")
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@RequiresPermissions("制度管理:管理")
	@ApiOperation(value = "上传文件", notes = "支持pdf、doc、docx、txt、xls、xlsx、ppt、pptx格式")
	public R save(@RequestParam(value = "file") MultipartFile file) {
		return R.ok().put("data", resourceFileService.upload(file, filePath));
	}

	/**
	 * 提交文件信息
	 */
	@SysLog("保存制度文件信息")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@RequiresPermissions("制度管理:管理")
	@ApiOperation(value = "提交文件信息", notes = "")
	public R save(@RequestBody ResourceFileEntity resourceFile) {
		verifyForm(resourceFile);
		resourceFileService.save(resourceFile);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改制度文件")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("制度管理:管理")
	@ApiOperation(value = "修改", notes = "")
	public R update(@RequestBody ResourceFileEntity resourceFile) {
		verifyForm(resourceFile);
		resourceFileService.update(resourceFile);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除制度文件")
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("制度管理:管理")
	@ApiOperation(value = "删除", notes = "")
	public R delete(@PathVariable("ids") String ids) {
		String[] strings = ids.split(",");
		for (int i = 0; i < strings.length; i++) {
			resourceFileService.delete(strings[i]);
		}
		return R.ok();
	}

	/**
	 * 验证参数是否正确
	 */
	private void verifyForm(ResourceFileEntity resourceFile) {
		if (StringUtils.isBlank(resourceFile.getAreaId())) {
			throw new RRException(270, "行政区域不能为空");
		}
		if (StringUtils.isBlank(resourceFile.getTitle())) {
			throw new RRException(270, "标题不能为空");
		}
		if (StringUtils.isBlank(resourceFile.getFiletype())) {
			throw new RRException(270, "文件类型不能为空");
		}
		if (StringUtils.isBlank(resourceFile.getFilePath())) {
			throw new RRException(270, "上传文件不能为空");
		}
	}
}