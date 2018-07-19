package com.yidu.surewin.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.surewin.system.domain.Customer;
import com.yidu.surewin.system.service.CustomerService;
import com.yidu.surewin.util.IDGenerator;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	public CustomerController(){
		
	}
	
	@ResponseBody
	@RequestMapping(value="findAllcustomer" ,method={RequestMethod.POST})
	public Map<String,Object> doFindAllByPage(){
		Map<String,Object> returnMap = new HashMap<String,Object>();
		List<Customer> customers = customerService.findAll();
		returnMap.put("total", 2);
		returnMap.put("rows", customers);
		System.out.println(customers);
		return returnMap;	
	}
	
	@ResponseBody
	@RequestMapping(value="addCustomer",method={RequestMethod.POST})
	public boolean doInsert(Customer customer){
			customer.setCustomerId(IDGenerator.getId());
			int rows=customerService.addCustomer(customer);
			if(rows>0){
				return true;
			}else{
				return false;
			}
	} 
	
	@ResponseBody
	@RequestMapping(value="deleteCustomer",method={RequestMethod.POST})
	public boolean doDelete(String ids){
		int rows = customerService.deleteCustomer(ids);
				if(rows>0){
					return true;
				}else{
					return false;
				}
	}
	
	@ResponseBody
	@RequestMapping(value="updateCustomer",method={RequestMethod.POST})
	public boolean doupdate(Customer customer){
		int rows = customerService.updateCustomer(customer);
		if(rows>0){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping("customerpageQuery") 
	@ResponseBody
	public Map<String,Object> docustomerpageQuery(String useable,String customerName,
			Integer pageNumber,Integer pageSize){  
		System.out.println(pageNumber);
		System.out.println(pageSize); 
		Map<String,Object>  queryMap = new HashMap<String,Object>();
		queryMap.put("useable", useable);
		queryMap.put("customerName", customerName);
		queryMap.put("pageNumber", (pageNumber-1)*pageSize);
		queryMap.put("pageSize", pageSize);
		List<Customer>  custlist=customerService.customerpageQuery(queryMap);
		
		Map<String, Object> returnMap= new HashMap<String, Object>();
		if(custlist.size() != 0){
			returnMap.put("rows",custlist);
		}else{
			queryMap.put("pageNumber", 0);
			List<Customer> customer=customerService.customerpageQuery(queryMap);
			returnMap.put("rows",customer);
		}
		
		int total=customerService.findPageQueryCount(queryMap);
		System.out.println(custlist);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("total", total);
		map.put("rows", custlist);
		return map;
		 
	} 
}
