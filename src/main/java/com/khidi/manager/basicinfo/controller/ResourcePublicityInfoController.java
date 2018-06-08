package com.khidi.manager.basicinfo.controller;

import com.khidi.common.exception.RRException;
import com.khidi.common.utils.*;
import com.khidi.manager.basicinfo.entity.*;
import com.khidi.manager.basicinfo.service.*;
import com.khidi.manager.basicinfo.vo.RiverPublicityInfoVO;
import com.khidi.manager.sys.controller.AbstractController;
import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * 公示牌管理
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-04 18:19:33
 */
@RestController
@RequestMapping("resourcepublicityinfo")
@Api(value = "/ResourcePublicityinfo", description = "公示信息管理")
public class ResourcePublicityInfoController extends AbstractController {
	@Autowired
	private RiverService riverService;
	@Autowired
	private LakeService lakeService;
	@Autowired
	private CanalService canalService;
	@Autowired
	private ReservoirService reservoirService;
	@Autowired
	private PartRiverService partRiverService;
	@Autowired
	private PartLakeService partLakeService;
	@Autowired
	private PartCanalService partCanalService;
	@Autowired
	private PartReservoirService partReservoirService;
	@Autowired
	private SysAreaService sysAreaService;
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysDictService sysDictService;
	@Autowired
	private SysUserService sysUserService;
@Autowired
private ResourcePublicityinfoService resourcePublicityinfoService;

	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	@RequiresPermissions("河长公示信息:查看")
    @ApiOperation(value = "列表",notes="")
	public R list(@RequestParam(value="page",required=true) int page,
                  @RequestParam(value="limit",required=true) int limit,
				  @RequestParam(value="areaId",required=false) String areaId,
				  @RequestParam(value="resourceType",required=false) String resourceType,
				  @RequestParam(value="resourceName",required=false) String resourceName,
				  @RequestParam(value="header",required=false) String header
	){
		Map<String,Object> queryparams = new HashMap<String,Object>();
		queryparams.put("page", page);
		queryparams.put("limit", limit);
		if(areaId != null){
			queryparams.put("areaId",areaId);
		}
		if(resourceType != null){
			queryparams.put("resourceType",resourceType);
		}
		if(resourceName != null){
			queryparams.put("resourceName",resourceName);
		}
		if(header != null){
			queryparams.put("header",header);
		}
		//查询列表数据
		Query query = new Query(queryparams);

		List<ResourcePublicityinfoEntity>  resultList= resourcePublicityinfoService.queryList(query);
		int total = resourcePublicityinfoService.queryTotal(query);
		return R.ok().put("page", new PageUtils(resultList, total, query.getLimit(), query.getPage()));
	}
	/**
	 * 信息
	 */
	@RequestMapping(value="",method = RequestMethod.GET)
	@RequiresPermissions("河长公示信息:查看")
    @ApiOperation(value = "信息",notes="")
	public R info(@RequestParam(value="id",required=true) String id){
		return R.ok().put("data", resourcePublicityinfoService.queryObject(id));
	}
}