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
		//处理请求编码
		request.setCharacterEncoding("UTF-8");
		//获取请求参数
		Map<String, String[]> map = request.getParameterMap();
		//获得客户id
		String custid = map.get("cust_id")[0];
		//类型转换
		Long cust_id = Long.parseLong(custid);
		//创建联系人对象
		Linkman linkman = new Linkman();
		//封装对象
		try {
			BeanUtils.populate(linkman, map);
			//调用业务层
			new LinkmanService().save(linkman,cust_id);
			System.out.println("保存成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
