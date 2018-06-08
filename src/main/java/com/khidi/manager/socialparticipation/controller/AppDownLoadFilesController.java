/**   
* @Title: AppDownLoadFiles.java 
* @Package com.khidi.manager.socialparticipation.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年12月11日 下午3:58:11 
* @version V1.0   
*/
package com.khidi.manager.socialparticipation.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("appnews")
@Api(value = "/Appnews", description = "APP文件下载接口(参数:file  type(appnews,appver))")
public class AppDownLoadFilesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Value("${app.news.location}")
	private String rootPath0;

	@Value("${app.install.location}")
	private String rootPath1;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AppDownLoadFilesController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@ApiOperation(value = "APP NEWS (文件下载)", notes = "APP NEWS (文件下载)")
	@RequestMapping(value = "/downloadFile", method = { RequestMethod.POST, RequestMethod.GET })
	public void downloadFile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/txt");
		OutputStream os = null;
		InputStream is = null;
		// ServletContext ctx = getServletContext();
		String downFileName = request.getParameter("file");
//		if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
//			downFileName = URLEncoder.encode(downFileName, "UTF-8");
//		} else {
//			downFileName = new String(downFileName.getBytes("UTF-8"), "ISO8859-1");
//		}
		String downType = request.getParameter("type");
		String rootPath = "";
		switch (downType) {
		case "appnews":
			rootPath = rootPath0;
			break;
		case "appver":
			rootPath = rootPath1;
			break;
		default:
			break;
		}
		downFileName = rootPath + downFileName;
		System.out.println(downFileName);
		try {
			// URLEncoder.encode解决了文件名称是中文的问题
			String fileName = "";
			if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
				fileName = URLEncoder.encode(downFileName, "UTF-8");
			} else {
				fileName = new String(downFileName.getBytes("UTF-8"), "ISO8859-1");
			}
			File tempFile = new File(fileName.trim());
			fileName = tempFile.getName();
			response.setHeader("Content-Disposition",
					"attachment;filename=" + fileName);
//					"attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
			// ，获取输入流，指定下载文件的所在路径
			is = new FileInputStream(downFileName);

			int read = 0;
			byte[] bytes = new byte[1024];
			// 把文件读取到输入流并放到缓冲区，再写到输出流
			os = response.getOutputStream();
			while ((read = is.read(bytes)) != -1) {
				os.write(bytes, 0, read);
			}
			System.out.println("下载文件了!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		} catch (Exception e) {
			System.out.println("error:" + downFileName);
			e.printStackTrace();
		} finally {
			if (os != null) {
				os.flush();
				os.close();
			}
			if (is != null) {
				is.close();
			}
		}
	}

	// /**
	// * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	// response)
	// */
	// protected void doPost(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// // TODO Auto-generated method stub
	// doGet(request, response);
	// }
}
