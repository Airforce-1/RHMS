package com.khidi.manager.sys.controller;

import com.khidi.common.utils.Constant;
import com.khidi.common.utils.R;
import com.khidi.manager.basicinfo.entity.*;
import com.khidi.manager.basicinfo.service.*;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfAjaxIo;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.sys.entity.FileUploadEntity;
import com.khidi.manager.sys.entity.SysDeptEntity;
import com.khidi.manager.sys.redis.EnumUploadOpType;
import com.khidi.manager.sys.redis.PathUtil;
import com.khidi.manager.sys.redis.UploadCfg;
import com.khidi.manager.sys.service.CommonService;
import com.khidi.manager.sys.service.FileuploadService;
import com.khidi.manager.sys.service.SysAreaService;
import com.khidi.manager.sys.service.SysDeptService;
import com.khidi.manager.sys.vo.ResourceVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;


/**
 * 部门管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-20 15:23:47
 */
@RestController
@RequestMapping("/sys/common")
@Api(value="/sys/common",description="公共方法")
public class CommonController extends AbstractController {

	@Autowired
	private CommonService commonService;





	/**
	 * 根据传入的河湖渠库（段）类型返回所有对应类型list
	 */
	@ApiOperation(value="根据传入的河湖渠库（段）类型返回所有对应类型list", notes="根据传入的河湖渠库（段）类型返回所有对应类型list")
	@RequestMapping(path="/resourcetype/{Id}",method=RequestMethod.GET)
	public R resourceList(@PathVariable("Id") String Id){

		return R.ok().put("data",commonService.resourceList(Id));
	}



	/**
	 * 根据传入的监测站类型返回所有对应监测站list
	 */
	@ApiOperation(value="根据传入的监测站类型返回所有对应监测站list", notes="根据传入的监测站类型返回所有对应监测站list")
	@RequestMapping(path="/stationtype/{Id}",method=RequestMethod.GET)
	public R stationList(@PathVariable("Id") String Id){
		return R.ok().put("data",commonService.stationList(Id));
	}


	/**
	 * 根据河流类型和河流编码获取行政区划级别
	 */
	@ApiOperation(value="根据河流类型和河流编码获取行政区划级别", notes="根据河流类型和河流编码获取行政区划级别")
	@RequestMapping(path="/getAreaGrade",method=RequestMethod.GET)
	public R areaGrade(@ApiParam("type") @RequestParam String type,
					   @ApiParam("Id") @RequestParam String Id){
		return R.ok().put("data",commonService.getAreaGrade(type,Id));
	}

	/**
	 * 根据河流类型和河流编码获取河长
	 */
	@ApiOperation(value="根据河流类型和河流编码获取河长", notes="根据河流类型和河流编码获取河长")
	@RequestMapping(path="/getHz",method=RequestMethod.GET)
	public R getHz(@ApiParam("type") @RequestParam String type,
					   @ApiParam("Id") @RequestParam String Id){
		return R.ok().put("data",commonService.getHz(type,Id));
	}


}
