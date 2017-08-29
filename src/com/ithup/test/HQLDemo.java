package com.ithup.test;

import java.util.Arrays;
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
	 * �ۺϺ�����count(),sum(),max(),min(),avg();
	 */
	@Test
	public void run8(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//��ѯ������ϵ�˵�����
		//List<Number> list = session.createQuery("select sum(lkm_id) from Linkman").list();
		//List<Number> list = session.createQuery("select avg(lkm_id) from Linkman").list();
		//List<Number> list = session.createQuery("select max(lkm_id) from Linkman").list();
		List<Number> list = session.createQuery("select min(lkm_id) from Linkman").list();
		//Number number = list.get(0);
		//ͨ���±�ֵȡֵ
		int value = list.get(0).intValue();
		System.out.println(value);
		tr.commit();
	}
	
	/**
	 * �ۺϺ�����count(),sum(),max(),min(),avg();
	 */
	@Test
	public void run7(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//��ѯ������ϵ�˵�����
		List<Number> list = session.createQuery("select count(*) from Linkman").list();
		//Number number = list.get(0);
		//ͨ���±�ֵȡֵ
		int value = list.get(0).intValue();
		System.out.println(value);
		tr.commit();
	}
	
	/**
	 * ͶӰ��ѯ��ֻ��ѯ�����ֶΣ�
	 */
	@Test
	public void run6(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//����HQL��ѯ�ӿ�
		Query query = session.createQuery("select lkm_name,lkm_gender from Linkman");
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		tr.commit();
	}
	
	
	
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
