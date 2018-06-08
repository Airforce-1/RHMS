package com.khidi.manager.externaldata.controller;

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

import com.khidi.manager.externaldata.entity.ExternalAttributeEntity;
import com.khidi.manager.externaldata.service.ExternalAttributeService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;




/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-18 15:14:19
 */
@RestController
@RequestMapping("externalattribute")
@Api(value = "/ExternalAttribute", description = "接口属性管理")
public class ExternalAttributeController {
	@Autowired
	private ExternalAttributeService externalAttributeService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
//	@RequiresPermissions("externalattribute:list")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="linkId",required=false) String linkId,
                  @RequestParam(value="destAttr",required=false) String destAttr,
                  @RequestParam(value="destType",required=false) String destType,
                  @RequestParam(value="originAttr",required=false) String originAttr,
                  @RequestParam(value="originType",required=false) String originType,
                  @RequestParam(value="createTime",required=false) Date createTime				  ){
        Map<String,Object> queryparams = new HashMap<String,Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
		if(id != null){
    	queryparams.put("id",id);
		}
		if(linkId != null){
    	queryparams.put("linkId",linkId);
		}
		if(destAttr != null){
    	queryparams.put("destAttr",destAttr);
		}
		if(destType != null){
    	queryparams.put("destType",destType);
		}
		if(originAttr != null){
    	queryparams.put("originAttr",originAttr);
		}
		if(originType != null){
    	queryparams.put("originType",originType);
		}
		if(createTime != null){
    	queryparams.put("createTime",createTime);
		}
		//查询列表数据
        Query query = new Query(queryparams);

		List<ExternalAttributeEntity> externalAttributeList = externalAttributeService.queryList(query);
		int total = externalAttributeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(externalAttributeList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
//	@RequiresPermissions("externalattribute:info")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		ExternalAttributeEntity externalAttribute = externalAttributeService.queryObject(id);
		
		return R.ok().put("data", externalAttribute);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
//	@RequiresPermissions("externalattribute:save")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody ExternalAttributeEntity externalAttribute){
        verifyForm(externalAttribute);
		externalAttributeService.save(externalAttribute);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
//	@RequiresPermissions("externalattribute:update")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody ExternalAttributeEntity externalAttribute){
        verifyForm(externalAttribute);
		externalAttributeService.update(externalAttribute);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
//	@RequiresPermissions("externalattribute:delete")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				externalAttributeService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(ExternalAttributeEntity externalAttribute){
	        if(StringUtils.isBlank(externalAttribute.getLinkId())){
            throw new RRException(270,"连接区域不能为空");
		}
	        if(StringUtils.isBlank(externalAttribute.getDestAttr())){
            throw new RRException(270,"目标属性不能为空");
		}
	        if(StringUtils.isBlank(externalAttribute.getDestType())){
            throw new RRException(270,"目标属性类型不能为空");
		}
	        if(StringUtils.isBlank(externalAttribute.getOriginAttr())){
            throw new RRException(270,"源数据属性不能为空");
		}
	}
}