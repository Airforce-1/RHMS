package com.khidi.manager.gis.service.impl;

import com.khidi.common.exception.RRException;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.basicinfo.dao.*;
import com.khidi.manager.basicinfo.entity.*;
import com.khidi.manager.gis.dao.ResourceMapDao;
import com.khidi.manager.gis.entity.ResourceMapEntity;
import com.khidi.manager.gis.service.ResourceMapService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/1/6.
 */
@Service("resourceMapService")
public class ResourceMapServiceImpl implements ResourceMapService {
    @Autowired
    private ResourceMapDao resourceMapDao;
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

    @Transactional
    @Override
    public void updateRiverFeatureId(ResourceMapEntity resourceMapEntity){
        String resourceName = resourceMapDao.queryRiverByFeatureId(resourceMapEntity.getFeatureId());
        if(StringUtil.isNotEmpty(resourceName) && !resourceName.equals(riverDao.queryObject(resourceMapEntity.getId()).getName())){
            throw new RRException(270, "该地图资源已绑定至【"+resourceName+"】");
        }
        resourceMapDao.updateRiverFeatureId(resourceMapEntity);
    }
    @Transactional
    @Override
    public void updatePartRiverFeatureId(ResourceMapEntity resourceMapEntity){
        String resourceName = resourceMapDao.queryPartRiverByFeatureId(resourceMapEntity.getFeatureId());
        if(StringUtil.isNotEmpty(resourceName) && !resourceName.equals(partRiverDao.queryObject(resourceMapEntity.getId()).getName())){
            throw new RRException(270, "该地图资源已绑定至【"+resourceName+"】");
        }
        resourceMapDao.updatePartRiverFeatureId(resourceMapEntity);
    }
    @Transactional
    @Override
    public void updateCanalFeatureId(ResourceMapEntity resourceMapEntity){
        String resourceName = resourceMapDao.queryCanalByFeatureId(resourceMapEntity.getFeatureId());
        if(StringUtil.isNotEmpty(resourceName) && !resourceName.equals(canalDao.queryObject(resourceMapEntity.getId()).getName())){
            throw new RRException(270, "该地图资源已绑定至【"+resourceName+"】");
        }
        resourceMapDao.updateCanalFeatureId(resourceMapEntity);
    }
    @Transactional
    @Override
    public void updatePartCanalFeatureId(ResourceMapEntity resourceMapEntity){
        String resourceName = resourceMapDao.queryPartCanalByFeatureId(resourceMapEntity.getFeatureId());
        if(StringUtil.isNotEmpty(resourceName) && !resourceName.equals(partCanalDao.queryObject(resourceMapEntity.getId()).getName())){
            throw new RRException(270, "该地图资源已绑定至【"+resourceName+"】");
        }
        resourceMapDao.updatePartCanalFeatureId(resourceMapEntity);
    }
    @Transactional
    @Override
    public void updateLakeFeatureId(ResourceMapEntity resourceMapEntity){
        String resourceName = resourceMapDao.queryLakeByFeatureId(resourceMapEntity.getFeatureId());
        if(StringUtil.isNotEmpty(resourceName) && !resourceName.equals(lakeDao.queryObject(resourceMapEntity.getId()).getName())){
            throw new RRException(270, "该地图资源已绑定至【"+resourceName+"】");
        }
        resourceMapDao.updateLakeFeatureId(resourceMapEntity);
    }
    @Transactional
    @Override
    public void updatePartLakeFeatureId(ResourceMapEntity resourceMapEntity){
        String resourceName = resourceMapDao.queryPartLakeByFeatureId(resourceMapEntity.getFeatureId());
        if(StringUtil.isNotEmpty(resourceName) && !resourceName.equals(partLakeDao.queryObject(resourceMapEntity.getId()).getName())){
            throw new RRException(270, "该地图资源已绑定至【"+resourceName+"】");
        }
        resourceMapDao.updatePartLakeFeatureId(resourceMapEntity);
    }
    @Transactional
    @Override
    public void updateReservoirFeatureId(ResourceMapEntity resourceMapEntity){
        String resourceName = resourceMapDao.queryReservoirByFeatureId(resourceMapEntity.getFeatureId());
        if(StringUtil.isNotEmpty(resourceName) && !resourceName.equals(reservoirDao.queryObject(resourceMapEntity.getId()).getName())){
            throw new RRException(270, "该地图资源已绑定至【"+resourceName+"】");
        }
        resourceMapDao.updateReservoirFeatureId(resourceMapEntity);
    }
    @Transactional
    @Override
    public void updatePartReservoirFeatureId(ResourceMapEntity resourceMapEntity){
        String resourceName = resourceMapDao.queryPartReservoirByFeatureId(resourceMapEntity.getFeatureId());
        if(StringUtil.isNotEmpty(resourceName) && !resourceName.equals(partReservoirDao.queryObject(resourceMapEntity.getId()).getName())){
            throw new RRException(270, "该地图资源已绑定至【"+resourceName+"】");
        }
        resourceMapDao.updatePartReservoirFeatureId(resourceMapEntity);
    }
}
