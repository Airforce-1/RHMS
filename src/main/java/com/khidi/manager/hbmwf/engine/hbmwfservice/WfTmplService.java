/**   
* @Title: WfTmplService.java 
* @Package com.khidi.manager.hbm.engine.hbmwfservice 
* @Description: TODO(工作流模板业务类) 
* @author 王顺波
* @date 2017年11月20日 上午10:03:45 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.hbmwfservice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;

import com.khidi.manager.hbmwf.engine.dao.OracleUtil;
import com.khidi.manager.hbmwf.engine.dao.WfTmplDao;
import com.khidi.manager.hbmwf.engine.domain.HbmentWftmpl;
import com.khidi.manager.hbmwf.engine.domain.HbmentuiWftmpl;
import com.khidi.manager.hbmwf.engine.wfobj.HbmwfNode;
import com.khidi.manager.hbmwf.engine.wfobj.uiFlow.HbmwfuientWfNode;
import com.khidi.manager.hbmwf.engine.wfobj.uiFlow.HbmwfuientWfobj;
import com.khidi.manager.hbmwf.engine.wftmplobj.HbmwftmplMonitorDriving;

/**
 * @author Administrator
 *
 */
@Component
@Qualifier("WfTmplService")
public class WfTmplService {
	@Autowired
	private WfTmplDao wfTmplDao; // 流程模板DAO

	// 新增流程模板
	public HbmentWftmpl NewWftmpl(HbmentuiWftmpl hbmwfTmpl) throws Exception {
		HbmentWftmpl rtn = wfTmplDao.NewWftmpl(hbmwfTmpl);
		//
		return rtn;
	}

	// 测试编辑流程模板基础信息
	public HbmentWftmpl EditWftmplBase(HbmentWftmpl wfTmpl) throws SQLException {
		return wfTmplDao.EditWftmplBase(wfTmpl);
	}

	// 编辑流程模板
	public HbmentWftmpl EditWftmpl(HbmentuiWftmpl hbmwfuiObj) throws Exception {
		HbmentWftmpl rtn = wfTmplDao.EditWftmpl(hbmwfuiObj);
		//
		return rtn;
	}

	// 删除流程模板
	public boolean DeleteWftmpl(int tmplId) throws SQLException {
		boolean rtn = wfTmplDao.DeleteWftmpl(tmplId);
		//
		return rtn;
	}

	// 查询流程模板
	public List<HbmentWftmpl> QueryWfTmpl(String wfType) throws Exception {
		List<HbmentWftmpl> rtn = wfTmplDao.QueryWftmpl(false, wfType);
		//
		return rtn;
	}

	// 获取特定流程模板
	public HbmentWftmpl GetWfTmpl(int tmplId) throws Exception {
		HbmentWftmpl rtn = wfTmplDao.GetWftmpl(tmplId);
		rtn.setTheContent(
				OracleUtil.GetWfJsonContent(rtn.getTheContent(), rtn.getName()).replace("end round mix", "end round"));
		//
		return rtn;
	}

	// 获取特定流程模板(内部服务使用)
	public HbmentWftmpl _GetWfTmpl(int tmplId) throws SQLException {
		return wfTmplDao.GetWftmpl(tmplId);
	}

	public List<HbmwfuientWfNode> GetPreviousNodes(String tmplId, String nodeId)
			throws NumberFormatException, Exception {
		HbmwftmplMonitorDriving hmd = new HbmwftmplMonitorDriving();
		hmd.InitWfTmpl(Integer.valueOf(tmplId));
		List<HbmwfNode> rtn0 = hmd.GetPreviousNodes(nodeId);
		//
		List<HbmwfuientWfNode> rtn = new ArrayList<HbmwfuientWfNode>();
		//
		for (HbmwfNode lpNode : rtn0) {
			HbmwfuientWfNode lpEntNode = new HbmwfuientWfNode();
			lpEntNode.setId(lpNode.getNodeId());
			lpEntNode.setName(lpNode.getNodeName());
			//
			rtn.add(lpEntNode);
		}
		return rtn;
	}
}
