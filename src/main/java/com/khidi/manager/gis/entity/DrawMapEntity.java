package com.khidi.manager.gis.entity;

/**
 * Created by Administrator on 2018/1/9.
 */

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/**
 * ${comments}
 *
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */

public class DrawMapEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    //编码
    @ApiModelProperty(value = "编码", dataType = "String", required = true, hidden = false)
    private String id;
    //坐标点集
    @ApiModelProperty(value = "坐标点集", dataType = "String", required = true, hidden = false)
    private String pointSet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPointSet() {
        return pointSet;
    }

    public void setPointSet(String pointSet) {
        this.pointSet = pointSet;
    }
}



