package com.khidi.manager.basicinfo.service.impl;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.sys.dao.FileuploadDao;
import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.entity.FileUploadEntity;
import com.qiniu.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.basicinfo.dao.ResourceWaterabilityDao;
import com.khidi.manager.basicinfo.entity.ResourceWaterabilityEntity;
import com.khidi.manager.basicinfo.service.ResourceWaterabilityService;

@Service("resourceWaterabilityService")
public class ResourceWaterabilityServiceImpl implements ResourceWaterabilityService {
    @Autowired
    private ResourceWaterabilityDao resourceWaterabilityDao;
    @Autowired
    private SysAreaDao sysAreaDao;
    @Autowired
    private FileuploadDao fileuploadDao;

    @Override
    public ResourceWaterabilityEntity queryObject(String id) {
        return resourceWaterabilityDao.queryObject(id);
    }

    @Override
    public List<ResourceWaterabilityEntity> queryList(Map<String, Object> map) {
        List<ResourceWaterabilityEntity> list = resourceWaterabilityDao.queryList(map);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());
            if (StringUtil.isEmpty(list.get(i).getAttachment())) {
                list.get(i).setFileList(null);
            } else {
                String allFlieId[] = list.get(i).getAttachment().split(",");
                List<FileUploadEntity> fileUpload = new ArrayList<FileUploadEntity>();
                for (int j = 0; j < allFlieId.length; j++) {
                    FileUploadEntity fileinfo = new FileUploadEntity();
                    fileinfo.setId(fileuploadDao.queryObject(allFlieId[j]).getId());
                    fileinfo.setFileName(fileuploadDao.queryObject(allFlieId[j]).getFileName());
                    fileinfo.setFilePath(fileuploadDao.queryObject(allFlieId[j]).getFilePath());
                    fileUpload.add(fileinfo);
                }
                list.get(i).setFileList(fileUpload);
            }
        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return resourceWaterabilityDao.queryTotal(map);
    }

    @Override
    public void save(ResourceWaterabilityEntity resourceWaterability) {
        resourceWaterability.setId(UUID.randomUUID().toString());
        resourceWaterabilityDao.save(resourceWaterability);
    }

    @Override
    public void update(ResourceWaterabilityEntity resourceWaterability) {
        resourceWaterabilityDao.update(resourceWaterability);
    }

    @Override
    public void delete(String id) {
        resourceWaterabilityDao.delete(id);
    }


    public String getSubAreaIdList(String areaId) {
        //行政区划及子行政区划ID列表
        List<String> areaIdList = new ArrayList<>();

        //获取子行政区划ID
        List<String> subIdList = sysAreaDao.queryAreaIdList(areaId);
        getAreaTreeList(subIdList, areaIdList);

        //添加本行政区划
        areaIdList.add(areaId);

        String areaFilter = StringUtils.join(areaIdList, ",");
        return areaFilter;
    }

    /**
     * 递归
     */
    public void getAreaTreeList(List<String> subIdList, List<String> areaIdList) {
        for (String areaId : subIdList) {
            List<String> list = sysAreaDao.queryAreaIdList(areaId);
            if (list.size() > 0) {
                getAreaTreeList(list, areaIdList);
            }

            areaIdList.add(areaId);
        }
    }
}
