/**   
* @Title: WfCurrentSession.java 
* @Package com.khidi.manager.hbm.enginext.cfg 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月22日 上午8:54:12 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.enginext.cfg;

import java.util.List;

import org.apache.shiro.SecurityUtils;

import com.khidi.manager.sys.entity.SysUserEntity;
import com.khidi.manager.sys.service.impl.SysUserRoleServiceImpl;

/**
 * @author Administrator
 *
 */
public class WfCurrentSession {
	public static String GetUserId() {
		SysUserEntity curUser = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
		//
		return curUser.getUserId();
	}

	public static String GetUserName() {
		SysUserEntity curUser = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
		//
		return curUser.getUsername(); 
	}

	public static String GetDeptId() {
		SysUserEntity curUser = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
		//
		return curUser.getDeptId();
	}

	public static String GetDeptName() {
		SysUserEntity curUser = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
		//
		return curUser.getDeptName();
	}
	
	public static List<String> GetUserRoles()
	{
		SysUserRoleServiceImpl surService = new SysUserRoleServiceImpl();
		//
		SysUserEntity curUser = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
		//
		return surService.queryRoleIdList(curUser.getUserId());		
	}
}
