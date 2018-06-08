/**   
* @Title: WfTmplController.java 
* @Package com.khidi.manager.hbm.engine.hbmwfcontroller 
* @Description: TODO(流程模板管) 
* @author 王顺波
* @date 2017年11月20日 上午9:57:43 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.hbmwfcontroller;

import java.sql.SQLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.khidi.manager.hbmwf.engine.domain.HbmentWftmpl;
import com.khidi.manager.hbmwf.engine.domain.HbmentuiWftmpl;
import com.khidi.manager.hbmwf.engine.hbmwfservice.WfTmplService;
import com.khidi.manager.hbmwf.engine.hbmwfservice.WfabsService;
import com.khidi.manager.hbmwf.engine.wfobj.uiFlow.HbmwfuientWfNode;
import com.khidi.manager.hbmwf.engine.wfobj.uiFlow.HbmwfuientWfobj;
import com.khidi.manager.hbmwf.engine.wfutil.HbmXml;
import com.khidi.manager.hbmwf.engine.wfutil.HbmentAjaxIo;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfAjaxIo;
import com.khidi.manager.hbmwf.enginext.cfg.WfCurrentSession;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "API - HBM  WF 流程模板管理", description = "HBM  WF 流程模板管理")
@RestController
@RequestMapping(value = "/wftmpl")
public class WfTmplController {
	@Autowired
	private WfTmplService wfTmplService;

	@ApiOperation(value = "新建流程模板", notes = "新建流程模板")
	@RequestMapping(value = "/newWfTmpl", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo newWfTmpl(@RequestBody HbmentuiWftmpl hbmwfTmpl) throws Exception {
		// return new Json(wfwjTestService.GetJwTestResult(hbmcomplexentOne));
		HbmentWftmpl rtn0 = wfTmplService.NewWftmpl(hbmwfTmpl);
		return HbmwfAjaxIo.GetReturn("1", "成功新增流程模板", rtn0);
	}

	@ApiOperation(value = "编辑流程模板", notes = "编辑流程模板")
	@RequestMapping(value = "/editWfTmpl", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo editWfTmpl(@RequestBody HbmentuiWftmpl hbmwfTmpl) throws Exception {
		//
		//
		HbmentWftmpl rtn0 = wfTmplService.EditWftmpl(hbmwfTmpl);
		//

		return HbmwfAjaxIo.GetReturn("1", "成功编辑流程模板", rtn0);
	}

	@ApiOperation(value = "编辑模板基础信息测试", notes = "编辑模板基础信息测试")
	@RequestMapping(value = "/editWfTmplBase", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo editWfTmplBase(@RequestBody HbmentWftmpl hbmwfTmpl) throws Exception {
		//
		HbmentWftmpl rtn0 = wfTmplService.EditWftmplBase(hbmwfTmpl);
		//
		return HbmwfAjaxIo.GetReturn("1", "成功编辑流程模板", rtn0);
	}

	@ApiOperation(value = "删除流程模板", notes = "删除流程模板")
	@RequestMapping(value = "/deleteWfImpl", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo deleteWfImpl(@ApiParam("wfTmplId") @RequestParam int wfTmplId) throws SQLException {
		boolean rtn0 = wfTmplService.DeleteWftmpl(wfTmplId);
		//
		String code = rtn0 ? "0" : "1";
		String msg = rtn0 ? "操作失败" : "操作成功";
		//
		return HbmwfAjaxIo.GetReturn(code, msg, rtn0);
	}

	@ApiOperation(value = "获取所有流程模板", notes = "获取所有流程模板")
	@RequestMapping(value = "/queryWfImpl", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo queryWfImpl(@ApiParam("bfld0") @RequestParam String bfld0) throws Exception {
		List<HbmentWftmpl> rtn0 = wfTmplService.QueryWfTmpl(bfld0);
		//
		String code = "1";
		String msg = "操作成功";
		//
		return HbmwfAjaxIo.GetReturn(code, msg, rtn0);
	}

	@ApiOperation(value = "获取特定流程模板", notes = "获取特定流程模板")
	@RequestMapping(value = "/getWfImpl", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo getWfTmpl(@ApiParam("wfTmplId") @RequestParam int wfTmplId) throws Exception {
		HbmentWftmpl rtn0 = wfTmplService.GetWfTmpl(wfTmplId);
		//
		String code = "1";
		String msg = "操作成功";
		//
		return HbmwfAjaxIo.GetReturn(code, msg, rtn0);
	}

	@ApiOperation(value = "流程内容测试", notes = "流程内容测试")
	@RequestMapping(value = "/tstWftmplcontent", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String TestWfContent(@RequestBody HbmwfuientWfobj hbmuiWfobj) throws ParserConfigurationException {
		String rtn0 = HbmXml.GetXml(hbmuiWfobj);
		//
		return rtn0;
	}

	@ApiOperation(value = "获取节点的所有可回退节点", notes = "获取节点的所有可回退节点")
	@RequestMapping(value = "/previousNodes", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo getWfTmplPreviousNodes(@ApiParam("wfTmplId") @RequestParam int wfTmplId,
			@ApiParam("nodeId") @RequestParam String nodeId) throws Exception {
		HbmentWftmpl rtn0 = wfTmplService.GetWfTmpl(wfTmplId);
		int a = wfTmplId;
		String b = nodeId;
		//
		List<HbmwfuientWfNode> rtn1 = wfTmplService.GetPreviousNodes(String.valueOf(wfTmplId), nodeId);
		//
		return HbmwfAjaxIo.GetReturn("1", "查询结束", rtn1, null);
	}
}
