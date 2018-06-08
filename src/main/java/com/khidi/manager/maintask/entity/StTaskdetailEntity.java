package com.khidi.manager.maintask.entity;

import com.khidi.manager.sys.entity.FileUploadEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * ${comments}
 *
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-03 10:29:04
 */
public class StTaskdetailEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //子任务编号
    @ApiModelProperty(value = "子任务编号", dataType = "String", required = true, hidden = false)
    private String id;
    //任务指标项
    @ApiModelProperty(value = "任务指标项", dataType = "String", required = true, hidden = false)
    private String indicate;
    //指标值-现状指标值
    @ApiModelProperty(value = "指标值-现状指标值", dataType = "String", required = true, hidden = false)
    private String nowindicators;
    //指标值-预期指标值
    @ApiModelProperty(value = "指标值-预期指标值", dataType = "String", required = true, hidden = false)
    private String expectedindicators;
    //分阶段目标-第一年度目标
    @ApiModelProperty(value = "分阶段目标-第一年度目标", dataType = "String", required = true, hidden = false)
    private String phaseone;
    //分阶段目标-第二年度目标
    @ApiModelProperty(value = "分阶段目标-第二年度目标", dataType = "String", required = true, hidden = false)
    private String phasetwo;
    //分阶段目标-第三年度目标
    @ApiModelProperty(value = "分阶段目标-第三年度目标", dataType = "String", required = true, hidden = false)
    private String phasethree;
    //分阶段目标-第四年度目标
    @ApiModelProperty(value = "分阶段目标-第四年度目标", dataType = "String", required = true, hidden = false)
    private String phasefour;
    //分阶段目标-第五年度目标
    @ApiModelProperty(value = "分阶段目标-第五年度目标", dataType = "String", required = true, hidden = false)
    private String phasefive;
    //责任部门
    @ApiModelProperty(value = "责任部门", dataType = "String", required = true, hidden = false)
    private String respdept;
    //责任人
    @ApiModelProperty(value = "责任人", dataType = "String", required = true, hidden = false)
    private String respuser;
    //联系电话
    @ApiModelProperty(value = "联系电话", dataType = "String", required = true, hidden = false)
    private String tel;
    //备注
    @ApiModelProperty(value = "备注", dataType = "String", required = true, hidden = false)
    private String memo;
    //接受部门
    @ApiModelProperty(value = "接受部门", dataType = "String", required = true, hidden = false)
    private String acceptdept;
    //是否接受
    @ApiModelProperty(value = "是否接受", dataType = "Double", required = true, hidden = false)
    private Double isaccepted;
    //进度值
    @ApiModelProperty(value = "进度值", dataType = "Double", required = true, hidden = false)
    private Double progress;
    //任务编号
    @ApiModelProperty(value = "任务编号", dataType = "String", required = true, hidden = false)
    private String taskid;
    //解决方案附件编号
    @ApiModelProperty(value = "解决方案附件编号", dataType = "String", required = true, hidden = false)
    private String solattachid;
    //任务类型
    @ApiModelProperty(value = "任务类型", dataType = "String", required = true, hidden = false)
    private String taskglobaltype;
    //接受部门编号
    @ApiModelProperty(value = "接受部门编号", dataType = "String", required = true, hidden = false)
    private String acceptdeptid;
    //接受标识
    @ApiModelProperty(value = "接受标识", dataType = "String", required = true, hidden = false)
    private String acceptflag;
    //接受人
    @ApiModelProperty(value = "接受人", dataType = "String", required = true, hidden = false)
    private String acceptuserid;
    //接受时间
    @ApiModelProperty(value = "接受时间", dataType = "Date", required = true, hidden = false)
    private Date accepttime;
    //转发到部门
    @ApiModelProperty(value = "转发到部门", dataType = "String", required = true, hidden = false)
    private String todeptid;
    //转发者
    @ApiModelProperty(value = "转发者", dataType = "String", required = true, hidden = false)
    private String transmituserid;
    //转发时间
    @ApiModelProperty(value = "转发时间", dataType = "Date", required = true, hidden = false)
    private Date transmittime;
    //转发部门
    @ApiModelProperty(value = "转发部门", dataType = "unknowType", required = true, hidden = false)
    private String transmitDeptid;
    //接受部门名称
    @ApiModelProperty(value = "接受部门名称", dataType = "String", required = true, hidden = false)
    private String acceptdeptName;


    //责任部门名称
    @ApiModelProperty(value = "责任部门名称", dataType = "String", required = true, hidden = false)
    private String respdeptName;
    //责任人名称
    @ApiModelProperty(value = "责任人名称", dataType = "String", required = true, hidden = false)
    private String respuserName;
    // 任务详情
    @ApiModelProperty(value = "任务详情", dataType = "StTaskEntity", required = true, hidden = false)
    private StTaskEntity taskDetail;

    // 任务名称
    @ApiModelProperty(value = "任务名称", dataType = "String", required = true, hidden = false)
    private String taskName;
    // 牵头部门
    @ApiModelProperty(value = "牵头部门", dataType = "String", required = true, hidden = false)
    private String qtDept;
    // 下达部门
    @ApiModelProperty(value = "下达部门", dataType = "String", required = true, hidden = false)
    private String xdDept;
    // 开始时间
    @ApiModelProperty(value = "开始时间", dataType = "String", required = true, hidden = false)
    private String sTime;
    // 完成期限
    @ApiModelProperty(value = "完成期限", dataType = "String", required = true, hidden = false)
    private String completeperiod;
    // 任务来源
    @ApiModelProperty(value = "任务来源", dataType = "String", required = true, hidden = false)
    private String taskSource;
    // 河长
    @ApiModelProperty(value = "河长", dataType = "String", required = true, hidden = false)
    private String hz;
    // 任务类别
    @ApiModelProperty(value = "任务类别", dataType = "String", required = true, hidden = false)
    private String taskType;
    // 河湖类型
    @ApiModelProperty(value = "河湖类型", dataType = "String", required = true, hidden = false)
    private String lakeType;
    // 河湖编码
    @ApiModelProperty(value = "河湖编码", dataType = "String", required = true, hidden = false)
    private String lakeId;
    // 河湖名称
    @ApiModelProperty(value = "河湖名称", dataType = "String", required = true, hidden = false)
    private String lakeName;
    // 河湖类型名称
    @ApiModelProperty(value = "河湖类型名称", dataType = "String", required = true, hidden = false)
    private String lakeTypeName;
    // 河湖归属
    @ApiModelProperty(value = "河湖归属", dataType = "String", required = true, hidden = false)
    private Map<String, Object>  lakeBelongTo;
    //  权限
    @ApiModelProperty(value = "权限", dataType = "String", required = true, hidden = false)
    private String power;


    //附件属性
    @ApiModelProperty(value = "附件属性",dataType="String",required = true,hidden = false)
    private List<FileUploadEntity> fileList;

    public List<FileUploadEntity> getFileList() {
        return fileList;
    }

    public void setFileList(List<FileUploadEntity> fileList) {
        this.fileList = fileList;
    }

    public String getAcceptdeptName() {
        return acceptdeptName;
    }

    public void setAcceptdeptName(String acceptdeptName) {
        this.acceptdeptName = acceptdeptName;
    }

    public String getHz() {
        return hz;
    }

    public void setHz(String hz) {
        this.hz = hz;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public Map<String, Object> getLakeBelongTo() {
        return lakeBelongTo;
    }

    public void setLakeBelongTo(Map<String, Object> lakeBelongTo) {
        this.lakeBelongTo = lakeBelongTo;
    }

    public String getLakeTypeName() {
        return lakeTypeName;
    }

    public void setLakeTypeName(String lakeTypeName) {
        this.lakeTypeName = lakeTypeName;
    }

    public String getLakeId() {
        return lakeId;
    }

    public void setLakeId(String lakeId) {
        this.lakeId = lakeId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getQtDept() {
        return qtDept;
    }

    public void setQtDept(String qtDept) {
        this.qtDept = qtDept;
    }

    public String getXdDept() {
        return xdDept;
    }

    public void setXdDept(String xdDept) {
        this.xdDept = xdDept;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    public String getCompleteperiod() {
        return completeperiod;
    }

    public void setCompleteperiod(String completeperiod) {
        this.completeperiod = completeperiod;
    }

    public String getTaskSource() {
        return taskSource;
    }

    public void setTaskSource(String taskSource) {
        this.taskSource = taskSource;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getLakeType() {
        return lakeType;
    }

    public void setLakeType(String lakeType) {
        this.lakeType = lakeType;
    }

    public String getLakeName() {
        return lakeName;
    }

    public void setLakeName(String lakeName) {
        this.lakeName = lakeName;
    }




    public String getRespdeptName() {
        return respdeptName;
    }

    public void setRespdeptName(String respdeptName) {
        this.respdeptName = respdeptName;
    }

    public String getRespuserName() {
        return respuserName;
    }

    public void setRespuserName(String respuserName) {
        this.respuserName = respuserName;
    }


    //-------
    public StTaskEntity getTaskDetail() {
        return taskDetail;
    }

    public void setTaskDetail(StTaskEntity taskDetail) {
        this.taskDetail = taskDetail;
    }

    // 任务转发明细
    private List<StTaskdetailTransmitEntity> taskTransmit;

	public List<StTaskdetailTransmitEntity> getTaskTransmit() {
		return taskTransmit;
	}

	public void setTaskTransmit(List<StTaskdetailTransmitEntity> taskTransmit) {
		this.taskTransmit = taskTransmit;
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
     * 设置：子任务编号
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取：子任务编号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置：任务指标项
     */
    public void setIndicate(String indicate) {
        this.indicate = indicate;
    }

    /**
     * 获取：任务指标项
     */
    public String getIndicate() {
        return indicate;
    }

    /**
     * 设置：指标值-现状指标值
     */
    public void setNowindicators(String nowindicators) {
        this.nowindicators = nowindicators;
    }

    /**
     * 获取：指标值-现状指标值
     */
    public String getNowindicators() {
        return nowindicators;
    }

    /**
     * 设置：指标值-预期指标值
     */
    public void setExpectedindicators(String expectedindicators) {
        this.expectedindicators = expectedindicators;
    }

    /**
     * 获取：指标值-预期指标值
     */
    public String getExpectedindicators() {
        return expectedindicators;
    }

    /**
     * 设置：分阶段目标-第一年度目标
     */
    public void setPhaseone(String phaseone) {
        this.phaseone = phaseone;
    }

    /**
     * 获取：分阶段目标-第一年度目标
     */
    public String getPhaseone() {
        return phaseone;
    }

    /**
     * 设置：分阶段目标-第二年度目标
     */
    public void setPhasetwo(String phasetwo) {
        this.phasetwo = phasetwo;
    }

    /**
     * 获取：分阶段目标-第二年度目标
     */
    public String getPhasetwo() {
        return phasetwo;
    }

    /**
     * 设置：分阶段目标-第三年度目标
     */
    public void setPhasethree(String phasethree) {
        this.phasethree = phasethree;
    }

    /**
     * 获取：分阶段目标-第三年度目标
     */
    public String getPhasethree() {
        return phasethree;
    }

    /**
     * 设置：分阶段目标-第四年度目标
     */
    public void setPhasefour(String phasefour) {
        this.phasefour = phasefour;
    }

    /**
     * 获取：分阶段目标-第四年度目标
     */
    public String getPhasefour() {
        return phasefour;
    }

    /**
     * 设置：分阶段目标-第五年度目标
     */
    public void setPhasefive(String phasefive) {
        this.phasefive = phasefive;
    }

    /**
     * 获取：分阶段目标-第五年度目标
     */
    public String getPhasefive() {
        return phasefive;
    }

    /**
     * 设置：责任部门
     */
    public void setRespdept(String respdept) {
        this.respdept = respdept;
    }

    /**
     * 获取：责任部门
     */
    public String getRespdept() {
        return respdept;
    }

    /**
     * 设置：责任人
     */
    public void setRespuser(String respuser) {
        this.respuser = respuser;
    }

    /**
     * 获取：责任人
     */
    public String getRespuser() {
        return respuser;
    }

    /**
     * 设置：联系电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取：联系电话
     */
    public String getTel() {
        return tel;
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
     * 设置：接受部门
     */
    public void setAcceptdept(String acceptdept) {
        this.acceptdept = acceptdept;
    }

    /**
     * 获取：接受部门
     */
    public String getAcceptdept() {
        return acceptdept;
    }

    /**
     * 设置：是否接受
     */
    public void setIsaccepted(Double isaccepted) {
        this.isaccepted = isaccepted;
    }

    /**
     * 获取：是否接受
     */
    public Double getIsaccepted() {
        return isaccepted;
    }

    /**
     * 设置：任务编号
     */
    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    /**
     * 获取：任务编号
     */
    public String getTaskid() {
        return taskid;
    }

    /**
     * 设置：解决方案附件编号
     */
    public void setSolattachid(String solattachid) {
        this.solattachid = solattachid;
    }

    /**
     * 获取：解决方案附件编号
     */
    public String getSolattachid() {
        return solattachid;
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
     * 设置：接受部门编号
     */
    public void setAcceptdeptid(String acceptdeptid) {
        this.acceptdeptid = acceptdeptid;
    }

    /**
     * 获取：接受部门编号
     */
    public String getAcceptdeptid() {
        return acceptdeptid;
    }

    /**
     * 设置：接受标识
     */
    public void setAcceptflag(String acceptflag) {
        this.acceptflag = acceptflag;
    }

    /**
     * 获取：接受标识
     */
    public String getAcceptflag() {
        return acceptflag;
    }

    /**
     * 设置：接受人
     */
    public void setAcceptuserid(String acceptuserid) {
        this.acceptuserid = acceptuserid;
    }

    /**
     * 获取：接受人
     */
    public String getAcceptuserid() {
        return acceptuserid;
    }

    /**
     * 设置：接受时间
     */
    public void setAccepttime(Date accepttime) {
        this.accepttime = accepttime;
    }

    /**
     * 获取：接受时间
     */
    public Date getAccepttime() {
        return accepttime;
    }


    /**
     * 设置：转发到部门
     */
    public void setTodeptid(String todeptid) {
        this.todeptid = todeptid;
    }

    /**
     * 获取：转发到部门
     */
    public String getTodeptid() {
        return todeptid;
    }

    /**
     * 设置：转发者
     */
    public void setTransmituserid(String transmituserid) {
        this.transmituserid = transmituserid;
    }

    /**
     * 获取：转发者
     */
    public String getTransmituserid() {
        return transmituserid;
    }

    /**
     * 设置：转发时间
     */
    public void setTransmittime(Date transmittime) {
        this.transmittime = transmittime;
    }

    /**
     * 获取：转发时间
     */
    public Date getTransmittime() {
        return transmittime;
    }

    /**
     * 设置：转发部门
     */
    public void setTransmitDeptid(String  transmitDeptid) {
        this.transmitDeptid = transmitDeptid;
    }

    /**
     * 获取：转发部门
     */
    public String getTransmitDeptid() {
        return transmitDeptid;
    }
}
