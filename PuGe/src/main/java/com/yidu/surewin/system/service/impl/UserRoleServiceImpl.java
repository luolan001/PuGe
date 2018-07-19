package com.yidu.surewin.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.surewin.system.dao.UserRoleDao;
import com.yidu.surewin.system.domain.UserRole;
import com.yidu.surewin.system.service.UserRoleService;
@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;
	
	public UserRoleServiceImpl(){
		
	}
	
	public UserRoleServiceImpl(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	@Override
	public int addUserRoleTx(UserRole UserRole) {
		return userRoleDao.addUserRoleTx(UserRole);
	}

	@Override
	public int deleteUserRoleTx(String userRoleId) {
		return userRoleDao.deleteUserRoleTx(userRoleId);
	}

	@Override
	public int updateUserRoleTx(UserRole userRole) {
		return userRoleDao.updateUserRoleTx(userRole);
	}

	@Override
	public List<UserRole> userRolePageQuery(Map<String, Object> map) {
		return userRoleDao.userRolePageQuery(map);
	}

	@Override
	public int findUserRoleQueryCount(Map<String, Object> map) {
		return userRoleDao.findUserRoleQueryCount(map);
	}
}
