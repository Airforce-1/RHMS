package com.khidi.manager.socialparticipation.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.khidi.manager.sys.entity.FileUploadEntity;

/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-09 16:00:10 Jw 2017 12 13
 */
public class AppnewsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//排序号
	@ApiModelProperty(value = "排序号", dataType = "Integer", required = true, hidden = false)
	private int sortNum;
	// 系统编码
	@ApiModelProperty(value = "系统编码", dataType = "String", required = true, hidden = false)
	private String id;
	// 标题
	@ApiModelProperty(value = "标题", dataType = "String", required = true, hidden = false)
	private String newsTitle;
	// 来源单位
	@ApiModelProperty(value = "来源单位", dataType = "String", required = true, hidden = false)
	private String deptName;
	// 作者
	@ApiModelProperty(value = "作者", dataType = "String", required = true, hidden = false)
	private String newsAuthor;
	// 行政区划编码
	@ApiModelProperty(value = "行政区划编码", dataType = "String", required = true, hidden = false)
	private String areaId;
	// 所属栏目
	@ApiModelProperty(value = "所属栏目", dataType = "String", required = true, hidden = false)
	private String menuId;
	// 是否置顶
	@ApiModelProperty(value = "是否置顶", dataType = "String", required = true, hidden = false)
	private String isTop;
	// 失效时间
	@ApiModelProperty(value = "失效时间", dataType = "Date", required = true, hidden = false)
	private Date destroyTime;
	// 信息内容
	@ApiModelProperty(value = "信息内容", dataType = "unknowType", required = true, hidden = false)
	private Object newsContent;
	// 生成时间
	@ApiModelProperty(value = "生成时间", dataType = "Date", required = true, hidden = false)
	private Date createTime;

	// 是否轮播
	@ApiModelProperty(value = "是否轮播", dataType = "String", required = true, hidden = false)
	private String isPlay;

	// 新闻状态
	@ApiModelProperty(value = "新闻状态", dataType = "String", required = true, hidden = false)
	private String newState;

	// 区域名称
	@ApiModelProperty(value = "区域名称", dataType = "String", required = true, hidden = false)
	private String areaName;

	// 所属菜单
	@ApiModelProperty(value = "所属菜单", dataType = "String", required = true, hidden = false)
	private List<AppmenuEntity> menus;

	// 最后更新时间
	@ApiModelProperty(value = "最后更新时间", dataType = "Date", required = true, hidden = false)
	private Date lastUpdateTime;
	
	// 新闻缩略图
	@ApiModelProperty(value = "新闻缩略图", dataType = "AppnewsviewimgEntity", required = false, hidden = false)
	private List<AppnewsviewimgEntity> fileList;
	
	// (新增  更新用fileaddress)
	@ApiModelProperty(value = "新增  更新用fileaddress", dataType = "AppnewsviewimgEntity", required = false, hidden = false)
	private String fileaddress;

	public String getFileaddress() {
		return fileaddress;
	}

	public void setFileaddress(String fileaddress) {
		this.fileaddress = fileaddress;
	}

	public List<AppnewsviewimgEntity> getFileList() {
		return fileList;
	}

	public void setFileList(List<AppnewsviewimgEntity> fileList) {
		this.fileList = fileList;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public List<AppmenuEntity> getMenus() {
		return menus;
	}

	public void setMenus(List<AppmenuEntity> menus) {
		this.menus = menus;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getNewsAuthor() {
		return newsAuthor;
	}

	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getIsTop() {
		return isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	public Date getDestroyTime() {
		return destroyTime;
	}

	public void setDestroyTime(Date destroyTime) {
		this.destroyTime = destroyTime;
	}

	public Object getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(Object newsContent) {
		this.newsContent = newsContent;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getIsPlay() {
		return isPlay;
	}

	public void setIsPlay(String isPlay) {
		this.isPlay = isPlay;
	}

	public String getNewState() {
		return newState;
	}

	public void setNewState(String newState) {
		this.newState = newState;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getSortNum() {
		return sortNum;
	}

	public void setSortNum(int sortNum) {
		this.sortNum = sortNum;
	}
	

}
