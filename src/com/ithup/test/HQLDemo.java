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
 * 演示HQL的基本查询
 * @author acer
 *
 */
public class HQLDemo {
	/**
	 * 聚合函数：count(),sum(),max(),min(),avg();
	 */
	@Test
	public void run8(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//查询所有联系人的数量
		//List<Number> list = session.createQuery("select sum(lkm_id) from Linkman").list();
		//List<Number> list = session.createQuery("select avg(lkm_id) from Linkman").list();
		//List<Number> list = session.createQuery("select max(lkm_id) from Linkman").list();
		List<Number> list = session.createQuery("select min(lkm_id) from Linkman").list();
		//Number number = list.get(0);
		//通过下标值取值
		int value = list.get(0).intValue();
		System.out.println(value);
		tr.commit();
	}
	
	/**
	 * 聚合函数：count(),sum(),max(),min(),avg();
	 */
	@Test
	public void run7(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//查询所有联系人的数量
		List<Number> list = session.createQuery("select count(*) from Linkman").list();
		//Number number = list.get(0);
		//通过下标值取值
		int value = list.get(0).intValue();
		System.out.println(value);
		tr.commit();
	}
	
	/**
	 * 投影查询：只查询几个字段，
	 */
	@Test
	public void run6(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//创建HQL查询接口
		Query query = session.createQuery("select lkm_name,lkm_gender from Linkman");
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		tr.commit();
	}
	
	
	
	/**
	 * 按条件进行查询
	 */
	@Test
	public void run5(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//创建HQL查询接口
		Query query = session.createQuery("from Linkman where lkm_id > ? and lkm_gender = ?");
	    //query.setString(0, "女");
		//query.setString("gender", "女");
		//通用的方法
		query.setParameter(0, 2L);
		query.setParameter(1, "女");
		List<Linkman> list = query.list();
		for (Linkman linkman : list) {
			System.out.println(linkman);
		}
		tr.commit();
	}
	
	
	
	/**
	 * 分页查询：
	 *    setFirstResult(a)		-- 从哪条记录开始，如果查询是从第一条开启，值是0
	 *    setMaxResults(b)		-- 每页查询的记录条数
	 * 
	 */
	@Test
	public void run4(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//创建HQL查询接口
		Query query = session.createQuery("from Linkman order by lkm_id");
		//分页查询，调用方法查询第一页的数据
		/*query.setFirstResult(0);
		query.setMaxResults(3);*/
		//查询第二页数据
		query.setFirstResult(3);
		query.setMaxResults(3);
		List<Linkman> list = query.list();
		for (Linkman linkman : list) {
			System.out.println(linkman.toString());
		}
		tr.commit();
	}
	
	/**
	 * 排序 查询
	 * 
	 */
	@Test
	public void run3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//创建HQL查询接口
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
		//创建HQL查询接口
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
