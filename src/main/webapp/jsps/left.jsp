<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>left</title>
    <base target="body"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/menu/mymenu.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='/menu/mymenu.css'/>" type="text/css" media="all">
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/left.css'/>">
<script language="javascript">
/*
 * 1. 对象名必须与第一个参数相同！
   2. 第二个参数是显示在菜单上的大标题
 */
var bar = new Q6MenuBar("bar", "传智播客网上书城");
$(function() {
	bar.colorStyle = 2;
	bar.config.imgDir = "<c:url value='/menu/img/'/>";
	bar.config.radioButton=true;	
	var array = "[";  
	<c:forEach items="${cateforylist}" var="item">
	<c:if test="${item.pid==null}">
	  array+="{\"cid\":${item.cid},\"cname\":\"${item.cname}\",\"pid\":null},"; 
	</c:if>
	<c:if test="${item.pid!=null}">
	  array+="{\"cid\":${item.cid},\"cname\":\"${item.cname}\",\"pid\":${item.pid}},"; 
	</c:if>
	</c:forEach>
	array=array.substring(0,array.length-1);
	array+="]";
	var list=JSON.parse(array);
	var yi="";
	for(var i=0;i<list.length;i++){
		if(list[i].pid==null){
			yi=list[i].cname;
		}else{
			bar.add(yi,list[i].cname,"${pageContext.request.contextPath}/user/book/selectbook.action?id="+list[i].cid,"body");
		}

	}
	
	$("#menu").html(bar.toString());
});
</script>
</head>
  
<body>  
  <div id="menu"></div>
</body>
</html>
