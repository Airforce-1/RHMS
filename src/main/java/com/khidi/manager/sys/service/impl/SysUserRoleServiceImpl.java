package com.khidi.manager.sys.service.impl;

import com.khidi.manager.sys.dao.SysUserRoleDao;
import com.khidi.manager.sys.entity.SysUserRoleEntity;
import com.khidi.manager.sys.service.SysUserRoleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * 用户与角色对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:45:48
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {
	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	@Override
	public void saveOrUpdate(String userId, String roleIdList) {
//		if(roleIdList.equals(null)){
//			return ;
//		}
		
		//先删除用户与角色关系
//		sysUserRoleDao.delete(userId);
		
//		//保存用户与角色关系
//		String[] strings = roleIdList.split(",");
//		for (int i = 0; i < strings.length; i++) {
//			Map<String, Object> map = new HashMap<>();
//			map.put("userId", userId);
//			map.put("roleId", strings[i]);
//			map.put("id", UUID.randomUUID().toString());
//			sysUserRoleDao.save(map);
//		}

	}


	@Override
	public void save(SysUserRoleEntity sysUserRoleEntity){
		sysUserRoleEntity.setId(UUID.randomUUID().toString());
		sysUserRoleDao.save(sysUserRoleEntity);
	}

	@Override
	public List<String> queryRoleIdList(String userId) {
		return sysUserRoleDao.queryRoleIdList(userId);
	}


	@Override
	public List<SysUserRoleEntity> queryListforUser(Map<String, Object> map){
		return sysUserRoleDao.queryListforUser(map);
	}

	@Override
	public void delete(String userId) {
		sysUserRoleDao.delete(userId);
	}


	@Override
	public void  delUserRole(SysUserRoleEntity sysUserRoleEntity){
		Map<String,Object> map = new HashMap();
		map.put("roleId",sysUserRoleEntity.getRoleId());
		map.put("userId",sysUserRoleEntity.getUserId());
		sysUserRoleDao.delete(sysUserRoleDao.queryObject(map).getId());
	}
}
