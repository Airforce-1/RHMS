/**   
* @Title: WfTmplController.java 
* @Package com.khidi.manager.hbm.engine.hbmwfcontroller 
* @Description: TODO(流程本省功能测试用 Service) 
* @author 王顺波
* @date 2017年11月20日 上午9:57:43 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.hbmwfservice;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.khidi.manager.hbmwf.engine.domain.tst.HbmentComplexentOne;
import com.khidi.manager.hbmwf.engine.wfutil.HbmXml;

@Component
@Qualifier("WfjwTestService")
public class WfjwTestService {
	// 流程测试方法之一: 复杂对象传递测试
	public HbmentComplexentOne GetJwTestResult(HbmentComplexentOne complexEntOne)
	{
		System.out.println("id:" + complexEntOne.getId());
		System.out.println("name:" + complexEntOne.getName());
		System.out.println("complexObj:" + complexEntOne.getComplexobj().get(0).getDesc());
		//
		
		//
		return complexEntOne;
	}
	
	
	// 流程测试方法之一: 流程内容转换测试
	public String GetJsonWf(String xml,String title) throws UnsupportedEncodingException, ParserConfigurationException, SAXException, IOException
	{
		return HbmXml.GetFlowJson(xml, title);
	}
}
