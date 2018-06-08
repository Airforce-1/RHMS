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
 * @date 2017-11-24 08:27:48
 */
public class ResourceWaterabilityEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//保护区编码
    @ApiModelProperty(value = "保护区编码",dataType="String",required = true,hidden = false)
	private String code;
	//水功能区类型
    @ApiModelProperty(value = "水功能区类型",dataType="String",required = true,hidden = false)
	private String type;
	//行政区划编码
    @ApiModelProperty(value = "行政区划编码",dataType="String",required = true,hidden = false)
	private String areaId;
	//行政区划名称
	@ApiModelProperty(value = "行政区划名称",dataType="String",required = true,hidden = false)
	private String areaName;
	//管理单位
    @ApiModelProperty(value = "管理单位",dataType="String",required = true,hidden = false)
	private String manager;
	//保护区名称
    @ApiModelProperty(value = "保护区名称",dataType="String",required = true,hidden = false)
	private String name;
	//区域面积（km2）
    @ApiModelProperty(value = "区域面积（km2）",dataType="String",required = true,hidden = false)
	private String area;
	//联系人
    @ApiModelProperty(value = "联系人",dataType="String",required = true,hidden = false)
	private String owner;
	//联系电话
    @ApiModelProperty(value = "联系电话",dataType="String",required = true,hidden = false)
	private String phone;
	//左下角经度
    @ApiModelProperty(value = "左下角经度",dataType="String",required = true,hidden = false)
	private String leftX;
	//左下角纬度
    @ApiModelProperty(value = "左下角纬度",dataType="String",required = true,hidden = false)
	private String leftY;
	//右上角经度
    @ApiModelProperty(value = "右上角经度",dataType="String",required = true,hidden = false)
	private String rightX;
	//右上角纬度
    @ApiModelProperty(value = "右上角纬度",dataType="String",required = true,hidden = false)
	private String rightY;
	//简介
    @ApiModelProperty(value = "简介",dataType="String",required = true,hidden = false)
	private String introduce;
	//附件
    @ApiModelProperty(value = "附件",dataType="String",required = true,hidden = false)
	private String attachment;

	//附件属性
	@ApiModelProperty(value = "附件属性",dataType="String",required = true,hidden = false)
	private List<FileUploadEntity> fileList;

	//坐标点集
	@ApiModelProperty(value = "坐标点集",dataType="String",required = true,hidden = false)
	private String pointSet;

	public String getPointSet() {
		return pointSet;
	}

	public void setPointSet(String pointSet) {
		this.pointSet = pointSet;
	}

	public List<FileUploadEntity> getFileList() {
		return fileList;
	}

	public void setFileList(List<FileUploadEntity> fileList) {
		this.fileList = fileList;
	}

	public String getAreaName() {
		return areaName;
	}

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
	 * 设置：保护区编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：保护区编码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：水功能区类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：水功能区类型
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
	/**
	 * 设置：保护区名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：保护区名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：区域面积（km2）
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：区域面积（km2）
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置：联系人
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * 获取：联系人
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：左下角经度
	 */
	public void setLeftX(String leftX) {
		this.leftX = leftX;
	}
	/**
	 * 获取：左下角经度
	 */
	public String getLeftX() {
		return leftX;
	}
	/**
	 * 设置：左下角纬度
	 */
	public void setLeftY(String leftY) {
		this.leftY = leftY;
	}
	/**
	 * 获取：左下角纬度
	 */
	public String getLeftY() {
		return leftY;
	}
	/**
	 * 设置：右上角经度
	 */
	public void setRightX(String rightX) {
		this.rightX = rightX;
	}
	/**
	 * 获取：右上角经度
	 */
	public String getRightX() {
		return rightX;
	}
	/**
	 * 设置：右上角纬度
	 */
	public void setRightY(String rightY) {
		this.rightY = rightY;
	}
	/**
	 * 获取：右上角纬度
	 */
	public String getRightY() {
		return rightY;
	}
	/**
	 * 设置：简介
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	/**
	 * 获取：简介
	 */
	public String getIntroduce() {
		return introduce;
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
}
