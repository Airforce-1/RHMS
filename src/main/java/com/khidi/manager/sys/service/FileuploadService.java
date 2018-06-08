package com.khidi.manager.sys.service;

import com.khidi.manager.sys.entity.FileUploadEntity;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-13 17:14:24
 */
public interface FileuploadService {
	
	FileUploadEntity queryObject(String id);
	
	List<FileUploadEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(FileUploadEntity fileupload);
	
	void update(FileUploadEntity fileupload);
	
	void delete(String id);

	Map<String, Object> upload(MultipartFile file, String filePath , String opType) throws IOException;
}
