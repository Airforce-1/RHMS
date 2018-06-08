package com.khidi.manager.officework.service;

import com.khidi.manager.officework.entity.ChecktaskEntity;
import com.khidi.manager.officework.vo.ChecktaskEntityVo;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-25 15:53:29
 */
public interface ChecktaskService {

	ChecktaskEntityVo queryObject(String id);
	
	List<ChecktaskEntityVo> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ChecktaskEntity checktask);
	
	void update(ChecktaskEntity checktask);
	
	void delete(String id);
}
