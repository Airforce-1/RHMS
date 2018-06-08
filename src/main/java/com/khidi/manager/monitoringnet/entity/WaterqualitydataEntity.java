package com.khidi.manager.monitoringnet.entity;

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
public class WaterqualitydataEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//监测站编码
	@ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String code;
	//时间
    @ApiModelProperty(value = "时间",dataType="DATE",required = true,hidden = false)
	private Date createtime;
	//监测站系统编码
    @ApiModelProperty(value = "监测站编码",dataType="String",required = true,hidden = false)
	private String stationId;
	//监测站名称
	@ApiModelProperty(value = "监测站名称",dataType="String",required = true,hidden = false)
	private String stationName;
	//PH值
    @ApiModelProperty(value = "PH值",dataType="String",required = true,hidden = false)
	private String ph;
	//COD(mg/L)
    @ApiModelProperty(value = "COD(mg/L)",dataType="String",required = true,hidden = false)
	private String cod;
	//BOD(mg/L)
    @ApiModelProperty(value = "BOD(mg/L)",dataType="String",required = true,hidden = false)
	private String bod;
	//大肠菌群(个/L)
    @ApiModelProperty(value = "大肠菌群(个/L)",dataType="String",required = true,hidden = false)
	private String coliform;
	//总磷(mg/L)
    @ApiModelProperty(value = "总磷(mg/L)",dataType="String",required = true,hidden = false)
	private String phosphor;
	//周平均最大温升(℃)
    @ApiModelProperty(value = "周平均最大温升(℃)",dataType="String",required = true,hidden = false)
	private String maxuptemp;
	//周平均最大温降(℃)
    @ApiModelProperty(value = "周平均最大温降(℃)",dataType="String",required = true,hidden = false)
	private String maxfalltemp;
	//氨氮(mg/L)
    @ApiModelProperty(value = "氨氮(mg/L)",dataType="String",required = true,hidden = false)
	private String nh;
	//溶解氧(mg/L)
    @ApiModelProperty(value = "溶解氧(mg/L)",dataType="String",required = true,hidden = false)
	private String oxygen;
	//高锰酸盐指数(mg/L)
    @ApiModelProperty(value = "高锰酸盐指数(mg/L)",dataType="String",required = true,hidden = false)
	private String permanganate;
	//总氮(mg/L)
    @ApiModelProperty(value = "总氮(mg/L)",dataType="String",required = true,hidden = false)
	private String totaln;
	//铜(mg/L)
    @ApiModelProperty(value = "铜(mg/L)",dataType="String",required = true,hidden = false)
	private String cu;
	//锌(mg/L)
    @ApiModelProperty(value = "锌(mg/L)",dataType="String",required = true,hidden = false)
	private String zn;
	//氟化物(mg/L)
    @ApiModelProperty(value = "氟化物(mg/L)",dataType="String",required = true,hidden = false)
	private String fluoride;
	//硒(mg/L)
    @ApiModelProperty(value = "硒(mg/L)",dataType="String",required = true,hidden = false)
	private String se;
	//砷(mg/L)
    @ApiModelProperty(value = "砷(mg/L)",dataType="String",required = true,hidden = false)
	private String arsenic;
	//汞(mg/L)
    @ApiModelProperty(value = "汞(mg/L)",dataType="String",required = true,hidden = false)
	private String hg;
	//镉(mg/L)
    @ApiModelProperty(value = "镉(mg/L)",dataType="String",required = true,hidden = false)
	private String cd;
	//铬(六价)(mg/L)
    @ApiModelProperty(value = "铬(六价)(mg/L)",dataType="String",required = true,hidden = false)
	private String chromium;
	//铅(mg/L)
    @ApiModelProperty(value = "铅(mg/L)",dataType="String",required = true,hidden = false)
	private String lead;
	//氰化物(mg/L)
    @ApiModelProperty(value = "氰化物(mg/L)",dataType="String",required = true,hidden = false)
	private String cyanide;
	//挥发酚(mg/L)
    @ApiModelProperty(value = "挥发酚(mg/L)",dataType="String",required = true,hidden = false)
	private String phenol;
	//石油类(mg/L)
    @ApiModelProperty(value = "石油类(mg/L)",dataType="String",required = true,hidden = false)
	private String petroleum;
	//阴离子表面活性剂(mg/L)
    @ApiModelProperty(value = "阴离子表面活性剂(mg/L)",dataType="String",required = true,hidden = false)
	private String anionic;
	//硫化物(mg/L)
    @ApiModelProperty(value = "硫化物(mg/L)",dataType="String",required = true,hidden = false)
	private String sulfide;
	//行政区划名称
	@ApiModelProperty(value = "行政区划名称",dataType="String",required = true,hidden = false)
	private String areaName;

	public String getStationName() {
		return stationName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 设置：系统编码
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：系统编码
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：监测站编码
	 */
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	/**
	 * 获取：监测站编码
	 */
	public String getStationId() {
		return stationId;
	}
	/**
	 * 设置：PH值
	 */
	public void setPh(String ph) {
		this.ph = ph;
	}
	/**
	 * 获取：PH值
	 */
	public String getPh() {
		return ph;
	}
	/**
	 * 设置：COD(mg/L)
	 */
	public void setCod(String cod) {
		this.cod = cod;
	}
	/**
	 * 获取：COD(mg/L)
	 */
	public String getCod() {
		return cod;
	}
	/**
	 * 设置：BOD(mg/L)
	 */
	public void setBod(String bod) {
		this.bod = bod;
	}
	/**
	 * 获取：BOD(mg/L)
	 */
	public String getBod() {
		return bod;
	}
	/**
	 * 设置：大肠菌群(个/L)
	 */
	public void setColiform(String coliform) {
		this.coliform = coliform;
	}
	/**
	 * 获取：大肠菌群(个/L)
	 */
	public String getColiform() {
		return coliform;
	}
	/**
	 * 设置：总磷(mg/L)
	 */
	public void setPhosphor(String phosphor) {
		this.phosphor = phosphor;
	}
	/**
	 * 获取：总磷(mg/L)
	 */
	public String getPhosphor() {
		return phosphor;
	}
	/**
	 * 设置：周平均最大温升(℃)
	 */
	public void setMaxuptemp(String maxuptemp) {
		this.maxuptemp = maxuptemp;
	}
	/**
	 * 获取：周平均最大温升(℃)
	 */
	public String getMaxuptemp() {
		return maxuptemp;
	}
	/**
	 * 设置：周平均最大温降(℃)
	 */
	public void setMaxfalltemp(String maxfalltemp) {
		this.maxfalltemp = maxfalltemp;
	}
	/**
	 * 获取：周平均最大温降(℃)
	 */
	public String getMaxfalltemp() {
		return maxfalltemp;
	}
	/**
	 * 设置：氨氮(mg/L)
	 */
	public void setNh(String nh) {
		this.nh = nh;
	}
	/**
	 * 获取：氨氮(mg/L)
	 */
	public String getNh() {
		return nh;
	}
	/**
	 * 设置：溶解氧(mg/L)
	 */
	public void setOxygen(String oxygen) {
		this.oxygen = oxygen;
	}
	/**
	 * 获取：溶解氧(mg/L)
	 */
	public String getOxygen() {
		return oxygen;
	}
	/**
	 * 设置：高锰酸盐指数(mg/L)
	 */
	public void setPermanganate(String permanganate) {
		this.permanganate = permanganate;
	}
	/**
	 * 获取：高锰酸盐指数(mg/L)
	 */
	public String getPermanganate() {
		return permanganate;
	}
	/**
	 * 设置：总氮(mg/L)
	 */
	public void setTotaln(String totaln) {
		this.totaln = totaln;
	}
	/**
	 * 获取：总氮(mg/L)
	 */
	public String getTotaln() {
		return totaln;
	}
	/**
	 * 设置：铜(mg/L)
	 */
	public void setCu(String cu) {
		this.cu = cu;
	}
	/**
	 * 获取：铜(mg/L)
	 */
	public String getCu() {
		return cu;
	}
	/**
	 * 设置：锌(mg/L)
	 */
	public void setZn(String zn) {
		this.zn = zn;
	}
	/**
	 * 获取：锌(mg/L)
	 */
	public String getZn() {
		return zn;
	}
	/**
	 * 设置：氟化物(mg/L)
	 */
	public void setFluoride(String fluoride) {
		this.fluoride = fluoride;
	}
	/**
	 * 获取：氟化物(mg/L)
	 */
	public String getFluoride() {
		return fluoride;
	}
	/**
	 * 设置：硒(mg/L)
	 */
	public void setSe(String se) {
		this.se = se;
	}
	/**
	 * 获取：硒(mg/L)
	 */
	public String getSe() {
		return se;
	}
	/**
	 * 设置：砷(mg/L)
	 */
	public void setArsenic(String arsenic) {
		this.arsenic = arsenic;
	}
	/**
	 * 获取：砷(mg/L)
	 */
	public String getArsenic() {
		return arsenic;
	}
	/**
	 * 设置：汞(mg/L)
	 */
	public void setHg(String hg) {
		this.hg = hg;
	}
	/**
	 * 获取：汞(mg/L)
	 */
	public String getHg() {
		return hg;
	}
	/**
	 * 设置：镉(mg/L)
	 */
	public void setCd(String cd) {
		this.cd = cd;
	}
	/**
	 * 获取：镉(mg/L)
	 */
	public String getCd() {
		return cd;
	}
	/**
	 * 设置：铬(六价)(mg/L)
	 */
	public void setChromium(String chromium) {
		this.chromium = chromium;
	}
	/**
	 * 获取：铬(六价)(mg/L)
	 */
	public String getChromium() {
		return chromium;
	}
	/**
	 * 设置：铅(mg/L)
	 */
	public void setLead(String lead) {
		this.lead = lead;
	}
	/**
	 * 获取：铅(mg/L)
	 */
	public String getLead() {
		return lead;
	}
	/**
	 * 设置：氰化物(mg/L)
	 */
	public void setCyanide(String cyanide) {
		this.cyanide = cyanide;
	}
	/**
	 * 获取：氰化物(mg/L)
	 */
	public String getCyanide() {
		return cyanide;
	}
	/**
	 * 设置：挥发酚(mg/L)
	 */
	public void setPhenol(String phenol) {
		this.phenol = phenol;
	}
	/**
	 * 获取：挥发酚(mg/L)
	 */
	public String getPhenol() {
		return phenol;
	}
	/**
	 * 设置：石油类(mg/L)
	 */
	public void setPetroleum(String petroleum) {
		this.petroleum = petroleum;
	}
	/**
	 * 获取：石油类(mg/L)
	 */
	public String getPetroleum() {
		return petroleum;
	}
	/**
	 * 设置：阴离子表面活性剂(mg/L)
	 */
	public void setAnionic(String anionic) {
		this.anionic = anionic;
	}
	/**
	 * 获取：阴离子表面活性剂(mg/L)
	 */
	public String getAnionic() {
		return anionic;
	}
	/**
	 * 设置：硫化物(mg/L)
	 */
	public void setSulfide(String sulfide) {
		this.sulfide = sulfide;
	}
	/**
	 * 获取：硫化物(mg/L)
	 */
	public String getSulfide() {
		return sulfide;
	}
}
