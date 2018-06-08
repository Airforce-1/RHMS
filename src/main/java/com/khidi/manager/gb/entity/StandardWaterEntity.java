package com.khidi.manager.gb.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2018-01-29 11:12:03
 */
public class StandardWaterEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//系统编码
    @ApiModelProperty(value = "系统编码",dataType="String",required = true,hidden = false)
	private String id;
	//参考项目
    @ApiModelProperty(value = "参考项目",dataType="String",required = true,hidden = false)
	private String item;
	//河流一类水标准
    @ApiModelProperty(value = "河流一类水标准",dataType="String",required = true,hidden = false)
	private String riverOne;
	//河流二类水标准
    @ApiModelProperty(value = "河流二类水标准",dataType="String",required = true,hidden = false)
	private String riverTwo;
	//河流三类水标准
    @ApiModelProperty(value = "河流三类水标准",dataType="String",required = true,hidden = false)
	private String riverThree;
	//河流四类水标准
    @ApiModelProperty(value = "河流四类水标准",dataType="String",required = true,hidden = false)
	private String riverFour;
	//河流五类水标准
    @ApiModelProperty(value = "河流五类水标准",dataType="String",required = true,hidden = false)
	private String riverFive;
	//湖泊一类水标准
    @ApiModelProperty(value = "湖泊一类水标准",dataType="String",required = true,hidden = false)
	private String lakeOne;
	//湖泊二类水标准
    @ApiModelProperty(value = "湖泊二类水标准",dataType="String",required = true,hidden = false)
	private String lakeTwo;
	//湖泊三类水标准
    @ApiModelProperty(value = "湖泊三类水标准",dataType="String",required = true,hidden = false)
	private String lakeThree;
	//湖泊四类水标准
    @ApiModelProperty(value = "湖泊四类水标准",dataType="String",required = true,hidden = false)
	private String lakeFour;
	//湖泊五类水标准
    @ApiModelProperty(value = "湖泊五类水标准",dataType="String",required = true,hidden = false)
	private String lakeFive;

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
	 * 设置：参考项目
	 */
	public void setItem(String item) {
		this.item = item;
	}
	/**
	 * 获取：参考项目
	 */
	public String getItem() {
		return item;
	}
	/**
	 * 设置：河流一类水标准
	 */
	public void setRiverOne(String riverOne) {
		this.riverOne = riverOne;
	}
	/**
	 * 获取：河流一类水标准
	 */
	public String getRiverOne() {
		return riverOne;
	}
	/**
	 * 设置：河流二类水标准
	 */
	public void setRiverTwo(String riverTwo) {
		this.riverTwo = riverTwo;
	}
	/**
	 * 获取：河流二类水标准
	 */
	public String getRiverTwo() {
		return riverTwo;
	}
	/**
	 * 设置：河流三类水标准
	 */
	public void setRiverThree(String riverThree) {
		this.riverThree = riverThree;
	}
	/**
	 * 获取：河流三类水标准
	 */
	public String getRiverThree() {
		return riverThree;
	}
	/**
	 * 设置：河流四类水标准
	 */
	public void setRiverFour(String riverFour) {
		this.riverFour = riverFour;
	}
	/**
	 * 获取：河流四类水标准
	 */
	public String getRiverFour() {
		return riverFour;
	}
	/**
	 * 设置：河流五类水标准
	 */
	public void setRiverFive(String riverFive) {
		this.riverFive = riverFive;
	}
	/**
	 * 获取：河流五类水标准
	 */
	public String getRiverFive() {
		return riverFive;
	}
	/**
	 * 设置：湖泊一类水标准
	 */
	public void setLakeOne(String lakeOne) {
		this.lakeOne = lakeOne;
	}
	/**
	 * 获取：湖泊一类水标准
	 */
	public String getLakeOne() {
		return lakeOne;
	}
	/**
	 * 设置：湖泊二类水标准
	 */
	public void setLakeTwo(String lakeTwo) {
		this.lakeTwo = lakeTwo;
	}
	/**
	 * 获取：湖泊二类水标准
	 */
	public String getLakeTwo() {
		return lakeTwo;
	}
	/**
	 * 设置：湖泊三类水标准
	 */
	public void setLakeThree(String lakeThree) {
		this.lakeThree = lakeThree;
	}
	/**
	 * 获取：湖泊三类水标准
	 */
	public String getLakeThree() {
		return lakeThree;
	}
	/**
	 * 设置：湖泊四类水标准
	 */
	public void setLakeFour(String lakeFour) {
		this.lakeFour = lakeFour;
	}
	/**
	 * 获取：湖泊四类水标准
	 */
	public String getLakeFour() {
		return lakeFour;
	}
	/**
	 * 设置：湖泊五类水标准
	 */
	public void setLakeFive(String lakeFive) {
		this.lakeFive = lakeFive;
	}
	/**
	 * 获取：湖泊五类水标准
	 */
	public String getLakeFive() {
		return lakeFive;
	}
}
