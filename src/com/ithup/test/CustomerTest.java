package com.ithup.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.ithup.dao.CustomerDao;
import com.ithup.domain.Customer;
import com.ithup.utils.HibernateUtils;

/**
 * 客户测试类
 * 
 * @author acer
 *
 */
public class CustomerTest {
	/*@Test
	public void testSave() {
		// 加载配置文件
		Configuration config = new Configuration().configure();
		// 创建SessionFactory 对象
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 创建session对象
		Session session = sessionFactory.openSession();
		// 开启事务
		Transaction tr = session.beginTransaction();

		// 创建客户对象
		Customer customer = new Customer();
		customer.setCust_name("tom");
		customer.setCust_level("4");
		// 保存对象
		session.save(customer);
		// 提交事务
		tr.commit();
		// 释放资源
		session.close();
		sessionFactory.close();
	}

	@Test
	public void testSave1() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// 创建客户对象
		Customer customer = new Customer();
		customer.setCust_name("tom");
		customer.setCust_level("4");
		// 保存对象
		session.save(customer);
		// 提交事务
		tr.commit();
		session.close();
	}*/
	
	/**
	 * 客户查询测试
	 */
	@Test
	public void testFindAllCustomer(){
		CustomerDao customerDao = new CustomerDao();
		List<Customer> list = customerDao.findAllCustomer("强");
		for (Customer customer : list) {
			System.out.println(customer.getLinkMan());
		}
	}
}

