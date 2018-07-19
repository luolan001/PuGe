package com.yidu.surewin.base.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.surewin.base.dao.AreaDao;
import com.yidu.surewin.base.domain.Area;
import com.yidu.surewin.base.service.AreaService;




@Service("AreaService")
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
	@Override
	public int updatedisable(String ids) {
		return areaDao.updatedisable(ids);
	}

	@Override
	public int updateuseable(String areaId) {
		return areaDao.updateuseable(areaId);
	}
}