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

import com.khidi.manager.maintask.entity.StTaskdetailTransmitEntity;
import com.khidi.manager.maintask.service.StTaskdetailTransmitService;
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
@RequestMapping("sttaskdetailtransmit")
@Api(value = "/StTaskdetailTransmit", description = "六大任务明细转发信息")
public class StTaskdetailTransmitController {
    @Autowired
    private StTaskdetailTransmitService stTaskdetailTransmitService;

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
                  @RequestParam(value = "taskdetailid", required = false) String taskdetailid,
                  @RequestParam(value = "taskid", required = false) String taskid,
                  @RequestParam(value = "tasktype", required = false) String tasktype,
                  @RequestParam(value = "zftime", required = false) Date zftime,
                  @RequestParam(value = "todeptid", required = false) String todeptid,
                  @RequestParam(value = "id", required = false) String id,
                  @RequestParam(value = "transmitDeptid", required = false) String transmitDeptid,
                  @RequestParam(value = "transmitUserid", required = false) String transmitUserid,
                  @RequestParam(value = "delind", required = false) String delind) {
        Map<String, Object> queryparams = new HashMap<String, Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
        if (taskdetailid != null) {
            queryparams.put("taskdetailid", taskdetailid);
        }
        if (taskid != null) {
            queryparams.put("taskid", taskid);
        }
        if (tasktype != null) {
            queryparams.put("tasktype", tasktype);
        }
        if (zftime != null) {
            queryparams.put("zftime", zftime);
        }
        if (todeptid != null) {
            queryparams.put("todeptid", todeptid);
        }
        if (id != null) {
            queryparams.put("id", id);
        }
        if(transmitDeptid != null){
            queryparams.put("transmitDeptid",transmitDeptid);
        }
        if(transmitUserid != null){
            queryparams.put("transmitUserid",transmitUserid);
        }
        if(delind != null){
            queryparams.put("delind",delind);
        }
        //查询列表数据
        Query query = new Query(queryparams);

        List<StTaskdetailTransmitEntity> stTaskdetailTransmitList = stTaskdetailTransmitService.queryList(query);
        int total = stTaskdetailTransmitService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(stTaskdetailTransmitList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @RequiresPermissions("六大任务:查看")
    @ApiOperation(value = "信息", notes = "")
    public R info(@PathVariable("id") String id) {
        StTaskdetailTransmitEntity stTaskdetailTransmit = stTaskdetailTransmitService.queryObject(id);

        return R.ok().put("data", stTaskdetailTransmit);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @RequiresPermissions("六大任务:管理")
    @ApiOperation(value = "保存", notes = "")
    public R save(@RequestBody StTaskdetailTransmitEntity stTaskdetailTransmit) {
        verifyForm(stTaskdetailTransmit);
        stTaskdetailTransmitService.save(stTaskdetailTransmit);
        return R.ok();
    }

    /**
     * 修改
     */
//    @RequestMapping(value = "", method = RequestMethod.PUT)
//    @RequiresPermissions("六大任务:管理")
//    @ApiOperation(value = "修改", notes = "")
//    public R update(@RequestBody StTaskdetailTransmitEntity stTaskdetailTransmit) {
//        verifyForm(stTaskdetailTransmit);
//        stTaskdetailTransmitService.update(stTaskdetailTransmit);
//        return R.ok();
//    }

    /**
     * 删除
     */
//    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
//    @RequiresPermissions("六大任务 :管理")
//    @ApiOperation(value = "删除", notes = "")
//    public R delete(@PathVariable("ids") String ids) {
//        String[] strings = ids.split(",");
//        for (int i = 0; i < strings.length; i++) {
//            stTaskdetailTransmitService.delete(strings[i]);
//        }
//        return R.ok();
//    }

    private void verifyForm(StTaskdetailTransmitEntity stTaskdetailTransmit) {
        if (StringUtils.isBlank(stTaskdetailTransmit.getTaskdetailid())) {
            throw new RRException(270, "任务明细编号不能为空");
        }
        if (StringUtils.isBlank(stTaskdetailTransmit.getTaskid())) {
            throw new RRException(270, "任务编号不能为空");
        }
        if (StringUtils.isBlank(stTaskdetailTransmit.getTodeptid())) {
            throw new RRException(270, "转发到部门不能为空");
        }
    }


}