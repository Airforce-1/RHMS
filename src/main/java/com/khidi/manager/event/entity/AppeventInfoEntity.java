package com.khidi.manager.event.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-29 15:22:47
 */
public class AppeventInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//删除标识
    @ApiModelProperty(value = "删除标识",dataType="String",required = true,hidden = false)
	private String delind;
	//事件编号
    @ApiModelProperty(value = "事件编号",dataType="String",required = true,hidden = false)
	private String id;
	//事项标识(可看成事项编号)
    @ApiModelProperty(value = "事项标识(可看成事项编号)",dataType="String",required = true,hidden = false)
	private String flag;
	//事项标题
    @ApiModelProperty(value = "事项标题",dataType="String",required = true,hidden = false)
	private String title;
	//事项状态
    @ApiModelProperty(value = "事项状态",dataType="String",required = true,hidden = false)
	private String state;
	//事项发起人
    @ApiModelProperty(value = "事项发起人",dataType="String",required = true,hidden = false)
	private String fqr;
	//事项创建时间
    @ApiModelProperty(value = "事项创建时间",dataType="Date",required = true,hidden = false)
	private Date createtime;
	//事项分类
    @ApiModelProperty(value = "事项分类",dataType="String",required = true,hidden = false)
	private String etype;
	//事件内容
    @ApiModelProperty(value = "事件内容",dataType="String",required = true,hidden = false)
	private String econtent;
	//事件的位置(纬度)
    @ApiModelProperty(value = "事件的位置(纬度)",dataType="Double",required = true,hidden = false)
	private Double elat;
	//事件的位置(高度)
    @ApiModelProperty(value = "事件的位置(高度)",dataType="Double",required = true,hidden = false)
	private Double eheight;
	//事件的位置(经度)
    @ApiModelProperty(value = "事件的位置(经度)",dataType="Double",required = true,hidden = false)
	private Double elon;
	//事件的处理过程
    @ApiModelProperty(value = "事件的处理过程",dataType="String",required = true,hidden = false)
	private String dwprocedure;
	//处理人
    @ApiModelProperty(value = "处理人",dataType="String",required = true,hidden = false)
	private String dwuserid;
	//事件发生的河段
    @ApiModelProperty(value = "事件发生的河段",dataType="String",required = true,hidden = false)
	private String hd;
    //事件流转类型
    @ApiModelProperty(value = "事件流转类型",dataType="String",required = true,hidden = false)
	private String esteptype;
    //附件
    private List<AppeventAttinfoEntity> attachments;

	public List<AppeventAttinfoEntity> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<AppeventAttinfoEntity> attachments) {
		this.attachments = attachments;
	}
	/**
	 * 设置：删除标识
	 */
	public void setDelind(String delind) {
		this.delind = delind;
	}
	/**
	 * 获取：删除标识
	 */
	public String getDelind() {
		return delind;
	}
	/**
	 * 设置：事件编号
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：事件编号
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：事项标识(可看成事项编号)
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * 获取：事项标识(可看成事项编号)
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 设置：事项标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：事项标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：事项状态
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 获取：事项状态
	 */
	public String getState() {
		return state;
	}
	/**
	 * 设置：事项发起人
	 */
	public void setFqr(String fqr) {
		this.fqr = fqr;
	}
	/**
	 * 获取：事项发起人
	 */
	public String getFqr() {
		return fqr;
	}
	/**
	 * 设置：事项创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：事项创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：事项分类
	 */
	public void setEtype(String etype) {
		this.etype = etype;
	}
	/**
	 * 获取：事项分类
	 */
	public String getEtype() {
		return etype;
	}
	/**
	 * 设置：事件内容
	 */
	public void setEcontent(String econtent) {
		this.econtent = econtent;
	}
	/**
	 * 获取：事件内容
	 */
	public String getEcontent() {
		return econtent;
	}
	/**
	 * 设置：事件的位置(纬度)
	 */
	public void setElat(Double elat) {
		this.elat = elat;
	}
	/**
	 * 获取：事件的位置(纬度)
	 */
	public Double getElat() {
		return elat;
	}
	/**
	 * 设置：事件的位置(高度)
	 */
	public void setEheight(Double eheight) {
		this.eheight = eheight;
	}
	/**
	 * 获取：事件的位置(高度)
	 */
	public Double getEheight() {
		return eheight;
	}
	/**
	 * 设置：事件的位置(经度)
	 */
	public void setElon(Double elon) {
		this.elon = elon;
	}
	/**
	 * 获取：事件的位置(经度)
	 */
	public Double getElon() {
		return elon;
	}
	/**
	 * 设置：事件的处理过程
	 */
	public void setDwprocedure(String dwprocedure) {
		this.dwprocedure = dwprocedure;
	}
	/**
	 * 获取：事件的处理过程
	 */
	public String getDwprocedure() {
		return dwprocedure;
	}
	/**
	 * 设置：处理人
	 */
	public void setDwuserid(String dwuserid) {
		this.dwuserid = dwuserid;
	}
	/**
	 * 获取：处理人
	 */
	public String getDwuserid() {
		return dwuserid;
	}
	/**
	 * 设置：事件发生的河段
	 */
	public void setHd(String hd) {
		this.hd = hd;
	}
	/**
	 * 获取：事件发生的河段
	 */
	public String getHd() {
		return hd;
	}
	public String getEsteptype() {
		return esteptype;
	}
	public void setEsteptype(String esteptype) {
		this.esteptype = esteptype;
	}
	
}
