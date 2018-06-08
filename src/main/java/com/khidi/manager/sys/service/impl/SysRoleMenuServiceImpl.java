package com.khidi.manager.sys.service.impl;

import com.khidi.manager.sys.entity.SysRoleMenuEntity;
import com.khidi.manager.sys.service.SysRoleMenuService;
import com.khidi.manager.sys.dao.SysRoleMenuDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * 角色与菜单对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:44:35
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;

	@Override
	@Transactional
	public void saveOrUpdate(SysRoleMenuEntity sysRoleMenuEntity) {
		//保存角色与菜单关系
		sysRoleMenuEntity.setId(UUID.randomUUID().toString());
		sysRoleMenuDao.save(sysRoleMenuEntity);
	}

	@Override
	public List<String> queryMenuIdList(String roleId) {
		return sysRoleMenuDao.queryMenuIdList(roleId);
	}
	@Override
	public void delete(String roleId){
		sysRoleMenuDao.delete(roleId);
	}

}
