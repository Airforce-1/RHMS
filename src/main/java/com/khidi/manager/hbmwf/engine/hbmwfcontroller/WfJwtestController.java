package com.khidi.manager.hbmwf.engine.hbmwfcontroller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.khidi.manager.hbmwf.engine.domain.tst.HbmentComplexentOne;
import com.khidi.manager.hbmwf.engine.hbmwfservice.WfjwTestService;
import com.khidi.manager.hbmwf.engine.wfutil.HbmentAjaxIo;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfAjaxIo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

//@Api(value = "API - HBM  JW流程测试", description = "HBM  JW流程测试")
//@RestController
//@RequestMapping(value = "/wfjw")
public class WfJwtestController {
	@Autowired
	private WfjwTestService wfwjTestService;

	@ApiOperation(value = "参数封装测试", notes = "参数封装测试")
	@RequestMapping(value = "/complexOne", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo complexOne(@RequestBody HbmentComplexentOne hbmcomplexentOne) {

		HbmentComplexentOne rtn0 = wfwjTestService.GetJwTestResult(hbmcomplexentOne);
		//
		return HbmwfAjaxIo.GetReturn("1", "操作完成", rtn0);
	}

	@ApiOperation(value = "参数封装测试", notes = "参数封装测试")
	@RequestMapping(value = "/wfxml", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HbmentAjaxIo xmlWf(@ApiParam("wfxml") @RequestParam String wfxml,
			@ApiParam("wftitle") @RequestParam String wftitle) throws UnsupportedEncodingException, ParserConfigurationException, SAXException, IOException {

		String rtn0 = wfwjTestService.GetJsonWf(wfxml, wftitle);
		//
		return HbmwfAjaxIo.GetReturn("1", "操作完成", rtn0);
	}
}