package com.khidi.manager.officework.service;

import com.khidi.manager.officework.vo.UserVO;
import com.khidi.manager.sys.entity.SysUserEntity;

import java.util.List;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
public interface WorkService {
	List<UserVO> UserListByRoleLevel(String level);
	List<UserVO> UserListByDeptLevel(String level);
}
