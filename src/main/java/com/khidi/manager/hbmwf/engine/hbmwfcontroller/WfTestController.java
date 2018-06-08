package com.khidi.manager.hbmwf.engine.hbmwfcontroller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.khidi.manager.hbmwf.engine.domain.HbmentWf;
import com.khidi.manager.hbmwf.engine.domain.HbmentWftmpl;
import com.khidi.manager.hbmwf.engine.domain.tst.HbmentForm1;
import com.khidi.manager.hbmwf.engine.hbmwfservice.WfService;
import com.khidi.manager.hbmwf.engine.hbmwfservice.WfTestService;
import com.khidi.manager.hbmwf.engine.hbmwfservice.WfTmplService;
import com.khidi.manager.hbmwf.engine.wfutil.HbmentAjaxIo;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfAjaxIo;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.hbmwf.enginext.cfg.WfCurrentSession;
import com.khidi.manager.hbmwf.enginext.cfg.form.EnumFormType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.spring.web.json.Json;

@Api(value = "API - HBM表单 流程测试(后台开发测试需要 ，暂时保留一段时间)", description = "HBM 表单 流程测试(后台开发测试需要 ，暂时保留一段时间)")
@RestController
@RequestMapping(value = "/wftst")
public class WfTestController {
	@Autowired
	private WfTestService wftestService;

	@Autowired
	private WfService wfService;

	@Autowired
	private WfTmplService wfTmplService;

	// @ApiOperation(value = "获取新ID ", notes = "获取新ID ")
	// @RequestMapping(value = "/wfNewId", method = { RequestMethod.GET,
	// RequestMethod.POST })
	// @ResponseBody
	// public Json wfNewId(String tableName) throws SQLException {
	// return new Json(wftestService.GetNewId(tableName));
	// }

	@ApiOperation(value = "新建测试表单1并绑定流程 ", notes = "新建测试表单1并绑定流程 ")
	@RequestMapping(value = "/newForm1", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo newForm1(@ApiParam("formwfnewJson") @RequestParam String formwfnewJson) throws Exception {
		// return new Json(wftestService.GetNewId(tableName));
		JSONObject jsonObj = new JSONObject(formwfnewJson);
		//
		JSONObject jsonFormInfo = jsonObj.getJSONObject("forminfo");
		JSONObject jsonFormCfg = jsonObj.getJSONObject("formcfg");
		//
		HbmentForm1 form1 = new HbmentForm1();
		form1.setContent(jsonFormInfo.getString("content"));
		form1.setId(0);
		form1.setKx(jsonFormInfo.getDouble("kx"));
		form1.setName(jsonFormInfo.getString("name"));
		form1.setState("NB");
		//
		HbmentForm1 rtn0 = wftestService.NewTestForm1(form1);
		//
		// 存流程
		HbmentWftmpl wfTmpl = wfTmplService._GetWfTmpl(jsonFormCfg.getInt("tmplid"));
		//
		HbmentWf wf = new HbmentWf();
		wf.setCreateDept(WfCurrentSession.GetDeptId());
		wf.setCreateTime(HbmwfUtil.NowDate());
		wf.setCreateUser(WfCurrentSession.GetUserId());
		wf.setFormId(String.valueOf(form1.getId()));
		wf.setFormType(EnumFormType.tstform1.toString()); // set form type
		wf.setId(0);
		wf.setLastUpdateDept(WfCurrentSession.GetDeptId());
		wf.setLastUpdateTime(new Date());
		wf.setLastUpdateUser(WfCurrentSession.GetUserId());
		wf.setMemo(wfTmpl.getMemo());
		wf.setName("表单类型:" + EnumFormType.tstform1.toString() + ",表单《" + form1.getName() + "》的流程:" + wfTmpl.getName());
		wf.setWfTmplId(wfTmpl.getId());

		wf.setWfContent(wfTmpl.getTheContent());
		//
		HbmentWf rtn1 = wfService.NewWf(wf);
		//
		return HbmwfAjaxIo.GetReturn("1", "成功新建表单", rtn0, null);
	}

	@ApiOperation(value = "查询表单 ", notes = "查询表单 ")
	@RequestMapping(value = "/queryForm1", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo queryForm1() throws SQLException {
		List<HbmentForm1> rtn0 = wftestService.QueryTstForm1();

		return HbmwfAjaxIo.GetReturn("1", "查询执行完毕", rtn0, null);
	}

	@ApiOperation(value = "查询表单以及流程配置信息", notes = "查询表单以及流程配置信息")
	@RequestMapping(value = "/getForm1wf", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo getForm1wf(@ApiParam("id") @RequestParam int id) throws JSONException, SQLException {
		// JSONObject jsonObj = new JSONObject(formwfgetJson);
		//
		String formType = EnumFormType.tstform1.toString();
		//
		HbmentForm1 rtn0 = wftestService.GetTestForm1(id);
		HbmentWf rtn1 = wfService.GetWfbaseInfo(String.valueOf(id), formType);
		//
		return HbmwfAjaxIo.GetReturn("1", "查询表单流程完毕", rtn0, rtn1);
	}

	@ApiOperation(value = "编辑测试表单1并绑定流程 ", notes = "编辑测试表单1并绑定流程 ")
	@RequestMapping(value = "/editForm1", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo editForm1(@ApiParam("formwfnewJson") @RequestParam String formwfeditJson) throws Exception {
		// return new Json(wftestService.GetNewId(tableName));
		JSONObject jsonObj = new JSONObject(formwfeditJson);
		//
		JSONObject jsonFormInfo = jsonObj.getJSONObject("forminfo");
		JSONObject jsonFormCfg = jsonObj.getJSONObject("formcfg");
		int formId = jsonFormInfo.getInt("id");
		int tmplId = jsonFormCfg.getInt("tmplid");
		//
		HbmentForm1 form1 = wftestService.GetTestForm1(formId);
		//
		form1.setContent(jsonFormInfo.getString("content"));
		form1.setKx(jsonFormInfo.getDouble("kx"));
		form1.setName(jsonFormInfo.getString("name"));
		form1.setState("NB");
		//
		HbmentWftmpl wfTmpl = wfTmplService._GetWfTmpl(jsonFormCfg.getInt("tmplid"));
		//
		HbmentForm1 rtn0 = wftestService.EditTestForm1(form1);
		HbmentWf wf = wfService.GetWfbaseInfo(String.valueOf(formId), EnumFormType.tstform1.toString());
		if (wf != null) {
			if (wf.getWfTmplId() != tmplId) {
				wfService.DropWf(wf.getId());
				// new
				wf = new HbmentWf();
				wf.setCreateDept(WfCurrentSession.GetDeptId());
				wf.setCreateTime(HbmwfUtil.NowDate());
				wf.setCreateUser(WfCurrentSession.GetUserId());
				wf.setFormId(String.valueOf(form1.getId()));
				wf.setFormType(EnumFormType.tstform1.toString()); // set form
																	// type
				wf.setId(0);
				wf.setLastUpdateDept(WfCurrentSession.GetDeptId());
				wf.setLastUpdateTime(new Date());
				wf.setLastUpdateUser(WfCurrentSession.GetUserId());
				wf.setMemo(wfTmpl.getMemo());
				wf.setName("表单类型:" + EnumFormType.tstform1.toString() + ",表单《" + form1.getName() + "》的流程:"
						+ wfTmpl.getName());
				wf.setWfTmplId(wfTmpl.getId());

				wf.setWfContent(wfTmpl.getTheContent());
				//
				HbmentWf rtn1 = wfService.NewWf(wf);
			} else {
				// do nothing
				// 流程的修改用单独入口
			}
		} else {
			// new
			wf = new HbmentWf();
			wf.setCreateDept(WfCurrentSession.GetDeptId());
			wf.setCreateTime(HbmwfUtil.NowDate());
			wf.setCreateUser(WfCurrentSession.GetUserId());
			wf.setFormId(String.valueOf(form1.getId()));
			wf.setFormType(EnumFormType.tstform1.toString()); // set form type
			wf.setId(0);
			wf.setLastUpdateDept(WfCurrentSession.GetDeptId());
			wf.setLastUpdateTime(new Date());
			wf.setLastUpdateUser(WfCurrentSession.GetUserId());
			wf.setMemo(wfTmpl.getMemo());
			wf.setName(
					"表单类型:" + EnumFormType.tstform1.toString() + ",表单《" + form1.getName() + "》的流程:" + wfTmpl.getName());
			wf.setWfTmplId(wfTmpl.getId());
			//
			wf.setWfContent(wfTmpl.getTheContent());
			//
			HbmentWf rtn1 = wfService.NewWf(wf);
		}
		//
		return HbmwfAjaxIo.GetReturn("1", "成功修改表单", rtn0, null);
	}
}
