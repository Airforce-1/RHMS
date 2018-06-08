package com.khidi.manager.sys.service.impl;

import com.khidi.common.utils.OfficeToPdf;
import com.khidi.manager.basicinfo.entity.ResourceFileEntity;
import com.khidi.manager.sys.entity.FileUploadEntity;
import com.khidi.manager.sys.redis.EnumUploadOpType;
import com.khidi.manager.sys.redis.PathUtil;
import com.khidi.manager.sys.redis.UploadCfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.sys.dao.FileuploadDao;
import com.khidi.manager.sys.entity.FileUploadEntity;
import com.khidi.manager.sys.service.FileuploadService;
import org.springframework.web.multipart.MultipartFile;


@Service("fileuploadService")
public class FileuploadServiceImpl implements FileuploadService {
    @Autowired
    private FileuploadDao fileuploadDao;
    @Autowired
    private UploadCfg uploadCfg;

    @Override
    public FileUploadEntity queryObject(String id) {
        return fileuploadDao.queryObject(id);
    }

    @Override
    public List<FileUploadEntity> queryList(Map<String, Object> map) {
        return fileuploadDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return fileuploadDao.queryTotal(map);
    }

    @Override
    public void save(FileUploadEntity fileupload) {fileuploadDao.save(fileupload);}

    @Override
    public void update(FileUploadEntity fileupload) {
        fileuploadDao.update(fileupload);
    }



    @Override
    public Map<String, Object> upload(MultipartFile file, String filePath ,String opType) throws IOException {
        FileUploadEntity fileUploadEntity= new FileUploadEntity();
        fileUploadEntity.setId(UUID.randomUUID().toString());  //设置主键
        fileUploadEntity.setFileSize(file.getSize());
        fileUploadEntity.setFileName(file.getOriginalFilename());
        fileUploadEntity.setFileType(file.getContentType());
        fileUploadEntity.setOpType(opType);
        uploadCfg.allowfile(EnumUploadOpType.valueOf(opType),file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1));
        String rootPath = uploadCfg.GetRootPath(EnumUploadOpType.valueOf(opType));
        String aimFilefullpath = PathUtil.getPath(fileUploadEntity.getId(), rootPath, true);

        fileUploadEntity.setFilePath("\\"+ fileUploadEntity.getOpType() + aimFilefullpath.replace(rootPath,"") + file.getOriginalFilename());

        fileUploadEntity.setFileAbsolutePath(aimFilefullpath);

        File input = new File(aimFilefullpath + fileUploadEntity.getFileName());
        file.transferTo(input);

        fileuploadDao.save(fileUploadEntity);
        Map<String, Object> map = new HashMap();
        map.put("id",fileUploadEntity.getId());
        map.put("filePath", fileUploadEntity.getFilePath());
        map.put("fileName", fileUploadEntity.getFileName());
        return map;
    }

    @Override
    public void delete(String id){
        StringBuilder sbf = new StringBuilder();
        FileUploadEntity fileUploadEntity = fileuploadDao.queryObject(id);
        String fileName = sbf.append(fileUploadEntity.getFileAbsolutePath()).append(fileUploadEntity.getFileName()).toString();
        System.out.println(sbf);
        File file = new File(fileName);
        if(file.isFile() && file.exists()){
            file.delete();
            System.out.println("删除文件"+fileName+"成功！");
        }else{
            System.out.println("删除文件"+fileName+"失败！");
        }

        fileuploadDao.delete(id);
    }
}
