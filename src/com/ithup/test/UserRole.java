package com.ithup.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.ithup.domain.Role;
import com.ithup.domain.User;
import com.ithup.utils.HibernateUtils;

/**
 * 系统用户与角色测试
 * @author acer
 *
 */
public class UserRole {
	
	/**
	 * 现在：周三用户，有2个角色，经理和职员
	 * 让张三没有职员角色
	 * 			分析：就是对集合的操作
	 */
	@Test
	public void run3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//获得周三的用户
		User user = session.get(User.class, 1L);
		//获得职员角色
		Role role = session.get(Role.class,2L);
		//从周三对象中移除职员这个角色
		user.getRoles().remove(role);
		//由于当前操作处于持久态：有自动更新数据的能力
		tr.commit();
	}

	/**
	 * 级联保存
	 */
	@Test
	public void run1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//创建用户对象
		User user1 = new User();
		user1.setUser_code("周三");
		User user2 = new User();
		user2.setUser_code("郭靖");
		
		//创建角色
		Role role1 = new Role();
		role1.setRole_name("经理");
		Role role2 = new Role();
		role2.setRole_name("职员");
		
		//级联保存
		user1.getRoles().add(role1);
		user1.getRoles().add(role2);
		user2.getRoles().add(role1);
		
		session.save(user1);
		session.save(user2);
		tr.commit();
	}
	
	
	@Test
	public void run(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//创建用户对象
		User user1 = new User();
		user1.setUser_code("周三");
		User user2 = new User();
		user2.setUser_code("郭靖");
		
		//创建角色
		Role role1 = new Role();
		role1.setRole_name("经理");
		Role role2 = new Role();
		role2.setRole_name("职员");
		
		//双向关联保存
		user1.getRoles().add(role1);
		user1.getRoles().add(role2);
		user2.getRoles().add(role2);
		
		role1.getUsers().add(user1);
		role2.getUsers().add(user1);
		role2.getUsers().add(user2);
		
		session.save(user1);
		session.save(user2);
		session.save(role1);
		session.save(role2);
		tr.commit();
	}
}





