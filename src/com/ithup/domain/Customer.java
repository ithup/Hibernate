package com.ithup.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 客户信息实体类：一个客户有多个联系人 一的一方
 * 
 * @author acer
 *
 */
public class Customer {

	private Long cust_id; // 客户编号(主键)
	private String cust_name; // 客户名称(公司名称)
	private Long cust_user_id; // 负责人id
	private Long cust_create_id; // 创建人id
	private String cust_source; // 客户信息来源
	private String cust_industry; // 客户所属行业
	private String cust_level; // 客户级别
	private String cust_phone;// 固定电话
	private String cust_mobile;// 移动电话

	/**
	 * 联系人：
	 * 一个客户有多个联系人，使用set集合来配置
	 */
	private Set<Linkman> linkMan = new HashSet<>();

	public Set<Linkman> getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(Set<Linkman> linkMan) {
		this.linkMan = linkMan;
	}

	public Long getCust_id() {
		return cust_id;
	}

	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public Long getCust_user_id() {
		return cust_user_id;
	}

	public void setCust_user_id(Long cust_user_id) {
		this.cust_user_id = cust_user_id;
	}

	public Long getCust_create_id() {
		return cust_create_id;
	}

	public void setCust_create_id(Long cust_create_id) {
		this.cust_create_id = cust_create_id;
	}

	public String getCust_source() {
		return cust_source;
	}

	public void setCust_source(String cust_source) {
		this.cust_source = cust_source;
	}

	public String getCust_industry() {
		return cust_industry;
	}

	public void setCust_industry(String cust_industry) {
		this.cust_industry = cust_industry;
	}

	public String getCust_level() {
		return cust_level;
	}

	public void setCust_level(String cust_level) {
		this.cust_level = cust_level;
	}

	public String getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

	public String getCust_mobile() {
		return cust_mobile;
	}

	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}

}
