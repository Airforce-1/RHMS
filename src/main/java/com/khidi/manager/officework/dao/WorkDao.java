package com.khidi.manager.officework.dao;

import com.khidi.manager.basicinfo.entity.ResourceWaterabilityEntity;
import com.khidi.manager.officework.vo.UserVO;
import com.khidi.manager.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/12/11.
 */


@Mapper
public interface WorkDao extends BaseDao<ResourceWaterabilityEntity> {
    List<UserVO> UserListByRoleLevel(String level);
    List<UserVO> UserListByDeptLevel(String level);

}


