$(function() {
 // 省的下拉如果改变值就那changeg
	$("#se").change(function() {
	
    var sheng =  $("#se").val();
    //省---找--市
    chaShi(sheng);
    
	});
	
	
	
	$("#si").change(function() {
	
    var si =  $("#si").val();
    chaQu(si);
    
	});

});
function  chaQu(si){
	
	
	$.post(
			 "QuServlet", {si:si}, 
		    callBackQu
		    );
	
	
}
function  callBackQu(data){
	
	
		  //[{"id":"shi1","name":"cc"},{"id":"shi2","name":"jl"},{"id":"shi3","name":"yj"}]
	  var  str="<option value=\"\">请选择区</option>";
	   for(var i=0;i<data.length;i++){
		   str+="<option value=\""+ data[i].id+"\">"+data[i].name+"</option>";
		   
		   
	   }
	  alert(str);//<option value="shi1">cc</option><option value="shi2">jl</option><option value="shi3">yj</option>
	  
	   $("#qu").html("");
	 $("#qu").append(str);
	
}


//根据省查出市
function   chaShi(sheng){
	
	
	$.post(
			 "ShiServlet", {sheng:sheng}, 
		    callBackShi
		    );
	}

//得到市，在页面显示出来
 function  callBackShi(data)
   {
		  //[{"id":"shi1","name":"cc"},{"id":"shi2","name":"jl"},{"id":"shi3","name":"yj"}]
	  var  str="<option value=\"\">请选择市</option>";
	   for(var i=0;i<data.length;i++){
		   str  += "<option value=\""+ data[i].id+"\">"+data[i].name+"</option>";
		   
		   
	   }
	  alert(str);//<option value="shi1">cc</option><option value="shi2">jl</option><option value="shi3">yj</option>
	 
	 $("#si").html(""); 
	 $("#si").append(str);
	 
    }