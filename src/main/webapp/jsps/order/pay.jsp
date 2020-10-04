<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>pay.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/order/pay.css'/>">
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>

<script type="text/javascript">
$(function() {
	$("#zhifu").click(function() {
		var total="${order.total }";
		var balance="${sessionScope.user.balance}";
		if(Number(total)>Number(balance)){
			alert("账户余额不足，请联系管理员");
		}else{
			
			$("#form1").submit();
			
		}
	});
});
</script>
  </head>
  
  <body>
<div class="divContent">
	<span class="spanPrice">支付金额：</span><span class="price_t">&yen;${order.total }</span>
	<span class="spanOid">编号：${order.orid }</span>
</div>
<form action="${pageContext.request.contextPath}/user/order/pay.action?orid=${order.orid }" method="post" id="form1" >
<input type="hidden" name="orid" value="${order.orid }"/>
<div class="divBank">
	
	<div style="margin-left: 20px;">
	  账户余额：${sessionScope.user.balance}
	</div>
	<div style="margin: 40px;">
		<input type="button" id="zhifu" value="确认付款">
	</div>
</div>
</form>
  </body>
</html>
