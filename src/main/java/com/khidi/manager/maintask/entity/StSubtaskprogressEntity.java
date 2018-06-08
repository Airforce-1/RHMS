package com.khidi.manager.maintask.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-03 10:29:04
 */
public class StSubtaskprogressEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
    @ApiModelProperty(value = "编号",dataType="String",required = true,hidden = false)
	private String id;
	//子任务编号
    @ApiModelProperty(value = "子任务编号",dataType="String",required = true,hidden = false)
	private String subtaskid;
	//河湖名称(只读)
    @ApiModelProperty(value = "河湖名称(只读)",dataType="String",required = true,hidden = false)
	private String lakeid;
	//河湖归属(只读)
	@ApiModelProperty(value = "河湖归属(只读)",dataType="String",required = true,hidden = false)
	private String lakebelongto;
	//措施名称
    @ApiModelProperty(value = "措施名称",dataType="String",required = true,hidden = false)
	private String measures;
	//所在河段位置
    @ApiModelProperty(value = "所在河段位置",dataType="String",required = true,hidden = false)
	private String riverunit;
	//主要措施内容
    @ApiModelProperty(value = "主要措施内容",dataType="String",required = true,hidden = false)
	private String mainmeasurescontent;
	//牵头部门
    @ApiModelProperty(value = "牵头部门",dataType="String",required = true,hidden = false)
	private String qtdept;
	//配合部门
    @ApiModelProperty(value = "配合部门",dataType="String",required = true,hidden = false)
	private String phdept;
	//开始时间
    @ApiModelProperty(value = "开始时间",dataType="String",required = true,hidden = false)
	private String stime;
	//结束时间
    @ApiModelProperty(value = "结束时间",dataType="String",required = true,hidden = false)
	private String etime;
	//重要环节说明
    @ApiModelProperty(value = "重要环节说明",dataType="String",required = true,hidden = false)
	private String importlinksmemo;
	//预期效果
    @ApiModelProperty(value = "预期效果",dataType="String",required = true,hidden = false)
	private String desiredeffect;
	//备注
    @ApiModelProperty(value = "备注",dataType="String",required = true,hidden = false)
	private String memo;
	//进度
	@ApiModelProperty(value = "进度",dataType="Double",required = true,hidden = false)
	private Double progress;
	//任务类型
    @ApiModelProperty(value = "任务类型",dataType="String",required = true,hidden = false)
	private String taskglobaltype;

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
	 * 设置：子任务编号
	 */
	public void setSubtaskid(String subtaskid) {
		this.subtaskid = subtaskid;
	}
	/**
	 * 获取：子任务编号
	 */
	public String getSubtaskid() {
		return subtaskid;
	}
	/**
	 * 设置：河湖名称(只读)
	 */
	public void setLakeid(String lakeid) {
		this.lakeid = lakeid;
	}
	/**
	 * 获取：河湖名称(只读)
	 */
	public String getLakeid() {
		return lakeid;
	}
	/**
	 * 设置：河湖归属(只读)
	 */
	public void setLakebelongto(String lakebelongto) {
		this.lakebelongto = lakebelongto;
	}
	/**
	 * 获取：河湖归属(只读)
	 */
	public String getLakebelongto() {
		return lakebelongto;
	}
	/**
	 * 设置：措施名称
	 */
	public void setMeasures(String measures) {
		this.measures = measures;
	}
	/**
	 * 获取：措施名称
	 */
	public String getMeasures() {
		return measures;
	}
	/**
	 * 设置：所在河段位置
	 */
	public void setRiverunit(String riverunit) {
		this.riverunit = riverunit;
	}
	/**
	 * 获取：所在河段位置
	 */
	public String getRiverunit() {
		return riverunit;
	}
	/**
	 * 设置：主要措施内容
	 */
	public void setMainmeasurescontent(String mainmeasurescontent) {
		this.mainmeasurescontent = mainmeasurescontent;
	}
	/**
	 * 获取：主要措施内容
	 */
	public String getMainmeasurescontent() {
		return mainmeasurescontent;
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
	 * 设置：配合部门
	 */
	public void setPhdept(String phdept) {
		this.phdept = phdept;
	}
	/**
	 * 获取：配合部门
	 */
	public String getPhdept() {
		return phdept;
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
	 * 设置：结束时间
	 */
	public void setEtime(String etime) {
		this.etime = etime;
	}
	/**
	 * 获取：结束时间
	 */
	public String getEtime() {
		return etime;
	}
	/**
	 * 设置：重要环节说明
	 */
	public void setImportlinksmemo(String importlinksmemo) {
		this.importlinksmemo = importlinksmemo;
	}
	/**
	 * 获取：重要环节说明
	 */
	public String getImportlinksmemo() {
		return importlinksmemo;
	}
	/**
	 * 设置：预期效果
	 */
	public void setDesiredeffect(String desiredeffect) {
		this.desiredeffect = desiredeffect;
	}
	/**
	 * 获取：预期效果
	 */
	public String getDesiredeffect() {
		return desiredeffect;
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
	/**
	 * 设置：进度
	 */
	public void setProgress(Double progress) {
		this.progress = progress;
	}
	/**
	 * 获取：进度
	 */
	public Double getProgress() {
		return progress;
	}
	public String getMemo() {
		return memo;
	}
	/**
	 * 设置：任务类型
	 */
	public void setTaskglobaltype(String taskglobaltype) {
		this.taskglobaltype = taskglobaltype;
	}
	/**
	 * 获取：任务类型
	 */
	public String getTaskglobaltype() {
		return taskglobaltype;
	}
}
