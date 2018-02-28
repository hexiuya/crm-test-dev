package com.crm.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.test.mapper.CustomerMapper;
import com.crm.test.model.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	
	public Customer selectCustomerByUserName(String username,String password){
		Customer customer = new Customer();
		List<Customer> customers = customerMapper.selectCustomerByUserName(username,password);
		if(customers == null){
			return customer;
		}
		customer = customers.get(0);
		return customer;
//		return null;
	}
	
	public int insertCustomer(Customer customer){
		int row = customerMapper.insertCustomer(customer);
		return row;
	}
}
