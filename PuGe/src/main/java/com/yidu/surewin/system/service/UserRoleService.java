package com.yidu.surewin.system.service;

import java.util.List;
import java.util.Map;

import com.yidu.surewin.system.domain.UserRole;

public interface UserRoleService {
int addUserRoleTx(UserRole UserRole);
	
	int deleteUserRoleTx(String userRoleId);
	
	int updateUserRoleTx(UserRole userRole);
	
	List<UserRole> userRolePageQuery(Map<String, Object> map);
	
	int findUserRoleQueryCount(Map<String, Object> map);
}
