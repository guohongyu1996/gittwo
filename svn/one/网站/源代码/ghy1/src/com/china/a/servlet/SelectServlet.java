package com.china.a.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.china.a.dao.Logindao;
import com.china.a.vo.Person;

public class SelectServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String pid = request.getParameter("pid");
		
		 Logindao dao=new Logindao();
		 Person p = dao.getPersonByid(Integer.parseInt(pid));
		 if (p!=null) {
		    	
		    	request.setAttribute("p", p);
		    	 request.getRequestDispatcher("Edit.jsp").forward(request, response);
			}else {
				 request.getRequestDispatcher("error.jsp").forward(request, response);
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
	}

}
