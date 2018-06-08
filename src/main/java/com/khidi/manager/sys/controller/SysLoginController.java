package com.khidi.manager.sys.controller;
import com.khidi.common.utils.R;
import com.khidi.manager.sys.service.SysUserService;
import com.khidi.manager.sys.entity.SysUserEntity;
import com.khidi.manager.sys.service.SysUserTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.Map;
/**
 * 登录相关
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017年11月10日 下午1:15:31
 */
@RestController
@Api(value="登录", description="用户登录")
public class SysLoginController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserTokenService sysUserTokenService;

	/**
	 * 登录
	 */
	@RequestMapping(value = "/sys/login", method = RequestMethod.GET)
	@ApiOperation(value="用户登录", notes="用户登录")
	public Map<String, Object> login(String username, String password)throws IOException {
		//用户信息
		SysUserEntity user = sysUserService.queryByUserName(username);

		//账号不存在、密码错误
		if(user == null || !user.getPassword().equals(new Sha256Hash(password, user.getSalt()).toHex())) {
			return R.error("账号或密码不正确");
		}

		//账号锁定
		if(user.getStatus() == 0){
			return R.error("账号已被锁定,请联系管理员");
		}

		//生成token，并保存到数据库
		R r = sysUserTokenService.createToken(user.getUserId());
		return r;
	}
	
}
