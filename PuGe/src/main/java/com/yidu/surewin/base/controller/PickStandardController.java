package com.yidu.surewin.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.surewin.base.domain.PickStandard;
import com.yidu.surewin.base.service.PickStandardService;
import com.yidu.surewin.util.IDGenerator;


@Controller
@RequestMapping("/pickStandard")
public class PickStandardController {
	@Autowired
	private PickStandardService pickStandardService;
	
	public PickStandardController(){	
	}

	@ResponseBody
	@RequestMapping(value="findAllpickStandard" ,method={RequestMethod.POST})
	public Map<String,Object> doFindAllByPage(){
		Map<String, Object> returnMap= new HashMap<String, Object>();
		List<PickStandard> pickStandards=pickStandardService.findAll();
		returnMap.put("total", 2);
		returnMap.put("rows",pickStandards);
		System.out.println(pickStandards);
		return returnMap;
	}
	@ResponseBody
	@RequestMapping(value="addDocument",method={RequestMethod.POST})
	public boolean doInsert(PickStandard pickStandard){
		pickStandard.setPickStandardId(IDGenerator.getId());
		int rows=pickStandardService.addPickStandard(pickStandard);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}

	@ResponseBody
	@RequestMapping(value="deleteDocument",method={RequestMethod.POST})
	public boolean doDelete(String ids){
		int rows=pickStandardService.deletePickStandard(ids);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="updateDocument",method={RequestMethod.POST})
	public boolean doupdate(PickStandard pickStandard){
		int rows=pickStandardService.updatePickStandard(pickStandard);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}
	@ResponseBody
	@RequestMapping(value="pickStandardpageQuery" ,method={RequestMethod.POST})
	public Map<String,Object> dopickStandardpageQuery(String useable,String pickStandardName ,String minWeight,String maxWeight,Integer pageNumber, Integer pageSize){
		System.out.println(useable+","+pickStandardName+","+minWeight+","+maxWeight+","+pageNumber+","+pageSize);
		Map<String, Object> queryMap= new HashMap<String, Object>();
		queryMap.put("useable", useable);
		queryMap.put("pickStandardName", pickStandardName);
		queryMap.put("minWeight", minWeight);
		queryMap.put("maxWeight", maxWeight);
		queryMap.put("pageNumber", (pageNumber-1)*pageSize);
		queryMap.put("pageSize", pageSize);
		List<PickStandard> pickStandards=pickStandardService.pickStandardpageQuery(queryMap);
		
		Map<String, Object> returnMap= new HashMap<String, Object>();
		if(pickStandards.size() != 0){
			returnMap.put("rows",pickStandards);
		}else{
			queryMap.put("pageNumber", 0);
			List<PickStandard> pickStandards2=pickStandardService.pickStandardpageQuery(queryMap);
			returnMap.put("rows",pickStandards2);
		}
		
		//获取总记录数
		int total = pickStandardService.findPageQueryCount(queryMap);
		System.out.println("---------"+total);
		returnMap.put("total", total);
		
		System.out.println(pickStandards.size());
		return returnMap;
	}
}

