package com.khidi.manager.basicinfo.controller;
import com.khidi.common.annotation.SysLog;
import com.khidi.common.exception.MyNullException;
import com.khidi.common.exception.RRException;
import com.khidi.common.utils.*;
import com.khidi.manager.basicinfo.service.PartCanalService;
import com.khidi.manager.sys.controller.AbstractController;
import com.khidi.manager.sys.entity.SysRoleEntity;
import com.khidi.manager.sys.entity.SysRoleMenuEntity;
import com.khidi.manager.sys.entity.SysRoleResourceEntity;
import com.khidi.manager.sys.service.SysRoleResourceService;
import io.swagger.annotations.ApiParam;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.khidi.manager.basicinfo.entity.CanalEntity;
import com.khidi.manager.basicinfo.service.CanalService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.apache.ibatis.io.Resources.getResourceAsStream;
import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

/**
 * 渠道基础信息管理
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
@RestController
@RequestMapping("canal")
@Api(value = "/Canal", description = "渠道基础信息管理")
public class CanalController extends AbstractController {
	@Autowired
	private CanalService canalService;
	@Value("${file.server.address}")
	private String address;
	@Value("${file.server.port}")
	private String port;
	@Autowired
	private SysRoleResourceService sysRoleResourceService;
	@Autowired
	private PartCanalService partCanalService;
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("渠道:查看")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="createTime",required=false) Date createTime,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="name",required=false) String name,
                  @RequestParam(value="code",required=false) String code,
                  @RequestParam(value="areaId",required=false) String areaId,
                  @RequestParam(value="superName",required=false) String superName,
                  @RequestParam(value="superType",required=false) String superType,
                  @RequestParam(value="inputName",required=false) String inputName,
                  @RequestParam(value="inputType",required=false) String inputType,
                  @RequestParam(value="alias",required=false) String alias,
                  @RequestParam(value="riverstart",required=false) String riverstart,
                  @RequestParam(value="riverend",required=false) String riverend,
                  @RequestParam(value="startX",required=false) String startX,
                  @RequestParam(value="startY",required=false) String startY,
                  @RequestParam(value="endX",required=false) String endX,
                  @RequestParam(value="endY",required=false) String endY,
                  @RequestParam(value="function",required=false) String function,
                  @RequestParam(value="flow",required=false) String flow,
                  @RequestParam(value="crossType",required=false) String crossType,
                  @RequestParam(value="length",required=false) String length,
                  @RequestParam(value="gradient",required=false) String gradient,
                  @RequestParam(value="regions",required=false) String regions,
                  @RequestParam(value="remark",required=false) String remark ,
				  @RequestParam(value="parentId",required=false) String parentId
				  ){
        Map<String,Object> queryparams = new HashMap<String,Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
		if(createTime != null){
    	queryparams.put("createTime",createTime);
		}
		if(id != null){
    	queryparams.put("id",id);
		}
		if(parentId != null){
			queryparams.put("parentId",parentId);
		}
		if(name != null){
    	queryparams.put("name",name);
		}
		if(code != null){
    	queryparams.put("code",code);
		}
		if(areaId != null){
    	queryparams.put("areaId",areaId);
		}
		if(superName != null){
    	queryparams.put("superName",superName);
		}
		if(superType != null){
    	queryparams.put("superType",superType);
		}
		if(inputName != null){
    	queryparams.put("inputName",inputName);
		}
		if(inputType != null){
    	queryparams.put("inputType",inputType);
		}
		if(alias != null){
    	queryparams.put("alias",alias);
		}
		if(riverstart != null){
    	queryparams.put("riverstart",riverstart);
		}
		if(riverend != null){
    	queryparams.put("riverend",riverend);
		}
		if(startX != null){
    	queryparams.put("startX",startX);
		}
		if(startY != null){
    	queryparams.put("startY",startY);
		}
		if(endX != null){
    	queryparams.put("endX",endX);
		}
		if(endY != null){
    	queryparams.put("endY",endY);
		}
		if(function != null){
    	queryparams.put("function",function);
		}
		if(flow != null){
    	queryparams.put("flow",flow);
		}
		if(crossType != null){
    	queryparams.put("crossType",crossType);
		}
		if(length != null){
    	queryparams.put("length",length);
		}
		if(gradient != null){
    	queryparams.put("gradient",gradient);
		}
		if(regions != null){
    	queryparams.put("regions",regions);
		}
		if(remark != null){
    	queryparams.put("remark",remark);
		}
		//查询列表数据
        Query query = new Query(queryparams);
		//加入用户角色的资源的过滤
		query.put("roleId",StringUtil.joinList4sql(getRole(),"','"));
		int total = canalService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(canalService.queryList(query), total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("渠道:查看")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		CanalEntity canal = canalService.queryObject(id);
		
		return R.ok().put("canal", canal);
	}
	
	/**
	 * 保存
	 */
	@SysLog("保存渠道信息")
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("渠道:管理")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody CanalEntity canal){
		verifyForm(canal);
		canalService.save(canal);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@SysLog("修改渠道信息")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("渠道:管理")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody CanalEntity canal){
		verifyForm(canal);
		canalService.update(canal);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@SysLog("删除渠道信息")
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("渠道:管理")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
		String[] strings = ids.split(",");
		for(int i=0;i<strings.length; i++){
			if(partCanalService.queryListByCanalId(strings[i]).size()>0){
				throw  new RRException(200,"请先删除该渠道渠段");
			}
			canalService.delete(strings[i]);
		}
		return R.ok();
	}


	/**
	 * 下载导入模板
	 * @throws IOException
	 */
	@RequestMapping(value="/downLoadtemplet",method = RequestMethod.GET)
	@RequiresPermissions("渠道:管理")
	public R downLoad() throws IOException {
		return R.ok().put("data","http://"+address+":"+port+"/template/"+"渠道基本信息导入模板.xls");
	}


	/**
	 * 验证导入的数据
	 * @throws IOException
	 */
	@RequestMapping(value="/verify",method = RequestMethod.GET)
	@RequiresPermissions("渠道:管理")
	public R verify() throws IOException {
		return R.ok().put("data",address+":"+port+"/template/"+"渠道基本信息导入模板.xls");
	}





	/**
	 * 导出数据
	 * @throws IOException
	 */
	@RequestMapping(value="/excelexport",method = RequestMethod.GET)
	@RequiresPermissions("渠道:管理")
	public R excelexport() throws IOException {
		return R.ok().put("data",address+":"+port+"/template/"+"渠道基本信息导入模板.xls");
	}

	private void verifyForm(CanalEntity canal) {
		if (StringUtils.isBlank(canal.getCode())) {
			throw new RRException(270, "渠道编码不能为空");
		}
		if (StringUtils.isBlank(canal.getName())) {
			throw new RRException(270, "渠道名称不能为空");

		}
		if (StringUtils.isBlank(canal.getAreaId())) {
			throw new RRException(270, "所属行政区划不能为空");
		}
		if(StringUtils.isBlank(canal.getStartX())){
			throw new RRException(270,"渠首经度不能为空");
		}
		if(StringUtils.isBlank(canal.getStartY())){
			throw new RRException(270,"渠首纬度不能为空");
		}
		if(StringUtils.isBlank(canal.getEndX())){
			throw new RRException(270,"渠尾经度不能为空");
		}
		if(StringUtils.isBlank(canal.getEndY())){
			throw new RRException(270,"渠尾纬度不能为空");
		}
	}
}
