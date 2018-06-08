/**   
* @Title: WfController.java 
* @Package com.khidi.manager.hbm.engine.hbmwfcontroller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月22日 下午1:40:15 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.hbmwfcontroller;

import java.sql.SQLException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.khidi.manager.hbmwf.engine.domain.HbmentWf;
import com.khidi.manager.hbmwf.engine.domain.tst.HbmentNewForm;
import com.khidi.manager.hbmwf.engine.hbmwfservice.WfService;
import com.khidi.manager.hbmwf.engine.hbmwfservice.WfTestService;
import com.khidi.manager.hbmwf.engine.wfobj.uiFlow.HbmwfuientWfNode;
import com.khidi.manager.hbmwf.engine.wfutil.HbmentAjaxIo;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfAjaxIo;
import com.khidi.manager.hbmwf.enginext.Service.WfdrivingService;
import com.khidi.manager.hbmwf.enginext.cfg.WfCurrentSession;
import com.khidi.manager.hbmwf.enginext.domain.HbmentFormHandle;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Administrator
 *
 */
@Api(value = "API - HBM  WF 表单流程管理", description = "HBM  WF 表单流程管理")
@RestController
@RequestMapping(value = "/wf")
public class WfController {
	@Autowired
	private WfService wfService;

	// @Autowired
	private WfdrivingService wfDrivingService;

	@Autowired
	private WfTestService wfTestService;

	//
	@ApiOperation(value = "新建流程模板", notes = "新建流程模板")
	@RequestMapping(value = "/newWfAndForm", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo newWfAndForm(@RequestBody HbmentNewForm wfAndForm) throws SQLException {
		HbmentWf rtn0 = wfService.NewWfAndForm(wfAndForm);
		//
		return HbmwfAjaxIo.GetReturn("1", "成功创建流程", rtn0);
	}

	@ApiOperation(value = "读取form和流程", notes = "读取form和流程")
	@RequestMapping(value = "/getFormAndWf", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo getFormAndWf(@ApiParam("formId") @RequestParam String formId,
			@ApiParam("formType") @RequestParam String formType) throws Exception {
		Object[] rtn0 = wfService.GetFormAndWf(formId, formType);
		//
		return HbmwfAjaxIo.GetReturn("1", "获取表单流程成功", rtn0[0], rtn0[1]);
	}

	@ApiOperation(value = "读取流程", notes = "读取流程")
	@RequestMapping(value = "/getWf", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo getWf(@ApiParam("formId") @RequestParam String formId,
			@ApiParam("formType") @RequestParam String formType) throws Exception {
		Object rtn0 = wfService.GetWf(formId, formType);
		//
		return HbmwfAjaxIo.GetReturn("1", "获取表单流程成功", rtn0);
	}

	@ApiOperation(value = "启动流程", notes = "启动流程")
	@RequestMapping(value = "/startWf", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo startWf(@ApiParam("formId") @RequestParam String formId,
			@ApiParam("formType") @RequestParam String formType) throws Exception {
		wfDrivingService = new WfdrivingService();
		wfDrivingService.InitByFormInfo(formId, formType);
		wfDrivingService.StartVeriWf();
		return HbmwfAjaxIo.GetReturn("1", "流程启动操作结束", null, null);
	}

	@ApiOperation(value = "流程审批", notes = "流程审批")
	@RequestMapping(value = "/veriWf", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo veriWf(@ApiParam("veriResult") String veriResult, @ApiParam("veriDesc") String veriDesc,
			@ApiParam("handleId") @RequestParam int handleId) throws Exception {
		wfDrivingService = new WfdrivingService();
		wfDrivingService.InitByWfHandle(handleId);
		wfDrivingService.Verification(veriResult.equals("1") ? true : false, veriDesc);
		return HbmwfAjaxIo.GetReturn("1", "流程审批操作结束", null, null);
	}

	@ApiOperation(value = "流程审批(后端测试用)", notes = "流程审批(后端测试用)")
	@RequestMapping(value = "/veriWf0", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo veriWf0(@ApiParam("veriTstJson") String veriTstJson) throws Exception {
		JSONObject jsonPm = new JSONObject(veriTstJson);
		//
		String formId = jsonPm.getString("formid");
		String formType = jsonPm.getString("formtype");
		String nodeId = jsonPm.getString("nodeid");
		String veriResult = jsonPm.getString("veriresult");
		String veriDesc = jsonPm.getString("veridesc");
		//
		List<HbmentFormHandle> rtn0 = wfTestService.GetVeriHandlesForTest(formId, formType, nodeId);
		//
		//
		for (HbmentFormHandle lpFormHandle : rtn0) {
			wfDrivingService = new WfdrivingService();
			wfDrivingService.InitByWfHandle(lpFormHandle.getHandleId());
			wfDrivingService.Verification(veriResult.equals("1") ? true : false, veriDesc);
			break;
		}
		return HbmwfAjaxIo.GetReturn("1", "后端测试流程审批操作结束", null, null);
	}

	@ApiOperation(value = "查询节点的所有父节点", notes = "查询节点的所有父节点")
	@RequestMapping(value = "/getPreviousNodes", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo getPreviousNodes(@ApiParam("nodeJson") String nodeJson) throws Exception {
		JSONObject jsonPm = new JSONObject(nodeJson);
		//
		String formId = jsonPm.getString("formid");
		String formType = jsonPm.getString("formtype");
		String nodeId = jsonPm.getString("nodeid");
		//
		wfDrivingService = new WfdrivingService();
		wfDrivingService.InitByFormInfo(formId, formType);
		//
		List<HbmwfuientWfNode> rtn0 = wfDrivingService.GetPreviousNodes(nodeId);
		//
		return HbmwfAjaxIo.GetReturn("1", "查询结束", rtn0, null);
	}

	// @ApiOperation(value = "读取节点的父节点", notes = "读取节点的父节点")
	// @RequestMapping(value = "/queryPrevousNodes", method = {
	// RequestMethod.GET, RequestMethod.POST })
	// @ResponseBody
	// public HbmentAjaxIo getWfNodePreviousNodes(@ApiParam("jsonPm") String
	// jsonPm) {
	// return null;// TODO:
	// }
}
