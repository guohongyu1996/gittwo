package com.china.a.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.china.a.dao.Logindao;
import com.china.a.vo.Person;

public class DengluServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		if(uname!=null && uname !="" && pwd !=null && pwd !=""){
		Logindao dao=new Logindao();
		 boolean b= dao.getPersonByUnameandPwd(uname.trim(),pwd.trim());
		 if (b==true) {
//			 得到用户信息放入session（会话）中
			 HttpSession session= request.getSession();
			 session.setMaxInactiveInterval(30);
			 Person person=new Person();
			 person.setUname(uname);
			 person.setPwd(pwd);
			 session.setAttribute("p1", person);
			 
//		     Cookie c1=new Cookie("uname", uname);
//			 Cookie c2=new Cookie("pwd", pwd);
			 
//			 c1.setMaxAge(3600);
//		     c2.setMaxAge(3600);
			 
//			 response.addCookie(c1);
//			 response.addCookie(c2);
			 
			 ServletContext sc= this.getServletContext();
			 Object obj = sc.getAttribute("count");
			 if (obj == null) {
				sc.setAttribute("count", 1);
				
			}else {
				int i= Integer.parseInt(obj.toString());
				i=i+1;
				sc.setAttribute("count", i);
			}
			 
//			 查询所有用户信息
		
			 List <Person> list = dao.getAllPerson();
			 request.setAttribute("Personlist", list);
		    	 request.getRequestDispatcher("welcome.jsp").forward(request, response);
		 
			}else {
				 request.setAttribute("msg", "账号密码不对");
				 request.getRequestDispatcher("Denglu.jsp").forward(request, response);
			}
		}
		else {
			 request.setAttribute("msg", "账号密码不对");
			 request.getRequestDispatcher("Denglu.jsp").forward(request, response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doGet(request, response);
	}

}
