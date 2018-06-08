package com.khidi.manager.sys.dao;

import com.khidi.manager.sys.entity.SysAreaEntity;
import com.khidi.manager.sys.entity.SysDeptEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 部门管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-20 15:23:47
 */
@Mapper
public interface SysDeptDao extends BaseDao<SysDeptEntity> {

    /**
     * 查询子部门ID列表
     * @param parentId  上级部门ID
     */
    List<String> queryDetpIdList(String parentId);

    String queryParentIdIsCorrent(SysDeptEntity entity);
}
