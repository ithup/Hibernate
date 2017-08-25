package com.ithup.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ithup.domain.Customer;
import com.ithup.service.CustomerService;

/**
 * 客户模块的查询管理
 */
@WebServlet("/customerListServlet")
public class CustomerListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建客户对象
		CustomerService customerService = new CustomerService();
		//获得客户名称
		String custName = request.getParameter("custName");
		//处理请求编码
		request.setCharacterEncoding("UTF-8");
		//编写查询客户方法
		List<Customer> list = customerService.findAllCustomer(custName);
		//将返回的客户集存入request域
		request.setAttribute("list", list);
		//使用request请求转发
		request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
	}

}
