package com.khidi.manager.hbmwf.engine.wfobj.uiFlow;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

//流程内容描述(为UI提供的实体)
public class HbmwfuientWfobj {
	@ApiModelProperty(value = "流程标题", required = true,hidden = false)
	private String title;
	@ApiModelProperty(value = "流程节点集合", required = true,hidden = false)
	private List<HbmwfuientWfNode> nodes;
	@ApiModelProperty(value = "流程连线集合", required = true,hidden = false)
	private List<HbmwfuientWfLine> lines;
	@ApiModelProperty(value = "initNum", required = true,hidden = false)
	private String initNum;
	
	
	public String getInitNum() {
		return initNum;
	}
	public void setInitNum(String initNum) {
		this.initNum = initNum;
	}
	//
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<HbmwfuientWfNode> getNodes() {
		return nodes;
	}
	public void setNodes(List<HbmwfuientWfNode> nodes) {
		this.nodes = nodes;
	}
	public List<HbmwfuientWfLine> getLines() {
		return lines;
	}
	public void setLines(List<HbmwfuientWfLine> lines) {
		this.lines = lines;
	}
	
}
