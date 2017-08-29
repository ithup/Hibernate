package com.ithup.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.ithup.domain.Customer;
import com.ithup.domain.Linkman;
import com.ithup.utils.HibernateUtils;

/**
 * QBC�Ĳ�ѯ�����������Ĳ�ѯ
 * @author acer
 *
 */
public class QBCDemo {
	
	/**
	 * QBC�ۺϺ���
	 */
	@Test
	public void run3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//����QBC��ѯ�ӿ�
		Criteria criteria = session.createCriteria(Linkman.class);
		//���þۺϺ����ķ�ʽ
		criteria.setProjection(Projections.count("lkm_id"));
		List<Number> list = criteria.list();
		long longValue = list.get(0).longValue();
		System.out.println(longValue);
		tr.commit();
	}
	
	
	
	/**
	 * QBC������ѯ
	 */
	@Test
	public void run2(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//����QBC��ѯ�ӿ�
		/** Restrictions.eq			-- ���
		* Restrictions.gt			-- ���ں�
		* Restrictions.ge			-- ���ڵ���
		* Restrictions.lt			-- С��
		* Restrictions.le			-- С�ڵ���
		* Restrictions.between		-- ��֮��
		* Restrictions.like			-- ģ����ѯ
		* Restrictions.in			-- ��Χ
		* Restrictions.and			-- ����
		* Restrictions.or			-- ����*/
		Criteria criteria = session.createCriteria(Linkman.class);
		//ʹ�÷����������
		//criteria.add(Restrictions.eq("lkm_gender", "Ů"));
		//criteria.add(Restrictions.gt("lkm_id", 3L));
		//criteria.add(Restrictions.between("lkm_id", 4L, 7L));
		//criteria.add(Restrictions.like("lkm_name", "%"+"1"+"%"));
		//Object[] values ={1L,4L};
		//List<Long> values = new ArrayList<Long>();
		//values.add(1L);
		//values.add(5L);
		//criteria.add(Restrictions.in("lkm_id", values));
		//criteria.add(Restrictions.and(Restrictions.eq("lkm_gender", "��"), Restrictions.gt("lkm_id", 4L)));
		criteria.add(Restrictions.or(Restrictions.eq("lkm_gender", "��"), Restrictions.gt("lkm_id", 5L)));
		List<Linkman> list = criteria.list();
		for (Linkman linkman : list) {
			System.out.println(linkman);
		}
		tr.commit();
	}
	
	@Test
	public void run1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//����QBC��ѯ�ӿ�
		Criteria criteria = session.createCriteria(Customer.class);
		//��������ķ���
		criteria.addOrder(Order.asc("cust_id"));
		//���÷�ҳ�ķ���
		criteria.setFirstResult(0);
		criteria.setMaxResults(3);
		List<Customer> list = criteria.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		tr.commit();
	}
}
