package com.khidi.manager.sys.service.impl;

import com.khidi.manager.sys.dao.*;
import com.khidi.manager.sys.entity.SysUserTokenEntity;
import com.khidi.common.utils.Constant;
import com.khidi.manager.sys.entity.SysMenuEntity;
import com.khidi.manager.sys.entity.SysUserEntity;
import com.khidi.manager.sys.service.ShiroService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserTokenDao sysUserTokenDao;
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;



//    @Override
//    public Set<String> getUserPermissions(String userId) {
//        List<String> permsList = new ArrayList<>();
//        List<String> roleList = new ArrayList<>();
//        List<String> menuIdList = new ArrayList<>();
//
////        系统管理员，拥有最高权限
//        if(userId.equals(Constant.SUPER_ADMIN)){
//            List<SysMenuEntity> menuList = sysMenuDao.queryList(new HashMap<>());
//            permsList = new ArrayList<>(menuList.size());
//            for(SysMenuEntity menu : menuList){
//                permsList.add(menu.getPerms());
//            }
//        }else{
//
//            //根据传入的userId进行查询对应角色列表
//            Map<String, Object> querymap1= new HashMap<>();
//            querymap1.put("user_id",userId);
////            List<SysUserRoleAreaResourceEntity> rolearearesourcelist =sysUserRoleAreaResourceDao.queryList(querymap1);
////            for(int i = 0; i < rolearearesourcelist.size();i++){
////                //获取职务（角色）行政区划资源--》并获取角色id
////                roleList.add(sysRoleAreaResourceDao.queryObject(rolearearesourcelist.get(i).getRoleAreaResourceId()).getRoleId());
////            }
//
//            for(int i= 0;i < roleList.size();i++){
//                menuIdList.addAll(sysRoleMenuDao.queryMenuIdList(roleList.get(i)));
//            }
//
//            for(int i= 0;i< menuIdList.size();i++){
//                permsList.add(sysMenuDao.queryObject(menuIdList.get(i)).getPerms());
//            }
//
////            permsList = sysUserDao.queryAllPerms(userId);
//        }
//        //用户权限列表
//        Set<String> permsSet = new HashSet<>();
//        for(String perms : permsList){
//            if(StringUtils.isBlank(perms)){
//                continue;
//            }
//            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
//        }
//        return permsSet;
//    }










    @Override
    public Set<String> getUserPermissions(String userId) {
        List<String> permsList;

        //系统管理员，拥有最高权限
        if(userId.equals(Constant.SUPER_ADMIN)){
            List<SysMenuEntity> menuList = sysMenuDao.queryList(new HashMap<>());
            permsList = new ArrayList<>(menuList.size());
            for(SysMenuEntity menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            permsList = sysUserDao.queryAllPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }





































    @Override
    public SysUserTokenEntity queryByToken(String token) {
        return sysUserTokenDao.queryByToken(token);
    }

    @Override
    public SysUserEntity queryUser(String userId) {
        return sysUserDao.queryObject(userId);
    }
}
