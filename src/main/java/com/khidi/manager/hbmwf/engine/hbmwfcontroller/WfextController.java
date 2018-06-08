/**   
* @Title: WfextController.java 
* @Package com.khidi.manager.hbm.engine.hbmwfcontroller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年12月1日 下午1:44:12 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.hbmwfcontroller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.khidi.manager.hbmwf.engine.domain.ext.HbmentcfgDept;
import com.khidi.manager.hbmwf.engine.domain.ext.HbmentcfgRole;
import com.khidi.manager.hbmwf.engine.domain.ext.HbmentcfgUser;
import com.khidi.manager.hbmwf.engine.hbmwfservice.WfextService;
import com.khidi.manager.hbmwf.engine.wfutil.HbmentAjaxIo;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfAjaxIo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Administrator
 *
 */
@Api(value = "API - HBM  WF 流程扩展API", description = "HBM  WF 流程扩展API")
@RestController
@RequestMapping(value = "/wfext")
public class WfextController {
	@Autowired
	private WfextService wfExtService;

	@ApiOperation(value = "读取配置的用户信息", notes = "读取配置的用户信息")
	@RequestMapping(value = "/queryUserInfo", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo queryUserInfo() throws SQLException {
		List<HbmentcfgUser> rtn0 = wfExtService.GetCfgUserinfos();
		//
		return HbmwfAjaxIo.GetReturn("1", "查询成功", rtn0);
	}

	@ApiOperation(value = "读取配置的部门信息", notes = "读取配置的部门信息")
	@RequestMapping(value = "/queryDeptInfo", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo queryDeptInfo() throws SQLException {
		List<HbmentcfgDept> rtn0 = wfExtService.GetCfgDeptinfos();
		return HbmwfAjaxIo.GetReturn("1", "查询成功", rtn0);
	}

	@ApiOperation(value = "读取配置的角色信息", notes = "读取配置的角色信息")
	@RequestMapping(value = "/queryRoleInfo", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo queryRoleInfo() throws SQLException {
		List<HbmentcfgRole> rtn0 = wfExtService.GetCfgRoleinfos();
		//
		return HbmwfAjaxIo.GetReturn("1", "查询成功", rtn0);
	}

	// 根据部门编号查询用户
	@ApiOperation(value = "根据部门编号查询用户", notes = "根据部门编号查询用户")
	@RequestMapping(value = "/queryUserInfoByDeptid", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo queryUserInfoByDeptid(@ApiParam("deptid") @RequestParam String deptid) throws SQLException {
		List<HbmentcfgUser> rtn0 = wfExtService.GetCfgUserInfos(deptid);
		//
		return HbmwfAjaxIo.GetReturn("1", "查询成功", rtn0);
	}

	// 根据部门编号 和 用户名 查用户
	@ApiOperation(value = "根据部门编号 和  用户名查询用户", notes = "根据部门编号 和  用户名查询用户")
	@RequestMapping(value = "/queryUserInfoByDeptidAndUesrName", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo queryUserInfoByDeptidAndUesrName(@ApiParam("deptid") @RequestParam String deptid,
			@ApiParam("username") @RequestParam String username) throws SQLException {
		List<HbmentcfgUser> rtn0 = wfExtService.QueryUserInfos(deptid, username);
		//
		return HbmwfAjaxIo.GetReturn("1", "查询成功", rtn0);
	}
}
