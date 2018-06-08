/**   
* @Title: WfService.java 
* @Package com.khidi.manager.hbm.engine.hbmwfservice 
* @Description: TODO(工作流 业务类) 
* @author 王顺波
* @date 2017年11月22日 下午1:45:01 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.hbmwfservice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.khidi.manager.hbmwf.engine.dao.Form1Dao;
import com.khidi.manager.hbmwf.engine.dao.OracleUtil;
import com.khidi.manager.hbmwf.engine.dao.WfDao;
import com.khidi.manager.hbmwf.engine.dao.WfHandleDao;
import com.khidi.manager.hbmwf.engine.dao.WfTmplDao;
import com.khidi.manager.hbmwf.engine.domain.HbmentWf;
import com.khidi.manager.hbmwf.engine.domain.HbmentWfHandle;
import com.khidi.manager.hbmwf.engine.domain.HbmentWftmpl;
import com.khidi.manager.hbmwf.engine.domain.tst.HbmentForm1;
import com.khidi.manager.hbmwf.engine.domain.tst.HbmentNewForm;
import com.khidi.manager.hbmwf.engine.wfutil.HbmXml;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.hbmwf.enginext.cfg.WfCurrentSession;

/**
 * @author Administrator
 *
 */
@Component
@Qualifier("WfService")
public class WfService {
	@Autowired
	private WfDao wfDao; // 工作流 DAO

	@Autowired
	private Form1Dao form1Dao; // 测试模板 DAO

	@Autowired
	private WfTmplDao wfTmplDao; // 工作流模板 DAO

	@Autowired
	private WfHandleDao wfHandleDao; // 工作流 Handle DAO

	// 新增表单 并绑定流程
	public HbmentWf NewWfAndForm(HbmentNewForm form) throws SQLException {
		// 存表单
		HbmentForm1 form1 = new HbmentForm1();
		form1.setContent(form.getContent());
		form1.setId(0);
		form1.setName(form.getName());
		form1 = form1Dao.NewForm1(form1);
		// 存流程
		HbmentWftmpl wfTmpl = wfTmplDao.GetWftmpl(form.getWfTmplId());
		//
		HbmentWf wf = new HbmentWf();
		wf.setCreateDept(WfCurrentSession.GetDeptId());
		wf.setCreateTime(HbmwfUtil.NowDate());
		wf.setCreateUser(WfCurrentSession.GetUserId());
		wf.setFormId(String.valueOf(form1.getId()));
		wf.setFormType(form.getFormType());
		wf.setId(0);
		wf.setLastUpdateDept(WfCurrentSession.GetDeptId());
		wf.setLastUpdateTime(new Date());
		wf.setLastUpdateUser(WfCurrentSession.GetUserId());
		wf.setMemo(wfTmpl.getMemo());
		wf.setName("表单类型:" + form.getFormType() + ",表单《" + form.getName() + "》的流程:" + wfTmpl.getName());
		wf.setWfTmplId(wfTmpl.getId());
		wf.setWfContent(wfTmpl.getTheContent());
		//
		return wfDao.NewWf(wf);
	}

	// 新增流程
	public HbmentWf NewWf(HbmentWf wf) throws SQLException {
		return wfDao.NewWf(wf);
	}

	public boolean DropWf(int wfId) throws SQLException {
		return wfDao.DropWf(wfId);
	}

	// 读取表单信息以及其相关流程信息
	public Object[] GetFormAndWf(String formId, String formType) throws Exception {
		HbmentForm1 rtn0 = form1Dao.GetForm(Integer.valueOf(formId));
		//
		HbmentWf rtn1 = wfDao.GetWf(formId, formType, true);
		// 更新流程节点状态
		String wfXml = OracleUtil.GetWfXmlContent(rtn1.getWfContent());
		String wfXml0 = UpdateWfNodeState(wfXml, rtn1.getId());
		//
		String wfJsonContent = OracleUtil.GetWfJsonContentByXml(wfXml0, rtn1.getName());
		rtn1.setWfContent(wfJsonContent);
		//
		return new Object[] { rtn0, rtn1 };
	}
	
	public Object GetWf(String formId, String formType) throws Exception {
		//
		HbmentWf rtn1 = wfDao.GetWf(formId, formType, true);
		// 更新流程节点状态
		String wfXml = OracleUtil.GetWfXmlContent(rtn1.getWfContent());
		String wfXml0 = UpdateWfNodeState(wfXml, rtn1.getId());
		//
		String wfJsonContent = OracleUtil.GetWfJsonContentByXml(wfXml0, rtn1.getName());
		rtn1.setWfContent(wfJsonContent);
		//
		return rtn1;
	}

	// 获取流程的基础信息
	public HbmentWf GetWfbaseInfo(String formId, String formType) throws SQLException {
		HbmentWf rtn1 = wfDao.GetWf(formId, formType, false);
		//
		return rtn1;
	}

	// 更新流程节点的处理状态
	private String UpdateWfNodeState(String wfXml, int wfId)
			throws ParserConfigurationException, SAXException, IOException, SQLException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document dom = builder.parse(new InputSource(new ByteArrayInputStream(wfXml.getBytes("utf-8"))));
		List<HbmentWfHandle> curWfHandles = wfHandleDao.GetWfCurHandles(wfId);
		//
		NodeList xnl0 = dom.getElementsByTagName(HbmwfUtil.WF_NODETAG_START);
		NodeList xnl1 = dom.getElementsByTagName(HbmwfUtil.WF_NODETAG_CMN);
		NodeList xnl2 = dom.getElementsByTagName(HbmwfUtil.WF_NODETAG_END);
		//
		_UpdateWfNodeState(dom, xnl0, curWfHandles, wfId);
		_UpdateWfNodeState(dom, xnl1, curWfHandles, wfId);
		_UpdateWfNodeState(dom, xnl2, curWfHandles, wfId);
		//
		String rtn = HbmXml.GetXmlFromDoc(dom);
		return rtn;
	}

	// 读取流程的Handle
	private HbmentWfHandle __GetWfHandle(List<HbmentWfHandle> wfHandles, String nodeId) {
		for (HbmentWfHandle lpWfHandle : wfHandles) {
			String lpNodeId = lpWfHandle.getNodeId();
			if (nodeId.equals(lpNodeId)) {
				return lpWfHandle;
			}
		}
		return null;
	}

	// 更新流程节点状态
	private void _UpdateWfNodeState(Document doc, NodeList xnl, List<HbmentWfHandle> wfHandles, int wfId) {
		for (int i = 0; i < xnl.getLength(); i++) {
			Node lpNode = xnl.item(i);
			String lpNodeId = HbmXml.GetNodeAttribute(doc, lpNode, "id", false, "");
			//
			if (lpNodeId.equals("1511316384817")) {
				String abc = "aaa";
			}
			HbmentWfHandle lpWfHandle = __GetWfHandle(wfHandles, lpNodeId);
			//
			//
			if (lpWfHandle != null) {
				HbmXml.SetNodeAttribute(doc, lpNode, "state", lpWfHandle.getNodeState(), true);
			} else {
				HbmXml.SetNodeAttribute(doc, lpNode, "state", HbmwfUtil.WF_NODESTATE_NB, true);
			}
			//
		}
	}

}
