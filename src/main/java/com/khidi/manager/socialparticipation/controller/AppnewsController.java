package com.khidi.manager.socialparticipation.controller;

import com.khidi.common.exception.RRException;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.khidi.manager.hbmwf.engine.wfutil.HbmwfAjaxIo;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.socialparticipation.entity.AppnewsEntity;
import com.khidi.manager.socialparticipation.entity.AppnewsMenuEntity;
import com.khidi.manager.socialparticipation.entity.AppnewsviewimgEntity;
import com.khidi.manager.socialparticipation.service.AppnewsMenuService;
import com.khidi.manager.socialparticipation.service.AppnewsService;
import com.khidi.manager.socialparticipation.service.AppnewsviewimgService;
import com.khidi.manager.sys.entity.FileUploadEntity;
import com.khidi.manager.sys.service.FileuploadService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-08 15:16:20 Jerry Wang 2017 12 09 功能实现 Jerry Wang 2017 12 25
 *       多附件扩展
 */
@RestController
@RequestMapping("appnews")
@Api(value = "/Appnews", description = "APP新闻管理")
public class AppnewsController {
	@Autowired
	private AppnewsService appnewsService;

	@Autowired
	private AppnewsMenuService newsmenuService;

	@Autowired
	private FileuploadService fileUploadService;

	@Value("${app.news.location}")
	private String rootPath;

	@Autowired
	private AppnewsviewimgService newViewImgService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions("APP新闻管理:查看")
	@ApiOperation(value = "列表", notes = "")
	public R list(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "limit", required = true) int limit,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "newsTitle", required = false) String newsTitle,
			@RequestParam(value = "deptName", required = false) String deptName,
			@RequestParam(value = "newsAuthor", required = false) String newsAuthor,
			@RequestParam(value = "areaId", required = false) String areaId,
			@RequestParam(value = "menuId", required = false) String menuId,
			@RequestParam(value = "isTop", required = false) String isTop,
			@RequestParam(value = "isPlay", required = false) String isPlay,
			@RequestParam(value = "newState", required = false) String newState,
			@RequestParam(value = "destroyTime", required = false) Date destroyTime,
			// @RequestParam(value="newscontent",required=false) Object
			// newscontent,
			@RequestParam(value = "picPath", required = false) String picPath) {
		Map<String, Object> queryparams = new HashMap<String, Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		queryparams.put("sidx", sidx);
		queryparams.put("order", order);
		if (id != null) {
			queryparams.put("id", id);
		}
		if (newsTitle != null) {
			queryparams.put("newsTitle", newsTitle);
		}
		if (deptName != null) {
			queryparams.put("deptName", deptName);
		}
		if (newsAuthor != null) {
			queryparams.put("newsAuthor", newsAuthor);
		}
		if (areaId != null) {
			queryparams.put("areaId", areaId);
		}
		if (menuId != null) {
			queryparams.put("menuId", menuId);
		}
		if (isTop != null) {
			queryparams.put("isTop", isTop);
		}
		if (isPlay != null) {
			queryparams.put("isPlay", isPlay);
		}
		if (newState != null) {
			queryparams.put("newState", newState);
		}
		if (destroyTime != null) {
			queryparams.put("destroyTime", destroyTime);
		}
		// if(newscontent != null){
		// queryparams.put("newscontent",newscontent);
		// }
		if (picPath != null) {
			queryparams.put("picPath", picPath);
		}
		// 查询列表数据
		Query query = new Query(queryparams);

		List<AppnewsEntity> appnewsList = appnewsService.queryList(query);
		for (AppnewsEntity lpEntity : appnewsList) {
			if (lpEntity.getNewsContent() == null) {
				lpEntity.setNewsContent("");

			} else {
				byte[] bytesContent = (byte[]) lpEntity.getNewsContent();
				String newContent = new String(bytesContent);
				lpEntity.setNewsContent(newContent);
			}
			//
			if (lpEntity.getDestroyTime() != null && lpEntity.getDestroyTime().getTime() <= new Date().getTime()) {
				lpEntity.setNewState("4");
			}
			//
			List<AppnewsviewimgEntity> lpFileList = newViewImgService.getAttachByNewsId(lpEntity.getId());
			if (lpFileList != null && lpFileList.size() > 0) {
				String attIds = "";
				for (AppnewsviewimgEntity lpImg : lpFileList) {
					attIds += lpImg.getId() + ",";
				}
				if (attIds.endsWith(",")) {
					attIds = attIds.substring(0, attIds.length() - 1);
				}
				lpEntity.setFileaddress(attIds);
			}
			lpEntity.setFileList(lpFileList);
		}
		int total = appnewsService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(appnewsList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@RequiresPermissions("APP新闻管理:查看")
	@ApiOperation(value = "信息", notes = "")
	public R info(@PathVariable("id") String id) {
		AppnewsEntity appnews = appnewsService.queryObject(id);
		if (appnews == null) {
			return R.error().put("data", null);
		}
		if (appnews.getNewsContent() != null) {
			byte[] bytesContent = (byte[]) appnews.getNewsContent();
			String newContent = new String(bytesContent);
			appnews.setNewsContent(newContent);
			if (appnews.getDestroyTime() != null) {
				if (appnews.getDestroyTime().getTime() <= new Date().getTime()) {
					appnews.setNewState("4");
				}
			}
		} else {
			appnews.setNewsContent("");
		}
		appnews.setFileList(newViewImgService.getAttachByNewsId(appnews.getId()));
		if (appnews.getFileList() != null && appnews.getFileList().size() > 0) {
			String attIds = "";
			for (AppnewsviewimgEntity lpImg : appnews.getFileList()) {
				attIds += lpImg.getId() + ",";
			}
			if (attIds.endsWith(",")) {
				attIds = attIds.substring(0, attIds.length() - 1);
			}
			appnews.setFileaddress(attIds);
		}
		//
		return R.ok().put("data", appnews);
	}

	/**
	 * 保存
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@RequiresPermissions("APP新闻管理:管理")
	@ApiOperation(value = "保存", notes = "")
	public R save(@RequestBody AppnewsEntity appnews) throws Exception {
		appnews.setId(String.valueOf(UUID.randomUUID()));
		//
		String newsContent = String.valueOf(appnews.getNewsContent());
		Object newContentBytes = newsContent.getBytes();
		appnews.setNewsContent(newContentBytes);
		appnews.setCreateTime(new Date());
		appnews.setLastUpdateTime(new Date());
		//
		verifyForm(appnews);
		//
		String menuId = appnews.getMenuId();
		//
		String[] menuIdArr = menuId.split(",");
		String newsID0 = appnews.getId();
		for (String lpMenuId : menuIdArr) {
			//
			AppnewsMenuEntity lpAme = new AppnewsMenuEntity();
			lpAme.setAppinfoid(newsID0);
			lpAme.setAppmenuid(lpMenuId);
			newsmenuService.save(lpAme);
		}
		
		//
		// List<AppnewsviewimgEntity> appnewsViewImgs = appnews.getFileList();
		// if (appnews.getFileList() != null && appnews.getFileList().size() >
		// 0) {
		// for (AppnewsviewimgEntity lpViewImgEntity : appnewsViewImgs) {
		// lpViewImgEntity.setAppNewsId(appnews.getId());
		// //
		// newViewImgService.save(lpViewImgEntity);
		// }
		// }
		String fileAddress = appnews.getFileaddress();
		if (fileAddress != null && !fileAddress.equals("")) {
			String[] fileAddressArr = fileAddress.split(",");
			for (String attId : fileAddressArr) {
				FileUploadEntity lpFile = fileUploadService.queryObject(attId);
				if (lpFile != null) {
					AppnewsviewimgEntity lpViewImg = new AppnewsviewimgEntity();
					lpViewImg.setFileName(lpFile.getFileName());
					lpViewImg.setFilePath(lpFile.getFilePath());
					lpViewImg.setAppNewsId(appnews.getId());
					lpViewImg.setId(attId);
					//
					newViewImgService.save(lpViewImg);
				}
			}
		}
		appnewsService.save(appnews);
		return R.ok().put("data", appnews);
	}

	@ApiOperation(value = "APP NEWS 新增(支持文件上传)", notes = "APP NEWS 新增(支持文件上传)")
	@RequestMapping(value = "/newApp", method = { RequestMethod.POST, RequestMethod.GET })
	public void newApp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter rspOut = response.getWriter();
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");

		String newsTitle = request.getParameter("newsTitle");
		String deptName = request.getParameter("deptName");
		String newsAuthor = request.getParameter("newsAuthor");
		String areaId = request.getParameter("areaId");
		String menuId = request.getParameter("menuId");
		String isTop = request.getParameter("isTop");
		String destroyTime = request.getParameter("destroyTime");
		String isPlay = request.getParameter("isPlay");
		String picPath = "";
		String newsContent = request.getParameter("newsContent");
		String newState = request.getParameter("newState");
		AppnewsEntity newsEntity = new AppnewsEntity();
		newsEntity.setNewsTitle(newsTitle);
		newsEntity.setDeptName(deptName);
		newsEntity.setNewsAuthor(newsAuthor);
		newsEntity.setAreaId(areaId);
		newsEntity.setMenuId(menuId);
		newsEntity.setIsTop(isTop);
		newsEntity.setIsPlay(isPlay);
		newsEntity.setDestroyTime(HbmwfUtil.GetDateNoF(destroyTime));
		newsEntity.setNewState(newState);
		// newsEntity.setPicpath(picPath);
		newsEntity.setNewsContent(newsContent);
		String theNewId = String.valueOf(UUID.randomUUID());
		newsEntity.setId(theNewId);
		verifyForm(newsEntity);
		//
		String newsContent0 = String.valueOf(newsEntity.getNewsContent());
		Object newContentBytes = newsContent0.getBytes();
		newsEntity.setNewsContent(newContentBytes);
		newsEntity.setCreateTime(new Date());
		newsEntity.setLastUpdateTime(new Date());
		//
		//
		String aimFilefullpath = HbmwfUtil.getNewsImgPath(newsEntity.getId(), rootPath, true);

		//
		for (MultipartFile lpFile : files) { // 实际这里只传单文件
			BufferedOutputStream out;
			try {
				String lpAimFilefullname = aimFilefullpath + lpFile.getOriginalFilename();
				// newsEntity.setPicPath(lpAimFilefullname.replace(rootPath,
				// ""));
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
			rspOut.println(HbmwfAjaxIo.GetReturn("1", "文件上传成功", newsEntity));
		}
		//
		String[] menuIdArr = menuId.split(",");
		String newsID0 = newsEntity.getId();
		for (String lpMenuId : menuIdArr) {
			//
			AppnewsMenuEntity lpAme = new AppnewsMenuEntity();
			lpAme.setAppinfoid(newsID0);
			lpAme.setAppmenuid(lpMenuId);
			newsmenuService.save(lpAme);
		}
		//

		//
		appnewsService.save(newsEntity);
		// return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("APP新闻管理:管理")
	@ApiOperation(value = "修改", notes = "")
	public R update(@RequestBody AppnewsEntity appnews) {
		verifyForm(appnews);
		//
		String menuId = appnews.getMenuId();
		String[] menuIdArr = menuId.split(",");
		String newsID0 = appnews.getId();
		newsmenuService.delete(newsID0);
		//
		for (String lpMenuId : menuIdArr) {
			//
			AppnewsMenuEntity lpAme = new AppnewsMenuEntity();
			lpAme.setAppinfoid(newsID0);
			lpAme.setAppmenuid(lpMenuId);
			newsmenuService.save(lpAme);
		}
		//
		//
		newViewImgService.delete(appnews.getId());
		//
		// List<AppnewsviewimgEntity> appnewsViewImgs = appnews.getFileList();
		// if (appnews.getFileList() != null && appnews.getFileList().size() >
		// 0) {
		// for (AppnewsviewimgEntity lpViewImgEntity : appnewsViewImgs) {
		// lpViewImgEntity.setAppNewsId(appnews.getId());
		// //
		// newViewImgService.save(lpViewImgEntity);
		// }
		// }
		String fileAddress = appnews.getFileaddress();
		if (fileAddress != null && !fileAddress.equals("")) {
			String[] fileAddressArr = fileAddress.split(",");
			for (String attId : fileAddressArr) {
				FileUploadEntity lpFile = fileUploadService.queryObject(attId);
				if (lpFile != null) {
					AppnewsviewimgEntity lpViewImg = new AppnewsviewimgEntity();
					lpViewImg.setFileName(lpFile.getFileName());
					lpViewImg.setFilePath(lpFile.getFilePath());
					lpViewImg.setAppNewsId(appnews.getId());
					lpViewImg.setId(attId);
					//
					newViewImgService.save(lpViewImg);
				}
			}
		}
		//
		String newsContent0 = String.valueOf(appnews.getNewsContent());
		Object newContentBytes = newsContent0.getBytes();
		appnews.setNewsContent(newContentBytes);
		appnews.setLastUpdateTime(new Date());
		appnewsService.update(appnews);
		////

		//
		return R.ok().put("data", appnews);
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "/updateState", method = RequestMethod.PUT)
	@RequiresPermissions("APP新闻管理:管理")
	@ApiOperation(value = "修改", notes = "")
	public R updateState(@RequestParam(value = "newsId", required = true) String newsId,
			@RequestParam(value = "newState", required = true) String newState) {
		AppnewsEntity appnews = new AppnewsEntity();
		appnews.setId(newsId);
		appnews.setNewState(newState);
		appnews.setLastUpdateTime(new Date());
		//
		appnewsService.updateState(appnews);
		//
		return R.ok().put("data", appnews);
	}

	//
	// @ApiOperation(value = "APP NEWS 编辑(支持文件上传)", notes = "APP NEWS
	// 编辑(支持文件上传)")
	// @RequestMapping(value = "/updateApp", method = { RequestMethod.POST,
	// RequestMethod.GET })
	public void updateApp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter rspOut = response.getWriter();
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");

		String newsId = request.getParameter("id");
		String newsTitle = request.getParameter("newsTitle");
		String deptName = request.getParameter("deptName");
		String newsAuthor = request.getParameter("newsAuthor");
		String areaId = request.getParameter("areaId");
		String menuId = request.getParameter("menuId");
		String isTop = request.getParameter("isTop");
		String isPlay = request.getParameter("isPlay");
		String destroyTime = request.getParameter("destroyTime");
		String picPath = request.getParameter("theTile");
		String newsContent = request.getParameter("newsContent");
		// String lastUpdateTime = request.getParameter("lastUpdateTime");
		AppnewsEntity newsEntity = new AppnewsEntity();
		newsEntity.setId(newsId);
		newsEntity.setNewsTitle(newsTitle);
		newsEntity.setDeptName(deptName);
		newsEntity.setNewsAuthor(newsAuthor);
		newsEntity.setAreaId(areaId);
		newsEntity.setMenuId(menuId);
		newsEntity.setIsTop(isTop);
		newsEntity.setDestroyTime(HbmwfUtil.GetDateNoF(destroyTime));
		// newsEntity.setPicPath(picPath);
		newsEntity.setIsPlay(isPlay);
		newsEntity.setNewsContent(newsContent);
		verifyForm(newsEntity);
		//
		String newsContent0 = String.valueOf(newsEntity.getNewsContent());
		Object newContentBytes = newsContent0.getBytes();
		newsEntity.setNewsContent(newContentBytes);
		newsEntity.setCreateTime(new Date());
		newsEntity.setLastUpdateTime(new Date());
		//
		//
		String aimFilefullpath = HbmwfUtil.getNewsImgPath(newsEntity.getId(), rootPath, true);

		//
		for (MultipartFile lpFile : files) { // 实际这里只传单文件
			BufferedOutputStream out;
			try {
				String lpAimFilefullname = aimFilefullpath + lpFile.getOriginalFilename();
				// newsEntity.setPicPath(lpAimFilefullname.replace(rootPath,
				// ""));
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
			rspOut.println(HbmwfAjaxIo.GetReturn("1", "文件上传成功", newsEntity));
		}
		//
		//
		String[] menuIdArr = menuId.split(",");
		String newsID0 = newsEntity.getId();
		newsmenuService.delete(newsID0);
		for (String lpMenuId : menuIdArr) {
			//
			AppnewsMenuEntity lpAme = new AppnewsMenuEntity();
			lpAme.setAppinfoid(newsID0);
			lpAme.setAppmenuid(lpMenuId);
			newsmenuService.save(lpAme);
		}
		//
		appnewsService.update(newsEntity);
		// return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("APP新闻管理:管理")
	@ApiOperation(value = "删除", notes = "")
	public R delete(@PathVariable("ids") String ids) {
		String[] strings = ids.split(",");
		for (int i = 0; i < strings.length; i++) {
			newsmenuService.delete(strings[i]);
			newViewImgService.delete(strings[i]);
			appnewsService.delete(strings[i]);
		}
		return R.ok();
	}

	private void verifyForm(AppnewsEntity appnews) {
		// if (StringUtils.isBlank(appnews.getId())) {
		// throw new RRException(270, "系统编码不能为空");
		// }
		if (StringUtils.isBlank(appnews.getNewsTitle())) {
			throw new RRException(270, "标题不能为空");
		}
		if (StringUtils.isBlank(appnews.getDeptName())) {
			throw new RRException(270, "来源单位不能为空");
		}
		if (StringUtils.isBlank(appnews.getNewsAuthor())) {
			throw new RRException(270, "作者不能为空");
		}
		if (StringUtils.isBlank(appnews.getAreaId())) {
			throw new RRException(270, "行政区划编码不能为空");
		}
		if (StringUtils.isBlank(appnews.getMenuId())) {
			throw new RRException(270, "所属栏目不能为空");
		}
		if (StringUtils.isBlank(appnews.getIsTop())) {
			throw new RRException(270, "是否置顶不能为空");
		}
		// if(StringUtils.isBlank(appnews.getDestroytime())){
		// throw new RRException(270,"失效时间不能为空");
		// }
		// if(StringUtils.isBlank(appnews.getNewscontent())){
		// throw new RRException(270,"信息内容不能为空");
		// }
		// if(StringUtils.isBlank(appnews.getPicpath())){
		// throw new RRException(270,"缩略图路径不能为空");
		// }
	}

}