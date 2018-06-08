/**   
* @Title: WfInternalController.java 
* @Package com.khidi.manager.hbmwf.engine.hbmwfcontroller.internal 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年12月16日 下午4:52:53 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.hbmwfcontroller.internal;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.khidi.manager.hbmwf.engine.domain.HbmentWf;
import com.khidi.manager.hbmwf.engine.domain.HbmentWftmpl;
import com.khidi.manager.hbmwf.engine.domain.ext.HbmentextWfReceiver;
import com.khidi.manager.hbmwf.engine.hbmwfservice.internalapi.WfInternalApi;
import com.khidi.manager.hbmwf.engine.wfutil.HbmentAjaxIo;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfAjaxIo;
import com.khidi.manager.hbmwf.enginext.domain.HbmentFormHandle;
import com.khidi.manager.hbmwf.engine.hbmwfservice.WfabsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Administrator
 *
 */
@Api(value = "API - HBMWF 内部API", description = "HBMWF 内部API")
@RestController
@RequestMapping(value = "/wfapply")
public class WfApplyController {
	@Autowired
	private WfInternalApi wfInternalApi;
	
	@Autowired
	private WfabsService wfAbsService;

	//
	@ApiOperation(value = "获取所有流程模板", notes = "获取所有流程模板")
	@RequestMapping(value = "/queryWfImpl", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo queryWfImpl(@ApiParam("bfld0") @RequestParam String bfld0) throws Exception {
		List<HbmentWftmpl> rtn0 = wfInternalApi.QueryWfTmpl(bfld0);
		//
		return HbmwfAjaxIo.GetReturn("1", "查询操作结束", rtn0, null);
	}

	//
	@ApiOperation(value = "流程绑定表单", notes = "流程绑定表单")
	@RequestMapping(value = "/wfBindForm", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo WfBindForm(@ApiParam("formType") @RequestParam String formType,
			@ApiParam("formId") @RequestParam String formId, @ApiParam("wfTmplId") @RequestParam int wfTmplId)
					throws SQLException {
		System.out.println("formId:" + formId);
		HbmentWf rtn0 = wfInternalApi.WfBindForm(formType, formId, wfTmplId);
		//
		return HbmwfAjaxIo.GetReturn("1", "流程绑定表单结束", rtn0, null);
	}

	@ApiOperation(value = "启动流程", notes = "启动流程")
	@RequestMapping(value = "/startWf", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo StartWf(@ApiParam("formType") @RequestParam String formType,
			@ApiParam("formId") @RequestParam String formId) {
		return wfInternalApi.StartWf(formType, formId);
	}

	@ApiOperation(value = "流程审批", notes = "流程审批")
	@RequestMapping(value = "/veriWf", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo VeriWf(@ApiParam("veriResult") @RequestParam String veriResult,
			@ApiParam("veriDesc") @RequestParam String veriDesc, @ApiParam("handleId") @RequestParam int handleId) {
		return wfInternalApi.Veri(handleId, veriResult.equals("1") ? true : false, veriDesc);
	}

	@ApiOperation(value = "读取特定表单Handles", notes = "读取特定表单Handles")
	@RequestMapping(value = "/getSpecialHandles", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo GetSpecialHandles(@ApiParam("formId") @RequestParam String formId,
			@ApiParam("formType") @RequestParam String formType,
			@ApiParam("receiverId") @RequestParam String receiverId) throws SQLException {
		return wfInternalApi.getFormHandlesByReceiverId(formId, formType, receiverId);
		//
	}
	
	@ApiOperation(value = "读取当前用户的指定表单的 任务", notes = "读取当前用户的指定表单的 任务")
	@RequestMapping(value = "/getCurHandles", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo GetCurHandles(@ApiParam("formId") @RequestParam String formId,
			@ApiParam("formType") @RequestParam String formType) throws SQLException {
		
		List<HbmentextWfReceiver> receivers = wfAbsService.GetCurReleatedReceiverInfo();
		String rtn = "";
		for(HbmentextWfReceiver lpReceiver : receivers)
		{
			rtn += lpReceiver.getId() + ",";
		}
		if(rtn.endsWith(","))
		{
			rtn = rtn.substring(0, rtn.length() - 1);
		}
		return wfInternalApi.getCurFormHandles(formId, formType, rtn);
	}
}
