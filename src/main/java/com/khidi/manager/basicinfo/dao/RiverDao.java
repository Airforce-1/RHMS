package com.khidi.manager.basicinfo.dao;

import com.khidi.manager.basicinfo.entity.RiverEntity;
import com.khidi.manager.sys.dao.BaseDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:56:52
 */
@Mapper
public interface RiverDao extends BaseDao<RiverEntity> {
	List<RiverEntity> queryChildrenRivers(@Param("parentId") String parentId);
}
