package com.yidu.surewin.system.dao;

import java.util.List;
import java.util.Map;

import com.yidu.surewin.system.domain.Role;

public interface RoleDao {
	public int addRoleTx(Role role);
	public int deleteRoleTx(String roleId);
	public int updateRoleTx(Role role);
	public List<Role> RolePageQuery(Map<String,Object> map);
	public int findRoleQueryCount(Map<String,Object> map);
	
}
