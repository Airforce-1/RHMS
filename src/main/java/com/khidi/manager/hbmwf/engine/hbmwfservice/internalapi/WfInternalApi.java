/**   
* @Title: WfInternalApi.java 
* @Package com.khidi.manager.hbmwf.engine.hbmwfservice.internalapi 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年12月16日 下午3:37:13 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.hbmwfservice.internalapi;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.khidi.manager.hbmwf.engine.dao.WfDao;
import com.khidi.manager.hbmwf.engine.dao.WfFormHandleDao;
import com.khidi.manager.hbmwf.engine.dao.WfHandleDao;
import com.khidi.manager.hbmwf.engine.dao.WfTmplDao;
import com.khidi.manager.hbmwf.engine.domain.HbmentWf;
import com.khidi.manager.hbmwf.engine.domain.HbmentWftmpl;
import com.khidi.manager.hbmwf.engine.wfutil.HbmentAjaxIo;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfAjaxIo;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.hbmwf.enginext.Service.WfdrivingService;
import com.khidi.manager.hbmwf.enginext.cfg.WfCurrentSession;
import com.khidi.manager.hbmwf.enginext.cfg.form.EnumFormType;
import com.khidi.manager.hbmwf.enginext.domain.HbmentFormHandle;

/**
 * @author Administrator
 *
 */
@Component
@Qualifier("WfInternalApi")
public class WfInternalApi implements IWfInternalApi {
	@Autowired
	private WfDao wfDao; // 工作流 DAO

	@Autowired
	private WfTmplDao wfTmplDao; // 工作流模板 DAO
	
	@Autowired
	private WfFormHandleDao wfFormHandleDao;

	private WfdrivingService wfDrivingService;

	// 对外API 流程绑定表单(新增 编辑)
	public HbmentWf WfBindForm(String formType, String formId, int wfTmplId) throws SQLException {
		// 存流程
		HbmentWftmpl wfTmpl = wfTmplDao.GetWftmpl(wfTmplId);
		//
		HbmentWf wf = wfDao.GetWf(formId, formType, false);
		if (wf == null) {
			wf = new HbmentWf();
			wf.setCreateDept(WfCurrentSession.GetDeptId());
			wf.setCreateTime(HbmwfUtil.NowDate());
			wf.setCreateUser(WfCurrentSession.GetUserId());
			wf.setFormId(formId);
			wf.setFormType(formType);
			wf.setId(0);
			wf.setLastUpdateDept(WfCurrentSession.GetDeptId());
			wf.setLastUpdateTime(new Date());
			wf.setLastUpdateUser(WfCurrentSession.GetUserId());
			wf.setMemo(wfTmpl.getMemo());
			wf.setName("表单类型:" + formType + ",表单《" + formId + "》的流程:" + wfTmpl.getName());
			wf.setWfTmplId(wfTmpl.getId());
			wf.setWfContent(wfTmpl.getTheContent());
			//
			HbmentWf rtn = wfDao.NewWf(wf);

			rtn.setWfContent("");

			return rtn;
		} else {
			if (wf.getWfTmplId() != wfTmplId) {
				wfDao.DropWf(wf.getId());
				// new
				wf = new HbmentWf();
				wf.setCreateDept(WfCurrentSession.GetDeptId());
				wf.setCreateTime(HbmwfUtil.NowDate());
				wf.setCreateUser(WfCurrentSession.GetUserId());
				wf.setFormId(String.valueOf(formId));
				wf.setFormType(formType); // set form type
				wf.setId(0);
				wf.setLastUpdateDept(WfCurrentSession.GetDeptId());
				wf.setLastUpdateTime(new Date());
				wf.setLastUpdateUser(WfCurrentSession.GetUserId());
				wf.setMemo(wfTmpl.getMemo());
				wf.setName("表单类型:" + formType + ",表单《" + formId + "》的流程:" + wfTmpl.getName());
				wf.setWfTmplId(wfTmpl.getId());

				wf.setWfContent(wfTmpl.getTheContent());
				//
				HbmentWf rtn1 = wfDao.NewWf(wf);
				rtn1.setWfContent("");
				//
				return rtn1;
			} else {
				// do nothing
				// 流程的修改用单独入口
				wf.setWfContent("");
				return wf;
			}
		}
	}

	// 对外API 审批流程
	public HbmentAjaxIo Veri(int handleId, boolean veriResult, String veriDesc) {
		try {
			wfDrivingService = new WfdrivingService();
			wfDrivingService.InitByWfHandle(handleId);
			wfDrivingService.Verification(veriResult, veriDesc);
			return HbmwfAjaxIo.GetReturn("1", "流程审批操作结束", null, null);
		} catch (Exception e) {
			e.printStackTrace();
			return HbmwfAjaxIo.GetReturn("0", e.getMessage(), null, null);
		}
	}

	// 启动流程
	public HbmentAjaxIo StartWf(String formType, String formId) {
		try {
			wfDrivingService = new WfdrivingService();
			wfDrivingService.InitByFormInfo(formId, formType);
			wfDrivingService.StartVeriWf();
			return HbmwfAjaxIo.GetReturn("1", "流程启动操作结束", null, null);
		} catch (Exception e) {
			e.printStackTrace();
			return HbmwfAjaxIo.GetReturn("0", e.getMessage(), null, null);
		}
	}

	// 查询流程模板
	public List<HbmentWftmpl> QueryWfTmpl(String wfType) throws Exception {
		List<HbmentWftmpl> rtn = wfTmplDao.QueryWftmpl(false,wfType);
		//
		return rtn;
	}

	// 根据接收者获取表单处理任务
	public HbmentAjaxIo getFormHandlesByReceiverId(String formId,String formType,String receiverId) throws SQLException
	{
		List<HbmentFormHandle> rtn0 = wfFormHandleDao.GetSpecialFormHandles(formId, formType,receiverId);
		return HbmwfAjaxIo.GetReturn("1", "查询特定接收者任务结束", rtn0, null);
	}
	
	// 查询当前用户任务
	public HbmentAjaxIo getCurFormHandles(String formId,String formType,String absIds) throws SQLException
	{
		//
		List<HbmentFormHandle> rtn0 = wfFormHandleDao.GetCurFormHandles(formId, formType,absIds);
		//
		return HbmwfAjaxIo.GetReturn("1", "查询当前用户任务结束", rtn0, null);
	}
}
