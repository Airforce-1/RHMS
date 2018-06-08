package com.khidi.manager.sys.controller;
import com.khidi.common.annotation.SysLog;
import com.khidi.common.exception.RRException;
import com.khidi.common.utils.Constant;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import com.khidi.common.validator.Assert;
import com.khidi.common.validator.ValidatorUtils;
import com.khidi.manager.basicinfo.entity.CanalEntity;
import com.khidi.manager.sys.service.SysUserService;
import com.khidi.common.validator.group.AddGroup;
import com.khidi.common.validator.group.UpdateGroup;
import com.khidi.manager.sys.entity.SysUserEntity;
import com.khidi.manager.sys.service.SysUserRoleService;
import com.khidi.manager.sys.service.SysUserTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月31日 上午10:40:10
 */
@RestController
@RequestMapping(value="/sys/user")
@Api(value="/sys/user",description="用户管理")
public class SysUserController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysUserTokenService sysUserTokenService;
	/**
	 * 所有用户列表
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@RequiresPermissions("用户管理:查看")
	@ApiOperation(value="获取所有用户列表", notes="获取所有用户列表")
	public R list(@RequestParam(value="page", required=true) int page,
				  @RequestParam(value="limit", required=true) int limit,
				  @RequestParam(value="sidx",required=false)String sidx,
				  @RequestParam(value="order",required=false)String order,
				  @RequestParam(value="areaId",required=false) String areaId,
				  @RequestParam(value="deptId",required=false) String deptId,
				  @RequestParam(value="name",required=false) String name,
				  @RequestParam(value="institute",required=false) String institute

				  				  ){
		Map<String, Object> params = new HashMap<>();
		params.put("page",page);
		params.put("limit",limit);
		params.put("sidx",sidx);
		params.put("order",order);

		if(name != null){
			params.put("name",name);
		}
		if(areaId != null){
			params.put("areaId",areaId);
		}
		if(deptId != null){
			params.put("deptId",deptId);
		}

		if(institute != null){
			params.put("institute",institute);
		}
		//只有超级管理员，才能查看所有管理员列表
		if(!getUserId().equals(Constant.SUPER_ADMIN)){
			params.put("createUserId", getUserId());
		}
		
		//查询列表数据
		Query query = new Query(params);
		List<SysUserEntity> userList = sysUserService.queryList(query);
		int total = sysUserService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 获取登录的用户信息
	 */
	@RequestMapping(value="/info",method=RequestMethod.GET)
	@ApiOperation(value="获取当前登录用户信息", notes="获取当前登录用户信息")
	public R info(){
		return R.ok().put("user", getUser());
	}
	
	/**
	 * 修改登录用户密码
	 */
	@SysLog("修改密码")
	@RequestMapping(value="/password",method=RequestMethod.PUT)
	@ApiOperation(value="修改登录用户密码", notes="修改登录用户密码")
	public R password(String password, String newPassword){
		Assert.isBlank(newPassword, "新密码不为能空");

		//sha256加密
		password = new Sha256Hash(password, getUser().getSalt()).toHex();
		//sha256加密
		newPassword = new Sha256Hash(newPassword, getUser().getSalt()).toHex();

		//更新密码
		int count = sysUserService.updatePassword(getUserId(), password, newPassword);
		if(count == 0){
			throw new RRException(210,"原密码不正确");
		}
		
		return R.ok();
	}



	/**
	 * admin重置用户密码
	 */
	@SysLog("重置密码")
	@RequestMapping(value="/resetpassword",method=RequestMethod.PUT)
	@ApiOperation(value="admin重置用户密码", notes="admin重置用户密码")
	public R resetpassword(String userId){

		//sha256加密
		String	newPassword = new Sha256Hash("123456", getUser().getSalt()).toHex();

		//更新密码
		int count = sysUserService.updatePassword(userId,sysUserService.queryObject(userId).getPassword(), newPassword);
		return R.ok();
	}
	
	/**
	 * 用户信息
	 */
	@RequestMapping(value="/info/{userId}",method=RequestMethod.GET)
	@RequiresPermissions("用户管理:查看")
	@ApiOperation(value="获取用户信息", notes="获取用户信息")
	public R info(@PathVariable("userId") String userId){
		SysUserEntity user = sysUserService.queryObject(userId);
		
		//获取用户所属的角色列表
		List<String> roleIdList = sysUserRoleService.queryRoleIdList(userId);
		user.setRoleIdList(StringUtils.strip(roleIdList.toString(),"[]"));

		
		return R.ok().put("user", user);
	}
	
	/**
	 * 保存用户
	 */
	@SysLog("保存用户")
	@RequestMapping(value="/",method=RequestMethod.POST)
	@RequiresPermissions("用户管理:管理")
	@ApiOperation(value="保存用户信息", notes="保存用户信息")
	public R save(@RequestBody SysUserEntity user){
		verifyForm(user);
		user.setCreateUserId(getUserId());
		sysUserService.save(user);
		return R.ok();
	}
	
	/**
	 * 修改用户
	 */
	@SysLog("修改用户")
	@RequestMapping(value="/",method=RequestMethod.PUT)
	@RequiresPermissions("用户管理:管理")
	@ApiOperation(value="修改用户信息", notes="修改用户信息")
	public R update(@RequestBody SysUserEntity user){
		verifyForm(user);
		user.setCreateUserId(getUserId());
		sysUserService.update(user);
		return R.ok();
	}
	/**
	 * 删除用户
	 */
	@SysLog("删除用户")
	@RequestMapping(value="/{ids}",method=RequestMethod.DELETE)
	@RequiresPermissions("用户管理:管理")
	@ApiOperation(value="删除用户信息", notes="删除用户信息")
	public R delete(@PathVariable("ids") String ids){
		String[] strings = ids.split(",");
		if(ArrayUtils.contains(strings, "1")){
			throw new RRException(200,"系统管理员不能删除");
		}
		
		if(ArrayUtils.contains(strings, getUserId())){
			throw new RRException(200,"当前用户不能删除");
		}
		for(int i=0;i<strings.length; i++){
			sysUserService.delete(strings[i]);
		}

		return R.ok();
	}



	private void verifyForm(SysUserEntity user) {
		if(sysUserService.queryByUserName(user.getUsername()) !=null){
			throw new RRException(240,"登录名重复");
		}
		if (StringUtils.isBlank(user.getName())) {
			throw new RRException(270, "姓名不能为空");

		}
		if (StringUtils.isBlank(user.getUsername())) {
			throw new RRException(270, "用户名不能为空");
		}
		if(StringUtils.isBlank(user.getOrdernum())){
			throw new RRException(270,"排序号不能为空");
		}
	}
}