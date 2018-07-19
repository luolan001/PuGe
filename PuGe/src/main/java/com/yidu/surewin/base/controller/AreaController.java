package com.yidu.surewin.base.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.surewin.base.domain.Area;
import com.yidu.surewin.base.service.AreaService;
import com.yidu.surewin.util.IDGenerator;
import com.yidu.surewin.util.OutExcel;


@Controller 
@RequestMapping("/Area")
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
		Map<String,Object> queryMap = new HashMap<String,Object>();
		queryMap.put("province", province);
		queryMap.put("city", city);
		queryMap.put("county", county);
		queryMap.put("pageNumber", (pageNumber-1)*pageSize);
		queryMap.put("pageSize", pageSize);
		List<Area> areas = areaService.areapageQuery(queryMap);
		Map<String,Object> returnMap = new HashMap<String,Object>();
		
		System.out.println(areas.get(1));
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
	
	@ResponseBody
	@RequestMapping("UpdateDisable")
	public boolean doUpdateDisable(String ids){
		int rows=areaService.updatedisable(ids);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}
	@ResponseBody
	@RequestMapping("UpdateUseable")
	public boolean doUpdateUseable(String areaId){
		int rows=areaService.updateuseable(areaId);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}
	 /**
	  * 导出Excel
	  * @param path 路径
	  * @return 导出结果
	  * @throws IOException 异常
	  */
	 @RequestMapping("outExcel.action")
	 @ResponseBody
	 private String outExcel(String path) {
		 //定义一个变量接收导出文件路径
		 String result = OutExcel.outExcel(areaService.findAllArea(null), path);
		 //返回结果
		 return result;
	 }
		
}
