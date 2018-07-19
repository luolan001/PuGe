package com.yidu.surewin.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.surewin.system.dao.RoleDao;
import com.yidu.surewin.system.domain.Role;
import com.yidu.surewin.system.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	public RoleServiceImpl(){
		
	}
	
	public RoleServiceImpl(RoleDao roleDao) {
		this.roleDao = roleDao;
	}


	@Override
	public int addRoleTx(Role role) {
		return roleDao.addRoleTx(role);
	}

	@Override
	public int deleteRoleTx(String roleId) {
		return roleDao.deleteRoleTx(roleId);
	}

	@Override
	public int updateRoleTx(Role role) {
		return roleDao.updateRoleTx(role);
	}

	@Override
	public List<Role> RolePageQuery(Map<String, Object> map) {
		return roleDao.RolePageQuery(map);
	}

	@Override
	public int findRoleQueryCount(Map<String, Object> map) {
		return roleDao.findRoleQueryCount(map);
	}

}
