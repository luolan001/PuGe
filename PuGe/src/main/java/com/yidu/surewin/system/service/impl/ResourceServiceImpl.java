package com.yidu.surewin.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.surewin.system.dao.ResourceDao;
import com.yidu.surewin.system.domain.Resource;
import com.yidu.surewin.system.service.ResourceService;
@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceDao resourceDao;
	
	public ResourceServiceImpl(){
		
	}
	
	public ResourceServiceImpl(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	@Override
	public List<Resource> findAll(Map<String, Object> paramMap) {
		List<Resource> resoureList = resourceDao.findAll(paramMap);
		return resoureList;
	}

	@Override
	public boolean deleteUseableTx(String resourceId) {
		int num = resourceDao.deleteUseableTx(resourceId);
		if(num >=1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean enableUseableTx(String resourceId) {
		int num = resourceDao.enableUseableTx(resourceId);
		if(num >=1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String findresourceId(String parentResourceName) {
		return resourceDao.findResourceId(parentResourceName);
	}

	@Override
	public boolean updateParentIdTx(Resource resource) {
		int num = resourceDao.updateParentIdTx(resource);
		if(num >=1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<Resource> findQueryResource() {
		return resourceDao.findQueryResource();
	}

	@Override
	public List<Resource> findRoleResourceWithRoleId(String roleId) {
		return resourceDao.findRoleResourceWithRoleId(roleId);
	}
}
