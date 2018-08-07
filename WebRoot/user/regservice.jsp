<%@page import="cn.my12306.business.UserService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.my12306.bean.User" %>
<%
	//1、取
	String username=request.getParameter("username");
	String pwd=request.getParameter("password");
	String realname=request.getParameter("realname");
	Integer sex=Integer.parseInt(request .getParameter("sex"));
	Integer prov=Integer.parseInt(request .getParameter("province"));
	Integer city=Integer.parseInt(request .getParameter("city"));
	Integer certtype=Integer.parseInt(request .getParameter("certType"));
	String cert=request.getParameter("cert");
	String date=request.getParameter("birthday");
	Integer userType=Integer.parseInt(request .getParameter("userType"));
	String remark=request.getParameter("content");
	
	User user=new User(0,username, pwd, 0,
			realname,sex,city, certtype,
			cert, date, userType, remark,
			0, request.getLocalAddr(),null);
	
	
	//2、调用业务逻辑层
	UserService service=new UserService();
	int rs=service.register(user);

	//3、跳转界面
	if(rs==1)
		response.sendRedirect("../index.jsp");
	else
		response.sendRedirect("../user/registration.jsp");
	


%>