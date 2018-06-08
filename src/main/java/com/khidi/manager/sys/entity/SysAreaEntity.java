package com.khidi.manager.sys.entity;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 行政区划
 * 
 * @author shudewei
 * @email 53725025@qq.com
 * @date 2017-10-20 15:23:47
 */
@ApiModel
public class SysAreaEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	//编码
	@ApiModelProperty(value = "系统编码", required = false,hidden=false)
	private String areaId;


	//行政区域编码
	@ApiModelProperty(value = "行政区域编码", required = true,hidden=false)
	private String Id;


	//行政区域ID，一级部门为0
	@ApiModelProperty(value = "父节点id", required = true,hidden=false)
	private String parentId;


	//行政区域名称
	@ApiModelProperty(value = "行政区域名称", required = true,hidden=false)
	private String name;


	//上级行政区域名称
	@ApiModelProperty(value = "上级行政区域名称", required = false,hidden=true)
	private String parentName;


	//排序
	@ApiModelProperty(value = "排序", required = true,hidden=false,example="1")
	private Integer orderNum;


	//土地面积(km²)
	@ApiModelProperty(value = "土地面积(km²)",dataType="String",required = false,hidden = false)
	private String landArea;


	//耕地面积（km²）
	@ApiModelProperty(value = "耕地面积（km²）",dataType="String",required = false,hidden = false)
	private String cultivatedArea;

	//总人口（人）
	@ApiModelProperty(value = "总人口（人）",dataType="String",required = false,hidden = false)
	private String sumPeople;

	//家庭户数（户）
	@ApiModelProperty(value = "家庭户数（户）",dataType="String",required = false,hidden = false)
	private String sumFamily;

	//房间数（间）
	@ApiModelProperty(value = "房间数（间）",dataType="String",required = false,hidden = false)
	private String sumHouse;

	//经度（度）
	@ApiModelProperty(value = "经度（度）",dataType="String",required = false,hidden = false)
	private String areaX;

	//纬度（度）
	@ApiModelProperty(value = "纬度（度）",dataType="String",required = false,hidden = false)
	private String areaY;

	//自然村总数（个）
	@ApiModelProperty(value = "自然村总数（个）",dataType="String",required = false,hidden = false)
	private String sumVillage;

	//权重
	@ApiModelProperty(value = "权重",dataType="String",required = false,hidden = false)
	private String weight;

	//面积(km²)
	@ApiModelProperty(value = "面积(km²)",dataType="String",required = false,hidden = false)
	private String areaArea;

	//备注
	@ApiModelProperty(value = "备注",dataType="String",required = false,hidden = false)
	private String remark;


	/**
	 * ztree属性
	 */
	@ApiModelProperty(value = "树节点是否展开", required = false,hidden=true,example="100")
	private Boolean open;

	@ApiModelProperty(value = "行政区域的子节点", required = false,hidden=true)	
	private List<?> list;
	
	@ApiModelProperty(value = "是否删除", required = false,hidden=true)
	private int delFlag;

	public int getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	/**
	 * 设置：上级部门ID，一级部门为0
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：上级部门ID，一级部门为0
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * 设置：部门名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：部门名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrderNum() {
		return orderNum;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}


	/**
	 * 设置：土地面积(km²)
	 */
	public void setLandArea(String landArea) {
		this.landArea = landArea;
	}
	/**
	 * 获取：土地面积(km²)
	 */
	public String getLandArea() {
		return landArea;
	}
	/**
	 * 设置：耕地面积（km²）
	 */
	public void setCultivatedArea(String cultivatedArea) {
		this.cultivatedArea = cultivatedArea;
	}
	/**
	 * 获取：耕地面积（km²）
	 */
	public String getCultivatedArea() {
		return cultivatedArea;
	}
	/**
	 * 设置：总人口（人）
	 */
	public void setSumPeople(String sumPeople) {
		this.sumPeople = sumPeople;
	}
	/**
	 * 获取：总人口（人）
	 */
	public String getSumPeople() {
		return sumPeople;
	}
	/**
	 * 设置：家庭户数（户）
	 */
	public void setSumFamily(String sumFamily) {
		this.sumFamily = sumFamily;
	}
	/**
	 * 获取：家庭户数（户）
	 */
	public String getSumFamily() {
		return sumFamily;
	}
	/**
	 * 设置：房间数（间）
	 */
	public void setSumHouse(String sumHouse) {
		this.sumHouse = sumHouse;
	}
	/**
	 * 获取：房间数（间）
	 */
	public String getSumHouse() {
		return sumHouse;
	}
	/**
	 * 设置：经度（度）
	 */
	public void setAreaX(String areaX) {
		this.areaX = areaX;
	}
	/**
	 * 获取：经度（度）
	 */
	public String getAreaX() {
		return areaX;
	}
	/**
	 * 设置：纬度（度）
	 */
	public void setAreaY(String areaY) {
		this.areaY = areaY;
	}
	/**
	 * 获取：纬度（度）
	 */
	public String getAreaY() {
		return areaY;
	}
	/**
	 * 设置：自然村总数（个）
	 */
	public void setSumVillage(String sumVillage) {
		this.sumVillage = sumVillage;
	}
	/**
	 * 获取：自然村总数（个）
	 */
	public String getSumVillage() {
		return sumVillage;
	}
	/**
	 * 设置：权重
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	/**
	 * 获取：权重
	 */
	public String getWeight() {
		return weight;
	}
	/**
	 * 设置：面积(km²)
	 */
	public void setAreaArea(String areaArea) {
		this.areaArea = areaArea;
	}
	/**
	 * 获取：面积(km²)
	 */
	public String getAreaArea() {
		return areaArea;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SysAreaEntity sysAreaEntity = (SysAreaEntity) o;

		if (!areaId.equals(sysAreaEntity.areaId)) return false;
		return areaId.equals(sysAreaEntity.areaId);

	}
	@Override
	public int hashCode() {
		int re = areaId.hashCode();
		re = 31 * re + areaId.hashCode();
		return re;
	}

}
