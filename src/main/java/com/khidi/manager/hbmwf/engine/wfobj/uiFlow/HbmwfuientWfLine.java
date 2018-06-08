package com.khidi.manager.hbmwf.engine.wfobj.uiFlow;

import io.swagger.annotations.ApiModelProperty;

//  流程连线设置(为UI提供的实体)
public class HbmwfuientWfLine {
	@ApiModelProperty(value = "线类型", required = true,hidden = false)
	private String type;
	@ApiModelProperty(value = "from节点", required = true,hidden = false)
	private String from;
	@ApiModelProperty(value = "to节点", required = true,hidden = false)
	private String to;
	@ApiModelProperty(value = "线名称", required = true,hidden = false)
	private String name;
	@ApiModelProperty(value = "dash", required = true,hidden = false)
	private String dash;
	@ApiModelProperty(value = "线Id(虚线或实线)", required = true,hidden = false)
	private String id;
	@ApiModelProperty(value = "线的辅助参数M", required = true,hidden = false)
	private float m;

	public float getM() {
		return m;
	}
	public void setM(float m) {
		this.m = m;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	//
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDash() {
		return dash;
	}
	public void setDash(String dash) {
		this.dash = dash;
	}
}
