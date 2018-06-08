package com.khidi.manager.hbmwf.engine.domain;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
/**
 * 工作流POJO  流程
 *
 * @author 王顺波
 * @email 405877884@qq.com
 * @date 2017-11-17 11:02
 */
public class HbmentWfHandle {
	@ApiModelProperty(value = "handle编号", required = true,hidden = false)
	private int id;
	@ApiModelProperty(value = "流程编号", required = true,hidden = false)
	private int wfId;
	@ApiModelProperty(value = "节点编号", required = true,hidden = false)
	private String nodeId;
	@ApiModelProperty(value = "节点状态", required = true,hidden = false)
	private String nodeState;
	@ApiModelProperty(value = "删除标志", required = true,hidden = false)
	private int delInd;
	@ApiModelProperty(value = "创建时间", required = true,hidden = false)
	private Date createTime;
	@ApiModelProperty(value = "最后更新时间", required = true,hidden = false)
	private Date lastUpdateTime;
	@ApiModelProperty(value = "创建部门", required = true,hidden = false)
	private String createDept;
	@ApiModelProperty(value = "创建者", required = true,hidden = false)
	private String createUser;
	@ApiModelProperty(value = "最后更新部门编号", required = true,hidden = false)
	private String lastUpdateDept;
	@ApiModelProperty(value = "最后更新人编号", required = true,hidden = false)
	private String lastUpdateUser;
	@ApiModelProperty(value = "当前handle标志", required = true,hidden = false)
	private int currentInd;
	@ApiModelProperty(value = "备注", required = true,hidden = false)
	private String memo;
	@ApiModelProperty(value = "接收者", required = true,hidden = false)
	private String receivers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWfId() {
		return wfId;
	}

	public void setWfId(int wfId) {
		this.wfId = wfId;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeState() {
		return nodeState;
	}

	public void setNodeState(String nodeState) {
		this.nodeState = nodeState;
	}

	public int getDelInd() {
		return delInd;
	}

	public void setDelInd(int delInd) {
		this.delInd = delInd;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getCreateDept() {
		return createDept;
	}

	public void setCreateDept(String createDept) {
		this.createDept = createDept;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getLastUpdateDept() {
		return lastUpdateDept;
	}

	public void setLastUpdateDept(String lastUpdateDept) {
		this.lastUpdateDept = lastUpdateDept;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public int getCurrentInd() {
		return currentInd;
	}

	public void setCurrentInd(int currentInd) {
		this.currentInd = currentInd;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getReceivers() {
		return receivers;
	}

	public void setReceivers(String receivers) {
		this.receivers = receivers;
	}
}
