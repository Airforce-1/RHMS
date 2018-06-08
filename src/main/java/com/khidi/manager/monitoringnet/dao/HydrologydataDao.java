package com.khidi.manager.monitoringnet.dao;

import com.khidi.manager.monitoringnet.entity.HydrologydataEntity;
import com.khidi.manager.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-08 13:25:47
 */
@Mapper
public interface HydrologydataDao extends BaseDao<HydrologydataEntity> {
    HydrologydataEntity queryObjectfortop(String id);
	
}
