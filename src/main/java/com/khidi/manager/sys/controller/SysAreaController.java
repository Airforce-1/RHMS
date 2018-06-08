package com.khidi.manager.sys.controller;

import com.khidi.common.exception.RRException;
import com.khidi.common.utils.*;
import com.khidi.manager.sys.entity.SysAreaEntity;
import com.khidi.manager.sys.entity.SysRoleEntity;
import com.khidi.manager.sys.service.SysAreaService;

import com.khidi.manager.sys.service.SysUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


/**
 * 行政区划管理
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-10-20 15:23:47
 */
@RestController
@RequestMapping("/sys/area")
@Api(value="/sys/area",description="行政区域")
public class SysAreaController extends AbstractController {
	@Autowired
	private SysAreaService sysAreaService;
//	@Autowired
//	private RedisUtils redisUtils;
	@Autowired
	private SysUserRoleService SysUserRoleService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
//	@RequiresPermissions("sys:area:list")
	@ApiOperation(value="获取所有行政区域", notes="获取所有行政区域")
	public List<SysAreaEntity> list(){
		Map<String, Object> map = new HashMap<>();
		List<SysAreaEntity> areaList = new ArrayList<>();
		//如果不是超级管理员，则只能查询本行政区划及子部门数据
		if(!getUserId().equals(Constant.SUPER_ADMIN)){
			map.put("roleId",StringUtil.joinList4sql(getRole(),"','"));
		}
		return  sysAreaService.queryList(map);
	}

	/**
	 * 选择行政区划(添加、修改菜单)
	 */
	@RequestMapping(value="/select",method=RequestMethod.GET)
//	@Cacheable(key ="#p0")
//	@RequiresPermissions("sys:area:select")
	@ApiOperation(value="选择自己管理的行政区划", notes="选择自己管理的行政区划")
	public R select(){
		Map<String, Object> map = new HashMap<>();
		List<SysAreaEntity> areaList = new ArrayList<>();
		//如果不是超级管理员，则只能查询本行政区划及子行政区划数据
		if(!getUserId().equals(Constant.SUPER_ADMIN)){
			List<String> roleIdList  = SysUserRoleService.queryRoleIdList(getUserId());
			for(int i=0;i<roleIdList.size();i++){
				map.put("roleId",roleIdList.get(i));
				areaList.addAll(sysAreaService.queryList(map));
			}
			areaList = ListUtil.getNewAreaList(areaList);
		}else{
			areaList = sysAreaService.queryList(map);
		}
		return R.ok().put("areaList", areaList);
	}

	/**
	 * 上级行政区划Id(管理员则为0)
	 */
	@RequestMapping(value="/info",method=RequestMethod.GET)
//	@RequiresPermissions("sys:area:list")
	@ApiOperation(value="上级行政区划Id(管理员则为0)", notes="上级行政区划Id(管理员则为0)")
	public R info(){
		String areaId = "";
		if(!getUserId().equals(Constant.SUPER_ADMIN)){
			SysAreaEntity area = sysAreaService.queryObject(getDeptId());
			areaId = area.getParentId();
		}

		return R.ok().put("areaId", areaId);
	}
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/info/{areaId}",method=RequestMethod.GET)
//	@RequiresPermissions("sys:area:info")
	@ApiOperation(value="根据id获取单条信息", notes="根据id获取单条信息")
	public R info(@PathVariable("areaId") String areaId){
		SysAreaEntity area = sysAreaService.queryObject(areaId);
		area.setList(sysAreaService.queryListByParentId(area.getAreaId()));
		return R.ok().put("area", area);
	}
	
	/**
	 * 保存
	 */

	@ApiOperation(value="保存行政区域信息", notes="保存行政区域信息")
	@RequestMapping(value="/save",method=RequestMethod.POST)
//	@CachePut(key = "#p0")
	@RequiresPermissions("行政区划管理:管理")
	public R save(@RequestBody SysAreaEntity area){
		verifyForm(area);
		sysAreaService.save(area);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ApiOperation(value="修改行政区域信息", notes="修改行政区域信息")
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	@RequiresPermissions("行政区划管理:管理")
	public R update(@RequestBody SysAreaEntity area){
		verifyForm(area);
		if(StringUtil.isNotEmpty(sysAreaService.queryParentIdIsCorrent(area))){
			throw new RRException(180, "父节点不能为自身和自身子节点");
		}
		sysAreaService.update(area);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ApiOperation(value="删除行政区域信息", notes="删除行政区域信息")
	@RequestMapping(value="/delete/{areaId}",method=RequestMethod.DELETE)
	@RequiresPermissions("行政区划管理:管理")
	public R delete(String areaId){
		//判断是否有子部门
		List<String> areaList = sysAreaService.queryAreaIdList(areaId);
		if(areaList.size() > 0){
			throw new RRException(280,"请先删除子行政区划");
		}

		sysAreaService.delete(areaId);
		return R.ok();
	}


	private void verifyForm(SysAreaEntity entity) {
		if (StringUtils.isBlank(entity.getId())) {
			throw new RRException(270, "行政区划编码不能为空");
		}
		if (StringUtils.isBlank(entity.getName())) {
			throw new RRException(270, "行政区划名称不能为空");

		}
		if (StringUtils.isBlank(entity.getParentId())){
			throw new RRException(270, "上级行政区划不能为空");
		}
		if (StringUtils.isBlank(entity.getOrderNum().toString())){
			throw new RRException(270, "排序号不能为空");
		}
	}
	
}
