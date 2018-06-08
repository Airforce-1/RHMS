package com.khidi.manager.hbmwf.engine.domain.tst;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

// swagger 前端json 对象转换测试 实体类
public class HbmentComplexentOne {
	@ApiModelProperty(value = "编号", required = true,hidden = false)
	private int id;
	@ApiModelProperty(value = "名称", required = true,hidden = false)
	private String name;
	@ApiModelProperty(value = "复杂对象", required = true,hidden = false)
	private List<HbmentComplexObj> complexobj;
	
	
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
	public List<HbmentComplexObj> getComplexobj() {
		return complexobj;
	}
	public void setComplexobj(List<HbmentComplexObj> complexobj) {
		this.complexobj = complexobj;
	}
}
