package com.yidu.surewin.system.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.surewin.system.domain.Area;
import com.yidu.surewin.system.service.AreaService;
import com.yidu.surewin.system.util.IDGenerator;

@Controller 
public class AreaController {
	@Autowired
	private AreaService areaService;
	public AreaController(){
		
	}
	public AreaController(AreaService areaService) {
		super();
		this.areaService = areaService;
	}
	public AreaService getAreaService() {
		return areaService;
	}
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	
	@ResponseBody
	@RequestMapping("findAllArea") 
	public Map<String,Object> doQueryAreaWithCriteria(Integer offset,Integer limit,Area area){
		System.out.println("1111111111111");
		Map<String, Object> paramMap = new HashMap<String,Object>();
		paramMap.put("offset", offset);
		paramMap.put("limit", limit);
		paramMap.put("province", area.getProvince());
		paramMap.put("city", area.getCity());
		paramMap.put("county", area.getCounty());
		paramMap.put("postCode", area.getPostCode());
		paramMap.put("simpleCode", area.getSimpleCode());
		paramMap.put("cityCode", area.getCityCode());
		List<Area> areaList = areaService.findAllArea(paramMap);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("total", areaService.findAllArea(paramMap));
		map.put("rows", areaList);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("addArea")
	public boolean doInsert(Area area){
		area.setAreaId(IDGenerator.getId());
		int rows=areaService.addArea(area);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}
	
	@ResponseBody
	@RequestMapping("updateArea")
	public boolean doUpdate(Area area){
		int row = areaService.updateArea(area);
		if(row>0){
			return true;
		}else{
			return false;
		}
		
	}
	
	@ResponseBody
	@RequestMapping("deleteArea")
	public String doDelete(@RequestParam(value="areaIds[]") String[] areaIds){
		System.out.println("11111111111");
		boolean result = false;
		for(int i=0;i<areaIds.length;i++){
			result=this.areaService.deleteArea(areaIds[i]);
		}
		if(result){
			return "success";
		}else{
			return "fail";
		}
	}
	
	@ResponseBody
	@RequestMapping("areapageQuery")
	public Map<String,Object> doAreapageQuery(String province,String city,String county,Integer pageNumber,Integer pageSize){
		System.out.println("12312312313");
		Map<String,Object> queryMap = new HashMap<String,Object>();
		queryMap.put("province", province);
		queryMap.put("city", city);
		queryMap.put("county", county);
		queryMap.put("pageNumber", (pageNumber-1)*pageSize);
		queryMap.put("pageSize", pageSize);
		List<Area> areas = areaService.areapageQuery(queryMap);
		Map<String,Object> returnMap = new HashMap<String,Object>();
		if(areas.size()!=0){
			returnMap.put("rows", areas);
		}else{
			queryMap.put("pageNumber", 0);
			List<Area> areas2=areaService.areapageQuery(queryMap);
			returnMap.put("rows", areas2);
		}
		int total = areaService.findPageQueryCount(queryMap);
		returnMap.put("total",total);
		return returnMap;
	}
}
