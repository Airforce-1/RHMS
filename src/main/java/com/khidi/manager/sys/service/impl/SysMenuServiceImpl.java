package com.khidi.manager.sys.service.impl;

import com.khidi.manager.sys.dao.SysMenuDao;
import com.khidi.manager.sys.dao.SysRoleMenuDao;
import com.khidi.manager.sys.dao.SysUserRoleDao;
import com.khidi.manager.sys.entity.SysAreaEntity;
import com.khidi.manager.sys.entity.SysUserRoleEntity;
import com.khidi.manager.sys.service.SysMenuService;
import com.khidi.common.utils.Constant;
import com.khidi.common.utils.Constant.MenuType;
import com.khidi.manager.sys.entity.SysMenuEntity;
import com.khidi.manager.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysUserService sysUserService;
	@Override
	public List<SysMenuEntity> queryListParentId(String parentId, List<String> menuIdList) {
		List<SysMenuEntity> menuList = queryListParentId(parentId);
		if(menuIdList == null){
			return menuList;
		}
		List<SysMenuEntity> userMenuList = new ArrayList<>();
		for(SysMenuEntity menu : menuList){
			if(menuIdList.contains(menu.getMenuId())){
				userMenuList.add(menu);
			}
		}
		return userMenuList;
	}

	@Override
	public List<SysMenuEntity> queryListParentId(String parentId) {
		List<SysMenuEntity> menuList= sysMenuDao.queryListParentId(parentId);
		for(int i=0;i<menuList.size();i++) {
			if(queryListParentId(menuList.get(i).getMenuId()).size() > 0){
				menuList.get(i).setOpen(true);
			}else{
				menuList.get(i).setOpen(false);
			}
		}
		return menuList;
	}

	@Override
	public List<SysMenuEntity> queryNotButtonList() {
		return sysMenuDao.queryNotButtonList();
	}

	@Override
	public String queryParentIdIsCorrent(SysMenuEntity entity){
		return sysMenuDao.queryParentIdIsCorrent(entity);
	}


	@Override
	public List<SysMenuEntity> getUserMenuList(String userId) {

		//系统管理员，拥有最高权限
		if(userId.equals(Constant.SUPER_ADMIN)){
			List<SysMenuEntity> menuList = getAllMenuList(null);
			return menuList;
		}else{
			List<String> menuIdList = sysUserService.queryAllMenuId(userId);
			return getAllMenuList(menuIdList);
		}
	}
	
	@Override
	public SysMenuEntity queryObject(String menuId) {
		return sysMenuDao.queryObject(menuId);
	}

	@Override
	public List<SysMenuEntity> queryList(Map<String, Object> map) {
		List<SysMenuEntity> list = sysMenuDao.queryList(map);
		for(int i=0;i<list.size();i++) {
			list.get(i).setOpen(list.get(i).getParent());
		}
		return list;
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysMenuDao.queryTotal(map);
	}

	@Override
	public SysMenuEntity save(SysMenuEntity menu) {
		menu.setMenuId(UUID.randomUUID().toString());
		sysMenuDao.save(menu);
		return menu;
	}

	@Override
	public void update(SysMenuEntity menu) {
		sysMenuDao.update(menu);
	}

	@Override
	@Transactional
	public void delete(String menuId) {
		sysMenuDao.delete(menuId);
	}
	
	@Override
	public List<SysMenuEntity> queryUserList(String userId) {
		return sysMenuDao.queryUserList(userId);
	}


	@Override
	public List<SysMenuEntity> querySonList(String menuId){
		List<SysMenuEntity> resultList= sysMenuDao.querySonList(menuId);
		resultList.remove(sysMenuDao.queryObject(menuId));
		for(int i=0;i<resultList.size();i++) {
			resultList.get(i).setOpen(resultList.get(i).getParent());
		}
		return resultList;
	}





	/**
	 * 获取所有菜单列表
	 */
	private List<SysMenuEntity> getAllMenuList(List<String> menuIdList){
		//查询根菜单列表
		List<SysMenuEntity> menuList = queryListParentId("0", menuIdList);
		//递归获取子菜单
		getMenuTreeList(menuList, menuIdList);
		return menuList;
	}

	/**
	 * 递归
	 */
	private List<SysMenuEntity> getMenuTreeList(List<SysMenuEntity> menuList, List<String> menuIdList){
		List<SysMenuEntity> subMenuList = new ArrayList<SysMenuEntity>();
		for(SysMenuEntity entity : menuList){
			if(entity.getType().equals(MenuType.CATALOG.getValue())){//目录
				entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
			}
			subMenuList.add(entity);
		}
		return subMenuList;
	}
}
