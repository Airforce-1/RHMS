package com.khidi.manager.maintask.service;

import com.khidi.manager.maintask.entity.StProcessDetailEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 *
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-10 15:36:28
 */
public interface StProcessDetailService {

	StProcessDetailEntity queryObject(String id);

	List<StProcessDetailEntity> queryList(Map<String, Object> map);

	int queryTotal(Map<String, Object> map);

	void save(StProcessDetailEntity stProcessDetail);

	void update(StProcessDetailEntity stProcessDetail);

	void delete(String id);
}
