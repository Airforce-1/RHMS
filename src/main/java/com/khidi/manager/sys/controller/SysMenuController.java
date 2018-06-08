package com.khidi.manager.sys.controller;
import com.khidi.common.exception.RRException;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.sys.service.SysMenuService;
import com.khidi.common.annotation.SysLog;
import com.khidi.common.utils.Constant.MenuType;
import com.khidi.common.utils.R;
import com.khidi.manager.sys.entity.SysMenuEntity;
import com.khidi.manager.sys.service.ShiroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.util.*;

/**
 * 系统菜单
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017年10月27日 下午9:58:15
 */
@RestController
@RequestMapping("/sys/menu")
@Api(value="/sys/menu",description="动态菜单管理")
public class SysMenuController extends AbstractController {
	@Autowired
	private SysMenuService sysMenuService;
	@Autowired
	private ShiroService shiroService;

	/**
	 * 导航菜单
	 */
	@RequestMapping(value = "/nav",method = RequestMethod.GET)
	@ApiOperation(value="获取当前用户的导航菜单", notes="获取当前用户的导航菜单")
	public R nav(){
		List<SysMenuEntity> menuList = sysMenuService.getUserMenuList(getUserId());
		Set<String> permissions = shiroService.getUserPermissions(getUserId());

		return R.ok().put("menuList", menuList).put("permissions", permissions);
	}
	
	/**
	 * 所有菜单列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("菜单管理:查看")
	@ApiOperation(value="获取所有菜单列表", notes="获取所有菜单列表")
	public R list(@RequestParam(value="name",required=false) String name,
				  @RequestParam(value="parentId",required=false) String parentId){
		Map querymap = new HashMap<>();
		querymap.put("name",name);
		querymap.put("parentId",parentId);
		List<SysMenuEntity> menuList = sysMenuService.queryList(querymap);
		return R.ok().put("data", menuList);
	}
	
	/**
	 * 选择菜单(添加、修改菜单)
	 */
	@RequestMapping(value="/select",method = RequestMethod.GET)
	@RequiresPermissions("菜单管理:查看")
	@ApiOperation(value="添加、修改菜单的时候，选择上级菜单接口", notes="添加、修改菜单的时候，选择上级菜单接口")
	public R select(){
		//查询列表数据
		List<SysMenuEntity> menuList = sysMenuService.queryNotButtonList();
		
		//添加顶级菜单
		SysMenuEntity root = sysMenuService.queryObject("0");
		root.setOpen(true);
		menuList.add(root);
		
		return R.ok().put("menuList", menuList);
	}
	
	/**
	 * 菜单信息
	 */
	@RequestMapping(value="/info/{menuId}",method=RequestMethod.GET)
	@RequiresPermissions("菜单管理:查看")
	@ApiOperation(value="获取菜单信息", notes="获取菜单信息")
	public R info(@PathVariable("menuId") String menuId){

			if(menuId.equals("0")){ //如果为根节点，返回一级菜单
				SysMenuEntity menu = new SysMenuEntity();
				menu.setList(sysMenuService.queryListParentId("0"));
				return R.ok().put("data", menu);
			}else{
				SysMenuEntity menu = sysMenuService.queryObject(menuId);
				if(sysMenuService.queryListParentId(menuId).size() == 0){
					menu.setOpen(false);
				}else{
					menu.setOpen(true);
					menu.setList(sysMenuService.queryListParentId(menuId));
				}
				return R.ok().put("data", menu);
			}
	}



	/**
	 * 菜单信息
	 */
	@RequestMapping(value="/sonList/{menuId}",method=RequestMethod.GET)
	@RequiresPermissions("菜单管理:查看")
	@ApiOperation(value="获取菜单信息", notes="获取菜单信息")
	public R sonList(@PathVariable("menuId") String menuId){
			SysMenuEntity sysMenuEntity = sysMenuService.queryObject(menuId);
			sysMenuEntity.setList(sysMenuService.querySonList(menuId));
			return R.ok().put("data", sysMenuEntity);
	}

	
	/**
	 * 保存
	 */
	@SysLog("保存菜单")
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("菜单管理:管理")
	@ApiOperation(value="保存菜单信息", notes="保存菜单信息")
	public R save(@RequestBody SysMenuEntity menu){
		//数据校验
		verifyForm(menu);
		SysMenuEntity resultMenu =  sysMenuService.save(menu);
		return R.ok().put("data",resultMenu);
	}
	
	/**
	 * 修改
	 */
	@SysLog("修改菜单")
	@RequestMapping(value="",method = RequestMethod.PUT)
	@RequiresPermissions("菜单管理:管理")
	@ApiOperation(value="修改菜单信息", notes="修改菜单信息")
	public R update(@RequestBody SysMenuEntity menu){
		//数据校验
		verifyForm(menu);
		if(StringUtil.isNotEmpty(sysMenuService.queryParentIdIsCorrent(menu))){
			throw new RRException(180, "父节点不能为自身和自身子节点");
		}
		sysMenuService.update(menu);
		return R.ok().put("data",menu);
	}
	
	/**
	 * 删除
	 */
	@SysLog("删除菜单")
	@RequestMapping(value="/{menuId}",method = RequestMethod.DELETE)
	@RequiresPermissions("菜单管理:管理")
	@ApiOperation(value="删除菜单信息", notes="删除菜单信息")
	public R delete(@PathVariable("menuId") String menuId){
		//判断是否有子菜单或按钮
		List<SysMenuEntity> menuList = sysMenuService.queryListParentId(menuId);
		if(menuList.size() > 0){
			throw new RRException(280,"请先删除子菜单或按钮");
		}

		sysMenuService.delete(menuId);
		
		return R.ok();
	}
	/**
	 * 验证参数是否正确
	 */
	private void verifyForm(SysMenuEntity menu){
		if(StringUtils.isBlank(menu.getName())){
			throw new RRException(280,"菜单名单不能为空");
		}

		if(menu.getParentId() == null){
			throw new RRException(280,"上级菜单不能为空");
		}
		if(menu.getOrderNum() == null){
			throw new RRException(280,"排序号不能为空");
		}
		//上级菜单类型
		BigDecimal parentType = MenuType.CATALOG.getValue();
		if(!menu.getParentId().equals("0")){
			SysMenuEntity parentMenu = sysMenuService.queryObject(menu.getParentId());
			parentType = parentMenu.getType();
		}
		//目录、菜单
		if(menu.getType() == MenuType.CATALOG.getValue() ||
				menu.getType() == MenuType.MENU.getValue()){
			if(parentType != MenuType.CATALOG.getValue()){
				throw new RRException(290,"上级菜单只能为目录类型");
			}
			return ;
		}
		//按钮
		if(menu.getType() == MenuType.BUTTON.getValue()){
			if(parentType != MenuType.MENU.getValue()){
				throw new RRException(320,"上级菜单只能为菜单类型");
			}
			return ;
		}
	}
}
