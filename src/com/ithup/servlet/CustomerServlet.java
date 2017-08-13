package com.ithup.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ithup.domain.Customer;
import com.ithup.service.CustomerService;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/customerServlet")
public class CustomerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����������
		request.setCharacterEncoding("UTF-8");
		//��ȡ�������
		Map<String, String[]> map = request.getParameterMap();
		Customer customer = new Customer();
		CustomerService customerService=new CustomerService();
		//��װ����
		try {
			BeanUtils.populate(customer, map);
			customerService.addCustomer(customer);
			System.out.println("���ӳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}