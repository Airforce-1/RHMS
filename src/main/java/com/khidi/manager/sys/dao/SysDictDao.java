package com.khidi.manager.sys.dao;

import com.khidi.manager.sys.entity.SysDictEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-17 09:48:30
 */
@Mapper
public interface SysDictDao extends BaseDao<SysDictEntity> {
    SysDictEntity queryObject(Map<String, Object> map);
    SysDictEntity queryObjectbyId(String id);
	
}
