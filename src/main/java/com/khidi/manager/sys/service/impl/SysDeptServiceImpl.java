package com.khidi.manager.sys.service.impl;

import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.dao.SysDeptDao;
import com.khidi.manager.sys.service.SysDeptService;
import com.qiniu.util.StringUtils;
import com.khidi.manager.sys.entity.SysDeptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service("sysDeptService")
public class SysDeptServiceImpl implements SysDeptService {
	@Autowired
	private SysDeptDao sysDeptDao;
	@Autowired
	private SysAreaDao sysAreaDao;
	
	@Override
	public SysDeptEntity queryObject(String deptId){
		return sysDeptDao.queryObject(deptId);
	}

	@Override
	public String queryParentIdIsCorrent(SysDeptEntity entity){
		return sysDeptDao.queryParentIdIsCorrent(entity);
	}
	
	@Override
	public List<SysDeptEntity> queryList(Map<String, Object> map){
		List<SysDeptEntity> list = sysDeptDao.queryList(map);
		for(int i=0;i<list.size();i++) {
			if(queryDetpIdList(list.get(i).getDeptId()).size() > 0){
				list.get(i).setOpen(true);
			}else{
				list.get(i).setOpen(false);
			}
			list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());
		}
		return list;
	}
	
	@Override
	public void save(SysDeptEntity sysDept){
		sysDept.setDeptId(UUID.randomUUID().toString());
		sysDept.setDelFlag(0);
		sysDeptDao.save(sysDept);
	}
	
	@Override
	public void update(SysDeptEntity sysDept){
		sysDeptDao.update(sysDept);
	}
	
	@Override
	public void delete(String deptId){
		sysDeptDao.delete(deptId);
	}

	@Override
	public List<String> queryDetpIdList(String parentId) {
		return sysDeptDao.queryDetpIdList(parentId);
	}

	@Override
	public String getSubDeptIdList(String deptId){
		//部门及子部门ID列表
		List<String> deptIdList = new ArrayList<>();

		//获取子部门ID
		List<String> subIdList = queryDetpIdList(deptId);
		getDeptTreeList(subIdList, deptIdList);

		//添加本部门
		deptIdList.add(deptId);

		String deptFilter = StringUtils.join(deptIdList, ",");
		return deptFilter;
	}

	/**
	 * 递归
	 */
	public void getDeptTreeList(List<String> subIdList, List<String> deptIdList){
		for(String deptId : subIdList){
			List<String> list = queryDetpIdList(deptId);
			if(list.size() > 0){
				getDeptTreeList(list, deptIdList);
			}

			deptIdList.add(deptId);
		}
	}
}
