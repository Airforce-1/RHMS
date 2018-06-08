/**   
* @Title: WfTmplController.java 
* @Package com.khidi.manager.hbm.engine.hbmwfcontroller 
* @Description: TODO(ID生成器 测试Service) 
* @author 王顺波
* @date 2017年11月20日 上午9:57:43 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.hbmwfservice;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.khidi.manager.hbmwf.engine.dao.Form1Dao;
import com.khidi.manager.hbmwf.engine.dao.IdgeneratorDao;
import com.khidi.manager.hbmwf.engine.dao.WfFormHandleDao;
import com.khidi.manager.hbmwf.engine.domain.tst.HbmentForm1;
import com.khidi.manager.hbmwf.enginext.domain.HbmentFormHandle;

@Component
@Qualifier("WfTestService")
public class WfTestService {
	@Autowired
	private IdgeneratorDao idDao;  //  id 生成器 DAO
	
	@Autowired
	private Form1Dao form1Dao;  // 测试表单1 DAO
	
	@Autowired
	private WfFormHandleDao formHandleDao;  // 表单任务 Handle DAO
	
	// 生成新ID
	public String GetNewId(String tableName) throws SQLException
	{
		return String.valueOf(idDao.GetNewId(tableName));
	}
	
	// 查询测试表单数据
	public List<HbmentForm1> QueryTstForm1() throws SQLException
	{
		return form1Dao.QueryForms();
	}
	
	// 查询特定测试表单数据
	public HbmentForm1 GetTestForm1(int formId) throws SQLException
	{
		return form1Dao.GetForm(formId);
	}
	
	// 	新建测试表单1数据
	public HbmentForm1 NewTestForm1(HbmentForm1 form1) throws SQLException
	{
		HbmentForm1 theForm1 = form1Dao.NewForm1(form1);
		//
		return theForm1;
	}
	
	// 编辑测试表单1数据
	public HbmentForm1 EditTestForm1(HbmentForm1 form1) throws SQLException
	{
		HbmentForm1 theForm1 = form1Dao.EditForm1(form1);
		//
		return theForm1;
	}
	
	// 获取审批 Op handle ID
	public List<HbmentFormHandle> GetVeriHandlesForTest(String formId,String formType,String nodeId) throws SQLException
	{
		return formHandleDao.GetFormHandlesForTest(formId, formType, nodeId);
	}
}
