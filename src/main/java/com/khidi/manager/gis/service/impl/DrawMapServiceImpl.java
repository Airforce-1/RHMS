package com.khidi.manager.gis.service.impl;

import com.khidi.common.exception.RRException;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.basicinfo.dao.*;
import com.khidi.manager.gis.dao.DrawMapDao;
import com.khidi.manager.gis.dao.ResourceMapDao;
import com.khidi.manager.gis.entity.DrawMapEntity;
import com.khidi.manager.gis.entity.ResourceMapEntity;
import com.khidi.manager.gis.service.DrawMapService;
import com.khidi.manager.gis.service.ResourceMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/1/6.
 */
@Service("drawMapService")
public class DrawMapServiceImpl implements DrawMapService {
    @Autowired
    private DrawMapDao drawMapDao;


    @Transactional
    @Override
    public void drawMap4WaterAbility(DrawMapEntity entity){
        drawMapDao.drawMap4WaterAbility(entity);
    }

    @Transactional
    @Override
    public void drawMap4Irrigated(DrawMapEntity entity){
        drawMapDao.drawMap4Irrigated(entity);
    }

}
