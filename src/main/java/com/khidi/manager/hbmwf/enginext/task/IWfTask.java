/**   
* @Title: IWfTask.java 
* @Package com.khidi.manager.hbm.enginext.task 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月22日 上午9:22:12 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.enginext.task;

import java.util.List;

import com.khidi.manager.hbmwf.engine.domain.HbmentWf;
import com.khidi.manager.hbmwf.engine.domain.HbmentWfHandle;
import com.khidi.manager.hbmwf.engine.wfobj.HbmwfEventObj;

/**
 * @author Administrator
 *
 */
public interface IWfTask {
	public HbmentWfHandle GetWfHandle(int handleId);

	public List<HbmentWfHandle> GetLastWfHandle(String nodeId, String formId, String formType);
	
	public 	HbmentWfHandle GetCurWfHandle(String formId,String formType,String nodeId,int receiverId);
	
	public HbmentWfHandle NewWfHandle(HbmentWfHandle handle);
	
	// 标记为已读取
	public boolean ReadWfHandle(int handleId);
	
	public List<HbmentWfHandle> GetCurWfHandles(String formId, String formType);
	
	// 获取node的所有handles(包括历史)
	public List<HbmentWfHandle> GetNodeWfHandles(String formId, String formType);
	
	// 获取当前用户的指定表单的当前所有wf handles
	public List<HbmentWfHandle> GetCurUserCurWfHandles(String formId, String formType,String nodeId);
	
	// 审批未通过   (更新)
	public HbmentWfHandle VeriNpd(HbmentWfHandle handle);
	
	
	// 编辑Handle
	public HbmentWfHandle EditWfHandle02(HbmentWfHandle handle);
	
	// 为处理handle而留出的编辑功能
	public HbmentWfHandle EditWfHandleForVeri(HbmentWfHandle handle);
	
	// 流程handle驱动 处理
	public void WfHandleSync(HbmwfEventObj event,HbmentWf wf,String handleDesc);

}