package com.yidu.surewin.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.surewin.system.dao.AreaDao;
import com.yidu.surewin.system.domain.Area;
import com.yidu.surewin.system.service.AreaService;



@Service
public class AreaServiceImpl implements AreaService{
	@Autowired
	private AreaDao areaDao;
   
	public AreaServiceImpl() {

	}
	
	

	public AreaDao getAreaDao() {
		return areaDao;
	}



	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}



	public List<Area> findAllArea(Map<String,Object> paramMap) {
		return areaDao.findAllArea(paramMap);
	}



	@Override
	public int addArea(Area area) {
		return areaDao.addArea(area);
	}



	@Override
	public int updateArea(Area area) {
		return areaDao.updateArea(area);
	}



	@Override
	public boolean deleteArea(String areaId) {
		return areaDao.deleteArea(areaId);
	}

	@Override
	public List<Area> areapageQuery(Map<String, Object> map) {
		return areaDao.areapageQuery(map);
	}



	@Override
	public int findPageQueryCount(Map<String, Object> map) {
		return areaDao.findPageQueryCount(map);
	}



	
}