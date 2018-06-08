package com.khidi.manager.maintask.service.impl;


import com.khidi.common.utils.CurrentSession;
import com.khidi.common.utils.StringUtil;
import com.khidi.manager.basicinfo.dao.*;
import com.khidi.manager.maintask.dao.StTargetDao;
import com.khidi.manager.maintask.entity.StTargetdetailTransmitEntity;
import com.khidi.manager.sys.dao.FileuploadDao;
import com.khidi.manager.sys.entity.FileUploadEntity;
import com.khidi.manager.sys.service.CommonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.maintask.dao.StTargetdetailDao;
import com.khidi.manager.maintask.entity.StTargetdetailEntity;
import com.khidi.manager.maintask.service.StTargetdetailService;


@Service("stTargetdetailService")
public class StTargetdetailServiceImpl implements StTargetdetailService {
    @Autowired
    private StTargetdetailDao stTargetdetailDao;
    @Autowired
    private StTargetDao stTargetDao;
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
    public StTargetdetailEntity queryObject(String id) {
        StTargetdetailEntity entity = stTargetdetailDao.queryObject(id);

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


        if (com.khidi.common.utils.StringUtil.isEmpty(entity.getAttachid())) {
            entity.setFileList(null);
        } else {
            String allFlieId[] = entity.getAttachid().split(",");
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

        if (stTargetDao.queryObject(entity.getTargetid()).getXddept().equals(CurrentSession.GetDeptId())) {
            entity.setPower("2");//已转发
        } else {
            if (entity.getRespdept().equals(CurrentSession.GetDeptId())) {
                if (stTargetdetailDao.queryPower(entity.getId(), CurrentSession.GetUserId()) == 0) {
                    entity.setPower("1");//可操作
                } else {
                    entity.setPower("2");//已转发
                }
            } else {
                if (stTargetdetailDao.queryPower(entity.getId(), CurrentSession.GetUserId()) == 0) {
                    entity.setPower("0");//无权限
                } else {
                    if (stTargetdetailDao.queryNewToDept(entity.getId()).equals(CurrentSession.GetDeptId())) {
                        entity.setPower("1");//可操作
                    } else {
                        entity.setPower("2");//已转发
                    }
                }
            }
        }

        if(com.khidi.common.utils.StringUtil.isEmpty( entity.getsTime())){
            entity.setsTime(null);
        }else{
            entity.setsTime(entity.getsTime().substring(0,10));
        }


        return entity;
    }

    @Override
    public List<StTargetdetailEntity> queryList(Map<String, Object> map) {
        List<StTargetdetailEntity> list = stTargetdetailDao.queryList(map);
        for (StTargetdetailEntity entity : list) {
            if (com.khidi.common.utils.StringUtil.isEmpty(entity.getLakeId())) {
                entity.setLakeBelongTo(null);
            } else {
                Map<String, Object> lakeBelongTo = commonService.getAreaGrade(entity.getLakeType(), entity.getLakeId());
                entity.setLakeBelongTo(lakeBelongTo);
            }


            if (stTargetDao.queryObject(entity.getTargetid()).getXddept().equals(CurrentSession.GetDeptId())) {
                entity.setPower("2");//已转发
            } else {
                if (entity.getRespdept().equals(CurrentSession.GetDeptId())) {
                    if (stTargetdetailDao.queryPower(entity.getId(), CurrentSession.GetUserId()) == 0) {
                        entity.setPower("1");//可操作
                    } else {
                        entity.setPower("2");//已转发
                    }
                } else {
                    if (stTargetdetailDao.queryPower(entity.getId(), CurrentSession.GetUserId()) == 0) {
                        entity.setPower("0");//无权限
                    } else {
                        if (stTargetdetailDao.queryNewToDept(entity.getId()).equals(CurrentSession.GetDeptId())) {
                            entity.setPower("1");//可操作
                        } else {
                            entity.setPower("2");//已转发
                        }
                    }
                }
            }

            if(com.khidi.common.utils.StringUtil.isEmpty( entity.getsTime())){
                entity.setsTime(null);
            }else{
                entity.setsTime(entity.getsTime().substring(0,10));
            }
        }

        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return stTargetdetailDao.queryTotal(map);
    }

    @Override
    public void save(StTargetdetailEntity stTargetdetail) {
        stTargetdetail.setId(UUID.randomUUID().toString());
        stTargetdetailDao.save(stTargetdetail);
    }

    @Override
    public void update(StTargetdetailEntity stTargetdetail) {
        stTargetdetailDao.update(stTargetdetail);
    }

    @Override
    public void delete(String id) {
        stTargetdetailDao.delete(id);
    }
}
