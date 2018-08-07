package cn.my12306.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.my12306.bean.User;
import cn.my12306.business.UserService;


public class RegisteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1¡¢È¡
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
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
		
		//2¡¢
		UserService service=new UserService();
		int rs=-1;
		try {
			rs = service.register(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3¡¢×ª
		if(rs==1)
			response.sendRedirect("../index.jsp");
		else
			response.sendRedirect("../user/registration.jsp");

	}
}
