package com.khidi.manager.maintask.service;

import com.khidi.manager.maintask.entity.*;

import java.util.List;

/**
 * Created by admin on 2018/1/22.
 */
public interface StCommonService  {

    List<StTaskdetailTransmitEntity> queryTaskdetailTransmitByTaskdetailId (String TaskdetailId);

    List<StSubtaskprogressEntity>  querySubtaskprogressByTaskdetailId (String subtaskid);

    List<StTaskdetailEntity> queryTaskdetailListByTaskId (String taskId);

    List<StTargetdetailTransmitEntity> queryTargetdetailTransmitByTargetedtailId(String TargetedtailId);

    List<StTargetdetailEntity> queryTargetdetailByTargetId(String TargetId);
}
