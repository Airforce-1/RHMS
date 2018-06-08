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
 * @date 2017-12-04 18:19:33
 */
public class ResourcePublicitycardEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//公示牌编码
    @ApiModelProperty(value = "公示牌编码",dataType="String",required = true,hidden = false)
	private String code;
	//公示牌名称
    @ApiModelProperty(value = "公示牌名称",dataType="String",required = true,hidden = false)
	private String name;
	//河湖渠库（段）类型
    @ApiModelProperty(value = "河湖渠库（段）类型",dataType="String",required = true,hidden = false)
	private String resourcetype;
	//河湖渠库（段）编码
    @ApiModelProperty(value = "河湖渠库（段）编码",dataType="String",required = true,hidden = false)
	private String resourceid;
	//经度
    @ApiModelProperty(value = "经度",dataType="String",required = true,hidden = false)
	private String x;
	//纬度
    @ApiModelProperty(value = "纬度",dataType="String",required = true,hidden = false)
	private String y;
	//行政区划编码
    @ApiModelProperty(value = "行政区划编码",dataType="String",required = true,hidden = false)
	private String areaId;
	//位置
    @ApiModelProperty(value = "位置",dataType="String",required = true,hidden = false)
	private String address;
	//附件地址
    @ApiModelProperty(value = "附件地址",dataType="String",required = true,hidden = false)
	private String fileaddress;
	//河湖渠库（段）类型名称
	@ApiModelProperty(value = "河湖渠库（段）类型名称",dataType="String",required = true,hidden = false)
	private String resourcetypeName;
	//河湖渠库（段）名称
	@ApiModelProperty(value = "河湖渠库（段）名称",dataType="String",required = true,hidden = false)
	private String resourceName;

	//附件属性
	@ApiModelProperty(value = "附件属性",dataType="String",required = true,hidden = false)
	private List<FileUploadEntity> fileList;

	//行政区划名称
	@ApiModelProperty(value = "行政区划名称",dataType="String",required = true,hidden = false)
	private String areaName;
	//备注
	@ApiModelProperty(value = "备注",dataType="String",required = true,hidden = false)
	private String remark;

	public List<FileUploadEntity> getFileList() {
		return fileList;
	}

	public void setFileList(List<FileUploadEntity> fileList) {
		this.fileList = fileList;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
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
	 * 获取：河湖渠库（段）类型名称
	 */
	public String getResourcetypeName() {
		return resourcetypeName;
	}
	/**
	 * 设置：河湖渠库（段）类型名称
	 */
	public void setResourcetypeName(String resourcetypeName) {
		this.resourcetypeName = resourcetypeName;
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
	 * 设置：公示牌编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：公示牌编码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：公示牌名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：公示牌名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：河湖渠库（段）类型
	 */
	public void setResourcetype(String resourcetype) {
		this.resourcetype = resourcetype;
	}
	/**
	 * 获取：河湖渠库（段）类型
	 */
	public String getResourcetype() {
		return resourcetype;
	}
	/**
	 * 设置：河湖渠库（段）编码
	 */
	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}
	/**
	 * 获取：河湖渠库（段）编码
	 */
	public String getResourceid() {
		return resourceid;
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
	 * 设置：行政区划编码
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	/**
	 * 获取：行政区划编码
	 */
	public String getAreaId() {
		return areaId;
	}
	/**
	 * 设置：位置
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：位置
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：附件地址
	 */
	public void setFileaddress(String fileaddress) {
		this.fileaddress = fileaddress;
	}
	/**
	 * 获取：附件地址
	 */
	public String getFileaddress() {
		return fileaddress;
	}
}
