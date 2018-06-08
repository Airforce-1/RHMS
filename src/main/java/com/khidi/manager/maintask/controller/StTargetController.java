package com.khidi.manager.maintask.controller;

import com.khidi.common.utils.CurrentSession;
import com.khidi.manager.maintask.service.StCommonService;
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

import com.khidi.manager.maintask.entity.StTargetEntity;
import com.khidi.manager.maintask.service.StTargetService;
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
@RequestMapping("sttarget")
@Api(value = "/StTarget", description = "市级/县区级目标下达")
public class StTargetController extends AbstractController {
    @Autowired
    private StTargetService stTargetService;
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
                  @RequestParam(value = "progress", required = false) Double progress,
                  @RequestParam(value = "id", required = false) String id,
                  @RequestParam(value = "targetcode", required = false) String targetcode,
                  @RequestParam(value = "targetname", required = false) String targetname,
                  @RequestParam(value = "indicators", required = false) String indicators,
                  @RequestParam(value = "laketype", required = false) String laketype,
                  @RequestParam(value = "lakeid", required = false) String lakeid,
                  @RequestParam(value = "lakebelongto", required = false) String lakebelongto,
                  @RequestParam(value = "areacode", required = false) String areacode,
                  @RequestParam(value = "stime", required = false) Date stime,
                  @RequestParam(value = "targetperiod", required = false) String targetperiod,
                  @RequestParam(value = "qtdept", required = false) String qtdept,
                  @RequestParam(value = "xddept", required = false) String xddept,
                  @RequestParam(value = "targettype", required = false) String targettype,
                  @RequestParam(value = "targetsource", required = false) String targetsource,
                  @RequestParam(value = "zbtype", required = false) String zbtype,
                  @RequestParam(value = "nowindicators", required = false) String nowindicators,
                  @RequestParam(value = "expectedindicators", required = false) String expectedindicators,
                  @RequestParam(value = "detailaddress", required = false) String detailaddress,
                  @RequestParam(value = "memo", required = false) String memo,
                  @RequestParam(value = "lakeName", required = false) String lakeName,
                  @RequestParam(value = "targetglobaltype", required = false) String targetglobaltype) {
        Map<String, Object> queryparams = new HashMap<String, Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
        queryparams.put("curdept", CurrentSession.GetDeptId());
        if (lakeName != null) {
            queryparams.put("lakeName", lakeName);
        }
        if (progress != null) {
            queryparams.put("progress", progress);
        }
        if (id != null) {
            queryparams.put("id", id);
        }
        if (targetcode != null) {
            queryparams.put("targetcode", targetcode);
        }
        if (targetname != null) {
            queryparams.put("targetname", targetname);
        }
        if (indicators != null) {
            queryparams.put("indicators", indicators);
        }
        if (laketype != null) {
            queryparams.put("laketype", laketype);
        }
        if (lakeid != null) {
            queryparams.put("lakeid", lakeid);
        }
        if (lakebelongto != null) {
            queryparams.put("lakebelongto", lakebelongto);
        }
        if (areacode != null) {
            queryparams.put("areacode", areacode);
        }
        if (stime != null) {
            queryparams.put("stime", stime);
        }
        if (targetperiod != null) {
            queryparams.put("targetperiod", targetperiod);
        }
        if (qtdept != null) {
            queryparams.put("qtdept", qtdept);
        }
        if (xddept != null) {
            queryparams.put("xddept", xddept);
        }
        if (targettype != null) {
            queryparams.put("targettype", targettype);
        }
        if (targetsource != null) {
            queryparams.put("targetsource", targetsource);
        }
        if (zbtype != null) {
            queryparams.put("zbtype", zbtype);
        }
        if (nowindicators != null) {
            queryparams.put("nowindicators", nowindicators);
        }
        if (expectedindicators != null) {
            queryparams.put("expectedindicators", expectedindicators);
        }
        if (detailaddress != null) {
            queryparams.put("detailaddress", detailaddress);
        }
        if (memo != null) {
            queryparams.put("memo", memo);
        }
        if (targetglobaltype != null) {
            queryparams.put("targetglobaltype", targetglobaltype);
        }
        //查询列表数据
        Query query = new Query(queryparams);

        List<StTargetEntity> stTargetList = stTargetService.queryList(query);
        int total = stTargetService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(stTargetList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @RequiresPermissions("六大任务:查看")
    @ApiOperation(value = "信息", notes = "")
    public R info(@PathVariable("id") String id) {
        StTargetEntity stTarget = stTargetService.queryObject(id);

        return R.ok().put("data", stTarget);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @RequiresPermissions("六大任务:管理")
    @ApiOperation(value = "保存", notes = "")
    public R save(@RequestBody StTargetEntity stTarget) {
        verifyForm(stTarget);
        stTargetService.save(stTarget);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @RequiresPermissions("六大任务:管理")
    @ApiOperation(value = "修改", notes = "")
    public R update(@RequestBody StTargetEntity stTarget) {
        verifyForm(stTarget);
        stTargetService.update(stTarget);
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
            stTargetService.delete(strings[i]);
        }
        return R.ok();
    }

    /**
     * 返回部门人员
     */
    @RequestMapping(value = "/deptid", method = RequestMethod.GET)
    @ApiOperation(value = "返回部门人员", notes = "")
    public R getUserListByDept(
            @RequestParam(value = "deptId", required = false) String deptId) {
        return R.ok().put("date", getUserListByDeptId(deptId));
    }


    @RequestMapping(value = "/TargetId", method = RequestMethod.GET)
    @ApiOperation(value = "通过目标查目标明细", notes = "")
    public R queryTaskDetailByTaskId(@RequestParam("TargetId") String TargetId) {
        return R.ok().put("data", stCommonService.queryTargetdetailByTargetId(TargetId));
    }

    private void verifyForm(StTargetEntity stTarget) {
        if (StringUtils.isBlank(stTarget.getTargetcode())) {
            throw new RRException(270, "目标编码不能为空");
        }
        if (StringUtils.isBlank(stTarget.getTargetname())) {
            throw new RRException(270, "目标名称不能为空");
        }
        if (StringUtils.isBlank(stTarget.getIndicators())) {
            throw new RRException(270, "指标项不能为空");
        }
        if (StringUtils.isBlank(stTarget.getLaketype())) {
            throw new RRException(270, "河湖类型不能为空");
        }
        if (StringUtils.isBlank(stTarget.getLakeid())) {
            throw new RRException(270, "河湖编号不能为空");
        }
        if (StringUtils.isBlank(stTarget.getStime())) {
            throw new RRException(270, "开始时间不能为空");
        }
        if (StringUtils.isBlank(stTarget.getTargetperiod())) {
            throw new RRException(270, "目标期限不能为空");
        }
    }
}