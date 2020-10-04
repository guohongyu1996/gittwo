package com.china.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener ,HttpSessionAttributeListener{

	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("ssession ，生成了");
		
		
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("ssession ，销毁了");
		
	}

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("添加");
		ServletContext sc = arg0.getSession().getServletContext();
		Object obj = sc.getAttribute("shu");
		if (obj == null) {
			sc.setAttribute("shu", 1);
		} else {
           int num= (Integer)obj;
           num=num+1;
           sc.setAttribute("shu",num);
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("删除");
		ServletContext  sc = arg0.getSession().getServletContext();
		Object obj = sc.getAttribute("shu");
		  int num =(Integer)obj; 
			num=num-1;
			sc.setAttribute("shu",num);
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("替换");
		
	}

}
