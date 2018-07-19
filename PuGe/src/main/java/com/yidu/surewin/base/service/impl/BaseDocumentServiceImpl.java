package com.yidu.surewin.base.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.surewin.base.dao.BaseDocumentDao;
import com.yidu.surewin.base.domain.BaseDocument;
import com.yidu.surewin.base.service.BaseDocumentService;

@Service
public class BaseDocumentServiceImpl implements BaseDocumentService {
	@Autowired
	private BaseDocumentDao baseDocumentDao;
	public BaseDocumentServiceImpl(){
		
	}
	
	public BaseDocumentServiceImpl(BaseDocumentDao baseDocumentDao) {
		this.baseDocumentDao = baseDocumentDao;
	}
	
	
	public BaseDocumentDao getBaseDocumentDao() {
		return baseDocumentDao;
	}

	public void setBaseDocumentDao(BaseDocumentDao baseDocumentDao) {
		this.baseDocumentDao = baseDocumentDao;
	}

	@Override
	public List<BaseDocument> findAll() {
		return baseDocumentDao.findAll();
	}

	@Override
	public int addBaseDocument(BaseDocument baseDocument) {
		return baseDocumentDao.addBaseDocument(baseDocument);
	}

	@Override
	public int deleteBaseDocument(String baseDocumentId) {
		return baseDocumentDao.deleteBaseDocument(baseDocumentId);
	}

	@Override
	public int updateBaseDocument(BaseDocument baseDocument) {
		return baseDocumentDao.updateBaseDocument(baseDocument);
	}

	@Override
	public List<BaseDocument> baseDocumentpageQuery(Map<String,Object> map) {
		return baseDocumentDao.baseDocumentpageQuery(map);
	}

	@Override
	public int findAllBaseDocumentCount() {
		return baseDocumentDao.findAllBaseDocumentCount();
	}

	@Override
	public int findPageQueryCount(Map<String,Object> map) {
		return baseDocumentDao.findPageQueryCount(map);
	}

}
