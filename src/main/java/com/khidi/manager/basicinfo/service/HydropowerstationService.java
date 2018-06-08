package com.khidi.manager.basicinfo.service;

import java.util.List;
import com.khidi.manager.basicinfo.entity.HydropowerstationEntity;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-15 15:37:03
 */
public interface HydropowerstationService {
	
	HydropowerstationEntity queryObject(String id);
	
	List<HydropowerstationEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HydropowerstationEntity hydropowerstation);
	
	void update(HydropowerstationEntity hydropowerstation);
	
	void delete(String id);
}
