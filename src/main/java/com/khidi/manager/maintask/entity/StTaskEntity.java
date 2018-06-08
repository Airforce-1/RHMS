package com.khidi.manager.maintask.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-03 10:29:04
 */
public class StTaskEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//完成期限
    @ApiModelProperty(value = "完成期限",dataType="String",required = true,hidden = false)
	private String completeperiod;
	//河湖类型
    @ApiModelProperty(value = "河湖类型",dataType="String",required = true,hidden = false)
	private String laketype;
	//河湖编号
    @ApiModelProperty(value = "河湖编号",dataType="String",required = true,hidden = false)
	private String lakeid;
	//河长
    @ApiModelProperty(value = "河长",dataType="String",required = true,hidden = false)
	private String hz;
	//行政区划
    @ApiModelProperty(value = "行政区划",dataType="String",required = true,hidden = false)
	private String areacode;
	//任务类别
    @ApiModelProperty(value = "任务类别",dataType="String",required = true,hidden = false)
	private String tasktype;
	//任务来源
    @ApiModelProperty(value = "任务来源",dataType="String",required = true,hidden = false)
	private String tasksource;
	//指标类型
    @ApiModelProperty(value = "指标类型",dataType="String",required = true,hidden = false)
	private String indicatortype;
	//详细地址
    @ApiModelProperty(value = "详细地址",dataType="String",required = true,hidden = false)
	private String detailaddress;
	//备注
    @ApiModelProperty(value = "备注",dataType="String",required = true,hidden = false)
	private String memo;
	//任务类型
    @ApiModelProperty(value = "任务类型",dataType="String",required = true,hidden = false)
	private String taskglobaltype;
	//编号
    @ApiModelProperty(value = "编号",dataType="String",required = true,hidden = false)
	private String id;
	//任务编码
    @ApiModelProperty(value = "任务编码",dataType="String",required = true,hidden = false)
	private String taskcode;
	//任务名称
    @ApiModelProperty(value = "任务名称",dataType="String",required = true,hidden = false)
	private String taskname;
	//主要任务
    @ApiModelProperty(value = "主要任务",dataType="String",required = true,hidden = false)
	private String maintask;
	//牵头部门
    @ApiModelProperty(value = "牵头部门",dataType="String",required = true,hidden = false)
	private String qtdept;
	//下达部门
    @ApiModelProperty(value = "下达部门",dataType="String",required = true,hidden = false)
	private String xddept;
	//开始时间
    @ApiModelProperty(value = "开始时间",dataType="String",required = true,hidden = false)
	private String stime;
	//进度值
	@ApiModelProperty(value = "进度值",dataType="Double",required = true,hidden = false)
	private Double progress;

	//行政区划名称
	@ApiModelProperty(value = "行政区划名称",dataType="String",required = true,hidden = false)
	private String areaName;
	//牵头部门名称
	@ApiModelProperty(value = "牵头部门名称",dataType="String",required = true,hidden = false)
	private String qtDeptName;
	//下达部门名称
	@ApiModelProperty(value = "下达部门名称",dataType="String",required = true,hidden = false)
	private String xdDeptName;
	//河湖类型名称
	@ApiModelProperty(value = "河湖类型名称",dataType="String",required = true,hidden = false)
	private String laketypeName;
	// 河湖名称
	@ApiModelProperty(value = "河湖名称",dataType="String",required = true,hidden = false)
	private String lakeName;
	// 河长名称
	@ApiModelProperty(value = "河长名称",dataType="String",required = true,hidden = false)
	private String hzName;


	// 任务明细
	private List<StTaskdetailEntity> taskDetails;
	public List<StTaskdetailEntity> getTaskDetails() {
		return taskDetails;
	}
	public void setTaskDetails(List<StTaskdetailEntity> taskDetails) {
		this.taskDetails = taskDetails;
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

	public String getHzName() {
		return hzName;
	}

	public void setHzName(String hzName) {
		this.hzName = hzName;
	}

	public String getLakeName() {
		return lakeName;
	}

	public void setLakeName(String lakeName) {
		this.lakeName = lakeName;
	}

	public String getLaketypeName() {
		return laketypeName;
	}

	public void setLaketypeName(String laketypeName) {
		this.laketypeName = laketypeName;
	}

	public String getQtDeptName() {
		return qtDeptName;
	}

	public void setQtDeptName(String qtDeptName) {
		this.qtDeptName = qtDeptName;
	}

	public String getXdDeptName() {
		return xdDeptName;
	}

	public void setXdDeptName(String xdDeptName) {
		this.xdDeptName = xdDeptName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 设置：完成期限
	 */
	public void setCompleteperiod(String completeperiod) {
		this.completeperiod = completeperiod;
	}
	/**
	 * 获取：完成期限
	 */
	public String getCompleteperiod() {
		return completeperiod;
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
	 * 设置：河长
	 */
	public void setHz(String hz) {
		this.hz = hz;
	}
	/**
	 * 获取：河长
	 */
	public String getHz() {
		return hz;
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
	 * 设置：任务类别
	 */
	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}
	/**
	 * 获取：任务类别
	 */
	public String getTasktype() {
		return tasktype;
	}
	/**
	 * 设置：任务来源
	 */
	public void setTasksource(String tasksource) {
		this.tasksource = tasksource;
	}
	/**
	 * 获取：任务来源
	 */
	public String getTasksource() {
		return tasksource;
	}
	/**
	 * 设置：指标类型
	 */
	public void setIndicatortype(String indicatortype) {
		this.indicatortype = indicatortype;
	}
	/**
	 * 获取：指标类型
	 */
	public String getIndicatortype() {
		return indicatortype;
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
	 * 设置：任务编码
	 */
	public void setTaskcode(String taskcode) {
		this.taskcode = taskcode;
	}
	/**
	 * 获取：任务编码
	 */
	public String getTaskcode() {
		return taskcode;
	}
	/**
	 * 设置：任务名称
	 */
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	/**
	 * 获取：任务名称
	 */
	public String getTaskname() {
		return taskname;
	}
	/**
	 * 设置：主要任务
	 */
	public void setMaintask(String maintask) {
		this.maintask = maintask;
	}
	/**
	 * 获取：主要任务
	 */
	public String getMaintask() {
		return maintask;
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
}
