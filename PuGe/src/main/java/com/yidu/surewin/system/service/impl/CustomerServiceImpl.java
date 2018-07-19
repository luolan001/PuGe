package com.yidu.surewin.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.surewin.system.dao.CustomerDao;
import com.yidu.surewin.system.domain.Customer;
import com.yidu.surewin.system.service.CustomerService;


@Service   
public class CustomerServiceImpl implements CustomerService{
	@Autowired  
	private CustomerDao customerDao;
	 
	public CustomerServiceImpl(){
		
	}
	
	public CustomerServiceImpl(CustomerDao customerDao){
		this.customerDao = customerDao;
	}
	
	public CustomerDao getCustomerDao(){
		return customerDao;
	}
	
	public void setCustomerDao(CustomerDao customerDao){
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	@Override
	public int addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	public int deleteCustomer(String customerId) {
		return customerDao.deleteCustomer(customerId);
	}

	@Override
	public int updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

	@Override
	public List<Customer> customerpageQuery(Map<String, Object> map) {
		return customerDao.customerpageQuery(map);
	}

	@Override
	public int findAllCustomerCount() {
		return customerDao.findAllCustomerCount();
	}

	@Override
	public int findPageQueryCount(Map<String, Object> map) {
		return customerDao.findPageQueryCount(map);
	}

}
