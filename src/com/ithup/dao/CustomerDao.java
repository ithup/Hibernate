package com.ithup.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

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

}
