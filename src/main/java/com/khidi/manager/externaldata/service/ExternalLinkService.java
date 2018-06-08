package com.khidi.manager.externaldata.service;

import com.khidi.manager.externaldata.entity.ExternalLinkEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-18 16:16:33
 */
public interface ExternalLinkService {
	
	ExternalLinkEntity queryObject(String id);
	
	List<ExternalLinkEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ExternalLinkEntity externalLink);
	
	void update(ExternalLinkEntity externalLink);
	
	void delete(String id);
}
