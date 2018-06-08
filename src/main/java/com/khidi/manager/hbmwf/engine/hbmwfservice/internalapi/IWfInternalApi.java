/**   
* @Title: IWfInternalApi.java 
* @Package com.khidi.manager.hbmwf.engine.hbmwfservice 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年12月16日 下午3:26:49 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.hbmwfservice.internalapi;

import java.sql.SQLException;
import java.util.List;

import com.khidi.manager.hbmwf.engine.domain.HbmentWf;
import com.khidi.manager.hbmwf.engine.domain.HbmentWftmpl;
import com.khidi.manager.hbmwf.engine.wfutil.HbmentAjaxIo;

/**
 * @author Administrator
 *
 */
public interface IWfInternalApi {
	HbmentWf WfBindForm(String formType, String formId, int wfTmplId) throws SQLException;
	HbmentAjaxIo Veri(int handleId,boolean veriResult,String veriDesc) throws Exception;
	HbmentAjaxIo StartWf(String formType,String formId) throws Exception;
	List<HbmentWftmpl> QueryWfTmpl(String wfType) throws Exception;
}
