/**   
* @Title: HbmentWfDrivingImpl.java 
* @Package com.khidi.manager.hbm.enginext.Service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月24日 上午10:33:20 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.enginext.Service;

import java.sql.SQLException;

import com.khidi.manager.hbmwf.engine.dao.WfDao;
import com.khidi.manager.hbmwf.engine.dao.WfFormHandleDao;
import com.khidi.manager.hbmwf.engine.dao.WfHandleSyncDao;
import com.khidi.manager.hbmwf.engine.domain.HbmentWf;
import com.khidi.manager.hbmwf.engine.wfobj.HbmwfDriving;
import com.khidi.manager.hbmwf.engine.wfobj.HbmwfEventObj;
import com.khidi.manager.hbmwf.engine.wfobj.IhbmwfAdapter;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmEnumwfState;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.hbmwf.enginext.cfg.form.BzDynamicForm;

/**
 * @author Administrator
 *
 */
public class HbmentWfDrivingImpl implements IhbmwfAdapter {
	private WfDao wfDao;
	private WfHandleSyncDao wfHandleSyncDao;
	private WfFormHandleDao wfFormHandleDao;

	public HbmentWfDrivingImpl(HbmwfDriving wfDriving,String formId, String formType,String veriDesc) {
		this.formId = formId;
		this.formType = formType;
		this.veriDesc = veriDesc;
		this.curDriving = wfDriving;
		//
		wfDao = new WfDao();
		wfHandleSyncDao = new WfHandleSyncDao();
		wfFormHandleDao = new WfFormHandleDao();
		
	}

	//
	private String formId;
	private String formType;
	private String veriDesc;
	private HbmwfDriving curDriving;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.khidi.manager.hbm.engine.wfobj.IhbmwfAdapter#WfNodeStateChanged(com.
	 * khidi.manager.hbm.engine.wfobj.HbmwfEventObj)
	 */
	@Override
	public void WfNodeStateChanged(HbmwfEventObj event) {
		// TODO Auto-generated method stub
		try {
			WfDrivingEvent(event);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.khidi.manager.hbm.engine.wfobj.IhbmwfAdapter#WfNodeNotPsd(com.khidi.
	 * manager.hbm.engine.wfobj.HbmwfEventObj)
	 */
	@Override
	public void WfNodeNotPsd(HbmwfEventObj event) {
		// TODO Auto-generated method stub
		try {
			WfDrivingEvent(event);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.khidi.manager.hbm.engine.wfobj.IhbmwfAdapter#
	 * WfNodeNotPsdBacktobacknode(com.khidi.manager.hbm.engine.wfobj.
	 * HbmwfEventObj)
	 */
	@Override
	public void WfNodeNotPsdBacktobacknode(HbmwfEventObj event) {
		// TODO Auto-generated method stub
		try {
			WfDrivingEvent(event);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.khidi.manager.hbm.engine.wfobj.IhbmwfAdapter#WfNodeEnforceNotPsd(com.
	 * khidi.manager.hbm.engine.wfobj.HbmwfEventObj)
	 */
	@Override
	public void WfNodeEnforceNotPsd(HbmwfEventObj event) {
		// TODO Auto-generated method stub
		try {
			WfDrivingEvent(event);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.khidi.manager.hbm.engine.wfobj.IhbmwfAdapter#WfNodeEnforcePsd(com.
	 * khidi.manager.hbm.engine.wfobj.HbmwfEventObj)
	 */
	@Override
	public void WfNodeEnforcePsd(HbmwfEventObj event) {
		// TODO Auto-generated method stub
		try {
			WfDrivingEvent(event);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.khidi.manager.hbm.engine.wfobj.IhbmwfAdapter#WfStartUndoEvent(com.
	 * khidi.manager.hbm.engine.wfobj.HbmwfEventObj)
	 */
	@Override
	public void WfStartUndoEvent(HbmwfEventObj event) {
		// TODO Auto-generated method stub
		try {
			WfDrivingEvent(event);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.khidi.manager.hbm.engine.wfobj.IhbmwfAdapter#WfEnforceStartUndoEvent(
	 * com.khidi.manager.hbm.engine.wfobj.HbmwfEventObj)
	 */
	@Override
	public void WfEnforceStartUndoEvent(HbmwfEventObj event) {
		// TODO Auto-generated method stub
		try {
			WfDrivingEvent(event);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void WfDrivingEvent(HbmwfEventObj event) throws SQLException
	{
		HbmentWf wf = wfDao.GetWf(formId, formType,true);
		//
		wfHandleSyncDao.WfHandleSync(event, wf);
		//
		wfFormHandleDao.FormHandleSync(event, wf, veriDesc);
		//
		if(curDriving != null)
		{
			if(curDriving.GetWfState() == HbmEnumwfState.complete)
			{
				BzDynamicForm.UpdateFormState(BzDynamicForm.GetDynamicForm(formId, formType), HbmwfUtil.FORM_STATE_VERICOM);
			}
		}
	}

}
