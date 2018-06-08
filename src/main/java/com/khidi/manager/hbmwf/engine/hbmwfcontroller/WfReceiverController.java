/**   
* @Title: WfReceiverController.java 
* @Package com.khidi.manager.hbm.engine.hbmwfcontroller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年12月5日 上午11:20:42 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.hbmwfcontroller;

import java.sql.SQLException;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.khidi.manager.hbmwf.engine.hbmwfservice.WfabsService;
import com.khidi.manager.hbmwf.engine.wfobj.uiFlow.HbmentAbsForui;
import com.khidi.manager.hbmwf.engine.wfutil.HbmentAjaxIo;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfAjaxIo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Administrator
 *
 */
@Api(value = "API - HBM  WF 接收者管理", description = "HBM  WF 接收者管理")
@RestController
@RequestMapping(value = "/wfreceiver")
public class WfReceiverController {
	@Autowired
	private WfabsService wfAbsService;
	
	
	@ApiOperation(value = "获取流程中的接收者", notes = "获取流程中的接收者")
	@RequestMapping(value = "/getAbsInfo", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo getAbsInfo(@ApiParam("absInfo") @RequestParam String absInfo) throws JSONException, SQLException
	{
		//
		String code = "1";
		String msg = "操作成功";
		//
		String rtn0 = wfAbsService.GetAbsInfo(absInfo);
		return HbmwfAjaxIo.GetReturn(code, msg, rtn0);
	}
	
	@ApiOperation(value = "获取接收者的显示结构信息", notes = "获取接收者的显示结构信息")
	@RequestMapping(value = "/getAbsShowInfo", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo getAbsShowInfo(@ApiParam("absShowInfo") @RequestParam String absIds) throws JSONException, SQLException
	{
		//
		String code = "1";
		String msg = "操作成功";
		//
		List<HbmentAbsForui> rtn0 = wfAbsService.GetAbsInfoForUi(absIds);
		return HbmwfAjaxIo.GetReturn(code, msg, rtn0);
	}
	
	
}
