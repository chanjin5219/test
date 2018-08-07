<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="cn.my12306.bean.User"%>


  
  	<c:if test="${ not empty user }">
  		welcome <h1>${user.id}</h1>   ${user.realname}	
  	</c:if>
  	<c:if test="${empty user}">
  		<a href="user/login.jsp">未登录</a>
  	</c:if>
  	
	<br/>
	<%
		Integer count=(Integer)application.getAttribute("count");
		if(null!=count)
		{
			count+=1;
		}
		else
			count=1;
		
		application.setAttribute("count", count);
	 %>
	
	当前在线人数：<%=count%>
	
	