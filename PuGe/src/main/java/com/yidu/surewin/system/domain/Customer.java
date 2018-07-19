package com.yidu.surewin.system.domain;
/**
 * 实体类 客户表
 * @author 刘欢
 * 日期：2018-7-5
 */
public class Customer {
	/**
	 * 客户id
	 */
	private String customerId;
	
	/**
	 * 客户编号
	 */
	private String customerNo;
	
	/**
	 * 联系人
	 */
	private String connectMan;
	
	/**
	 * 联系人手机号
	 */
	private String connectPhone;
	
	/**
	 * 联系人地址
	 */
	private String connectAddress;
	
	/**
	 * 客户名
	 */
	private String customerName;
	
	/**
	 *  客户手机号
	 */
	private String phoneNumber;
	
	/**
	 * 客户地址
	 */
	private String address;
	
	/**
	 * 是否可用 y:可用 n:不可用
	 */
	private String useable;
	
	/**
	 * 描述
	 */
	private String description;

	/**
	 * 默认构造方法
	 */
	public Customer(){}

	/**
	 * 带参构造方法
	 * @param customerId 客户id
	 * @param customerNo 客户编号
	 * @param connectMan 联系人
	 * @param connectPhone 联系人手机号
	 * @param connectAddress联系人地址
	 * @param customerName 客户名
	 * @param phoneNumber 客户手机号
	 * @param address 客户地址
	 * @param useable  是否可用 y:可用 n:不可用
	 * @param description 描述
	 */
	public Customer(String customerId, String customerNo, String connectMan, String connectPhone, String connectAddress,
			String customerName, String phoneNumber, String address, String useable, String description) {
		super();
		this.customerId = customerId;
		this.customerNo = customerNo;
		this.connectMan = connectMan;
		this.connectPhone = connectPhone;
		this.connectAddress = connectAddress;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.useable = useable;
		this.description = description;
	}

	//自动生成set/get
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getConnectMan() {
		return connectMan;
	}

	public void setConnectMan(String connectMan) {
		this.connectMan = connectMan;
	}

	public String getConnectPhone() {
		return connectPhone;
	}

	public void setConnectPhone(String connectPhone) {
		this.connectPhone = connectPhone;
	}

	public String getConnectAddress() {
		return connectAddress;
	}

	public void setConnectAddress(String connectAddress) {
		this.connectAddress = connectAddress;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUseable() {
		return useable;
	}

	public void setUseable(String useable) {
		this.useable = useable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((connectAddress == null) ? 0 : connectAddress.hashCode());
		result = prime * result + ((connectMan == null) ? 0 : connectMan.hashCode());
		result = prime * result + ((connectPhone == null) ? 0 : connectPhone.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customerNo == null) ? 0 : customerNo.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((useable == null) ? 0 : useable.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (connectAddress == null) {
			if (other.connectAddress != null)
				return false;
		} else if (!connectAddress.equals(other.connectAddress))
			return false;
		if (connectMan == null) {
			if (other.connectMan != null)
				return false;
		} else if (!connectMan.equals(other.connectMan))
			return false;
		if (connectPhone == null) {
			if (other.connectPhone != null)
				return false;
		} else if (!connectPhone.equals(other.connectPhone))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerNo == null) {
			if (other.customerNo != null)
				return false;
		} else if (!customerNo.equals(other.customerNo))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (useable == null) {
			if (other.useable != null)
				return false;
		} else if (!useable.equals(other.useable))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerNo=" + customerNo + ", connectMan=" + connectMan
				+ ", connectPhone=" + connectPhone + ", connectAddress=" + connectAddress + ", customerName="
				+ customerName + ", phoneNumber=" + phoneNumber + ", address=" + address + ", useable=" + useable
				+ ", description=" + description + "]";
	}
	
	
}
