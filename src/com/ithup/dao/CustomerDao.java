package com.ithup.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ithup.domain.Customer;
import com.ithup.utils.HibernateUtils;

/**
 * 客户持久层类
 * @author acer
 *
 */
public class CustomerDao {
	
	
	/**
	 * 客户信息添加操作
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		//获得session对象
		Session session = HibernateUtils.getSession();
		//开启事务
		Transaction tr = session.beginTransaction();
		//保存客户
		session.save(customer);
		//提交事务
		tr.commit();
		//释放资源
		session.close();
	}

}
