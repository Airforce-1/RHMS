package com.khidi.manager.hbmwf.engine.wfobj.uiFlow;

import io.swagger.annotations.ApiModelProperty;
//流程节点设置(为UI提供的实体)
public class HbmwfuientWfNode {
	@ApiModelProperty(value = "节点名", required = true,hidden = false)
	private String name;
	@ApiModelProperty(value = "节点x坐标", required = true,hidden = false)
	private String left;
	@ApiModelProperty(value = "节点y坐标", required = true,hidden = false)
	private String top;
	@ApiModelProperty(value = "节点类型", required = true,hidden = false)
	private String type;
	@ApiModelProperty(value = "节点宽度", required = true,hidden = false)
	private String width;
	@ApiModelProperty(value = "节点高度", required = true,hidden = false)
	private String height;
	@ApiModelProperty(value = "节点提示信息", required = true,hidden = false)
	private String alt;
	@ApiModelProperty(value = "节点Id", required = true,hidden = false)
	private String id;
	@ApiModelProperty(value = "审批（处理）不通过，退回到哪", required = true,hidden = false)
	private String backto;
	@ApiModelProperty(value = "审批接收者", required = true,hidden = false)
	private String receiver;
	@ApiModelProperty(value = "前置逻辑(前面节点 用此逻辑运算后的返回值标识该节点是否启动)", required = true,hidden = false)
	private String prelogic;
//	@ApiModelProperty(value = "节点状态", required = true,hidden = false)
//	private String state;
//	
//	public String getState() {
//		return state;
//	}
//	public void setState(String state) {
//		this.state = state;
//	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getPrelogic() {
		return prelogic;
	}
	public void setPrelogic(String prelogic) {
		this.prelogic = prelogic;
	}
	public String getBackto() {
		return backto;
	}
	public void setBackto(String backto) {
		this.backto = backto;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	//
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLeft() {
		return left;
	}
	public void setLeft(String left) {
		this.left = left;
	}
	public String getTop() {
		return top;
	}
	public void setTop(String top) {
		this.top = top;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
}
