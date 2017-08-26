package com.ithup.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ithup.dao.CustomerDao;
import com.ithup.dao.LinkmanDao;
import com.ithup.domain.Customer;
import com.ithup.domain.Linkman;
import com.ithup.utils.HibernateUtils;

/**
 * ��ϵ��ģ�飺ҵ���
 * @author acer
 *
 */
public class LinkmanService {
	
	
	/**
	 * ������ϵ��
	 * @param linkman
	 * @param cust_id
	 */
	public void save(Linkman linkman, Long cust_id) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			//��ѯ�ͻ�������id��ѯ,��װ�ͻ�����
			Customer customer = new CustomerDao().findCustomerById(cust_id);
			//Ϊ��ϵ�����ÿͻ�ֵ
			linkman.setCustomer(customer);
			//������ϵ��
			new LinkmanDao().save(linkman);
			System.out.println("--------------");
			System.out.println(linkman.getCustomer().getCust_name());
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
	}
	
	
}
