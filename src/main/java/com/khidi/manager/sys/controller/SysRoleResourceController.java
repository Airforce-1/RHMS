package com.khidi.manager.sys.controller;

import com.khidi.common.annotation.SysLog;
import com.khidi.common.utils.*;
import com.khidi.manager.basicinfo.entity.ResourceStationEntity;
import com.khidi.manager.basicinfo.entity.ResourceVideoEntity;
import com.khidi.manager.basicinfo.service.ResourceStationService;
import com.khidi.manager.basicinfo.service.ResourceVideoService;
import com.khidi.manager.sys.dao.SysUserDao;
import com.khidi.manager.sys.entity.SysMenuEntity;
import com.khidi.manager.sys.entity.SysRoleMenuEntity;
import com.khidi.manager.sys.service.*;
import com.khidi.manager.sys.vo.RoleResourceIdsVO;
import com.khidi.common.exception.RRException;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;

import java.util.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.khidi.manager.sys.entity.SysRoleResourceEntity;

import javax.websocket.server.PathParam;


/**
 * 角色-菜单-资源配置管理
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-14 14:31:17
 */
@RestController
@RequestMapping("sysroleresource")
@Api(value = "/SysRoleResource", description = "角色-菜单-资源配置管理")
public class SysRoleResourceController {
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysRoleDeptService sysRoleDeptService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysRoleResourceService sysRoleResourceService;
	@Autowired
	private ResourceVideoService resourceVideoService;
	@Autowired
	private ResourceStationService resourceStationService;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	@Autowired
	private SysMenuService sysMenuService;
	@Autowired
	private SysAreaService sysAreaService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
//	@RequiresPermissions("sysroleresource:list")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="riverids",required=false) String riverids,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="roleId",required=false) String roleId,
                  @RequestParam(value="lakeids",required=false) String lakeids,
                  @RequestParam(value="videostationids",required=false) String videostationids,
                  @RequestParam(value="canalids",required=false) String canalids,
                  @RequestParam(value="riverstationids",required=false) String riverstationids,
                  @RequestParam(value="reservoirids",required=false) String reservoirids,
                  @RequestParam(value="partriverids",required=false) String partriverids,
                  @RequestParam(value="partcanalids",required=false) String partcanalids,
                  @RequestParam(value="partlakeids",required=false) String partlakeids,
                  @RequestParam(value="partreservoirids",required=false) String partreservoirids,
                  @RequestParam(value="areaids",required=false) String areaids,
				  @RequestParam(value="menuids",required=false) String menuids){
        Map<String,Object> queryparams = new HashMap<String,Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
		if(riverids != null){
    	queryparams.put("riverids",riverids);
		}
		if(id != null){
    	queryparams.put("id",id);
		}
		if(roleId != null){
    	queryparams.put("roleId",roleId);
		}
		if(lakeids != null){
    	queryparams.put("lakeids",lakeids);
		}
		if(videostationids != null){
    	queryparams.put("videostationids",videostationids);
		}
		if(canalids != null){
    	queryparams.put("canalids",canalids);
		}
		if(riverstationids != null){
    	queryparams.put("riverstationids",riverstationids);
		}
		if(reservoirids != null){
    	queryparams.put("reservoirids",reservoirids);
		}
		if(partriverids != null){
    	queryparams.put("partriverids",partriverids);
		}
		if(partcanalids != null){
    	queryparams.put("partcanalids",partcanalids);
		}
		if(partlakeids != null){
    	queryparams.put("partlakeids",partlakeids);
		}
		if(partreservoirids != null){
    	queryparams.put("partreservoirids",partreservoirids);
		}
		if(areaids != null){
    	queryparams.put("areaids",areaids);
		}
		if(menuids != null){
			queryparams.put("menuids",menuids);
		}
		//查询列表数据
        Query query = new Query(queryparams);

		List<SysRoleResourceEntity> sysRoleResourceList = sysRoleResourceService.queryList(query);
		int total = sysRoleResourceService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysRoleResourceList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

//
//	/**
//	 * 保存角色-菜单关系
//	 */
//	@SysLog("保存角色-资源关系")
//	@RequestMapping(value="/menus/",method=RequestMethod.POST)
//	@RequiresPermissions("sys:role:save")
//	@ApiOperation(value="保存角色-资源(菜单-河流(段)-渠道(段)-湖泊(段)-水库(段))", notes="保存角色-资源关系(菜单-河流(段)-渠道(段)-湖泊(段)-水库(段))")
//	public R saveRoleResource(@RequestBody RoleResourceIdsVO roleResourceIdsVO){
//		sysRoleMenuService.delete(roleResourceIdsVO.getRoleId());
//		String[] strings = roleResourceIdsVO.getResourceIds().split(",");
//		for(int i=0;i<strings.length;i++){
//			SysRoleMenuEntity sysRoleMenuEntity = new SysRoleMenuEntity();
//			sysRoleMenuEntity.setRoleId(roleResourceIdsVO.getRoleId());
//			sysRoleMenuEntity.setMenuId(strings[i]);
//			sysRoleMenuService.saveOrUpdate(sysRoleMenuEntity);
//		}
//		return R.ok();
//	}



	/**
	 * 传入角色roleId，返回带有status的菜单列表，用于修改分配权限时的第一次显示
	 */
	@RequestMapping(value="/menus",method = RequestMethod.GET)
//	@RequiresPermissions("sys:role:info")
	@ApiOperation(value="获取当前账户职务（角色）对应的菜单列表", notes="status表示是否有该权限")
	public R menus(@RequestParam(value="roleId",required=true) String roleId){
		return R.ok().put("data", sysRoleResourceService.menus(roleId));
	}

	/**
	 * 传入角色roleId，返回stations列表，用于修改监测站分配权限时的第一次显示
	 */
	@RequestMapping(value="/stations",method = RequestMethod.GET)
//	@RequiresPermissions("sys:role:info")
	@ApiOperation(value="获取当前账户职务（角色）返回监测站列表", notes="1、水质监测站2、水文监测站3、视频监测站")
	public R stations(@RequestParam(value="roleId",required=true) String roleId,
					  @RequestParam(value="page",required=true) int page,
	                  @RequestParam(value="limit",required=true) int limit,
					  @RequestParam(value="resourceType",required=false) String resourceType,
					  @RequestParam(value="resourceName",required=false) String resourceName
	){
		Map<String,Object> queryparams = new HashMap<String,Object>();
		if(StringUtil.isNotEmpty(roleId)){
			queryparams.put("roleId",roleId);
		}
		if(StringUtil.isNotEmpty(resourceType)){
			queryparams.put("resourceType",resourceType);
		}else{
			queryparams.put("resourceType","");
		}
		if(StringUtil.isNotEmpty(resourceName)){
			queryparams.put("resourceName",resourceName);
		}else{
			queryparams.put("resourceName","");
		}
		return R.ok().put("data", ListUtil.ListPage(sysRoleResourceService.stations(queryparams),page,limit));
	}

	/**
	 * 传入角色roleId，返回该角色可看的stations列表，用于监测站显示已选右侧框
	 */
	@RequestMapping(value="/permstations",method = RequestMethod.GET)
//	@RequiresPermissions("sys:role:info")
	@ApiOperation(value="获取当前账户职务（角色）返回监测站列表", notes="1、水质监测站2、水文监测站3、视频监测站")
	public R permstations(@RequestParam(value="roleId",required=true) String roleId
	){
		return R.ok().put("data", sysRoleResourceService.permstations(roleId));
	}

	/**
	 * 传入角色roleId，返回河流列表，用于修改河流分配权限时的第一次显示
	 */
	@RequestMapping(value="/rivers/{parentId}",method = RequestMethod.GET)
//	@RequiresPermissions("sys:role:info")
	@ApiOperation(value="获取当前账户职务（角色）返回河流列表", notes="status，true有权限；flase无权限")
	public R rivers(@PathParam("parentId")String parentId,
			        @RequestParam(value="roleId",required=true)String roleId){
		return R.ok().put("data",sysRoleResourceService.rivers(roleId,parentId));
	}


	/**
	 * 传入角色roleId，返回渠道列表，用于修改渠道分配权限时的第一次显示
	 */
	@RequestMapping(value="/canals/{parentId}",method = RequestMethod.GET)
//	@RequiresPermissions("sys:role:info")
	@ApiOperation(value="获取当前账户职务（角色）返回渠道列表", notes="status，true有权限；flase无权限")
	public R canals(@PathParam("parentId")String parentId,
					@RequestParam(value="roleId",required=true)String roleId){
		return R.ok().put("data",sysRoleResourceService.canals(roleId,parentId));
	}


	/**
	 * 传入角色roleId，返回湖泊列表，用于修改湖泊分配权限时的第一次显示
	 */
	@RequestMapping(value="/lakes/{parentId}",method = RequestMethod.GET)
//	@RequiresPermissions("sys:role:info")
	@ApiOperation(value="获取当前账户职务（角色）返回湖泊(段)列表", notes="status，true有权限；flase无权限")
	public R lakes(@PathParam("parentId")String parentId,
					@RequestParam(value="roleId",required=true)String roleId){
		return R.ok().put("data",sysRoleResourceService.lakes(roleId,parentId));
	}


	/**
	 * 传入角色roleId，返回水库列表，用于修改水库分配权限时的第一次显示
	 */
	@RequestMapping(value="/reservoirs/{parentId}",method = RequestMethod.GET)
//	@RequiresPermissions("sys:role:info")
	@ApiOperation(value="获取当前账户职务（角色）返回水库(段)列表", notes="status，true有权限；flase无权限")
	public R reservoirs(@PathParam("parentId")String parentId,
				   @RequestParam(value="roleId",required=true)String roleId){
		return R.ok().put("data",sysRoleResourceService.reservoirs(roleId,parentId));
	}

	/**
	 * 传入角色roleId，返回行政区划列表，用于修改行政区划分配权限时的第一次显示
	 */
	@RequestMapping(value="/areas/{parentId}",method = RequestMethod.GET)
//	@RequiresPermissions("sys:role:info")
	@ApiOperation(value="获取当前账户职务（角色）返回行政区划列表", notes="status，true有权限；flase无权限")
	public R areas(@PathParam("parentId")String parentId,
				   @RequestParam(value="roleId",required=true)String roleId){
		return R.ok().put("data",sysRoleResourceService.areas(roleId,parentId));
	}
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
//	@RequiresPermissions("sysroleresource:info")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		SysRoleResourceEntity sysRoleResource = sysRoleResourceService.queryObject(id);
		
		return R.ok().put("data", sysRoleResource);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
//	@RequiresPermissions("sys:role:save")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody SysRoleResourceEntity sysRoleResource){
        verifyForm(sysRoleResource);
        //1、对前台传来的meuid的ids进行索源查找，找到目录为止
        List<String> menuids = StringUtil.arrays2List(sysRoleResource.getMenuids());
//		List<String> resultmenuids = new ArrayList<>();
//		for(int i=0;i<menuids.size();i++){
//			resultmenuids.addAll(getParentId(resultmenuids,menuids.get(i)));
//		}

//		resultmenuids = StringUtil.removeDuplicate(resultmenuids);
		sysRoleMenuService.delete(sysRoleResource.getRoleId());
        for(int i=0;i<menuids.size();i++){
			SysRoleMenuEntity sysRoleMenuEntity = new SysRoleMenuEntity();
			sysRoleMenuEntity.setMenuId(menuids.get(i));
			sysRoleMenuEntity.setRoleId(sysRoleResource.getRoleId());
			sysRoleMenuService.saveOrUpdate(sysRoleMenuEntity);
		}
		//2、对前台传来的行政区划id，只传根节点id，向下查找，找到后拼接保存
		List<String> areaList = StringUtil.arrays2List(sysRoleResource.getAreaids());
		List<String> resultList = new ArrayList<>();
		resultList.addAll(areaList);
		Iterator<String> it = areaList.iterator();
		while(it.hasNext()){
			String obj = it.next();
			resultList.addAll(sysAreaService.getSonAreaIdList(obj));
		}
		//去除重复项
		resultList = StringUtil.removeDuplicate(resultList);
		//list转化为逗号分割的String
		sysRoleResource.setAreaids(StringUtil.joinList(resultList,","));
		sysRoleResourceService.save(sysRoleResource);
		return R.ok();
	}

	//前台传来按钮的menuid，往上找出菜单和目录的id，也存入数据库
//	private List<String> getParentId(List<String> resultlist,String menuId){
//		resultlist.add(menuId);
//		if(!sysMenuService.queryObject(menuId).getParentId().equals("0")){
//			if(!resultlist.contains(sysMenuService.queryObject(menuId).getParentId())){
//				resultlist.add(sysMenuService.queryObject(menuId).getParentId());
//			}
//			getParentId(resultlist,sysMenuService.queryObject(menuId).getParentId());
//		}
//		return resultlist;
//	}
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("sysroleresource:update")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody SysRoleResourceEntity sysRoleResource){
        verifyForm(sysRoleResource);
		sysRoleResourceService.update(sysRoleResource);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
//	@RequiresPermissions("sysroleresource:delete")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				sysRoleResourceService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(SysRoleResourceEntity sysRoleResource){

	        if(StringUtils.isBlank(sysRoleResource.getRoleId())){
            throw new RRException(270,"角色编码不能为空");
		}
	    }


}