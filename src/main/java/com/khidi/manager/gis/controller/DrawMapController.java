package com.khidi.manager.gis.controller;

import com.khidi.common.annotation.SysLog;
import com.khidi.common.exception.RRException;
import com.khidi.common.utils.R;
import com.khidi.manager.basicinfo.service.CanalService;
import com.khidi.manager.basicinfo.service.PartCanalService;
import com.khidi.manager.gis.entity.DrawMapEntity;
import com.khidi.manager.gis.entity.ResourceMapEntity;
import com.khidi.manager.gis.service.DrawMapService;
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
@RequestMapping("drawmap")
@Api(value = "/drawmap", description = "绘制地图信息，对点集进行记录")
public class DrawMapController extends AbstractController {
    @Autowired
    private DrawMapService drawMapService;
    /**
     * 绘制水功能区图形
     */
    @RequestMapping(value="/waterability",method = RequestMethod.PUT)
    @RequiresPermissions("水功能区:管理")
    @ApiOperation(value = "保存",notes="绘制水功能区(保护区、保留区、限制开发区、开发利用区)图形")
    public R drawMap4WaterAbility(@RequestBody DrawMapEntity entity){
        drawMapService.drawMap4WaterAbility(entity);
        return R.ok();
    }

    /**
     * 绘制灌区图形
     */
    @RequestMapping(value="/irrigated",method = RequestMethod.PUT)
    @RequiresPermissions("灌区管理:管理")
    @ApiOperation(value = "保存",notes="绘制灌区图形")
    public R drawMap4Irrigated(@RequestBody DrawMapEntity entity){
        drawMapService.drawMap4Irrigated(entity);
        return R.ok();
    }



}
