package com.ithup.service;

import java.util.List;

import com.ithup.dao.CustomerDao;
import com.ithup.domain.Customer;

/**
 * 客户服务层
 * @author acer
 *
 */
public class CustomerService {
	private CustomerDao customerDao = new CustomerDao();
	/**
	 * 增加客户信息
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	/**
	 * 
	 * 查询客户
	 * @return
	 */
	public List<Customer> findAllCustomer() {
		return customerDao.findAllCustomer();
	}
	/**
	 * 
	 * 查询客户:带条件查询
	 * @return
	 */
	public List<Customer> findAllCustomer(String custName) {
		return customerDao.findAllCustomer(custName);
	}

	
}
