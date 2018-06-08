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

import com.khidi.manager.externaldata.entity.EcoCompensationEntity;
import com.khidi.manager.externaldata.service.EcoCompensationService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import java.util.HashMap;




/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-17 16:39:02
 */
@RestController
@RequestMapping("ecocompensation")
@Api(value = "/EcoCompensation", description = "生态补偿金管理")
public class EcoCompensationController {
	@Autowired
	private EcoCompensationService ecoCompensationService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
//	@RequiresPermissions("ecocompensation:list")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
                  @RequestParam(value="sidx",required=false) String sidx,
                  @RequestParam(value="order",required=false) String order,
                  @RequestParam(value="id",required=false) String id,
                  @RequestParam(value="aimType",required=false) String aimType,
                  @RequestParam(value="currentType",required=false) String currentType,
                  @RequestParam(value="factor",required=false) String factor,
                  @RequestParam(value="codOut",required=false) String codOut,
                  @RequestParam(value="nhOut",required=false) String nhOut,
                  @RequestParam(value="pOut",required=false) String pOut,
                  @RequestParam(value="ecoCompensation",required=false) String ecoCompensation,
                  @RequestParam(value="cod",required=false) String cod,
                  @RequestParam(value="nh",required=false) String nh,
                  @RequestParam(value="p",required=false) String p,
                  @RequestParam(value="monitorTime",required=false) String monitorTime				  ){
        Map<String,Object> queryparams = new HashMap<String,Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
		if(id != null){
    	queryparams.put("id",id);
		}
		if(aimType != null){
    	queryparams.put("aimType",aimType);
		}
		if(currentType != null){
    	queryparams.put("currentType",currentType);
		}
		if(factor != null){
    	queryparams.put("factor",factor);
		}
		if(codOut != null){
    	queryparams.put("codOut",codOut);
		}
		if(nhOut != null){
    	queryparams.put("nhOut",nhOut);
		}
		if(pOut != null){
    	queryparams.put("pOut",pOut);
		}
		if(ecoCompensation != null){
    	queryparams.put("ecoCompensation",ecoCompensation);
		}
		if(cod != null){
    	queryparams.put("cod",cod);
		}
		if(nh != null){
    	queryparams.put("nh",nh);
		}
		if(p != null){
    	queryparams.put("p",p);
		}
		if(monitorTime != null){
    	queryparams.put("monitorTime",monitorTime);
		}
		//查询列表数据
        Query query = new Query(queryparams);

		List<EcoCompensationEntity> ecoCompensationList = ecoCompensationService.queryList(query);
		int total = ecoCompensationService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(ecoCompensationList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/{stationId}",method = RequestMethod.GET)
//	@RequiresPermissions("ecocompensation:info")
    @ApiOperation(value = "信息",notes="")
	public R queryListByStationId(@PathVariable("stationId") String stationId){
		return R.ok().put("page", ecoCompensationService.queryListByStationId(stationId));
	}
















	/**
	 * 保存
	 */
	@RequestMapping(value="",method = RequestMethod.POST)
//	@RequiresPermissions("ecocompensation:save")
    @ApiOperation(value = "保存",notes="")
	public R save(@RequestBody EcoCompensationEntity ecoCompensation){
        verifyForm(ecoCompensation);
		ecoCompensationService.save(ecoCompensation);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
//	@RequiresPermissions("ecocompensation:update")
    @ApiOperation(value = "修改",notes="")
	public R update(@RequestBody EcoCompensationEntity ecoCompensation){
        verifyForm(ecoCompensation);
		ecoCompensationService.update(ecoCompensation);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
//	@RequiresPermissions("ecocompensation:delete")
    @ApiOperation(value = "删除",notes="")
	public R delete(@PathVariable("ids") String ids){
        String[] strings = ids.split(",");
		for(int i=0;i<strings.length;i++){
				ecoCompensationService.delete(strings[i]);
		}
		return R.ok();
	}

    private void verifyForm(EcoCompensationEntity ecoCompensation){
        if(StringUtils.isBlank(ecoCompensation.getId())){
            throw new RRException(270,"系统编码不能为空");
		}
	        if(StringUtils.isBlank(ecoCompensation.getAimType())){
            throw new RRException(270,"目标水质类别不能为空");
		}
	        if(StringUtils.isBlank(ecoCompensation.getCurrentType())){
            throw new RRException(270,"当前水质类别不能为空");
		}
	        if(StringUtils.isBlank(ecoCompensation.getFactor())){
            throw new RRException(270,"污染因子不能为空");
		}
	        if(StringUtils.isBlank(ecoCompensation.getCodOut())){
            throw new RRException(270,"COD超标值不能为空");
		}
	        if(StringUtils.isBlank(ecoCompensation.getNhOut())){
            throw new RRException(270,"氨氮超标值不能为空");
		}
	        if(StringUtils.isBlank(ecoCompensation.getPOut())){
            throw new RRException(270,"总磷超标值不能为空");
		}
	        if(StringUtils.isBlank(ecoCompensation.getEcoCompensation())){
            throw new RRException(270,"生态补偿金(万)不能为空");
		}
	        if(StringUtils.isBlank(ecoCompensation.getCod())){
            throw new RRException(270,"COD不能为空");
		}
	        if(StringUtils.isBlank(ecoCompensation.getNh())){
            throw new RRException(270,"氨氮不能为空");
		}
	        if(StringUtils.isBlank(ecoCompensation.getP())){
            throw new RRException(270,"总磷不能为空");
		}
	        if(StringUtils.isBlank(ecoCompensation.getMonitorTime())){
            throw new RRException(270,"监测时间不能为空");
		}
	    }


}