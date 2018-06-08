package com.khidi.manager.basicinfo.dao;

import com.khidi.manager.basicinfo.entity.ResourceStationEntity;
import com.khidi.manager.sys.dao.BaseDao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-22 17:36:48
 */
@Mapper
public interface ResourceStationDao extends BaseDao<ResourceStationEntity> {
	List<ResourceStationEntity> queryByResource(Map<String, Object> map);
	List<ResourceStationEntity> allStations(@Param("stationType") String stationType);
	ResourceStationEntity queryObjectByCode(String code);
//	List<ResourceStationEntity> queryUpStationLinks(Map<String, Object> map);
}
