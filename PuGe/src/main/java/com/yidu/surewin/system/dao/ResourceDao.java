package com.yidu.surewin.system.dao;

import java.util.List;
import java.util.Map;

import com.yidu.surewin.system.domain.Resource;


public interface ResourceDao {
	
	/**
	 * 
	 * @param paramMap
	 * @return
	 */
	 
	public String findResourceId(String parentResourceName);
	 
	public List<Resource> findAll(Map<String, Object> paramMap);
	
	public int deleteUseableTx(String resourceId);
	
	public int enableUseableTx(String resourceId);
	
	public int updateParentIdTx(Resource resource);
	
	List<Resource> findQueryResource();
	
	List<Resource> findRoleResourceWithRoleId(String roleId);
}
