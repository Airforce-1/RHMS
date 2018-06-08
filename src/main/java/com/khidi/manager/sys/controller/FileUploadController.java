package com.khidi.manager.sys.controller;

import com.khidi.common.annotation.SysLog;
import com.khidi.common.utils.R;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfAjaxIo;
import com.khidi.manager.sys.dao.FileuploadDao;
import com.khidi.manager.sys.entity.FileUploadEntity;
import com.khidi.manager.sys.redis.EnumUploadOpType;
import com.khidi.manager.sys.redis.PathUtil;
import com.khidi.manager.sys.redis.UploadCfg;
import com.khidi.manager.sys.service.FileuploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

/**
 * Created by admin on 2017/12/15.
 */
@RestController
@RequestMapping("/sys/upload")
@Api(value = "/sys/upload", description = "文件上传")
public class FileUploadController {
    @Autowired
    private FileuploadService fileuploadService;
    @Value("${file.upload.location}")
    private String rootPath;

    @RequestMapping(value = "/singleUpload", method = RequestMethod.POST)
    @ApiOperation(value = "单上传文件", notes = "")
    public R save(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "opType") String opType) throws IOException {
        return R.ok().put("data", fileuploadService.upload(file, rootPath, opType));
    }


    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除", notes = "")
    public R delete(@PathVariable("ids") String ids) {
        String[] strings = ids.split(",");
        for (int i = 0; i < strings.length; i++) {
            fileuploadService.delete(strings[i]);
        }
        return R.ok();
    }


    @ApiOperation(value = "下载", notes = "")
    @RequestMapping(value = "/download", method = {RequestMethod.POST,RequestMethod.GET})
    public void downloadFile(HttpServletRequest request,
                             HttpServletResponse response,
                             @RequestParam(value = "fileId") String fileId)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        OutputStream os = null;
        InputStream is = null;
        String downFileName = fileuploadService.queryObject(fileId).getFileName();
        String rootPath = fileuploadService.queryObject(fileId).getFileAbsolutePath();
        downFileName = rootPath  + downFileName;
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
            System.out.println("下载文件!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
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


    //    @RequestMapping(value = "/multUpload", method = RequestMethod.POST)
//    @ApiOperation(value = "上传多文件", notes = "")
    public void fileUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {


        PrintWriter rspOut = response.getWriter();
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");

        FileUploadEntity fileUploadEntity = new FileUploadEntity();

        //	fileUploadEntity.setId(String.valueOf(UUID.randomUUID()));

        //    String aimFilefullpath = HbmwfUtil.getNewsImgPath(fileUploadEntity.getId(), rootPath, true);

        //
        for (MultipartFile lpFile : files) { // 实际这里只传单文件
            BufferedOutputStream out;
            try {
                fileUploadEntity.setId(String.valueOf(UUID.randomUUID()));
                fileUploadEntity.setFileName(lpFile.getOriginalFilename());
                fileUploadEntity.setFileSize(lpFile.getSize());
                fileUploadEntity.setFileType(lpFile.getContentType());

                String aimFilefullpath = PathUtil.getPath(fileUploadEntity.getId(), rootPath, true);

                fileUploadEntity.setFilePath(aimFilefullpath.replace(rootPath, ""));
                fileUploadEntity.setFileAbsolutePath(aimFilefullpath);

                String lpAimFilefullname = aimFilefullpath + lpFile.getOriginalFilename();


                //	fileUploadEntity.setFilePath(lpAimFilefullname.replace(rootPath, ""));
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
        //
        fileuploadService.save(fileUploadEntity);
        //return R.ok();
    }


}
