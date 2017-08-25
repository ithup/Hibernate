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
 * �ͻ�ģ��Ĳ�ѯ����
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
		//�����ͻ�����
		CustomerService customerService = new CustomerService();
		//��ÿͻ�����
		String custName = request.getParameter("custName");
		//�����������
		request.setCharacterEncoding("UTF-8");
		//��д��ѯ�ͻ�����
		List<Customer> list = customerService.findAllCustomer(custName);
		//�����صĿͻ�������request��
		request.setAttribute("list", list);
		//ʹ��request����ת��
		request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
	}

}
