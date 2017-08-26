package com.ithup.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ithup.dao.CustomerDao;
import com.ithup.dao.LinkmanDao;
import com.ithup.domain.Customer;
import com.ithup.domain.Linkman;
import com.ithup.utils.HibernateUtils;

/**
 * 联系人模块：业务层
 * @author acer
 *
 */
public class LinkmanService {
	
	
	/**
	 * 保存联系人
	 * @param linkman
	 * @param cust_id
	 */
	public void save(Linkman linkman, Long cust_id) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			//查询客户：根据id查询,封装客户数据
			Customer customer = new CustomerDao().findCustomerById(cust_id);
			//为联系人设置客户值
			linkman.setCustomer(customer);
			//保存联系人
			new LinkmanDao().save(linkman);
			System.out.println("--------------");
			System.out.println(linkman.getCustomer().getCust_name());
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
	}
	
	
}
