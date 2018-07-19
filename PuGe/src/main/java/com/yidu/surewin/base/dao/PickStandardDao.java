package com.yidu.surewin.base.dao;

import java.util.List;
import java.util.Map;

import com.yidu.surewin.base.domain.PickStandard;

public interface PickStandardDao {
	public List<PickStandard> findAll();
	public int addPickStandard(PickStandard pickStandard);
	public int deletePickStandard(String pickStandardId);
	public int updatePickStandard(PickStandard pickStandard);
	public List<PickStandard> pickStandardpageQuery(Map<String,Object> map);
	public int findAllPickStandardCount();
	public int findPageQueryCount(Map<String,Object> map);
}
