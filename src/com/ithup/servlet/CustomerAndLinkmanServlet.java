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
 * Servlet implementation class CustomerAndLinkmanServlet
 */
@WebServlet("/customerAndLinkmanServlet")
public class CustomerAndLinkmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService customerService = new CustomerService();
		List<Customer> list = customerService.findAllCustomer();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/linkman/add.jsp").forward(request, response);
	}

}
