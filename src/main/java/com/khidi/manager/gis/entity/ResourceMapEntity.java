package com.khidi.manager.gis.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * ${comments}
 *
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-18 11:11:52
 */

public class ResourceMapEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    //编码
    @ApiModelProperty(value = "编码", dataType = "String", required = true, hidden = false)
    private String id;
    //地图资源编码
    @ApiModelProperty(value = "地图资源编码", dataType = "String", required = true, hidden = false)
    private String featureId;

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}


