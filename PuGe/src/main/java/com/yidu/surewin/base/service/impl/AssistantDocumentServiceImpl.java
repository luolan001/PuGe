package com.yidu.surewin.base.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.surewin.base.dao.AssistantDocumentDao;
import com.yidu.surewin.base.domain.AssistantDocument;
import com.yidu.surewin.base.service.AssistantDocumentService;

@Service
public class AssistantDocumentServiceImpl implements AssistantDocumentService{
	@Autowired
	private AssistantDocumentDao assistantDocumentDao;
	
	public AssistantDocumentServiceImpl() {
	
	}
	
	public AssistantDocumentServiceImpl(AssistantDocumentDao assistantDocumentDao) {
		this.assistantDocumentDao = assistantDocumentDao;
	}
	
	
	public AssistantDocumentDao getAssistantDocumentDao() {
		return assistantDocumentDao;
	}

	public void setAssistantDocumentDao(AssistantDocumentDao assistantDocumentDao) {
		this.assistantDocumentDao = assistantDocumentDao;
	}

	@Override
	public List<AssistantDocument> AssistantDocumentpageQuery(Map<String, Object> map) {
		return assistantDocumentDao.AssistantDocumentpageQuery(map);
	}

	@Override
	public int findPageQueryCount(Map<String, Object> map) {
		return assistantDocumentDao.findPageQueryCount(map);
	}

	@Override
	public String findBaseDocumentBDId(String baseDocumentNo) {
		return assistantDocumentDao.findBaseDocumentBDId(baseDocumentNo);
	}

	@Override
	public int addAssistantDocument(AssistantDocument assistantDocument) {
		return assistantDocumentDao.addAssistantDocument(assistantDocument);
	}

	@Override
	public int deleteAassistantDocument(String assistantDocumentId) {
		return assistantDocumentDao.deleteAassistantDocument(assistantDocumentId);
	}

	@Override
	public int updateAassistantDocument(AssistantDocument assistantDocument) {
		return assistantDocumentDao.updateAassistantDocument(assistantDocument);
	}

	@Override
	public int updateDisable(String assId) {
		return assistantDocumentDao.updateDisable(assId);
	}

	@Override
	public int updateUseable(String useassId) {
		return assistantDocumentDao.updateUseable(useassId);
	}
}
