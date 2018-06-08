package com.khidi.manager.basicinfo.controller;

import com.khidi.common.annotation.SysLog;
import com.khidi.common.utils.*;
import com.khidi.manager.basicinfo.service.PartRiverService;
import com.khidi.manager.sys.controller.AbstractController;
import io.swagger.annotations.ApiParam;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.khidi.manager.basicinfo.entity.RiverEntity;
import com.khidi.manager.basicinfo.service.RiverService;
import com.khidi.common.exception.RRException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 河流基本信息管理
 *
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:56:52
 */
@RestController
@RequestMapping("river")
@Api(value = "/River", description = "河流基本信息管理")
public class RiverController extends AbstractController {
    @Autowired
    private RiverService riverService;
    @Autowired
    private PartRiverService partRiverService;
    @Value("${file.server.address}")
    private String address;
    @Value("${file.server.port}")
    private String port;

    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @RequiresPermissions("河流:查看")
    @ApiOperation(value = "列表", notes = "")
    public R list(@RequestParam(value = "page", required = true) int page,
                  @RequestParam(value = "limit", required = true) int limit,
                  @RequestParam(value = "sidx", required = false) String sidx,
                  @RequestParam(value = "order", required = false) String order,
                  @RequestParam(value = "id", required = false) String id,
                  @RequestParam(value = "name", required = false) String name,
                  @RequestParam(value = "code", required = false) String code,
                  @RequestParam(value = "crossType", required = false) String crossType,
                  @RequestParam(value = "areaId", required = false) String areaId,
                  @RequestParam(value = "direction", required = false) String direction,
                  @RequestParam(value = "alias", required = false) String alias,
                  @RequestParam(value = "riverResource", required = false) String riverResource,
                  @RequestParam(value = "mouth", required = false) String mouth,
                  @RequestParam(value = "resourceX", required = false) String resourceX,
                  @RequestParam(value = "resourceY", required = false) String resourceY,
                  @RequestParam(value = "mouthX", required = false) String mouthX,
                  @RequestParam(value = "mouthY", required = false) String mouthY,
                  @RequestParam(value = "type", required = false) String type,
                  @RequestParam(value = "gradient", required = false) String gradient,
                  @RequestParam(value = "flow", required = false) String flow,
                  @RequestParam(value = "length", required = false) String length,
                  @RequestParam(value = "runoff", required = false) String runoff,
                  @RequestParam(value = "area", required = false) String area,
                  @RequestParam(value = "regions", required = false) String regions,
                  @RequestParam(value = "parentId", required = false) String parentId,
                  @RequestParam(value = "remark", required = false) String remark) {
        Map<String, Object> queryparams = new HashMap<String, Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        queryparams.put("sidx", sidx);
        queryparams.put("order", order);
        if (parentId != null) {
            queryparams.put("parentId", parentId);
        }
        if (id != null) {
            queryparams.put("id", id);
        }
        if (name != null) {
            queryparams.put("name", name);
        }
        if (code != null) {
            queryparams.put("code", code);
        }
        if (crossType != null) {
            queryparams.put("crossType", crossType);
        }
        if (areaId != null) {
            queryparams.put("areaId", areaId);
        }
        if (direction != null) {
            queryparams.put("direction", direction);
        }
        if (alias != null) {
            queryparams.put("alias", alias);
        }
        if (riverResource != null) {
            queryparams.put("riverResource", riverResource);
        }
        if (mouth != null) {
            queryparams.put("mouth", mouth);
        }
        if (resourceX != null) {
            queryparams.put("resourceX", resourceX);
        }
        if (resourceY != null) {
            queryparams.put("resourceY", resourceY);
        }
        if (mouthX != null) {
            queryparams.put("mouthX", mouthX);
        }
        if (mouthY != null) {
            queryparams.put("mouthY", mouthY);
        }
        if (type != null) {
            queryparams.put("type", type);
        }
        if (gradient != null) {
            queryparams.put("gradient", gradient);
        }
        if (flow != null) {
            queryparams.put("flow", flow);
        }
        if (length != null) {
            queryparams.put("length", length);
        }
        if (runoff != null) {
            queryparams.put("runoff", runoff);
        }
        if (area != null) {
            queryparams.put("area", area);
        }
        if (regions != null) {
            queryparams.put("regions", regions);
        }
        if (remark != null) {
            queryparams.put("remark", remark);
        }
        // 查询列表数据
        Query query = new Query(queryparams);
        //加入用户角色的资源的过
            query.put("roleId", StringUtil.joinList4sql(getRole(), "','"));
        List<RiverEntity> riverList = riverService.queryList(query);
        int total = riverService.queryTotal(query);
        PageUtils pageUtil = new PageUtils(riverList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @RequiresPermissions("河流:查看")
    @ApiOperation(value = "信息", notes = "")
    public R info(@PathVariable("id") String id) {
        RiverEntity river = riverService.queryObject(id);

        return R.ok().put("river", river);
    }

    /**
     * 保存
     */
    @SysLog("保存河流信息")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @RequiresPermissions("河流:管理")
    @ApiOperation(value = "保存", notes = "")
    public R save(@RequestBody RiverEntity river) {
        verifyForm(river);
        riverService.save(river);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改河流信息")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @RequiresPermissions("河流:管理")
    @ApiOperation(value = "修改", notes = "")
    public R update(@RequestBody RiverEntity river) {
        verifyForm(river);
        riverService.update(river);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除河流信息")
    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    @RequiresPermissions("河流:管理")
    @ApiOperation(value = "删除", notes = "")
    public R delete(@PathVariable("ids") String ids) {
        String[] strings = ids.split(",");
        for (int i = 0; i < strings.length; i++) {
            if(partRiverService.queryListByRiverId(strings[i]).size()>0 || riverService.queryChildrenRivers(strings[i]).size()>0){
                throw  new RRException(200,"请先删除该河流河段或河流分支");
            }
            riverService.delete(strings[i]);
        }
        return R.ok();
    }



    /**
     * 下载导入模板
     * @throws IOException
     */
    @RequestMapping(value="/downLoadtemplet",method = RequestMethod.GET)
    @RequiresPermissions("河流:管理")
    public R downLoad() throws IOException {
        return R.ok().put("data","http://"+address+":"+port+"/template/"+"河流基本信息导入模板.xls");
    }



    /**
     * 提供导出数据下载
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/downloadExcel", method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    @RequiresPermissions("河流:管理")
    @ApiOperation(value = "导出数据", notes = "")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 告诉浏览器用什么软件可以打开此文件
        List<RiverEntity> resultList = riverService.queryList(new HashedMap());
       LinkedHashMap<String,String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("name", "name");
        fieldMap.put("code", "code");
        fieldMap.put("crossType", "crossType");
        fieldMap.put("crossType", "crossType");
        ExcelUtils.listToExcel(resultList,fieldMap,"河流信息表",resultList.size(),response);
    }







    private void verifyForm(RiverEntity river) {
        if (StringUtils.isBlank(river.getName())) {
            throw new RRException(270, "河流名称不能为空");
        }
        if (StringUtils.isBlank(river.getCode())) {
            throw new RRException(270, "河流编码不能为空");
        }
        if (!StringJudgUtils.isLetterOrDigit(river.getCode())) {
            throw new RRException(250, "河流编码只能输入英文或数字");
        }
        if (StringUtils.isBlank(river.getAreaId())) {
            throw new RRException(270, "所属行政区划不能为空");
        }
        if (StringUtils.isBlank(river.getCrossType())) {
            throw new RRException(270, "跨界类型不能为空");
        }
        if (!StringUtil.isEmpty(river.getMouthX())) {
            if (!StringJudgUtils.isIntegerOrDecimal(river.getMouthX())) {
                throw new RRException(230, "经纬度只能输入整数及六位小数");
            }
        }
        if (!StringUtil.isEmpty(river.getMouthY())) {
            if (!StringJudgUtils.isIntegerOrDecimal(river.getMouthY())) {
                throw new RRException(230, "经纬度只能输入整数及六位小数");
            }
        }
        if (!StringUtil.isEmpty(river.getResourceX())){
            if (!StringJudgUtils.isIntegerOrDecimal(river.getResourceX())) {
                throw new RRException(230, "经纬度只能输入整数及六位小数");
            }
        }
        if (!StringUtil.isEmpty(river.getResourceY())) {
            if (!StringJudgUtils.isIntegerOrDecimal(river.getResourceY())) {
                throw new RRException(230, "经纬度只能输入整数及六位小数");
            }
        }
        if (!StringUtil.isEmpty(river.getGradient())) {
            if (!StringJudgUtils.isPercent(river.getGradient())) {
                throw new RRException(230, "百分比只能输入三位整数及两位小数");
            }
        }
    }
}
