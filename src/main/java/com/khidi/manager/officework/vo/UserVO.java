package com.khidi.manager.officework.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/2.
 */
public class UserVO implements Serializable {
    private String userId;//系统编码
    private String name;//姓名
    private String deptName;//机构名称
    private String roleName;//职务名称
    private String mobile;//电话

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


}
