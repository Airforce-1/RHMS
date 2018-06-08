package com.khidi.manager.socialparticipation.dao;

import com.khidi.manager.socialparticipation.entity.AppnewsEntity;
import com.khidi.manager.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-08 15:16:20
 */
@Mapper
public interface AppnewsDao extends BaseDao<AppnewsEntity> {
	void updateState(AppnewsEntity appnews);
}
