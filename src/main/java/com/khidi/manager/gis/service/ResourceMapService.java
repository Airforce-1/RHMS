package com.khidi.manager.gis.service;

import com.khidi.manager.basicinfo.entity.ResourceVideoEntity;
import com.khidi.manager.gis.entity.ResourceMapEntity;

/**
 * Created by Administrator on 2018/1/6.
 */
public interface ResourceMapService {
    void updateRiverFeatureId(ResourceMapEntity resourceMapEntity);
    void updatePartRiverFeatureId(ResourceMapEntity resourceMapEntity);
    void updateCanalFeatureId(ResourceMapEntity resourceMapEntity);
    void updatePartCanalFeatureId(ResourceMapEntity resourceMapEntity);
    void updateLakeFeatureId(ResourceMapEntity resourceMapEntity);
    void updatePartLakeFeatureId(ResourceMapEntity resourceMapEntity);
    void updateReservoirFeatureId(ResourceMapEntity resourceMapEntity);
    void updatePartReservoirFeatureId(ResourceMapEntity resourceMapEntity);

}
