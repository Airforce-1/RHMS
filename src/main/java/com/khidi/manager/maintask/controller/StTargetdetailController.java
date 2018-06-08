package com.khidi.manager.maintask.controller;

import com.khidi.common.utils.CurrentSession;
import com.khidi.manager.maintask.service.StCommonService;
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

import com.khidi.manager.maintask.entity.StTargetdetailEntity;
import com.khidi.manager.maintask.service.StTargetdetailService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;

import java.util.HashMap;


/**
 * ${comments}
 *
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-03 10:29:04
 */
@RestController
@RequestMapping("sttargetdetail")
@Api(value = "/StTargetdetail", description = "市级/县区级 实际目标明细")
public class StTargetdetailController {
    @Autowired
    private StTargetdetailService stTargetdetailService;
    @Autowired
    private StCommonService stCommonService;

    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @RequiresPermissions("六大任务:查看")
    @ApiOperation(value = "列表", notes = "")
    public R list(@RequestParam(value = "page", required = true) int page,
                  @RequestParam(value = "limit", required = true) int limit,
                  @RequestParam(value = "sidx", required = false) String sidx,
                  @RequestParam(value = "order", required = false) String order,
                  @RequestParam(value = "transmitDeptid", required = false) String transmitDeptid,
                  @RequestParam(value = "id", required = false) String id,
                  @RequestParam(value = "targetid", required = false) String targetid,
                  @RequestParam(value = "indicators", required = false) String indicators,
                  @RequestParam(value = "nowindicators", required = false) String nowindicators,
                  @RequestParam(value = "expectedindicators", required = false) String expectedindicators,
                  @RequestParam(value = "phaseone", required = false) String phaseone,
                  @RequestParam(value = "phasetwo", required = false) String phasetwo,
                  @RequestParam(value = "phasethree", required = false) String phasethree,
                  @RequestParam(value = "phasefour", required = false) String phasefour,
                  @RequestParam(value = "phasefive", required = false) String phasefive,
                  @RequestParam(value = "respdept", required = false) String respdept,
                  @RequestParam(value = "respuser", required = false) String respuser,
                  @RequestParam(value = "tel", required = false) String tel,
                  @RequestParam(value = "memo", required = false) String memo,
                  @RequestParam(value = "progress", required = false) Double progress,
                  @RequestParam(value = "targetglobaltype", required = false) String targetglobaltype,
                  @RequestParam(value = "attachid", required = false) String attachid,
                  @RequestParam(value = "acceptdeptid", required = false) String acceptdeptid,
                  @RequestParam(value = "acceptflag", required = false) String acceptflag,
                  @RequestParam(value = "acceptuserid", required = false) String acceptuserid,
                  @RequestParam(value = "accepttime", required = false) Date accepttime,
                  @RequestParam(value = "createtime", required = false) Date createtime,
                  @RequestParam(value = "todeptid", required = false) String todeptid,
                  @RequestParam(value = "transmituserid", required = false) String transmituserid,
                  @RequestParam(value = "lakeName", required = false) String lakeName,
                  @RequestParam(value = "lakeType", required = false) String lakeType,
                  @RequestParam(value = "targettype", required = false) String targettype,
                  @RequestParam(value = "targetName", required = false) String targetName,
                  @RequestParam(value = "transmittime", required = false) Date transmittime) {
        Map<String, Object> queryparams = new HashMap<String, Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
        queryparams.put("curdept", CurrentSession.GetDeptId());
        if (targetName != null) {
            queryparams.put("targetName", targetName);
        }
        if (targettype != null) {
            queryparams.put("targettype", targettype);
        }
        if (lakeType != null) {
            queryparams.put("lakeType", lakeType);
        }
        if (lakeName != null) {
            queryparams.put("lakeName", lakeName);
        }
        if (transmitDeptid != null) {
            queryparams.put("transmitDeptid", transmitDeptid);
        }
        if (id != null) {
            queryparams.put("id", id);
        }
        if (targetid != null) {
            queryparams.put("targetid", targetid);
        }
        if (indicators != null) {
            queryparams.put("indicators", indicators);
        }
        if (nowindicators != null) {
            queryparams.put("nowindicators", nowindicators);
        }
        if (expectedindicators != null) {
            queryparams.put("expectedindicators", expectedindicators);
        }
        if (phaseone != null) {
            queryparams.put("phaseone", phaseone);
        }
        if (phasetwo != null) {
            queryparams.put("phasetwo", phasetwo);
        }
        if (phasethree != null) {
            queryparams.put("phasethree", phasethree);
        }
        if (phasefour != null) {
            queryparams.put("phasefour", phasefour);
        }
        if (phasefive != null) {
            queryparams.put("phasefive", phasefive);
        }
        if (respdept != null) {
            queryparams.put("respdept", respdept);
        }
        if (respuser != null) {
            queryparams.put("respuser", respuser);
        }
        if (tel != null) {
            queryparams.put("tel", tel);
        }
        if (memo != null) {
            queryparams.put("memo", memo);
        }
        if (progress != null) {
            queryparams.put("progress", progress);
        }
        if (targetglobaltype != null) {
            queryparams.put("targetglobaltype", targetglobaltype);
        }
        if (attachid != null) {
            queryparams.put("attachid", attachid);
        }
        if (acceptdeptid != null) {
            queryparams.put("acceptdeptid", acceptdeptid);
        }
        if (acceptflag != null) {
            queryparams.put("acceptflag", acceptflag);
        }
        if (acceptuserid != null) {
            queryparams.put("acceptuserid", acceptuserid);
        }
        if (accepttime != null) {
            queryparams.put("accepttime", accepttime);
        }
        if (createtime != null) {
            queryparams.put("createtime", createtime);
        }
        if (todeptid != null) {
            queryparams.put("todeptid", todeptid);
        }
        if (transmituserid != null) {
            queryparams.put("transmituserid", transmituserid);
        }
        if (transmittime != null) {
            queryparams.put("transmittime", transmittime);
        }
        //查询列表数据
        Query query = new Query(queryparams);

        List<StTargetdetailEntity> stTargetdetailList = stTargetdetailService.queryList(query);
        int total = stTargetdetailService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(stTargetdetailList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @RequiresPermissions("六大任务:查看")
    @ApiOperation(value = "信息", notes = "")
    public R info(@PathVariable("id") String id) {
        StTargetdetailEntity stTargetdetail = stTargetdetailService.queryObject(id);

        return R.ok().put("data", stTargetdetail);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @RequiresPermissions("六大任务:管理")
    @ApiOperation(value = "保存", notes = "")
    public R save(@RequestBody StTargetdetailEntity stTargetdetail) {
        verifyForm(stTargetdetail);
        stTargetdetailService.save(stTargetdetail);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @RequiresPermissions("六大任务:管理")
    @ApiOperation(value = "修改", notes = "")
    public R update(@RequestBody StTargetdetailEntity stTargetdetail) {
        verifyForm(stTargetdetail);
        stTargetdetailService.update(stTargetdetail);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    @RequiresPermissions("六大任务:管理")
    @ApiOperation(value = "删除", notes = "")
    public R delete(@PathVariable("ids") String ids) {
        String[] strings = ids.split(",");
        for (int i = 0; i < strings.length; i++) {
            stTargetdetailService.delete(strings[i]);
        }
        return R.ok();
    }

    /**
     * 接受
     */
    @RequestMapping(value = "/accept", method = RequestMethod.GET)
    @RequiresPermissions("六大任务:管理")
    @ApiOperation(value = "接受功能", notes = "")
    public R accept(@RequestParam("targetDetailId") String  targetDetailId) {
        StTargetdetailEntity entity = stTargetdetailService.queryObject(targetDetailId);
        entity.setAcceptdeptid(CurrentSession.GetDeptId());
        entity.setAcceptdeptName(CurrentSession.GetDeptName());
        entity.setAcceptuserid(CurrentSession.GetUserId());
        entity.setAccepttime(new Date());
        entity.setAcceptflag("1");
        stTargetdetailService.update(entity);
        return R.ok();
    }

    @RequestMapping(value = "/TargetedtailId", method = RequestMethod.GET)
    @ApiOperation(value = "通过目标明细查目标明细转发信息", notes = "")
    public R queryTaskDetailByTaskId(@RequestParam("TargetedtailId") String TargetedtailId) {
        return R.ok().put("data", stCommonService.queryTargetdetailTransmitByTargetedtailId(TargetedtailId));
    }

    private void verifyForm(StTargetdetailEntity stTargetdetail) {
        if (StringUtils.isBlank(stTargetdetail.getIndicators())) {
            throw new RRException(270, "指标项不能为空");
        }
        if (StringUtils.isBlank(stTargetdetail.getRespdept())) {
            throw new RRException(270, "责任部门不能为空");
        }
    }


}