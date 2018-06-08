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
import com.khidi.manager.basicinfo.dao.PumpstationDao;
import com.khidi.manager.basicinfo.dao.ReservoirDao;
import com.khidi.manager.basicinfo.dao.RiverDao;
import com.khidi.manager.basicinfo.entity.PumpstationEntity;
import com.khidi.manager.basicinfo.service.PumpstationService;
import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.dao.SysDictDao;



@Service("pumpstationService")
public class PumpstationServiceImpl implements PumpstationService {
	@Autowired
	private PumpstationDao pumpstationDao;
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
	public PumpstationEntity queryObject(String id){
		return pumpstationDao.queryObject(id);
	}
	
	@Override
	public List<PumpstationEntity> queryList(Map<String, Object> map){
		List<PumpstationEntity> list = pumpstationDao.queryList(map);
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> querymap = new HashMap();
			//行政区划
			list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());
			//工程建设情况名称
			if (StringUtil.isEmpty(list.get(i).getBuildSiuation())) {
                list.get(i).setBuildSiuationName(null);;
            } else {
                querymap.put("dictValue", list.get(i).getBuildSiuation());
                querymap.put("dictType", "工程建设情况");
                list.get(i).setBuildSiuationName(sysDictDao.queryObject(querymap).getDictName());
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
		return pumpstationDao.queryTotal(map);
	}
	
	@Override
	public void save(PumpstationEntity pumpstation){
        pumpstation.setId(UUID.randomUUID().toString());
		pumpstationDao.save(pumpstation);
	}
	
	@Override
	public void update(PumpstationEntity pumpstation){
		pumpstationDao.update(pumpstation);
	}
	
	@Override
	public void delete(String id){
		pumpstationDao.delete(id);
	}
}
