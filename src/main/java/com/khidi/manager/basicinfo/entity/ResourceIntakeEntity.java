package com.khidi.manager.basicinfo.entity;

import com.khidi.manager.sys.entity.FileUploadEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ${comments}
 *
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-23 10:22:51
 */
public class ResourceIntakeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    // 行政区划名称
    @ApiModelProperty(value = "所属行政区划名称", dataType = "String", required = true, hidden = false)
    private String areaName;
    // 水质类型
    @ApiModelProperty(value = "水质类型", dataType = "String", required = true, hidden = false)
    private String waterTyper;
    // 开始取水时间
    @ApiModelProperty(value = "开始取水时间", dataType = "Date", required = true, hidden = false)
    private Date waterStarttime;
    // 设计流量(m3/s)
    @ApiModelProperty(value = "设计流量(m3/s)", dataType = "String", required = true, hidden = false)
    private String designFlow;
    // 许可最大流量(m3/s)
    @ApiModelProperty(value = "许可最大流量(m3/s)", dataType = "String", required = true, hidden = false)
    private String allowFlow;
    // 许可总取水量(万m3)
    @ApiModelProperty(value = "许可总取水量(万m3)", dataType = "String", required = true, hidden = false)
    private String allowSum;
    // 累计取水量(万m3)
    @ApiModelProperty(value = "累计取水量(万m3)", dataType = "String", required = true, hidden = false)
    private String sum;
    // 备注
    @ApiModelProperty(value = "备注", dataType = "String", required = true, hidden = false)
    private String remark;
    // 附件
    @ApiModelProperty(value = "附件", dataType = "String", required = true, hidden = false)
    private String attachment;
    // 生成时间
    @ApiModelProperty(value = "生成时间", dataType = "Date", required = true, hidden = false)
    private Date createTime;
    // 系统编码
    @ApiModelProperty(value = "系统编码", dataType = "String", required = true, hidden = false)
    private String id;
    // 河口编码
    @ApiModelProperty(value = "河口编码", dataType = "String", required = true, hidden = false)
    private String code;
    // 河口名称
    @ApiModelProperty(value = "河口名称", dataType = "String", required = true, hidden = false)
    private String name;
    // 河口类型
    @ApiModelProperty(value = "河口类型", dataType = "String", required = true, hidden = false)
    private String type;
    // 行政区划
    @ApiModelProperty(value = "行政区划", dataType = "String", required = true, hidden = false)
    private String areaId;
    // 经度
    @ApiModelProperty(value = "经度", dataType = "String", required = true, hidden = false)
    private String x;
    // 纬度
    @ApiModelProperty(value = "纬度", dataType = "String", required = true, hidden = false)
    private String y;
    // 地址
    @ApiModelProperty(value = "地址", dataType = "String", required = true, hidden = false)
    private String address;
    // 河湖渠库（段）类型
    @ApiModelProperty(value = "河湖渠库（段）类型", dataType = "String", required = true, hidden = false)
    private String resourceType;
    // 河湖渠库（段）编号
    @ApiModelProperty(value = "河湖渠库（段）编号", dataType = "String", required = true, hidden = false)
    private String resourceId;
    // 河湖渠库（段）名称
    @ApiModelProperty(value = "河湖渠库（段）编号", dataType = "String", required = true, hidden = false)
    private String resourceName;
    // 负责人
    @ApiModelProperty(value = "负责人", dataType = "String", required = true, hidden = false)
    private String owner;
    // 负责人电话
    @ApiModelProperty(value = "负责人电话", dataType = "String", required = true, hidden = false)
    private String phone;
    // 工程建设情况
    @ApiModelProperty(value = "工程建设情况", dataType = "String", required = true, hidden = false)
    private String stationBuild;
    // 运行状况
    @ApiModelProperty(value = "运行状况", dataType = "String", required = true, hidden = false)
    private String stationSituation;
    // 取水方式
    @ApiModelProperty(value = "取水方式", dataType = "String", required = true, hidden = false)
    private String getway;
    // 开工时间
    @ApiModelProperty(value = "开工时间", dataType = "Date", required = true, hidden = false)
    private Date stationStarttime;
    // 建成时间
    @ApiModelProperty(value = "建成时间", dataType = "Date", required = true, hidden = false)
    private Date stationBuildttime;
    // 管理单位
    @ApiModelProperty(value = "管理单位", dataType = "String", required = true, hidden = false)
    private String manager;
    //工程建设情况名称
    @ApiModelProperty(value = "工程建设情况名称", dataType = "String", required = true, hidden = false)
    private String stationBuildName;
    //水质类型名称
    @ApiModelProperty(value = "水质类型名称", dataType = "String", required = true, hidden = false)
    private String waterTyperName;
    //河湖渠库（段）类型名称
    @ApiModelProperty(value = "河湖渠库（段）类型名称", dataType = "String", required = true, hidden = false)
    private String resourceTypeName;
    //取水方式名称
    @ApiModelProperty(value = "取水方式名称", dataType = "String", required = true, hidden = false)
    private String getwayName;
    //运行状况名称
    @ApiModelProperty(value = "运行状况名称", dataType = "String", required = true, hidden = false)
    private String stationSituationName;
    //附件属性
    @ApiModelProperty(value = "附件属性",dataType="String",required = true,hidden = false)
    private List<FileUploadEntity> fileList;

    public List<FileUploadEntity> getFileList() {
        return fileList;
    }

    public void setFileList(List<FileUploadEntity> fileList) {
        this.fileList = fileList;
    }


    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * 获取：工程建设情况名称
     */
    public String getStationBuildName() {
        return stationBuildName;
    }

    /**
     * 设置：工程建设情况名称
     */
    public void setStationBuildName(String stationBuildName) {
        this.stationBuildName = stationBuildName;
    }


    /**
     * 获取：水质类型名称
     */
    public String getWaterTyperName() {
        return waterTyperName;
    }

    /**
     * 设置：水质类型名称
     */
    public void setWaterTyperName(String waterTyperName) {
        this.waterTyperName = waterTyperName;
    }

    /**
     * 获取：河湖渠库（段）类型名称
     */
    public String getResourceTypeName() {
        return resourceTypeName;
    }

    /**
     * 设置：河湖渠库（段）类型名称
     */
    public void setResourceTypeName(String resourceTypeName) {
        this.resourceTypeName = resourceTypeName;
    }

    /**
     * 获取：取水方式名称
     */
    public String getGetwayName() {
        return getwayName;
    }

    /**
     * 设置：取水方式名称
     */
    public void setGetwayName(String getwayName) {
        this.getwayName = getwayName;
    }

    /**
     * 获取：运行状况名称
     */
    public String getStationSituationName() {
        return stationSituationName;
    }

    /**
     * 设置：运行状况名称
     */
    public void setStationSituationName(String stationSituationName) {
        this.stationSituationName = stationSituationName;
    }

    /**
     * 获取：所属行政区划名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置：所属行政区划名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 设置：水质类型
     */
    public void setWaterTyper(String waterTyper) {
        this.waterTyper = waterTyper;
    }

    /**
     * 获取：水质类型
     */
    public String getWaterTyper() {
        return waterTyper;
    }

    /**
     * 设置：开始取水时间
     */
    public void setWaterStarttime(Date waterStarttime) {
        this.waterStarttime = waterStarttime;
    }

    /**
     * 获取：开始取水时间
     */
    public Date getWaterStarttime() {
        return waterStarttime;
    }

    /**
     * 设置：设计流量(m3/s)
     */
    public void setDesignFlow(String designFlow) {
        this.designFlow = designFlow;
    }

    /**
     * 获取：设计流量(m3/s)
     */
    public String getDesignFlow() {
        return designFlow;
    }

    /**
     * 设置：许可最大流量(m3/s)
     */
    public void setAllowFlow(String allowFlow) {
        this.allowFlow = allowFlow;
    }

    /**
     * 获取：许可最大流量(m3/s)
     */
    public String getAllowFlow() {
        return allowFlow;
    }

    /**
     * 设置：许可总取水量(万m3)
     */
    public void setAllowSum(String allowSum) {
        this.allowSum = allowSum;
    }

    /**
     * 获取：许可总取水量(万m3)
     */
    public String getAllowSum() {
        return allowSum;
    }

    /**
     * 设置：累计取水量(万m3)
     */
    public void setSum(String sum) {
        this.sum = sum;
    }

    /**
     * 获取：累计取水量(万m3)
     */
    public String getSum() {
        return sum;
    }

    /**
     * 设置：备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置：附件
     */
    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    /**
     * 获取：附件
     */
    public String getAttachment() {
        return attachment;
    }

    /**
     * 设置：系统编码
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取：系统编码
     */
    public String getId() {
        return id;
    }

    /**
     * 设置：河口编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取：河口编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置：河口名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：河口名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：河口类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取：河口类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置：行政区划
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取：行政区划
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 设置：经度
     */
    public void setX(String x) {
        this.x = x;
    }

    /**
     * 获取：经度
     */
    public String getX() {
        return x;
    }

    /**
     * 设置：纬度
     */
    public void setY(String y) {
        this.y = y;
    }

    /**
     * 获取：纬度
     */
    public String getY() {
        return y;
    }

    /**
     * 设置：地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取：地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置：河湖渠库（段）类型
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * 获取：河湖渠库（段）类型
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * 设置：河湖渠库（段）编号
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 获取：河湖渠库（段）编号
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * 设置：负责人
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * 获取：负责人
     */
    public String getOwner() {
        return owner;
    }

    /**
     * 设置：负责人电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取：负责人电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置：工程建设情况
     */
    public void setStationBuild(String stationBuild) {
        this.stationBuild = stationBuild;
    }

    /**
     * 获取：工程建设情况
     */
    public String getStationBuild() {
        return stationBuild;
    }

    /**
     * 设置：运行状况
     */
    public void setStationSituation(String stationSituation) {
        this.stationSituation = stationSituation;
    }

    /**
     * 获取：运行状况
     */
    public String getStationSituation() {
        return stationSituation;
    }

    /**
     * 设置：取水方式
     */
    public void setGetway(String getway) {
        this.getway = getway;
    }

    /**
     * 获取：取水方式
     */
    public String getGetway() {
        return getway;
    }

    /**
     * 设置：开工时间
     */
    public void setStationStarttime(Date stationStarttime) {
        this.stationStarttime = stationStarttime;
    }

    /**
     * 获取：开工时间
     */
    public Date getStationStarttime() {
        return stationStarttime;
    }

    /**
     * 设置：建成时间
     */
    public void setStationBuildttime(Date stationBuildttime) {
        this.stationBuildttime = stationBuildttime;
    }

    /**
     * 获取：建成时间
     */
    public Date getStationBuildttime() {
        return stationBuildttime;
    }

    /**
     * 设置：管理单位
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * 获取：管理单位
     */
    public String getManager() {
        return manager;
    }
}
