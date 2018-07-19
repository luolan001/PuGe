package com.yidu.surewin.base.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.surewin.base.dao.PickStandardDao;
import com.yidu.surewin.base.domain.PickStandard;
import com.yidu.surewin.base.service.PickStandardService;

@Service
public class PickStandardServiceImpl implements PickStandardService {
	@Autowired
	private PickStandardDao pickStandardDao;
	public PickStandardServiceImpl(){
		
	}
	
	public PickStandardServiceImpl(PickStandardDao pickStandardDao) {
		this.pickStandardDao = pickStandardDao;
	}
	
	
	public PickStandardDao getPickStandardDao() {
		return pickStandardDao;
	}

	public void setPickStandardDao(PickStandardDao pickStandardDao) {
		this.pickStandardDao = pickStandardDao;
	}

	@Override
	public List<PickStandard> findAll() {
		return pickStandardDao.findAll();
	}

	@Override
	public int addPickStandard(PickStandard pickStandard) {
		return pickStandardDao.addPickStandard(pickStandard);
	}

	@Override
	public int deletePickStandard(String pickStandardId) {
		return pickStandardDao.deletePickStandard(pickStandardId);
	}

	@Override
	public int updatePickStandard(PickStandard pickStandard) {
		return pickStandardDao.updatePickStandard(pickStandard);
	}

	@Override
	public List<PickStandard> pickStandardpageQuery(Map<String,Object> map) {
		return pickStandardDao.pickStandardpageQuery(map);
	}

	@Override
	public int findAllPickStandardCount() {
		return pickStandardDao.findAllPickStandardCount();
	}

	@Override
	public int findPageQueryCount(Map<String,Object> map) {
		return pickStandardDao.findPageQueryCount(map);
	}

}
