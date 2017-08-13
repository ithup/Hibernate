package com.ithup.service;

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
	
}
