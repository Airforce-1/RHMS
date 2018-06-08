package com.khidi.manager.officework.service;

import com.khidi.manager.officework.entity.ChecktaskdailyEntity;
import com.khidi.manager.officework.vo.ChecktaskEntityVo;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-22 11:37:03
 */
public interface ChecktaskdailyService {
	
	ChecktaskEntityVo queryObject(String id);
	
	List<ChecktaskEntityVo> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ChecktaskdailyEntity checktaskdaily);
	
	void update(ChecktaskdailyEntity checktaskdaily);
	
	void delete(String id);
}
