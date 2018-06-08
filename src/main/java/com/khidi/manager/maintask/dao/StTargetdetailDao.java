package com.khidi.manager.maintask.dao;

import com.khidi.manager.maintask.entity.StTargetdetailEntity;
import com.khidi.manager.maintask.entity.StTargetdetailTransmitEntity;
import com.khidi.manager.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-03 10:29:04
 */
@Mapper
public interface StTargetdetailDao extends BaseDao<StTargetdetailEntity> {
    List<StTargetdetailTransmitEntity> queryTargetdetailTransmitByTargetedtailId(String TargetedtailId);

    int queryPower(@Param("targetdetailid") String targetdetailid, @Param("userid")  String userid);

    String queryNewToDept(@Param("targetdetailid")  String targetdetailid);
}
