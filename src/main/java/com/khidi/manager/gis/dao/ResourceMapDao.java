package com.khidi.manager.gis.dao;

import com.khidi.manager.basicinfo.entity.RiverEntity;
import com.khidi.manager.gis.entity.ResourceMapEntity;
import com.khidi.manager.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:56:52
 */
@Mapper
public interface ResourceMapDao extends BaseDao<ResourceMapEntity> {
	void updateRiverFeatureId(ResourceMapEntity resourceMapEntity);
	void updatePartRiverFeatureId(ResourceMapEntity resourceMapEntity);
	void updateCanalFeatureId(ResourceMapEntity resourceMapEntity);
	void updatePartCanalFeatureId(ResourceMapEntity resourceMapEntity);
	void updateLakeFeatureId(ResourceMapEntity resourceMapEntity);
	void updatePartLakeFeatureId(ResourceMapEntity resourceMapEntity);
	void updateReservoirFeatureId(ResourceMapEntity resourceMapEntity);
	void updatePartReservoirFeatureId(ResourceMapEntity resourceMapEntity);
	String queryRiverByFeatureId(String featureId);
	String queryPartRiverByFeatureId(String featureId);
	String queryCanalByFeatureId(String featureId);
	String queryPartCanalByFeatureId(String featureId);
	String queryLakeByFeatureId(String featureId);
	String queryPartLakeByFeatureId(String featureId);
	String queryReservoirByFeatureId(String featureId);
	String queryPartReservoirByFeatureId(String featureId);




}
