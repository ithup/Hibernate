package com.ithup.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.ithup.domain.Customer;
import com.ithup.domain.Linkman;
import com.ithup.utils.HibernateUtils;

/**
 * 1. 唯一标识OID的检索方式
 *		* session.get(对象.class,OID)
 * 2. 对象的导航的方式
 * @author acer
 *
 */
public class Demo {
	@Test
	public void run1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//唯一标识OID的检索方式
		Linkman linkman = session.get(Linkman.class, 1L);
		//对象的导航的方式
		Customer customer = linkman.getCustomer();
		System.out.println(customer.getCust_name());
		tr.commit();
	}
	@Test
	public void run(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//唯一标识OID的检索方式
		Customer customer = session.get(Customer.class, 1L);
		//对象的导航的方式
		Set<Linkman> linkMan = customer.getLinkMan();
		for (Linkman linkman2 : linkMan) {
			System.out.println(linkman2.getLkm_name());
		}
		tr.commit();
	}
}
