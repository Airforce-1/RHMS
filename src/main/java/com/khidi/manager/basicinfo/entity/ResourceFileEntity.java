package com.khidi.manager.basicinfo.entity;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-11-24 15:59:55
 */
public class ResourceFileEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	// 系统编码
	@ApiModelProperty(value = "系统编码", dataType = "String", required = true, hidden = false)
	private String id;
	// 行政区域编码
	@NotBlank(message = "行政区划不能为空")
	@ApiModelProperty(value = "行政区域编码", dataType = "String", required = true, hidden = false)
	private String areaId;

	// 行政区域名称
	@ApiModelProperty(value = "行政区域名称", dataType = "String", required = true, hidden = false)
	private String areaName;

	// 文件名称
	@NotBlank(message = "文件名称不能为空")
	@ApiModelProperty(value = "文件名称", dataType = "String", required = true, hidden = false)
	private String name;
	// 文件路径
	@ApiModelProperty(value = "文件路径", dataType = "String", required = true, hidden = false)
	private String filePath;
	// 类型(河湖)
	@ApiModelProperty(value = "类型(河湖)", dataType = "String", required = true, hidden = false)
	private String riverType;
	// 名称(河湖)
	@ApiModelProperty(value = "名称(河湖)", dataType = "String", required = true, hidden = false)
	private String riverName;

	// 标题
	@NotBlank(message = "标题不能为空")
	@ApiModelProperty(value = "标题", dataType = "String", required = true, hidden = false)
	private String title;
	// 文件大小
	@ApiModelProperty(value = "文件大小", dataType = "String", required = true, hidden = false)
	private String fileSize;
	// 排序号
	@ApiModelProperty(value = "排序号", dataType = "Double", required = true, hidden = false)
	private Double orderNum;
	// 备注
	@ApiModelProperty(value = "备注", dataType = "String", required = true, hidden = false)
	private String remark;
	// 文件类型
	@ApiModelProperty(value = "文件类型", dataType = "String", required = true, hidden = false)
	private String filetype;
	// 文件类型名称
	@ApiModelProperty(value = "文件类型名称", dataType = "String", required = true, hidden = false)
	private String filetypeName;
	// 类型(河湖)名称
	@ApiModelProperty(value = "类型(河湖)名称", dataType = "String", required = true, hidden = false)
	private String riverTypeName;

	/**
	 * 获取：文件类型名称
	 */
	public String getFiletypeName() {
		return filetypeName;
	}

	/**
	 * 设置：文件类型名称
	 */
	public void setFiletypeName(String filetypeName) {
		this.filetypeName = filetypeName;
	}

	/**
	 * 获取：类型(河湖)名称
	 */
	public String getRiverTypeName() {
		return riverTypeName;
	}

	/**
	 * 设置：类型(河湖)名称
	 */
	public void setRiverTypeName(String riverTypeName) {
		this.riverTypeName = riverTypeName;
	}

	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * 设置：行政区域
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	/**
	 * 获取：行政区域
	 */
	public String getAreaId() {
		return areaId;
	}

	/**
	 * 设置：文件名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：文件名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：文件路径
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * 获取：文件路径
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * 设置：类型(河湖)
	 */
	public void setRiverType(String riverType) {
		this.riverType = riverType;
	}

	/**
	 * 获取：类型(河湖)
	 */
	public String getRiverType() {
		return riverType;
	}

	/**
	 * 设置：名称(河湖)
	 */
	public void setRiverName(String riverName) {
		this.riverName = riverName;
	}

	/**
	 * 获取：名称(河湖)
	 */
	public String getRiverName() {
		return riverName;
	}

	/**
	 * 设置：文件大小
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * 获取：文件大小
	 */
	public String getFileSize() {
		return fileSize;
	}

	/**
	 * 设置：排序号
	 */
	public void setOrderNum(Double orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * 获取：排序号
	 */
	public Double getOrderNum() {
		return orderNum;
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
	 * 设置：文件类型
	 */
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	/**
	 * 获取：文件类型
	 */
	public String getFiletype() {
		return filetype;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}
