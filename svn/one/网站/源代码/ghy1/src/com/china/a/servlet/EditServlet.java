package com.china.a.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.china.a.dao.Logindao;
import com.china.a.vo.Person;

public class EditServlet extends HttpServlet {

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String pid = request.getParameter("pid");
	    String uname = request.getParameter("uname");
	    String pwd = request.getParameter("pwd");
	    String sex = request.getParameter("sex");
	    String brithday = request.getParameter("birthday");
	    String[] likes = request.getParameterValues("like");
	    String str="";
	   if (likes !=null) {
		   for (String s : likes) {
				str+=s+",";
			}
		   System.out.println(str);
	}
	    
        //保存在数据库中	    
	    Person person=new Person();
	    person.setPid(Integer.parseInt(pid));
	    person.setUname(uname);
	    person.setPwd(pwd);
	    person.setSex(sex);
	    person.setBrithday(brithday);
	    person.setLikes(str);
	    
	    Logindao dao=new Logindao();
       //更新数据	    
	   int count= dao.updatePersonByID(person);
      	   
	    if (count!=0) {
        //查找全部数据    	
	    	List <Person> list = dao.getAllPerson();
	    	request.setAttribute("Personlist", list);
	    	 request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else {
			 request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	   
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
	}

}
