package com.yidu.surewin.base.service;

import java.util.List;
import java.util.Map;

import com.yidu.surewin.base.domain.BaseDocument;

public interface BaseDocumentService {
	 List<BaseDocument> findAll();
	 int addBaseDocument(BaseDocument baseDocument);
	 int deleteBaseDocument(String baseDocumentId);
	 int updateBaseDocument(BaseDocument baseDocument);
	 List<BaseDocument> baseDocumentpageQuery(Map<String,Object> map);
	 int findAllBaseDocumentCount();
	 int findPageQueryCount(Map<String,Object> map);
}
