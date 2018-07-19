package com.yidu.surewin.system.dao;

import java.util.List;
import java.util.Map;

import com.yidu.surewin.system.domain.Customer;



public interface CustomerDao {

	public List<Customer> findAll();
	public int addCustomer(Customer customer);
	public int deleteCustomer(String customerId);
	public int updateCustomer(Customer customer);
	public List<Customer> customerpageQuery(Map<String,Object>map );
	public int findAllCustomerCount();
	public int findPageQueryCount(Map<String,Object>map);
}
