package com.khidi.manager.gb.service.impl;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.gb.vo.DataByLevelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.gb.dao.StandardWaterDao;
import com.khidi.manager.gb.entity.StandardWaterEntity;
import com.khidi.manager.gb.service.StandardWaterService;



@Service("standardWaterService")
public class StandardWaterServiceImpl implements StandardWaterService {
	@Autowired
	private StandardWaterDao standardWaterDao;
	
	@Override
	public StandardWaterEntity queryObject(String id){
		return standardWaterDao.queryObject(id);
	}
	
	@Override
	public List<StandardWaterEntity> queryList(Map<String, Object> map){
	    return standardWaterDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return standardWaterDao.queryTotal(map);
	}
	
	@Override
	public void save(StandardWaterEntity standardWater){
        standardWater.setId(UUID.randomUUID().toString());
		standardWaterDao.save(standardWater);
	}
	
	@Override
	public void update(StandardWaterEntity standardWater){
		standardWaterDao.update(standardWater);
	}
	
	@Override
	public void delete(String id){
		standardWaterDao.delete(id);
	}


	@Override
	public DataByLevelVo getDataByLevel(String level){
			if(level.equals("1")){
				level = "river_one";
			}else if(level.equals("2")){
				level = "river_two";
			}else if(level.equals("3")){
				level = "river_three";
			}else if(level.equals("4")){
				level = "river_four";
			}else if(level.equals("5")){
				level = "river_five";
			}
		return standardWaterDao.getDataByLevel(level);
	}


	@Override
	public int getCodLevelByValue(String value){
		return standardWaterDao.getCodLevelByValue(value);
	}
	@Override
	public int getPLevelByValue(String value){
		return standardWaterDao.getPLevelByValue(value);
	}
	@Override
	public int getNHLevelByValue(String value){
		return standardWaterDao.getNHLevelByValue(value);
	}
}
