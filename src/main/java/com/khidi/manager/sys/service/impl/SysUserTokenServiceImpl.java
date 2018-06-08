package com.khidi.manager.sys.service.impl;

import com.khidi.manager.sys.dao.SysUserTokenDao;
import com.khidi.manager.sys.entity.SysUserTokenEntity;
import com.khidi.manager.sys.oauth2.TokenGenerator;
import com.khidi.manager.sys.service.SysUserTokenService;
import com.khidi.manager.sys.service.SysUserService;
import com.khidi.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service("sysUserTokenService")
public class SysUserTokenServiceImpl implements SysUserTokenService {
	@Autowired
	private SysUserTokenDao sysUserTokenDao;
	@Autowired
	private SysUserService sysUserService;
	//12小时后过期
	private final static int EXPIRE = 3600 * 12;

	@Override
	public SysUserTokenEntity queryByUserId(String userId) {
		return sysUserTokenDao.queryByUserId(userId);
	}

	@Override
	public SysUserTokenEntity queryByToken(String token) {
		return sysUserTokenDao.queryByToken(token);
	}

	@Override
	public void save(SysUserTokenEntity token){
		sysUserTokenDao.save(token);
	}
	
	@Override
	public void update(SysUserTokenEntity token){
		sysUserTokenDao.update(token);
	}

	@Override
	public R createToken(String userId){
		//生成一个token
		String token = TokenGenerator.generateValue();
		//测试阶段，将token设置为用户名加123456789
		String token1 = new StringBuffer().append(sysUserService.queryObject(userId).getUsername()).append("123456789").toString();

		//当前时间
		Date now = new Date();
		//过期时间
		Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

		//判断是否生成过token
		SysUserTokenEntity tokenEntity = queryByUserId(userId);
		if(tokenEntity == null){
			tokenEntity = new SysUserTokenEntity();
			tokenEntity.setUserId(userId);
			tokenEntity.setToken(token1);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//保存token
			save(tokenEntity);
		}else{
			tokenEntity.setToken(token1);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//更新token
			update(tokenEntity);
		}

		R r = R.ok().put("token", token1).put("expire", EXPIRE);
		return r;
	}
}
