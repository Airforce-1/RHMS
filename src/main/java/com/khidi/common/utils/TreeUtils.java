package com.khidi.common.utils;

import com.khidi.manager.sys.dao.SysAreaDao;
import com.khidi.manager.sys.entity.SysAreaEntity;
import com.qiniu.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shudewei
 * 2017.12.7
 */

public class TreeUtils {
    /**
     * 获取行政职务父节点下面的所有子节点
     * @param
     * @param
     * @return
     */

    @Autowired
    private static SysAreaDao sysAreaDao;

    public String getSubAreaIdList(String areaId){
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
    public void getAreaTreeList(List<String> subIdList, List<String> areaIdList){
        for(String areaId : subIdList){
            List<String> list = sysAreaDao.queryAreaIdList(areaId);
            if(list.size() > 0){
                getAreaTreeList(list, areaIdList);
            }

            areaIdList.add(areaId);
        }
    }
}
