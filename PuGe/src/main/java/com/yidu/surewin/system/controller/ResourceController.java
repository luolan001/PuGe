package com.yidu.surewin.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.surewin.system.domain.Resource;
import com.yidu.surewin.system.service.ResourceService;

@Controller
@RequestMapping("/resource")
public class ResourceController {
	
	@Autowired
	private ResourceService resourceService;
	
	/**
	 * 默认构造方法
	 */
	public ResourceController(){
		
	}
	
	/**
	 * 根据角色ID查询资源表
	 * @param roleId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="findResourceWithRoleId",method={RequestMethod.POST})
	public List<Resource> dofindResourceWithRoleId(String roleId){
		return resourceService.findRoleResourceWithRoleId(roleId);
	}
	
	/**
	 * 查询资源表，不带条件
	 * @param roleId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="findQueryResource",method={RequestMethod.POST})
	public List<Resource> dofindQueryResource(String roleId){
		//调用查询方法
		List<Resource> resourceList=resourceService.findQueryResource();
		//返回结果
		return resourceList;
	}
	
	/**
	 * 查询资源表所有数据
	 * @param resourceName
	 * @param indexs
	 * @param resourceType
	 * @param parentResourceName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="findAll" ,method={RequestMethod.POST,RequestMethod.GET})
	public List<Resource> findAll(String resourceName,String indexs,String resourceType,String parentResourceName){
		//根据父资源名查询资源Id
		String resourceId = resourceService.findresourceId(parentResourceName);
		//根据资源名查询Id
		String resourceId2 = resourceService.findresourceId(resourceName);
		//创建map对象
		Map<String, Object> map= new HashMap<String, Object>();
		//第一个资源ID赋值给第一个父ID
		map.put("parentId", resourceId);
		//第二个资源ID赋值给第二个父ID
		map.put("parentId2", resourceId2);
		//资源名
		map.put("resourceName", resourceName);
		//索引
		map.put("indexs", indexs);
		//资源级别
		map.put("resourceType", resourceType);
		//进行方法查询，将结果保存到集合中
		List<Resource> resourceList = resourceService.findAll(map);
		//返回集合
		return resourceList;
	}
	
	/**
	 * 禁用
	 * @param resourceIdArray
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="deleteUseableTx" ,method={RequestMethod.POST,RequestMethod.GET})
	public boolean deleteUseableTx(String[] resourceIdArray){
		boolean flag = false;
		for (int i = 0; i < resourceIdArray.length-1; i++) {
			flag = resourceService.deleteUseableTx(resourceIdArray[i]);
		}
		return flag;
	}
	
	/**
	 * 启用
	 * @param resourceIdArray
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="enableUseableTx" ,method={RequestMethod.POST,RequestMethod.GET})
	public boolean enableUseableTx(String[] resourceIdArray){
		boolean flag = false;
		for (int i = 0; i < resourceIdArray.length-1; i++) {
			flag = resourceService.enableUseableTx(resourceIdArray[i]);
		}
		return flag;
	}
	
	/**
	 * 修改
	 * @param resource
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="updateParentIdTx" ,method={RequestMethod.POST,RequestMethod.GET})
	public boolean updateParentIdTx(Resource resource){
		System.out.println(resource);
		return resourceService.updateParentIdTx(resource);
	}
}
