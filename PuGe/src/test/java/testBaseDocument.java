import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yidu.surewin.system.domain.BaseDocument;
import com.yidu.surewin.system.service.BaseDocumentService;
import com.yidu.surewin.system.service.impl.BaseDocumentServiceImpl;

public class testBaseDocument {
	@Test
	public void findAll(){
		ApplicationContext app=new ClassPathXmlApplicationContext("spring/spring-base.xml");
		BaseDocumentService baseService = new BaseDocumentServiceImpl();
		Map<String, Object> returnMap= new HashMap<String, Object>();
		List<BaseDocument> baseDocuments=baseService.findAll();
		returnMap.put("total", baseDocuments.size());
		returnMap.put("rows",baseDocuments);
	
		
	}
}
