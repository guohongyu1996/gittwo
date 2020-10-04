package com.china.a.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.china.a.biz.PersonBiz;
import com.china.a.vo.Person;
import com.china.tools.A;
import com.china.tools.FenYe;

public class FenYeServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		// =======接收页面的信息===========================================

		// 1.当前页： 前台JSP上传过来的页数
		String page = request.getParameter("page");
		// 2.如果 当前页<1 ，那么当前页=第1页
		int p = 0;
		if (page != null && page != "") {

			p = Integer.parseInt(page);
			if (p < 1) {
				p = 1;
			}

		}

		// 3.总记录数 : select count(*) from 表名
		FenYe fen = new FenYe();
		int zongTiao = fen.getAllPerson();

		// 4.每页显示多少条 ： 给定一个值就可能
		int tiao = A.TIAO;
		// 5.返回总页数=（总记录数-1）/一页显示多少行+1
		int zongyeshu = (zongTiao - 1) / tiao + 1;
		// 6.如果当前页数>总页数，那么当前页=总页数

		if (p > zongyeshu) {
			p = zongyeshu;
		}
		// 7.起始条数=（当前页数-1）*每页要显示的记录数+1 
		int start = (p - 1) * tiao + 1;
		// 8.结束条数=起始条数+每页要显示的记录数
		int end = start+tiao;
		
		
		 PersonBiz  biz =new PersonBiz();
		 List<Person>  list = biz.getFenyePerson(start,end);
		 
		    request.setAttribute("userlist", list);
			request.setAttribute("zongtiao", zongTiao);
			request.setAttribute("yeshu", zongyeshu);
			request.setAttribute("p", p);
			
			request.getRequestDispatcher("usersList.jsp").forward(request, response);
		

	}
		


	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
	}

}
