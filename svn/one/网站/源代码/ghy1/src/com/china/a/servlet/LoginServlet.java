package com.china.a.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.china.a.dao.Logindao;
import com.china.a.vo.Person;
import com.china.tools.DateFormaty;
import com.oreilly.servlet.MultipartRequest;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
//		向tomcat中的img存放图片
		String path = this.getServletContext().getRealPath("\\img\\");
//		上传附件（请求，路径url，附件大小，字符编码）
		MultipartRequest res = new MultipartRequest(request,path,50*1024*1024,"utf-8");
		Enumeration er = res.getFileNames();
//		装文件名的变量
		String filename="";
		while (er.hasMoreElements()) {
//			上传文件文本框的名字
			String kuangname=(String)er.nextElement();
			System.out.println(kuangname);
//			获得图片的名字
			filename += res.getFilesystemName(kuangname)+"-";
		}
		
		
		
//		===接收页面信息==========================
	    String uname = res.getParameter("uname");
	    String pwd = res.getParameter("pwd");
	    String sex = res.getParameter("sex");
	    String brithday = res.getParameter("birthday");
	    String[] likes = res.getParameterValues("like");
	    String biye = res.getParameter("biye");
	    String str="";
	    if (likes !=null ){
	    for (String s : likes) {
			str+= s +",";
		}
	    }
	    Person person=new Person();
	    
	    person.setUname(uname);
	    person.setPwd(pwd);
	    person.setSex(sex);
	    person.setBrithday(brithday);
	    person.setLikes(str);
	    person.setBiye(DateFormaty.stringToDate(biye));
	    person.setPicurl(filename);
	    
	    Logindao dao=new Logindao();
	   int count= dao.savePerson(person);
	    if (count!=0) {
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
		doGet(request, response);
	}

}
