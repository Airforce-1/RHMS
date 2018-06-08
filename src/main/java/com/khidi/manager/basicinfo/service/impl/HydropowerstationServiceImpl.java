package com.khidi.manager.basicinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.basicinfo.dao.CanalDao;
import com.khidi.manager.basicinfo.dao.HydropowerstationDao;
import com.khidi.manager.basicinfo.dao.LakeDao;
import com.khidi.manager.basicinfo.dao.PartCanalDao;
import com.khidi.manager.basicinfo.dao.PartLakeDao;
import com.khidi.manager.basicinfo.dao.PartReservoirDao;
import com.khidi.manager.basicinfo.dao.PartRiverDao;
import com.khidi.manager.basicinfo.dao.ReservoirDao;
import com.khidi.manager.basicinfo.dao.RiverDao;
import com.khidi.manager.basicinfo.entity.HydropowerstationEntity;
import com.khidi.manager.basicinfo.entity.WatersourceEntity;
import com.khidi.manager.basicinfo.service.HydropowerstationService;
import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.dao.SysDictDao;



@Service("hydropowerstationService")
public class HydropowerstationServiceImpl implements HydropowerstationService {
	@Autowired
	private HydropowerstationDao hydropowerstationDao;
	@Autowired
	private SysDictDao sysDictDao;
	@Autowired
    private RiverDao riverDao;
    @Autowired
    private PartRiverDao partRiverDao;
    @Autowired
    private LakeDao lakeDao;
    @Autowired
    private PartLakeDao partLakeDao;
    @Autowired
    private CanalDao canalDao;
    @Autowired
    private PartCanalDao partCanalDao;
    @Autowired
    private ReservoirDao reservoirDao;
    @Autowired
    private PartReservoirDao partReservoirDao;
    @Autowired
    private SysAreaDao sysAreaDao;
	
	@Override
	public HydropowerstationEntity queryObject(String id){
		return hydropowerstationDao.queryObject(id);
	}
	
	@Override
	public List<HydropowerstationEntity> queryList(Map<String, Object> map){
		List<HydropowerstationEntity> list = hydropowerstationDao.queryList(map);
		for (int i = 0; i < list.size(); i++) {
			//行政区划
			list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());
			Map<String, Object> querymap = new HashMap();
			//水电站类型名称
			if(StringUtil.isEmpty(list.get(i).getType())){
				list.get(i).setTypeName(null);
			}else{
				querymap.put("dictValue", list.get(i).getType());
				querymap.put("dictType", "水电站类型");
				list.get(i).setTypeName(sysDictDao.queryObject(querymap).getDictName());
			}
			//工程建设情况名称
			if (StringUtil.isEmpty(list.get(i).getBuildSituation())) {
                list.get(i).setBuildSituationName(null);;
            } else {
                querymap.put("dictValue", list.get(i).getBuildSituation());
                querymap.put("dictType", "工程建设情况");
                list.get(i).setBuildSituationName(sysDictDao.queryObject(querymap).getDictName());
            }
			//河湖渠库类型
			if (StringUtil.isEmpty(list.get(i).getResourceType())) {
                list.get(i).setResourceTypeName(null);
            } else {
                querymap.put("dictValue", list.get(i).getResourceType());
                querymap.put("dictType", "河湖类型");
                list.get(i).setResourceTypeName(sysDictDao.queryObject(querymap).getDictName());
            }
			//河湖渠库名称
			if (StringUtil.isEmpty(list.get(i).getResourceType())) {
                list.get(i).setResourceTypeName(null);
            } else if (list.get(i).getResourceType().equals("1")) {   //河流
                list.get(i).setResourceName(riverDao.queryObject(list.get(i).getResourceId()).getName());
            } else if (list.get(i).getResourceType().equals("2")) {    //河段
                list.get(i).setResourceName(partRiverDao.queryObject(list.get(i).getResourceId()).getName());
            } else if (list.get(i).getResourceType().equals("3")) {    //渠道
                list.get(i).setResourceName(canalDao.queryObject(list.get(i).getResourceId()).getName());
            } else if (list.get(i).getResourceType().equals("4")) {    //渠段
                list.get(i).setResourceName(partCanalDao.queryObject(list.get(i).getResourceId()).getName());
            } else if (list.get(i).getResourceType().equals("5")) {  //湖泊
                list.get(i).setResourceName(lakeDao.queryObject(list.get(i).getResourceId()).getName());
            } else if (list.get(i).getResourceType().equals("6")) {    //湖段
                list.get(i).setResourceName(partLakeDao.queryObject(list.get(i).getResourceId()).getName());
            } else if (list.get(i).getResourceType().equals("7")) {   //水库
                list.get(i).setResourceName(reservoirDao.queryObject(list.get(i).getResourceId()).getName());
            } else if (list.get(i).getResourceType().equals("8")) {    //库段
                list.get(i).setResourceName(partReservoirDao.queryObject(list.get(i).getResourceId()).getName());
            }
		}
		return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return hydropowerstationDao.queryTotal(map);
	}
	
	@Override
	public void save(HydropowerstationEntity hydropowerstation){
        hydropowerstation.setId(UUID.randomUUID().toString());
		hydropowerstationDao.save(hydropowerstation);
	}
	
	@Override
	public void update(HydropowerstationEntity hydropowerstation){
		hydropowerstationDao.update(hydropowerstation);
	}
	
	@Override
	public void delete(String id){
		hydropowerstationDao.delete(id);
	}
}
