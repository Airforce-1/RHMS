package com.khidi.manager.gis.service;

import com.khidi.manager.gis.entity.DrawMapEntity;
import com.khidi.manager.gis.entity.ResourceMapEntity;

/**
 * Created by Administrator on 2018/1/6.
 */
public interface DrawMapService {
    void drawMap4WaterAbility(DrawMapEntity entity);
    void drawMap4Irrigated(DrawMapEntity entity);
}
