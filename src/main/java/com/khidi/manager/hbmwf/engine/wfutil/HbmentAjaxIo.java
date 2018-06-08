/**   
* @Title: HbmentAjaxIo.java 
* @Package com.khidi.manager.hbm.engine.wfutil 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月20日 上午11:02:29 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.wfutil;

/**
 * @author Administrator
 *
 */
public class HbmentAjaxIo {
	private String code;
	private String msg;
	private Object attachRtnL;
	private Object attachRtnR;
	//
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getAttachRtnL() {
		return attachRtnL;
	}
	public void setAttachRtnL(Object attachRtnL) {
		this.attachRtnL = attachRtnL;
	}
	public Object getAttachRtnR() {
		return attachRtnR;
	}
	public void setAttachRtnR(Object attachRtnR) {
		this.attachRtnR = attachRtnR;
	}
}
