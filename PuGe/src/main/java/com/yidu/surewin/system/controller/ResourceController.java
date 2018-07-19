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
	 * Ĭ�Ϲ��췽��
	 */
	public ResourceController(){
		
	}
	
	/**
	 * ���ݽ�ɫID��ѯ��Դ��
	 * @param roleId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="findResourceWithRoleId",method={RequestMethod.POST})
	public List<Resource> dofindResourceWithRoleId(String roleId){
		return resourceService.findRoleResourceWithRoleId(roleId);
	}
	
	/**
	 * ��ѯ��Դ����������
	 * @param roleId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="findQueryResource",method={RequestMethod.POST})
	public List<Resource> dofindQueryResource(String roleId){
		//���ò�ѯ����
		List<Resource> resourceList=resourceService.findQueryResource();
		//���ؽ��
		return resourceList;
	}
	
	/**
	 * ��ѯ��Դ����������
	 * @param resourceName
	 * @param indexs
	 * @param resourceType
	 * @param parentResourceName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="findAll" ,method={RequestMethod.POST,RequestMethod.GET})
	public List<Resource> findAll(String resourceName,String indexs,String resourceType,String parentResourceName){
		//���ݸ���Դ����ѯ��ԴId
		String resourceId = resourceService.findresourceId(parentResourceName);
		//������Դ����ѯId
		String resourceId2 = resourceService.findresourceId(resourceName);
		//����map����
		Map<String, Object> map= new HashMap<String, Object>();
		//��һ����ԴID��ֵ����һ����ID
		map.put("parentId", resourceId);
		//�ڶ�����ԴID��ֵ���ڶ�����ID
		map.put("parentId2", resourceId2);
		//��Դ��
		map.put("resourceName", resourceName);
		//����
		map.put("indexs", indexs);
		//��Դ����
		map.put("resourceType", resourceType);
		//���з�����ѯ����������浽������
		List<Resource> resourceList = resourceService.findAll(map);
		//���ؼ���
		return resourceList;
	}
	
	/**
	 * ����
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
	 * ����
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
	 * �޸�
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
