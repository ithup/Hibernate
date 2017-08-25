package com.ithup.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
	
	/**
	 * 客户查询
	 * @return
	 */
	public List<Customer> findAllCustomer() {
		//获得session对象
		Session session = HibernateUtils.getSession();
		//开启事务
		Transaction tr = session.beginTransaction();
		//查询客户
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		//提交 事务
		tr.commit();
		//释放资源
		session.close();
		return list;
	}
	
	/**
	 * 客户查询:带条件查询
	 * @return
	 */
	public List<Customer> findAllCustomer(String custName) {
		//获得session对象
		Session session = HibernateUtils.getSession();
		//开启事务
		Transaction tr = session.beginTransaction();
		//查询客户
		Criteria criteria = session.createCriteria(Customer.class);
		//增加带条件的查询custName
		if(custName != null && !custName.trim().isEmpty()){
			criteria.add(Restrictions.ilike("cust_name", "%"+custName+"%"));
		}
		//查询
		List<Customer> list = criteria.list();
		//提交 事务
		tr.commit();
		//释放资源
		session.close();
		return list;
	}

}
