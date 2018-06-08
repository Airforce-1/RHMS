package com.khidi.manager.sys.controller;

import com.khidi.common.exception.RRException;
import com.khidi.common.utils.R;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.sys.entity.SysAreaEntity;
import com.khidi.manager.sys.entity.SysDeptEntity;
import com.khidi.manager.sys.service.SysDeptService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.khidi.common.utils.Constant;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 机构管理
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-10-20 15:23:47
 */
@RestController
@RequestMapping("/sys/dept")
@Api(value="/sys/dept",description="机构管理")
public class SysDeptController extends AbstractController {
	@Autowired
	private SysDeptService sysDeptService;
	
	/**
	 * 列表
	 */
	@ApiOperation(value="所有机构列表", notes="所有机构列表")
	@RequestMapping(path="/list",method=RequestMethod.GET)
	@RequiresPermissions("机构管理:查看")
	public List<SysDeptEntity> list(){
		Map<String, Object> map = new HashMap<>();
		//如果不是超级管理员，则只能查询本部门及子部门数据
		if(!getUserId().equals(Constant.SUPER_ADMIN)){
			map.put("deptFilter", sysDeptService.getSubDeptIdList(getDeptId()));
		}
		List<SysDeptEntity> deptList = sysDeptService.queryList(map);

		return deptList;
	}

	/**
	 * 选择部门(添加、修改菜单)
	 */
	@ApiOperation(value="选择机构列表", notes="选择机构列表")
	@RequestMapping(path="/select",method=RequestMethod.GET)
	@RequiresPermissions("机构管理:查看")
	public R select(){
		Map<String, Object> map = new HashMap<>();
		//如果不是超级管理员，则只能查询本部门及子部门数据
		if(!getUserId().equals(Constant.SUPER_ADMIN)){
			map.put("deptFilter", sysDeptService.getSubDeptIdList(getDeptId()));
		}
		List<SysDeptEntity> deptList = sysDeptService.queryList(map);

		//添加一级部门
		if(getUserId().equals(Constant.SUPER_ADMIN)){
			SysDeptEntity root = new SysDeptEntity();
			root.setDeptId("0");
			root.setName("一级部门");
			root.setParentId("-1");
			root.setOpen(true);
			deptList.add(root);
		}

		return R.ok().put("deptList", deptList);
	}

	/**
	 * 上级部门Id(管理员则为0)
	 */
	@ApiOperation(value="上级部门Id", notes="上级机构Id")
	@RequestMapping(path="/info",method=RequestMethod.GET)
	@RequiresPermissions("机构管理:查看")
	public R info(){
		String deptId = "0";
		if(!getUserId().equals(Constant.SUPER_ADMIN)){
			SysDeptEntity dept = sysDeptService.queryObject(getDeptId());
			deptId = dept.getParentId();
		}

		return R.ok().put("deptId", deptId);
	}
	
	/**
	 * 信息
	 */
	@ApiOperation(value="查询部门信息", notes="查询部门信息")
	@RequestMapping(path="/info/{deptId}",method=RequestMethod.GET)
	@RequiresPermissions("机构管理:查看")
	public R info(@PathVariable("deptId") String deptId){
		SysDeptEntity dept = sysDeptService.queryObject(deptId);
		
		return R.ok().put("dept", dept);
	}
	
	/**
	 * 保存
	 */
	@ApiOperation(value="保存机构", notes="保存机构")
	@RequestMapping(path="/save",method=RequestMethod.POST)
	@RequiresPermissions("机构管理:管理")
	public R save(@RequestBody SysDeptEntity dept){
		verifyForm(dept);
		sysDeptService.save(dept);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ApiOperation(value="修改机构", notes="修改机构")
	@RequestMapping(path="/update",method=RequestMethod.PUT)
	@RequiresPermissions("机构管理:管理")
	public R update(@RequestBody SysDeptEntity dept){
		verifyForm(dept);
		if(StringUtil.isNotEmpty(sysDeptService.queryParentIdIsCorrent(dept))){
			throw new RRException(180, "父节点不能为自身和自身子节点");
		}
		sysDeptService.update(dept);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ApiOperation(value="删除机构", notes="删除机构")
	@RequestMapping(path="/delete",method=RequestMethod.DELETE)
	@RequiresPermissions("机构管理:管理")
	public R delete(String deptId){
		//判断是否有子部门
		List<String> deptList = sysDeptService.queryDetpIdList(deptId);
		if(deptList.size() > 0){
			throw new RRException(280,"请先删除子部门");
		}

		sysDeptService.delete(deptId);
		
		return R.ok();
	}


	private void verifyForm(SysDeptEntity entity) {
		if (StringUtils.isBlank(entity.getAreaId())) {
			throw new RRException(270, "管辖区域不能为空");
		}
		if (StringUtils.isBlank(entity.getDeptLevel().toString())) {
			throw new RRException(270, "机构级别不能为空");
		}
		if (StringUtils.isBlank(entity.getName())) {
			throw new RRException(270, "机构名称不能为空");

		}
		if (StringUtils.isBlank(entity.getParentId())){
			throw new RRException(270, "上级机构不能为空");
		}
		if (StringUtils.isBlank(entity.getOrderNum().toString())){
			throw new RRException(270, "排序号不能为空");
		}
	}
	
}
