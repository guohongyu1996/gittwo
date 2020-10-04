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
    <title>图书分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/admin/css/book/list.css'/>">
<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/pager/pager.css'/>" />
<script type="text/javascript" src="<c:url value='/jsps/pager/pager.jsp'/>"></script>

<script type="text/javascript" src="<c:url value='/adminjsps/admin/js/book/list.js'/>"></script>

<script type="text/javascript">
$(function(){

	//点首页
	$("#shouye").click(function(){
		var bname="${book.bname}";
		var author="${book.author}";
		var press="${book.press}";

		 window.location.href="<%=basePath%>gjselectBook?page=1&bname="+bname+"&author="+author+"&press="+press;
	});
	
	//点上一页
	$("#shangye").click(function(){
		var bname="${book.bname}";
		var author="${book.author}";
		var press="${book.press}";

		var page="${pp.currentPageNo}";
		var pageno=parseInt(page);
		var pagenno=pageno-1;
		 window.location.href="<%=basePath%>gjselectBook?page="+pagenno+"&bname="+bname+"&author="+author+"&press="+press;
	});
	
	//点下一页
	$("#xiaye").click(function(){
		var bname="${book.bname}";
		var author="${book.author}";
		var press="${book.press}";

		var page="${pp.currentPageNo}";
		var pageno=parseInt(page);
		var pagenno=pageno+1;
		 window.location.href="<%=basePath%>gjselectBook?page="+pagenno+"&bname="+bname+"&author="+author+"&press="+press;
	});
	//点末页
	$("#moye").click(function(){
		var page="${pp.pageAllCount}";
		var bname="${book.bname}";
		var author="${book.author}";
		var press="${book.press}";

		 window.location.href="<%=basePath%>gjselectBook?page="+page+"&bname="+bname+"&author="+author+"&press="+press;
	});
	//点跳转
	$("#tiaozhuanpage").click(function(){
		var bname="${book.bname}";
		var author="${book.author}";
		var press="${book.press}";

		var page=$("#tiaozhuan").val();
		if(isNaN(page)){
			alert("请输入正确的页数");
		}else{
			var pageno=parseInt(page);
			 window.location.href="<%=basePath%>gjselectBook?page="+pageno;
		}
		

	});
	
	
});

</script>


  </head>
  
  <body>
<div class="divBook">
<ul>


<c:forEach items="${booklist}" var="item">
<li>
  <div class="inner">
    <a class="pic" href="<%=basePath%>selectonebook?bid=${item.bid}"><img src="<%=basePath%>getbookimg?bid=${item.bid}" border="0" height="200px" width="160px"/></a>
    <p class="price" >
		<span class="price_n">&yen;${item.currprice}</span>
		<span class="price_r">&yen;${item.price}</span>
		(<span class="price_s">${item.discount}折</span>)
	</p>
	<p>${item.bname}</p>
	<p>${item.author}著</p>
	<p class="publishing">
		<span>出版社：</span>${item.press}
	</p>
  </div>
 </li>
</c:forEach>
 
</ul>
</div>
<div style="float:left; width: 100%; text-align: center;">
	<table border="0" width="100%"  id="fenye">
		<tr>
		<td>总记录数<div id="zongjilushu">${pp.recordAllCount}</div></td>
		<td>总页数<div id="zongyeshu">${pp.pageAllCount}</div></td>
		<td>当前页数<div id="dangqianyeshu">${pp.currentPageNo}</div></td>
		<td ><input type="button" value="首页" id="shouye"><input type="button" value="上一页" id="shangye"><input type="button" value="下一页" id="xiaye"><input type="button" value="末页" id="moye">跳转到第<input type="text" name="page" id="tiaozhuan" size="2"> 页  <input type="button" value="Go" id="tiaozhuanpage"></td></tr>
		</table>
</div>
  </body>
 
</html>

