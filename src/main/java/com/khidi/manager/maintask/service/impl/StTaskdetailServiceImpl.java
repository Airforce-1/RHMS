package com.khidi.manager.maintask.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.khidi.common.utils.CurrentSession;
import com.khidi.manager.basicinfo.dao.*;
import com.khidi.manager.maintask.dao.StTaskDao;
import com.khidi.manager.maintask.entity.StSubtaskprogressEntity;
import com.khidi.manager.maintask.entity.StTaskdetailTransmitEntity;
import com.khidi.manager.monitoringnet.dao.WaterqualitydataDao;
import com.khidi.manager.sys.dao.FileuploadDao;
import com.khidi.manager.sys.dao.SysDeptDao;
import com.khidi.manager.sys.entity.FileUploadEntity;
import com.khidi.manager.sys.entity.SysDeptEntity;
import com.khidi.manager.sys.entity.SysDictEntity;
import com.khidi.manager.sys.service.CommonService;
import com.lkx.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.maintask.dao.StTaskdetailDao;
import com.khidi.manager.maintask.entity.StTaskdetailEntity;
import com.khidi.manager.maintask.service.StTaskdetailService;


@Service("stTaskdetailService")
public class StTaskdetailServiceImpl implements StTaskdetailService {
    @Autowired
    private StTaskdetailDao stTaskdetailDao;
    @Autowired
    private StTaskDao stTaskDao;
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
    private FileuploadDao fileuploadDao;
    @Autowired
    private CommonService commonService;


    @Override
    public StTaskdetailEntity queryObject(String id) {
        StTaskdetailEntity entity = stTaskdetailDao.queryObject(id);

        if (com.khidi.common.utils.StringUtil.isEmpty(entity.getLakeId())) {
            entity.setLakeBelongTo(null);
        } else {
            Map<String, Object> lakeBelongTo = commonService.getAreaGrade(entity.getLakeType(), entity.getLakeId());
            entity.setLakeBelongTo(lakeBelongTo);
        }

        if (com.khidi.common.utils.StringUtil.isEmpty(entity.getLakeType())) {
            entity.setLakeName(null);
        } else if (com.khidi.common.utils.StringUtil.isEmpty(entity.getLakeId())) {
            entity.setLakeName(null);
        } else if (entity.getLakeType().equals("1")) {   //河流
            entity.setLakeName(riverDao.queryObject(entity.getLakeId()).getName());
        } else if (entity.getLakeType().equals("2")) {    //河段
            entity.setLakeName(partRiverDao.queryObject(entity.getLakeId()).getName());
        } else if (entity.getLakeType().equals("3")) {    //渠道
            entity.setLakeName(canalDao.queryObject(entity.getLakeId()).getName());
        } else if (entity.getLakeType().equals("4")) {    //渠段
            entity.setLakeName(partCanalDao.queryObject(entity.getLakeId()).getName());
        } else if (entity.getLakeType().equals("5")) {  //湖泊
            entity.setLakeName(lakeDao.queryObject(entity.getLakeId()).getName());
        } else if (entity.getLakeType().equals("6")) {    //湖段
            entity.setLakeName(partLakeDao.queryObject(entity.getLakeId()).getName());
        } else if (entity.getLakeType().equals("7")) {   //水库
            entity.setLakeName(reservoirDao.queryObject(entity.getLakeId()).getName());
        } else if (entity.getLakeType().equals("8")) {    //库段
            entity.setLakeName(partReservoirDao.queryObject(entity.getLakeId()).getName());
        }


        if (stTaskDao.queryObject(entity.getTaskid()).getXddept().equals(CurrentSession.GetDeptId())) {
            entity.setPower("2");//已转发
        } else {
            if (entity.getRespdept().equals(CurrentSession.GetDeptId())) {
                if (stTaskdetailDao.queryPower(entity.getId(), CurrentSession.GetUserId()) == 0) {
                   entity.setPower("1");//可操作
                } else {
                    entity.setPower("2");//已转发
                }
            } else {
                if (stTaskdetailDao.queryPower(entity.getId(), CurrentSession.GetUserId()) == 0) {
                    entity.setPower("0");//无权限
                } else {
                    if (stTaskdetailDao.queryNewToDept(entity.getId()).equals(CurrentSession.GetDeptId())) {
                        entity.setPower("1");//可操作
                    } else {
                        entity.setPower("2");//已转发
                    }
                }
            }
        }



        if (com.khidi.common.utils.StringUtil.isEmpty(entity.getSolattachid())) {
            entity.setFileList(null);
        } else {
            String allFlieId[] = entity.getSolattachid().split(",");
            List<FileUploadEntity> fileUpload = new ArrayList<FileUploadEntity>();
            for (int j = 0; j < allFlieId.length; j++) {
                FileUploadEntity fileinfo = new FileUploadEntity();
                fileinfo.setId(fileuploadDao.queryObject(allFlieId[j]).getId());
                fileinfo.setFileName(fileuploadDao.queryObject(allFlieId[j]).getFileName());
                fileinfo.setFilePath(fileuploadDao.queryObject(allFlieId[j]).getFilePath());
                fileUpload.add(fileinfo);
            }
            entity.setFileList(fileUpload);
        }
        return entity;
    }

    @Override
    public List<StTaskdetailEntity> queryList(Map<String, Object> map) {
        List<StTaskdetailEntity> list = stTaskdetailDao.queryList(map);
        for (StTaskdetailEntity entity:list) {

            if (stTaskDao.queryObject(entity.getTaskid()).getXddept().equals(CurrentSession.GetDeptId())) {
                entity.setPower("2");//已转发
            } else {
                if (entity.getRespdept().equals(CurrentSession.GetDeptId())) {
                    if (stTaskdetailDao.queryPower(entity.getId(), CurrentSession.GetUserId()) == 0) {
                        entity.setPower("1");//可操作
                    } else {
                        entity.setPower("2");//已转发
                    }
                } else {
                    if (stTaskdetailDao.queryPower(entity.getId(), CurrentSession.GetUserId()) == 0) {
                        entity.setPower("0");//无权限
                    } else {
                        if (stTaskdetailDao.queryNewToDept(entity.getId()).equals(CurrentSession.GetDeptId())) {
                            entity.setPower("1");//可操作
                        } else {
                            entity.setPower("2");//已转发
                        }
                    }
                }
            }
        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return stTaskdetailDao.queryTotal(map);
    }

    @Override
    public void save(StTaskdetailEntity stTaskdetail) {
        stTaskdetail.setId(UUID.randomUUID().toString());
        stTaskdetailDao.save(stTaskdetail);
    }

    @Override
    public void update(StTaskdetailEntity stTaskdetail) {
        stTaskdetailDao.update(stTaskdetail);
    }

    @Override
    public void delete(String id) {
        stTaskdetailDao.delete(id);
    }


}
