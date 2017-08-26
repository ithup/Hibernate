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

import com.ithup.domain.Linkman;
import com.ithup.service.LinkmanService;

/**
 * Servlet implementation class AddLinkmanServlet
 */
@WebServlet("/addLinkmanServlet")
public class AddLinkmanServlet extends HttpServlet {
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
		//�����������
		request.setCharacterEncoding("UTF-8");
		//��ȡ�������
		Map<String, String[]> map = request.getParameterMap();
		//��ÿͻ�id
		String custid = map.get("cust_id")[0];
		//����ת��
		Long cust_id = Long.parseLong(custid);
		//������ϵ�˶���
		Linkman linkman = new Linkman();
		//��װ����
		try {
			BeanUtils.populate(linkman, map);
			//����ҵ���
			new LinkmanService().save(linkman,cust_id);
			System.out.println("����ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
