package com.khidi.manager.officework.service;

import com.khidi.manager.officework.entity.CheckrecordEntity;
import com.khidi.manager.officework.vo.CheckRecordVo;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-10 11:56:31
 */
public interface CheckrecordService {
	
	CheckrecordEntity queryObject(String id);
	
	List<CheckRecordVo> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CheckrecordEntity checkrecord);
	
	void update(CheckrecordEntity checkrecord);
	
	void delete(String id);
}
