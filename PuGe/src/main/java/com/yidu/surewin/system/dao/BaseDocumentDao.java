package com.yidu.surewin.system.dao;

import java.util.List;
import java.util.Map;

import com.yidu.surewin.system.domain.BaseDocument;

public interface BaseDocumentDao {
	 List<BaseDocument> findAll();
	 int addBaseDocument(BaseDocument baseDocument);
	 int deleteBaseDocument(String baseDocumentId);
	 int updateBaseDocument(BaseDocument baseDocument);
	 List<BaseDocument> baseDocumentpageQuery(Map<String,Object> map);
	 int findAllBaseDocumentCount();
	 int findPageQueryCount(Map<String,Object> map);
}
