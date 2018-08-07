package cn.my12306.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.my12306.bean.User;
import cn.my12306.business.UserService;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1、取  取表单信息
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		
		//2、调  调用方法 使用业务逻辑层隔离界面层与数据访问层
		UserService service=new UserService();
		User user=null;
		try {
			user=service.login(username, pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//3、转 跳转界面
		if(null!=user)
		{
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
		
			//创建cookie对象
			Cookie  cookie=new Cookie("uid",String.valueOf(user.getId()));
			cookie.setMaxAge(60*60*24);
			cookie.setHttpOnly(true);
			//发送至客户端
			response.addCookie(cookie);
			
			Cookie cookie2=new Cookie("abc","abc");
			cookie2.setMaxAge(60*60*24);
			cookie2.setHttpOnly(true);
			
			//发送至客户端
			response.addCookie(cookie2);
		
			//返回客户端json数据
			String usermsg="{'msg':'ok','uid':'"+user.getId()+"','uname':'"+user.getRealname()+"'}";
			out.print(usermsg);
			
			
			//重定向
//			response.sendRedirect("../index.jsp");
			
			//转发
			//request.getRequestDispatcher("../index.jsp?uid="+user.getId())
			//			.forward(request, response);
			
			
			
		}
		else
		{
			String msg="{'msg':'error'}";
			out.print(msg);
		}			//response.sendRedirect("../user/login.jsp");
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
