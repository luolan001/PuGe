package com.yidu.surewin.system.dao;

import java.util.List;
import java.util.Map;

import com.yidu.surewin.system.domain.RoleResource;

public interface RoleResourceDao {
	int addRoleResourceTx(RoleResource roleResource);
	
	int deleteRoleResourceTx(String roleResourceId);
	
	int updateRoleResourceTx(RoleResource roleResource);
	
	List<RoleResource> roleResourcePageQuery(Map<String, Object> map);
	
	int findRoleResourceQueryCount(Map<String, Object> map);
	
	String findResourceParentId(String resourceId);
	
	int deleteRoleResourceWithRoleIdTx(String roleId);
}
