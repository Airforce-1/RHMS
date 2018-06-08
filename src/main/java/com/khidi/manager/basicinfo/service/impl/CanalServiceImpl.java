package com.khidi.manager.basicinfo.service.impl;

import com.khidi.common.utils.StringUtil;
import com.khidi.manager.basicinfo.dao.*;
import com.khidi.manager.basicinfo.entity.PartRiverEntity;
import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.dao.SysDictDao;
import com.khidi.manager.sys.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;
import java.util.List;
import java.util.Map;

import com.khidi.manager.basicinfo.entity.CanalEntity;
import com.khidi.manager.basicinfo.service.CanalService;


@Service("canalService")
public class CanalServiceImpl extends AbstractService implements CanalService {
    @Autowired
    private SysAreaDao sysAreaDao;
    @Autowired
    private SysDictDao sysDictDao;
    @Autowired
    private RiverDao riverDao;
    @Autowired
    private LakeDao lakeDao;
    @Autowired
    private CanalDao canalDao;
    @Autowired
    private ReservoirDao reservoirDao;


    @Override
    public CanalEntity queryObject(String id) {
        return canalDao.queryObject(id);
    }

    @Override
    public List<CanalEntity> queryList(Map<String, Object> map) {

        List<CanalEntity> list = canalDao.queryList(map);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setAreaName(sysAreaDao.queryObject(list.get(i).getAreaId()).getName());

            Map<String, Object> querymap = new HashMap();
            if (StringUtil.isEmpty(list.get(i).getSuperType())) {
                list.get(i).setSuperTypeName(null);
            } else {
                querymap.put("dictValue", list.get(i).getSuperType());
                querymap.put("dictType", "上级河渠湖库类型");
                list.get(i).setSuperTypeName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(list.get(i).getInputType())) {
                list.get(i).setInputTypeName(null);
            } else {
                querymap.put("dictValue", list.get(i).getInputType());
                querymap.put("dictType", "排入河渠湖库类型");
                list.get(i).setInputTypeName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(list.get(i).getFunction())) {
                list.get(i).setFunctionName(null);
            } else {
                querymap.put("dictValue", list.get(i).getFunction());
                querymap.put("dictType", "渠道功能");
                list.get(i).setFunctionName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(list.get(i).getCrossType())) {
                list.get(i).setCrossTypeName(null);
            } else {
                querymap.put("dictValue", list.get(i).getCrossType());
                querymap.put("dictType", "跨界类型");
                list.get(i).setCrossTypeName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(list.get(i).getCanaltype())) {
                list.get(i).setCanalTypeName(null);
            } else {
                querymap.put("dictValue", list.get(i).getCanaltype());
                querymap.put("dictType", "河流（渠道）类型");
                list.get(i).setCanalTypeName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(list.get(i).getDirection())) {
                list.get(i).setDirectionName(null);
            } else {
                querymap.put("dictValue", list.get(i).getDirection());
                querymap.put("dictType", "岸别");
                list.get(i).setDirectionName(sysDictDao.queryObject(querymap).getDictName());
            }

            if (StringUtil.isEmpty(list.get(i).getSuperType())) {
                list.get(i).setSuperNameName(null);
            } else if (StringUtil.isEmpty(list.get(i).getSuperName())) {
                list.get(i).setSuperNameName(null);
            } else if (list.get(i).getSuperType().equals("1")) { // 河流
                list.get(i).setSuperNameName(riverDao.queryObject(list.get(i).getSuperName()).getName());
            } else if (list.get(i).getSuperType().equals("2")) { // 渠道
                list.get(i).setSuperNameName(canalDao.queryObject(list.get(i).getSuperName()).getName());
            } else if (list.get(i).getSuperType().equals("3")) { // 湖泊
                list.get(i).setSuperNameName(lakeDao.queryObject(list.get(i).getSuperName()).getName());
            } else if (list.get(i).getSuperType().equals("4")) { // 水库
                list.get(i).setSuperNameName(reservoirDao.queryObject(list.get(i).getSuperName()).getName());
            }

            if (StringUtil.isEmpty(list.get(i).getInputType())) {
                list.get(i).setInputNameName(null);
            } else if (StringUtil.isEmpty(list.get(i).getInputName())) {
                list.get(i).setInputNameName(null);
            } else if (list.get(i).getInputType().equals("1")) { // 河流
                list.get(i).setInputNameName(riverDao.queryObject(list.get(i).getInputName()).getName());
            } else if (list.get(i).getInputType().equals("2")) { // 渠道
                list.get(i).setInputNameName(canalDao.queryObject(list.get(i).getInputName()).getName());
            } else if (list.get(i).getInputType().equals("3")) { // 湖泊
                list.get(i).setInputNameName(lakeDao.queryObject(list.get(i).getInputName()).getName());
            } else if (list.get(i).getInputType().equals("4")) { // 水库
                list.get(i).setInputNameName(reservoirDao.queryObject(list.get(i).getInputName()).getName());
            }

        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return canalDao.queryTotal(map);
    }

    @Override
    public void save(CanalEntity canal) {
        canal.setId(UUID.randomUUID().toString());
        canalDao.save(canal);
    }

    @Override
    public void update(CanalEntity canal) {
        canalDao.update(canal);
    }

    @Override
    public void delete(String id) {
        canalDao.delete(id);
    }
}
