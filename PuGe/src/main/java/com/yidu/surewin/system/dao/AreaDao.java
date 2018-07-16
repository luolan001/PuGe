package com.yidu.surewin.system.dao;

import java.util.List;
import java.util.Map;

import com.yidu.surewin.system.domain.Area;


public interface AreaDao {
	public List<Area> findAllArea(Map<String,Object> paramMap);
	public int addArea(Area area);
	public int updateArea(Area area);
	public boolean deleteArea(String areaId);
	public List<Area> areapageQuery(Map<String,Object> map); 
	public int findPageQueryCount(Map<String,Object> map);
}
