package com.china.a.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.china.a.vo.Address;

public class ShiServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String sheng = request.getParameter("sheng");
		
		  //查询完毕
				List<Address>list  =new ArrayList<Address>();
				
				Address  a =new Address();
				a.setId("shi1");
				a.setName("cc");
				
				Address  b =new Address();
				b.setId("shi2");
				b.setName("jl");
				
				Address  c =new Address();
				c.setId("shi3");
				c.setName("yj");
				
				list.add(a);
				list.add(b);
				list.add(c);
				
				//list集合--JSON串
				//JSON   jar包里的类  toJSONString(Object)
				String str = JSON.toJSONString(list);
				
				System.out.println("st = "+str);
				
				//st = [{"id":"shi1","name":"cc"},{"id":"shi2","name":"jl"},{"id":"shi3","name":"yj"}]
				
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
