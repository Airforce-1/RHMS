package com.khidi.manager.gis.controller;

import com.khidi.common.utils.R;
import com.khidi.manager.gis.entity.DrawMapEntity;
import com.khidi.manager.gis.service.DrawMapService;
import com.khidi.manager.monitoringnet.service.DataAirService;
import com.khidi.manager.monitoringnet.service.HydrologydataService;
import com.khidi.manager.monitoringnet.service.WaterqualitydataService;
import com.khidi.manager.sys.controller.AbstractController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
@RestController
@RequestMapping("stationinfo")
@Api(value = "/stationinfo", description = "返回测点(水文、水质、空气质量)最新信息")
public class StationInfoController extends AbstractController {
    @Autowired
    private HydrologydataService hydrologydataService;
    @Autowired
    private WaterqualitydataService waterqualitydataService;
    @Autowired
    private DataAirService dataAirService;
    /**
     * 返回水文监测站  最新一条水文监测数据
     */
    @RequestMapping(value="/hydrologydata",method = RequestMethod.GET)
    @ApiOperation(value = "保存",notes="返回水文监测站  最新一条水文监测数据")
    public R hydrologydata4top(@RequestParam String stationId){
        return R.ok().put("data",hydrologydataService.queryObjectfortop(stationId));
    }

    /**
     * 返回水质监测站  最新一条水质监测数据
     */
    @RequestMapping(value="/waterqualitydata",method = RequestMethod.GET)
    @ApiOperation(value = "保存",notes="返回水质监测站  最新一条水质监测数据")
    public R waterqualitydata4top(@RequestParam String stationId){
        return R.ok().put("data", waterqualitydataService.queryObjectfortop(stationId));
    }

    /**
     * 根据传入的stationId返回生态补偿金数据和水质数据
     */
    @RequestMapping(value="/gisstationdata",method = RequestMethod.GET)
    @ApiOperation(value = "保存",notes="返回水质监测站  最新一条水质监测数据")
    public R getWQStationInfo(@RequestParam String stationId){
        return R.ok().put("data", waterqualitydataService.getWQStationInfo(stationId));
    }


    /**
     * 根据传入的stationId返回空气质量最新一条记录
     */
    @RequestMapping(value="/airstationdata",method = RequestMethod.GET)
    @ApiOperation(value = "保存",notes="返回水质监测站  最新一条水质监测数据")
    public R getAirStationInfo(@RequestParam String stationId){
        return R.ok().put("data", dataAirService.getAir4Gis(stationId));
    }
}
