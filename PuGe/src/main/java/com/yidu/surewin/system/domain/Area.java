package com.yidu.surewin.system.domain;

/**
 * 区域表实体类
 * @author 陈昭
 *
 */
public class Area {
	/**
	 * 区域Id 主键
	 */
	private String areaId;
	
	/**
	 * 省份
	 */
	private String province;
	
	/**
	 * 市
	 */
	private String city;
	
	/**
	 * 县
	 */
	private String county;
	/**
	 * 邮政编码
	 */
	private String postCode;
	/**
	 * 简码
	 */
	private String simpleCode;
	/**
	 * 城市简码
	 */
	private String cityCode;
	/**
	 * 出港单位Id
	 */
	private String outPortId;
	/**
	 * 出港单位
	 */
	private String outPort;
	/**
	 * 入港单位Id
	 */
	private String inPortId;
	/**
	 * 入港单位
	 */
	private String inPort;
	/**
	 * 可服务区
	 */
	private String serciceArea;
	/**
	 * 不可服务区
	 */
	private String unserciceArea;
	/**
	 * 特别区域
	 */
	private String specialArea;
	/**
	 * 外网
	 */
	private String outerNet;
	/**
	 * 郊区
	 */
	private String suburbs;
	/**
	 * 区域级别
	 */
	private String areaLevel;
	/**
	 * 所属区域
	 */
	private String zone;
	/**
	 * 普运城市
	 */
	private String cityLevel;
	/**
	 * 海关口岸
	 */
	private String ports;
	/**
	 * 可用/不可用
	 */
	private Boolean useable;
	/**
	 * 备注
	 */
	private String description;
	/**
	 * 备用字段1
	 */
	private String remark1;
	/**
	 * 备用字段2
	 */
	private String remark2;

	/**
	 * 默认无参构造方法
	 */
	public Area() {

	}
	
	/**
	 * 有参的构造方法
	 * @param areaId  区域ID
	 * @param province 省
	 * @param city 市
	 * @param county (区)县
	 * @param postCode  邮编
	 * @param simpleCode 简码
	 * @param cityCode  城市简码
	 * @param outPortId 出港单位Id
	 * @param outPort  出港单位
	 * @param inPortId 入港单位Id
	 * @param inPort 入港单位
	 * @param serciceArea 可服务区
	 * @param unserciceArea 不可服务区
	 * @param specialArea 特别区域
	 * @param outerNet 外网
	 * @param suburbs 郊区
	 * @param areaLevel 区域级别
	 * @param zone 所属区域
	 * @param cityLevel 普运城市
	 * @param ports 海关口岸
	 * @param useable 可用/不可用
	 * @param description 备注
	 * @param remark1 备用字段1
	 * @param remark2 备用字段2
	 */
	public Area(String areaId, String province, String city, String county, String postCode, String simpleCode,
			String cityCode, String outPortId, String outPort, String inPortId, String inPort, String serciceArea,
			String unserciceArea, String specialArea, String outerNet, String suburbs, String areaLevel, String zone,
			String cityLevel, String ports, Boolean useable, String description, String remark1, String remark2) {
		super();
		this.areaId = areaId;
		this.province = province;
		this.city = city;
		this.county = county;
		this.postCode = postCode;
		this.simpleCode = simpleCode;
		this.cityCode = cityCode;
		this.outPortId = outPortId;
		this.outPort = outPort;
		this.inPortId = inPortId;
		this.inPort = inPort;
		this.serciceArea = serciceArea;
		this.unserciceArea = unserciceArea;
		this.specialArea = specialArea;
		this.outerNet = outerNet;
		this.suburbs = suburbs;
		this.areaLevel = areaLevel;
		this.zone = zone;
		this.cityLevel = cityLevel;
		this.ports = ports;
		this.useable = useable;
		this.description = description;
		this.remark1 = remark1;
		this.remark2 = remark2;
	}

	/**
	 * 获取区域Id
	 * @return 返回区域Id
	 */
	public String getAreaId() {
		return areaId;
	}
	/**
	 * 给区域Id赋值
	 * @param regionId 区域Id
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	/**
	 * 获取省
	 * @return 返回省 province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 给省赋值
	 * @param province 省
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取市
	 * @return 返回市 city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 给市赋值
	 * @param city 市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取区(县) 
	 * @return 返回区(县) district
	 */
	public String getCounty() {
		return county;
	}
	/**
	 * 给区(县)赋值
	 * @param district 区(县)
	 */
	public void setCounty(String county) {
		this.county = county;
	}
	/**
	 * 获取邮编
	 * @return 返回邮编 postcode
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 给邮编赋值 
	 * @param postcode 邮编
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	/**
	 * 获取简码
	 * @return 返回简码 simpleCode
	 */
	public String getSimpleCode() {
		return simpleCode;
	}
	/**
	 * 给简码赋值
	 * @param simpleCode 简码
	 */
	public void setSimpleCode(String simpleCode) {
		this.simpleCode = simpleCode;
	}
	/**
	 * 获取城市编码
	 * @return 返回城市编码 citycode
	 */
	public String getCityCode() {
		return cityCode;
	}
	/**
	 * 给城市编码赋值
	 * @param citycode 城市编码
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	/**
	 * 获取出港单位Id
	 * @return 返回出港单位Id outPortId
	 */
	public String getOutPortId() {
		return outPortId;
	}
	/**
	 * 给出港单位Id赋值
	 * @param outPortId 出港单位Id
	 */
	public void setOutPortId(String outPortId) {
		this.outPortId = outPortId;
	}
	/**
	 * 获取出港单位
	 * @return 返回出港单位 outPort
	 */
	public String getOutPort() {
		return outPort;
	}
	/**
	 * 给出港单位赋值
	 * @param outPort 出港单位
	 */
	public void setOutPort(String outPort) {
		this.outPort = outPort;
	}
	/**
	 * 获取入港单位Id
	 * @return 返回入港单位Id inPortId
	 */
	public String getInPortId() {
		return inPortId;
	}
	/**
	 * 给入港单位Id赋值
	 * @param inPortId 入港单位Id
	 */
	public void setInPortId(String inPortId) {
		this.inPortId = inPortId;
	}
	/**
	 * 获取入港单位
	 * @return 返回入港单位 inPort
	 */
	public String getInPort() {
		return inPort;
	}
	/**
	 * 给入港单位赋值
	 * @param inPort 入港单位
	 */
	public void setInPort(String inPort) {
		this.inPort = inPort;
	}
	/**
	 * 获取可服务区
	 * @return 返回可服务区 serciceArea
	 */
	public String getSerciceArea() {
		return serciceArea;
	}
	/**
	 * 给可服务区赋值
	 * @param serciceArea 可服务区
	 */
	public void setSerciceArea(String serciceArea) {
		this.serciceArea = serciceArea;
	}
	/**
	 * 获取不可服务区
	 * @return 返回不可服务区 unserciceArea
	 */
	public String getUnserciceArea() {
		return unserciceArea;
	}
	/**
	 * 给不可服务区赋值
	 * @param unserciceArea 不可服务区
	 */
	public void setUnserciceArea(String unserciceArea) {
		this.unserciceArea = unserciceArea;
	}
	/**
	 * 获取特别区域
	 * @return 返回特别区域 specialArea
	 */
	public String getSpecialArea() {
		return specialArea;
	}
	/**
	 * 给特别区域赋值
	 * @param specialArea 特别区域
	 */
	public void setSpecialArea(String specialArea) {
		this.specialArea = specialArea;
	}
	/**
	 * 获取外网
	 * @return 返回外网 outerNet
	 */
	public String getOuterNet() {
		return outerNet;
	}
	/**
	 * 给外网赋值
	 * @param outerNet 外网
	 */
	public void setOuterNet(String outerNet) {
		this.outerNet = outerNet;
	}
	/**
	 * 获取郊区
	 * @return 返回郊区 suburbs
	 */
	public String getSuburbs() {
		return suburbs;
	}
	/**
	 * 给郊区赋值
	 * @param suburbs 郊区
	 */
	public void setSuburbs(String suburbs) {
		this.suburbs = suburbs;
	}
	/**
	 * 获取区域级别
	 * @return 返回区域级别 areaLevel
	 */
	public String getAreaLevel() {
		return areaLevel;
	}
	/**
	 * 给区域级别赋值
	 * @param areaLevel 区域级别
	 */
	public void setAreaLevel(String areaLevel) {
		this.areaLevel = areaLevel;
	}
	/**
	 * 获取所属区域
	 * @return 返回所属区域 zone
	 */
	public String getZone() {
		return zone;
	}
	/**
	 * 给所属区域赋值
	 * @param zone 所属区域
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}
	/**
	 * 获取普运城市
	 * @return 返回普云城市 cityLevel
	 */
	public String getCityLevel() {
		return cityLevel;
	}
	/**
	 * 给普云城市赋值
	 * @param cityLevel 普云城市
	 */
	public void setCityLevel(String cityLevel) {
		this.cityLevel = cityLevel;
	}
	/**
	 * 获取海关口岸
	 * @return 返回海关口岸 ports
	 */
	public String getPorts() {
		return ports;
	}
	/**
	 * 给海关口岸赋值
	 * @param ports 海关口岸
	 */
	public void setPorts(String ports) {
		this.ports = ports;
	}
	/**
	 * 获取可用/不可用
	 * @return 返回可用/不可用 useable
	 */
	public Boolean getUseable() {
		return useable;
	}
	/**
	 * 给可用/不可用赋值
	 * @param useable 可用/不可用
	 */
	public void setUseable(Boolean useable) {
		this.useable = useable;
	}
	/**
	 * 获取备注
	 * @return 返回备注 description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 给备注赋值
	 * @param useable 备注
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取备用字段1
	 * @return 返回备用字段1 remark1
	 */
	public String getRemark1() {
		return remark1;
	}
	/**
	 * 给备用字段1赋值
	 * @param remark1 备用字段1
	 */
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	/**
	 * 获取备用字段2
	 * @return 返回备用字段2 remark2
	 */
	public String getRemark2() {
		return remark2;
	}
	/**
	 * 给备用字段2赋值
	 * @param remark2 备用字段2
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	/**
	 * 重写toString的方法
	 */
	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", province=" + province + ", city=" + city + ", county=" + county
				+ ", postCode=" + postCode + ", simpleCode=" + simpleCode + ", cityCode=" + cityCode + ", outPortId="
				+ outPortId + ", outPort=" + outPort + ", inPortId=" + inPortId + ", inPort=" + inPort
				+ ", serciceArea=" + serciceArea + ", unserciceArea=" + unserciceArea + ", specialArea=" + specialArea
				+ ", outerNet=" + outerNet + ", suburbs=" + suburbs + ", areaLevel=" + areaLevel + ", zone=" + zone
				+ ", cityLevel=" + cityLevel + ", ports=" + ports + ", useable=" + useable + ", description="
				+ description + ", remark1=" + remark1 + ", remark2=" + remark2 + "]";
	}
	
}