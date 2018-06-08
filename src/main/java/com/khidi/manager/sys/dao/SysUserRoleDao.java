package com.khidi.manager.sys.dao;

import com.khidi.manager.sys.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户与角色对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:34:46
 */
@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<String> queryRoleIdList(String userId);

	void deletebyRoleId(String roleId);
	void deletebyUserId(String userId);

	List<SysUserRoleEntity> queryListforUser(Map<String, Object> map);

	void delUserRole(SysUserRoleEntity sysUserRoleEntity);
}
