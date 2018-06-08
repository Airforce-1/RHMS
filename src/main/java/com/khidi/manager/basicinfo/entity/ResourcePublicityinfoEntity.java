package com.khidi.manager.basicinfo.entity;

import com.khidi.manager.sys.entity.FileUploadEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;


/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-04 18:19:33
 */
public class ResourcePublicityinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//资源(河渠湖库（段）)编码
	private String id;
	//行政区划名称
	private String areaName;
	//资源(河渠湖库（段）)类型
	private String resourcetype;
	//河湖渠库（段）名称
	private String resourcename;
	//目标
	private String aim;
	//职责
	private String duty;
	//巡查员
	private String checker;
	//警长
	private String policeman;
	//督察长
	private String superviser;
	//河长姓名
	private String header;
	//河长职务编码
	private String headerpost;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getResourcetype() {
		return resourcetype;
	}

	public void setResourcetype(String resourcetype) {
		this.resourcetype = resourcetype;
	}

	public String getResourcename() {
		return resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	public String getAim() {
		return aim;
	}

	public void setAim(String aim) {
		this.aim = aim;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getPoliceman() {
		return policeman;
	}

	public void setPoliceman(String policeman) {
		this.policeman = policeman;
	}

	public String getSuperviser() {
		return superviser;
	}

	public void setSuperviser(String superviser) {
		this.superviser = superviser;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getHeaderpost() {
		return headerpost;
	}

	public void setHeaderpost(String headerpost) {
		this.headerpost = headerpost;
	}
}
