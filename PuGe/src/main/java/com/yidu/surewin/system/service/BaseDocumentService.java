package com.yidu.surewin.system.service;

import java.util.List;
import java.util.Map;

import com.yidu.surewin.system.domain.BaseDocument;

public interface BaseDocumentService {
	public List<BaseDocument> findAll();
	public int addBaseDocument(BaseDocument baseDocument);
	public int deleteBaseDocument(String baseDocumentId);
	public int updateBaseDocument(BaseDocument baseDocument);
	public List<BaseDocument> baseDocumentpageQuery(Map<String,Object> map);
	public int findAllBaseDocumentCount();
	public int findPageQueryCount(Map<String,Object> map);
}
