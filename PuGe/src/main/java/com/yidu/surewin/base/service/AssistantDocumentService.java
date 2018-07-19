package com.yidu.surewin.base.service;

import java.util.List;
import java.util.Map;

import com.yidu.surewin.base.domain.AssistantDocument;


public interface AssistantDocumentService {
	 List<AssistantDocument> AssistantDocumentpageQuery(Map<String,Object> map);
	 int findPageQueryCount(Map<String,Object> map);
	 String findBaseDocumentBDId(String baseDocumentNo);
	 int addAssistantDocument(AssistantDocument assistantDocument);
	 int deleteAassistantDocument(String assistantDocumentId);
	 int updateAassistantDocument(AssistantDocument assistantDocument);
	 int updateDisable(String assId);
	 int updateUseable(String useassId);
}
