package com.ithup.service;

import com.ithup.dao.CustomerDao;
import com.ithup.domain.Customer;

/**
 * �ͻ������
 * @author acer
 *
 */
public class CustomerService {
	private CustomerDao customerDao = new CustomerDao();
	/**
	 * ���ӿͻ���Ϣ
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
}
