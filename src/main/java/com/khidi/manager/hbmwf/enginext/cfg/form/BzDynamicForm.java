/**   
* @Title: BzDynamicForm.java 
* @Package com.khidi.manager.hbm.enginext.cfg.form 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月23日 下午1:34:12 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.enginext.cfg.form;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.khidi.manager.hbmwf.engine.dao.WfDynamicDao;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.hbmwf.enginext.domain.HbmentDynamicForm;

/**
 * @author Administrator
 *
 */
public class BzDynamicForm {
	private static List<FormCfg> dynamicFormCfg;
	private static WfDynamicDao dynamicDao;
	static
	{
		dynamicDao = new WfDynamicDao();
	}
	
	private static void FillDynamicFormCfg()
	{
		dynamicFormCfg = new ArrayList<FormCfg>();
		FormCfg item = new FormCfg();
		item.setEnable(true);
		item.setFormTable("TABABC");
		item.setFormType("TSTFORMTYPE_VIRTUAL");
		item.setTableCfg(null);
		item.setPkFieldName("ID");
		item.setStateFieldName("STATE");
		dynamicFormCfg.add(item);
		//
		item = new FormCfg();
		item.setEnable(true);
		item.setFormTable("HBMTESTFORM1");
		item.setFormType("tstform1");
		item.setTableCfg(null);
		item.setPkFieldName("ID");
		item.setStateFieldName("STATE");
		dynamicFormCfg.add(item);
		//
		item = new FormCfg();
		item.setEnable(true);
		item.setFormTable("MEETING_M");
		item.setFormType("meetingform");
		item.setTableCfg(null);
		item.setPkFieldName("ID");
		item.setStateFieldName("ATTSTATE1");
		dynamicFormCfg.add(item);
	}
	
	public static FormCfg GetDynamicFormCfg(String formType)
	{
		if(dynamicFormCfg == null)
		{
			FillDynamicFormCfg();
		}
		for(FormCfg lpCfg : dynamicFormCfg)
		{
			if(lpCfg.getFormType().equals(formType))
			{
				return lpCfg;
			}
		}
		return null;
	}
	
	public static HbmentDynamicForm GetDynamicForm(String formId,String formType) throws SQLException
	{
		FormCfg formCfg = GetDynamicFormCfg(formType);
		//
		HbmentDynamicForm rtn = new HbmentDynamicForm();
		rtn.setFormId(formId);
		rtn.setFormType(formType);
		rtn.setFormCfg(formCfg);
		
		String formState = dynamicDao.GetDynamicFormState(rtn);
		if(formState == null)
		{
			formState = HbmwfUtil.FORM_STATE_DRA;
		}
		rtn.setFormState(formState);
		//
		return rtn;
	}
	
	public static boolean UpdateFormState(HbmentDynamicForm dynamicForm,String state) throws SQLException
	{
		return dynamicDao.UpdateDynamicFormState(dynamicForm, state);
	}
}
