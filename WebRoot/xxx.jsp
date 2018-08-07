<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<c:set var="uname" value="jack" />
  	
  	
  	
    <h1>${key}</h1>
     <h1>${sessionkey}</h1>
     
     <h1>
     <c:out value="${uname}" default="12312"></c:out>
     </h1>
     
     <h1>
    ${uname}
     </h1>
  </body>
</html>
