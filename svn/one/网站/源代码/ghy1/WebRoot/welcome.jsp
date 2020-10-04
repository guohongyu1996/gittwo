<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.china.a.vo.*"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  欢迎${sessionScope.p1.uname } 您是第${applicationScope.count }登录的用户
  在线人数${applicationScope.shu} 
   用户信息： <br/>
   <TABLE width="70%" border="1">
<TR>
	<TD>pid</TD>
	<TD>uname</TD>
	<TD>pwd</TD>
	<TD>Sex</TD>
	<TD>birthday</TD>
	<TD>Likes</TD>
	<TD>biye</TD>
	<TD>pic</TD>
	<TD>操作</TD>
</TR>
<c:forEach items="${requestScope.Personlist}" var="p">
<TR>
	<TD>
	<c:if test="${p.pid ==10}">
	 ${p.pid}
	</c:if>
	<c:if test="${p.pid !=10}"></c:if>
	${p.pid+100} 
	 </TD>
	<TD>${p.uname} </TD>
	<TD>${p.pwd}</TD>
	<TD>${p.sex}</TD>
	<TD>${p.brithday}</TD>
	<TD>${p.likes}</TD>
	<TD><fmt:formatDate value="${p.biye}" type="date"/></TD>
	<TD> 
	<c:forTokens items="${p.picurl}" delims="-" var="z">
	
	<img src="<%=basePath%>img/${z}"/>
	</c:forTokens>       
	
	</TD>
	<TD><a href="DeleteServlet?pid=${p.pid}">删除 </a>
	    <a href="SelectServlet?pid=${p.pid}">修改 </a>
	</TD>
</TR>

</c:forEach>
</TABLE>
  <a href="admin.jsp">进入admin页面</a>
  </body>
</html>
