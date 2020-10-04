package com.china.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.china.a.dao.Logindao;

public class Shulistener implements  ServletContextListener{
//销毁方法
	public void contextDestroyed(ServletContextEvent arg0) {
		// 往数据库里存东西
		
		ServletContext sc = arg0.getServletContext();
		int count =(Integer) sc.getAttribute("count");
		Logindao logindao=new Logindao();
		int i = logindao.saveShu(count);
	}
//初始化方法
	public void contextInitialized(ServletContextEvent arg0) {
		// 从数据库里拿东西
		Logindao logindao=new Logindao();
		int i = logindao.getShu();
		ServletContext sc = arg0.getServletContext();
		sc.setAttribute("count", 1);
		
	}

}
