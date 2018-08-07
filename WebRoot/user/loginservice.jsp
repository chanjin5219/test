<%@page import="cn.my12306.business.UserService"%>
<%@page import="cn.my12306.dao.impl.UserDaoImpl"%>
<%@page import="cn.my12306.bean.User"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	//1、取  取表单信息
	request.setCharacterEncoding("utf-8");
	String username=request.getParameter("username");
	String pwd=request.getParameter("pwd");
	
	//2、调  调用方法 使用业务逻辑层隔离界面层与数据访问层
	//UserDaoImpl dao=new UserDaoImpl();
	//User user=dao.getUser(username, pwd);
	
	UserService service=new UserService();
	User user=service.login(username, pwd);
	
	
	//3、转 跳转界面
	if(null!=user)
	{
		session.setAttribute("user", user);
	
		//创建cookie对象
		Cookie cookie=new Cookie("uid",String.valueOf(user.getId()));
		cookie.setMaxAge(60*60*24);
		cookie.setHttpOnly(true);
		//发送至客户端
		response.addCookie(cookie);
		
		Cookie cookie2=new Cookie("abc","abc");
		cookie2.setMaxAge(60*60*24);
		cookie2.setHttpOnly(true);
		
		//发送至客户端
		response.addCookie(cookie2);
	
		//重定向
		response.sendRedirect("../index.jsp");
		
		//转发
		//request.getRequestDispatcher("../index.jsp?uid="+user.getId())
		//			.forward(request, response);
		
		
		
	}
	else
		response.sendRedirect("../user/login.jsp");
%>