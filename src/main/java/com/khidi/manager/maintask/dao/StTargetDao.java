package com.khidi.manager.maintask.dao;

import com.khidi.manager.maintask.entity.StTargetEntity;
import com.khidi.manager.maintask.entity.StTargetdetailEntity;
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
public interface StTargetDao extends BaseDao<StTargetEntity> {
    List<StTargetdetailEntity> queryTargetdetailByTargetId(String TargetId);
}
