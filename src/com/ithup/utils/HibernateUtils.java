package com.ithup.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate工具类
 * @author acer
 *
 */
public class HibernateUtils {
	public static final Configuration CONFIGURATION;
	public static final SessionFactory FACTORY;
	//编写静态代码块
	static{
		CONFIGURATION = new Configuration().configure();
		FACTORY = CONFIGURATION.buildSessionFactory();
	}
	
	/**
	 * 创建连接session的对象
	 * @return
	 */
	public static Session getSession(){
		return FACTORY.openSession();
	}
}
