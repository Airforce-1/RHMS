package com.khidi.manager.socialparticipation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.socialparticipation.dao.AppmenuDao;
import com.khidi.manager.socialparticipation.entity.AppmenuEntity;
import com.khidi.manager.socialparticipation.service.AppmenuService;



@Service("appmenuService")
public class AppmenuServiceImpl implements AppmenuService {
	@Autowired
	private AppmenuDao appmenuDao;
	
	@Override
	public AppmenuEntity queryObject(String id){
		return appmenuDao.queryObject(id);
	}
	
	@Override
	public List<AppmenuEntity> queryList(Map<String, Object> map){
	    return appmenuDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return appmenuDao.queryTotal(map);
	}
	
	@Override
	public void save(AppmenuEntity appmenu){
		appmenuDao.save(appmenu);
	}
	
	@Override
	public void update(AppmenuEntity appmenu){
		appmenuDao.update(appmenu);
	}
	
	@Override
	public void delete(String id){
		appmenuDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.khidi.manager.socialparticipation.service.AppmenuService#querySonMenusCounts(java.lang.String)
	 */
	@Override
	public int querySonMenusCounts(String parentid) {
		// TODO Auto-generated method stub
		return appmenuDao.querySonMenusCounts(parentid);
	}

	/* (non-Javadoc)
	 * @see com.khidi.manager.socialparticipation.service.AppmenuService#queryAll()
	 */
	@Override
	public List<AppmenuEntity> queryAll() {
		// TODO Auto-generated method stub
		return appmenuDao.queryAll();
	}

	/* (non-Javadoc)
	 * @see com.khidi.manager.socialparticipation.service.AppmenuService#queryChildren(com.khidi.manager.socialparticipation.entity.AppmenuEntity)
	 */
	@Override
	public List<AppmenuEntity> queryChildren(String id) {
		// TODO Auto-generated method stub
		return appmenuDao.queryChildren(id);
	}

	/* (non-Javadoc)
	 * @see com.khidi.manager.socialparticipation.service.AppmenuService#queryList0(java.util.Map)
	 */
	@Override
	public List<AppmenuEntity> queryList0(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return appmenuDao.queryList0(map);
	}
}
