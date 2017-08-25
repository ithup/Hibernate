package com.ithup.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ithup.domain.Customer;
import com.ithup.utils.HibernateUtils;

/**
 * �ͻ��־ò���
 * @author acer
 *
 */
public class CustomerDao {
	
	
	/**
	 * �ͻ���Ϣ��Ӳ���
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		//���session����
		Session session = HibernateUtils.getSession();
		//��������
		Transaction tr = session.beginTransaction();
		//����ͻ�
		session.save(customer);
		//�ύ����
		tr.commit();
		//�ͷ���Դ
		session.close();
	}
	
	/**
	 * �ͻ���ѯ
	 * @return
	 */
	public List<Customer> findAllCustomer() {
		//���session����
		Session session = HibernateUtils.getSession();
		//��������
		Transaction tr = session.beginTransaction();
		//��ѯ�ͻ�
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		//�ύ ����
		tr.commit();
		//�ͷ���Դ
		session.close();
		return list;
	}
	
	/**
	 * �ͻ���ѯ:��������ѯ
	 * @return
	 */
	public List<Customer> findAllCustomer(String custName) {
		//���session����
		Session session = HibernateUtils.getSession();
		//��������
		Transaction tr = session.beginTransaction();
		//��ѯ�ͻ�
		Criteria criteria = session.createCriteria(Customer.class);
		//���Ӵ������Ĳ�ѯcustName
		if(custName != null && !custName.trim().isEmpty()){
			criteria.add(Restrictions.ilike("cust_name", "%"+custName+"%"));
		}
		//��ѯ
		List<Customer> list = criteria.list();
		//�ύ ����
		tr.commit();
		//�ͷ���Դ
		session.close();
		return list;
	}

}
