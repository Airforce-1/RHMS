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
public class StTargetdetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//编号
    @ApiModelProperty(value = "编号",dataType="String",required = true,hidden = false)
	private String id;
	//目标编号
    @ApiModelProperty(value = "目标编号",dataType="String",required = true,hidden = false)
	private String targetid;
	//指标项
    @ApiModelProperty(value = "指标项",dataType="String",required = true,hidden = false)
	private String indicators;
	//指标值-现状
    @ApiModelProperty(value = "指标值-现状",dataType="String",required = true,hidden = false)
	private String nowindicators;
	//指标值-预期
    @ApiModelProperty(value = "指标值-预期",dataType="String",required = true,hidden = false)
	private String expectedindicators;
	//分阶段目标-第一年度
    @ApiModelProperty(value = "分阶段目标-第一年度",dataType="String",required = true,hidden = false)
	private String phaseone;
	//分阶段目标-第二年度
    @ApiModelProperty(value = "分阶段目标-第二年度",dataType="String",required = true,hidden = false)
	private String phasetwo;
	//分阶段目标-第三年度
    @ApiModelProperty(value = "分阶段目标-第三年度",dataType="String",required = true,hidden = false)
	private String phasethree;
	//分阶段目标-第四年度
    @ApiModelProperty(value = "分阶段目标-第四年度",dataType="String",required = true,hidden = false)
	private String phasefour;
	//分阶段目标-第五年度
    @ApiModelProperty(value = "分阶段目标-第五年度",dataType="String",required = true,hidden = false)
	private String phasefive;
	//责任部门
    @ApiModelProperty(value = "责任部门",dataType="String",required = true,hidden = false)
	private String respdept;
	//责任人
    @ApiModelProperty(value = "责任人",dataType="String",required = true,hidden = false)
	private String respuser;
	//联系电话
    @ApiModelProperty(value = "联系电话",dataType="String",required = true,hidden = false)
	private String tel;
	//备注
    @ApiModelProperty(value = "备注",dataType="String",required = true,hidden = false)
	private String memo;
	//目标分类
    @ApiModelProperty(value = "目标分类",dataType="String",required = true,hidden = false)
	private String targetglobaltype;
	//解决方案附件编号
    @ApiModelProperty(value = "解决方案附件编号",dataType="String",required = true,hidden = false)
	private String attachid;
	//接受部门编号
    @ApiModelProperty(value = "接受部门编号",dataType="String",required = true,hidden = false)
	private String acceptdeptid;
	//接受标识
    @ApiModelProperty(value = "接受标识",dataType="String",required = true,hidden = false)
	private String acceptflag;
	//接受人
    @ApiModelProperty(value = "接受人",dataType="String",required = true,hidden = false)
	private String acceptuserid;
	//接受时间
    @ApiModelProperty(value = "接受时间",dataType="Date",required = true,hidden = false)
	private Date accepttime;
	//转发到部门
    @ApiModelProperty(value = "转发到部门",dataType="String",required = true,hidden = false)
	private String todeptid;
	//转发者
    @ApiModelProperty(value = "转发者",dataType="String",required = true,hidden = false)
	private String transmituserid;
	//转发时间
    @ApiModelProperty(value = "转发时间",dataType="Date",required = true,hidden = false)
	private Date transmittime;
	//进度值
	@ApiModelProperty(value = "进度值",dataType="Double",required = true,hidden = false)
	private Double progress;
	//转发部门
	@ApiModelProperty(value = "转发部门",dataType="String",required = true,hidden = false)
	private String transmitDeptid;

	//责任部门名称
	@ApiModelProperty(value = "责任部门名称", dataType = "String", required = true, hidden = false)
	private String respdeptName;
	//责任人名称
	@ApiModelProperty(value = "责任人名称", dataType = "String", required = true, hidden = false)
	private String respuserName;


	// 目标名称
	@ApiModelProperty(value = "目标名称", dataType = "String", required = true, hidden = false)
	private String targetName;
	// 牵头部门
	@ApiModelProperty(value = "牵头部门", dataType = "String", required = true, hidden = false)
	private String qtDept;
	// 下达部门
	@ApiModelProperty(value = "下达部门", dataType = "String", required = true, hidden = false)
	private String xdDept;
	// 开始时间
	@ApiModelProperty(value = "开始时间", dataType = "String", required = true, hidden = false)
	private String sTime;
	// 目标期限
	@ApiModelProperty(value = "目标期限", dataType = "String", required = true, hidden = false)
	private String targetperiod;
	// 目标来源
	@ApiModelProperty(value = "目标来源", dataType = "String", required = true, hidden = false)
	private String targetSource;
	// 目标类别
	@ApiModelProperty(value = "目标类别", dataType = "String", required = true, hidden = false)
	private String targetType;
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
	private Map<String, Object> lakeBelongTo;
	//  权限
	@ApiModelProperty(value = "权限", dataType = "String", required = true, hidden = false)
	private String power;
	//接受部门名称
	@ApiModelProperty(value = "接受部门名称", dataType = "String", required = true, hidden = false)
	private String acceptdeptName;
    //指标类型
    @ApiModelProperty(value = "指标类型", dataType = "String", required = true, hidden = false)
    private String zbtype;

	//附件属性
	@ApiModelProperty(value = "附件属性",dataType="String",required = true,hidden = false)
	private List<FileUploadEntity> fileList;

	public List<FileUploadEntity> getFileList() {
		return fileList;
	}

	public void setFileList(List<FileUploadEntity> fileList) {
		this.fileList = fileList;
	}

    public String getZbtype() {
        return zbtype;
    }

    public void setZbtype(String zbtype) {
        this.zbtype = zbtype;
    }

    public String getAcceptdeptName() {
		return acceptdeptName;
	}

	public void setAcceptdeptName(String acceptdeptName) {
		this.acceptdeptName = acceptdeptName;
	}

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
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

	public String getTargetperiod() {
		return targetperiod;
	}

	public void setTargetperiod(String targetperiod) {
		this.targetperiod = targetperiod;
	}

	public String getTargetSource() {
		return targetSource;
	}

	public void setTargetSource(String targetSource) {
		this.targetSource = targetSource;
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public String getLakeType() {
		return lakeType;
	}

	public void setLakeType(String lakeType) {
		this.lakeType = lakeType;
	}

	public String getLakeId() {
		return lakeId;
	}

	public void setLakeId(String lakeId) {
		this.lakeId = lakeId;
	}

	public String getLakeName() {
		return lakeName;
	}

	public void setLakeName(String lakeName) {
		this.lakeName = lakeName;
	}

	public String getLakeTypeName() {
		return lakeTypeName;
	}

	public void setLakeTypeName(String lakeTypeName) {
		this.lakeTypeName = lakeTypeName;
	}

	public Map<String, Object> getLakeBelongTo() {
		return lakeBelongTo;
	}

	public void setLakeBelongTo(Map<String, Object> lakeBelongTo) {
		this.lakeBelongTo = lakeBelongTo;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	// 目标转发明细
    private List<StTargetdetailTransmitEntity> targetTransmit;
    public List<StTargetdetailTransmitEntity> getTargetTransmit() {
		return targetTransmit;
	}

	public void setTargetTransmit(List<StTargetdetailTransmitEntity> targetTransmit) {
		this.targetTransmit = targetTransmit;
	}


	/**
	 * 设置：转发部门
	 */
	public void setTransmitDeptid(String transmitDeptid) {
		this.transmitDeptid = transmitDeptid;
	}
	/**
	 * 获取：转发部门
	 */
	public String getTransmitDeptid() {
		return transmitDeptid;
	}


	public Double getProgress() {
		return progress;
	}

	public void setProgress(Double progress) {
		this.progress = progress;
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
	 * 设置：目标编号
	 */
	public void setTargetid(String targetid) {
		this.targetid = targetid;
	}
	/**
	 * 获取：目标编号
	 */
	public String getTargetid() {
		return targetid;
	}
	/**
	 * 设置：指标项
	 */
	public void setIndicators(String indicators) {
		this.indicators = indicators;
	}
	/**
	 * 获取：指标项
	 */
	public String getIndicators() {
		return indicators;
	}
	/**
	 * 设置：指标值-现状
	 */
	public void setNowindicators(String nowindicators) {
		this.nowindicators = nowindicators;
	}
	/**
	 * 获取：指标值-现状
	 */
	public String getNowindicators() {
		return nowindicators;
	}
	/**
	 * 设置：指标值-预期
	 */
	public void setExpectedindicators(String expectedindicators) {
		this.expectedindicators = expectedindicators;
	}
	/**
	 * 获取：指标值-预期
	 */
	public String getExpectedindicators() {
		return expectedindicators;
	}
	/**
	 * 设置：分阶段目标-第一年度
	 */
	public void setPhaseone(String phaseone) {
		this.phaseone = phaseone;
	}
	/**
	 * 获取：分阶段目标-第一年度
	 */
	public String getPhaseone() {
		return phaseone;
	}
	/**
	 * 设置：分阶段目标-第二年度
	 */
	public void setPhasetwo(String phasetwo) {
		this.phasetwo = phasetwo;
	}
	/**
	 * 获取：分阶段目标-第二年度
	 */
	public String getPhasetwo() {
		return phasetwo;
	}
	/**
	 * 设置：分阶段目标-第三年度
	 */
	public void setPhasethree(String phasethree) {
		this.phasethree = phasethree;
	}
	/**
	 * 获取：分阶段目标-第三年度
	 */
	public String getPhasethree() {
		return phasethree;
	}
	/**
	 * 设置：分阶段目标-第四年度
	 */
	public void setPhasefour(String phasefour) {
		this.phasefour = phasefour;
	}
	/**
	 * 获取：分阶段目标-第四年度
	 */
	public String getPhasefour() {
		return phasefour;
	}
	/**
	 * 设置：分阶段目标-第五年度
	 */
	public void setPhasefive(String phasefive) {
		this.phasefive = phasefive;
	}
	/**
	 * 获取：分阶段目标-第五年度
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
	 * 设置：目标分类
	 */
	public void setTargetglobaltype(String targetglobaltype) {
		this.targetglobaltype = targetglobaltype;
	}
	/**
	 * 获取：目标分类
	 */
	public String getTargetglobaltype() {
		return targetglobaltype;
	}
	/**
	 * 设置：解决方案附件编号
	 */
	public void setAttachid(String attachid) {
		this.attachid = attachid;
	}
	/**
	 * 获取：解决方案附件编号
	 */
	public String getAttachid() {
		return attachid;
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
}
