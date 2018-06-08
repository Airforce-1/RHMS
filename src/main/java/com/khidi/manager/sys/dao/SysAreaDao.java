package com.khidi.manager.sys.dao;

import com.khidi.manager.sys.entity.SysAreaEntity;
import com.khidi.manager.sys.entity.SysRoleEntity;
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
public interface SysAreaDao extends BaseDao<SysAreaEntity> {

    /**
     * 查询行政区域ID列表
     * @param parentId  上级部门ID
     */
    List<String> queryAreaIdList(String parentId);

    List<SysAreaEntity> queryListByParentId(String parentId);

    List<SysAreaEntity> queryExistsByParentId(String parentId);

    List<SysAreaEntity> getList4Open();

    String queryParentIdIsCorrent(SysAreaEntity entity);

    List<String> getSubAreaIdList(String parentId);
}
