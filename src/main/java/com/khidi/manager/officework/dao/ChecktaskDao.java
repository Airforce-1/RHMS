package com.khidi.manager.officework.dao;

import com.khidi.manager.officework.entity.ChecktaskEntity;
import com.khidi.manager.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-25 15:53:29
 */
@Mapper
public interface ChecktaskDao extends BaseDao<ChecktaskEntity> {
    void deleteByDailyTaskId(String dailyTaskId);
}
