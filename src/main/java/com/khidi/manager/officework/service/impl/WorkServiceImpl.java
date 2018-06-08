package com.khidi.manager.officework.service.impl;


import com.khidi.manager.officework.dao.WorkDao;
import com.khidi.manager.officework.service.WorkService;
import com.khidi.manager.officework.vo.UserVO;
import com.khidi.manager.sys.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("workService")
public class WorkServiceImpl implements WorkService{
    @Autowired
    private WorkDao workDao;
    @Override
    public List<UserVO> UserListByRoleLevel(String level){
        return workDao.UserListByRoleLevel(level);
    }
    @Override
    public List<UserVO> UserListByDeptLevel(String level){
        return workDao.UserListByDeptLevel(level);
    }
}
