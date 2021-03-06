package com.yidu.surewin.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.surewin.base.domain.BaseDocument;
import com.yidu.surewin.base.service.BaseDocumentService;
import com.yidu.surewin.util.IDGenerator;

@Controller
@RequestMapping("/baseDocument")
public class BaseDocumentController {
	@Autowired
	private BaseDocumentService baseDocumentService;
	
	public BaseDocumentController(){	
		System.out.println("进来了");
	}

	@ResponseBody
	@RequestMapping(value="findAllbaseDocument" ,method={RequestMethod.POST})
	public Map<String,Object> doFindAllByPage(){
		Map<String, Object> returnMap= new HashMap<String, Object>();
		List<BaseDocument> baseDocuments=baseDocumentService.findAll();
		returnMap.put("total", 2);
		returnMap.put("rows",baseDocuments);
		System.out.println(baseDocuments);
		return returnMap;
	}
	@ResponseBody
	@RequestMapping(value="addDocument",method={RequestMethod.POST})
	public boolean doInsert(BaseDocument baseDocument){
		baseDocument.setBaseDocumentId(IDGenerator.getId());
		int rows=baseDocumentService.addBaseDocument(baseDocument);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}

	@ResponseBody
	@RequestMapping(value="deleteDocument",method={RequestMethod.POST})
	public boolean doDelete(String ids){
		int rows=baseDocumentService.deleteBaseDocument(ids);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}

	@RequestMapping(value="lookAssistantDocument",method={RequestMethod.POST})
	public String dolook(String ids){
		System.out.println("lookAssistantDocument1231231");
		return "redirect:../jsps/system/AssistantDocument.jsp?ids="+ids;
	}
	
	@ResponseBody
	@RequestMapping(value="updateDocument",method={RequestMethod.POST})
	public boolean doupdate(BaseDocument baseDocument){
		int rows=baseDocumentService.updateBaseDocument(baseDocument);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}
	@ResponseBody
	@RequestMapping(value="baseDocumentpageQuery" ,method={RequestMethod.POST})
	public Map<String,Object> dobaseDocumentpageQuery(String scale,String baseDocumentName ,Integer pageNumber, Integer pageSize){
		System.out.println(scale+","+baseDocumentName+","+pageNumber+","+pageSize);
		Map<String, Object> queryMap= new HashMap<String, Object>();
		queryMap.put("scale", scale);
		queryMap.put("baseDocumentName", baseDocumentName);
		queryMap.put("pageNumber", (pageNumber-1)*pageSize);
		queryMap.put("pageSize", pageSize);
		List<BaseDocument> baseDocuments=baseDocumentService.baseDocumentpageQuery(queryMap);
		
		Map<String, Object> returnMap= new HashMap<String, Object>();
		if(baseDocuments.size() != 0){
			returnMap.put("rows",baseDocuments);
		}else{
			queryMap.put("pageNumber", 0);
			List<BaseDocument> baseDocuments2=baseDocumentService.baseDocumentpageQuery(queryMap);
			returnMap.put("rows",baseDocuments2);
		}
		
		//获取总记录数
		int total = baseDocumentService.findPageQueryCount(queryMap);
		returnMap.put("total", total);
		return returnMap;
	}
}

