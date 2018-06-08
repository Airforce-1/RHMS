package com.khidi.common.utils;

import com.khidi.manager.basicinfo.entity.CanalEntity;
import com.khidi.manager.sys.entity.SysAreaEntity;

import java.io.Serializable;
import java.util.*;

/**
 *
 */
public class ListUtil implements Serializable {
    /**
     *
     * @param resultList 待分页list
     * @param page       页数
     * @param limit      每页条数
     * @return
     */
    public static PageUtils ListPage(List resultList,int page,int limit){
        Map<String,Object> queryparams = new HashMap<String,Object>();
        queryparams.put("page", page);
        queryparams.put("limit", limit);
        Query query = new Query(queryparams);
        if(resultList.size() < page*limit){
            PageUtils pageUtil = new PageUtils(resultList.subList((page-1)*limit,resultList.size()), resultList.size(), query.getLimit(), query.getPage());
            return pageUtil;
        }else{
            PageUtils pageUtil = new PageUtils(resultList.subList((page-1)*limit,page*limit), resultList.size(), query.getLimit(), query.getPage());
            return pageUtil;
        }
    }



    public static List<SysAreaEntity> getNewAreaList(List<SysAreaEntity> list){
        List<SysAreaEntity> myList=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(!myList.contains(list.get(i))){
                myList.add(list.get(i));
            }
        }
        return myList;
    }



    public static List<CanalEntity> getNewCanalList(List<CanalEntity> list){
        List<CanalEntity> myList=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(!myList.contains(list.get(i))){
                myList.add(list.get(i));
            }
        }
        return myList;
    }
}


