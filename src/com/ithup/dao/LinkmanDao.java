package com.ithup.dao;

import org.hibernate.Session;

import com.ithup.domain.Linkman;
import com.ithup.utils.HibernateUtils;

/**
 * 联系人模块：数据层
 * @author acer
 *
 */
public class LinkmanDao {

	
	/**
	 * 保存联系人
	 * @param linkman
	 */
	public void save(Linkman linkman) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(linkman);
	}

}
