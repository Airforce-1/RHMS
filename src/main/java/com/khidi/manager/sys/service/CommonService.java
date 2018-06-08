package com.khidi.manager.sys.service;

import com.khidi.manager.sys.vo.ResourceVO;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/14.
 */
public interface CommonService {
    List<ResourceVO> resourceList(String Id);

    List<ResourceVO> stationList(String Id);

    String getResource(String type, String id);

    Map<String, Object> getAreaGrade(String type, String id);

    Map<String, Object> getHz(String type, String id);
}
