package com.khidi.manager.monitoringnet.dao;

import com.khidi.manager.monitoringnet.entity.HydrologydataEntity;
import com.khidi.manager.monitoringnet.entity.WaterqualitydataEntity;
import com.khidi.manager.sys.dao.BaseDao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-08 13:25:47
 */
@Mapper
public interface WaterqualitydataDao extends BaseDao<WaterqualitydataEntity> {
    WaterqualitydataEntity queryObjectfortop(String id);
    List<WaterqualitydataEntity> queryObjectReleatedTime(Map<String, Object> map);
    WaterqualitydataEntity queryObjectReleatedTimeSingle(Map<String, Object> map);
}
