<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'usersList.jsp' starting page</title>
    
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
    分页显示：
		<br />

		<table border="2" bgcolor="yellow" width="60%" align="center">
			<tr align="center">
				<td>
					序号
				</td>
				<td>
					姓名
				</td>
				
			</tr>

			<c:forEach items="${requestScope.userlist}" var="person">
				<tr align="center">
					<td>
						${person.pid}
					</td>
					<td>
						${person.uname}
					</td>
					
				</tr>
			</c:forEach>

		</table>
		
		<table border="2" bgcolor="yellow" width="60%" align="center">
			<tr>
				<td>
					总记录数：${requestScope.zongtiao}
				</td>
				<td>
					总页数：${requestScope.yeshu}
				</td>
				<td>
					当前页：${requestScope.p}
				</td>
				<td>
					<a href="FenYeServlet?page=1">首页|</a>
					<a href="FenYeServlet?page=${requestScope.p-1}">《前页|</a>
					<a href="FenYeServlet?page=${requestScope.p+1}">后页》|</a>
					<a href="FenYeServlet?page=${requestScope.yeshu}">末页|</a>
				</td>
				<td>
					跳转到:第&nbsp;
					<input type="text" size="3" id="pagenum">
					&nbsp;页&nbsp;
					<input type="button" value="go" onclick="fenyemeetingroom()">
				</td>
			</tr>
		</table>
  </body>
</html>
