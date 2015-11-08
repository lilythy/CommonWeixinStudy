package com.wxcommon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxcommon.service.AdminDataService;


public class AdminDataActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminDataActionServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("lastData")) {
			AdminDataService.getData(request);
		}else if(flag.equals("insertData")){
			if(AdminDataService.putData(request)) {
				request.setAttribute("insertState", "success");
			}else {
				request.setAttribute("insertState", "error");
			}
		}
		
		request.getRequestDispatcher("/sqldata/scoreProvince.jsp").forward(request, response);
	}

}
