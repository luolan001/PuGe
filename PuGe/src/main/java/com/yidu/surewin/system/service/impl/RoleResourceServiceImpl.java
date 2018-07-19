package com.yidu.surewin.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.surewin.system.dao.RoleResourceDao;
import com.yidu.surewin.system.domain.RoleResource;
import com.yidu.surewin.system.service.RoleResourceService;
@Service
public class RoleResourceServiceImpl implements RoleResourceService {

	@Autowired
	private RoleResourceDao roleResourceDao;
	
	public RoleResourceServiceImpl(){
		
	}
	
	public RoleResourceServiceImpl(RoleResourceDao roleResourceDao) {
		this.roleResourceDao = roleResourceDao;
	}


	@Override
	public int addRoleResourceTx(RoleResource roleResource) {
		return roleResourceDao.addRoleResourceTx(roleResource);
	}

	@Override
	public int deleteRoleResourceTx(String roleResourceId) {
		return roleResourceDao.deleteRoleResourceTx(roleResourceId);
	}

	@Override
	public int updateRoleResourceTx(RoleResource roleResource) {
		return roleResourceDao.updateRoleResourceTx(roleResource);
	}

	@Override
	public List<RoleResource> roleResourcePageQuery(Map<String, Object> map) {
		return roleResourceDao.roleResourcePageQuery(map);
	}

	@Override
	public int findRoleResourceQueryCount(Map<String, Object> map) {
		return roleResourceDao.findRoleResourceQueryCount(map);
	}

	@Override
	public String findResourceParentId(String resourceId) {
		return roleResourceDao.findResourceParentId(resourceId);
	}

	@Override
	public int deleteRoleResourceWithRoleIdTx(String roleId) {
		return roleResourceDao.deleteRoleResourceWithRoleIdTx(roleId);
	}

}
