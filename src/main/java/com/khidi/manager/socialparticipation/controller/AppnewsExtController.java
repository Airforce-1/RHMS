/**   
* @Title: SmvcUploadController.java 
* @Package com.khidi.manager.socialparticipation.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年12月9日 上午10:08:18 
* @version V1.0   
*/
package com.khidi.manager.socialparticipation.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfAjaxIo;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.socialparticipation.entity.AppnewsEntity;


//@Api(value = "API - APP NEWS IMG文件上传功能", description = "APP NEWS IMG文件上传功能")
//@Controller
//@RequestMapping(value = "/appnewsext")
//@CrossOrigin(origins = "*", maxAge = 3600)
public class AppnewsExtController {
	@Value("${app.news.location}")
	private String rootPath;

	// 创建目录
	private void CreatePath(String pPath) {
		try {
			if (!(new File(pPath).isDirectory())) {
				new File(pPath).mkdir();
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	// （支持多文件）上传功能
//	@ApiOperation(value = "APP NEWS 新增(支持多文件上传 文件上传测试)", notes = "APP NEWS 新增(支持多文件上传 文件上传测试)")
//	@RequestMapping(value = "/uploadMulti", method = RequestMethod.POST)
	public void uploadMulti(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter rspOut = response.getWriter();
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");

		String dataId = request.getParameter("theid");
		String aimFilefullpath = HbmwfUtil.getNewsImgPath(dataId, rootPath, true);
		//
		for (MultipartFile lpFile : files) {
			BufferedOutputStream out;
			try {
				String lpAimFilefullname = aimFilefullpath + lpFile.getOriginalFilename();
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
			rspOut.println(HbmwfAjaxIo.GetReturn("1", "文件上传成功", null));
		}
	}

//	@ApiOperation(value = "APP NEWS 新增(支持多文件上传)", notes = "APP NEWS 新增(支持多文件上传)")
//	@RequestMapping(value = "/newApp", method = RequestMethod.POST)
	public void newApp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter rspOut = response.getWriter();
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");

		String newsTitle = request.getParameter("newstitle");
		String deptName = request.getParameter("deptname");
		String newsAuthor = request.getParameter("newsauthor");
		String areaId = request.getParameter("areaid");
		String menuId = request.getParameter("menuid");
		String isTop = request.getParameter("istop");
		String destroyTime = request.getParameter("destroytime");
		String picPath = request.getParameter("picpath");
		String newsContent = request.getParameter("newscontent");
		AppnewsEntity newsEntity = new AppnewsEntity();
		newsEntity.setNewsTitle(newsTitle);
		newsEntity.setDeptName(deptName);
		newsEntity.setNewsAuthor(newsAuthor);
		newsEntity.setAreaId(areaId);
		newsEntity.setMenuId(menuId);
		newsEntity.setIsTop(isTop);
		newsEntity.setDestroyTime(HbmwfUtil.GetDate(destroyTime));
//		newsEntity.setPicPath(picPath);
		newsEntity.setNewsContent(newsContent);
		newsEntity.setId(String.valueOf(UUID.randomUUID()));
		
		//
		String newsContent0 = String.valueOf(newsEntity.getNewsContent());
		Object newContentBytes = newsContent0.getBytes();
		newsEntity.setNewsContent(newContentBytes);
		newsEntity.setCreateTime(new Date());
		//
//        verifyForm(newsEntity);
//		appnewsService.save(appnews);
//		return R.ok();
		//
		String aimFilefullpath = HbmwfUtil.getNewsImgPath(newsEntity.getId(), rootPath, true);
//		newsEntity.setPicPath(aimFilefullpath.replace("rootPath", ""));
		//
		for (MultipartFile lpFile : files) {
			BufferedOutputStream out;
			try {
				String lpAimFilefullname = aimFilefullpath + lpFile.getOriginalFilename();
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
			rspOut.println(HbmwfAjaxIo.GetReturn("1", "文件上传成功", null));
		}
	}

}
