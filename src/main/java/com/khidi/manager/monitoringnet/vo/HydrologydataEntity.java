package com.khidi.manager.monitoringnet.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-08 13:25:47
 */
public class HydrologydataEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
	private String id;
	//监测站编码
	private String stationid;
	//监测时间
	private Date createdate;
	//流速(m/s)
	private String speed;
	//流量(m3/s)
	private String flow;
	//水量(万m3)
	private String yield;
	//区域名称
	private String areaName;
	//监测站编码
	private String Code;

}
