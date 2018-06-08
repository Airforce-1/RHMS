package com.khidi.manager.hbmwf.engine.wfobj.theenum;

public enum HbmwfenumeventType {
	// 启动流程
	startwf,
	// 撤销流程启动
	undostartwf,
	// 强制撤销流程启动
	enforceundostartwf,
	// 完成流程
	completewf,
	// 审批流程通过
	verinodepsd,
	// 审批流程不通过
	verinodenpd,
	// 节点审批不通过，返回到backnode
	backtobacknode,
	// 节点被强制审批通过
	enforceverinodepsd,
	// 节点被强制审批不通过
	enforceverinodenpd,
	// 自动启动下一节点
	autostartnode,
	// 未知类型
	none
}
