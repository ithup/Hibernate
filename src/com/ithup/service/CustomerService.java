package com.ithup.service;

import java.util.List;

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
	
	/**
	 * 
	 * ��ѯ�ͻ�
	 * @return
	 */
	public List<Customer> findAllCustomer() {
		return customerDao.findAllCustomer();
	}
	/**
	 * 
	 * ��ѯ�ͻ�:��������ѯ
	 * @return
	 */
	public List<Customer> findAllCustomer(String custName) {
		return customerDao.findAllCustomer(custName);
	}

	
}
