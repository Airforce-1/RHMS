package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.ResourceFileEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-24 15:59:55
 */
public interface ResourceFileService {
	
	ResourceFileEntity queryObject(String id);
	
	List<ResourceFileEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResourceFileEntity resourceFileEntity);

	Map<String, Object> upload(MultipartFile file, String filePath);
	
	void update(ResourceFileEntity resourceFile);
	
	void delete(String id);
}
