package com.khidi.manager.sys.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/2.
 */
public class ResourceVO implements Serializable {
    private String id;
    private String name;
    private String areaName;
    private String resourceTypeName;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getResourceTypeName() {
        return resourceTypeName;
    }

    public void setResourceTypeName(String resourceTypeName) {
        this.resourceTypeName = resourceTypeName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
