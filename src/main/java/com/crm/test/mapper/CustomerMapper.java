package com.crm.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.crm.test.model.Customer;

public interface CustomerMapper {
	public List<Customer> selectCustomer(Customer customer);
	
	public List<Customer> selectCustomerByUserName(@Param(value = "username") String username,@Param(value = "password") String password);
	
	public int insertCustomer(Customer customer);
}
