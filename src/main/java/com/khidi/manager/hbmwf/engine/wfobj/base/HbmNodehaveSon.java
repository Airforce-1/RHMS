/**   
* @Title: HbmNodehaveSon.java 
* @Package com.khidi.manager.hbm.engine.wfobj.base 
* @Description: TODO(检查流程节点是否包含有子节点) 
* @author 王顺波
* @date 2017年11月20日 上午10:03:45 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.wfobj.base;

import com.khidi.manager.hbmwf.engine.wfobj.HbmwfNode;

public class HbmNodehaveSon {
	private boolean rtn;

	// 检查流程节点是否包含有子节点
	public void NodeHaveSonCheck(HbmwfNode pParenOrRparentNode, HbmwfNode pSonNode) {
		if (pParenOrRparentNode.getNodeId().equals(pSonNode.getNodeId())) {
			rtn = true;
		}
		if (pParenOrRparentNode.getNextNodes() != null) {

			for (HbmwfNode lpNode : pParenOrRparentNode.getNextNodes()) {
				NodeHaveSonCheck(lpNode, pSonNode);
			}
		}
	}

	// 返回计算结果
	public boolean GetResult() {
		return rtn;
	}
}
