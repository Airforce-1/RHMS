package com.khidi.manager.basicinfo.controller;

import com.khidi.common.annotation.SysLog;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.sys.controller.AbstractController;
import com.khidi.manager.sys.entity.SysRoleResourceEntity;
import com.khidi.manager.sys.service.SysRoleResourceService;
import io.swagger.annotations.ApiParam;

import java.util.List;
import java.util.Map;
import java.util.Date;

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
import org.apache.commons.lang.StringUtils;

import com.khidi.common.exception.RRException;
import com.khidi.manager.basicinfo.entity.CanalEntity;
import com.khidi.manager.basicinfo.entity.PartCanalEntity;
import com.khidi.manager.basicinfo.service.PartCanalService;
import com.khidi.common.exception.RRException;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;

import java.util.HashMap;

/**
 * ${comments}
 *
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */
@RestController
@RequestMapping("partcanal")
@Api(value = "/PartCanal", description = "渠段基础信息管理")
public class PartCanalController extends AbstractController {
    @Autowired
    private PartCanalService partCanalService;
    @Autowired
    private SysRoleResourceService sysRoleResourceService;

    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @RequiresPermissions("渠道:查看")
    @ApiOperation(value = "列表", notes = "")
    public R list(@RequestParam(value = "page", required = true) int page,
                  @RequestParam(value = "limit", required = true) int limit,
                  @RequestParam(value = "sidx", required = false) String sidx,
                  @RequestParam(value = "order", required = false) String order,
                  @RequestParam(value = "id", required = false) String id,
                  @RequestParam(value = "canalId", required = false) String canalId,
                  @RequestParam(value = "name", required = false) String name,
                  @RequestParam(value = "code", required = false) String code,
                  @RequestParam(value = "areaId", required = false) String areaId,
                  @RequestParam(value = "alias", required = false) String alias,
                  @RequestParam(value = "riverStart", required = false) String riverStart,
                  @RequestParam(value = "riverEnd", required = false) String riverEnd,
                  @RequestParam(value = "startX", required = false) String startX,
                  @RequestParam(value = "startY", required = false) String startY,
                  @RequestParam(value = "endX", required = false) String endX,
                  @RequestParam(value = "endY", required = false) String endY,
                  @RequestParam(value = "length", required = false) String length,
                  @RequestParam(value = "remark", required = false) String remark) {
        Map<String, Object> queryparams = new HashMap<String, Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
        if (id != null) {
            queryparams.put("id", id);
        }
        if (canalId != null) {
            queryparams.put("canalId", canalId);
        }
        if (name != null) {
            queryparams.put("name", name);
        }
        if (code != null) {
            queryparams.put("code", code);
        }
        if (areaId != null) {
            queryparams.put("areaId", areaId);
        }
        if (alias != null) {
            queryparams.put("alias", alias);
        }
        if (riverStart != null) {
            queryparams.put("riverStart", riverStart);
        }
        if (riverEnd != null) {
            queryparams.put("riverEnd", riverEnd);
        }
        if (startX != null) {
            queryparams.put("startX", startX);
        }
        if (startY != null) {
            queryparams.put("startY", startY);
        }
        if (endX != null) {
            queryparams.put("endX", endX);
        }
        if (endY != null) {
            queryparams.put("endY", endY);
        }
        if (length != null) {
            queryparams.put("length", length);
        }
        if (remark != null) {
            queryparams.put("remark", remark);
        }
        // 查询列表数据
        Query query = new Query(queryparams);
        //加入用户角色的资源的过滤
        Boolean isfilter = true;   //是否加入渠段的过滤
        for(String roleId:getRole()){
            if(sysRoleResourceService.queryObjectByRoleId(roleId) ==null) continue;
            String canalIds = sysRoleResourceService.queryObjectByRoleId(roleId).getCanalids();
            //如果没有传入渠道id，则返回所有渠段
            if(StringUtil.isEmpty(canalId)){
                isfilter = false;
                break;
            }
            //如果sys_role_resource中有该渠道权限，则不介入权限控制，返回该渠道所有渠段
            if(StringUtil.isNotEmpty(canalIds)  && canalIds.contains(canalId)){
                isfilter = false;
            }
        }
        if(isfilter){
            query.put("roleId", StringUtil.joinList4sql(getRole(),"','"));
        }
        List<PartCanalEntity> partCanalList = partCanalService.queryList(query);
        int total = partCanalService.queryTotal(query);


        PageUtils pageUtil = new PageUtils(partCanalList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @RequiresPermissions("渠道:查看")
    @ApiOperation(value = "信息", notes = "")
    public R info(@PathVariable("id") String id) {
        PartCanalEntity partCanal = partCanalService.queryObject(id);

        return R.ok().put("partCanal", partCanal);
    }

    /**
     * 保存
     */
    @SysLog("保存渠段信息")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @RequiresPermissions("渠道:管理")
    @ApiOperation(value = "保存", notes = "")
    public R save(@RequestBody PartCanalEntity partCanal) {
        verifyForm(partCanal);
        partCanalService.save(partCanal);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改渠段信息")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @RequiresPermissions("渠道:管理")
    @ApiOperation(value = "修改", notes = "")
    public R update(@RequestBody PartCanalEntity partCanal) {
        verifyForm(partCanal);
        partCanalService.update(partCanal);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除渠段信息")
    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    @RequiresPermissions("渠道:管理")
    @ApiOperation(value = "删除", notes = "")
    public R delete(@PathVariable("ids") String ids) {
        String[] strings = ids.split(",");
        for (int i = 0; i < strings.length; i++) {
            partCanalService.delete(strings[i]);
        }
        return R.ok();
    }

    private void verifyForm(PartCanalEntity partCanal) {
        if (StringUtils.isBlank(partCanal.getCode())) {
            throw new RRException(270, "渠道编码不能为空");
        }
        if (StringUtils.isBlank(partCanal.getName())) {
            throw new RRException(270, "渠道名称不能为空");
        }
        if (StringUtils.isBlank(partCanal.getAreaId())) {
            throw new RRException(270, "所属行政区划不能为空");
        }
    }
}
