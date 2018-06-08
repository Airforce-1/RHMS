package com.khidi.manager.sys.controller;
import com.khidi.common.annotation.SysLog;
import com.khidi.common.exception.RRException;
import com.khidi.common.utils.*;
import com.khidi.common.validator.ValidatorUtils;
import com.khidi.manager.api.entity.UserEntity;
import com.khidi.manager.basicinfo.entity.PartCanalEntity;
import com.khidi.manager.sys.dao.SysUserDao;
import com.khidi.manager.sys.entity.*;
import com.khidi.manager.sys.service.*;
import com.khidi.manager.sys.vo.RoleResourceIdsVO;
import com.mchange.lang.IntegerUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 职务（角色）管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月8日 下午2:18:33
 */
@RestController
@RequestMapping("/sys/role")
@Api(value="/sys/role",description="职务（角色）管理")
public class SysRoleController extends AbstractController {
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	@Autowired
	private SysRoleDeptService sysRoleDeptService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
    private SysUserDao sysUserDao;
	@Autowired
	private SysRoleResourceService sysRoleResourceService;
	@Autowired
	private SysUserService sysUserService;

	/**
	 * 角色列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
//	@RequiresPermissions("sys:role:list")
	@ApiOperation(value="获取所有职务（角色）列表", notes="获取所有职务（角色）列表")
	public R list(@RequestParam(value="roleId",required=false) String roleId,
				  @RequestParam(value="parentId",required=false) String parentId,
				  @RequestParam(value="roleName",required=false) String roleName,
				  @RequestParam(value="areaId",required=false) String areaId,
				  @RequestParam(value="roleLevel",required=false) Double roleLevel,
				  @RequestParam(value="roleType",required=false) Double roleType){
		Map<String, Object> map = new HashMap<>();
		if(roleId != null){
			map.put("roleId",roleId);
		}
		if(parentId != null){
			map.put("parentId",parentId);
		}
		if(roleName != null){
			map.put("roleName",roleName);
		}
		if(areaId != null){
			map.put("areaId",areaId);
		}
		if(roleLevel != null){
			map.put("roleLevel",roleLevel);
		}
		if(roleType != null){
			map.put("roleType",roleType);
		}
		//如果不是超级管理员，则只查询自己创建的角色列表
//		if(!getUserId().equals(Constant.SUPER_ADMIN)){
//			map.put("createUserId", getUserId());
//		}
		List<SysRoleEntity> list = sysRoleService.queryList(map);
		return R.ok().put("page", list);
	}

	/**
	 * 获取父节点下的职务（角色）列表
	 */
	@RequestMapping(value="/sonlist/{parentId}",method = RequestMethod.GET)
	@RequiresPermissions("职务管理:查看")
	@ApiOperation(value="获取父节点下的职务（角色）列表", notes="获取父节点下的职务（角色）列表")
	public R querySonList(@PathVariable("parentId") String parentId){
		SysRoleEntity entity = new SysRoleEntity();
		if(!parentId.equals("0")){
			entity = sysRoleService.queryObject(parentId);
		}
		List<SysRoleEntity> list = sysRoleService.querySonList(parentId);
		entity.setList(list);
		return R.ok().put("data",entity);
	}








	/**
	 * 角色信息
	 */
	@RequestMapping(value="/info/{roleId}",method = RequestMethod.GET)
	@RequiresPermissions("职务管理:查看")
	@ApiOperation(value="获取当前账户职务（角色）列表", notes="获取所有职务（角色）列表")
	public R info(@PathVariable("roleId") String roleId){
		SysRoleEntity role = sysRoleService.queryObject(roleId);
		
		//查询角色对应的菜单
		List<String> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
		role.setMenuIdList(menuIdList);

		//查询角色对应的行政区划
		
		return R.ok().put("role", role);
	}
	
	/**
	 * 保存角色
	 */
	@SysLog("保存角色")
	@RequestMapping(value="",method=RequestMethod.POST)
	@RequiresPermissions("职务管理:管理")
	@ApiOperation(value="保存职务（角色）信息", notes="保存职务（角色）信息")
	public R save(@RequestBody SysRoleEntity role){
		verifyForm(role);
		
		sysRoleService.save(role);
		
		return R.ok();
	}
	
	/**
	 * 修改角色
	 */
	@SysLog("修改角色")
	@RequestMapping(value="",method=RequestMethod.PUT)
	@RequiresPermissions("职务管理:管理")
	@ApiOperation(value="修改职务（角色）信息", notes="修改职务（角色）信息")
	public R update(@RequestBody SysRoleEntity role){
		verifyForm(role);
		if(StringUtil.isNotEmpty(sysRoleService.queryParentIdIsCorrent(role))){
			throw new RRException(180, "父节点不能为自身和自身子节点");
		}
		sysRoleService.update(role);
		return R.ok();
	}
	
	/**
	 * 删除角色
	 */
	@SysLog("删除角色")
	@RequestMapping(value="/{roleId}",method = RequestMethod.DELETE)
	@RequiresPermissions("职务管理:管理")
	@ApiOperation(value="删除职务（角色）信息", notes="删除职务（角色）信息")
	public R delete(@PathVariable("roleId") String  roleId){
		List<String> roleIdList = sysRoleService.queryRoleIdList(roleId);
		if(roleIdList.size() > 0){
			return R.error("请先删除子职务");
		}
		sysRoleService.delete(roleId);
		return R.ok();
	}

	/**
	 * 根据roleId传回关联userList
	 */
	@RequestMapping(value="/userlist/",method = RequestMethod.GET)
//	@RequiresPermissions("sys:role:list")
	@ApiOperation(value="根据roleId,listType传回userList", notes="listType:1代表关联用户；listType:2代表不关联用户,listType:else，代表全部用户")
	public R UserListbyRoleId(@RequestParam(value="page",required=true) int page,
							  @RequestParam(value="limit",required=true) int limit,
							  @RequestParam(value="username",required=false) String username,
							  @RequestParam(value="deptId",required=false) String deptId,
							  @RequestParam(value="roleId",required=true) String roleId,
							  @RequestParam(value="listType",required=true) String listType){
		Map<String,Object> queryparams = new HashMap<String,Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		if(username != null){
			queryparams.put("username",username);
		}
		if(deptId != null){
			queryparams.put("deptId",deptId);
		}
		if(roleId != null){
			queryparams.put("roleId",roleId);
		}
		if(listType != null){
			queryparams.put("listType",listType);
		}
		Query query = new Query(queryparams);
		PageUtils pageUtil = new PageUtils(sysUserService.queryUserList4RoleRelate(query), sysUserService.queryTotal4RoleRelate(query), query.getLimit(), query.getPage());
		return R.ok().put("data",pageUtil);
	}



	/**
	 * 保存角色-用户关系
	 */
//	@SysLog("保存角色-用户关系")
	@RequestMapping(value="/user/",method=RequestMethod.POST)
	@RequiresPermissions("职务管理:管理")
	@ApiOperation(value="保存角色-用户关系", notes="保存角色-用户关系")
	public R saveUserRole(@RequestParam(value="roleId",required=false) String roleId,
				  @RequestParam(value="user_ids",required=false) String user_ids){
		if(StringUtils.isBlank(roleId)) {
			throw new RRException(270, "角色编码不能为空");
		}
		if(StringUtils.isBlank(user_ids)) {
			throw new RRException(270, "用户编码不能为空");
		}

		String[] strings = user_ids.split(",");
		for(int i=0;i<strings.length;i++){
			SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
			sysUserRoleEntity.setRoleId(roleId);
			sysUserRoleEntity.setUserId(strings[i]);
			sysUserRoleService.save(sysUserRoleEntity);
		}
		return R.ok();
	}





	/**
	 * 删除角色-用户关系
	 */
	@SysLog("删除角色-用户关系")
	@RequestMapping(value="/user/",method=RequestMethod.DELETE)
	@RequiresPermissions("职务管理:管理")
	@ApiOperation(value="删除角色-用户关系", notes="删除角色-用户关系")
	public R delUserRole(@RequestParam(value="roleId",required=false) String roleId,
						  @RequestParam(value="user_ids",required=false) String user_ids){
		if(StringUtils.isBlank(roleId)) {
			throw new RRException(270, "角色编码不能为空");
		}
		if(StringUtils.isBlank(user_ids)) {
			throw new RRException(270, "用户编码不能为空");
		}

		String[] strings = user_ids.split(",");
		for(int i=0;i<strings.length;i++){
			SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
			sysUserRoleEntity.setRoleId(roleId);
			sysUserRoleEntity.setUserId(strings[i]);
			sysUserRoleService.delUserRole(sysUserRoleEntity);
		}
		return R.ok();
	}


	private void verifyForm(SysRoleEntity role) {
		if (StringUtils.isBlank(role.getRoleName())) {
			throw new RRException(270, "职务名称不能为空");

		}
		if (StringUtils.isBlank(role.getParentId())){
			throw new RRException(270, "上级职务不能为空");
		}
	}

}
