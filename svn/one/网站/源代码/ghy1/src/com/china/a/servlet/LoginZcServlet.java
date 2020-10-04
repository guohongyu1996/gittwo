package com.china.a.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginZcServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
        //       ajax的异步请求和form表单提交的同步请求后台代码的唯一区别就是响应客户端的方式变了
		//		获取响应输出流
		PrintWriter writer = response.getWriter();
       //		打印输出到网页的客户端
		writer.print("登录成功！用户名："+username+"，密码："+passwd);
		writer.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doGet(request, response);
	}

}
