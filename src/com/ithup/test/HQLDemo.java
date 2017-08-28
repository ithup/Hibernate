package com.ithup.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.ithup.domain.Customer;
import com.ithup.domain.Linkman;
import com.ithup.utils.HibernateUtils;

/**
 * ��ʾHQL�Ļ�����ѯ
 * @author acer
 *
 */
public class HQLDemo {
	
	
	/**
	 * ���������в�ѯ
	 */
	@Test
	public void run5(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//����HQL��ѯ�ӿ�
		Query query = session.createQuery("from Linkman where lkm_id > ? and lkm_gender = ?");
	    //query.setString(0, "Ů");
		//query.setString("gender", "Ů");
		//ͨ�õķ���
		query.setParameter(0, 2L);
		query.setParameter(1, "Ů");
		List<Linkman> list = query.list();
		for (Linkman linkman : list) {
			System.out.println(linkman);
		}
		tr.commit();
	}
	
	
	
	/**
	 * ��ҳ��ѯ��
	 *    setFirstResult(a)		-- ��������¼��ʼ�������ѯ�Ǵӵ�һ��������ֵ��0
	 *    setMaxResults(b)		-- ÿҳ��ѯ�ļ�¼����
	 * 
	 */
	@Test
	public void run4(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//����HQL��ѯ�ӿ�
		Query query = session.createQuery("from Linkman order by lkm_id");
		//��ҳ��ѯ�����÷�����ѯ��һҳ������
		/*query.setFirstResult(0);
		query.setMaxResults(3);*/
		//��ѯ�ڶ�ҳ����
		query.setFirstResult(3);
		query.setMaxResults(3);
		List<Linkman> list = query.list();
		for (Linkman linkman : list) {
			System.out.println(linkman.toString());
		}
		tr.commit();
	}
	
	/**
	 * ���� ��ѯ
	 * 
	 */
	@Test
	public void run3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//����HQL��ѯ�ӿ�
		List<Linkman> list = session.createQuery("from Linkman order by lkm_id desc").list();
		for (Linkman linkman : list) {
			System.out.println(linkman.toString());
		}
		tr.commit();
	}
	
	@Test
	public void run(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//����HQL��ѯ�ӿ�
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for (Customer customer : list) {
			Set<Linkman> linkMan = customer.getLinkMan();
			for (Linkman linkman2 : linkMan) {
				System.out.println(linkman2.getLkm_name());
				System.out.println("======================");
			}
		}
		tr.commit();
	}
}
