package com.china.a.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.china.a.dao.Logindao;
import com.china.a.vo.Person;

public class DeleteServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String pid = request.getParameter("pid");
		
        // 保存在数据库中		
		
		 Logindao dao=new Logindao();
         //  删除数据   	 
		   int count= dao.deletePersonByPid(Integer.parseInt(pid));
		    if (count!=0) {
               //查询全部数据	    	
		    	List <Person> list = dao.getAllPerson();
		    	request.setAttribute("Personlist", list);
                //	请求转发方式进入页面	    	
		    	 request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}else {
                 //	请求转发方式进入页面			
				 request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		   
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
	}

}
