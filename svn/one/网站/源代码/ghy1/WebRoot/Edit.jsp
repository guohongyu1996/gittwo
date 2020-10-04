<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@page import="com.china.a.vo.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Edit.jsp' starting page</title>
    
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
   <form action="EditServlet" method="get">
            <%
          Person  p  = (Person)request.getAttribute("p");
            String str1="";
            String str2="";
            String  sex =  p.getSex();
            if(sex !=null){
            if("woman".equals(sex))
             {
                str1="checked";
               }else{
                 str2="checked";
              }
              }
             %>
			用户名:
			<input type="text" name="uname" value="<%=p.getUname()%>"/>
			<input type="hidden" name="pid"  value="<%=p.getPid()%>"/>
			<br />
			密码:
			<input type="text" name="pwd"  value="<%=p.getPwd()   %>"/>
			<br />
			性别：
			<input type="radio" name="sex" value="woman" <%=str1%>/>
			女
			<input type="radio" name="sex" value="man" <%=str2%>/>
			男
			<br />
			<%
               String  like =p.getLikes();
               String  l1="";
               String  l2="";
               if(like !=null){
               String  []  arr = like.split(",");
               for(String si : arr){
               if("eat".equals(si)){
               l1="checked";
               }
               if("drink".equals(si)){
               l2="checked";
               }
              }
             }
                %>
			
			爱好：
			<input type="checkbox" name="like" value="eat" <%= l1 %>/>
			吃
			<input type="checkbox" name="like" value="drink" <%= l2 %>/>
			喝
			<br />
			<%
			String  s = p.getBrithday();
			  
			  String  s1="";
			  String  s2="";
			  String  s3="";
			  if(s!=null){
			  if("1".equals(s)){
			  
			    s1="selected";
			  }
			   else if("2".equals(s)){
			    s2="selected";
			  }
			   if("3".equals(s)){
			    s3="selected";
			  }
			 }
			%>
			生日：
			<select name="birthday">
				<option value="1"  <%= s1 %>>
					1月
				</option>
				<option value="2" <%= s2 %> >
					2月
				</option>
				<option value="3" <%= s3 %>> 
					3月
				</option>
			</select>
			<br/>
			<input type="submit" value="登录" />
		
			</form>
			
			</body>
</html>			

