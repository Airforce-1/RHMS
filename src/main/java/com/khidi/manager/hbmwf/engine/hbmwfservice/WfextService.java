/**   
* @Title: WfextService.java 
* @Package com.khidi.manager.hbm.engine.hbmwfservice 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年12月1日 下午1:45:38 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.hbmwfservice;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.khidi.manager.hbmwf.engine.dao.WfDynamicDao;
import com.khidi.manager.hbmwf.engine.domain.ext.HbmentcfgDept;
import com.khidi.manager.hbmwf.engine.domain.ext.HbmentcfgRole;
import com.khidi.manager.hbmwf.engine.domain.ext.HbmentcfgUser;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;

/**
 * @author Administrator
 *
 */
@Component
@Qualifier("WfextService")
public class WfextService {
	@Autowired
	private WfDynamicDao wfDynamicDao;  // 工作流 WF DAO
	
	// 查询（流程用）配置用户信息
	public List<HbmentcfgUser> GetCfgUserinfos() throws SQLException
	{
		return wfDynamicDao.QueryUserInfo(HbmwfUtil.GetUserCfg(),HbmwfUtil.GetDeptCfg());
	}
	
	public List<HbmentcfgUser> GetCfgUserInfos(String deptId) throws SQLException
	{
		return wfDynamicDao.QueryUserInfo(HbmwfUtil.GetUserCfg(),HbmwfUtil.GetDeptCfg(),deptId);
	}
	
	public List<HbmentcfgUser> QueryUserInfos(String deptId,String userName) throws SQLException
	{
		return wfDynamicDao.QueryUserInfo(HbmwfUtil.GetUserCfg(),HbmwfUtil.GetDeptCfg(),deptId,userName);
	}
	
	// 查询（流程用）配置用户信息集合
	public List<HbmentcfgDept> GetCfgDeptinfos() throws SQLException
	{
		return wfDynamicDao.QueryDeptInfo(HbmwfUtil.GetDeptCfg());		
	}
	
	// 查询（流程用）配置角色信息
	public List<HbmentcfgRole> GetCfgRoleinfos() throws SQLException
	{
		return wfDynamicDao.QueryRoleInfo(HbmwfUtil.GetRoleCfg());
	}
}
