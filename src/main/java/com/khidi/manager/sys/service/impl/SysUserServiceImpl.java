package com.khidi.manager.sys.service.impl;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.dao.SysDeptDao;
import com.khidi.manager.sys.dao.SysUserDao;
import com.khidi.manager.sys.dao.SysUserRoleDao;
import com.khidi.manager.sys.entity.SysUserRoleEntity;
import com.khidi.manager.sys.service.SysRoleService;
import com.khidi.manager.sys.entity.SysUserEntity;
import com.khidi.manager.sys.service.SysUserRoleService;
import com.khidi.manager.sys.service.SysUserService;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:46:09
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysAreaDao sysAreaDao;
	@Autowired
	private SysDeptDao sysDeptDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	@Override
	public List<String> queryAllPerms(String userId) {
		return sysUserDao.queryAllPerms(userId);
	}

	@Override
	public List<String> queryAllMenuId(String userId) {
		return sysUserDao.queryAllMenuId(userId);
	}

	@Override
	public SysUserEntity queryByUserName(String username) {
		return sysUserDao.queryByUserName(username);
	}
	
	@Override
	public SysUserEntity queryObject(String userId) {
		return sysUserDao.queryObject(userId);
	}

	@Override
	public List<SysUserEntity> queryList(Map<String, Object> map){
		List<SysUserEntity> list = sysUserDao.queryList(map);
		for(int i=0;i<list.size();i++){
			if(StringUtil.isEmpty(list.get(i).getAreaId())){
				list.get(i).setAreaName(null);
			}else{
				list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());
			}


			if(StringUtil.isEmpty(list.get(i).getDeptId())){
				list.get(i).setDeptName(null);
			}else{
				list.get(i).setDeptName(sysDeptDao.queryObject(list.get(i).getDeptId()).getName());
			}
		}
	return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysUserDao.queryTotal(map);
	}

	@Override
	@Transactional
	public void save(SysUserEntity user) {
		user.setUserId(UUID.randomUUID().toString());
		//sha256加密
		String salt = RandomStringUtils.randomAlphanumeric(20);
		user.setPassword(new Sha256Hash(user.getPassword(), salt).toHex());
		user.setSalt(salt);
		sysUserDao.save(user);
		
		//保存用户与角色关系

		//保存用户与角色关系
		List<String> roleList = StringUtil.arrays2List(user.getRoleIdList());
		for(String roleId:roleList){
			SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
			sysUserRoleEntity.setId(UUID.randomUUID().toString());
			sysUserRoleEntity.setUserId(user.getUserId());
			sysUserRoleEntity.setRoleId(roleId);
			sysUserRoleDao.save(sysUserRoleEntity);
		}
	}

	@Override
	@Transactional
	public void update(SysUserEntity user) {
		if(StringUtils.isBlank(user.getPassword())){
			user.setPassword(null);
		}else{
			user.setPassword(new Sha256Hash(user.getPassword(), user.getSalt()).toHex());
		}
		sysUserDao.update(user);

		//保存用户与角色关系
		List<String> roleList = StringUtil.arrays2List(user.getRoleIdList());
		sysUserRoleDao.deletebyUserId(user.getUserId());
		for(String roleId:roleList){
			SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
			sysUserRoleEntity.setId(UUID.randomUUID().toString());
			sysUserRoleEntity.setUserId(user.getUserId());
			sysUserRoleEntity.setRoleId(roleId);
			sysUserRoleDao.save(sysUserRoleEntity);
		}

	}

	@Override
	@Transactional
	public void delete(String userId) {
		sysUserRoleDao.deletebyUserId(userId);
		sysUserDao.delete(userId);
	}

	@Override
	public int updatePassword(String userId, String password, String newPassword) {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("password", password);
		map.put("newPassword", newPassword);
		return sysUserDao.updatePassword(map);
	}


	@Override
	public List<SysUserEntity> getUserListByDeptId(String deptId){
		return sysUserDao.getUserListByDeptId(deptId);
	}


	@Override
	public List<SysUserEntity> queryUserList4RoleRelate(Map<String, Object> map){
		return sysUserDao.queryUserList4RoleRelate(map);
		}

	@Override
	public int queryTotal4RoleRelate(Map<String, Object> map){
		return sysUserDao.queryTotal4RoleRelate(map);
	}

}
