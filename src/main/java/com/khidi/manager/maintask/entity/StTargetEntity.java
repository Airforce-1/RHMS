package com.khidi.manager.maintask.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * ${comments}
 *
 * @author fdz
 * @email 592926573@qq.com
 * @date 2018-01-03 10:29:04
 */
public class StTargetEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //进度值
    @ApiModelProperty(value = "进度值",dataType="Double",required = true,hidden = false)
    private Double progress;
    //编号
    @ApiModelProperty(value = "编号", dataType = "String", required = true, hidden = false)
    private String id;
    //目标编码
    @ApiModelProperty(value = "目标编码", dataType = "String", required = true, hidden = false)
    private String targetcode;
    //目标名称
    @ApiModelProperty(value = "目标名称", dataType = "String", required = true, hidden = false)
    private String targetname;
    //指标项
    @ApiModelProperty(value = "指标项", dataType = "String", required = true, hidden = false)
    private String indicators;
    //河湖类型
    @ApiModelProperty(value = "河湖类型", dataType = "String", required = true, hidden = false)
    private String laketype;
    //河湖编号
    @ApiModelProperty(value = "河湖编号", dataType = "String", required = true, hidden = false)
    private String lakeid;
    //河湖归属
    @ApiModelProperty(value = "河湖归属", dataType = "String", required = true, hidden = false)
    private String lakebelongto;
    //行政区划编号
    @ApiModelProperty(value = "行政区划编号", dataType = "String", required = true, hidden = false)
    private String areacode;
    //开始时间
    @ApiModelProperty(value = "开始时间", dataType = "String", required = true, hidden = false)
    private String stime;
    //目标期限
    @ApiModelProperty(value = "目标期限", dataType = "String", required = true, hidden = false)
    private String targetperiod;
    //牵头部门
    @ApiModelProperty(value = "牵头部门", dataType = "String", required = true, hidden = false)
    private String qtdept;
    //下达部门
    @ApiModelProperty(value = "下达部门", dataType = "String", required = true, hidden = false)
    private String xddept;
    //目标类型
    @ApiModelProperty(value = "目标类型", dataType = "String", required = true, hidden = false)
    private String targettype;
    //目标来源
    @ApiModelProperty(value = "目标来源", dataType = "String", required = true, hidden = false)
    private String targetsource;
    //指标类型
    @ApiModelProperty(value = "指标类型", dataType = "String", required = true, hidden = false)
    private String zbtype;
    //现状指标值
    @ApiModelProperty(value = "现状指标值", dataType = "String", required = true, hidden = false)
    private String nowindicators;
    //预期指标值
    @ApiModelProperty(value = "预期指标值", dataType = "String", required = true, hidden = false)
    private String expectedindicators;
    //详细地址
    @ApiModelProperty(value = "详细地址", dataType = "String", required = true, hidden = false)
    private String detailaddress;
    //备注
    @ApiModelProperty(value = "备注", dataType = "String", required = true, hidden = false)
    private String memo;
    //级别目标类型
    @ApiModelProperty(value = "级别目标类型", dataType = "String", required = true, hidden = false)
    private String targetglobaltype;

    //行政区划名称
    @ApiModelProperty(value = "行政区划名称", dataType = "String", required = true, hidden = false)
    private String areaName;
    //目标类型名称
    @ApiModelProperty(value = "目标类型名称", dataType = "String", required = true, hidden = false)
    private String targettypeName;
    //目标来源名称
    @ApiModelProperty(value = "目标来源名称", dataType = "String", required = true, hidden = false)
    private String targetsourceName;
    //指标类型名称
    @ApiModelProperty(value = "指标类型名称", dataType = "String", required = true, hidden = false)
    private String zbtypeName;
    //河湖类型名称
    @ApiModelProperty(value = "河湖类型名称", dataType = "String", required = true, hidden = false)
    private String lakeTypeName;
    //河湖名称
    @ApiModelProperty(value = "河湖名称", dataType = "String", required = true, hidden = false)
    private String lakeName;
    //牵头部门名称
    @ApiModelProperty(value = "牵头部门名称", dataType = "String", required = true, hidden = false)
    private String qtdeptName;
    //下达部门名称
    @ApiModelProperty(value = "下达部门名称", dataType = "String", required = true, hidden = false)
    private String xddeptName;
    
    // 目标明细
    private List<StTargetdetailEntity> targetDetails;


    public List<StTargetdetailEntity> getTargetDetails() {
		return targetDetails;
	}

	public void setTargetDetails(List<StTargetdetailEntity> targetDetail) {
		this.targetDetails = targetDetail;
	}

	public String getLakeTypeName() {
        return lakeTypeName;
    }

    public void setLakeTypeName(String laketypeName) {
        this.lakeTypeName = laketypeName;
    }

    public String getQtdeptName() {
        return qtdeptName;
    }

    public void setQtdeptName(String qtdeptName) {
        this.qtdeptName = qtdeptName;
    }

    public String getXddeptName() {
        return xddeptName;
    }

    public void setXddeptName(String xddeptName) {
        this.xddeptName = xddeptName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getTargettypeName() {
        return targettypeName;
    }

    public void setTargettypeName(String targettypeName) {
        this.targettypeName = targettypeName;
    }

    public String getTargetsourceName() {
        return targetsourceName;
    }

    public void setTargetsourceName(String targetsourceName) {
        this.targetsourceName = targetsourceName;
    }

    public String getZbtypeName() {
        return zbtypeName;
    }

    public void setZbtypeName(String zbtypeName) {
        this.zbtypeName = zbtypeName;
    }

    public String getLakeName() {
        return lakeName;
    }

    public void setLakeName(String lakeName) {
        this.lakeName = lakeName;
    }


    /**
     * 设置：进度值
     */
    public void setProgress(Double progress) {
        this.progress = progress;
    }
    /**
     * 获取：进度值
     */
    public Double getProgress() {
        return progress;
    }
    /**
     * 设置：编号
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取：编号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置：目标编码
     */
    public void setTargetcode(String targetcode) {
        this.targetcode = targetcode;
    }

    /**
     * 获取：目标编码
     */
    public String getTargetcode() {
        return targetcode;
    }

    /**
     * 设置：目标名称
     */
    public void setTargetname(String targetname) {
        this.targetname = targetname;
    }

    /**
     * 获取：目标名称
     */
    public String getTargetname() {
        return targetname;
    }

    /**
     * 设置：指标项
     */
    public void setIndicators(String indicators) {
        this.indicators = indicators;
    }

    /**
     * 获取：指标项
     */
    public String getIndicators() {
        return indicators;
    }

    /**
     * 设置：河湖类型
     */
    public void setLaketype(String laketype) {
        this.laketype = laketype;
    }

    /**
     * 获取：河湖类型
     */
    public String getLaketype() {
        return laketype;
    }

    /**
     * 设置：河湖编号
     */
    public void setLakeid(String lakeid) {
        this.lakeid = lakeid;
    }

    /**
     * 获取：河湖编号
     */
    public String getLakeid() {
        return lakeid;
    }

    /**
     * 设置：河湖归属
     */
    public void setLakebelongto(String lakebelongto) {
        this.lakebelongto = lakebelongto;
    }

    /**
     * 获取：河湖归属
     */
    public String getLakebelongto() {
        return lakebelongto;
    }

    /**
     * 设置：行政区划
     */
    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    /**
     * 获取：行政区划
     */
    public String getAreacode() {
        return areacode;
    }

    /**
     * 设置：开始时间
     */
    public void setStime(String stime) {
        this.stime = stime;
    }

    /**
     * 获取：开始时间
     */
    public String getStime() {
        return stime;
    }

    /**
     * 设置：目标期限
     */
    public void setTargetperiod(String targetperiod) {
        this.targetperiod = targetperiod;
    }

    /**
     * 获取：目标期限
     */
    public String getTargetperiod() {
        return targetperiod;
    }

    /**
     * 设置：牵头部门
     */
    public void setQtdept(String qtdept) {
        this.qtdept = qtdept;
    }

    /**
     * 获取：牵头部门
     */
    public String getQtdept() {
        return qtdept;
    }

    /**
     * 设置：下达部门
     */
    public void setXddept(String xddept) {
        this.xddept = xddept;
    }

    /**
     * 获取：下达部门
     */
    public String getXddept() {
        return xddept;
    }

    /**
     * 设置：目标类型
     */
    public void setTargettype(String targettype) {
        this.targettype = targettype;
    }

    /**
     * 获取：目标类型
     */
    public String getTargettype() {
        return targettype;
    }

    /**
     * 设置：目标来源
     */
    public void setTargetsource(String targetsource) {
        this.targetsource = targetsource;
    }

    /**
     * 获取：目标来源
     */
    public String getTargetsource() {
        return targetsource;
    }

    /**
     * 设置：指标类型
     */
    public void setZbtype(String zbtype) {
        this.zbtype = zbtype;
    }

    /**
     * 获取：指标类型
     */
    public String getZbtype() {
        return zbtype;
    }

    /**
     * 设置：现状指标值
     */
    public void setNowindicators(String nowindicators) {
        this.nowindicators = nowindicators;
    }

    /**
     * 获取：现状指标值
     */
    public String getNowindicators() {
        return nowindicators;
    }

    /**
     * 设置：预期指标值
     */
    public void setExpectedindicators(String expectedindicators) {
        this.expectedindicators = expectedindicators;
    }

    /**
     * 获取：预期指标值
     */
    public String getExpectedindicators() {
        return expectedindicators;
    }

    /**
     * 设置：详细地址
     */
    public void setDetailaddress(String detailaddress) {
        this.detailaddress = detailaddress;
    }

    /**
     * 获取：详细地址
     */
    public String getDetailaddress() {
        return detailaddress;
    }

    /**
     * 设置：备注
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 获取：备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置：目标类型
     */
    public void setTargetglobaltype(String targetglobaltype) {
        this.targetglobaltype = targetglobaltype;
    }

    /**
     * 获取：目标类型
     */
    public String getTargetglobaltype() {
        return targetglobaltype;
    }
}
