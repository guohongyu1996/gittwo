<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript">
		function checkForm() {
			if(!$("#cname").val()) {
				alert("分类名不能为空！");
				return false;
			}
			if(!$("#idpid").val()) {
				alert("一级分类不能为空！");
				return false;
			}
			if(!$("#descs").val()) {
				alert("分类描述不能为空！");
				return false;
			}

			return true;
		}
	</script>
<style type="text/css">
	body {background: rgb(254,238,189);}
</style>
  </head>
  
  <body>
    <h3>添加2级分类</h3>
    <h1></h1>
    <p style="font-weight: 900; color: red">${msg }</p>
    <form action="<%=basePath%>insertCatefory2" method="post" onsubmit="return checkForm()">
    	分类名称：<input type="text" name="cname" id="cname"/><br/>
    	一级分类：<select name="idpid" id="idpid">
    	<option value="">===选择1级分类===</option>
    		<c:forEach items="${category1list}" var="i">
    			<c:if test="${i.idpid == null}">
					<c:if test="${i.cid==requestScope.category.cid}"><option value="${i.cid}" selected="selected">${i.cname}</option></c:if>
					<c:if test="${i.cid!=requestScope.category.cid}"><option value="${i.cid}">${i.cname}</option></c:if>
				</c:if>
    		</c:forEach>
    	</select><br/>
    	分类描述：<textarea rows="5" cols="50" name="descs" id="descs"></textarea><br/>
    	<input type="submit" value="添加二级分类"/>
    	<input type="button" value="返回" onclick="history.go(-1)"/>
    </form>
  </body>
</html>