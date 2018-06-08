package com.khidi.manager.sys.service.impl;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.sys.dao.*;
import com.khidi.manager.sys.entity.SysMenuEntity;
import com.khidi.manager.sys.entity.SysRoleEntity;
import com.khidi.manager.sys.service.SysRoleDeptService;
import com.khidi.manager.sys.service.SysRoleMenuService;
import com.khidi.manager.sys.service.SysRoleService;
import com.khidi.manager.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * 角色
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:45:12
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysAreaDao sysAreaDao;
	@Autowired
	private SysDeptDao sysDeptDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;


	@Override
	public SysRoleEntity queryObject(String roleId) {
		SysRoleEntity entity = sysRoleDao.queryObject(roleId);
		if(queryRoleIdList(entity.getRoleId()).size() > 0){
			entity.setOpen(true);
		}else{
			entity.setOpen(false);
		}
		return entity;
	}

	@Override
	public List<SysRoleEntity> queryList(Map<String, Object> map) {
		List<SysRoleEntity> list = sysRoleDao.queryList(map);
		for(int i=0;i<list.size();i++) {
			list.get(i).setOpen(list.get(i).isParent());
		}
		return list;
	}



	@Override
	public List<SysRoleEntity> querySonList(String parentId) {
		List<SysRoleEntity> list = sysRoleDao.querySonList(parentId);
		for(int i=0;i<list.size();i++) {
			list.get(i).setOpen(list.get(i).isParent());
		}
		return list;
	}



	@Override
	public List<String> queryRoleIdList(String parentId) {
		return sysRoleDao.queryRoleIdList(parentId);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysRoleDao.queryTotal(map);
	}

	@Override
	@Transactional
	public void save(SysRoleEntity role) {
		role.setRoleId(UUID.randomUUID().toString());
		sysRoleDao.save(role);

		//保存角色与菜单关系
//		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());

		//保存角色与部门关系
//		sysRoleDeptService.saveOrUpdate(role.getRoleId(), role.getDeptIdList());
	}

	@Override
	@Transactional
	public void update(SysRoleEntity role) {
		sysRoleDao.update(role);
		
		//更新角色与菜单关系
//		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());

		//保存角色与部门关系
//		sysRoleDeptService.saveOrUpdate(role.getRoleId(), role.getDeptIdList());
	}
	@Override
	@Transactional
	public void delete(String roleId) {
		sysRoleDao.delete(roleId);         //删除角色
		sysRoleMenuDao.delete(roleId);     //删除角色菜单关联表中记录
		sysUserRoleDao.deletebyRoleId(roleId);     //删除角色用户关联表中记录
	}

	@Override
	public List<String> queryRoleList(String user_id){
		return sysRoleDao.queryRoleList(user_id);
	}



	@Override
	public String queryParentIdIsCorrent(SysRoleEntity entity){
		return sysRoleDao.queryParentIdIsCorrent(entity);
	}
}
