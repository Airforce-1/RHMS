package com.khidi.common.utils;

import com.khidi.manager.sys.entity.SysUserEntity;
import com.khidi.manager.sys.service.impl.SysUserRoleServiceImpl;
import org.apache.shiro.SecurityUtils;

import java.util.List;

/**
 * Created by admin on 2018/1/15.
 */
public class CurrentSession {
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
