package com.ithup.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.ithup.domain.Customer;
import com.ithup.domain.Linkman;
import com.ithup.utils.HibernateUtils;

/**
 * �ͻ�����ϵ�˵�˫�����
 * @author acer
 *
 */
public class CustomerLinkman {
	@Test
	public void deleteCustomerLinkman3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		/**
		 * ����ɾ����ϵ�ˣ�ɾ���ͻ����������ü����ͻ�:ɾ����ϵ��
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
		 * ����ɾ����ϵ�ˣ�ɾ���ͻ�
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
		 * ����ɾ���û����û�������ϵ��
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
		 * ɾ���û�
		 * 
		 */
		Customer customer = session.get(Customer.class, 1L);
		session.delete(customer);
		tr.commit();
	}
	
	
	/**
	 * �������棺
	 */
	@Test
	public void testCustomerLinkman3(){
		//���session����
		Session session = HibernateUtils.getCurrentSession();
		//��������
		Transaction tr = session.beginTransaction();
		//�����ͻ�����
		Customer customer = new Customer();
		customer.setCust_name("��ͷǿ1");
		//������ϵ��
		Linkman linkman = new Linkman();
		linkman.setLkm_name("�ܴ�1");
		Linkman linkman1 = new Linkman();
		linkman1.setLkm_name("�ܶ�1");
		
		//�ͻ�������ϵ��1
		customer.getLinkMan().add(linkman);
		//��ϵ�˹����ͻ�
		linkman1.setCustomer(customer);
		//������ϵ��
		session.save(linkman1);
		//����ͻ�
		session.save(customer);
		//�ύ����
		tr.commit();
		//�ͷ���Դ
	}
	
	/**
	 * �������棺������ϵ�ˣ������û�
	 */
	@Test
	public void testCustomerLinkman2(){
		//���session����
		Session session = HibernateUtils.getCurrentSession();
		//��������
		Transaction tr = session.beginTransaction();
		//�����ͻ�����
		Customer customer = new Customer();
		customer.setCust_name("��ͷǿ1");
		//������ϵ��
		Linkman linkman = new Linkman();
		linkman.setLkm_name("�ܴ�1");
		Linkman linkman1 = new Linkman();
		linkman1.setLkm_name("�ܶ�1");
		//���������������
		linkman.setCustomer(customer);
		linkman1.setCustomer(customer);
		//�����û�
		session.save(linkman);
		session.save(linkman1);
		//�ύ����
		tr.commit();
		//�ͷ���Դ
	}
	
	/**
	 * �������棺�����û���������ϵ��
	 */
	@Test
	public void testCustomerLinkman1(){
		//���session����
		Session session = HibernateUtils.getCurrentSession();
		//��������
		Transaction tr = session.beginTransaction();
		//�����ͻ�����
		Customer customer = new Customer();
		customer.setCust_name("��ͷǿ1");
		//������ϵ��
		Linkman linkman = new Linkman();
		linkman.setLkm_name("�ܴ�1");
		Linkman linkman1 = new Linkman();
		linkman1.setLkm_name("�ܶ�1");
		//���������������
		customer.getLinkMan().add(linkman);
		customer.getLinkMan().add(linkman1);
		//�����û�
		session.save(customer);
		//�ύ����
		tr.commit();
		//�ͷ���Դ
	}
	
	
	@Test
	public void testCustomerLinkman(){
		//���session����
		Session session = HibernateUtils.getCurrentSession();
		//��������
		Transaction tr = session.beginTransaction();
		//�����ͻ�����
		Customer customer = new Customer();
		customer.setCust_name("��ͷǿ1");
		//������ϵ��
		Linkman linkman = new Linkman();
		linkman.setLkm_name("�ܴ�1");
		Linkman linkman1 = new Linkman();
		linkman1.setLkm_name("�ܶ�1");
		//����˫���������
		customer.getLinkMan().add(linkman);
		customer.getLinkMan().add(linkman1);
		linkman.setCustomer(customer);
		linkman1.setCustomer(customer);
		//�������
		session.save(customer);
		session.save(linkman);
		session.save(linkman1);
		//�ύ����
		tr.commit();
		//�ͷ���Դ
	}
}
