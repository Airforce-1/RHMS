/**   
* @Title: WfAbsService.java 
* @Package com.khidi.manager.hbm.enginext.Service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年12月4日 下午6:06:34 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.hbmwfservice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.khidi.manager.hbmwf.engine.dao.WfAbsDao;
import com.khidi.manager.hbmwf.engine.dao.WfDynamicDao;
import com.khidi.manager.hbmwf.engine.domain.ext.EnumWfReceiverType;
import com.khidi.manager.hbmwf.engine.domain.ext.HbmentcfgDept;
import com.khidi.manager.hbmwf.engine.domain.ext.HbmentcfgRole;
import com.khidi.manager.hbmwf.engine.domain.ext.HbmentcfgUser;
import com.khidi.manager.hbmwf.engine.domain.ext.HbmentextWfReceiver;
import com.khidi.manager.hbmwf.engine.wfobj.uiFlow.HbmentAbsForui;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.hbmwf.enginext.cfg.WfCurrentSession;
import com.khidi.manager.hbmwf.enginext.cfg.receiver.WfDeptCfg;
import com.khidi.manager.hbmwf.enginext.cfg.receiver.WfRoleCfg;
import com.khidi.manager.hbmwf.enginext.cfg.receiver.WfUserCfg;

/**
 * @author Administrator
 *
 */
@Component
@Qualifier("WfabsService")
public class WfabsService {
	@Autowired
	private WfAbsDao wfAbsDao; // 工作流接收者DAO

	@Autowired
	private WfDynamicDao wfDynamicDao; // 工作流Dynamic DAO

	// 获取接收者信息(为前端显示)
	public String GetAbsInfo(String jsonAbs) throws JSONException, SQLException {
		String rtn = "";
		JSONArray jsonArr = new JSONArray(jsonAbs);
		for (int i = 0; i < jsonArr.length(); i++) {
			String lpJson = jsonArr.getString(i);
			JSONObject jsonObj = new JSONObject(lpJson);
			//
			String lpAbsType = jsonObj.getString("ctype");
			String lpTheId = jsonObj.getString("cid");
			String lpAttId0 = jsonObj.getString("attid0");
			String lpAttId1 = jsonObj.getString("attid1");
			//
			HbmentextWfReceiver lpUnknownReceiver = new HbmentextWfReceiver();
			switch (lpAbsType) {
			case "EM":
				lpUnknownReceiver.setDeptId(lpAttId0);
				lpUnknownReceiver.setReceiverType(EnumWfReceiverType.EM);
				lpUnknownReceiver.setUserId(lpTheId);
				break;
			case "RO":
				lpUnknownReceiver.setReceiverType(EnumWfReceiverType.RO);
				lpUnknownReceiver.setRoleId(lpTheId);
				break;
			case "DER":
				lpUnknownReceiver.setDeptRoleId(lpTheId);
				lpUnknownReceiver.setDeptId(lpAttId0);
				lpUnknownReceiver.setReceiverType(EnumWfReceiverType.DER);
				break;
			case "DE":
				lpUnknownReceiver.setDeptId(lpTheId);
				lpUnknownReceiver.setReceiverType(EnumWfReceiverType.DE);
				break;
			default:
				lpUnknownReceiver = null;
				break;
			}
			HbmentextWfReceiver rtn0 = wfAbsDao.GetAbsReceiver(lpUnknownReceiver);
			//
			if (rtn0 != null) {
				rtn += rtn0.getId() + ",";
			}
		}
		//
		if (rtn.endsWith(",")) {
			rtn = rtn.substring(0, rtn.length() - 1);
		}
		return rtn;
	}
	
	// 获取接收者信息
	public HbmentextWfReceiver GetAbsInfo(HbmentextWfReceiver unknownReceiver) throws SQLException
	{
		return wfAbsDao.GetAbsReceiver(unknownReceiver);
	}

	// 获取接收者(为UI提供)
	public List<HbmentAbsForui> GetAbsInfoForUi(String absIds) throws NumberFormatException, SQLException {
		List<HbmentAbsForui> rtn = new ArrayList<HbmentAbsForui>();
		String[] absIdsArr = absIds.split(",");
		//
		for (String lpAbsId : absIdsArr) {
			HbmentextWfReceiver lpRtn = wfAbsDao.GetAbsReceiver(Integer.valueOf(lpAbsId));
			if (lpRtn != null) {
				String lpStrRecType = lpRtn.getReceiverType().toString();
				HbmentAbsForui lpRtn0 = new HbmentAbsForui();
				String lpCid = "";
				String lpAttId0 = "";
				String lpAttId1 = "";
				switch (lpStrRecType) {
				case "EM":
					lpCid = lpRtn.getUserId();
					lpAttId0 = lpRtn.getDeptId();
					break;
				case "RO":
					lpCid = lpRtn.getRoleId();
					break;
				case "DER":
					lpCid = lpRtn.getDeptRoleId();
					lpAttId0 = lpRtn.getDeptId();
					break;
				case "DE":
					lpCid = lpRtn.getDeptId();
					break;
				}
				lpRtn0.setCid(lpCid);
				lpRtn0.setCname(QueryAbsName(lpRtn));
				lpRtn0.setAttid0(lpAttId0);
				lpRtn0.setAttid1(lpAttId1);
				lpRtn0.setCtype(lpStrRecType);
				//
				rtn.add(lpRtn0);
			}
		}
		return rtn;
	}

	// 读取 接收者 （业务）名称
	private String GetCfgName(Object obj) {
		if (obj == null) {
			return "未知";
		}
		if (obj instanceof HbmentcfgUser) {
			return ((HbmentcfgUser) obj).getUserName();
		}
		if (obj instanceof HbmentcfgDept) {
			return ((HbmentcfgDept) obj).getDeptName();
		}
		if (obj instanceof HbmentcfgRole) {
			return ((HbmentcfgRole) obj).getRoleName();
		}
		return "";
	}

	// 查询接收者名称
	private String QueryAbsName(HbmentextWfReceiver receiver) throws SQLException {
		if (receiver == null) {
			return "未知2";
		}
		String recType = receiver.getReceiverType().toString();
		WfUserCfg userCfg = HbmwfUtil.GetUserCfg();
		WfDeptCfg deptCfg = HbmwfUtil.GetDeptCfg();
		WfRoleCfg roleCfg = HbmwfUtil.GetRoleCfg();
		//
		HbmentcfgUser cfgUser = null;
		HbmentcfgDept cfgDept = null;
		HbmentcfgRole cfgRole = null;
		switch (recType) {
		case "EM":
			cfgUser = wfDynamicDao.GetUserInfo(userCfg, deptCfg, receiver.getUserId());
			cfgDept = wfDynamicDao.GetDeptInfo(deptCfg, receiver.getDeptId());

			String userName = GetCfgName(cfgUser);
			String deptName = GetCfgName(cfgDept);
			return userName + "(" + deptName + ")";
		case "RO":
			cfgRole = wfDynamicDao.GetRoleInfo(roleCfg, receiver.getRoleId());

			return GetCfgName(cfgRole);
		case "DE":
			cfgDept = wfDynamicDao.GetDeptInfo(deptCfg, receiver.getDeptId());
			return GetCfgName(cfgDept);
		case "DER":
			cfgDept = wfDynamicDao.GetDeptInfo(deptCfg, receiver.getDeptId());
			cfgRole = wfDynamicDao.GetRoleInfo(roleCfg, receiver.getRoleId());
			String roleName1 = GetCfgName(cfgRole);
			String deptName1 = GetCfgName(cfgDept);
			return roleName1 + "(" + deptName1 + ")";
		default:
			break;
		}

		return "未知1";
	}


	// 读取当前用户的相关接收者信息
	public List<HbmentextWfReceiver> GetCurReleatedReceiverInfo()
	{
		List<HbmentextWfReceiver> rtn = new ArrayList<HbmentextWfReceiver>();
		//
		String deptId = WfCurrentSession.GetDeptId();
		String userId = WfCurrentSession.GetUserId();
		List<String> roleIds = WfCurrentSession.GetUserRoles();
		//
		HbmentextWfReceiver unAbs01 = new HbmentextWfReceiver();
		unAbs01.setDeptId(deptId);
		unAbs01.setReceiverType(EnumWfReceiverType.DE);
		rtn.add(unAbs01);
		//
		unAbs01 = new HbmentextWfReceiver();
		unAbs01.setDeptId(deptId);
		unAbs01.setUserId(userId);
		unAbs01.setReceiverType(EnumWfReceiverType.EM);
		//
		rtn.add(unAbs01);
		//
		for(String roleId : roleIds)
		{
			unAbs01 = new HbmentextWfReceiver();
			unAbs01.setReceiverType(EnumWfReceiverType.RO);
			unAbs01.setRoleId(roleId);
			rtn.add(unAbs01);
		}
		//
		return rtn;
	}
}
