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
    <title>注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/user/regist.css'/>">

	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsps/js/user/regist.js'/>"></script>
	<script type="text/javascript">
	$(function(){
		$("#loginname").blur(function(){
			var value=$("#loginname").val();
			$.ajax({
				url:"<%=basePath%>ajaxloginname",
                data:{loginname:value},
				type:"POST",
				dataType:"json",
				success:function(data) {
					if(data.result==1) {
						$("#ajaxloginname").html("用户名已被注册！");
					}else{
						$("#ajaxloginname").html("");
					}
				},
				error : function(jqXHR) {
					
					alert("发生错误：" + jqXHR.status);
				}
			});
		});
	});
	
	</script>
  </head>
  
  <body>
<div id="divMain">
  <div id="divTitle">
    <span id="spanTitle">新用户注册</span>
  </div>
  <div id="divBody">
<form action="<%=basePath%>registuser" method="post" id="registForm">
    <table id="tableForm">
      <tr>
        <td class="tdText">用户名：</td>
        <td class="tdInput">
          <input class="inputClass" type="text" name="loginname" id="loginname" value="${form.loginname }"/>
        </td>
        <td class="tdError">
          <div id="ajaxloginname"></div><label class="errorClass" id="loginnameError">${errors.loginname }</label>
        </td>
      </tr>
      <tr>
        <td class="tdText">登录密码：</td>
        <td>
          <input class="inputClass" type="password" name="loginpassword" id="loginpassword" value="${form.loginpass }"/>
        </td>
        <td>
          <label class="errorClass" id="loginpassError">${errors.loginpass }</label>
        </td>
      </tr>
      <tr>
        <td class="tdText">确认密码：</td>
        <td>
          <input class="inputClass" type="password" name="reloginpass" id="reloginpass" value="${form.reloginpass }"/>
        </td>
        <td>
          <label class="errorClass" id="reloginpassError">${errors.reloginpass}</label>
        </td>
      </tr>
      <tr>
        <td></td>
        <td>
          <input type="image" src="<%=basePath%>images/regist1.jpg" id="submitBtn"/>
        </td>
        <td>
          <label></label>
        </td>
      </tr>
      <tr>
      <td><center><h2>${result}</h2></center></td>
      </tr>
    </table>
</form>    
  </div>
</div>
  </body>
</html>
