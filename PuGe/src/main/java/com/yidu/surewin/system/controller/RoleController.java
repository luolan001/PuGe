package com.yidu.surewin.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.surewin.system.domain.Role;
import com.yidu.surewin.system.service.RoleService;
import com.yidu.surewin.util.IDGenerator;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	public RoleController(){	
	}

	@ResponseBody
	@RequestMapping(value="addRole",method={RequestMethod.POST})
	public boolean doInsert(Role role){
		role.setRoleId(IDGenerator.getId());
		int rows=roleService.addRoleTx(role);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}

	@ResponseBody
	@RequestMapping(value="deleteRole",method={RequestMethod.POST})
	public boolean doDelete(String ids){
		int rows=roleService.deleteRoleTx(ids);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="updateRole",method={RequestMethod.POST})
	public boolean doupdate(Role role){
		int rows=roleService.updateRoleTx(role);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="rolePageQuery" ,method={RequestMethod.POST})
	public Map<String,Object> doRolePageQuery(String roleName, String organizationTypeName, Integer pageNumber, Integer pageSize){
		Map<String, Object> queryMap= new HashMap<String, Object>();
		queryMap.put("roleName", roleName);
		queryMap.put("organizationTypeName", organizationTypeName);
		queryMap.put("pageNumber", (pageNumber-1)*pageSize);
		queryMap.put("pageSize", pageSize);
		List<Role> RoleList=roleService.RolePageQuery(queryMap);
		Map<String, Object> returnMap= new HashMap<String, Object>();
		if(RoleList.size() != 0){
			returnMap.put("rows",RoleList);
		}else{
			queryMap.put("pageNumber", 0);
			List<Role> RoleList2=roleService.RolePageQuery(queryMap);
			returnMap.put("rows",RoleList2);
		}
		//获取总记录数
		int total = roleService.findRoleQueryCount(queryMap);
		returnMap.put("total", total);
		return returnMap;
	}
}

