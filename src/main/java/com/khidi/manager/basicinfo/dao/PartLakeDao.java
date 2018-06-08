package com.khidi.manager.basicinfo.dao;

import com.khidi.manager.basicinfo.entity.PartLakeEntity;
import com.khidi.manager.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
@Mapper
public interface PartLakeDao extends BaseDao<PartLakeEntity> {
    List<PartLakeEntity> queryListByLakeId(String lakeId);
}
