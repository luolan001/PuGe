package com.yidu.surewin.system.domain;

/**
 * �����ʵ����
 * @author ����
 *
 */
public class Area {
	/**
	 * ����Id ����
	 */
	private String areaId;
	
	/**
	 * ʡ��
	 */
	private String province;
	
	/**
	 * ��
	 */
	private String city;
	
	/**
	 * ��
	 */
	private String county;
	/**
	 * ��������
	 */
	private String postCode;
	/**
	 * ����
	 */
	private String simpleCode;
	/**
	 * ���м���
	 */
	private String cityCode;
	/**
	 * ���۵�λId
	 */
	private String outPortId;
	/**
	 * ���۵�λ
	 */
	private String outPort;
	/**
	 * ��۵�λId
	 */
	private String inPortId;
	/**
	 * ��۵�λ
	 */
	private String inPort;
	/**
	 * �ɷ�����
	 */
	private String serciceArea;
	/**
	 * ���ɷ�����
	 */
	private String unserciceArea;
	/**
	 * �ر�����
	 */
	private String specialArea;
	/**
	 * ����
	 */
	private String outerNet;
	/**
	 * ����
	 */
	private String suburbs;
	/**
	 * ���򼶱�
	 */
	private String areaLevel;
	/**
	 * ��������
	 */
	private String zone;
	/**
	 * ���˳���
	 */
	private String cityLevel;
	/**
	 * ���ؿڰ�
	 */
	private String ports;
	/**
	 * ����/������
	 */
	private Boolean useable;
	/**
	 * ��ע
	 */
	private String description;
	/**
	 * �����ֶ�1
	 */
	private String remark1;
	/**
	 * �����ֶ�2
	 */
	private String remark2;

	/**
	 * Ĭ���޲ι��췽��
	 */
	public Area() {

	}
	
	/**
	 * �вεĹ��췽��
	 * @param areaId  ����ID
	 * @param province ʡ
	 * @param city ��
	 * @param county (��)��
	 * @param postCode  �ʱ�
	 * @param simpleCode ����
	 * @param cityCode  ���м���
	 * @param outPortId ���۵�λId
	 * @param outPort  ���۵�λ
	 * @param inPortId ��۵�λId
	 * @param inPort ��۵�λ
	 * @param serciceArea �ɷ�����
	 * @param unserciceArea ���ɷ�����
	 * @param specialArea �ر�����
	 * @param outerNet ����
	 * @param suburbs ����
	 * @param areaLevel ���򼶱�
	 * @param zone ��������
	 * @param cityLevel ���˳���
	 * @param ports ���ؿڰ�
	 * @param useable ����/������
	 * @param description ��ע
	 * @param remark1 �����ֶ�1
	 * @param remark2 �����ֶ�2
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
	 * ��ȡ����Id
	 * @return ��������Id
	 */
	public String getAreaId() {
		return areaId;
	}
	/**
	 * ������Id��ֵ
	 * @param regionId ����Id
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	/**
	 * ��ȡʡ
	 * @return ����ʡ province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * ��ʡ��ֵ
	 * @param province ʡ
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * ��ȡ��
	 * @return ������ city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * ���и�ֵ
	 * @param city ��
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * ��ȡ��(��) 
	 * @return ������(��) district
	 */
	public String getCounty() {
		return county;
	}
	/**
	 * ����(��)��ֵ
	 * @param district ��(��)
	 */
	public void setCounty(String county) {
		this.county = county;
	}
	/**
	 * ��ȡ�ʱ�
	 * @return �����ʱ� postcode
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * ���ʱำֵ 
	 * @param postcode �ʱ�
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	/**
	 * ��ȡ����
	 * @return ���ؼ��� simpleCode
	 */
	public String getSimpleCode() {
		return simpleCode;
	}
	/**
	 * �����븳ֵ
	 * @param simpleCode ����
	 */
	public void setSimpleCode(String simpleCode) {
		this.simpleCode = simpleCode;
	}
	/**
	 * ��ȡ���б���
	 * @return ���س��б��� citycode
	 */
	public String getCityCode() {
		return cityCode;
	}
	/**
	 * �����б��븳ֵ
	 * @param citycode ���б���
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	/**
	 * ��ȡ���۵�λId
	 * @return ���س��۵�λId outPortId
	 */
	public String getOutPortId() {
		return outPortId;
	}
	/**
	 * �����۵�λId��ֵ
	 * @param outPortId ���۵�λId
	 */
	public void setOutPortId(String outPortId) {
		this.outPortId = outPortId;
	}
	/**
	 * ��ȡ���۵�λ
	 * @return ���س��۵�λ outPort
	 */
	public String getOutPort() {
		return outPort;
	}
	/**
	 * �����۵�λ��ֵ
	 * @param outPort ���۵�λ
	 */
	public void setOutPort(String outPort) {
		this.outPort = outPort;
	}
	/**
	 * ��ȡ��۵�λId
	 * @return ������۵�λId inPortId
	 */
	public String getInPortId() {
		return inPortId;
	}
	/**
	 * ����۵�λId��ֵ
	 * @param inPortId ��۵�λId
	 */
	public void setInPortId(String inPortId) {
		this.inPortId = inPortId;
	}
	/**
	 * ��ȡ��۵�λ
	 * @return ������۵�λ inPort
	 */
	public String getInPort() {
		return inPort;
	}
	/**
	 * ����۵�λ��ֵ
	 * @param inPort ��۵�λ
	 */
	public void setInPort(String inPort) {
		this.inPort = inPort;
	}
	/**
	 * ��ȡ�ɷ�����
	 * @return ���ؿɷ����� serciceArea
	 */
	public String getSerciceArea() {
		return serciceArea;
	}
	/**
	 * ���ɷ�������ֵ
	 * @param serciceArea �ɷ�����
	 */
	public void setSerciceArea(String serciceArea) {
		this.serciceArea = serciceArea;
	}
	/**
	 * ��ȡ���ɷ�����
	 * @return ���ز��ɷ����� unserciceArea
	 */
	public String getUnserciceArea() {
		return unserciceArea;
	}
	/**
	 * �����ɷ�������ֵ
	 * @param unserciceArea ���ɷ�����
	 */
	public void setUnserciceArea(String unserciceArea) {
		this.unserciceArea = unserciceArea;
	}
	/**
	 * ��ȡ�ر�����
	 * @return �����ر����� specialArea
	 */
	public String getSpecialArea() {
		return specialArea;
	}
	/**
	 * ���ر�����ֵ
	 * @param specialArea �ر�����
	 */
	public void setSpecialArea(String specialArea) {
		this.specialArea = specialArea;
	}
	/**
	 * ��ȡ����
	 * @return �������� outerNet
	 */
	public String getOuterNet() {
		return outerNet;
	}
	/**
	 * ��������ֵ
	 * @param outerNet ����
	 */
	public void setOuterNet(String outerNet) {
		this.outerNet = outerNet;
	}
	/**
	 * ��ȡ����
	 * @return ���ؽ��� suburbs
	 */
	public String getSuburbs() {
		return suburbs;
	}
	/**
	 * ��������ֵ
	 * @param suburbs ����
	 */
	public void setSuburbs(String suburbs) {
		this.suburbs = suburbs;
	}
	/**
	 * ��ȡ���򼶱�
	 * @return �������򼶱� areaLevel
	 */
	public String getAreaLevel() {
		return areaLevel;
	}
	/**
	 * �����򼶱�ֵ
	 * @param areaLevel ���򼶱�
	 */
	public void setAreaLevel(String areaLevel) {
		this.areaLevel = areaLevel;
	}
	/**
	 * ��ȡ��������
	 * @return ������������ zone
	 */
	public String getZone() {
		return zone;
	}
	/**
	 * ����������ֵ
	 * @param zone ��������
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}
	/**
	 * ��ȡ���˳���
	 * @return �������Ƴ��� cityLevel
	 */
	public String getCityLevel() {
		return cityLevel;
	}
	/**
	 * �����Ƴ��и�ֵ
	 * @param cityLevel ���Ƴ���
	 */
	public void setCityLevel(String cityLevel) {
		this.cityLevel = cityLevel;
	}
	/**
	 * ��ȡ���ؿڰ�
	 * @return ���غ��ؿڰ� ports
	 */
	public String getPorts() {
		return ports;
	}
	/**
	 * �����ؿڰ���ֵ
	 * @param ports ���ؿڰ�
	 */
	public void setPorts(String ports) {
		this.ports = ports;
	}
	/**
	 * ��ȡ����/������
	 * @return ���ؿ���/������ useable
	 */
	public Boolean getUseable() {
		return useable;
	}
	/**
	 * ������/�����ø�ֵ
	 * @param useable ����/������
	 */
	public void setUseable(Boolean useable) {
		this.useable = useable;
	}
	/**
	 * ��ȡ��ע
	 * @return ���ر�ע description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * ����ע��ֵ
	 * @param useable ��ע
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * ��ȡ�����ֶ�1
	 * @return ���ر����ֶ�1 remark1
	 */
	public String getRemark1() {
		return remark1;
	}
	/**
	 * �������ֶ�1��ֵ
	 * @param remark1 �����ֶ�1
	 */
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	/**
	 * ��ȡ�����ֶ�2
	 * @return ���ر����ֶ�2 remark2
	 */
	public String getRemark2() {
		return remark2;
	}
	/**
	 * �������ֶ�2��ֵ
	 * @param remark2 �����ֶ�2
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	/**
	 * ��дtoString�ķ���
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