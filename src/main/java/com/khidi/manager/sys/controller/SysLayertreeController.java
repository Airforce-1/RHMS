package com.khidi.manager.sys.controller;

import com.khidi.common.utils.StringUtil;
import io.swagger.annotations.ApiParam;
import com.khidi.common.exception.RRException;
import org.apache.commons.lang.StringUtils;
import java.util.List;
import java.util.Map;
import java.util.Date;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.khidi.manager.sys.entity.SysLayertreeEntity;
import com.khidi.manager.sys.service.SysLayertreeService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;




/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-13 15:21:19
 */
@RestController
@RequestMapping("syslayertree")
@Api(value = "/SysLayertree", description = "图层树管理")
public class SysLayertreeController {
	@Autowired
	private SysLayertreeService sysLayertreeService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
    @ApiOperation(value = "列表",notes="")
	public R list(
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="name",required=false) String name,
                  @RequestParam(value="code",required=false) String code,
                  @RequestParam(value="type",required=false) String type,
                  @RequestParam(value="parentId",required=false) String parentId,
                  @RequestParam(value="icon",required=false) String icon,
                  @RequestParam(value="queryplant",required=false) String queryplant,
                  @RequestParam(value="title",required=false) String title,
                  @RequestParam(value="layersource",required=false) String layersource,
                  @RequestParam(value="args",required=false) String args,
                  @RequestParam(value="createtime",required=false) Date createtime				  ){
        Map<String,Object> queryparams = new HashMap<String,Object>();
		if(id != null){
    	queryparams.put("id",id);
		}
		if(name != null){
    	queryparams.put("name",name);
		}
		if(code != null){
    	queryparams.put("code",code);
		}
		if(type != null){
    	queryparams.put("type",type);
		}
		if(parentId != null){
    	queryparams.put("parentId",parentId);
		}
		if(icon != null){
    	queryparams.put("icon",icon);
		}
		if(queryplant != null){
    	queryparams.put("queryplant",queryplant);
		}
		if(title != null){
    	queryparams.put("title",title);
		}
		if(layersource != null){
    	queryparams.put("layersource",layersource);
		}
		if(args != null){
    	queryparams.put("args",args);
		}
		if(createtime != null){
    	queryparams.put("createtime",createtime);
		}
		List<SysLayertreeEntity> list =  sysLayertreeService.queryList(queryparams);

		for(SysLayertreeEntity entity:list){
			if(sysLayertreeService.queryCountbyParentId(entity.getId()) >0){
				entity.setOpen(true);
			}else{
				entity.setOpen(false);
			}
		}
		return R.ok().put("data", list);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("图层管理:查看")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		SysLayertreeEntity sysLayertree = sysLayertreeService.queryObject(id);
		List<SysLayertreeEntity> list = sysLayertreeService.querySonList(id);
		list.remove(sysLayertree);
		for(SysLayertreeEntity entity:list){
			if(sysLayertreeService.queryCountbyParentId(entity.getId()) >0){
				entity.setOpen(true);
			}else{
				entity.setOpen(false);
			}
		}
		sysLayertree.setList(list);
		return R.ok().put("data", sysLayertree);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("图层管理:管理")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody SysLayertreeEntity sysLayertree){
        verifyForm(sysLayertree);
		sysLayertreeService.save(sysLayertree);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("图层管理:管理")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody SysLayertreeEntity sysLayertree){
        verifyForm(sysLayertree);
		if(StringUtil.isNotEmpty(sysLayertreeService.queryParentIdIsCorrent(sysLayertree))){
			throw new RRException(180, "父节点不能为自身和自身子节点");
		}
		sysLayertreeService.update(sysLayertree);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("图层管理:管理")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				if( sysLayertreeService.queryCountbyParentId(strings[i]) > 0){
					throw new RRException(280,"请先删除子图层");
				}
				sysLayertreeService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(SysLayertreeEntity sysLayertree){
        if(StringUtils.isBlank(sysLayertree.getOrderNum())){
            throw new RRException(270,"排序号不能为空");
		}
	        if(StringUtils.isBlank(sysLayertree.getName())){
            throw new RRException(270,"图层名称不能为空");
		}
	        if(StringUtils.isBlank(sysLayertree.getParentId())){
            throw new RRException(270,"上级图层不能为空");
		}
	        if(StringUtils.isBlank(sysLayertree.getIcon())){
            throw new RRException(270,"图标不能为空");
		}
	    }


}