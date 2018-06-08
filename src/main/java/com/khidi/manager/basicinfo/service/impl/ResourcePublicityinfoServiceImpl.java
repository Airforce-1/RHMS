package com.khidi.manager.basicinfo.service.impl;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.basicinfo.dao.*;
import com.khidi.manager.basicinfo.entity.ResourcePublicitycardEntity;
import com.khidi.manager.basicinfo.entity.ResourcePublicityinfoEntity;
import com.khidi.manager.basicinfo.service.ResourcePublicitycardService;
import com.khidi.manager.basicinfo.service.ResourcePublicityinfoService;
import com.khidi.manager.sys.dao.FileuploadDao;
import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.dao.SysDictDao;
import com.khidi.manager.sys.dao.SysRoleDao;
import com.khidi.manager.sys.entity.FileUploadEntity;
import com.khidi.manager.sys.entity.SysRoleEntity;
import com.khidi.manager.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service("resourcePublicityinfoService")
public class ResourcePublicityinfoServiceImpl implements ResourcePublicityinfoService {
	@Autowired
	private ResourcePublicityinfoDao resourcePublicityinfoDao;
	@Autowired
	private SysRoleDao sysRoleDao;


	@Override
	public ResourcePublicityinfoEntity queryObject(String id){

		ResourcePublicityinfoEntity entity =resourcePublicityinfoDao.queryObject(id);
		if(entity.getResourcetype().equals("1")){
			entity.setResourcetype("河流");
		}else if(entity.getResourcetype().equals("2")){
			entity.setResourcetype("河段");
		}else if(entity.getResourcetype().equals("3")){
			entity.setResourcetype("渠道");
		}else if(entity.getResourcetype().equals("4")){
			entity.setResourcetype("渠段");
		}else if(entity.getResourcetype().equals("5")){
			entity.setResourcetype("湖泊");
		}else if(entity.getResourcetype().equals("6")){
			entity.setResourcetype("湖段");
		}else if(entity.getResourcetype().equals("7")){
			entity.setResourcetype("水库");
		}else if(entity.getResourcetype().equals("8")){
			entity.setResourcetype("库段");
		}
		if(entity.getHeaderpost() != null){
			SysRoleEntity sysRoleEntity = sysRoleDao.queryObject(entity.getHeaderpost());
			if(sysRoleEntity.getRoleLevel() == 1){
				entity.setHeaderpost("市级河长");
			}else if(sysRoleEntity.getRoleLevel() == 2){
				entity.setHeaderpost("区县级河长");
			}else if(sysRoleEntity.getRoleLevel() == 3){
				entity.setHeaderpost("乡镇级河长");
			}else if(sysRoleEntity.getRoleLevel() == 4){
				entity.setHeaderpost("村级河长");
			}else if(sysRoleEntity.getRoleLevel() == 5){
				entity.setHeaderpost("组级级河长");
			}
		}
		return entity;
	}









	@Override
	public List<ResourcePublicityinfoEntity> queryList(Map<String, Object> map){
		List<ResourcePublicityinfoEntity> list = resourcePublicityinfoDao.queryList(map);
		for(ResourcePublicityinfoEntity entity : list){
			if(entity.getResourcetype().equals("1")){
				entity.setResourcetype("河流");
			}else if(entity.getResourcetype().equals("2")){
				entity.setResourcetype("河段");
			}else if(entity.getResourcetype().equals("3")){
				entity.setResourcetype("渠道");
			}else if(entity.getResourcetype().equals("4")){
				entity.setResourcetype("渠段");
			}else if(entity.getResourcetype().equals("5")){
				entity.setResourcetype("湖泊");
			}else if(entity.getResourcetype().equals("6")){
				entity.setResourcetype("湖段");
			}else if(entity.getResourcetype().equals("7")){
				entity.setResourcetype("水库");
			}else if(entity.getResourcetype().equals("8")){
				entity.setResourcetype("库段");
			}
			if(entity.getHeaderpost() != null){
				SysRoleEntity sysRoleEntity = sysRoleDao.queryObject(entity.getHeaderpost());
				if(sysRoleEntity.getRoleLevel() == 1){
					entity.setHeaderpost("市级河长");
				}else if(sysRoleEntity.getRoleLevel() == 2){
					entity.setHeaderpost("区县级河长");
				}else if(sysRoleEntity.getRoleLevel() == 3){
					entity.setHeaderpost("乡镇级河长");
				}else if(sysRoleEntity.getRoleLevel() == 4){
					entity.setHeaderpost("村级河长");
				}else if(sysRoleEntity.getRoleLevel() == 5){
					entity.setHeaderpost("组级级河长");
				}
			}
		}
		return list;
	}

	@Override
	public int queryTotal(Map<String, Object> map){
		return resourcePublicityinfoDao.queryTotal(map);
	}
}
