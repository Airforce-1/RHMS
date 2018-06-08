package com.khidi.manager.sys.service;

import com.khidi.manager.sys.entity.SysMenuEntity;

import java.util.List;
import java.util.Map;


/**
 * 菜单管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:42:16
 */
public interface SysMenuService {
	
	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 * @param menuIdList  用户菜单ID
	 */
	List<SysMenuEntity> queryListParentId(String parentId, List<String> menuIdList);

	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<SysMenuEntity> queryListParentId(String parentId);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<SysMenuEntity> queryNotButtonList();
	
	/**
	 * 获取用户菜单列表
	 */
	List<SysMenuEntity> getUserMenuList(String userId);
	
	/**
	 * 查询菜单
	 */
	SysMenuEntity queryObject(String menuId);
	
	/**
	 * 查询菜单列表
	 */
	List<SysMenuEntity> queryList(Map<String, Object> map);

	List<SysMenuEntity> querySonList(String menuId);
	
	/**
	 * 查询总数
	 */
	int queryTotal(Map<String, Object> map);
	
	/**
	 * 保存菜单
	 */
	SysMenuEntity save(SysMenuEntity menu);
	
	/**
	 * 修改
	 */
	void update(SysMenuEntity menu);
	
	/**
	 * 删除
	 */
	void delete(String menuId);
	
	/**
	 * 查询用户的权限列表
	 */
	List<SysMenuEntity> queryUserList(String userId);

	String queryParentIdIsCorrent(SysMenuEntity entity);

}
