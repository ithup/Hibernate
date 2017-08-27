package com.ithup.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.ithup.domain.Role;
import com.ithup.domain.User;
import com.ithup.utils.HibernateUtils;

/**
 * ϵͳ�û����ɫ����
 * @author acer
 *
 */
public class UserRole {
	
	/**
	 * ���ڣ������û�����2����ɫ�������ְԱ
	 * ������û��ְԱ��ɫ
	 * 			���������ǶԼ��ϵĲ���
	 */
	@Test
	public void run3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//����������û�
		User user = session.get(User.class, 1L);
		//���ְԱ��ɫ
		Role role = session.get(Role.class,2L);
		//�������������Ƴ�ְԱ�����ɫ
		user.getRoles().remove(role);
		//���ڵ�ǰ�������ڳ־�̬�����Զ��������ݵ�����
		tr.commit();
	}

	/**
	 * ��������
	 */
	@Test
	public void run1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//�����û�����
		User user1 = new User();
		user1.setUser_code("����");
		User user2 = new User();
		user2.setUser_code("����");
		
		//������ɫ
		Role role1 = new Role();
		role1.setRole_name("����");
		Role role2 = new Role();
		role2.setRole_name("ְԱ");
		
		//��������
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
		//�����û�����
		User user1 = new User();
		user1.setUser_code("����");
		User user2 = new User();
		user2.setUser_code("����");
		
		//������ɫ
		Role role1 = new Role();
		role1.setRole_name("����");
		Role role2 = new Role();
		role2.setRole_name("ְԱ");
		
		//˫���������
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





