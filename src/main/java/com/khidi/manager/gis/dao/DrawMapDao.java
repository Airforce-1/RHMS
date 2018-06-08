package com.khidi.manager.gis.dao;

import com.khidi.manager.gis.entity.DrawMapEntity;
import com.khidi.manager.gis.entity.ResourceMapEntity;
import com.khidi.manager.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:56:52
 */
@Mapper
public interface DrawMapDao extends BaseDao<ResourceMapEntity> {
	void drawMap4WaterAbility(DrawMapEntity entity);
	void drawMap4Irrigated(DrawMapEntity entity);
}
