/**   
* @Title: HbmwfIo.java 
* @Package com.khidi.manager.hbm.engine.wfutil 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月20日 上午11:00:31 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.wfutil;

/**
 * @author Administrator
 *
 */
public class HbmwfAjaxIo {
	public static HbmentAjaxIo GetReturn(String code, String msg, Object attachMsg) {
		String _code = code;
		if(_code.equals("1"))
		{
			_code = "0";
		}
		else
		{
			if(_code.equals("0"))
			{
				_code = "1";
			}
		}
		//
		HbmentAjaxIo rtn  = new HbmentAjaxIo();
		rtn.setAttachRtnL(attachMsg);
		rtn.setCode(_code);
		rtn.setMsg(msg);
		return rtn;
	}
	
	public static HbmentAjaxIo GetReturn(String code, String msg, Object attachMsgL,Object attachMsgR)
	{
		String _code = code;
		if(_code.equals("1"))
		{
			_code = "0";
		}
		else
		{
			if(_code.equals("0"))
			{
				_code = "1";
			}
		}
		//
		HbmentAjaxIo rtn  = new HbmentAjaxIo();
		rtn.setAttachRtnL(attachMsgL);
		rtn.setAttachRtnR(attachMsgR);
		rtn.setCode(_code);
		rtn.setMsg(msg);
		return rtn;
	}
}
