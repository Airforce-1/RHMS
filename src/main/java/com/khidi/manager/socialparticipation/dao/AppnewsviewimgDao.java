package com.khidi.manager.socialparticipation.dao;

import com.khidi.manager.socialparticipation.entity.AppnewsviewimgEntity;
import com.khidi.manager.sys.dao.BaseDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * ${comments}
 * 
 * @author JerryWang
 * @email 405877884@qq.com
 * @date 2017-12-25 13:40:37
 */
@Mapper
public interface AppnewsviewimgDao extends BaseDao<AppnewsviewimgEntity> {
	List<AppnewsviewimgEntity> getAttachByNewsId(String newsId);
}
