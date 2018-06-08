package com.khidi.manager.hbmwf.engine.wfobj;
// 流程事件代理接口(流程核心内部使用)
public interface IhbmwfAdapter {
	public void WfNodeStateChanged(HbmwfEventObj event);

	public void WfNodeNotPsd(HbmwfEventObj event);

	public void WfNodeNotPsdBacktobacknode(HbmwfEventObj event);

	public void WfNodeEnforceNotPsd(HbmwfEventObj event);

	public void WfNodeEnforcePsd(HbmwfEventObj event);

	public void WfStartUndoEvent(HbmwfEventObj event);

	public void WfEnforceStartUndoEvent(HbmwfEventObj event);
}
