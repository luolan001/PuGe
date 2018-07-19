package com.yidu.surewin.base.dao;

import java.util.List;
import java.util.Map;

import com.yidu.surewin.base.domain.Area;

public interface AreaDao {
	List<Area> findAllArea(Map<String,Object> paramMap);
	int addArea(Area area);
	int updateArea(Area area);
	boolean deleteArea(String areaId);
	List<Area> areapageQuery(Map<String,Object> map); 
	int findPageQueryCount(Map<String,Object> map);
	int updatedisable(String ids);
	int updateuseable(String areaId);
}
