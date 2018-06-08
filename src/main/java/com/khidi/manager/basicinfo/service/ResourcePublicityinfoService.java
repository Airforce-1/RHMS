package com.khidi.manager.basicinfo.service;

import com.khidi.manager.basicinfo.entity.ResourcePublicitycardEntity;
import com.khidi.manager.basicinfo.entity.ResourcePublicityinfoEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-04 18:19:33
 */
public interface ResourcePublicityinfoService {
	

	List<ResourcePublicityinfoEntity> queryList(Map<String, Object> map);
	int queryTotal(Map<String, Object> map);
	ResourcePublicityinfoEntity queryObject(String id);
	

}
