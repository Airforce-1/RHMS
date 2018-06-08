package com.khidi.manager.basicinfo.controller;

import com.khidi.common.annotation.SysLog;
import com.khidi.common.exception.RRException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.sys.controller.AbstractController;
import com.khidi.manager.sys.dao.FileuploadDao;
import com.khidi.manager.sys.entity.FileUploadEntity;
import com.khidi.manager.sys.service.FileuploadService;
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
import com.khidi.manager.basicinfo.entity.ResourcePublicitycardEntity;
import com.khidi.manager.basicinfo.service.ResourcePublicitycardService;
import com.khidi.common.utils.PageUtils;
import com.khidi.common.utils.Query;
import com.khidi.common.utils.R;

import java.util.HashMap;


/**
 * 公示牌管理
 *
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-04 18:19:33
 */
@RestController
@RequestMapping("resourcepublicitycard")
@Api(value = "/ResourcePublicitycard", description = "公示牌管理")
public class ResourcePublicitycardController extends AbstractController {
    @Autowired
    private ResourcePublicitycardService resourcePublicitycardService;
    @Autowired
    private FileuploadService fileuploadService;


    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @RequiresPermissions("河长公示牌:查看")
    @ApiOperation(value = "列表", notes = "")
    public R list(@RequestParam(value = "page", required = true) int page,
                  @RequestParam(value = "limit", required = true) int limit,
                  @RequestParam(value = "sidx", required = false) String sidx,
                  @RequestParam(value = "order", required = false) String order,
                  @RequestParam(value = "id", required = false) String id,
                  @RequestParam(value = "code", required = false) String code,
                  @RequestParam(value = "name", required = false) String name,
                  @RequestParam(value = "resourcetype", required = false) String resourcetype,
                  @RequestParam(value = "resourceid", required = false) String resourceid,
                  @RequestParam(value = "resourceName", required = false) String resourceName,
                  @RequestParam(value = "x", required = false) String x,
                  @RequestParam(value = "y", required = false) String y,
                  @RequestParam(value = "areaId", required = false) String areaId,
                  @RequestParam(value = "address", required = false) String address,
                  @RequestParam(value = "fileaddress", required = false) String fileaddress) {
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
        if (name != null) {
            queryparams.put("name", name);
        }
        if (resourcetype != null) {
            queryparams.put("resourcetype", resourcetype);
        }
        if (resourceid != null) {
            queryparams.put("resourceid", resourceid);
        }
        if (resourceName != null) {
            queryparams.put("resourceName", resourceName);
        }
        if (x != null) {
            queryparams.put("x", x);
        }
        if (y != null) {
            queryparams.put("y", y);
        }
        if (areaId != null) {
            queryparams.put("areaId", areaId);
        }
        if (address != null) {
            queryparams.put("address", address);
        }
        if (fileaddress != null) {
            queryparams.put("fileaddress", fileaddress);
        }
        //查询列表数据
        Query query = new Query(queryparams);
//加入用户角色的资源的过滤
        query.put("roleId", StringUtil.joinList4sql(getRole(), "','"));
        List<ResourcePublicitycardEntity> resourcePublicitycardList = resourcePublicitycardService.queryList(query);
        int total = resourcePublicitycardService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(resourcePublicitycardList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @RequiresPermissions("河长公示牌:查看")
    @ApiOperation(value = "信息", notes = "")
    public R info(@PathVariable("id") String id) {
        ResourcePublicitycardEntity resourcePublicitycard = resourcePublicitycardService.queryObject(id);
        if (StringUtil.isEmpty(resourcePublicitycard.getFileaddress())) {
            resourcePublicitycard.setFileList(null);
        } else {
            String allFlieId[] = resourcePublicitycard.getFileaddress().split(",");
            List<FileUploadEntity> fileUpload = new ArrayList<FileUploadEntity>();
            for (int j = 0; j < allFlieId.length; j++) {
                FileUploadEntity fileinfo = new FileUploadEntity();
                fileinfo.setId(fileuploadService.queryObject(allFlieId[j]).getId());
                fileinfo.setFileName(fileuploadService.queryObject(allFlieId[j]).getFileName());
                fileinfo.setFilePath(fileuploadService.queryObject(allFlieId[j]).getFilePath());
                fileUpload.add(fileinfo);
            }
            resourcePublicitycard.setFileList(fileUpload);
        }


        return R.ok().put("data", resourcePublicitycard);
    }

    /**
     * 保存
     */
    @SysLog("保存河长公示牌信息")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @RequiresPermissions("河长公示牌:管理")
    @ApiOperation(value = "保存", notes = "")
    public R save(@RequestBody ResourcePublicitycardEntity resourcePublicitycard) {
        verifyForm(resourcePublicitycard);
        resourcePublicitycardService.save(resourcePublicitycard);
        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改河长公示牌信息")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @RequiresPermissions("河长公示牌:查看")
    @ApiOperation(value = "修改", notes = "")
    public R update(@RequestBody ResourcePublicitycardEntity resourcePublicitycard) {
        verifyForm(resourcePublicitycard);
        resourcePublicitycardService.update(resourcePublicitycard);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除河长公示牌信息")
    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    @RequiresPermissions("河长公示牌:查看")
    @ApiOperation(value = "删除", notes = "")
    public R delete(@PathVariable("ids") String ids) {
        String[] strings = ids.split(",");
        for (int i = 0; i < strings.length; i++) {
            resourcePublicitycardService.delete(strings[i]);
        }
        return R.ok();
    }

    private void verifyForm(ResourcePublicitycardEntity resourcePublicitycard) {
        if (StringUtils.isBlank(resourcePublicitycard.getCode())) {
            throw new RRException(270, "公示牌编码不能为空");
        }
        if (StringUtils.isBlank(resourcePublicitycard.getName())) {
            throw new RRException(270, "公示牌名称不能为空");
        }
        if (StringUtils.isBlank(resourcePublicitycard.getResourcetype())) {
            throw new RRException(270, "河湖渠库（段）类型不能为空");
        }
        if (StringUtils.isBlank(resourcePublicitycard.getResourceid())) {
            throw new RRException(270, "河湖渠库（段）编码不能为空");
        }
        if (StringUtils.isBlank(resourcePublicitycard.getX())) {
            throw new RRException(270, "经度不能为空");
        }
        if (StringUtils.isBlank(resourcePublicitycard.getY())) {
            throw new RRException(270, "纬度不能为空");
        }
        if (StringUtils.isBlank(resourcePublicitycard.getAreaId())) {
            throw new RRException(270, "行政区划编码不能为空");
        }
    }
}