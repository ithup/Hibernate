package com.ithup.dao;

import org.hibernate.Session;

import com.ithup.domain.Linkman;
import com.ithup.utils.HibernateUtils;

/**
 * ��ϵ��ģ�飺���ݲ�
 * @author acer
 *
 */
public class LinkmanDao {

	
	/**
	 * ������ϵ��
	 * @param linkman
	 */
	public void save(Linkman linkman) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(linkman);
	}

}
