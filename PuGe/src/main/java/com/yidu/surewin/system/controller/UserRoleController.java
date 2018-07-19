package com.yidu.surewin.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.surewin.system.domain.UserRole;
import com.yidu.surewin.system.service.UserRoleService;
import com.yidu.surewin.util.IDGenerator;

@Controller
@RequestMapping("/userRole")
public class UserRoleController {
	@Autowired
	private UserRoleService userRoleService;
	
	public UserRoleController(){	
	}
	
	@ResponseBody
	@RequestMapping(value="addUserRole",method={RequestMethod.POST})
	public boolean doInsert(UserRole userRole){
		userRole.setUserRoleId(IDGenerator.getId());
		int rows=userRoleService.addUserRoleTx(userRole);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value="deleteUserRole",method={RequestMethod.POST})
	public boolean doDelete(String ids){
		int rows=userRoleService.deleteUserRoleTx(ids);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="updateUserRole",method={RequestMethod.POST})
	public boolean doupdate(UserRole userRole){
		int rows=userRoleService.updateUserRoleTx(userRole);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="userRolePageQuery" ,method={RequestMethod.POST})
	public Map<String,Object> doRoleResourcePageQuery(String userId, String roleId, Integer pageNumber, Integer pageSize){
		Map<String, Object> queryMap= new HashMap<String, Object>();
		System.out.println(userId+","+roleId);
		queryMap.put("userId", userId);
		queryMap.put("roleId", roleId);
		queryMap.put("pageNumber", (pageNumber-1)*pageSize);
		queryMap.put("pageSize", pageSize);
		List<UserRole> userRoleList=userRoleService.userRolePageQuery(queryMap);
		Map<String, Object> returnMap= new HashMap<String, Object>();
		if(userRoleList.size() != 0){
			returnMap.put("rows",userRoleList);
		}else{
			queryMap.put("pageNumber", 0);
			List<UserRole> userRoleList2=userRoleService.userRolePageQuery(queryMap);
			returnMap.put("rows",userRoleList2);
		}
		//获取总记录数
		int total = userRoleService.findUserRoleQueryCount(queryMap);
		returnMap.put("total", total);
		return returnMap;
	}
	
	
}
