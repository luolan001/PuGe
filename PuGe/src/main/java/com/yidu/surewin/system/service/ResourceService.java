package com.yidu.surewin.system.service;

import java.util.List;
import java.util.Map;

import com.yidu.surewin.system.domain.Resource;

public interface ResourceService {
	public String findresourceId(String parentResourceName);
	
	public List<Resource> findAll(Map<String, Object> paramMap);
	
	public boolean deleteUseableTx(String resourceId);
	
	public boolean enableUseableTx(String resourceId);
	
	public boolean updateParentIdTx(Resource resource);
	
	List<Resource> findQueryResource();

	List<Resource> findRoleResourceWithRoleId(String roleId);
	
}
