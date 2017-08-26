package com.ithup.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.ithup.domain.Customer;
import com.ithup.domain.Linkman;
import com.ithup.utils.HibernateUtils;

/**
 * 客户和联系人的双向关联
 * @author acer
 *
 */
public class CustomerLinkman {
	
	/**
	 * 级联保存联系人：
	 */
	@Test
	public void saveLinkmanAndCustomer(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, 1L);
		Linkman linkman = new Linkman();
		linkman.setLkm_name("周伯通");
		linkman.setCustomer(customer);
		session.save(linkman);
		tr.commit();
	}
	
	
	
	/**
	 * cascade和inverse的区别:
	 * 		总结：一的一方放弃外键维护、多的一方级联保存
	 */
	@Test
	public void cascadeAndInverse(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//创建客户对象
		Customer customer = new Customer();
		customer.setCust_name("光头强1");
		//创建联系人
		Linkman linkman = new Linkman();
		linkman.setLkm_name("熊大1");
		Linkman linkman1 = new Linkman();
		linkman1.setLkm_name("熊二1");
		//级联保存:保存客户关联联系人
		//关联联系人
		/*customer.getLinkMan().add(linkman);
		customer.getLinkMan().add(linkman1);
		//保存用户
		session.save(customer);*/
		//总结：一的一方放弃外键维护、多的一方级联保存
		//联系人级联保存
		linkman.setCustomer(customer);
		linkman1.setCustomer(customer);
		//保存联系人
		session.save(linkman);
		session.save(linkman1);
		tr.commit();
	}
	
	
	@Test
	public void customerLinkman(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, 2L);
		Linkman linkman = session.get(Linkman.class, 1L);
		//使用双向关联
		customer.getLinkMan().add(linkman);
		linkman.setCustomer(customer);
		//自动更新
		tr.commit();
	}
	
	
	@Test
	public void deleteCustomerLinkman4(){
		/**
		 * 解除关系：从集合中删除联系人
		 */
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//先获得用户
		Customer customer = session.get(Customer.class, 1L);
		//再获得要解除关系的联系人
		Linkman linkman = session.get(Linkman.class, 1L);
		//customer用户解除linkman联系人的关系
		customer.getLinkMan().remove(linkman);//级联删除
		tr.commit();
	}
	
	@Test
	public void deleteCustomerLinkman3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		/**
		 * 级联删除联系人：删除客户——》设置级联客户:删除联系人
		 * 
		 */
		Linkman linkman = session.get(Linkman.class, 1L);
		session.delete(linkman);
		tr.commit();
	}
	
	@Test
	public void deleteCustomerLinkman2(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		/**
		 * 级联删除联系人：删除客户
		 * 
		 */
		Linkman linkman = session.get(Linkman.class, 1L);
		session.delete(linkman);
		tr.commit();
	}
	
	@Test
	public void deleteCustomerLinkman1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		/**
		 * 级联删除用户：用户下有联系人
		 * 
		 */
		Customer customer = session.get(Customer.class, 1L);
		session.delete(customer);
		tr.commit();
	}
	
	@Test
	public void deleteCustomerLinkman(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		/**
		 * 删除用户
		 * 
		 */
		Customer customer = session.get(Customer.class, 1L);
		session.delete(customer);
		tr.commit();
	}
	
	
	/**
	 * 级联保存：
	 */
	@Test
	public void testCustomerLinkman3(){
		//获得session对象
		Session session = HibernateUtils.getCurrentSession();
		//开启事务
		Transaction tr = session.beginTransaction();
		//创建客户对象
		Customer customer = new Customer();
		customer.setCust_name("光头强1");
		//创建联系人
		Linkman linkman = new Linkman();
		linkman.setLkm_name("熊大1");
		Linkman linkman1 = new Linkman();
		linkman1.setLkm_name("熊二1");
		
		//客户关联联系人1
		customer.getLinkMan().add(linkman);
		//联系人关联客户
		linkman1.setCustomer(customer);
		//保存联系人
		session.save(linkman1);
		//保存客户
		session.save(customer);
		//提交事务
		tr.commit();
		//释放资源
	}
	
	/**
	 * 级联保存：保存联系人，级联用户
	 */
	@Test
	public void testCustomerLinkman2(){
		//获得session对象
		Session session = HibernateUtils.getCurrentSession();
		//开启事务
		Transaction tr = session.beginTransaction();
		//创建客户对象
		Customer customer = new Customer();
		customer.setCust_name("光头强5");
		//创建联系人
		Linkman linkman = new Linkman();
		linkman.setLkm_name("熊大1");
		/*Linkman linkman1 = new Linkman();
		linkman1.setLkm_name("熊二1");*/
		//创建单向关联操作
		linkman.setCustomer(customer);
		//linkman1.setCustomer(customer);
		//保存用户
		session.save(linkman);
		//session.save(linkman1);
		//提交事务
		tr.commit();
		//释放资源
	}
	
	/**
	 * 级联保存：保存用户，级联联系人
	 */
	@Test
	public void testCustomerLinkman1(){
		//获得session对象
		Session session = HibernateUtils.getCurrentSession();
		//开启事务
		Transaction tr = session.beginTransaction();
		//创建客户对象
		Customer customer = new Customer();
		customer.setCust_name("光头强1");
		//创建联系人
		Linkman linkman = new Linkman();
		linkman.setLkm_name("熊大1");
		Linkman linkman1 = new Linkman();
		linkman1.setLkm_name("熊二1");
		//创建单向关联操作
		customer.getLinkMan().add(linkman);
		customer.getLinkMan().add(linkman1);
		//保存用户
		session.save(customer);
		//提交事务
		tr.commit();
		//释放资源
	}
	
	
	@Test
	public void testCustomerLinkman(){
		//获得session对象
		Session session = HibernateUtils.getCurrentSession();
		//开启事务
		Transaction tr = session.beginTransaction();
		//创建客户对象
		Customer customer = new Customer();
		customer.setCust_name("光头强1");
		//创建联系人
		Linkman linkman = new Linkman();
		linkman.setLkm_name("熊大1");
		Linkman linkman1 = new Linkman();
		linkman1.setLkm_name("熊二1");
		//创建双向关联操作
		customer.getLinkMan().add(linkman);
		customer.getLinkMan().add(linkman1);
		linkman.setCustomer(customer);
		linkman1.setCustomer(customer);
		//保存操作
		session.save(customer);
		session.save(linkman);
		session.save(linkman1);
		//提交事务
		tr.commit();
		//释放资源
	}
}
