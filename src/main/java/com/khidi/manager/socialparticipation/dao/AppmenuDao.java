package com.khidi.manager.socialparticipation.dao;

import com.khidi.manager.socialparticipation.entity.AppmenuEntity;
import com.khidi.manager.sys.dao.BaseDao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-08 15:06:21
 */
@Mapper
public interface AppmenuDao extends BaseDao<AppmenuEntity> {
	int querySonMenusCounts(String parentid);
	List<AppmenuEntity> queryAll();
	List<AppmenuEntity> queryList0(Map<String, Object> map);
	List<AppmenuEntity> queryChildren(String id);
}
