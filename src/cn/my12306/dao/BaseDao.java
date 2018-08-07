package cn.my12306.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * 数据访问层
 * 1、BaseDao
 * 2、每张表对应一个数据访问接口
 * 3、每个接口至少有一个数据访问实现类
 * 
 * 

 */
public class BaseDao {
	
	private static final  String driver="com.mysql.jdbc.Driver";
	private static final  String url="jdbc:mysql://localhost:3306/12306?SSL=false";
	private static final  String user="root";
	private static final  String pwd="123456";
	

	/**
	 * 获取连接对象
	 * @return Connection
	 */
	public static Connection  getConn()
	{
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, pwd);
			
//			Context context=new InitialContext();
//			DataSource ds=(DataSource)context.lookup("java:comp/env/my12306");
//			conn=ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	/**
	 * 执行增删改的通用方法
	 * @param sql 
	 * @param objs ?的参数值，按顺序填充
	 * @return int 受影响的行数
	 */
	public static int executeUpdate(String sql,Object[] objs)
	{
		int rs=-1;
		Connection conn=null;
		PreparedStatement pstate=null;
		try {
			conn=BaseDao.getConn();//1、2	String sql="update users set pwd=?,ismanager=? where id=?";//3、
			pstate=conn.prepareStatement(sql);
			//设置参数
			if(objs!=null)
			{
				for (int i = 0; i < objs.length; i++) {
					pstate.setObject(i+1, objs[i]);
				}
			}
			rs=pstate.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			BaseDao.close(null, pstate, conn);
		}
		return rs;
	}
	
	
	public static ResultSet executeQuery(String sql,Object[] objs)
	{
		Connection conn=null;
		PreparedStatement pstate=null;
		ResultSet rs=null;
		try {
			conn=BaseDao.getConn();
			pstate=conn.prepareStatement(sql);
			if(objs!=null)
				for (int i = 0; i < objs.length; i++) {
					pstate.setObject(i+1, objs[i]);
				}
			rs=pstate.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	
	
	
	
	
	/**
	 * 释放资源
	 * @param rs
	 * @param state
	 * @param conn
	 */
	public static void close(ResultSet rs,Statement state,Connection conn)
	{
		try {
			if(rs!=null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(state!=null)
				state.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(conn!=null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 释放资源
	 * @param rs
	 */
	public static void close(ResultSet rs)
	{
		Statement state=null;
		Connection conn=null;
		try {
			
			state=rs.getStatement();
			conn=state.getConnection();
			
			BaseDao.close(rs, state, conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
