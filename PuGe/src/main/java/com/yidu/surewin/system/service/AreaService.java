package com.yidu.surewin.system.service;
import java.util.List;
import java.util.Map;

import com.yidu.surewin.system.domain.Area;


public interface AreaService {
   List<Area> findAllArea(Map<String,Object> paramMap);
   int addArea(Area area);
   int updateArea(Area area);
   boolean deleteArea(String areaId);
   List<Area> areapageQuery(Map<String, Object> map);
   int findPageQueryCount(Map<String,Object> map);
}
