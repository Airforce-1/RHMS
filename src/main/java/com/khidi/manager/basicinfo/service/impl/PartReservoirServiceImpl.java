package com.khidi.manager.basicinfo.service.impl;

import com.khidi.manager.basicinfo.dao.ReservoirDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.basicinfo.dao.PartReservoirDao;
import com.khidi.manager.basicinfo.entity.PartReservoirEntity;
import com.khidi.manager.basicinfo.service.PartReservoirService;
import com.khidi.manager.sys.dao.SysAreaDao;

@Service("partReservoirService")
public class PartReservoirServiceImpl implements PartReservoirService {
	@Autowired
	private PartReservoirDao partReservoirDao;
	@Autowired
	private ReservoirDao reservoirDao;
	@Autowired
	private SysAreaDao sysAreaDao;

	@Override
	public PartReservoirEntity queryObject(String id) {
		return partReservoirDao.queryObject(id);
	}


	@Override
	public List<PartReservoirEntity> queryListByReservoirId(String reservoirId){
		return partReservoirDao.queryListByReservoirId(reservoirId);
	}

	@Override
	public List<PartReservoirEntity> queryList(Map<String, Object> map) {
		List<PartReservoirEntity> list = partReservoirDao.queryList(map);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());
			list.get(i).setReservoirName(reservoirDao.queryObject(list.get(i).getReservoirId()).getName());
		}
		return list;
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return partReservoirDao.queryTotal(map);
	}

	@Override
	public void save(PartReservoirEntity partReservoir) {
		partReservoir.setId(UUID.randomUUID().toString());
		partReservoirDao.save(partReservoir);
	}

	@Override
	public void update(PartReservoirEntity partReservoir) {
		partReservoirDao.update(partReservoir);
	}

	@Override
	public void delete(String id) {
		partReservoirDao.delete(id);
	}

}
