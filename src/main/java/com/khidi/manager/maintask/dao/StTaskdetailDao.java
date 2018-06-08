package com.khidi.manager.maintask.dao;

import com.khidi.manager.maintask.entity.StSubtaskprogressEntity;
import com.khidi.manager.maintask.entity.StTaskdetailEntity;
import com.khidi.manager.maintask.entity.StTaskdetailTransmitEntity;
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
public interface StTaskdetailDao extends BaseDao<StTaskdetailEntity> {
    List<StTaskdetailTransmitEntity> queryTaskdetailTransmitByTaskdetailId (String TaskdetailId);

    List<StSubtaskprogressEntity>  querySubtaskprogressByTaskdetailId (String subtaskid);

    List<StTaskdetailEntity> queryTaskdetailListByTaskId (String taskId);

    int queryPower(@Param("taskdetailid") String taskdetailid,@Param("userid")  String userid);

    String queryNewToDept(@Param("taskdetailid")  String taskdetailid);
}
