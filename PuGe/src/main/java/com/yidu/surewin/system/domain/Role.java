package com.yidu.surewin.system.domain;

import java.io.Serializable;

public class Role implements Serializable {
	
	/**
	 * –Ú¡–∫≈
	 */
	private static final long serialVersionUID = 5042592116106166355L;
	
	private String roleId;
	private String roleName;
	private String keyword;
	private String organizationTypeId;
	private String organizationTypeName;
	private String description;
	private String remark1;
	private String remark2;
	
	public Role(){
		
	}

	public Role(String roleId, String roleName, String keyword, String organizationTypeId, String organizationTypeName,
			String description, String remark1, String remark2) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.keyword = keyword;
		this.organizationTypeId = organizationTypeId;
		this.organizationTypeName = organizationTypeName;
		this.description = description;
		this.remark1 = remark1;
		this.remark2 = remark2;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getOrganizationTypeId() {
		return organizationTypeId;
	}

	public void setOrganizationTypeId(String organizationTypeId) {
		this.organizationTypeId = organizationTypeId;
	}

	public String getOrganizationTypeName() {
		return organizationTypeName;
	}

	public void setOrganizationTypeName(String organizationTypeName) {
		this.organizationTypeName = organizationTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", keyword=" + keyword + ", organizationTypeId="
				+ organizationTypeId + ", organizationTypeName=" + organizationTypeName + ", description=" + description
				+ ", remark1=" + remark1 + ", remark2=" + remark2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result + ((organizationTypeId == null) ? 0 : organizationTypeId.hashCode());
		result = prime * result + ((organizationTypeName == null) ? 0 : organizationTypeName.hashCode());
		result = prime * result + ((remark1 == null) ? 0 : remark1.hashCode());
		result = prime * result + ((remark2 == null) ? 0 : remark2.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
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
		Role other = (Role) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		if (organizationTypeId == null) {
			if (other.organizationTypeId != null)
				return false;
		} else if (!organizationTypeId.equals(other.organizationTypeId))
			return false;
		if (organizationTypeName == null) {
			if (other.organizationTypeName != null)
				return false;
		} else if (!organizationTypeName.equals(other.organizationTypeName))
			return false;
		if (remark1 == null) {
			if (other.remark1 != null)
				return false;
		} else if (!remark1.equals(other.remark1))
			return false;
		if (remark2 == null) {
			if (other.remark2 != null)
				return false;
		} else if (!remark2.equals(other.remark2))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}
	
}
