package com.ithup.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate������
 * @author acer
 *
 */
public class HibernateUtils {
	public static final Configuration CONFIGURATION;
	public static final SessionFactory FACTORY;
	//��д��̬�����
	static{
		CONFIGURATION = new Configuration().configure();
		FACTORY = CONFIGURATION.buildSessionFactory();
	}
	
	/**
	 * ��������session�Ķ���
	 * @return
	 */
	public static Session getSession(){
		return FACTORY.openSession();
	}
}
