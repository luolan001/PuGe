package com.yidu.surewin.system.domain;

import java.io.Serializable;

/**
 * 角色资源表
 * @author Administrator
 *
 */
public class RoleResource implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1927286470010909870L;
	
	private String roleResourceId;
	private String resourceId;
	private String roleId;
	private String description;
	private String remark1;
	
	public RoleResource(){
		
	}

	public RoleResource(String roleResourceId, String resourceId, String roleId, String description, String remark1) {
		this.roleResourceId = roleResourceId;
		this.resourceId = resourceId;
		this.roleId = roleId;
		this.description = description;
		this.remark1 = remark1;
	}

	public String getRoleResourceId() {
		return roleResourceId;
	}

	public void setRoleResourceId(String roleResourceId) {
		this.roleResourceId = roleResourceId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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

	@Override
	public String toString() {
		return "RoleResource [roleResourceId=" + roleResourceId + ", resourceId=" + resourceId + ", roleId=" + roleId
				+ ", description=" + description + ", remark1=" + remark1 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((remark1 == null) ? 0 : remark1.hashCode());
		result = prime * result + ((resourceId == null) ? 0 : resourceId.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((roleResourceId == null) ? 0 : roleResourceId.hashCode());
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
		RoleResource other = (RoleResource) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (remark1 == null) {
			if (other.remark1 != null)
				return false;
		} else if (!remark1.equals(other.remark1))
			return false;
		if (resourceId == null) {
			if (other.resourceId != null)
				return false;
		} else if (!resourceId.equals(other.resourceId))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (roleResourceId == null) {
			if (other.roleResourceId != null)
				return false;
		} else if (!roleResourceId.equals(other.roleResourceId))
			return false;
		return true;
	}
}
