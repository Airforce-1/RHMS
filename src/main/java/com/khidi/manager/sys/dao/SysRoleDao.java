package com.khidi.manager.sys.dao;

import com.khidi.manager.sys.entity.SysMenuEntity;
import com.khidi.manager.sys.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:33:33
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRoleEntity> {

    List<String> queryRoleIdList(String parentId);
    List<SysRoleEntity> querySonList(String parentId);

    List<String> queryRoleList(String user_id);



    String queryParentIdIsCorrent(SysRoleEntity entity);


}
