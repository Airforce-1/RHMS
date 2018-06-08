/**   
* @Title: WfHandleDynamicDao.java 
* @Package com.khidi.manager.hbm.engine.dao 
* @Description: TODO(工作流的扩展开发部分:  业务Handle) 
* @author 王顺波
* @date 2017年11月23日 下午4:23:10 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.khidi.manager.hbmwf.engine.domain.HbmentWf;
import com.khidi.manager.hbmwf.engine.wfobj.HbmwfEventObj;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumNodeState;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumNodeType;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumeventType;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.hbmwf.enginext.cfg.WfCurrentSession;
import com.khidi.manager.hbmwf.enginext.cfg.form.BzDynamicForm;
import com.khidi.manager.hbmwf.enginext.domain.HbmentDynamicForm;
import com.khidi.manager.hbmwf.enginext.domain.HbmentFormHandle;

/**
 * @author 王顺波
 *
 */
@Component
@Qualifier("WfFormHandleDao")
public class WfFormHandleDao {
	// HBMOP_HANDLE HbmentFormHandle

	public static HbmentFormHandle GetFormHandle(int handleId) throws SQLException {
		String sql = "SELECT * FROM HBMOP_HANDLE WHERE ID = ?";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setInt(1, handleId);
		//
		ResultSet rs = pre.executeQuery();
		HbmentFormHandle rtn = OracleUtil.GetFormHandle(rs);
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}

	public static HbmentFormHandle GetLastFormHandle(String nodeId, String formId, String formType)
			throws SQLException {
		String sql = "SELECT * FROM HBMOP_HANDLE WHERE FORMID = ? AND FORMTYPE = ? AND WFNODEID = ? AND ROWNUM <= 1 ORDER BY CREATETM DESC";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, formId);
		pre.setString(2, formType);
		pre.setString(3, nodeId);
		//
		ResultSet rs = pre.executeQuery();
		HbmentFormHandle rtn = OracleUtil.GetFormHandle(rs);
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}

	public static HbmentFormHandle GetFormHandle(String formId, String formType, String nodeId, int absId)
			throws SQLException {
		String sql = "SELECT * FROM HBMOP_HANDLE WHERE FORMID = ? AND FORMTYPE = ? AND WFNODEID = ? AND RECEIVERID = ? ORDER BY Createtm DESC";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, formId);
		pre.setString(2, formType);
		pre.setString(3, nodeId);
		pre.setInt(4, absId);
		//
		ResultSet rs = pre.executeQuery();
		HbmentFormHandle rtn = OracleUtil.GetFormHandle(rs);
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}

	// 后端测试用方法
	public static List<HbmentFormHandle> GetFormHandlesForTest(String formId, String formType, String nodeId)
			throws SQLException {
		String sql = "SELECT * FROM HBMOP_HANDLE WHERE FORMID = ? AND FORMTYPE = ? AND WFNODEID = ? ORDER BY Createtm DESC";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, formId);
		pre.setString(2, formType);
		pre.setString(3, nodeId);
		//
		ResultSet rs = pre.executeQuery();
		List<HbmentFormHandle> rtn = OracleUtil.GetFormHandles(rs);
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}

	public static HbmentFormHandle GetCurFormHandle(String formId, String formType, String nodeId, int absId)
			throws SQLException {
		String sql = "SELECT * FROM HBMOP_HANDLE WHERE CURRENTIND = 1 AND FORMID = ? AND FORMTYPE = ? AND WFNODEID = ? AND RECEIVERID = ? ORDER BY Createtm DESC";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, formId);
		pre.setString(2, formType);
		pre.setString(3, nodeId);
		pre.setInt(4, absId);
		//
		ResultSet rs = pre.executeQuery();
		HbmentFormHandle rtn = OracleUtil.GetFormHandle(rs);
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}

	public static List<HbmentFormHandle> GetSpecialFormHandles(String formId, String formType, String receiverId)
			throws SQLException {
		//

		String sql = "SELECT * FROM HBMOP_HANDLE WHERE RECEIVERID = ? AND CURRENTIND = '1' AND FORMID = ? AND FORMTYPE = ? AND DWSTATE = 'DO'";
		//
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, receiverId);
		pre.setString(2, formId);
		pre.setString(3, formType);
		//
		ResultSet rs = pre.executeQuery();
		List<HbmentFormHandle> rtnArr = OracleUtil.GetFormHandles(rs);
		rs.close();
		pre.close();
		con.close();
		//
		return rtnArr;
	}

	public static List<HbmentFormHandle> GetCurFormHandles(String formId, String formType, String absIds)
			throws SQLException {
		//
		//
		String sql = String.format(
				"SELECT * FROM HBMOP_HANDLE WHERE RECEIVERID IN(%s) AND CURRENTIND = '1' AND FORMID = ? AND FORMTYPE = ? AND DWSTATE = 'DO'",
				absIds);
		//
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, formId);
		pre.setString(2, formType);
		//
		ResultSet rs = pre.executeQuery();
		List<HbmentFormHandle> rtnArr = OracleUtil.GetFormHandles(rs);
		rs.close();
		pre.close();
		con.close();
		//
		return rtnArr;
	}

	public static HbmentFormHandle NewFormHandle(HbmentFormHandle formHandle) throws SQLException {
		//
		// String absIds = formHandle.getReceiverId();
		// String[] absIdsArr = absIds.split(",");
		// for (String absId : absIdsArr) {
		String sql = "INSERT INTO HBMOP_HANDLE(FORMID,ID,CURRENTIND,DWSTATE,WFNODEID,RECEIVERID,VERIDESC,CREATEUSERID,CREATEDEPTID,CREATETM,FORMTYPE) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, formHandle.getFormId());
		int newId = HbmwfUtil.NewId("HBMOP_HANDLE");
		pre.setInt(2, newId);
		pre.setString(3, "1");
		pre.setString(4, formHandle.getDwState());
		pre.setString(5, formHandle.getWfNodeId());
		pre.setString(6, formHandle.getReceiverId());
		pre.setString(7, formHandle.getVeriDesc());
		pre.setString(8, WfCurrentSession.GetUserId());
		pre.setString(9, WfCurrentSession.GetDeptId());
		pre.setDate(10, new java.sql.Date(new Date().getTime()));
		pre.setString(11, formHandle.getFormType());
		//
		boolean rtn0 = pre.execute();
		pre.close();
		con.close();
		//
		formHandle.setHandleId(newId);
		return formHandle;
		// }
		// return formHandle;
	}

	// TODO:
	public static void ReadFormHandle(int handleId) {

	}

	public static List<HbmentFormHandle> GetCurFormHandles(String formId, String formType) throws SQLException {
		String sql = "SELECT * FROM HBMOP_HANDLE WHERE CURRENTIND = 1 AND FORMID = ? AND FORMTYPE = ? AND DWSTATE = 'DO' ORDER BY Createtm DESC";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, formId);
		pre.setString(2, formType);
		//
		ResultSet rs = pre.executeQuery();
		List<HbmentFormHandle> rtn = OracleUtil.GetFormHandles(rs);
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}

	public static List<HbmentFormHandle> GetNodeFormhandles(String formId, String formType, String nodeId)
			throws SQLException {
		String sql = "SELECT * FROM HBMOP_HANDLE WHERE FORMID = ? AND FORMTYPE = ? AND WFNODEID = ? ORDER BY ID";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, formId);
		pre.setString(2, formType);
		pre.setString(3, nodeId);
		//
		ResultSet rs = pre.executeQuery();
		List<HbmentFormHandle> rtn = OracleUtil.GetFormHandles(rs);
		rs.close();
		pre.close();
		con.close();
		//
		return rtn;
	}

	// TODO:
	public static List<HbmentFormHandle> GetCurUserCurVeriHandles(String formId, String formType, String nodeId)
			throws SQLException {
		return null;
	}

	// 审批未通过 EditVeriHandle01
	public static HbmentFormHandle DwFormHandleNpd(HbmentFormHandle formHandle) throws SQLException {
		String sql = "UPDATE HBMOP_HANDLE SET CURRENTIND = ? , DWSTATE = ? WHERE ID = ?";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, "1");
		pre.setString(2, HbmwfUtil.WF_NODESTATE_NPD);
		pre.setInt(3, formHandle.getHandleId());
		//
		boolean rtn0 = pre.execute();
		pre.close();
		con.close();
		//
		formHandle.setDwState(HbmwfUtil.WF_NODESTATE_NPD);
		return formHandle;
	}

	public static HbmentFormHandle EditFormHandle02(HbmentFormHandle formHandle) throws SQLException {
		String sql = "UPDATE HBMOP_HANDLE SET CURRENTIND = ?,DWSTATE = ?,COMPLETEDDEPTID = ?,COMPLETEDEMPID = ?,COMPLETEDIND = ?,COMPLETEDTIME = ?,VERIDESC = ?,"
				+ "WFNODEID = ?,RECEIVERID = ? WHERE ID = ?";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, formHandle.getCurrentInd());
		pre.setString(2, formHandle.getDwState());
		pre.setString(3, WfCurrentSession.GetDeptId());
		pre.setString(4, WfCurrentSession.GetUserId());
		pre.setString(5, formHandle.getCompletedInd());
		pre.setDate(6, new java.sql.Date(new Date().getTime()));
		pre.setString(7, formHandle.getVeriDesc());
		pre.setString(8, formHandle.getWfNodeId());
		pre.setString(9, formHandle.getReceiverId());
		//
		boolean rtn0 = pre.execute();
		pre.close();
		con.close();
		//
		// formHandle.setDwState(HbmwfUtil.WF_NODESTATE_NPD);
		return formHandle;
	}
	//

	private static void _startwf(HbmwfEventObj event, HbmentWf wf) throws SQLException {
		if (event.getTheNode().getEnumNodeType() == HbmwfenumNodeType.start) {
			WfDynamicDao wfDynamicDao = new WfDynamicDao();
			HbmentDynamicForm dynamicForm = BzDynamicForm.GetDynamicForm(wf.getFormId(), wf.getFormType());
			wfDynamicDao.UpdateDynamicFormState(dynamicForm, HbmwfUtil.FORM_STATE_VERI);
			// return;
		}
		_startnode(event, wf);
	}

	private static void _startnode(HbmwfEventObj event, HbmentWf wf) throws SQLException {
		String strReceivers = event.getTheNode().getReceivers();
		//
		String sql0 = "SELECT COUNT(*) FROM HBMOP_HANDLE WHERE FORMID = ? AND WFNODEID = ? AND CURRENTIND = '1' AND FORMTYPE = ?";
		String sql1 = "UPDATE HBMOP_HANDLE SET CURRENTIND = ? WHERE FORMID = ? AND WFNODEID = ? AND CURRENTIND = '1' AND FORMTYPE = ?";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql0);
		// pre.setString(1, strReceivers);
		pre.setString(1, wf.getFormId());
		pre.setString(2, event.getTheNode().getNodeId());
		pre.setString(3, wf.getFormType());
		ResultSet rs = pre.executeQuery();
		//
		boolean exists = OracleUtil.CheckDataExists(rs);
		rs.close();
		pre.close();
		con.close();
		//

		if (exists) {
			con = OracleUtil.GetOperationConnection();
			PreparedStatement pre1 = con.prepareStatement(sql1);
			pre1.setString(1, "0");
			// pre1.setString(2, strReceivers);
			pre1.setString(2, wf.getFormId());
			pre1.setString(3, event.getTheNode().getNodeId());
			pre1.setString(4, wf.getFormType());
			//
			boolean rtn0 = pre1.execute();
			//
			pre1.close();
			con.close();
		}
		//
		List<HbmentFormHandle> newFormHandleList = GetVeriHandle(event, wf, "节点启动");

		for (HbmentFormHandle newFormHandle : newFormHandleList) {
			if (event.getTheNode().getEnumNodeType() == HbmwfenumNodeType.start) {
				newFormHandle.setDwState(HbmwfUtil.WF_NODESTATE_PSD);
			} else {
				newFormHandle.setDwState(HbmwfUtil.WF_NODESTATE_DO);
			}
			HbmentFormHandle rtn1 = NewFormHandle(newFormHandle);
		}
		//
	}

	private static void _backfornpd(HbmwfEventObj event, HbmentWf wf, String veriDesc) throws SQLException {
		//
		if (event.getTheNode().getEnumNodeType() == HbmwfenumNodeType.start) {
			// 改变Form的状态
			WfDynamicDao wfDynamicDao = new WfDynamicDao();
			HbmentDynamicForm dynamicForm = BzDynamicForm.GetDynamicForm(wf.getFormId(), wf.getFormType());
			if (!dynamicForm.getFormState().equals(HbmwfUtil.FORM_STATE_VERINPD)) {
				wfDynamicDao.UpdateDynamicFormState(dynamicForm, HbmwfUtil.FORM_STATE_VERINPD);
			}
		}

		List<HbmentFormHandle> theFormHandleList = GetVeriHandle(event, wf, veriDesc);
		//
		for (HbmentFormHandle theFormHandle : theFormHandleList) {
			if (CurFormHandleExists(theFormHandle)) {
				ChangeCurVeriHandleToHis(theFormHandle);
			}
			theFormHandle.setDwState(HbmwfUtil.WF_NODESTATE_NPD);
			HbmentFormHandle rtn0 = NewFormHandle(theFormHandle);
		}
	}

	private static void _completeveri(HbmwfEventObj event, HbmentWf wf, String veriDesc) {
		// do nothing
	}

	private static void _enforceverinpd(HbmwfEventObj event, HbmentWf wf, String veriDesc)
			throws NumberFormatException, SQLException {
		//
		// if(event.getTheNode().getEnumNodeType() == HbmwfenumNodeType.start)
		// {
		// // 改变Form的状态
		// WfDynamicDao wfDynamicDao = new WfDynamicDao();
		// HbmentDynamicForm dynamicForm = BzDynamicForm.GetDynamicForm(
		// wf.getFormId(), wf.getFormType());
		// wfDynamicDao.UpdateDynamicFormState(dynamicForm,
		// HbmwfUtil.FORM_STATE_VERINPD);
		// }
		//
		String theReceivers = event.getTheNode().getReceivers();
		String[] theReceiversArr = theReceivers.split(",");
		for (String lpReceiver : theReceiversArr) {
			HbmentFormHandle formHandle = GetCurFormHandle(wf.getFormId(), wf.getFormType(),
					event.getTheNode().getNodeId(), Integer.valueOf(lpReceiver));
			//
			if (formHandle != null) {
				if (formHandle.getDwState().equals(HbmwfUtil.WF_NODESTATE_PSD)) {
					if (CurFormHandleExists(formHandle)) {
						ChangeCurVeriHandleToHis(formHandle);
					}

					//
					HbmentFormHandle rtn0 = NewFormHandle(formHandle);
				} else {
					formHandle.setCompletedDeptId(WfCurrentSession.GetDeptId());
					formHandle.setCompletedEmpId(WfCurrentSession.GetUserId());
					formHandle.setCompletedInd("1");// TODO:?
					formHandle.setCompletedTime(new Date());
					formHandle.setDwState(String.valueOf(HbmwfenumNodeState.NPD));
					formHandle.setVeriDesc(veriDesc);
					//
					EditFormHandleFormVeri(formHandle);
					//
				}
			}
		}
	}

	private static void _enforceveripsd(HbmwfEventObj event, HbmentWf wf, String veriDesc)
			throws NumberFormatException, SQLException {

		//
		String theReceivers = event.getTheNode().getReceivers();
		String[] theReceiversArr = theReceivers.split(",");
		for (String lpReceiver : theReceiversArr) {
			HbmentFormHandle formHandle = GetCurFormHandle(wf.getFormId(), wf.getFormType(),
					event.getTheNode().getNodeId(), Integer.valueOf(lpReceiver));
			//
			if (formHandle != null) {
				formHandle.setCompletedDeptId(WfCurrentSession.GetDeptId());
				formHandle.setCompletedEmpId(WfCurrentSession.GetUserId());
				formHandle.setCompletedInd("1");// TODO:?
				formHandle.setCompletedTime(new Date());
				formHandle.setDwState(String.valueOf(HbmwfenumNodeState.PSD));
				formHandle.setVeriDesc(veriDesc);
				//
				EditFormHandleFormVeri(formHandle);
			}
		}
	}

	private static void _veripsd(HbmwfEventObj event, HbmentWf wf, String veriDesc) throws SQLException {
		if (event.getTheNode().getEnumNodeType() == HbmwfenumNodeType.end) {
			UpdateDynamicFormState(BzDynamicForm.GetDynamicForm(wf.getFormId(), wf.getFormType()),
					HbmwfUtil.FORM_STATE_VERICOM);
			//
			return;
		}
		//
		String theReceivers = event.getTheNode().getReceivers();
		String[] theReceiversArr = theReceivers.split(",");
		for (String lpReceiver : theReceiversArr) {
			HbmentFormHandle formHandle = GetCurFormHandle(wf.getFormId(), wf.getFormType(),
					event.getTheNode().getNodeId(), Integer.valueOf(lpReceiver));
			//
			if (formHandle != null) {
				formHandle.setCompletedDeptId(WfCurrentSession.GetDeptId());
				formHandle.setCompletedEmpId(WfCurrentSession.GetUserId());
				formHandle.setCompletedInd("1");// TODO:?
				formHandle.setCompletedTime(new Date());
				formHandle.setDwState(String.valueOf(HbmwfenumNodeState.PSD));
				formHandle.setVeriDesc(veriDesc);
				//
				EditFormHandleFormVeri(formHandle);
			}
		}
	}

	private static void _verinpd(HbmwfEventObj event, HbmentWf wf, String veriDesc)
			throws NumberFormatException, SQLException {

		String theReceivers = event.getTheNode().getReceivers();
		String[] theReceiversArr = theReceivers.split(",");
		for (String lpReceiver : theReceiversArr) {
			HbmentFormHandle formHandle = GetCurFormHandle(wf.getFormId(), wf.getFormType(),
					event.getTheNode().getNodeId(), Integer.valueOf(lpReceiver));
			//
			if (formHandle != null) {
				formHandle.setCompletedDeptId(WfCurrentSession.GetDeptId());
				formHandle.setCompletedEmpId(WfCurrentSession.GetUserId());
				formHandle.setCompletedInd("1");// TODO:?
				formHandle.setCompletedTime(new Date());
				// formHandle.setDwState(String.valueOf(event.getTheNode().getEnumNodeState()));
				formHandle.setDwState(String.valueOf(HbmwfenumNodeState.NPD));
				formHandle.setVeriDesc(veriDesc);
				//
				EditFormHandleFormVeri(formHandle);
			}
		}
	}

	private static boolean UpdateDynamicFormState(HbmentDynamicForm dynamicForm, String state) throws SQLException {
		String sql = String.format("UPDATE %s SET %s = ? WHERE %s = ?", dynamicForm.getFormCfg().getFormTable(),
				dynamicForm.getFormCfg().getStateFieldName(), dynamicForm.getFormCfg().getPkFieldName());
		//
		Connection con = OracleUtil.GetWfConnection();
		PreparedStatement pre = con.prepareStatement(sql); //
		pre.setString(1, state);
		pre.setString(2, dynamicForm.getFormId());
		boolean rtn = pre.execute();
		//
		pre.close();
		con.close();
		//
		return rtn;
	}

	public static HbmentFormHandle EditFormHandleFormVeri(HbmentFormHandle formHandle) throws SQLException {
		String sql = "UPDATE HBMOP_HANDLE SET CURRENTIND = ?,DWSTATE = ?,COMPLETEDDEPTID = ?,COMPLETEDEMPID = ?,"
				+ "COMPLETEDTIME = ?,COMPLETEDIND = ? ,VERIDESC = ? WHERE ID = ?";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, formHandle.getCurrentInd());
		pre.setString(2, formHandle.getDwState());
		pre.setString(3, formHandle.getCompletedDeptId());
		pre.setString(4, formHandle.getCompletedEmpId());
		pre.setDate(5, new java.sql.Date(formHandle.getCompletedTime().getTime()));
		pre.setString(6, formHandle.getCompletedInd());
		pre.setString(7, formHandle.getVeriDesc());
		pre.setInt(8, formHandle.getHandleId());
		//
		boolean rtn0 = pre.execute();
		pre.close();
		con.close();
		//
		// formHandle.setDwState(HbmwfUtil.WF_NODESTATE_NPD);
		//
		return formHandle;
	}

	private static boolean ChangeCurVeriHandleToHis(HbmentFormHandle formHandle) throws SQLException {
		String sql = "UPDATE HBMOP_HANDLE SET CURRENTIND = '0' WHERE RECEIVERID = ? AND FORMID = ? AND WFNODEID = ? AND CURRENTIND = '1' AND FORMTYPE = ?";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, formHandle.getReceiverId());
		pre.setString(2, formHandle.getFormId());
		pre.setString(3, formHandle.getWfNodeId());
		pre.setString(4, formHandle.getFormType());
		//
		boolean rtn0 = pre.execute();
		pre.close();
		con.close();
		//
		// formHandle.setDwState(HbmwfUtil.WF_NODESTATE_NPD);
		//
		return rtn0;
	}

	private static boolean CurFormHandleExists(HbmentFormHandle formHandle) throws SQLException {
		String sql0 = "SELECT COUNT(*) FROM HBMOP_HANDLE WHERE RECEIVERID = ? AND FORMID = ? AND WFNODEID = ? AND CURRENTIND = '1' AND FORMTYPE = ?";
		//
		Connection con = OracleUtil.GetOperationConnection();
		PreparedStatement pre = con.prepareStatement(sql0);
		pre.setString(1, formHandle.getReceiverId());
		pre.setString(2, formHandle.getFormId());
		pre.setString(3, formHandle.getWfNodeId());
		pre.setString(4, formHandle.getFormType());
		//
		ResultSet rs = pre.executeQuery();
		//
		boolean rtn = OracleUtil.CheckDataExists(rs);
		//
		rs.close();
		pre.close();
		con.close();
		return rtn;
	}

	private static List<HbmentFormHandle> GetVeriHandle(HbmwfEventObj event, HbmentWf wf, String veriDesc) {
		List<HbmentFormHandle> rtnList = new ArrayList<HbmentFormHandle>();
		String absIds = event.getTheNode().getReceivers();
		String[] absIdsarr = absIds.split(",");
		for (String lpAbsId : absIdsarr) {
			//
			HbmentFormHandle rtn = new HbmentFormHandle();
			rtn.setCompletedInd("0");
			rtn.setCurrentInd("1");
			rtn.setDwState(String.valueOf(event.getTheNode().getEnumNodeState()));
			rtn.setHandleId(0);
			rtn.setReadInd("0");

			// TODO:
			if (event.getTheNode().getEnumNodeType() == HbmwfenumNodeType.start) {
				// TODO:
				rtn.setReceiverId("1");
			} else {
				rtn.setReceiverId(lpAbsId);
			}
			rtn.setVeriDesc(veriDesc);
			rtn.setWfNodeId(event.getTheNode().getNodeId());
			rtn.setFormId(wf.getFormId());
			rtn.setFormType(wf.getFormType());
			rtnList.add(rtn);
		}
		return rtnList;
	}

	public static void FormHandleSync(HbmwfEventObj event, HbmentWf wf, String veriDesc) throws SQLException {
		// HbmwfenumeventType enumeventType = event.getEventType();
		String eventType = String.valueOf(event.getEventType());
		switch (eventType) {
		case "startwf":
			_startwf(event, wf);
			break;
		case "autostartnode":
			_startnode(event, wf);
			break;
		case "backtobacknode":
			_backfornpd(event, wf, WfCurrentSession.GetUserName() + ":" + veriDesc);
			break;
		case "completewf":
			_completeveri(event, wf, "");
			break;
		case "enforceundostartwf":
			break;
		case "enforceverinodenpd":
			_enforceverinpd(event, wf, WfCurrentSession.GetUserName() + ":" + veriDesc);
			break;
		case "enforceverinodepsd":
			_enforceveripsd(event, wf, WfCurrentSession.GetUserName() + ":" + veriDesc);
			break;
		case "none":
			break;
		case "undostartwf":
			break;
		case "verinodenpd":
			_verinpd(event, wf, WfCurrentSession.GetUserName() + ":" + veriDesc);
			break;
		case "verinodepsd":
			_veripsd(event, wf, WfCurrentSession.GetUserName() + ":" + veriDesc);
			break;
		default:
			break;

		}
	}
}
