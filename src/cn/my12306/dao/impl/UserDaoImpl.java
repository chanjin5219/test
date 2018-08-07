package cn.my12306.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import cn.my12306.bean.Province;
import cn.my12306.bean.User;
import cn.my12306.dao.BaseDao;
import cn.my12306.dao.UserDao;

/**
 * 用户访问数据库类
 * 只写操作users表的方法
 * @author lynn
 * 作用：提供访问数据库的增删改查方法
 * 
 *
 */
public class UserDaoImpl implements UserDao {
	
	public int add(User user) {
		String sql="insert INTO users(username,`password`,rule,realname,"
			 +"sex,cid,ctid,cert,birthday,utid,content,`status`,loginIp,imagePath) VALUES"
			 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] objs={user.getUsername(),user.getPassword(),user.getRule(),user.getRealname(),
				user.getSex(),user.getCity(),user.getCertType(),user.getCert(),user.getBirthday(),
				user.getUserType(),user.getContent(),user.getStatus(),user.getLoginIp(),user.getImagePath()};
		return BaseDao.executeUpdate(sql, objs);
	}

	public int update(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public User getUser(String username ,String pwd)
	{
		String sql=" SELECT id,username,rule,realname,sex,cid,ctid,cert, "
				+ " birthday,utid,content,`status`,loginIp,imagePath "
				+ " from  users where username=? and `password`=? and rule=0 and `status`=0";
		Object[] objs={username,pwd};
		User user=null;
		ResultSet rs=null;
		try {
			rs=BaseDao.executeQuery(sql, objs);
			while(rs.next())
			{

				user=new User(rs.getInt("id"), 
						rs.getString("username"), null, 
						rs.getInt("rule"), rs.getString("realname"), rs.getInt("sex"),
						rs.getInt("cid"), rs.getInt("ctid"),  rs.getString("cert"), 
						rs.getString("birthday"),rs.getInt("utid") ,
						rs.getString("content"), rs.getInt("status"), 
						rs.getString("loginIp"), rs.getString("imagePath"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			BaseDao.close(rs);
		}
		
		return user;
	}

	
	
	
}
