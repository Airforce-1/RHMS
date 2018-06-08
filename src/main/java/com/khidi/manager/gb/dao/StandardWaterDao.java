package com.khidi.manager.gb.dao;

import com.khidi.manager.gb.entity.StandardWaterEntity;
import com.khidi.manager.gb.vo.DataByLevelVo;
import com.khidi.manager.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-29 11:12:03
 */
@Mapper
public interface StandardWaterDao extends BaseDao<StandardWaterEntity> {
    DataByLevelVo getDataByLevel(String level);
    int getCodLevelByValue(String Value) ;
    int getPLevelByValue(String Value) ;
    int getNHLevelByValue(String Value) ;
	
}
