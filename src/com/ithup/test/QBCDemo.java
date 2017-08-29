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
 * QBC的查询：纯面向对象的查询
 * @author acer
 *
 */
public class QBCDemo {
	
	/**
	 * QBC聚合函数
	 */
	@Test
	public void run3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//创建QBC查询接口
		Criteria criteria = session.createCriteria(Linkman.class);
		//设置聚合函数的方式
		criteria.setProjection(Projections.count("lkm_id"));
		List<Number> list = criteria.list();
		long longValue = list.get(0).longValue();
		System.out.println(longValue);
		tr.commit();
	}
	
	
	
	/**
	 * QBC条件查询
	 */
	@Test
	public void run2(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//创建QBC查询接口
		/** Restrictions.eq			-- 相等
		* Restrictions.gt			-- 大于号
		* Restrictions.ge			-- 大于等于
		* Restrictions.lt			-- 小于
		* Restrictions.le			-- 小于等于
		* Restrictions.between		-- 在之间
		* Restrictions.like			-- 模糊查询
		* Restrictions.in			-- 范围
		* Restrictions.and			-- 并且
		* Restrictions.or			-- 或者*/
		Criteria criteria = session.createCriteria(Linkman.class);
		//使用方法添加条件
		//criteria.add(Restrictions.eq("lkm_gender", "女"));
		//criteria.add(Restrictions.gt("lkm_id", 3L));
		//criteria.add(Restrictions.between("lkm_id", 4L, 7L));
		//criteria.add(Restrictions.like("lkm_name", "%"+"1"+"%"));
		//Object[] values ={1L,4L};
		//List<Long> values = new ArrayList<Long>();
		//values.add(1L);
		//values.add(5L);
		//criteria.add(Restrictions.in("lkm_id", values));
		//criteria.add(Restrictions.and(Restrictions.eq("lkm_gender", "男"), Restrictions.gt("lkm_id", 4L)));
		criteria.add(Restrictions.or(Restrictions.eq("lkm_gender", "男"), Restrictions.gt("lkm_id", 5L)));
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
		//创建QBC查询接口
		Criteria criteria = session.createCriteria(Customer.class);
		//调用排序的方法
		criteria.addOrder(Order.asc("cust_id"));
		//设置分页的方法
		criteria.setFirstResult(0);
		criteria.setMaxResults(3);
		List<Customer> list = criteria.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		tr.commit();
	}
}
