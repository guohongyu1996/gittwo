<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>book_desc.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/admin/css/book/desc.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/jquery/jquery.datepick.css'/>">
<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick.js'/>"></script>
<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick-zh-CN.js'/>"></script>

<script type="text/javascript" src="<c:url value='/adminjsps/admin/js/book/desc.js'/>"></script>

<script type="text/javascript">

$(function() {
	$("#box").attr("checked", false);
	$("#formDiv").css("display", "none");
	$("#show").css("display", "");	
	
	$("#editBtn").click(function(){
		var bname = $("#bname").val();
		var currPrice = $("#currprice").val();
		var price = $("#price").val();
		var discount = $("#discount").val();
		var author = $("#author").val();
		var press = $("#press").val();
		var pid = $("#pid").val();
		var cid = $("#cid").val();
		
		if(!bname || !currPrice || !price || !discount || !author || !press || !pid || !cid ) {
			alert("图名、当前价、定价、折扣、作者、出版社、1级分类、2级分类都不能为空！");
			return false;
		}
		
		if(isNaN(currPrice) || isNaN(price) || isNaN(discount)) {
			alert("当前价、定价、折扣必须是合法小数！");
			return false;
		}
		$("#form").submit();
	});
	
	$("#delBtn").click(function(){
		var bid="${book.bid}";
		 window.location.href="<%=basePath%>deletebook?bid="+bid;
	});
	
	
	
	// 操作和显示切换
	$("#box").click(function() {
		if($(this).attr("checked")) {
			$("#show").css("display", "none");
			$("#formDiv").css("display", "");
		} else {
			$("#formDiv").css("display", "none");
			$("#show").css("display", "");		
		}
	});
	
	$("#pid").change(function(){
		var id=$("#pid").val();
		$.ajax( {
			type : "get",
			url : "<%=basePath%>ajaxselectcatefory2?id="+id,
			dataType : "json",
			success : function(data) {
				if(data!=null&&data!="") {
					var str="<option value=\"\">==请选择2级分类==</option>";
					for(var i=0;i<data.length;i++){
						str+="<option value=\""+data[i].cid+"\">"+data[i].cname+"</option>";
					}
					$("#cid").empty();
					$("#cid").append(str);
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
    <input type="checkbox" id="box"><label for="box">编辑或删除</label>
    <br/>
    <br/>
  <div id="show">
    <div class="sm">${book.bname}</div>
    <img align="top" src="<%=basePath%>getbookimgbig?bid=${book.bid}" class="tp"/>
    <div id="book" style="float:left;">
	    <ul>
	    	<li>商品编号：${book.bid}</li>
	    	<li>当前价：<span class="price_n">&yen;${book.currprice}</span></li>
	    	<li>定价：<span style="text-decoration:line-through;">&yen;${book.price}</span>　折扣：<span style="color: #c30;">${book.discount}</span>折</li>
	    </ul>
		<hr style="margin-left: 50px; height: 1px; color: #dcdcdc"/>
		<table class="tab">
			<tr>
				<td colspan="3">
					作者：${book.author}著
				</td>
			</tr>
			<tr>
				<td colspan="3">
					出版社：${book.press}
				</td>
			</tr>
			<tr>
				<td colspan="3">出版时间：<fmt:formatDate value="${book.publishtime}" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<td>版次：${book.edition}</td>
				<td>页数：${book.pagenum}</td>
				<td>字数：${book.wordnum}</td>
			</tr>
			<tr>
				<td width="180">印刷时间：<fmt:formatDate value="${book.printtime}" pattern="yyyy-MM-dd"/></td>
				<td>开本：${book.booksize}开</td>
				<td>纸张：${book.paper}</td>
			</tr>
		</table>
	</div>
  </div>
  
  
  <div id='formDiv'>
   <div class="sm">&nbsp;</div>
   <form action="<%=basePath%>updatebook?bid=${book.bid}" method="post" id="form">
   	<input type="hidden" name="bid" value=""/>
   	<input type="hidden" name="image_w" value=""/>
   	<input type="hidden" name="image_b" value=""/>
    <img align="top" src="<%=basePath%>getbookimgbig?bid=${book.bid}" class="tp"/>
    <div style="float:left;">
	    <ul>
	    	<li>商品编号：${book.bid}</li>
	    	<li>书名：　<input id="bname" type="text" name="bname" value="${book.bname}" style="width:500px;"/></li>
	    	<li>当前价：<input id="currprice" type="text" name="currprice" value="${book.currprice}" style="width:50px;"/></li>
	    	<li>定价：　<input id="price" type="text" name="price" value="${book.price}" style="width:50px;"/>
	    	折扣：<input id="discount" type="text" name="discount" value="${book.discount}" style="width:30px;"/>折</li>
	    </ul>
		<hr style="margin-left: 50px; height: 1px; color: #dcdcdc"/>
		<table class="tab">
			<tr>
				<td colspan="3">
					作者：　　<input id="author" type="text" name="author" value="${book.author}" style="width:150px;"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					出版社：　<input id="press" type="text" name="press" value="${book.press}" style="width:200px;"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">出版时间：<input id="publishtime" type="text" name="publishtime" value="<fmt:formatDate value="${book.publishtime}" pattern="yyyy-MM-dd"/>" style="width:100px;"/></td>
			</tr>
			<tr>
				<td>版次：　　<input id="edition" type="text" name="edition" value="${book.edition}" style="width:40px;"/></td>
				<td>页数：　　<input id="pagenum" type="text" name="pagenum" value="${book.pagenum}" style="width:50px;"/></td>
				<td>字数：　　<input id="wordnum" type="text" name="wordnum" value="${book.wordnum}" style="width:80px;"/></td>
			</tr>
			<tr>
				<td width="250px">印刷时间：<input id="printtime" type="text" name="printtime" value="<fmt:formatDate value="${book.printtime}" pattern="yyyy-MM-dd"/>" style="width:100px;"/></td>
				<td width="250px">开本：　　<input id="booksize" type="text" name="booksize" value="${book.booksize}" style="width:30px;"/></td>
				<td>纸张：　　<input id="paper" type="text" name="paper" value="${book.paper}" style="width:80px;"/></td>
			</tr>
			<tr>
				<td>
					一级分类：<select name="pid" id="pid" >
						<option value="">==请选择1级分类==</option>
			    		<c:forEach items="${categorylist}" var="i">
    						<option value="${i.cid}">${i.cname}</option>
    					</c:forEach>
					</select>
				</td>
				<td>
					二级分类：<select name="cid" id="cid">
						<option value="">==请先选择1级分类==</option>
					</select>
				</td>
				<td></td>
			</tr>
			<tr>
				<td colspan="2">
					<input  type="button" name="method" id="editBtn" class="btn" value="编　　辑">
					<input  type="button" name="method" id="delBtn" class="btn" value="删　　除">
				</td>
				<td></td>
			</tr>
		</table>
	</div>
   </form>
  </div>

  </body>
</html>
