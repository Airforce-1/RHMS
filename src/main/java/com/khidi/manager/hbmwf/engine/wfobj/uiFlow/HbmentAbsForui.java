/**   
* @Title: HbmentAbsForui.java 
* @Package com.khidi.manager.hbm.engine.wfobj.uiFlow 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年12月5日 上午10:18:04 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.wfobj.uiFlow;

/**
 * @author Administrator
 *
 */
// 返回给UI的接收者
public class HbmentAbsForui {
	// 编号
	private String cid;
	// 名称
	private String cname;
	// 接收者类型
	private String ctype;
	// 接收者关联ID0
	private String attid0;
	// 接收者关联ID1
	private String attid1;
	
	
	public String getAttid0() {
		return attid0;
	}
	public void setAttid0(String attid0) {
		this.attid0 = attid0;
	}
	public String getAttid1() {
		return attid1;
	}
	public void setAttid1(String attid1) {
		this.attid1 = attid1;
	}
	//
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
}
