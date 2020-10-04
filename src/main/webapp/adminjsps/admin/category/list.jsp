<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>分类列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/admin/css/category/list.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/css.css'/>">
  </head>
  
  <body>
    <h2 style="text-align: center;">分类列表</h2>
    <table align="center" border="1" cellpadding="0" cellspacing="0">
    	<caption class="captionAddOneLevel">
    	  <a href="<%=basePath%>adminjsps/admin/category/add.jsp">添加一级分类</a>
    	</caption>
    	<tr class="trTitle">
    		<th>分类名称</th>
    		<th>描述</th>
    		<th>操作</th>
    	</tr>
    	<c:forEach items="${cateforylist}" var="i">
    	<c:if test="${i.idpid==null}">
    		<tr class="trOneLevel">
    		<td width="200px;">${i.cname}</td>
    		<td width="200px;">${i.descs}</td>
    		<td width="200px;">
    		<a href="<%=basePath%>findAllBooktoadd2?cid=${i.cid}">添加二级分类</a>
    		<a href="<%=basePath%>findOneBookById?cid=${i.cid}">修改</a>
    		<a onclick="return confirm('您是否真要删除该一级分类及下面的所有二级分类？')" href="<%=basePath%>deleteCatefory?cid=${i.cid}">删除</a>
    		</td>
    		</tr>
			<c:forEach items="${cateforylist}" var="i1">

					<c:if test="${i1.idpid==i.cid}">
						<tr class="trTwoLevel">
							<td>${i1.cname}</td>
							<td>${i1.descs}</td>
							<td width="200px;" align="right">
								<a href="<%=basePath%>findOneBookById?cid=${i1.cid}">修改</a>
								<a onclick="return confirm('您是否真要删除该二级分类？')" href="<%=basePath%>deleteCatefory2?cid=${i1.cid}">删除</a>
							</td>
						</tr>
					</c:if>

			</c:forEach>
    	</c:if>
		</c:forEach>

 
    </table>
  </body>
</html>
