package com.khidi.manager.sys.controller;
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
import com.khidi.manager.sys.entity.SysDictEntity;
import com.khidi.manager.sys.service.SysDictService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;
/**
 * 系统字典管理
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 16:49:47
 */
@RestController
@RequestMapping("sysdict")
@Api(value = "/SysDict", description = "系统字典管理")
public class SysDictController {
	@Autowired
	private SysDictService sysDictService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
//	@RequiresPermissions("sys:dict:list")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="createTime",required=false) Date createTime,
                  @RequestParam(value="dictValue",required=false) String dictValue,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="dictType",required=false) String dictType,
                  @RequestParam(value="dictName",required=false) String dictName
				  ){
        Map<String,Object> queryparams = new HashMap<String,Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
		if(dictValue != null){
    	queryparams.put("dictValue",dictValue);
		}
		if(dictType != null){
    	queryparams.put("dictType",dictType);
		}
		if(dictName != null){
    	queryparams.put("dictName",dictName);
		}
		//查询列表数据
        Query query = new Query(queryparams);

		List<SysDictEntity> sysDictList = sysDictService.queryList(query);
		int total = sysDictService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysDictList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@RequiresPermissions("系统字典:查看")
    @ApiOperation(value = "信息",notes="")
	public R info(@PathVariable("id") String id){
		SysDictEntity sysDict = sysDictService.queryObject(id);
		
		return R.ok().put("sysDict", sysDict);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
	@RequiresPermissions("系统字典:管理")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody SysDictEntity sysDict){
		sysDictService.save(sysDict);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@RequiresPermissions("系统字典:管理")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody SysDictEntity sysDict){
		sysDictService.update(sysDict);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@RequiresPermissions("系统字典:管理")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				sysDictService.delete(strings[i]);
		}
		return R.ok();
	}
}