package com.khidi.manager.gis.controller;

import com.khidi.common.annotation.SysLog;
import com.khidi.common.exception.RRException;
import com.khidi.common.utils.R;
import com.khidi.manager.basicinfo.service.CanalService;
import com.khidi.manager.basicinfo.service.PartCanalService;
import com.khidi.manager.gis.entity.ResourceMapEntity;
import com.khidi.manager.sys.controller.AbstractController;
import com.khidi.manager.sys.service.SysRoleResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.khidi.manager.gis.service.ResourceMapService;
/**
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
@RestController
@RequestMapping("resourcemap")
@Api(value = "/resourcemap", description = "资源信息与地图信息关联管理")
public class ResourceMapController extends AbstractController {
    @Autowired
    private ResourceMapService resourceMapService;

    /**
     * 河流信息关联地图资源
     */
    @SysLog("关联河流与地图信息")
    @RequestMapping(value="/river",method = RequestMethod.PUT)
//    @RequiresPermissions("river:save")
    @ApiOperation(value = "保存",notes="河流信息关联地图资源")
    public R saveRiverFeatureId(@RequestBody ResourceMapEntity entity){
        verifyForm(entity);
        resourceMapService.updateRiverFeatureId(entity);
        return R.ok();
    }


    /**
     * 河段信息关联地图资源
     */
    @SysLog("关联河段与地图信息")
    @RequestMapping(value="/partriver",method = RequestMethod.PUT)
//    @RequiresPermissions("partriver:save")
    @ApiOperation(value = "保存",notes="河段信息关联地图资源")
    public R savePartRiverFeatureId(@RequestBody ResourceMapEntity entity){
        verifyForm(entity);
        resourceMapService.updatePartRiverFeatureId(entity);
        return R.ok();
    }


    /**
     * 渠道信息关联地图资源
     */
    @SysLog("关联渠道与地图信息")
    @RequestMapping(value="/canal",method = RequestMethod.PUT)
//    @RequiresPermissions("canal:save")
    @ApiOperation(value = "保存",notes="渠道信息关联地图资源")
    public R saveCanalFeatureId(@RequestBody ResourceMapEntity entity){
        verifyForm(entity);
        resourceMapService.updateCanalFeatureId(entity);
        return R.ok();
    }


    /**
     * 渠段信息关联地图资源
     */
    @SysLog("关联渠段与地图信息")
    @RequestMapping(value="/partcanal",method = RequestMethod.PUT)
//    @RequiresPermissions("partcanal:save")
    @ApiOperation(value = "保存",notes="渠段信息关联地图资源")
    public R savePartCanalFeatureId(@RequestBody ResourceMapEntity entity){
        verifyForm(entity);
        resourceMapService.updatePartCanalFeatureId(entity);
        return R.ok();
    }


    /**
     * 湖泊信息关联地图资源
     */
    @SysLog("关联湖泊与地图信息")
    @RequestMapping(value="/lake",method = RequestMethod.PUT)
//    @RequiresPermissions("lake:save")
    @ApiOperation(value = "保存",notes="湖泊信息关联地图资源")
    public R saveLakeFeatureId(@RequestBody ResourceMapEntity entity){
        verifyForm(entity);
        resourceMapService.updateLakeFeatureId(entity);
        return R.ok();
    }

    /**
     * 湖段信息关联地图资源
     */
    @SysLog("关联湖泊与地图信息")
    @RequestMapping(value="/partlake",method = RequestMethod.PUT)
//    @RequiresPermissions("partlake:save")
    @ApiOperation(value = "保存",notes="湖段信息关联地图资源")
    public R savePartLakeFeatureId(@RequestBody ResourceMapEntity entity){
        verifyForm(entity);
        resourceMapService.updatePartLakeFeatureId(entity);
        return R.ok();
    }


    /**
     * 水库信息关联地图资源
     */
    @SysLog("关联水库与地图信息")
    @RequestMapping(value="/reservoir",method = RequestMethod.PUT)
//    @RequiresPermissions("reservoir:save")
    @ApiOperation(value = "保存",notes="水库信息关联地图资源")
    public R saveReservoirFeatureId(@RequestBody ResourceMapEntity entity){
        verifyForm(entity);
        resourceMapService.updateReservoirFeatureId(entity);
        return R.ok();
    }

    /**
     * 库段信息关联地图资源
     */
    @SysLog("关联库段与地图信息")
    @RequestMapping(value="/partreservoir",method = RequestMethod.PUT)
//    @RequiresPermissions("partreservoir:save")
    @ApiOperation(value = "保存",notes="库段信息关联地图资源")
    public R savePartReservoirFeatureId(@RequestBody ResourceMapEntity entity){
        verifyForm(entity);
        resourceMapService.updatePartReservoirFeatureId(entity);
        return R.ok();
    }


    private void verifyForm(ResourceMapEntity entity) {
        if (StringUtils.isBlank(entity.getId())) {
            throw new RRException(270, "资源系统编码不能为空");
        }
        if (StringUtils.isBlank(entity.getFeatureId())) {
            throw new RRException(270, "地图编码不能为空");
        }
    }

}
