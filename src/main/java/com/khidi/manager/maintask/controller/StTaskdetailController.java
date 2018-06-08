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

import com.khidi.manager.maintask.entity.StTaskdetailEntity;
import com.khidi.manager.maintask.service.StTaskdetailService;
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
@RequestMapping("sttaskdetail")
@Api(value = "/StTaskdetail", description = "六大任务明细")
public class StTaskdetailController {
    @Autowired
    private StTaskdetailService stTaskdetailService;
    @Autowired
    private StCommonService stCommonService ;

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
                  @RequestParam(value = "indicate", required = false) String indicate,
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
                  @RequestParam(value = "acceptdept", required = false) String acceptdept,
                  @RequestParam(value = "isaccepted", required = false) Double isaccepted,
                  @RequestParam(value = "progress", required = false) Double progress,
                  @RequestParam(value = "taskid", required = false) String taskid,
                  @RequestParam(value = "solattachid", required = false) String solattachid,
                  @RequestParam(value = "taskglobaltype", required = false) String taskglobaltype,
                  @RequestParam(value = "acceptdeptid", required = false) String acceptdeptid,
                  @RequestParam(value = "acceptflag", required = false) String acceptflag,
                  @RequestParam(value = "acceptuserid", required = false) String acceptuserid,
                  @RequestParam(value = "accepttime", required = false) Date accepttime,
                  @RequestParam(value = "createtime", required = false) Date createtime,
                  @RequestParam(value = "todeptid", required = false) String todeptid,
                  @RequestParam(value = "transmituserid", required = false) String transmituserid,
                  @RequestParam(value = "hzName", required = false) String hzName,
                  @RequestParam(value = "lakeName", required = false) String lakeName,
                  @RequestParam(value = "tasktype", required = false) String tasktype,
                  @RequestParam(value = "taskName", required = false) String taskName,
                  @RequestParam(value = "transmittime", required = false) Date transmittime,
                  @RequestParam(value = "transmitDeptid", required = false) String transmitDeptid) {
        Map<String, Object> queryparams = new HashMap<String, Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
        queryparams.put("curdept", CurrentSession.GetDeptId());
        if (id != null) {
            queryparams.put("id", id);
        }
        if (taskName != null) {
            queryparams.put("taskName", taskName);
        }
        if (tasktype != null) {
            queryparams.put("tasktype", tasktype);
        }
        if (lakeName != null) {
            queryparams.put("lakeName", lakeName);
        }
        if (hzName != null) {
            queryparams.put("hzName", hzName);
        }
        if (indicate != null) {
            queryparams.put("indicate", indicate);
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
        if (acceptdept != null) {
            queryparams.put("acceptdept", acceptdept);
        }
        if (isaccepted != null) {
            queryparams.put("isaccepted", isaccepted);
        }
        if (progress != null) {
            queryparams.put("progress", progress);
        }
        if (taskid != null) {
            queryparams.put("taskid", taskid);
        }
        if (solattachid != null) {
            queryparams.put("solattachid", solattachid);
        }
        if (taskglobaltype != null) {
            queryparams.put("taskglobaltype", taskglobaltype);
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
        if(transmitDeptid != null){
            queryparams.put("transmitDeptid",transmitDeptid);
        }
        //查询列表数据
        Query query = new Query(queryparams);

        List<StTaskdetailEntity> stTaskdetailList = stTaskdetailService.queryList(query);
        int total = stTaskdetailService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(stTaskdetailList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @RequiresPermissions("六大任务:查看")
    @ApiOperation(value = "信息", notes = "")
    public R info(@PathVariable("id") String id) {
        StTaskdetailEntity stTaskdetail = stTaskdetailService.queryObject(id);
        return R.ok().put("data", stTaskdetail);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @RequiresPermissions("六大任务:管理")
    @ApiOperation(value = "保存", notes = "")
    public R save(@RequestBody StTaskdetailEntity stTaskdetail) {
        verifyForm(stTaskdetail);
        stTaskdetailService.save(stTaskdetail);
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
            stTaskdetailService.delete(strings[i]);
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @RequiresPermissions("六大任务:管理")
    @ApiOperation(value = "修改", notes = "")
    public R update(@RequestBody StTaskdetailEntity stTaskdetail) {
        verifyForm(stTaskdetail);
        stTaskdetailService.update(stTaskdetail);
        return R.ok();
    }

    /**
     * 接受
     */
    @RequestMapping(value = "/accept/{taskDetalId}", method = RequestMethod.GET)
    @RequiresPermissions("六大任务:管理")
    @ApiOperation(value = "接受功能", notes = "")
    public R accept(@RequestParam("taskDetalId") String  taskDetalId) {
        StTaskdetailEntity entity = stTaskdetailService.queryObject(taskDetalId);
        entity.setAcceptdeptid(CurrentSession.GetDeptId());
        entity.setAcceptdept(CurrentSession.GetDeptName());
        entity.setAcceptuserid(CurrentSession.GetUserId());
        entity.setAccepttime(new Date());
        entity.setAcceptflag("1");
        stTaskdetailService.update(entity);
        return R.ok();
    }

    @RequestMapping(value = "/subtaskid", method = RequestMethod.GET)
    @ApiOperation(value = "通过明细查子任务计划", notes = "")
    public R querySubtaskprogressByTaskdetailId(@RequestParam("subtaskid") String subtaskid) {
        return R.ok().put("data", stCommonService.querySubtaskprogressByTaskdetailId(subtaskid));
    }

    @RequestMapping(value = "/taskdetailid", method = RequestMethod.GET)
    @ApiOperation(value = "通过任务明细查任务明细转发信息", notes = "")
    public R queryTaskdetailTransmitByTaskdetailId(@RequestParam("taskdetailid") String TaskdetailId) {
        return R.ok().put("data", stCommonService.queryTaskdetailTransmitByTaskdetailId(TaskdetailId));
    }

    @RequestMapping(value = "/taskId", method = RequestMethod.GET)
    @ApiOperation(value = "通过任务编码查任务明细", notes = "")
    public R queryTaskdetailListByTaskId(@RequestParam("taskId") String taskId) {
        return R.ok().put("data", stCommonService.queryTaskdetailListByTaskId(taskId));
    }

    private void verifyForm(StTaskdetailEntity stTaskdetail) {

        if (StringUtils.isBlank(stTaskdetail.getIndicate())) {
            throw new RRException(270, "任务指标项不能为空");
        }
        if (StringUtils.isBlank(stTaskdetail.getRespdept())) {
            throw new RRException(270, "责任部门不能为空");
        }
//    if (StringUtils.isBlank(stTaskdetail.getNowindicators())) {
//            throw new RRException(270, "指标值-现状指标值不能为空");
//        }
//        if(StringUtils.isBlank(stTaskdetail.getId())){
//            throw new RRException(270,"子任务编号不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getExpectedindicators())){
//            throw new RRException(270,"指标值-预期指标值不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getPhaseone())){
//            throw new RRException(270,"分阶段目标-第一年度目标不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getPhasetwo())){
//            throw new RRException(270,"分阶段目标-第二年度目标不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getPhasethree())){
//            throw new RRException(270,"分阶段目标-第三年度目标不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getPhasefour())){
//            throw new RRException(270,"分阶段目标-第四年度目标不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getPhasefive())){
//            throw new RRException(270,"分阶段目标-第五年度目标不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getRespuser())){
//            throw new RRException(270,"责任人不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getTel())){
//            throw new RRException(270,"联系电话不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getMemo())){
//            throw new RRException(270,"备注不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getAcceptdept())){
//            throw new RRException(270,"接受部门不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getIsaccepted())){
//            throw new RRException(270,"是否接受不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getTaskprogress())){
//            throw new RRException(270,"任务进度值不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getTaskid())){
//            throw new RRException(270,"任务编号不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getSolattachid())){
//            throw new RRException(270,"解决方案附件编号不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getTaskglobaltype())){
//            throw new RRException(270,"任务类型不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getAcceptdeptid())){
//            throw new RRException(270,"接受部门编号不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getAcceptflag())){
//            throw new RRException(270,"接受标识不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getAcceptuserid())){
//            throw new RRException(270,"接受人不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getAccepttime())){
//            throw new RRException(270,"接受时间不能为空");
//		}
//	        if(StringUtils.isBlank(stTaskdetail.getCreatetime())){
//            throw new RRException(270,"创建时间不能为空");
//		}
//        if (StringUtils.isBlank(stTaskdetail.getTodeptid())) {
//            throw new RRException(270, "转发到部门不能为空");
//        }
//        if (StringUtils.isBlank(stTaskdetail.getTransmituserid())) {
//            throw new RRException(270, "转发者不能为空");
//        }
//	        if(StringUtils.isBlank(stTaskdetail.getTransmittime())){
//            throw new RRException(270,"转发时间不能为空");
//		}
    }


}