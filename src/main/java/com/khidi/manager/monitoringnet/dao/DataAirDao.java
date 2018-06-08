package com.khidi.manager.monitoringnet.dao;

import com.khidi.manager.monitoringnet.entity.DataAirEntity;
import com.khidi.manager.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-30 14:23:59
 */
@Mapper
public interface DataAirDao extends BaseDao<DataAirEntity> {
    DataAirEntity getAir4Gis(String stationId);
	
}
