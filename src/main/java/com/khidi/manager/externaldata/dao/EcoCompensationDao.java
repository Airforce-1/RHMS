package com.khidi.manager.externaldata.dao;

import com.khidi.manager.externaldata.entity.EcoCompensationEntity;
import com.khidi.manager.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-17 16:39:02
 */
@Mapper
public interface EcoCompensationDao extends BaseDao<EcoCompensationEntity> {
    List<EcoCompensationEntity> queryListByStationId(String stationId);
}
