package com.yidu.surewin.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.surewin.system.domain.RoleResource;
import com.yidu.surewin.system.service.RoleResourceService;
import com.yidu.surewin.util.IDGenerator;

@Controller
@RequestMapping("/roleResource")
public class RoleResourceController {
	@Autowired
	private RoleResourceService roleResourceService;
	
	public RoleResourceController(){	
	}
	
	
	@ResponseBody
	@RequestMapping(value="addRoleResource",method={RequestMethod.POST})
	public boolean doAdd(String[] resourceIdData, RoleResource roleResource){
		/**
		 * 删除角色所有资源，下面在重新添加
		 */
		roleResourceService.deleteRoleResourceWithRoleIdTx(roleResource.getRoleId());
		
		/**
		 * 将父资源添加给角色
		 */
		for(int i = 0; i < resourceIdData.length-1; i++){
			roleResource.setRoleResourceId(IDGenerator.getId());
			if(!"null".equals(roleResourceService.findResourceParentId(resourceIdData[i]))){
				roleResource.setResourceId(roleResourceService.findResourceParentId(resourceIdData[i]));
				roleResourceService.addRoleResourceTx(roleResource);
			}
		}
		
		/**
		 * 将子资源添加给角色
		 */
		for(int i = 0; i < resourceIdData.length-1; i++){
			roleResource.setRoleResourceId(IDGenerator.getId());
			roleResource.setResourceId(resourceIdData[i]);
			roleResourceService.addRoleResourceTx(roleResource);
		}
		return true;
	}
	
	/*@ResponseBody
	@RequestMapping(value="addRoleResource",method={RequestMethod.POST})
	public boolean doInsert(RoleResource roleResource){
		roleResource.setRoleResourceId(IDGenerator.getId());
		int rows=roleResourceService.addRoleResourceTx(roleResource);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}*/
	
	
	@ResponseBody
	@RequestMapping(value="deleteRoleResource",method={RequestMethod.POST})
	public boolean doDelete(String ids){
		int rows=roleResourceService.deleteRoleResourceTx(ids);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="updateRoleResource",method={RequestMethod.POST})
	public boolean doupdate(RoleResource roleResource){
		int rows=roleResourceService.updateRoleResourceTx(roleResource);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="roleResourcePageQuery" ,method={RequestMethod.POST})
	public Map<String,Object> doRoleResourcePageQuery(String resourceId, String roleId, Integer pageNumber, Integer pageSize){
		Map<String, Object> queryMap= new HashMap<String, Object>();
		queryMap.put("resourceId", resourceId);
		queryMap.put("roleId", roleId);
		queryMap.put("pageNumber", (pageNumber-1)*pageSize);
		queryMap.put("pageSize", pageSize);
		List<RoleResource> roleResourceList=roleResourceService.roleResourcePageQuery(queryMap);
		Map<String, Object> returnMap= new HashMap<String, Object>();
		if(roleResourceList.size() != 0){
			returnMap.put("rows",roleResourceList);
		}else{
			queryMap.put("pageNumber", 0);
			List<RoleResource> roleResourceList2=roleResourceService.roleResourcePageQuery(queryMap);
			returnMap.put("rows",roleResourceList2);
		}
		//获取总记录数
		int total = roleResourceService.findRoleResourceQueryCount(queryMap);
		returnMap.put("total", total);
		return returnMap;
	}
	
	
}
