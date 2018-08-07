
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.my12306.bean.User"%>
<%@page import="javax.naming.Context"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-3.3.1.js" ></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		#logDv{
			width: 500px;
			height: 500px;
			z-index: 100;
			position: absolute;
			left: 400px;
			top:300px;
			display: none;
		}
		
		#loginmsg{
			display: none;
		}
		
	</style>
  </head>
  
  <body>

	<div id="loginmsg">
		
		
	</div>

   	<a href="user/login.jsp">User Login</a><br/><br/>
   	<a href="">Manager Login</a><br/><br/>
   	<a href="user/registration.jsp">Registration</a><br/><br/>
   	<a href="first.jsp">first</a><br/><br/>
   	
   	 sessionid:<%=session.getId() %>
   	 
   	 <a id="alog" href="#" >login</a>
   	 
   	 <div id="logDv">
   	 	<fieldset>
  			<legend>Login</legend>
  			<form>
    			用户名：<input type="text" id="username" name="username" value=""><br/>
    			密&nbsp;&nbsp;码 <input type="password" id="pwd" name="pwd" value=""/><br/>
    			<input type="button" id="btn" value="Login">
    		</form>
  		</fieldset>
   	 </div>
   	 
  </body>
</html>
<script>
$(function(){
	$("#alog").click(function(){
		$("#logDv").show(1500);
	});
	
	$("#btn").click(function(){
		$.post("http://localhost:8080/my12306/user/loginservlet",//地址
			{"username": $("#username").val(),"pwd": $("#pwd").val()},//参数
		   	function(data){//回调函数
		   		
		   		alert(data);
//		   		if(date.msg=="ok")
//		   		{
//		   			$("#logDv").hide(1500);
//		   			$("loginmsg").html(data);
//		   			$("loginmsg").show(1500);
//		   		}
//		   		else
//		   		{
//		   			alert("该用户不存在！");
//		   		}	
		   	},
		   	"json");
		
		
	})
	
	
	
	
	
})
	
	
</script>










