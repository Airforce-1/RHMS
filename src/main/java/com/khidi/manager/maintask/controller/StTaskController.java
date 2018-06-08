package com.khidi.manager.maintask.controller;

import com.khidi.common.utils.CurrentSession;
import com.khidi.manager.sys.controller.AbstractController;
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

import com.khidi.manager.maintask.entity.StTaskEntity;
import com.khidi.manager.maintask.service.StTaskService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;

import java.util.HashMap;


/**
 * ${comments}
 *
 * @author fdz
 * @email 592926573@qq.com
 * @date 2018-01-03 10:29:04
 */
@RestController
@RequestMapping("sttask")
@Api(value = "/StTask", description = "六大任务下达")
public class StTaskController extends AbstractController {
    @Autowired
    private StTaskService stTaskService;


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
                  @RequestParam(value = "completeperiod", required = false) String completeperiod,
                  @RequestParam(value = "laketype", required = false) String laketype,
                  @RequestParam(value = "lakeid", required = false) String lakeid,
                  @RequestParam(value = "hzName", required = false) String hzName,
                  @RequestParam(value = "areacode", required = false) String areacode,
                  @RequestParam(value = "tasktype", required = false) String tasktype,
                  @RequestParam(value = "tasksource", required = false) String tasksource,
                  @RequestParam(value = "indicatortype", required = false) String indicatortype,
                  @RequestParam(value = "detailaddress", required = false) String detailaddress,
                  @RequestParam(value = "memo", required = false) String memo,
                  @RequestParam(value = "taskglobaltype", required = false) String taskglobaltype,
                  @RequestParam(value = "progress", required = false) Double progress,
                  @RequestParam(value = "id", required = false) String id,
                  @RequestParam(value = "taskcode", required = false) String taskcode,
                  @RequestParam(value = "taskname", required = false) String taskname,
                  @RequestParam(value = "maintask", required = false) String maintask,
                  @RequestParam(value = "qtdept", required = false) String qtdept,
                  @RequestParam(value = "xddept", required = false) String xddept,
                  @RequestParam(value = "stime", required = false) Date stime) {
        Map<String, Object> queryparams = new HashMap<String, Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
        queryparams.put("curdept", CurrentSession.GetDeptId());
        if (completeperiod != null) {
            queryparams.put("completeperiod", completeperiod);
        }
        if (laketype != null) {
            queryparams.put("laketype", laketype);
        }
        if (lakeid != null) {
            queryparams.put("lakeid", lakeid);
        }
        if (hzName != null) {
            queryparams.put("hzName", hzName);
        }
        if (areacode != null) {
            queryparams.put("areacode", areacode);
        }
        if (tasktype != null) {
            queryparams.put("tasktype", tasktype);
        }
        if (tasksource != null) {
            queryparams.put("tasksource", tasksource);
        }
        if (indicatortype != null) {
            queryparams.put("indicatortype", indicatortype);
        }
        if (detailaddress != null) {
            queryparams.put("detailaddress", detailaddress);
        }
        if (memo != null) {
            queryparams.put("memo", memo);
        }
        if (taskglobaltype != null) {
            queryparams.put("taskglobaltype", taskglobaltype);
        }
        if (progress != null) {
            queryparams.put("progress", progress);
        }
        if (id != null) {
            queryparams.put("id", id);
        }
        if (taskcode != null) {
            queryparams.put("taskcode", taskcode);
        }
        if (taskname != null) {
            queryparams.put("taskname", taskname);
        }
        if (maintask != null) {
            queryparams.put("maintask", maintask);
        }
        if (qtdept != null) {
            queryparams.put("qtdept", qtdept);
        }
        if (xddept != null) {
            queryparams.put("xddept", xddept);
        }
        if (stime != null) {
            queryparams.put("stime", stime);
        }
        //查询列表数据
        Query query = new Query(queryparams);

        List<StTaskEntity> stTaskList = stTaskService.queryList(query);
        int total = stTaskService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(stTaskList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @RequiresPermissions("六大任务:查看")
    @ApiOperation(value = "信息", notes = "")
    public R info(@PathVariable("id") String id) {
        StTaskEntity stTask = stTaskService.queryObject(id);

        return R.ok().put("data", stTask);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @RequiresPermissions("六大任务:管理")
    @ApiOperation(value = "保存", notes = "")
    public R save(@RequestBody StTaskEntity stTask) {
        verifyForm(stTask);
        stTaskService.save(stTask);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @RequiresPermissions("六大任务:管理")
    @ApiOperation(value = "修改", notes = "")
    public R update(@RequestBody StTaskEntity stTask) {
        verifyForm(stTask);
        stTaskService.update(stTask);
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
            stTaskService.delete(strings[i]);
        }
        return R.ok();
    }


    @RequestMapping(value = "/teskId", method = RequestMethod.GET)
    @ApiOperation(value = "通过任务查任务明细", notes = "")
    public R queryTaskDetailByTaskId(@RequestParam("teskId") String teskId) {
        return R.ok().put("data", stTaskService.queryTaskDetailByTaskId(teskId));
    }

    private void verifyForm(StTaskEntity stTask) {
        if (StringUtils.isBlank(stTask.getTaskcode())) {
            throw new RRException(270, "任务编码不能为空");
        }
        if (StringUtils.isBlank(stTask.getTaskname())) {
            throw new RRException(270, "任务名称不能为空");
        }
        if (StringUtils.isBlank(stTask.getMaintask())) {
            throw new RRException(270, "主要任务不能为空");
        }
        if (StringUtils.isBlank(stTask.getLaketype())) {
            throw new RRException(270, "河湖类型不能为空");
        }
        if (StringUtils.isBlank(stTask.getLakeid())) {
            throw new RRException(270, "河湖编号不能为空");
        }
    }


}