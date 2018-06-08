package com.khidi.manager.basicinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.basicinfo.dao.CanalDao;
import com.khidi.manager.basicinfo.dao.LakeDao;
import com.khidi.manager.basicinfo.dao.PartCanalDao;
import com.khidi.manager.basicinfo.dao.PartLakeDao;
import com.khidi.manager.basicinfo.dao.PartReservoirDao;
import com.khidi.manager.basicinfo.dao.PartRiverDao;
import com.khidi.manager.basicinfo.dao.ReservoirDao;
import com.khidi.manager.basicinfo.dao.RiverDao;
import com.khidi.manager.basicinfo.dao.WatersourceDao;
import com.khidi.manager.basicinfo.entity.WatersourceEntity;
import com.khidi.manager.basicinfo.service.WatersourceService;
import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.dao.SysDictDao;



@Service("watersourceService")
public class WatersourceServiceImpl implements WatersourceService {
	@Autowired
	private WatersourceDao watersourceDao;
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
	public WatersourceEntity queryObject(String id){
		return watersourceDao.queryObject(id);
	}

	@Override
	public List<WatersourceEntity> queryList(Map<String, Object> map){
		List<WatersourceEntity> list = watersourceDao.queryList(map);
		for (int i = 0; i < list.size(); i++) {
			//行政区划
			list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());
			//河湖渠库类型
			Map<String, Object> querymap = new HashMap();
			if (StringUtil.isEmpty(list.get(i).getResourceType())) {
                list.get(i).setResourceTypeName(null);
            } else {
                querymap.put("dictValue", list.get(i).getResourceType());
                querymap.put("dictType", "河湖类型");
                list.get(i).setResourceTypeName(sysDictDao.queryObject(querymap).getDictName());
            }
			//水质类别
			if (StringUtil.isEmpty(list.get(i).getWaterLevel())) {
                list.get(i).setWaterLevelName(null);
            } else {
                querymap.put("dictValue", list.get(i).getWaterLevel());
                querymap.put("dictType", "水质类型");
                list.get(i).setWaterLevelName(sysDictDao.queryObject(querymap).getDictName());
            }
			//河湖渠库名称
			if (StringUtil.isEmpty(list.get(i).getResourceType())) {
                list.get(i).setResourceName(null);
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
		return watersourceDao.queryTotal(map);
	}

	@Override
	public void save(WatersourceEntity watersource){
		watersource.setId(UUID.randomUUID().toString());
		watersourceDao.save(watersource);
	}

	@Override
	public void update(WatersourceEntity watersource){
		watersourceDao.update(watersource);
	}

	@Override
	public void delete(String id){
		watersourceDao.delete(id);
	}
}
