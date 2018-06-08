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

import com.khidi.manager.externaldata.entity.ExternalLinkEntity;
import com.khidi.manager.externaldata.service.ExternalLinkService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;




/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-18 16:16:33
 */
@RestController
@RequestMapping("externallink")
@Api(value = "/ExternalLink", description = "接口类型管理")
public class ExternalLinkController {
	@Autowired
	private ExternalLinkService externalLinkService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
//	@RequiresPermissions("externallink:list")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="area",required=false) String area,
                  @RequestParam(value="url",required=false) String url,
                  @RequestParam(value="rate",required=false) String rate,
                  @RequestParam(value="linkTable",required=false) String linkTable,
                  @RequestParam(value="enable",required=false) String enable,
                  @RequestParam(value="describe",required=false) String describe,
                  @RequestParam(value="createTime",required=false) Date createTime,
                  @RequestParam(value="method",required=false) String method,
                  @RequestParam(value="authorization",required=false) String authorization				  ){
        Map<String,Object> queryparams = new HashMap<String,Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
		if(id != null){
    	queryparams.put("id",id);
		}
		if(area != null){
    	queryparams.put("area",area);
		}
		if(url != null){
    	queryparams.put("url",url);
		}
		if(rate != null){
    	queryparams.put("rate",rate);
		}
		if(linkTable != null){
    	queryparams.put("linkTable",linkTable);
		}
		if(enable != null){
    	queryparams.put("enable",enable);
		}
		if(describe != null){
    	queryparams.put("describe",describe);
		}
		if(createTime != null){
    	queryparams.put("createTime",createTime);
		}
		if(method != null){
    	queryparams.put("method",method);
		}
		if(authorization != null){
    	queryparams.put("authorization",authorization);
		}
		//查询列表数据
        Query query = new Query(queryparams);

		List<ExternalLinkEntity> externalLinkList = externalLinkService.queryList(query);
		int total = externalLinkService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(externalLinkList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
//	@RequiresPermissions("externallink:info")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		ExternalLinkEntity externalLink = externalLinkService.queryObject(id);
		
		return R.ok().put("data", externalLink);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
//	@RequiresPermissions("externallink:save")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody ExternalLinkEntity externalLink){
        verifyForm(externalLink);
		externalLinkService.save(externalLink);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
//	@RequiresPermissions("externallink:update")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody ExternalLinkEntity externalLink){
        verifyForm(externalLink);
		externalLinkService.update(externalLink);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
//	@RequiresPermissions("externallink:delete")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				externalLinkService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(ExternalLinkEntity externalLink){
	        if(StringUtils.isBlank(externalLink.getArea())){
            throw new RRException(270,"连接区域不能为空");
		}
	        if(StringUtils.isBlank(externalLink.getUrl())){
            throw new RRException(270,"连接符不能为空");
		}
	        if(StringUtils.isBlank(externalLink.getLinkTable())){
            throw new RRException(270,"被关联表名不能为空");
		}
	        if(StringUtils.isBlank(externalLink.getEnable())){
            throw new RRException(270,"是否启用不能为空");
		}
	        if(StringUtils.isBlank(externalLink.getDescribe())){
            throw new RRException(270,"业务描述不能为空");
		}
	        if(StringUtils.isBlank(externalLink.getMethod())){
            throw new RRException(270,"连接支持的方法不能为空");
		}
	        if(StringUtils.isBlank(externalLink.getAuthorization())){
            throw new RRException(270,"验证符不能为空");
		}
	    }


}