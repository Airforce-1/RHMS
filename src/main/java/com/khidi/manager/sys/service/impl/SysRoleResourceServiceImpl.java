package com.khidi.manager.sys.service.impl;

import com.khidi.common.utils.ListUtil;
import com.khidi.common.utils.R;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.basicinfo.entity.*;
import com.khidi.manager.basicinfo.service.*;
import com.khidi.manager.sys.dao.SysMenuDao;
import com.khidi.manager.sys.dao.SysRoleMenuDao;
import com.khidi.manager.sys.entity.SysAreaEntity;
import com.khidi.manager.sys.entity.SysMenuEntity;
import com.khidi.manager.sys.entity.SysRoleMenuEntity;
import com.khidi.manager.sys.service.SysAreaService;
import com.khidi.manager.sys.service.SysRoleMenuService;
import com.khidi.manager.sys.vo.RoleResourceIdsVO;
import com.khidi.manager.sys.vo.Vo4River;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.khidi.manager.sys.dao.SysRoleResourceDao;
import com.khidi.manager.sys.entity.SysRoleResourceEntity;
import com.khidi.manager.sys.service.SysRoleResourceService;



@Service("sysRoleResourceService")
public class SysRoleResourceServiceImpl implements SysRoleResourceService {
	@Autowired
	private SysRoleResourceDao sysRoleResourceDao;
	@Autowired
	private ResourceVideoService resourceVideoService;
	@Autowired
	private ResourceStationService resourceStationService;
	@Autowired
	private SysRoleResourceService sysRoleResourceService;
	@Autowired
	private RiverService riverService;
	@Autowired
	private LakeService lakeService;
	@Autowired
	private CanalService canalService;
	@Autowired
	private ReservoirService reservoirService;
	@Autowired
	private PartRiverService partRiverService;
	@Autowired
	private PartLakeService partLakeService;
	@Autowired
	private PartCanalService partCanalService;
	@Autowired
	private PartReservoirService partReservoirService;
	@Autowired
	private SysAreaService sysAreaService;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysMenuDao sysMenuDao;
	
	@Override
	public SysRoleResourceEntity queryObject(String id){
		return sysRoleResourceDao.queryObject(id);
	}
	
	@Override
	public List<SysRoleResourceEntity> queryList(Map<String, Object> map){
	    return sysRoleResourceDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysRoleResourceDao.queryTotal(map);
	}
	
	@Override
	public void save(SysRoleResourceEntity sysRoleResource){
		//判断当前是否有该角色资源，如果有，先删除再添加，如果没有，就保存
			sysRoleResourceDao.deleteByRoleId(sysRoleResource.getRoleId());
			sysRoleResource.setId(UUID.randomUUID().toString());
			sysRoleResourceDao.save(sysRoleResource);
	}
	
	@Override
	public void update(SysRoleResourceEntity sysRoleResource){
		sysRoleResourceDao.update(sysRoleResource);
	}
	
	@Override
	public void delete(String id){
		sysRoleResourceDao.delete(id);
	}

	@Override
	public SysMenuEntity menus(String roleId){
		SysMenuEntity sysMenuEntity =new SysMenuEntity();
		List<SysMenuEntity> menuList = sysMenuDao.queryList(new HashedMap());
		List<String> menuIdList = sysRoleMenuDao.queryMenuIdList(roleId);
		for(int i=0;i<menuList.size();i++){
			menuList.get(i).setStatus(false);
			for(int j=0;j<menuIdList.size();j++){
				if(menuList.get(i).getMenuId().equals(menuIdList.get(j))){
					menuList.get(i).setStatus(true);
				}
			}
		}
		sysMenuEntity.setList(menuList);
		return sysMenuEntity;
	}

	/**
	 *返回角色监测站资源
	 * @param inmap
	 * @return List<RoleResourceIdsVO>
	 */
	@Override
	public List<RoleResourceIdsVO> stations(Map<String,Object> inmap){
		String resourceType = "";
		String resourceName = "";
		if(StringUtil.isNotEmpty(inmap.get("resourceType").toString())){
			resourceType = inmap.get("resourceType").toString();
		}
		if(StringUtil.isNotEmpty(inmap.get("resourceName").toString())){
			resourceName = inmap.get("resourceName").toString();
		}
		String roleId = inmap.get("roleId").toString();
		//新建一个提供返回的list
		List<RoleResourceIdsVO> resultList = new ArrayList<>();
		//查询到所有视频监测站
		List<ResourceVideoEntity> videoStaionList = resourceVideoService.queryList(new HashedMap());
		//查询所有的水质监测站
		Map<String,Object> shuizhimap = new HashedMap();
		shuizhimap.put("stationType","1");
		List<ResourceStationEntity> riverszStationList = resourceStationService.queryList(shuizhimap);//水质监测站1
		//查询所有水文监测站
		Map<String,Object> shuiwenmap = new HashedMap();
		shuiwenmap.put("stationType","2");
		List<ResourceStationEntity> riverswStationList = resourceStationService.queryList(shuiwenmap);//水文监测站2
		//遍历所有视频监测站加载到resultlist
		for(ResourceVideoEntity entity:videoStaionList){
			RoleResourceIdsVO vo = new RoleResourceIdsVO();
			vo.setAreaName(entity.getAreaName());
			vo.setRoleId(roleId);
			vo.setResourceIds(entity.getId());
			vo.setResourceName(entity.getName());
			vo.setResourceType("视频监测站");
			resultList.add(vo);
		}
		//遍历所有水质监测站加载到resultlist
		for(ResourceStationEntity entity:riverszStationList){
			RoleResourceIdsVO vo = new RoleResourceIdsVO();
			vo.setAreaName(entity.getAreaName());
			vo.setRoleId(roleId);
			vo.setResourceIds(entity.getId());
			vo.setResourceName(entity.getName());
			vo.setResourceType("水质监测站");
			resultList.add(vo);
		}
		//遍历所有水文监测站加载到resultlist
		for(ResourceStationEntity entity:riverswStationList){
			RoleResourceIdsVO vo = new RoleResourceIdsVO();
			vo.setAreaName(entity.getAreaName());
			vo.setRoleId(roleId);
			vo.setResourceIds(entity.getId());
			vo.setResourceName(entity.getName());
			vo.setResourceType("水文监测站");
			resultList.add(vo);
		}
		//根据stationType和stationName对result进行过滤查询
		if(StringUtils.isNotEmpty(resourceType)) {
			if (resourceType.equals("1")) {
				resourceType = "水质监测站";
			} else if (resourceType.equals("2")) {
				resourceType = "水文监测站";
			} else if (resourceType.equals("3")) {
				resourceType = "视频监测站";
			}
		}

		if(StringUtils.isNotEmpty(resourceType)){
			Iterator<RoleResourceIdsVO> it =  resultList.iterator();
			while(it.hasNext()){
				RoleResourceIdsVO obj = it.next();
				if(!obj.getResourceType().equals(resourceType)){
					it.remove();
				}
			}
		}
		if(StringUtils.isNotEmpty(resourceName)){
			Iterator<RoleResourceIdsVO> it =  resultList.iterator();
			while(it.hasNext()){
				RoleResourceIdsVO obj = it.next();
				if(!obj.getResourceName().contains(resourceName)){
					it.remove();
				}
			}
		}
		//查找到该角色对应的监测站权限
		SysRoleResourceEntity sysRoleResourceEntity = sysRoleResourceDao.queryObjectByRoleId(roleId);
		//判断拥有的监测站个数的大小，如果为0，返回resultlist，并将status置为flase，不为0.则将拥有的权限置为true
		if(sysRoleResourceEntity != null){
			List videoStationIds = StringUtil.arrays2List(sysRoleResourceEntity.getVideostationids());
			List riverStationIds = StringUtil.arrays2List(sysRoleResourceEntity.getRiverstationids());

			for(int i=0;i<resultList.size();i++){
				resultList.get(i).setStatus(false);
				for(int j=0;j<videoStationIds.size();j++){
					if(videoStationIds.get(j).equals(resultList.get(i).getResourceIds())){
						resultList.get(i).setStatus(true);
					}
				}
				for(int k=0;k<riverStationIds.size();k++){
					if(riverStationIds.get(k).equals(resultList.get(i).getResourceIds())){
						resultList.get(i).setStatus(true);
					}
				}
			}
			return resultList;
		}else{
			for(int i=0;i<resultList.size();i++){
				resultList.get(i).setStatus(false);
			}
			return resultList;
		}
	}



	public List<RoleResourceIdsVO> permstations(String roleId){
		Map<String,Object> map = new HashedMap();
		map.put("roleId",roleId);
		map.put("resourceType","");
		map.put("resourceName","");
		List<RoleResourceIdsVO> list = this.stations(map);
		Iterator<RoleResourceIdsVO> it =  list.iterator();
		while(it.hasNext()){
			RoleResourceIdsVO obj = it.next();
			if(!obj.isStatus()){
				it.remove();
			}
		}
		return list;
	}




	/**
	 *返回角色河流资源
	 * @param roleId
	 * @param parentId
	 * @return
	 */
	@Override
	public Vo4River rivers(String roleId,String parentId) {
		Vo4River vo4River = new Vo4River();
		List<Vo4River> resultList = new ArrayList<>();
		List<RiverEntity> riverList = riverService.queryList(new HashedMap());
		Iterator<RiverEntity> it = riverList.iterator();
		Map<String,Object> queryMap = new HashedMap();
		while (it.hasNext()) {
			Vo4River vo =new Vo4River();
			RiverEntity obj = it.next();
			vo.setRoleId(roleId);
			vo.setId(obj.getId());
			vo.setType("河流");
			vo.setAreaName(obj.getAreaName());
			vo.setName(obj.getName());
			vo.setParentId("0");
			queryMap.put("riverId",obj.getId());
			List<PartRiverEntity> partRiverList= partRiverService.queryList(queryMap);
			if(partRiverList.size() > 0 ){
				vo.setOpen(true);
			}else{
				vo.setOpen(false);
			}
			Iterator<PartRiverEntity> partit = partRiverList.iterator();
			while(partit.hasNext()){
				PartRiverEntity partRiverEntity = partit.next();
				Vo4River partvo =new Vo4River();
				partvo.setRoleId(roleId);
				partvo.setAreaName(partRiverEntity.getAreaName());
				partvo.setName(partRiverEntity.getName());
				partvo.setType("河段");
				partvo.setId(partRiverEntity.getId());
				partvo.setParentId(partRiverEntity.getRiverId());
				partvo.setOpen(false);
				resultList.add(partvo);
			}
			resultList.add(vo);
		}
		//查找到该角色对应的河流权限
		Map<String,Object> map = new HashedMap();
		map.put("roleId",roleId);
		List<SysRoleResourceEntity> list = sysRoleResourceService.queryList(map);
		//判断拥有的河流个数的大小，如果为0，返回resultlist，并将status置为flase，不为0.则将拥有的权限置为true
		if(list.size() != 0) {
			SysRoleResourceEntity sysRoleResourceEntity = list.get(0);
			List riverIds = StringUtil.arrays2List(sysRoleResourceEntity.getRiverids());
			List partRiverIds = StringUtil.arrays2List(sysRoleResourceEntity.getPartriverids());
			for (int i = 0; i < resultList.size(); i++) {
				resultList.get(i).setStatus(false);
				for (int j = 0; j < riverIds.size(); j++) {
					if (riverIds.get(j).equals(resultList.get(i).getId())) {
						resultList.get(i).setStatus(true);
					}
				}
				for (int j = 0; j < partRiverIds.size(); j++) {
					if (partRiverIds.get(j).equals(resultList.get(i).getId())) {
						resultList.get(i).setStatus(true);
					}
				}
			}

		}
			vo4River.setList(resultList);
			return vo4River;
	}
	/**
	 *返回角色渠道资源
	 * @param roleId
	 * @param parentId
	 * @return
	 */
	@Override
	public Vo4River canals(String roleId,String parentId) {
		Vo4River vo4River = new Vo4River();
		List<Vo4River> resultList = new ArrayList<>();
		List<CanalEntity> canalList = canalService.queryList(new HashedMap());
		Iterator<CanalEntity> it = canalList.iterator();
		Map<String,Object> queryMap = new HashedMap();
		while (it.hasNext()) {
			Vo4River vo =new Vo4River();
			CanalEntity obj = it.next();
			vo.setRoleId(roleId);
			vo.setId(obj.getId());
			vo.setType("渠道");
			vo.setAreaName(obj.getAreaName());
			vo.setName(obj.getName());
			vo.setParentId("0");
			queryMap.put("canalId",obj.getId());
			List<PartCanalEntity> partCanalList= partCanalService.queryList(queryMap);
			if(partCanalList.size() > 0 ){
				vo.setOpen(true);
			}else{
				vo.setOpen(false);
			}
			Iterator<PartCanalEntity> partit = partCanalList.iterator();
			while(partit.hasNext()){
				PartCanalEntity partCanalEntity = partit.next();
				Vo4River partvo =new Vo4River();
				partvo.setRoleId(roleId);
				partvo.setAreaName(partCanalEntity.getAreaName());
				partvo.setName(partCanalEntity.getName());
				partvo.setType("渠段");
				partvo.setId(partCanalEntity.getId());
				partvo.setParentId(partCanalEntity.getCanalId());
				partvo.setOpen(false);
				resultList.add(partvo);
			}
			resultList.add(vo);
		}
		//查找到该角色对应的河流权限
		Map<String,Object> map = new HashedMap();
		map.put("roleId",roleId);
		List<SysRoleResourceEntity> list = sysRoleResourceService.queryList(map);
		//判断拥有的河流个数的大小，如果为0，返回resultlist，并将status置为flase，不为0.则将拥有的权限置为true
		if(list.size() != 0) {
			SysRoleResourceEntity sysRoleResourceEntity = list.get(0);
			List canalIds = StringUtil.arrays2List(sysRoleResourceEntity.getCanalids());
			List partCanalIds = StringUtil.arrays2List(sysRoleResourceEntity.getPartcanalids());
			for (int i = 0; i < resultList.size(); i++) {
				resultList.get(i).setStatus(false);
				for (int j = 0; j < canalIds.size(); j++) {
					if (canalIds.get(j).equals(resultList.get(i).getId())) {
						resultList.get(i).setStatus(true);
					}
				}
				for (int j = 0; j < partCanalIds.size(); j++) {
					if (partCanalIds.get(j).equals(resultList.get(i).getId())) {
						resultList.get(i).setStatus(true);
					}
				}

			}

		}
		vo4River.setList(resultList);
		return vo4River;
	}

	/**
	 *返回角色湖泊资源
	 * @param roleId
	 * @param parentId
	 * @return湖泊对象
	 *
	 */

	@Override
	public Vo4River lakes(String roleId,String parentId) {
		Vo4River vo4River = new Vo4River();
		List<Vo4River> resultList = new ArrayList<>();
		List<LakeEntity> lakeList = lakeService.queryList(new HashedMap());
		Iterator<LakeEntity> it = lakeList.iterator();
		Map<String,Object> queryMap = new HashedMap();
		while (it.hasNext()) {
			Vo4River vo =new Vo4River();
			LakeEntity obj = it.next();
			vo.setRoleId(roleId);
			vo.setId(obj.getId());
			vo.setType("湖泊");
			vo.setAreaName(obj.getAreaName());
			vo.setName(obj.getName());
			vo.setParentId("0");
			queryMap.put("lakeId",obj.getId());
			List<PartLakeEntity> partLakeList= partLakeService.queryList(queryMap);
			if(partLakeList.size() > 0 ){
				vo.setOpen(true);
			}else{
				vo.setOpen(false);
			}
			Iterator<PartLakeEntity> partit = partLakeList.iterator();
			while(partit.hasNext()){
				PartLakeEntity partLakeEntity = partit.next();
				Vo4River partvo =new Vo4River();
				partvo.setRoleId(roleId);
				partvo.setAreaName(partLakeEntity.getAreaName());
				partvo.setName(partLakeEntity.getName());
				partvo.setType("湖段");
				partvo.setId(partLakeEntity.getId());
				partvo.setParentId(partLakeEntity.getLakeId());
				partvo.setOpen(false);
				resultList.add(partvo);
			}
			resultList.add(vo);
		}
		//查找到该角色对应的河流权限
		Map<String,Object> map = new HashedMap();
		map.put("roleId",roleId);
		List<SysRoleResourceEntity> list = sysRoleResourceService.queryList(map);
		//判断拥有的河流个数的大小，如果为0，返回resultlist，并将status置为flase，不为0.则将拥有的权限置为true
		if(list.size() != 0) {
			SysRoleResourceEntity sysRoleResourceEntity = list.get(0);
			List lakeIds = StringUtil.arrays2List(sysRoleResourceEntity.getLakeids());
			List partLakeIds = StringUtil.arrays2List(sysRoleResourceEntity.getPartlakeids());
			for (int i = 0; i < resultList.size(); i++) {
				resultList.get(i).setStatus(false);
				for (int j = 0; j < lakeIds.size(); j++) {
					if (lakeIds.get(j).equals(resultList.get(i).getId())) {
						resultList.get(i).setStatus(true);
					}
				}
				for (int j = 0; j < partLakeIds.size(); j++) {
					if (partLakeIds.get(j).equals(resultList.get(i).getId())) {
						resultList.get(i).setStatus(true);
					}
				}

			}
		}
		vo4River.setList(resultList);
		return vo4River;
	}


	/**
	 * 返回角色水库资源
	 * @param roleId
	 * @param parentId
	 * @return
	 */
	@Override
	public Vo4River reservoirs(String roleId,String parentId) {
		Vo4River vo4River = new Vo4River();
		List<Vo4River> resultList = new ArrayList<>();
		List<ReservoirEntity> reservoirList = reservoirService.queryList(new HashedMap());
		Iterator<ReservoirEntity> it = reservoirList.iterator();
		Map<String,Object> queryMap = new HashedMap();
		while (it.hasNext()) {
			Vo4River vo =new Vo4River();
			ReservoirEntity obj = it.next();
			vo.setRoleId(roleId);
			vo.setId(obj.getId());
			vo.setType("水库");
			vo.setAreaName(obj.getAreaName());
			vo.setName(obj.getName());
			vo.setParentId("0");
			queryMap.put("reservoirId",obj.getId());
			List<PartReservoirEntity> partReservoirList= partReservoirService.queryList(queryMap);
			if(partReservoirList.size() > 0 ){
				vo.setOpen(true);
			}else{
				vo.setOpen(false);
			}
			Iterator<PartReservoirEntity> partit = partReservoirList.iterator();
			while(partit.hasNext()){
				PartReservoirEntity partReservoirEntity = partit.next();
				Vo4River partvo =new Vo4River();
				partvo.setRoleId(roleId);
				partvo.setAreaName(partReservoirEntity.getAreaName());
				partvo.setName(partReservoirEntity.getName());
				partvo.setType("库段");
				partvo.setId(partReservoirEntity.getId());
				partvo.setParentId(partReservoirEntity.getReservoirId());
				partvo.setOpen(false);
				resultList.add(partvo);
			}
			resultList.add(vo);
		}
		//查找到该角色对应的水库权限
		Map<String,Object> map = new HashedMap();
		map.put("roleId",roleId);
		List<SysRoleResourceEntity> list = sysRoleResourceService.queryList(map);
		//判断拥有的河流个数的大小，如果为0，返回resultlist，并将status置为flase，不为0.则将拥有的权限置为true
		if(list.size() != 0) {
			SysRoleResourceEntity sysRoleResourceEntity = list.get(0);
			List reservoirIds = StringUtil.arrays2List(sysRoleResourceEntity.getReservoirids());
			List partReservoirIds = StringUtil.arrays2List(sysRoleResourceEntity.getPartreservoirids());
			for (int i = 0; i < resultList.size(); i++) {
				resultList.get(i).setStatus(false);
				for (int j = 0; j < reservoirIds.size(); j++) {
					if (reservoirIds.get(j).equals(resultList.get(i).getId())) {
						resultList.get(i).setStatus(true);
					}
				}
				for (int j = 0; j < partReservoirIds.size(); j++) {
					if (partReservoirIds.get(j).equals(resultList.get(i).getId())) {
						resultList.get(i).setStatus(true);
					}
				}

			}
		}
		vo4River.setList(resultList);
		return vo4River;
	}

	@Override
	public Vo4River areas(String roleId,String parentId){
		Vo4River vo4River = new Vo4River();
		List<Vo4River> resultList = new ArrayList<>();
		List<SysAreaEntity> areaList = sysAreaService.queryList(new HashedMap());
		Iterator<SysAreaEntity> it = areaList.iterator();
		Map<String,Object> queryMap = new HashedMap();
		while (it.hasNext()) {
			Vo4River vo =new Vo4River();
			SysAreaEntity obj = it.next();
			vo.setRoleId(roleId);
			vo.setId(obj.getAreaId());//系统编码
			vo.setCode(obj.getId());  //行政区划编码
			vo.setName(obj.getName());
			vo.setParentId(obj.getParentId());
			vo.setOpen(obj.getOpen());
			resultList.add(vo);
		}
		//查找到该角色对应的水库权限
		Map<String,Object> map = new HashedMap();
		map.put("roleId",roleId);
		List<SysRoleResourceEntity> list = sysRoleResourceService.queryList(map);
		//判断拥有的河流个数的大小，如果为0，返回resultlist，并将status置为flase，不为0.则将拥有的权限置为true
		if(list.size() != 0) {
			SysRoleResourceEntity sysRoleResourceEntity = list.get(0);
			List areaIds = StringUtil.arrays2List(sysRoleResourceEntity.getAreaids());
			for (int i = 0; i < resultList.size(); i++) {
				resultList.get(i).setStatus(false);
				for (int j = 0; j < areaIds.size(); j++) {
					if (areaIds.get(j).equals(resultList.get(i).getId())) {
						resultList.get(i).setStatus(true);
					}
				}
			}
		}
		vo4River.setList(resultList);
		return vo4River;
	}


	@Override
	public SysRoleResourceEntity queryObjectByRoleId(String roleId){
		return sysRoleResourceDao.queryObjectByRoleId(roleId);
	}

}
