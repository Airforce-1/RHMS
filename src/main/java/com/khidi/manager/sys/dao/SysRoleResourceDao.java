package com.khidi.manager.sys.dao;

import com.khidi.manager.sys.entity.SysRoleResourceEntity;
import com.khidi.manager.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-14 14:31:17
 */
@Mapper
public interface SysRoleResourceDao extends BaseDao<SysRoleResourceEntity> {
    SysRoleResourceEntity queryObjectByRoleId(String roleId);
    void deleteByRoleId(String roleId);
}
