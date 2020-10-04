<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
    
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
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/pager/pager.css'/>" />
    <script type="text/javascript" src="<c:url value='/jsps/pager/pager.js'/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/admin/css/order/list.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/css.css'/>" />
  <script type="text/javascript">
$(function(){

	//点首页
	$("#shouye").click(function(){
		var status="${statu}";
		 window.location.href="<%=basePath%>selectallstatusorder?page=1&status="+status;
	});
	
	//点上一页
	$("#shangye").click(function(){
		var status="${statu}";
		var page="${pp.currentPageNo}";
		var pageno=parseInt(page);
		var pagenno=pageno-1;
		 window.location.href="<%=basePath%>selectallstatusorder?page="+pagenno+"&status="+status;
	});
	
	//点下一页
	$("#xiaye").click(function(){
		var status="${statu}";
		var page="${pp.currentPageNo}";
		var pageno=parseInt(page);
		var pagenno=pageno+1;
		 window.location.href="<%=basePath%>selectallstatusorder?page="+pagenno+"&status="+status;
	});
	//点末页
	$("#moye").click(function(){
		var status="${statu}";
		var page="${pp.pageAllCount}";
		 window.location.href="<%=basePath%>selectallstatusorder?page="+page+"&status="+status;
	});
	//点跳转
	$("#tiaozhuanpage").click(function(){
		var status="${statu}";
		var page=$("#tiaozhuan").val();
		if(isNaN(page)){
			alert("请输入正确的页数");
		}else{
			var pageno=parseInt(page);
			 window.location.href="<%=basePath%>selectallstatusorder?page="+pageno+"&status="+status;
		}
		

	});
	
	
});

</script>
  </head>
  
  <body>
<p class="pLink">
  <a href="<%=basePath%>selectallstatusorder?status=1">未付款</a>  |
  <a href="<%=basePath%>selectallstatusorder?status=2">已付款</a>  |
  <a href="<%=basePath%>selectallstatusorder?status=3">已发货</a>  |
  <a href="<%=basePath%>selectallstatusorder?status=4">交易成功</a>  |
  <a href="<%=basePath%>selectallstatusorder?status=5">已取消</a>
</p>
<div class="divMain">
	<div class="title">
		<div style="margin-top:7px;">
			<span style="margin-left: 150px;margin-right: 280px;">商品信息</span>
			<span style="margin-left: 40px;margin-right: 100px;">金额</span>
			<span style="margin-left: 50px;margin-right: 53px;">订单状态</span>
			<span style="margin-left: 100px;">操作</span>
		</div>
	</div>
	<br/>
	<table align="center" border="0" width="100%" cellpadding="0" cellspacing="0">
<c:forEach items="${orderlist}" var="order">	
	
		<tr class="tt">
			<td width="320px">订单号：<a  href="<%=basePath%>selectadminoneorder?oid=${order.oid }">${order.oid }</a></td>
			<td width="200px">下单时间：<fmt:formatDate value="${order.ordertime }" pattern="yyyy-MM-dd HH:mm:ss "/></td>
			<td width="178px">&nbsp;</td>
			<td width="205px">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>	

		<tr style="padding-top: 10px; padding-bottom: 10px;">
			<td colspan="2">


  <c:forEach items="${order.orderItems }" var="orderItem">
	    <img border="0" width="70" src="<%=basePath%>getbookimg?bid=${orderItem.bid }"/>
  </c:forEach>

			</td>
			<td style="padding-left: 0">
				<span class="price_t">&yen;${order.total }</span>
			</td>
			<td>
<c:choose>
	<c:when test="${order.status eq 1 }">(等待付款)</c:when>
	<c:when test="${order.status eq 2 }">(准备发货)</c:when>
	<c:when test="${order.status eq 3 }">(等待确认)</c:when>
	<c:when test="${order.status eq 4 }">(交易成功)</c:when>
	<c:when test="${order.status eq 5 }">(已取消)</c:when>
</c:choose>	
			</td>
						
			<td>
			<a href="<%=basePath%>selectadminoneorder?oid=${order.oid }">查看</a><br/>
<c:if test="${order.status eq 1 }">
				<a onclick="return confirm('您是否真要取消订单？')" href="<%=basePath%>cancleorder?oid=${order.oid }">取消</a><br/>
</c:if>
<c:if test="${order.status eq 2 }">
				<a href="<%=basePath%>fahuo?orid=${order.orid }">发货</a><br/>
</c:if>			

			</td>
		</tr>
</c:forEach>

	</table>
	<br/>
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
