package com.wxcommon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginActionServlet extends HttpServlet{

	private static final long serialVersionUID = -8380880269430155022L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String path = request.getContextPath();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("wjl")&&password.equals("1015")) {
			request.getSession().setAttribute("username", "admin");
			response.sendRedirect(path + "/sqldata/scoreProvince.jsp");
		}else {
			response.sendRedirect(path + "/index.jsp");
		}
		
	}

}
