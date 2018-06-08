package com.khidi.manager.maintask.controller;

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

import com.khidi.manager.maintask.entity.StSubtaskprogressEntity;
import com.khidi.manager.maintask.service.StSubtaskprogressService;
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
@RequestMapping("stsubtaskprogress")
@Api(value = "/StSubtaskprogress", description = "子任务计划进度")
public class StSubtaskprogressController {
    @Autowired
    private StSubtaskprogressService stSubtaskprogressService;

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
                  @RequestParam(value = "id", required = false) String id,
                  @RequestParam(value = "subtaskid", required = false) String subtaskid,
                  @RequestParam(value = "lakeid", required = false) String lakeid,
                  @RequestParam(value = "lakebelongto", required = false) String lakebelongto,
                  @RequestParam(value = "measures", required = false) String measures,
                  @RequestParam(value = "riverunit", required = false) String riverunit,
                  @RequestParam(value = "mainmeasurescontent", required = false) String mainmeasurescontent,
                  @RequestParam(value = "qtdept", required = false) String qtdept,
                  @RequestParam(value = "phdept", required = false) String phdept,
                  @RequestParam(value = "stime", required = false) Date stime,
                  @RequestParam(value = "etime", required = false) Date etime,
                  @RequestParam(value = "importlinksmemo", required = false) String importlinksmemo,
                  @RequestParam(value = "desiredeffect", required = false) String desiredeffect,
                  @RequestParam(value = "memo", required = false) String memo,
                  @RequestParam(value = "progress", required = false) Double progress,
                  @RequestParam(value = "taskglobaltype", required = false) String taskglobaltype) {
        Map<String, Object> queryparams = new HashMap<String, Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
        if (id != null) {
            queryparams.put("id", id);
        }
        if (subtaskid != null) {
            queryparams.put("subtaskid", subtaskid);
        }
        if (lakeid != null) {
            queryparams.put("lakeid", lakeid);
        }
        if (lakebelongto != null) {
            queryparams.put("lakebelongto", lakebelongto);
        }
        if (measures != null) {
            queryparams.put("measures", measures);
        }
        if (riverunit != null) {
            queryparams.put("riverunit", riverunit);
        }
        if (mainmeasurescontent != null) {
            queryparams.put("mainmeasurescontent", mainmeasurescontent);
        }
        if (qtdept != null) {
            queryparams.put("qtdept", qtdept);
        }
        if (phdept != null) {
            queryparams.put("phdept", phdept);
        }
        if (stime != null) {
            queryparams.put("stime", stime);
        }
        if (etime != null) {
            queryparams.put("etime", etime);
        }
        if (importlinksmemo != null) {
            queryparams.put("importlinksmemo", importlinksmemo);
        }
        if (desiredeffect != null) {
            queryparams.put("desiredeffect", desiredeffect);
        }
        if (memo != null) {
            queryparams.put("memo", memo);
        }
        if (progress != null) {
            queryparams.put("progress", progress);
        }
        if (taskglobaltype != null) {
            queryparams.put("taskglobaltype", taskglobaltype);
        }
        //查询列表数据
        Query query = new Query(queryparams);

        List<StSubtaskprogressEntity> stSubtaskprogressList = stSubtaskprogressService.queryList(query);
        int total = stSubtaskprogressService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(stSubtaskprogressList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @RequiresPermissions("六大任务:查看")
    @ApiOperation(value = "信息", notes = "")
    public R info(@PathVariable("id") String id) {
        StSubtaskprogressEntity stSubtaskprogress = stSubtaskprogressService.queryObject(id);

        return R.ok().put("data", stSubtaskprogress);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @RequiresPermissions("六大任务:管理")
    @ApiOperation(value = "保存", notes = "")
    public R save(@RequestBody StSubtaskprogressEntity stSubtaskprogress) {
        verifyForm(stSubtaskprogress);
        stSubtaskprogressService.save(stSubtaskprogress);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @RequiresPermissions("六大任务:管理")
    @ApiOperation(value = "修改", notes = "")
    public R update(@RequestBody StSubtaskprogressEntity stSubtaskprogress) {
        verifyForm(stSubtaskprogress);
        stSubtaskprogressService.update(stSubtaskprogress);
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
            stSubtaskprogressService.delete(strings[i]);
        }
        return R.ok();
    }

    private void verifyForm(StSubtaskprogressEntity stSubtaskprogress) {
        if (StringUtils.isBlank(stSubtaskprogress.getMeasures())) {
            throw new RRException(270, "措施名称不能为空");
        }
//	        if(StringUtils.isBlank(stSubtaskprogress.getStime())){
//            throw new RRException(270,"开始时间不能为空");
//		}
//	        if(StringUtils.isBlank(stSubtaskprogress.getEtime())){
//            throw new RRException(270,"结束时间不能为空");
//		}
        if (StringUtils.isBlank(stSubtaskprogress.getImportlinksmemo())) {
            throw new RRException(270, "重要环节说明不能为空");
        }
    }

}