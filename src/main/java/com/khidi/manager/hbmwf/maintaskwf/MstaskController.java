/**   
* @Title: mstaskController.java 
* @Package com.khidi.manager.hbmwf.maintaskwf 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2018年1月12日 上午11:50:50 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.maintaskwf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Administrator
 *
 */
@Api(value = "API - 六大任务流程", description = "六大任务流程")
@RestController
@RequestMapping(value = "/wf")
public class MstaskController {
	@Autowired
	private MstaskService  mstService;
	
	@ApiOperation(value = "读取form和流程", notes = "读取form和流程")
	@RequestMapping(value = "/getStWf", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String getStWf(@ApiParam("id") @RequestParam String id,@ApiParam("wfType") @RequestParam String wfType)
	{
		return mstService.GetStWf(id, EnumWfType.valueOf(wfType));
	}
}
