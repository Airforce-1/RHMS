package com.khidi.manager.maintask.dao;

import com.khidi.manager.maintask.entity.StTaskEntity;
import com.khidi.manager.maintask.entity.StTaskdetailEntity;
import com.khidi.manager.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-03 10:29:04
 */
@Mapper
public interface StTaskDao extends BaseDao<StTaskEntity> {
    List<StTaskdetailEntity> queryTaskDetailByTaskId (String StTaskId);
}
