<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     <script language="javascript" type="text/javascript"
	         src="My97DatePicker/WdatePicker.js">
	 </script>
	 
	 <script language="javascript" type="text/javascript"
	          src="js/jquery-1.8.3.min.js">
	 </script>
	 
	 <script language="javascript" type="text/javascript"
			 src="js/sanji.js">
	 </script>
	
	 <script language="javascript" type="text/javascript"
			 src="js/zuche.js">
     </script>
	 
	 <script type="text/javascript">
	 function a(){
	  var uname=$("#uname").val();
	  var pwd=$("#pwd").val();
	$.post(
   "YanZengServlet",{uname:uname,pwd:pwd},
    callBackFunc);
  
   function callBackFunc(data){           
    if(data.y  == "red"){
		  $("#msg").html("<font color=\"red\">"+data.f+"</font>");
		}
	else{
		  $("#msg").html("<font color=\"green\">"+data.f+"</font>");
    }      
   }
   }
   </script>
  </head>
  
  <body>
   <form action="LoginServlet" method="post"  id="form1" enctype="multipart/form-data">
   用户名：<input type="text" name="uname" id="uname"   >
     <span id="unamemsg"></span><br/>
   密码：<input type="password" name="pwd" id="pwd"><br/>
     <span id="pwdmsg"></span><br/>
  性别：<input type="radio" name="sex" value="woman">女
       <input type="radio" name="sex" value="man">男 <br/>
 爱好：<input type="checkbox" name="like" value="eat">吃
      <input type="checkbox" name="like" value="drink">喝<br/>
  生日：<select name="birthday">
       <option value="1">
             1月
       </option>
       <option value="2">
             2月
       </option>
       <option value="3">
             3月
       </option>
       
      </select><br/>
      时间：<input type="text" name="biye"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
        <br/>
       照骗1： <input type="file" name="pic1"><br/>
       照骗2：  <input type="file" name="pic2"><br/>
       省：
		<select id="se">
		    <option value="">
				请选择城省
			</option>
			<option value="ji">
				吉林省
			</option>
			<option value="liao">
				辽宁省
			</option>
			</select><br />
			市：
			<select id="si">
			<option value="">
				请选择城市
			</option>
		
			
			
			</select>
			<br />
			区：
			<select id="qu">
			<option value="">
				请选择区
			</option>
			</select>
			<br />
        
      <input type="submit" value="登录">
      
   </form>
  </body>
</html>
