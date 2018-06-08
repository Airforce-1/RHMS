/**   
* @Title: HbmentuiWftmpl.java 
* @Package com.khidi.manager.hbm.engine.domain 
* @Description: TODO(流程模板 与 前端交互的实体) 
* @author 王顺波
* @date 2017年11月21日 下午5:42:41 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.domain;

import java.sql.Date;

import com.khidi.manager.hbmwf.engine.wfobj.uiFlow.HbmwfuientWfobj;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 王顺波
 *
 */
public class HbmentuiWftmpl {
	@ApiModelProperty(value = "编号", required = true,hidden = false)
	private int id;
	@ApiModelProperty(value = "名称", required = true,hidden = false)
	private String name;
	@ApiModelProperty(value = "模版内容", required = true,hidden = false)
	private HbmwfuientWfobj theContent;
	@ApiModelProperty(value = "父编号", required = true,hidden = false)
	private int pid;
	@ApiModelProperty(value = "备注", required = true,hidden = false)
	private String memo;
	@ApiModelProperty(value = "最后更新时间", required = true,hidden = false)
	private Date lastUpdateTime;
	@ApiModelProperty(value = "最后更新部门", required = true,hidden = false)
	private String lastUpdateDept;
	@ApiModelProperty(value = "最后更新者", required = true,hidden = false)
	private String lastUpdateUser;
	@ApiModelProperty(value = "创建时间", required = true,hidden = false)
	private Date createTime;
	@ApiModelProperty(value = "创建人", required = true,hidden = false)
	private String createUser;
	@ApiModelProperty(value = "创建部门", required = true,hidden = false)
	private String createDept;
	private String bfld0;
	
	
	public String getBfld0() {
		return bfld0;
	}
	public void setBfld0(String bfld0) {
		this.bfld0 = bfld0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HbmwfuientWfobj getTheContent() {
		return theContent;
	}
	public void setTheContent(HbmwfuientWfobj theContent) {
		this.theContent = theContent;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getCreateDept() {
		return createDept;
	}
	public void setCreateDept(String createDept) {
		this.createDept = createDept;
	}
}
