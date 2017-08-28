package com.ithup.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.ithup.domain.Customer;
import com.ithup.domain.Linkman;
import com.ithup.utils.HibernateUtils;

/**
 * 1. Ψһ��ʶOID�ļ�����ʽ
 *		* session.get(����.class,OID)
 * 2. ����ĵ����ķ�ʽ
 * @author acer
 *
 */
public class Demo {
	@Test
	public void run1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//Ψһ��ʶOID�ļ�����ʽ
		Linkman linkman = session.get(Linkman.class, 1L);
		//����ĵ����ķ�ʽ
		Customer customer = linkman.getCustomer();
		System.out.println(customer.getCust_name());
		tr.commit();
	}
	@Test
	public void run(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//Ψһ��ʶOID�ļ�����ʽ
		Customer customer = session.get(Customer.class, 1L);
		//����ĵ����ķ�ʽ
		Set<Linkman> linkMan = customer.getLinkMan();
		for (Linkman linkman2 : linkMan) {
			System.out.println(linkman2.getLkm_name());
		}
		tr.commit();
	}
}
