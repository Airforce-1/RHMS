/**   
* @Title: AppUploadFilesController.java 
* @Package com.khidi.manager.socialparticipation.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年12月15日 上午8:50:09 
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.khidi.common.annotation.SysLog;
import com.khidi.common.utils.R;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfAjaxIo;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.socialparticipation.entity.AppnewsEntity;
import com.khidi.manager.socialparticipation.entity.AppnewsMenuEntity;

import io.swagger.annotations.ApiOperation;

/**
 * @author Administrator
 *
 */
public class AppUploadFilesController {
//	@RequestMapping(value = "/upload", method = RequestMethod.POST)
//	@RequiresPermissions("resourcefile:upload")
//	@ApiOperation(value = "上传文件", notes = "支持pdf、doc、docx、txt、xls、xlsx、ppt、pptx格式")
//	public R save(@RequestParam(value = "file") MultipartFile file) {
//		return R.ok().put("data", resourceFileService.upload(file, filePath));
//	}
}
