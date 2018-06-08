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
 * @date 2017-11-23 10:22:50
 */
public class ResourceStationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	// 系统编码
	@ApiModelProperty(value = "系统编码", dataType = "String", required = true, hidden = false)
	private String id;
	// 监测站编码
	@ApiModelProperty(value = "监测站编码", dataType = "String", required = true, hidden = false)
	private String code;
	// 行政区划
	@ApiModelProperty(value = "行政区划编码", dataType = "String", required = true, hidden = false)
	private String areaId;
	// 行政区划名称
	@ApiModelProperty(value = "行政区划名称", dataType = "String", required = true, hidden = false)
	private String areaName;
	// 监测站类型
	@ApiModelProperty(value = "监测站类型", dataType = "String", required = true, hidden = false)
	private String stationType;
	// 监测站名称
	@ApiModelProperty(value = "监测站名称", dataType = "String", required = true, hidden = false)
	private String name;
	// 地址
	@ApiModelProperty(value = "地址", dataType = "String", required = true, hidden = false)
	private String address;
	// 所属河渠湖库（段）类型
	@ApiModelProperty(value = "所属河渠湖库（段）类型", dataType = "String", required = true, hidden = false)
	private String resourceType;
	// 所属河渠湖库（段）类型名称
	@ApiModelProperty(value = "所属河渠湖库（段）类型名称", dataType = "String", required = true, hidden = false)
	private String resourceTypeName;
	// 河渠湖库（段）编码
	@ApiModelProperty(value = "河渠湖库（段）编码", dataType = "String", required = true, hidden = false)
	private String resourceId;
	// 河渠湖库（段）名称
	@ApiModelProperty(value = "河渠湖库（段）名称", dataType = "String", required = true, hidden = false)
	private String resourceName;
	// 经度
	@ApiModelProperty(value = "经度", dataType = "String", required = true, hidden = false)
	private String stationX;
	// 纬度
	@ApiModelProperty(value = "纬度", dataType = "String", required = true, hidden = false)
	private String stationY;
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
	// 开工时间
	@ApiModelProperty(value = "开工时间", dataType = "Date", required = true, hidden = false)
	private Date stationStarttime;
	// 建成时间
	@ApiModelProperty(value = "建成时间", dataType = "Date", required = true, hidden = false)
	private Date stationBuildtime;
	// 备注
	@ApiModelProperty(value = "备注", dataType = "String", required = true, hidden = false)
	private String remark;
	// 图片
	@ApiModelProperty(value = "图片", dataType = "String", required = true, hidden = false)
	private String attachment;
	// 运行状况名称
	@ApiModelProperty(value = "运行状况名称", dataType = "String", required = true, hidden = false)
	private String stationSituationName;
	// 工程建设情况mc==名称
	@ApiModelProperty(value = "工程建设情况名称", dataType = "String", required = true, hidden = false)
	private String stationBuildName;
	// 上游测站编码
	@ApiModelProperty(value = "上游测站", dataType = "String", required = true, hidden = false)
	private String uprId;
	//数据来源单位
	@ApiModelProperty(value = "数据来源单位", dataType = "String", required = true, hidden = false)
	private String dataOrgin;
	//目标水质
	@ApiModelProperty(value = "目标水质", dataType = "String", required = true, hidden = false)
	private String aimLevel;

	public String getAimLevel() {
		return aimLevel;
	}

	public void setAimLevel(String aimLevel) {
		this.aimLevel = aimLevel;
	}

	public String getDataOrgin() {
		return dataOrgin;
	}

	public void setDataOrgin(String dataOrgin) {
		this.dataOrgin = dataOrgin;
	}

	//附件属性
	@ApiModelProperty(value = "附件属性",dataType="String",required = true,hidden = false)
	private List<FileUploadEntity> fileList;

	public List<FileUploadEntity> getFileList() {
		return fileList;
	}

	public void setFileList(List<FileUploadEntity> fileList) {
		this.fileList = fileList;
	}

	// 下游测站
	private List<ResourceStationEntity> downStation;
		
	public List<ResourceStationEntity> getDownStation() {
		return downStation;
	}

	public void setDownStation(List<ResourceStationEntity> downStation) {
		this.downStation = downStation;
	}

	public String getUprId() {
		return uprId;
	}

	public void setUprId(String uprId) {
		this.uprId = uprId;
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
	 * 获取：河渠湖库（段）名称
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * 设置：河渠湖库（段）名称
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	/**
	 * 获取：所属河渠湖库（段）类型名称
	 */
	public String getResourceTypeName() {
		return resourceTypeName;
	}

	/**
	 * 设置：所属河渠湖库（段）类型名称
	 */
	public void setResourceTypeName(String resourceTypeName) {
		this.resourceTypeName = resourceTypeName;
	}

	/**
	 * 获取：行政区划名称
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * 设置：行政区划名称
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
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
	 * 设置：监测站编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取：监测站编码
	 */
	public String getCode() {
		return code;
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
	 * 设置：监测站类型
	 */
	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	/**
	 * 获取：监测站类型
	 */
	public String getStationType() {
		return stationType;
	}

	/**
	 * 设置：监测站名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：监测站名称
	 */
	public String getName() {
		return name;
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
	 * 设置：所属河渠湖库（段）类型
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	/**
	 * 获取：所属河渠湖库（段）类型
	 */
	public String getResourceType() {
		return resourceType;
	}

	/**
	 * 设置：河渠湖库（段）编码
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * 获取：河渠湖库（段）编码
	 */
	public String getResourceId() {
		return resourceId;
	}

	/**
	 * 设置：经度
	 */
	public void setStationX(String stationX) {
		this.stationX = stationX;
	}

	/**
	 * 获取：经度
	 */
	public String getStationX() {
		return stationX;
	}

	/**
	 * 设置：纬度
	 */
	public void setStationY(String stationY) {
		this.stationY = stationY;
	}

	/**
	 * 获取：纬度
	 */
	public String getStationY() {
		return stationY;
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
	public void setStationBuildtime(Date stationBuildtime) {
		this.stationBuildtime = stationBuildtime;
	}

	/**
	 * 获取：建成时间
	 */
	public Date getStationBuildtime() {
		return stationBuildtime;
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
	 * 设置：图片
	 */
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	/**
	 * 获取：图片
	 */
	public String getAttachment() {
		return attachment;
	}
}
