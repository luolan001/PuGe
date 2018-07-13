package com.yidu.surewin.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.surewin.system.domain.AssistantDocument;
import com.yidu.surewin.system.service.AssistantDocumentService;
import com.yidu.surewin.system.util.IDGenerator;

@Controller
@RequestMapping("/assistantDocument")
public class AssistantDocumentController {
	@Autowired
	private AssistantDocumentService assistantDocumentService;
	public AssistantDocumentController(){
		
	}
	@ResponseBody
	@RequestMapping(value="assistantDocumentpageQuery" ,method={RequestMethod.POST, RequestMethod.GET})
	public Map<String, Object> doassistantDocumentController(String useable,String baseNo,String assistantDocumentName,String baseDocumentNo,Integer pageNumber,Integer pageSize){
		Map<String, Object> queryMap= new HashMap<String, Object>();
		queryMap.put("useable", useable);
		queryMap.put("assistantDocumentName", assistantDocumentName);
		queryMap.put("baseDocumentNo", baseDocumentNo);
		System.out.println(pageNumber+"=---"+pageSize);
		queryMap.put("pageNumber", (pageNumber-1)*pageSize);
		
		queryMap.put("pageSize", pageSize);
		queryMap.put("baseNo", baseNo);
		List<AssistantDocument> assistantDocuments=assistantDocumentService.AssistantDocumentpageQuery(queryMap);
		System.out.println(assistantDocuments);
		Map<String, Object> returnMap= new HashMap<String, Object>();
		if(assistantDocuments.size() != 0){
			returnMap.put("rows",assistantDocuments);
		}else{
			queryMap.put("pageNumber", 0);
			List<AssistantDocument> assistantDocuments2=assistantDocumentService.AssistantDocumentpageQuery(queryMap);
			returnMap.put("rows",assistantDocuments2);
		}
		//获取总记录数
		int total = assistantDocumentService.findPageQueryCount(queryMap);
		returnMap.put("total", total);
		return returnMap;
	}	
	@ResponseBody
	@RequestMapping(value="assistantDocumentAdd" ,method={RequestMethod.POST,RequestMethod.GET})
	 public boolean doInsert(AssistantDocument assistantDocument){
		assistantDocument.setAssistantDocumentId(IDGenerator.getId());
		assistantDocument.setUseable("Y");
		String baseDocumentId = assistantDocumentService.findBaseDocumentBDId(assistantDocument.getBaseDocumentNo());
		if(baseDocumentId != null){
			assistantDocument.setBaseDocumentId(baseDocumentId);
		}else{
			return false;
		}
		int rows=assistantDocumentService.addAssistantDocument(assistantDocument);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}
	@ResponseBody
	@RequestMapping(value="assistantDocumentdelete" ,method={RequestMethod.POST ,RequestMethod.GET})
	 public boolean dodelete(String ids){
		int rows=assistantDocumentService.deleteAassistantDocument(ids);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}
	@ResponseBody
	@RequestMapping(value="assistantDocumentUpdate" ,method={RequestMethod.POST,RequestMethod.GET})
	 public boolean doUpdate(AssistantDocument assistantDocument){
		int rows=assistantDocumentService.updateAassistantDocument(assistantDocument);
		if(rows>0){
			return true;
		}else {
			return false;
		}
	}
}
