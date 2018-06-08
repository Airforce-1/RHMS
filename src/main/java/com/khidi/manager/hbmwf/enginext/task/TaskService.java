/**   
* @Title: TaskService.java 
* @Package com.khidi.manager.hbm.enginext.task 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月22日 上午9:20:21 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.enginext.task;

import java.util.List;

import com.khidi.manager.hbmwf.engine.domain.HbmentWf;
import com.khidi.manager.hbmwf.engine.domain.HbmentWfHandle;
import com.khidi.manager.hbmwf.engine.wfobj.HbmwfEventObj;
import com.khidi.manager.hbmwf.engine.wfobj.theenum.HbmwfenumNodeState;

/**
 * @author Administrator
 *
 */
public class TaskService implements IWfTask{
    /********************************************     基础函数      ************************************************/
	private void _startwf(HbmwfEventObj event,HbmentWf wf)
	{
		
	}
	
	private void _startnode(HbmwfEventObj event,HbmentWf wf)
	{
		
	}
	
	private void _backfornpd(HbmwfEventObj event,HbmentWf wf,String wfHandleDesc)
	{
		
	}
	
	private void _completeveri(HbmwfEventObj event,HbmentWf wf,String wfHandleDesc)
	{
		
	}
	
	private void _enforceverinpd(HbmwfEventObj event,HbmentWf wf,String wfHandleDesc)
	{
		
	}
	
	private void _enforceveripsd(HbmwfEventObj event,HbmentWf wf,String wfHandleDesc)
	{
		
	}
	
	private void _veripsd(HbmwfEventObj event,HbmentWf wf,String wfHandleDesc)
	{
		
	}
	
	private void _verinpd(HbmwfEventObj event,HbmentWf wf,String wfHandleDesc)
	{
		
	}
	
	
	private String GetWfHandleState(HbmwfenumNodeState nodeState)
	{
		return null;
	}
	
	
	private HbmentWfHandle GetWfHandle(HbmwfEventObj event,HbmentWf wf,String wfHandleDesc)
	{
		return null;
	}
	
	private boolean CurWfHandleExists(HbmentWfHandle handle)
	{
		return false;
	}
	
	private boolean ChangeCurWfHandleToHis(HbmentWfHandle handle)
	{
		return false;
	}
	/*****************************************     基础函数 END      *********************************************/

	
	
	
	/********************************************     xxx      ************************************************/
	/********************************************  xxx END     ************************************************/
	/********************************************     xxx      ************************************************/
	/********************************************  xxx END     ************************************************/
	/********************************************     xxx      ************************************************/
	/********************************************  xxx END     ************************************************/
	/* (non-Javadoc)
	 * @see com.khidi.manager.hbm.enginext.task.IWfTask#GetWfHandle(int)
	 */
	@Override
	public HbmentWfHandle GetWfHandle(int handleId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.khidi.manager.hbm.enginext.task.IWfTask#GetLastWfHandle(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<HbmentWfHandle> GetLastWfHandle(String nodeId, String formId, String formType) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.khidi.manager.hbm.enginext.task.IWfTask#GetCurWfHandle(java.lang.String, java.lang.String, java.lang.String, int)
	 */
	@Override
	public HbmentWfHandle GetCurWfHandle(String formId, String formType, String nodeId, int receiverId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.khidi.manager.hbm.enginext.task.IWfTask#NewWfHandle(com.khidi.manager.hbm.engine.domain.HbmentWfHandle)
	 */
	@Override
	public HbmentWfHandle NewWfHandle(HbmentWfHandle handle) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.khidi.manager.hbm.enginext.task.IWfTask#ReadWfHandle(int)
	 */
	@Override
	public boolean ReadWfHandle(int handleId) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.khidi.manager.hbm.enginext.task.IWfTask#GetCurWfHandles(java.lang.String, java.lang.String)
	 */
	@Override
	public List<HbmentWfHandle> GetCurWfHandles(String formId, String formType) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.khidi.manager.hbm.enginext.task.IWfTask#GetNodeWfHandles(java.lang.String, java.lang.String)
	 */
	@Override
	public List<HbmentWfHandle> GetNodeWfHandles(String formId, String formType) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.khidi.manager.hbm.enginext.task.IWfTask#GetCurUserCurWfHandles(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<HbmentWfHandle> GetCurUserCurWfHandles(String formId, String formType, String nodeId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.khidi.manager.hbm.enginext.task.IWfTask#VeriNpd(com.khidi.manager.hbm.engine.domain.HbmentWfHandle)
	 */
	@Override
	public HbmentWfHandle VeriNpd(HbmentWfHandle handle) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.khidi.manager.hbm.enginext.task.IWfTask#EditWfHandle02(com.khidi.manager.hbm.engine.domain.HbmentWfHandle)
	 */
	@Override
	public HbmentWfHandle EditWfHandle02(HbmentWfHandle handle) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.khidi.manager.hbm.enginext.task.IWfTask#EditWfHandleForVeri(com.khidi.manager.hbm.engine.domain.HbmentWfHandle)
	 */
	@Override
	public HbmentWfHandle EditWfHandleForVeri(HbmentWfHandle handle) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.khidi.manager.hbm.enginext.task.IWfTask#WfHandleSync(com.khidi.manager.hbm.engine.wfobj.HbmwfEventObj, com.khidi.manager.hbm.engine.domain.HbmentWf, java.lang.String)
	 */
	@Override
	public void WfHandleSync(HbmwfEventObj event, HbmentWf wf, String handleDesc) {
		// TODO Auto-generated method stub
		
	}

}
