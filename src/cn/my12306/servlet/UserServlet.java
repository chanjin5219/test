package cn.my12306.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * url
 * @author lynn
 *
 */
public class UserServlet extends HttpServlet {
	
	public UserServlet() {
		System.out.println("实例化：UserServlet");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("初始化：UserServlet");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String  value=this.getInitParameter("kkk");
		out.print("<h1>刘赫加班！"+value+"</h1>");
		
		System.out.println("doGet:UserServlet");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doPost:UserServlet");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy:UserServlet");
	}
	
}
