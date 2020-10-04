package com.china.a.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class YanZengServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String  uname= request.getParameter("uname");
		String  pwd  =request.getParameter("pwd");
		boolean  b=true;
		String  str ="";
		 if(b == true){//用户名可以用    JSON
			str="{\"f\":\"用户名可以使用\",\"y\":\"green\"}";
			 
			 
		 }else{//用户名不可以用
			 
			 str="{\"f\":\"不可以用\",\"y\":\"red\"}";
		 }
		 response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(str);
			out.flush();
			out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doGet(request, response);
	}

}
