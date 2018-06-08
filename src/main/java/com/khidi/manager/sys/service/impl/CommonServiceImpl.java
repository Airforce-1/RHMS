package com.khidi.manager.sys.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.khidi.manager.basicinfo.entity.*;
import com.khidi.manager.basicinfo.service.*;
import com.khidi.manager.sys.service.CommonService;
import com.khidi.manager.sys.service.SysAreaService;
import com.khidi.manager.sys.service.SysUserService;
import com.khidi.manager.sys.vo.ResourceVO;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/14.
 */
@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private RiverService riverService;
    @Autowired
    private LakeService lakeService;
    @Autowired
    private CanalService canalService;
    @Autowired
    private ReservoirService reservoirService;
    @Autowired
    private PartRiverService partRiverService;
    @Autowired
    private PartLakeService partLakeService;
    @Autowired
    private PartCanalService partCanalService;
    @Autowired
    private PartReservoirService partReservoirService;
    @Autowired
    private ResourceStationService resourceStationService;
    @Autowired
    private ResourceVideoService resourceVideoService;
    @Autowired
    private SysAreaService sysAreaService;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public List<ResourceVO> resourceList(String Id) {
        List<ResourceVO> list = new ArrayList<>();

        if (Id.equals("1")) {   //类型为河流
            List<RiverEntity> riverList = riverService.queryList(new HashMap());
            for (int i = 0; i < riverList.size(); i++) {
                ResourceVO resourceVO = new ResourceVO();
                resourceVO.setId(riverList.get(i).getId());
                resourceVO.setName(riverList.get(i).getName());
                list.add(i, resourceVO);
            }
        } else if (Id.equals("5")) {  //湖泊
            List<LakeEntity> lakeList = lakeService.queryList(new HashMap());
            for (int i = 0; i < lakeList.size(); i++) {
                ResourceVO resourceVO = new ResourceVO();
                resourceVO.setId(lakeList.get(i).getId());
                resourceVO.setName(lakeList.get(i).getName());
                list.add(i, resourceVO);
            }
        } else if (Id.equals("7")) {   //水库
            List<ReservoirEntity> reservoirList = reservoirService.queryList(new HashMap());
            for (int i = 0; i < reservoirList.size(); i++) {
                ResourceVO resourceVO = new ResourceVO();
                resourceVO.setId(reservoirList.get(i).getId());
                resourceVO.setName(reservoirList.get(i).getName());
                list.add(i, resourceVO);
            }
        } else if (Id.equals("3")) {    //渠道
            List<CanalEntity> canalList = canalService.queryList(new HashMap());
            for (int i = 0; i < canalList.size(); i++) {
                ResourceVO resourceVO = new ResourceVO();
                resourceVO.setId(canalList.get(i).getId());
                resourceVO.setName(canalList.get(i).getName());
                list.add(i, resourceVO);
            }
        } else if (Id.equals("6")) {    //湖段
            List<PartLakeEntity> partLakeList = partLakeService.queryList(new HashMap());
            for (int i = 0; i < partLakeList.size(); i++) {
                ResourceVO resourceVO = new ResourceVO();
                resourceVO.setId(partLakeList.get(i).getId());
                resourceVO.setName(partLakeList.get(i).getName());
                list.add(i, resourceVO);
            }
        } else if (Id.equals("8")) {    //库段
            List<PartReservoirEntity> partReservoirList = partReservoirService.queryList(new HashMap());
            for (int i = 0; i < partReservoirList.size(); i++) {
                ResourceVO resourceVO = new ResourceVO();
                resourceVO.setId(partReservoirList.get(i).getId());
                resourceVO.setName(partReservoirList.get(i).getName());
                list.add(i, resourceVO);
            }
        } else if (Id.equals("2")) {    //河段
            List<PartRiverEntity> partRiverList = partRiverService.queryList(new HashMap());
            for (int i = 0; i < partRiverList.size(); i++) {
                ResourceVO resourceVO = new ResourceVO();
                resourceVO.setId(partRiverList.get(i).getId());
                resourceVO.setName(partRiverList.get(i).getName());
                list.add(i, resourceVO);
            }
        } else if (Id.equals("4")) {                         //渠段
            List<PartCanalEntity> partCanalList = partCanalService.queryList(new HashMap());
            for (int i = 0; i < partCanalList.size(); i++) {
                ResourceVO resourceVO = new ResourceVO();
                resourceVO.setId(partCanalList.get(i).getId());
                resourceVO.setName(partCanalList.get(i).getName());
                list.add(i, resourceVO);
            }
        } else {
        }
        return list;
    }

    @Override
    public List<ResourceVO> stationList(String Id) {
        List<ResourceVO> list = new ArrayList<>();
        if (Id.equals("1")) {   //类型为水文监测站
            Map<String, Object> querymap = new HashedMap();
            querymap.put("stationType", "1");//水质监测站
            List<ResourceStationEntity> resourceStationList = resourceStationService.queryList(querymap);
            for (int i = 0; i < resourceStationList.size(); i++) {
                ResourceVO resourceVO = new ResourceVO();
                resourceVO.setId(resourceStationList.get(i).getId());
                resourceVO.setName(resourceStationList.get(i).getName());
                resourceVO.setAreaName(sysAreaService.queryObject(resourceStationList.get(i).getAreaId()).getName());
                resourceVO.setResourceTypeName("水质监测站");
                list.add(i, resourceVO);
            }
        } else if (Id.equals("2")) {
            Map<String, Object> querymap = new HashedMap();
            querymap.put("stationType", "2");//水文监测站
            List<ResourceStationEntity> resourceStationList = resourceStationService.queryList(querymap);
            for (int i = 0; i < resourceStationList.size(); i++) {
                ResourceVO resourceVO = new ResourceVO();
                resourceVO.setId(resourceStationList.get(i).getId());
                resourceVO.setName(resourceStationList.get(i).getName());
                resourceVO.setAreaName(sysAreaService.queryObject(resourceStationList.get(i).getAreaId()).getName());
                resourceVO.setResourceTypeName("水文监测站");
                list.add(i, resourceVO);
            }
        } else if (Id.equals("3")) {
            Map<String, Object> querymap = new HashedMap();
            querymap.put("stationType", "2");//视频监测站
            List<ResourceVideoEntity> resourceVideoList = resourceVideoService.queryList(querymap);
            for (int i = 0; i < resourceVideoList.size(); i++) {
                ResourceVO resourceVO = new ResourceVO();
                resourceVO.setId(resourceVideoList.get(i).getId());
                resourceVO.setName(resourceVideoList.get(i).getName());
                resourceVO.setAreaName(sysAreaService.queryObject(resourceVideoList.get(i).getAreaId()).getName());
                resourceVO.setResourceTypeName("视频监测站");
                list.add(i, resourceVO);
            }
        } else {
        }
        return list;
    }

    /**
     * @param type 河湖类型
     * @param id   对应主键id
     * @return
     */
    @Override
    public String getResource(String type, String id) {
        if (type.equals("1")) {   //河流
            return riverService.queryObject(id).getName();
        } else if (type.equals("5")) {   //湖泊
            return lakeService.queryObject(id).getName();
        } else if (type.equals("7")) {    //水库
            return reservoirService.queryObject(id).getName();
        } else if (type.equals("3")) {     //渠道
            return canalService.queryObject(id).getName();
        } else if (type.equals("6")) {     //湖段
            return partLakeService.queryObject(id).getName();
        } else if (type.equals("8")) {        //库段
            return partReservoirService.queryObject(id).getName();
        } else if (type.equals("2")) {    //河段
            return partRiverService.queryObject(id).getName();
        } else if (type.equals("4")) {   //渠段
            return partCanalService.queryObject(id).getName();
        } else {
            return null;
        }
    }

    @Override
    public Map<String, Object> getAreaGrade(String type, String id) {
        String areaGrade = null;
        String areaId = null;
        String areaName = null;
        String Id = null;
        String cutId = null;
        Map<String, Object> map = new HashMap();
        if (type.equals("1")) {   //河流
            areaId = riverService.queryObject(id).getAreaId();
            areaName = sysAreaService.queryObject(areaId).getName();
            Id = sysAreaService.queryObject(areaId).getId();
            cutId = Id.substring(0, 6);
            areaGrade = GetAreaGradeName(cutId);
        } else if (type.equals("2")) {    //河段
            areaId = partRiverService.queryObject(id).getAreaId();
            areaName = sysAreaService.queryObject(areaId).getName();
            Id = sysAreaService.queryObject(areaId).getId();
            cutId = Id.substring(0, 6);
            areaGrade = GetAreaGradeName(cutId);
        } else if (type.equals("3")) {    //渠道
            areaId = canalService.queryObject(id).getAreaId();
            areaName = sysAreaService.queryObject(areaId).getName();
            Id = sysAreaService.queryObject(areaId).getId();
            cutId = Id.substring(0, 6);
            areaGrade = GetAreaGradeName(cutId);
        } else if (type.equals("4")) {    //渠段
            areaId = partCanalService.queryObject(id).getAreaId();
            areaName = sysAreaService.queryObject(areaId).getName();
            Id = sysAreaService.queryObject(areaId).getId();
            cutId = Id.substring(0, 6);
            areaGrade = GetAreaGradeName(cutId);
        } else if (type.equals("5")) {    //湖泊
            areaId = lakeService.queryObject(id).getAreaId();
            areaName = sysAreaService.queryObject(areaId).getName();
            Id = sysAreaService.queryObject(areaId).getId();
            cutId = Id.substring(0, 6);
            areaGrade = GetAreaGradeName(cutId);
        } else if (type.equals("6")) {    //湖段
            areaId = partLakeService.queryObject(id).getAreaId();
            areaName = sysAreaService.queryObject(areaId).getName();
            Id = sysAreaService.queryObject(areaId).getId();
            cutId = Id.substring(0, 6);
            areaGrade = GetAreaGradeName(cutId);
        } else if (type.equals("7")) {    //水库
            areaId = reservoirService.queryObject(id).getAreaId();
            areaName = sysAreaService.queryObject(areaId).getName();
            Id = sysAreaService.queryObject(areaId).getId();
            cutId = Id.substring(0, 6);
            areaGrade = GetAreaGradeName(cutId);
        } else if (type.equals("8")) {    //库段
            areaId = partReservoirService.queryObject(id).getAreaId();
            areaName = sysAreaService.queryObject(areaId).getName();
            Id = sysAreaService.queryObject(areaId).getId();
            cutId = Id.substring(0, 6);
            areaGrade = GetAreaGradeName(cutId);
        }
        map.put("areaId", areaId);
        map.put("areaName", areaName);
        map.put("areaGrade", areaGrade);
        return map;
    }

    public Map<String, Object> getHz(String type, String id) {
        String areaId = null;
        String areaName = null;
        String hz = null;
        String hzName = null ;
        Map<String, Object> map = new HashMap();
        if (type.equals("1")) {   //河流
            areaId = riverService.queryObject(id).getAreaId();
            if (StringUtils.isEmpty(riverService.queryObject(id).getHeader())) {
                hz = null;
            } else {
                hz = riverService.queryObject(id).getHeader();
                hzName = sysUserService.queryObject(hz).getName();
            }
            areaName = sysAreaService.queryObject(areaId).getName();
        } else if (type.equals("2")) {    //河段
            areaId = partRiverService.queryObject(id).getAreaId();
            if (StringUtils.isEmpty(partRiverService.queryObject(id).getHeader())) {
                hz = null;
            } else {
                hz = partRiverService.queryObject(id).getHeader();
                hzName = sysUserService.queryObject(hz).getName();
            }
            areaName = sysAreaService.queryObject(areaId).getName();
        } else if (type.equals("3")) {    //渠道
            areaId = canalService.queryObject(id).getAreaId();
            if (StringUtils.isEmpty(canalService.queryObject(id).getHeader())) {
                hz = null;
            } else {
                hz = canalService.queryObject(id).getHeader();
                hzName = sysUserService.queryObject(hz).getName();
            }

            areaName = sysAreaService.queryObject(areaId).getName();
        } else if (type.equals("4")) {    //渠段
            areaId = partCanalService.queryObject(id).getAreaId();
            if (StringUtils.isEmpty(partCanalService.queryObject(id).getHeader())) {
                hz = null;
            } else {
                hz = partCanalService.queryObject(id).getHeader();
                hzName = sysUserService.queryObject(hz).getName();
            }

            areaName = sysAreaService.queryObject(areaId).getName();
        } else if (type.equals("5")) {    //湖泊
            areaId = lakeService.queryObject(id).getAreaId();
            if (StringUtils.isEmpty(lakeService.queryObject(id).getHeader())) {
                hz = null;
            } else {
                hz = lakeService.queryObject(id).getHeader();
                hzName = sysUserService.queryObject(hz).getName();
            }

            areaName = sysAreaService.queryObject(areaId).getName();
        } else if (type.equals("6")) {    //湖段
            areaId = partLakeService.queryObject(id).getAreaId();
            if (StringUtils.isEmpty(partLakeService.queryObject(id).getHeader())) {
                hz = null;
            } else {
                hz = partLakeService.queryObject(id).getHeader();
                hzName = sysUserService.queryObject(hz).getName();
            }

            areaName = sysAreaService.queryObject(areaId).getName();
        } else if (type.equals("7")) {    //水库
            areaId = reservoirService.queryObject(id).getAreaId();
            if (StringUtils.isEmpty(reservoirService.queryObject(id).getHeader())) {
                hz = null;
            } else {
                hz = reservoirService.queryObject(id).getHeader();
                hzName = sysUserService.queryObject(hz).getName();
            }

            areaName = sysAreaService.queryObject(areaId).getName();
        } else if (type.equals("8")) {    //库段
            areaId = partReservoirService.queryObject(id).getAreaId();
            if (StringUtils.isEmpty(partReservoirService.queryObject(id).getHeader())) {
                hz = null;
            } else {
                hz = partReservoirService.queryObject(id).getHeader();
                hzName = sysUserService.queryObject(hz).getName();
            }

            areaName = sysAreaService.queryObject(areaId).getName();
        }
        map.put("areaId", areaId);
        map.put("areaName", areaName);
        map.put("hz", hz);
        map.put("hzName",hzName);
        return map;
    }

    private static String GetAreaGradeName(String adcd) {
        int i1 = adcd.indexOf("0000");
        //
        if (i1 == 2) {
            return "省级";
        }
        i1 = adcd.indexOf("00");
        if (i1 == 4) {
            return "市级";
        }
        i1 = adcd.indexOf("00");
        if (i1 == -1) {
            return "区(县）级";
        }
        return "";
    }

}
