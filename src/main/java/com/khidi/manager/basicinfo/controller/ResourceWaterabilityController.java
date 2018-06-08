package com.khidi.manager.basicinfo.controller;

import com.khidi.common.annotation.SysLog;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfAjaxIo;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.socialparticipation.entity.AppnewsEntity;
import com.khidi.manager.sys.controller.AbstractController;
import io.swagger.annotations.ApiParam;

import java.io.*;
import java.util.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.khidi.manager.basicinfo.entity.ResourceWaterabilityEntity;
import com.khidi.manager.basicinfo.service.ResourceWaterabilityService;
import com.khidi.common.exception.RRException;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 水功能区(保护区、保留区、限制开发区、开发利用区)信息管理
 *
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-24 08:27:48
 */
@RestController
@RequestMapping("resourcewaterability")
@Api(value = "/ResourceWaterability", description = "水功能区(保护区、保留区、限制开发区、开发利用区)信息管理")
public class ResourceWaterabilityController extends AbstractController {
    @Autowired
    private ResourceWaterabilityService resourceWaterabilityService;

    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @RequiresPermissions("水功能区:查看")
    @ApiOperation(value = "列表", notes = "")
    public R list(@RequestParam(value = "page", required = true) int page,
                  @RequestParam(value = "limit", required = true) int limit,
                  @RequestParam(value = "sidx", required = false) String sidx,
                  @RequestParam(value = "order", required = false) String order,
                  @RequestParam(value = "id", required = false) String id,
                  @RequestParam(value = "code", required = false) String code,
                  @RequestParam(value = "type", required = false) String type,
                  @RequestParam(value = "areaId", required = false) String areaId,
                  @RequestParam(value = "manager", required = false) String manager,
                  @RequestParam(value = "name", required = false) String name,
                  @RequestParam(value = "area", required = false) String area,
                  @RequestParam(value = "owner", required = false) String owner,
                  @RequestParam(value = "phone", required = false) String phone,
                  @RequestParam(value = "leftX", required = false) String leftX,
                  @RequestParam(value = "leftY", required = false) String leftY,
                  @RequestParam(value = "rightX", required = false) String rightX,
                  @RequestParam(value = "rightY", required = false) String rightY,
                  @RequestParam(value = "introduce", required = false) String introduce,
                  @RequestParam(value = "attachment", required = false) String attachment) {
        Map<String, Object> queryparams = new HashMap<String, Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
        if (id != null) {
            queryparams.put("id", id);
        }
        if (code != null) {
            queryparams.put("code", code);
        }
        if (type != null) {
            queryparams.put("type", type);
        }
        if (areaId != null) {
            queryparams.put("areaId", areaId);
        }
        if (manager != null) {
            queryparams.put("manager", manager);
        }
        if (name != null) {
            queryparams.put("name", name);
        }
        if (area != null) {
            queryparams.put("area", area);
        }
        if (owner != null) {
            queryparams.put("owner", owner);
        }
        if (phone != null) {
            queryparams.put("phone", phone);
        }
        if (leftX != null) {
            queryparams.put("leftX", leftX);
        }
        if (leftY != null) {
            queryparams.put("leftY", leftY);
        }
        if (rightX != null) {
            queryparams.put("rightX", rightX);
        }
        if (rightY != null) {
            queryparams.put("rightY", rightY);
        }
        if (introduce != null) {
            queryparams.put("introduce", introduce);
        }
        if (attachment != null) {
            queryparams.put("attachment", attachment);
        }
        // 查询列表数据
        Query query = new Query(queryparams);
        //加入用户角色的资源的过滤
        query.put("roleId", StringUtil.joinList4sql(getRole(), "','"));

        List<ResourceWaterabilityEntity> resourceWaterabilityList = resourceWaterabilityService.queryList(query);
        int total = resourceWaterabilityService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(resourceWaterabilityList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @RequiresPermissions("水功能区:查看")
    @ApiOperation(value = "信息", notes = "")
    public R info(@PathVariable("id") String id) {
        ResourceWaterabilityEntity resourceWaterability = resourceWaterabilityService.queryObject(id);

        return R.ok().put("resourceWaterability", resourceWaterability);
    }

    /**
     * 保存
     */
    @SysLog("保存水功能区信息")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @RequiresPermissions("水功能区:管理")
    @ApiOperation(value = "保存", notes = "")
    public R save(@RequestBody ResourceWaterabilityEntity resourceWaterability) {
        verifyForm(resourceWaterability);
        resourceWaterabilityService.save(resourceWaterability);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改水功能区信息")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @RequiresPermissions("水功能区:管理")
    @ApiOperation(value = "修改", notes = "")
    public R update(@RequestBody ResourceWaterabilityEntity resourceWaterability) {
        verifyForm(resourceWaterability);
        resourceWaterabilityService.update(resourceWaterability);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除水功能区信息")
    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    @RequiresPermissions("水功能区:管理")
    @ApiOperation(value = "删除", notes = "")
    public R delete(@PathVariable("ids") String ids) {
        String[] strings = ids.split(",");
        for (int i = 0; i < strings.length; i++) {
            resourceWaterabilityService.delete(strings[i]);
        }
        return R.ok();
    }




    private void verifyForm(ResourceWaterabilityEntity resourceWaterability) {
        if (StringUtils.isBlank(resourceWaterability.getCode())) {
            throw new RRException(270, "保护区编码不能为空");
        }
        if (StringUtils.isBlank(resourceWaterability.getAreaId())) {
            throw new RRException(270, "行政区划不能为空");
        }
        if (StringUtils.isBlank(resourceWaterability.getName())) {
            throw new RRException(270, "保护区名称不能为空");
        }
    }
}