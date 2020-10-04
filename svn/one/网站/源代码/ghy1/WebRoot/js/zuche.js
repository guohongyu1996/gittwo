$(function() {
	
	
	$("#uname").blur(jianChaUname);
	$("#pwd").blur(jianPwd);
	
	$("#form1").submit(function(){
		
		var   f = true;
		if(jianChaUname() == false){f=false; }
		if(jianPwd() == false){f=false; }
		return f;
	});
	
 

});

function   jianChaUname(){
	
	var  uname = $("#uname").val();
	 if(uname == ""){
//		 提示信息 
		 $("#unamemsg").html("<font color=\"red\">用户名不能为空！</font>");
		 return false;
	 }
	 return true;
	 
	
}
function   jianPwd(){
	
	var  pwd = $("#pwd").val();
	 if(pwd == ""){
		 $("#pwdmsg").html("<font color=\"red\">密码不能为空！</font>");
		 return false;
	 }
	 if(isNaN(pwd)){//是数字false   不是数字true
		 
		
		  $("#pwdmsg").html("<font color=\"red\">密码只能为数字</font>");
	 }
	 
	 if(pwd.length>5 && pwd.length<10){
		 
		 $("#pwdmsg").html("<font color=\"red\">密码长充在5-10之间</font>");
		 return false;
	 }
	  return true;
	
}