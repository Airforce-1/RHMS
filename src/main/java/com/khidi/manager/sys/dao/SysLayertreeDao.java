package com.khidi.manager.sys.dao;

import com.khidi.manager.sys.entity.SysLayertreeEntity;
import com.khidi.manager.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-13 15:21:19
 */
@Mapper
public interface SysLayertreeDao extends BaseDao<SysLayertreeEntity> {
    int queryCountbyParentId(String parentId);
    List<SysLayertreeEntity> querySonList(String parentId);
    String queryParentIdIsCorrent(SysLayertreeEntity entity);
}
