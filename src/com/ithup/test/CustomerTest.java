/*package com.ithup.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.ithup.domain.Customer;
import com.ithup.utils.HibernateUtils;

*//**
 * �ͻ�������
 * 
 * @author acer
 *
 *//*
public class CustomerTest {
	@Test
	public void testSave() {
		// ���������ļ�
		Configuration config = new Configuration().configure();
		// ����SessionFactory ����
		SessionFactory sessionFactory = config.buildSessionFactory();
		// ����session����
		Session session = sessionFactory.openSession();
		// ��������
		Transaction tr = session.beginTransaction();

		// �����ͻ�����
		Customer customer = new Customer();
		customer.setCust_name("tom");
		customer.setCust_level("4");
		// �������
		session.save(customer);
		// �ύ����
		tr.commit();
		// �ͷ���Դ
		session.close();
		sessionFactory.close();
	}

	@Test
	public void testSave1() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// �����ͻ�����
		Customer customer = new Customer();
		customer.setCust_name("tom");
		customer.setCust_level("4");
		// �������
		session.save(customer);
		// �ύ����
		tr.commit();
		session.close();
	}
}
*/