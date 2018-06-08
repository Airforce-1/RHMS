package com.khidi.manager.sys.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-12-14 14:31:17
 */
public class SysRoleResourceEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//河流编码集合
    @ApiModelProperty(value = "河流编码集合",dataType="String",required = true,hidden = false)
	private String riverids;
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//角色编码
    @ApiModelProperty(value = "角色编码",dataType="String",required = true,hidden = false)
	private String roleId;
	//湖泊编码集合
    @ApiModelProperty(value = "湖泊编码集合",dataType="String",required = true,hidden = false)
	private String lakeids;
	//监测站编码集合
    @ApiModelProperty(value = "监测站编码集合",dataType="String",required = true,hidden = false)
	private String videostationids;
	//渠道编码集合
    @ApiModelProperty(value = "渠道编码集合",dataType="String",required = true,hidden = false)
	private String canalids;
	//水文水质监测站编码集
    @ApiModelProperty(value = "水文水质监测站编码集",dataType="String",required = true,hidden = false)
	private String riverstationids;
	//水库编码集合
    @ApiModelProperty(value = "水库编码集合",dataType="String",required = true,hidden = false)
	private String reservoirids;
	//河段编码集合
    @ApiModelProperty(value = "河段编码集合",dataType="String",required = true,hidden = false)
	private String partriverids;
	//渠段编码集合
    @ApiModelProperty(value = "渠段编码集合",dataType="String",required = true,hidden = false)
	private String partcanalids;
	//湖段编码集合
    @ApiModelProperty(value = "湖段编码集合",dataType="String",required = true,hidden = false)
	private String partlakeids;
	//库段编码集合
    @ApiModelProperty(value = "库段编码集合",dataType="String",required = true,hidden = false)
	private String partreservoirids;
	//行政区划编码集合
    @ApiModelProperty(value = "行政区划编码集合",dataType="String",required = true,hidden = false)
	private String areaids;
	//菜单编码集合
	@ApiModelProperty(value = "菜单编码集合",dataType="String",required = true,hidden = false)
	private String menuids;


	public String getMenuids() {
		return menuids;
	}

	public void setMenuids(String menuids) {
		this.menuids = menuids;
	}

	/**
	 * 设置：河流编码集合
	 */
	public void setRiverids(String riverids) {
		this.riverids = riverids;
	}
	/**
	 * 获取：河流编码集合
	 */
	public String getRiverids() {
		return riverids;
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
	 * 设置：角色编码
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：角色编码
	 */
	public String getRoleId() {
		return roleId;
	}
	/**
	 * 设置：湖泊编码集合
	 */
	public void setLakeids(String lakeids) {
		this.lakeids = lakeids;
	}
	/**
	 * 获取：湖泊编码集合
	 */
	public String getLakeids() {
		return lakeids;
	}
	/**
	 * 设置：监测站编码集合
	 */
	public void setVideostationids(String videostationids) {
		this.videostationids = videostationids;
	}
	/**
	 * 获取：监测站编码集合
	 */
	public String getVideostationids() {
		return videostationids;
	}
	/**
	 * 设置：渠道编码集合
	 */
	public void setCanalids(String canalids) {
		this.canalids = canalids;
	}
	/**
	 * 获取：渠道编码集合
	 */
	public String getCanalids() {
		return canalids;
	}
	/**
	 * 设置：水文水质监测站编码集
	 */
	public void setRiverstationids(String riverstationids) {
		this.riverstationids = riverstationids;
	}
	/**
	 * 获取：水文水质监测站编码集
	 */
	public String getRiverstationids() {
		return riverstationids;
	}
	/**
	 * 设置：水库编码集合
	 */
	public void setReservoirids(String reservoirids) {
		this.reservoirids = reservoirids;
	}
	/**
	 * 获取：水库编码集合
	 */
	public String getReservoirids() {
		return reservoirids;
	}
	/**
	 * 设置：河段编码集合
	 */
	public void setPartriverids(String partriverids) {
		this.partriverids = partriverids;
	}
	/**
	 * 获取：河段编码集合
	 */
	public String getPartriverids() {
		return partriverids;
	}
	/**
	 * 设置：渠段编码集合
	 */
	public void setPartcanalids(String partcanalids) {
		this.partcanalids = partcanalids;
	}
	/**
	 * 获取：渠段编码集合
	 */
	public String getPartcanalids() {
		return partcanalids;
	}
	/**
	 * 设置：湖段编码集合
	 */
	public void setPartlakeids(String partlakeids) {
		this.partlakeids = partlakeids;
	}
	/**
	 * 获取：湖段编码集合
	 */
	public String getPartlakeids() {
		return partlakeids;
	}
	/**
	 * 设置：库段编码集合
	 */
	public void setPartreservoirids(String partreservoirids) {
		this.partreservoirids = partreservoirids;
	}
	/**
	 * 获取：库段编码集合
	 */
	public String getPartreservoirids() {
		return partreservoirids;
	}
	/**
	 * 设置：行政区划编码集合
	 */
	public void setAreaids(String areaids) {
		this.areaids = areaids;
	}
	/**
	 * 获取：行政区划编码集合
	 */
	public String getAreaids() {
		return areaids;
	}
}
