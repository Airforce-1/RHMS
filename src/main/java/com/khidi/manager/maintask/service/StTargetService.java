package com.khidi.manager.maintask.service;

import com.khidi.manager.maintask.entity.StTargetEntity;
import com.khidi.manager.maintask.entity.StTargetdetailEntity;
import com.khidi.manager.maintask.entity.StTaskdetailEntity;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 *
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-03 10:29:04
 */
public interface StTargetService {

    StTargetEntity queryObject(String id);

    List<StTargetEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(StTargetEntity stTarget);

    void update(StTargetEntity stTarget);

    void delete(String id);


}
