package com.khidi.manager.socialparticipation.controller;

import io.swagger.annotations.ApiParam;
import com.khidi.common.exception.RRException;
import org.apache.commons.lang.StringUtils;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.bind.annotation.*;

import com.khidi.manager.hbmwf.engine.wfutil.HbmwfAjaxIo;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.socialparticipation.entity.AppversionEntity;
import com.khidi.manager.socialparticipation.service.AppversionService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-08 15:06:21 Jerry Wang 2017 12 09 apptype : XZ_A(行政版安卓)
 *       XZ_I(行政版IOS) GZ_A(公众版安卓) GZ_I(公众版IOS)
 */
@RestController
@RequestMapping("appversion")
@Api(value = "/Appversion", description = "APP版本管理")
public class AppversionController {
	@Autowired
	private AppversionService appversionService;

	@Value("${app.install.location}")
	private String rootPath;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions("APP版本管理:查看")
	@ApiOperation(value = "列表", notes = "")
	public R list(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "limit", required = true) int limit,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "appType1", required = false) String appType1,
			@RequestParam(value = "appType2", required = false) String appType2,
			@RequestParam(value = "appName", required = false) String appName,
			@RequestParam(value = "appVersion", required = false) String appVersion,
			@RequestParam(value = "appPath", required = false) String appPath,
			@RequestParam(value = "appDesc", required = false) String appDesc) {
		Map<String, Object> queryparams = new HashMap<String, Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
		if (id != null) {
			queryparams.put("id", id);
		}
		if (appType1 != null) {
			queryparams.put("appType1", appType1);
		}
		if (appType2 != null) {
			queryparams.put("appType2", appType2);
		}
		if (appName != null) {
			queryparams.put("appName", appName);
		}
		if (appVersion != null) {
			queryparams.put("appVersion", appVersion);
		}
		if (appPath != null) {
			queryparams.put("appPath", appPath);
		}
		if (appDesc != null) {
			queryparams.put("appDesc", appDesc);
		}
		// 查询列表数据
		Query query = new Query(queryparams);

		List<AppversionEntity> appversionList = appversionService.queryList(query);
		int total = appversionService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(appversionList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@RequiresPermissions("APP版本管理:查看")
	@ApiOperation(value = "信息", notes = "")
	public R info(@PathVariable("id") String id) {
		AppversionEntity appversion = appversionService.queryObject(id);

		return R.ok().put("data", appversion);
	}

	/**
	 * 保存
	 */
	 @RequestMapping(value = "", method = RequestMethod.POST)
	 @RequiresPermissions("APP版本管理:管理")
	 @ApiOperation(value = "保存", notes = "")
	public R save(@RequestBody AppversionEntity appversion) {
		verifyForm(appversion);
        appversion.setId(UUID.randomUUID().toString());
        
		appversionService.save(appversion);
		return R.ok().put("data", appversion);
	}

//	@ApiOperation(value = "APP VERSION 新增(支持文件上传)", notes = "APP VERSION 新增(支持文件上传)")
//	@RequestMapping(value = "/newVerion", method = { RequestMethod.POST })
	public void newVerion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter rspOut = response.getWriter();
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");

		String appType1 = request.getParameter("apptype1");
		String appType2 = request.getParameter("apptype2");
		//
//		String appType = appType1 + "_" + appType2;
		String appName = request.getParameter("appname");
		String appVersion = request.getParameter("appversion");
		String appPath = "0";// request.getParameter("apppath");
		String appDesc = request.getParameter("appdesc");
		String releaseTime = request.getParameter("releasetime");

		AppversionEntity versionEntity = new AppversionEntity();
		versionEntity.setAppType1(appType1);
		versionEntity.setAppType2(appType2);
		versionEntity.setAppName(appName);
		versionEntity.setAppVersion(appVersion);
		versionEntity.setAppDesc(appDesc);
		versionEntity.setId(String.valueOf(UUID.randomUUID()));
		versionEntity.setAppPath(appPath);
		versionEntity.setReleaseTime(HbmwfUtil.GetDateNoF(releaseTime));
		verifyForm(versionEntity);
		//
		//
		String aimFilefullpath = HbmwfUtil.getNewsImgPath(versionEntity.getId(), rootPath, true);

		//
		for (MultipartFile lpFile : files) { // 实际这里只传单文件
			BufferedOutputStream out;
			try {
				String lpAimFilefullname = aimFilefullpath + lpFile.getOriginalFilename();
				versionEntity.setAppPath(lpAimFilefullname.replace(rootPath, ""));
				out = new BufferedOutputStream(new FileOutputStream(new File(lpAimFilefullname)));
				// out = new BufferedOutputStream(new FileOutputStream(new File(
				// lpFile.getOriginalFilename())));
				out.write(lpFile.getBytes());
				// out.flush();
				out.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// rspOut.println("upload failed");
				rspOut.println(HbmwfAjaxIo.GetReturn("0", e.getMessage(), null));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// rspOut.println("upload failed");
				rspOut.println(HbmwfAjaxIo.GetReturn("0", e.getMessage(), null));
			}
			// rspOut.println("upload successfully");
			rspOut.println(HbmwfAjaxIo.GetReturn("1", "文件上传成功", versionEntity));
		}
		//
		appversionService.save(versionEntity);
		// return R.ok();
	}

	/**
	 * 修改
	 */
	 @RequestMapping(value = "", method = RequestMethod.PUT)
	 @RequiresPermissions("APP版本管理:管理")
	 @ApiOperation(value = "修改", notes = "")
	public R update(@RequestBody AppversionEntity appversion) {
		verifyForm(appversion);
		appversionService.update(appversion);
		return R.ok();
	}
	
//	@ApiOperation(value = "APP VERSION 编辑(支持文件上传)", notes = "APP VERSION 编辑(支持文件上传)")
//	@RequestMapping(value = "/editVerion", method = { RequestMethod.POST })
	public void editVerion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter rspOut = response.getWriter();
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");

		String theId = request.getParameter("id");
		String appType1 = request.getParameter("apptype1");
		String appType2 = request.getParameter("apptype2");
//		String appType = appType1 + "_" + appType2;
		String appName = request.getParameter("appname");
		String appVersion = request.getParameter("appversion");
		String appPath = request.getParameter("apppath");
		String appDesc = request.getParameter("appdesc");
		String releaseTime = request.getParameter("releasetime");
		//
		AppversionEntity versionEntity = new AppversionEntity();
		versionEntity.setId(theId);
		versionEntity.setAppType1(appType1);
		versionEntity.setAppType2(appType2);
		versionEntity.setAppName(appName);
		versionEntity.setAppVersion(appVersion);
		versionEntity.setAppDesc(appDesc);
		versionEntity.setAppPath(appPath);
		versionEntity.setReleaseTime(HbmwfUtil.GetDateNoF(releaseTime));
		verifyForm(versionEntity);
		//
		String aimFilefullpath = HbmwfUtil.getNewsImgPath(versionEntity.getId(), rootPath, true);

		//
		for (MultipartFile lpFile : files) { // 实际这里只传单文件
			BufferedOutputStream out;
			try {
				String lpAimFilefullname = aimFilefullpath + lpFile.getOriginalFilename();
				versionEntity.setAppPath(lpAimFilefullname.replace(rootPath, ""));
				out = new BufferedOutputStream(new FileOutputStream(new File(lpAimFilefullname)));
				// out = new BufferedOutputStream(new FileOutputStream(new File(
				// lpFile.getOriginalFilename())));
				out.write(lpFile.getBytes());
				// out.flush();
				out.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// rspOut.println("upload failed");
				rspOut.println(HbmwfAjaxIo.GetReturn("0", e.getMessage(), null));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// rspOut.println("upload failed");
				rspOut.println(HbmwfAjaxIo.GetReturn("0", e.getMessage(), null));
			}
			// rspOut.println("upload successfully");
			rspOut.println(HbmwfAjaxIo.GetReturn("1", "文件上传成功", versionEntity));
		}
		//
		appversionService.update(versionEntity);
		// return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("APP版本管理:管理")
	@ApiOperation(value = "删除", notes = "")
	public R delete(@PathVariable("ids") String ids) {
		String[] strings = ids.split(",");
		for (int i = 0; i < strings.length; i++) {
			appversionService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(AppversionEntity appversion) {
//		if (StringUtils.isBlank(appversion.getId())) {
//			throw new RRException(270, "系统编码不能为空");
//		}
		if (StringUtils.isBlank(appversion.getAppType1())) {
			throw new RRException(270, "APP版本类型1不能为空");
		}
		if (StringUtils.isBlank(appversion.getAppType2())) {
			throw new RRException(270, "APP版本类型2不能为空");
		}
		if (StringUtils.isBlank(appversion.getAppName())) {
			throw new RRException(270, "版本名称不能为空");
		}
		if (StringUtils.isBlank(appversion.getAppVersion())) {
			throw new RRException(270, "版本号不能为空");
		}
//		if (StringUtils.isBlank(appversion.getAppPath())) {
//			throw new RRException(270, "app存放路径不能为空");
//		}
		if (StringUtils.isBlank(appversion.getAppDesc())) {
			throw new RRException(270, "版本说明不能为空");
		}
	}

}